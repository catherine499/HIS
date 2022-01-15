package com.example.HIS.controller;

import com.alibaba.fastjson.JSON;
import com.example.HIS.DTO.ReturnMedicenDto;
import com.example.HIS.models.*;
import com.example.HIS.service.RefundService;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

@Controller
public class RefundController {
    @Autowired
    RefundService refundService;

    @RequestMapping("/getPayReturn")
    @ResponseBody//--->前端传递缴费单Id，退费  返回：缴费单号、缴费项目名称、项目数量、缴费金额
    public String showTmtReturn(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        response.setContentType("text/html; charset=utf-8");
        Map<String, String> parameter = new HashMap<>();
        HttpSession session = request.getSession();
        Object userSession = session.getAttribute("cashierInfo");//先查找session，获取患者信息
        Cashier cashier = (Cashier) userSession;

        int payId = Integer.parseInt(request.getParameter("payId"));
        //查询是否已有绑定的退费单（不可重复退费）
        RefundTable refundTable = refundService.selectPayRefundByPayId(payId);
        //查询缴费信息
        PayTable payTable = refundService.getPayTableByPayId(payId);
        Double money = payTable.getPayMoney();
        //缴费项目（检查单号或处方单号）
        String payItem = payTable.getPayItem();
        int payId1 = Integer.parseInt(payItem.replaceAll("[^0-9]", "")); //获得单号id
        String flag = payItem.replaceAll("[^a-zA-z]", ""); // 获得P or C
        if (flag.equals("P")) {//处方单
            //获取处方单信息：药品数量、药品名称
            //先获取处方单
            PrescriptionTable prescriptionTable = refundService.getPrescriptionTableById(payId1);
            //获取药品id和药品数量
            String medicineId = prescriptionTable.getMedicineId();
            int medicineNumber = prescriptionTable.getMedicineNumber();
            //查询药品名称
            String medicineName = refundService.getMedicineNameByMId(medicineId);
            parameter.put("name", medicineName);
            parameter.put("number", String.valueOf(medicineNumber));
        } else {//检查单
            //获取检查单
            CheckTable checkTable = refundService.getCheckTableById(payId1);

            //获取检查名称
            String checkName = checkTable.getCheckDescription();
            parameter.put("name", checkName);
            parameter.put("number", String.valueOf(1));
        }
        parameter.put("payWay", String.valueOf(payTable.getPayWay()));
        parameter.put("id", payItem);
        parameter.put("money", String.valueOf(money));
        parameter.put("payId", String.valueOf(payId));
        return JSON.toJSONString(parameter);
    }

    @RequestMapping("/refund")
    @ResponseBody//--->前端传递缴费单Id，退费  返回："ok"
    public String refund(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        response.setContentType("text/html; charset=utf-8");
        Map<String, String> parameter = new HashMap<>();
        HttpSession session = request.getSession();
        Object userSession = session.getAttribute("cashierInfo");//先查找session，获取患者信息
        Cashier cashier = (Cashier) userSession;
        int payId = Integer.parseInt(request.getParameter("payId"));
        //查询是否已有绑定的退费单（不可重复退费）
        RefundTable refundTable = refundService.selectPayRefundByPayId(payId);
        if (refundTable != null) {
            parameter.put("status", "fail1");
            parameter.put("msg", "退费失败！不可重复退费！！！");
            System.out.println("退费失败！不可重复退费！！！");
            return JSON.toJSONString(parameter);
        }

        //查询缴费信息
        PayTable payTable = refundService.getPayTableByPayId(payId);
        Date now = new Date();
        if (payTable.getPayTime().getTime() + 12 * 60 * 60 * 1000 < now.getTime()) {
            parameter.put("status", "fail2");
            parameter.put("msg", "退费失败！缴费已过12小时，不可退费！！！");
            System.out.println("退费失败！缴费已过12小时，不可退费！！！");
            return JSON.toJSONString(parameter);
        }
        Double money = payTable.getPayMoney();
        //缴费项目（检查单号或处方单号）
        String payItem = payTable.getPayItem();
        int payId1 = Integer.parseInt(payItem.replaceAll("[^0-9]", "")); //获得单号id
        String flag = payItem.replaceAll("[^a-zA-z]", ""); // 获得P or C
        if (flag.equals("C")) {//检查单
            //获取检查单
            CheckTable checkTable = refundService.getCheckTableById(payId1);
            //检查是否已完成，若已完成，不可退费
            if (checkTable.getIsChecked() == 1) {
                parameter.put("status", "fail3");
                parameter.put("msg", "退费失败！该检查项目已完成！！！");
                System.out.println("退费失败！该检查项目已完成！！！");
                return JSON.toJSONString(parameter);
            }
        }//新建退费单
        else if(flag.equals("")){
            parameter.put("status", "fail4");
            parameter.put("msg", "退费失败！挂号费不可退！！！");
            System.out.println("退费失败！挂号费不可退！！！！");
            return JSON.toJSONString(parameter);
        }
        RefundTable refundTable1=new RefundTable();
        refundTable1.setPatientIdentity(payTable.getPatientIdentity());
        refundTable1.setCashierId(cashier.getCashierId());
        refundTable1.setRefundMoney(money);
        refundTable1.setRefundWay(payTable.getPayWay());
        refundTable1.setPayId(payId1);
        refundTable1.setRefundTime(new Date());
        //存入数据库
        refundService.addRefundTable(refundTable1);
        parameter.put("status", "ok");
        parameter.put("msg", "已以原方式退费成功！");
        System.out.println("退费成功！");
        return JSON.toJSONString(parameter);
        }
    }


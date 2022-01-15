package com.example.HIS.controller;

import com.alibaba.fastjson.JSON;
import com.example.HIS.DTO.CheckTableDto;
import com.example.HIS.DTO.PrescriptionTableDto;
import com.example.HIS.models.*;
import com.example.HIS.service.*;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;


@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private LoginService loginService;
    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping("/pay_main") //员工登录到其界面上 ---》通过缴费单号查询--->返回单号、项目内容、数量、单价、总价、操作。。。
    public void payMain(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        response.setContentType("text/html; charset=utf-8");
        String paymentTableId = request.getParameter("itemId");
        String  payId= paymentTableId.replaceAll("[^0-9]", ""); //获得单号id
        String flag = paymentTableId.replaceAll("[^a-zA-z]", ""); // 获得P or C
//        System.out.println(""+paymentTableId+"  "+flag+"   "+payId);
        if (flag.equals("C")) { //如果是检查单
            CheckTableDto checkInfos = paymentService.findCheckTableDtoById(Integer.parseInt(payId));
            try {
                response.getWriter().print(new GsonBuilder().serializeNulls().create().toJson(checkInfos));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {//处方单
            PrescriptionTableDto preInfos = paymentService.findPrescriptionTableDtoById(Integer.parseInt(payId));//查找处方单
//            String medicineId = preInfos.getMedicineId();  // 获取药品编号ID
//            Medicine medicine = paymentService.getMedicineByMId(medicineId);//根据药品Id获取药品
            try {
                response.getWriter().print(new GsonBuilder().serializeNulls().create().toJson(preInfos));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/pay") //付钱--->前端传递：付款方式(0,1,2)、付款内容(”P11\C22“)、总金额---->付款内容可以有多个，逗号分隔
    @ResponseBody
    public String payApp(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Integer> checkMoneyList=new HashMap<>();
        checkMoneyList.put( "心电图", 30);
        checkMoneyList.put( "颅脑平扫",1000);
        checkMoneyList.put( "'胸部平扫'", 500);
        checkMoneyList.put( "'胸部正侧位片'",500);
        checkMoneyList.put( "'胸腰段正侧位'", 500);
        Map<String, String> parameter = new HashMap<>();
        response.setContentType("text/html; charset=utf-8");
        String patientId=request.getParameter("patientId");
        int payWay = Integer.parseInt(request.getParameter("payWay"));
        String[] payItems=request.getParameter("payItem").split(",");
        double payMoney=Float.valueOf(request.getParameter("payMoney"));//总金额
        HttpSession session = request.getSession();
        Object userSession = session.getAttribute("cashierInfo");//先查找session，获取患者信息
        Cashier cashier=(Cashier)  userSession;
        System.out.println("缴费：患者编号："+patientId+"  支付方式:"+payWay+"  支付内容： "+payItems.toString());
        for (int i=0;i<payItems.length;i++) {
            String  payId= payItems[i].replaceAll("[^0-9]", ""); //获得单号id
            String flag = payItems[i].replaceAll("[^a-zA-z]", ""); // 获得P or C
            System.out.println("flag:"+flag+"  payId:"+payId);

            PayTable payTable = new PayTable();
            if(flag.equals("P")){//处方单-->新增配药单
                //根据id查询处方单
                PrescriptionTable prescriptionTable =paymentService.findPrescriptionTableById(Integer.parseInt(payId));
                //获取药品信息
                String medicineId=prescriptionTable.getMedicineId();
                int medicineNumber=prescriptionTable.getMedicineNumber();
                //新增配药单
                TakeMedineTable takeMedineTable=new TakeMedineTable();
                takeMedineTable.setBillTime(new Date());
                takeMedineTable.setPatientIdentity(patientId);
                takeMedineTable.setTakeState(0);
                takeMedineTable.setPrescriptionId(Integer.parseInt(payId));
                paymentService.addTakeMedicineTable(takeMedineTable);
                //设置缴费金额
                //查询药品价格
                double medicineMoney=paymentService.getMedicineMoney(medicineId);
                payTable.setPayMoney(medicineMoney*medicineNumber);
            }
            else if (flag.equals("C")){//检查单-->更新检查单信息
                //获取检查单信息
                CheckTable checkTable=paymentService.findCheckTableById(Integer.parseInt(payId));
                //更新状态为已缴费
                checkTable.setIsPayed(1);
                //更新数据库
                paymentService.updateCheckTableState(checkTable);
                //设置缴费金额
                payTable.setPayMoney(Double.valueOf(checkMoneyList.get(checkTable.getCheckDescription())));
            }else {//挂号单-->只需要添加缴费单，查询挂号类型，设置缴费金额
                //获取挂号单信息
                System.out.println(Integer.parseInt(payId));
                RegisterTable registerTable=paymentService.getRegisterTableById(Integer.parseInt(payId));
                //获取挂号类型-->普通号5块，专家号30
                int registerType=registerTable.getRegisterType();
                if (registerType==0){//专家号
                    payTable.setPayMoney(30.0);
                }else{
                    payTable.setPayMoney(5.0);
                }
            }
            payTable.setPatientIdentity(patientId);
            payTable.setCashierId(cashier.getCashierId());
            payTable.setPayWay(payWay);
            payTable.setPayItem(flag+payId);
            payTable.setPayTime(new Date());
            //放数据库
            paymentService.addPayTable(payTable);
        }
        parameter.put("status", "ok");
        parameter.put("msg", "付款完成");
        return JSON.toJSONString(parameter);
    }
}





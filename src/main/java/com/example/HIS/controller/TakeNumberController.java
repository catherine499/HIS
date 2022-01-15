package com.example.HIS.controller;


import com.alibaba.fastjson.JSON;
import com.example.HIS.models.*;
import com.example.HIS.service.*;
import com.example.HIS.DTO.RemainDoctorDto;
import com.example.HIS.DTO.ReserveTableDto;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

//挂号
@Controller
public class TakeNumberController {

    @Autowired
    private TakeNumberService takeNumberServiceimpl;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private LoginService loginService;

    @ResponseBody
    @RequestMapping("/take_number_appoint")//返回患者当天的预约信息 -->通过患者身份证号查询，
    public void takeNumberAppoint(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html; charset=utf-8");
        String patientIdentity = request.getParameter("patientIdentity");
        List<ReserveTableDto>  reserveInfos=takeNumberServiceimpl.getReserveInfoByPIdToday(patientIdentity);
        try{
            response.getWriter().print(new GsonBuilder().serializeNulls().create().toJson(reserveInfos));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping("/take_number_appoint_submit")//返回取号结果 -->通过预约单编号操作，
    public String takeNumberAppointSubmit(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html; charset=utf-8");
        Map<String, String> parameter = new HashMap<>();
        int reserveId = Integer.parseInt(request.getParameter("reserveId"));
        System.out.println("预约取号，预约单编号："+reserveId);
        ReserveTable reserveTable=takeNumberServiceimpl.getReserveTableByPrimaryKey(reserveId);
        if(reserveTable.getReserveState()==-1){
            parameter.put("status", "fail");
            parameter.put("msg", "取号失败！预约单已取消！");
            System.out.println("取号失败！预约单已取消！");
            return JSON.toJSONString(parameter);
        }
        //查看预约时间
        long resverveTime=reserveTable.getReserveTime().getTime();
        //获取半小时前的时间
        long halHourAgo = resverveTime-30*60*1000;
        //获取一小时后的时间
        long anHourLater=resverveTime+60*60*1000;
        //获取当前时间
        long now=System.currentTimeMillis();
        //早到（当前时间小于半小时前的时间） -->挂号失败，询问是否取消
        if(now<halHourAgo){
            parameter.put("status", "fail");
            parameter.put("msg", "取号失败!当前时间早于预约时间前30分钟，是否取消预约？");
            System.out.println("取号失败！早到！");
            return JSON.toJSONString(parameter);
        }
        //迟到（当前时间大于一小时后的时间） -->标记取消，挂号失败，更新黑名单标记
        if(now>anHourLater){
            reserveTable.setReserveState(-1);
            appointmentService.updateReserveState(reserveTable);
            //添加违约记录
            ViolateTable violateTable=new ViolateTable();
            violateTable.setReserveId(reserveId);
            appointmentService.addViolateTable(violateTable);
            Patient patient=loginService.selectPatient(reserveTable.getPatientIdentity());
            //查询是否更新黑名单状态
            if (appointmentService.getBlackFlag(patient)==1){
                parameter.put("status", "ok");
                parameter.put("msg", "您近期违约记录较多，现已加入黑名单。");
                System.out.println("取消成功！加入黑名单");
                return JSON.toJSONString(parameter);
            }
            parameter.put("status", "fail1");
            parameter.put("msg", "取号失败！预约时间已过，预约已取消。只能取现场号！");
            System.out.println("取号失败!迟到！");
            return JSON.toJSONString(parameter);
        }
        //没有迟到或早到
        RegisterTable registerTable=new RegisterTable();
        String doctorId=reserveTable.getDoctorId();
        registerTable.setDepartmentId(reserveTable.getDepartmentId());
        registerTable.setDoctorId(reserveTable.getDoctorId());
        registerTable.setPatientIdentity(reserveTable.getPatientIdentity());
        registerTable.setRegisterQueueType(1);//预约号
        if (doctorId.equals("D0000001")){//科室号
            registerTable.setRegisterType(1);
            //排队号码
            registerTable.setRegisterNumber(getDeptNumber(reserveTable.getDepartmentId()));
        }//if
        else{ //专家号
            registerTable.setRegisterType(0);
            //排队号码
            System.out.println(reserveTable.getDoctorId());
            int number=getDoctorNumber(reserveTable.getDoctorId());
            registerTable.setRegisterNumber(number);
        }
        //获取当前时间
        registerTable.setRegisterTime(new Date());
        //更新预约单状态
        reserveTable.setReserveState(1);
        takeNumberServiceimpl.updateReserveState(reserveTable);
        //挂号单存入数据库
        int ret=takeNumberServiceimpl.addRegisterTable(registerTable);
        if (ret<1){ //挂号单插入失败
            parameter.put("status", "fail2");
            parameter.put("msg", "取号失败！插入挂号单失败！");
            System.out.println("取号失败");
            return JSON.toJSONString(parameter);
        }
        //挂号单加入队列
        if (doctorId.equals("D0000001")){//科室号
            DeptQueue deptQueue=new DeptQueue();
            deptQueue.setDepartmentId(reserveTable.getDepartmentId());
            deptQueue.setRegisterId(registerTable.getRegisterId());
            deptQueue.setRegisterNumber(registerTable.getRegisterNumber());
            deptQueue.setDeptQueueDate(new Date());
            deptQueue.setState(0);
            takeNumberServiceimpl.addDeptqueue(deptQueue);
        }//if
        else{ //专家号
            DoctorQueue doctorQueue=new DoctorQueue();
            doctorQueue.setDoctorId(doctorId);
            doctorQueue.setRegisterId(registerTable.getRegisterNumber());
            doctorQueue.setRegisterNumber(registerTable.getRegisterNumber());
            doctorQueue.setState(0);
            doctorQueue.setDoctorQueueDate(new Date());
            takeNumberServiceimpl.addDoctorqueue(doctorQueue);
        }
        parameter.put("status", "ok");
        parameter.put("msg", String.valueOf(registerTable.getRegisterId()));
        System.out.println("取号成功");
        return JSON.toJSONString(parameter);
    }

    @ResponseBody
    @RequestMapping("/take_number_dept")//返回今天所有科室号情况-->科室号：科室、已预约人数
    public void takeNumberDept(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html; charset=utf-8");
        List<RemainDeptNumber> remainDeptNumberList=takeNumberServiceimpl.getRemainDeptNumberToday();
        for (int i=0;i<remainDeptNumberList.size();i++){
            int num= remainDeptNumberList.get(i).getNumber();
            remainDeptNumberList.get(i).setNumber(20-num);
        }
        try{
            response.getWriter().print(new GsonBuilder().serializeNulls().create().toJson(remainDeptNumberList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 专家号：科室、专家姓名、剩余号数(当前时间所属时间段，比如现在16：26，就是数据库今天16:00的那个名额)、操作（挂号）
    @ResponseBody
    @RequestMapping("/take_number_doctor")
    public void takeNumberDoctor(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html; charset=utf-8");
        List<RemainDoctorDto> doctorRemains=takeNumberServiceimpl.getDoctorRmainToday();
        try{
            response.getWriter().print(new GsonBuilder().serializeNulls().create().toJson(doctorRemains));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping("/take_number_dept_submit")//返回现场取科室号结果 -->前端传递departmentId,patientIdentity,
    public String takeNumberDeptSubmit(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html; charset=utf-8");
        Map<String, String> parameter = new HashMap<>();
        String departmentId =request.getParameter("departmentId");
        String patientIdentity =request.getParameter("patientIdentity");
        System.out.println("取现场科室号："+departmentId+"患者身份证："+patientIdentity);
        RegisterTable registerTable=new RegisterTable();
        registerTable.setDepartmentId(departmentId);
        registerTable.setDoctorId("D0000001");
        registerTable.setPatientIdentity(patientIdentity);
        registerTable.setRegisterQueueType(0);//现场号
        registerTable.setRegisterType(1);//科室号
        //排队号码
        registerTable.setRegisterNumber(getDeptNumber(departmentId));
        //获取当前时间
        registerTable.setRegisterTime(new Date());
        //挂号单存入数据库
        int ret=takeNumberServiceimpl.addRegisterTable(registerTable);
//        System.out.println("呜呜呜"+ret+"       "+registerTable.getRegisterId());
        if (registerTable.getRegisterId()<1){ //挂号单插入失败
            parameter.put("status", "fail");
            System.out.println("挂号失败");
            return JSON.toJSONString(parameter);
        }
        //挂号单加入队列
        DeptQueue deptQueue=new DeptQueue();
        deptQueue.setDepartmentId(departmentId);
        deptQueue.setRegisterId(registerTable.getRegisterId());
        deptQueue.setRegisterNumber(registerTable.getRegisterNumber());
        deptQueue.setDeptQueueDate(new Date());
        deptQueue.setState(0);
        takeNumberServiceimpl.addDeptqueue(deptQueue);

        parameter.put("status", "ok");
        System.out.println("挂号成功");
        parameter.put("msg",String.valueOf(registerTable.getRegisterId()));
        return JSON.toJSONString(parameter);
    }

    @ResponseBody
    @RequestMapping("/take_number_doctor_submit")//返回现场取专家号结果 -->前端传递departmentId,patientIdentity,doctorId
    public String takeNumberDoctorSubmit( HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html; charset=utf-8");
        Map<String, String> parameter = new HashMap<>();
        String departmentId =request.getParameter("departmentId");
        String patientIdentity =request.getParameter("patientIdentity");
        String doctorId =request.getParameter("doctorId");
        System.out.println("取现场专家号："+departmentId+"患者身份证："+patientIdentity+"医生工号："+doctorId);
        RegisterTable registerTable=new RegisterTable();
        registerTable.setDepartmentId(departmentId);
        registerTable.setDoctorId(doctorId);
        registerTable.setPatientIdentity(patientIdentity);
        registerTable.setRegisterQueueType(0);//现场号
        registerTable.setRegisterType(0);//专家号
        registerTable.setRegisterNumber(getDoctorNumber(doctorId));//获取号码
        //获取当前时间
        Date today=new Date();
        //修改剩余名额
        List<RemainDoctorNumber> remainDoctorNumbers=takeNumberServiceimpl.getRemainDcotorNumberByTimeAndDoctorId(doctorId);
        RemainDoctorNumber remainDoctorNumber=remainDoctorNumbers.get(0);
        System.out.println("挂专家号，减少名额："+remainDoctorNumber.getRemainDoctorNumberId()+"  "+remainDoctorNumber.getNumber());
        int number=remainDoctorNumber.getNumber();
        remainDoctorNumber.setNumber(number-1);
        takeNumberServiceimpl.updateRemainDcotorNumber(remainDoctorNumber);
        registerTable.setRegisterTime(today);
        //挂号单存入数据库
        int ret=takeNumberServiceimpl.addRegisterTable(registerTable);
        if (registerTable.getRegisterId()<1){ //挂号单插入失败
            parameter.put("status", "fail");
            System.out.println("挂号失败");
            return JSON.toJSONString(parameter);
        }
        //添加到就诊队列
        DoctorQueue doctorQueue=new DoctorQueue();
        doctorQueue.setDoctorId(doctorId);
        doctorQueue.setRegisterId(registerTable.getRegisterId());
        doctorQueue.setRegisterNumber(registerTable.getRegisterNumber());
        doctorQueue.setState(0);
        doctorQueue.setDoctorQueueDate(new Date());
        takeNumberServiceimpl.addDoctorqueue(doctorQueue);
        parameter.put("status", "ok");
        parameter.put("msg",String.valueOf(registerTable.getRegisterId()));
        System.out.println("挂号成功");
        return JSON.toJSONString(parameter);
    }

    //获取当天的科室号编号
    public int getDeptNumber(String departmentId){
        //查询当天的队列情况，得到当天这个科室队列中的最大号码
        int number=takeNumberServiceimpl.getMaxDeptNumberByDeptId(departmentId);
        return number+1;
    }

    //获取当天的专家号编号
    public int getDoctorNumber(String doctorId){
        //查询当天的队列情况，得到当天这个专家队列中的最大号码
//        if(takeNumberServiceimpl.getMaxDoctorNumberByDoctorId(doctorId)==null){
//            return 1;
//        }
        int number=takeNumberServiceimpl.getMaxDoctorNumberByDoctorId(doctorId);
        return number+1;
    }

}

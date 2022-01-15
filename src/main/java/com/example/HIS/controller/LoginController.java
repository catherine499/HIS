package com.example.HIS.controller;

import com.alibaba.fastjson.JSON;
import com.example.HIS.models.Cashier;
import com.example.HIS.models.Doctor;
import com.example.HIS.models.Patient;
import com.example.HIS.models.Pharmacist;
import com.example.HIS.service.LoginService;
import com.example.HIS.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public String userLogin(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> parameter = new HashMap<>();
        String patientIdentity = request.getParameter("patientIdentity");
        String password = request.getParameter("password");
        Patient patient = loginService.selectPatient(patientIdentity);
        System.out.println("登录密码:"+password);
        if (null==patient){
            parameter.put("status", "null");
            parameter.put("msg","用户登录失败,无此用户");
            System.out.println("用户登录失败,无此用户");
            return JSON.toJSONString(parameter);
        }
        else if(!Objects.equals(patient.getPatientPassword(), password)) {
            System.out.println("密码:"+patient.getPatientPassword());
            parameter.put("status", "fail");
            parameter.put("msg","用户登录失败,密码错误");
            System.out.println("用户登录失败,密码错误");
            return JSON.toJSONString(parameter);
        }
        else{
            request.getSession().setAttribute("patientInfo", patient);
//            Cookie patientCookie = new Cookie("patientID",patient.getPatientIdentity());//服务器创建cookie,存储内容为用户名
//            patientCookie.setPath("/");
//            patientCookie.setMaxAge(60*60);
//            response.addCookie(patientCookie);
            parameter.put("status", "ok");
            parameter.put("msg","用户登录成功");
            parameter.put("data",patient.getPatientIdentity());
            System.out.println("用户登录成功");
            return JSON.toJSONString(parameter);
        }
    }
    @RequestMapping("/staff_login")
    @ResponseBody
    public String staffLogin(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> parameter = new HashMap<>();
        String staffId = request.getParameter("staffId");
        String password = request.getParameter("password");
        System.out.println("staff_login"+staffId+"    "+password);

        //判断员工类型
        if (staffId.startsWith("P")){//P开头：收费人员
            Cashier cashier = loginService.selectCashier(staffId);
            System.out.println("登录密码:"+password);
            if (null==cashier){
                parameter.put("status", "null");
                parameter.put("msg","用户登录失败,无此用户");
                System.out.println("用户登录失败,无此用户");
            }
            else if(!Objects.equals(cashier.getCashierPassword(), password)) {
                System.out.println("密码:"+cashier.getCashierPassword());
                parameter.put("status", "fail");
                parameter.put("msg","用户登录失败,密码错误");
                System.out.println("用户登录失败,密码错误");
            }
            else{
                request.getSession().setAttribute("cashierInfo", cashier);
                parameter.put("status", "ok1");
                parameter.put("msg","用户登录成功");
                parameter.put("data",cashier.getCashierId());
                System.out.println("用户登录成功");
            }
        }//if (staffId.startsWith("P"))
        else if (staffId.startsWith("D")) {//D开头：医生
            Doctor doctor = loginService.selectDoctor(staffId);
            System.out.println("登录密码:"+password);
            if (null==doctor){
                parameter.put("status", "null");
                parameter.put("msg","用户登录失败,无此用户");
                System.out.println("用户登录失败,无此用户");
            }
            else if(!Objects.equals(doctor.getDoctorPassword(), password)) {
                System.out.println("密码:"+doctor.getDoctorPassword());
                parameter.put("status", "fail");
                parameter.put("msg","用户登录失败,密码错误");
                System.out.println("用户登录失败,密码错误");
            }
            else{
                request.getSession().setAttribute("doctorInfo", doctor);
                parameter.put("status", "ok2");
                parameter.put("msg","用户登录成功");
                parameter.put("data",doctor.getDoctorId());
                System.out.println("用户登录成功");
            }
        }//else if (staffId.startsWith("D"))
        else if (staffId.startsWith("M")) {//M开头：药剂师
            Pharmacist pharmacist = loginService.selectPharmacist(staffId);
            System.out.println("登录密码:"+password);
            if (null==pharmacist){
                parameter.put("status", "null");
                parameter.put("msg","用户登录失败,无此用户");
                System.out.println("用户登录失败,无此用户");
            }
            else if(!Objects.equals(pharmacist.getPharmacistPassword(), password)) {
                System.out.println("密码:"+pharmacist.getPharmacistPassword());
                parameter.put("status", "fail");
                parameter.put("msg","用户登录失败,密码错误");
                System.out.println("用户登录失败,密码错误");
            }
            else{
                request.getSession().setAttribute("pharmacistInfo", pharmacist);
                parameter.put("status", "ok3");
                parameter.put("msg","用户登录成功");
                parameter.put("data",pharmacist.getPharmacistId());
                System.out.println("用户登录成功");
            }
        }//else if (staffId.startsWith("M"))
        else{
            parameter.put("status", "fail");
            parameter.put("msg","用户登录失败，请检查工号是否正确");
            System.out.println("用户登录失败，请检查工号是否正确");
        }//else
        return JSON.toJSONString(parameter);
    }
}

package com.example.HIS.controller;

import com.alibaba.fastjson.JSON;
import com.example.HIS.service.RegisterService;
import com.example.HIS.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @RequestMapping("/register")
    @ResponseBody
    public  String userRegister(HttpServletRequest request, HttpSession session){
        Map<String, String> parameter = new HashMap<>();
        String patientIdentity = request.getParameter("patientIdentity");
        String password1 = request.getParameter("password1");
        String patientName = request.getParameter("patientName");
        String gender=request.getParameter("patientGender");
        int patientGender = 0;
        if(gender.equals("男")){
            patientGender=1;
        }
        String patientAddress = request.getParameter("patientAddress");
        String patientTel = request.getParameter("patientTel");

        Patient patient = registerService.selectPatient(patientIdentity);
        if (null==patient){
            Patient patient1 = new Patient(patientIdentity,password1);
            patient1.setPatientName(patientName);
            patient1.setPatientAddress(patientAddress);
            patient1.setPatientGender(patientGender);
            patient1.setPatientIsBlack(0);
            patient1.setPatientTel(patientTel);
            registerService.addPatient(patient1);
            session.setAttribute("patientInfo", patient1);
            parameter.put("status", "ok");
            System.out.println("用户注册成功");
            return JSON.toJSONString(parameter);
        }
        else {
            parameter.put("status", "no");
            System.out.println("用户存在,注册失败");
            return JSON.toJSONString(parameter);
        }
    }
}

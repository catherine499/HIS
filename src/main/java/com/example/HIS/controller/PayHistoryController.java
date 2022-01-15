package com.example.HIS.controller;


import com.example.HIS.service.PayHistoryService;
import com.example.HIS.DTO.PayHistoryDto;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//查看缴费单记录
@Controller
public class PayHistoryController {
    @Autowired
    private PayHistoryService payHistoryService;

    //点击查看缴费单记录
    @RequestMapping("/pay_history")
    @ResponseBody
    public void payHistory(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html; charset=utf-8");
        String patientIdentity = request.getParameter("patientIdentity");
        List<PayHistoryDto> payHistoryInfoList=payHistoryService.getPayHistoryByPatientId(patientIdentity);
        try{
            response.getWriter().print(new GsonBuilder().serializeNulls().create().toJson(payHistoryInfoList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

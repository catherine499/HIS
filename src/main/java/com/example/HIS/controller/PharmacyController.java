package com.example.HIS.controller;

import com.alibaba.fastjson.JSON;
import com.example.HIS.DTO.ReturnMedicenDto;
import com.example.HIS.DTO.TakeMedicineDto;
import com.example.HIS.models.*;
import com.example.HIS.service.DoctorService;
import com.example.HIS.service.DoctorServiceImpl;
import com.example.HIS.service.LoginService;
import com.example.HIS.service.PharmacyService;
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
public class PharmacyController {
    @Autowired
    PharmacyService pharmacyService;

    @Autowired
    LoginService loginService;

    @Autowired
    DoctorService doctorService;


    @RequestMapping("/getAllTmt")
    @ResponseBody
    public void allTakeMedineTable(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        response.setContentType("text/html; charset=utf-8");
        List<TakeMedineTable> takeMedineList = pharmacyService.selectAllTakeMedineTable();
//        HashSet<Integer> tidSet = new HashSet<>();
//        for (int i = 0; i < takeMedineList.size(); i++) {
//            tidSet.add(takeMedineList.get(i).getTakeId());
//        }
        try{
            String jsonString=new GsonBuilder().serializeNulls().create().toJson(takeMedineList);
            System.out.println("查询所有取药单信息："+jsonString);
            response.getWriter().print(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/getSelectedTmt")
    @ResponseBody//medicint name medicine number
    public void selectedTakeMedineTable(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        response.setContentType("text/html; charset=utf-8");
        int takeMedicineTableId = Integer.parseInt(request.getParameter("takeMedicineTableId"));
        List<TakeMedineTable> takeMedineList = pharmacyService.selectTakeMedicineTable(takeMedicineTableId);
        List<Medicine> medicineList = new ArrayList<>();
        for (int i = 0; i < takeMedineList.size() ; i++) {
            PrescriptionTable prescriptionTable = pharmacyService.selectPrescription(takeMedineList.get(i).getPrescriptionId());
            String medicineId = prescriptionTable.getMedicineId();
            Medicine medicine = pharmacyService.getMedicine(medicineId);
            medicine.setMedicineNumber(prescriptionTable.getMedicineNumber());
            medicineList.add(medicine);
        }
        try{
            response.getWriter().print(new GsonBuilder().serializeNulls().create().toJson(medicineList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/makeMedicine")
    @ResponseBody//medicint name medicine number
    public String makeMedicine(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        response.setContentType("text/html; charset=utf-8");
        Map<String, String> parameter = new HashMap<>();
        HttpSession session = request.getSession();
        Object userSession = session.getAttribute("pharmacistInfo");
        Pharmacist pharmacist=(Pharmacist)  userSession;
        String pharmacistId=pharmacist.getPharmacistId();
        int sta = Integer.parseInt(request.getParameter("sta"));
        int tid = Integer.
                parseInt(request.getParameter("tid"));
        if(sta==0){
            TakeMedineTable takeMedicineTable = new TakeMedineTable();
            List<TakeMedineTable> takeMedineTableNow = pharmacyService.selectTakeMedicineTable(tid);
            for (int i = 0; i < takeMedineTableNow.size(); i++) {
                takeMedicineTable=takeMedineTableNow.get(i);
                takeMedicineTable.setTakeState(1);
                takeMedicineTable.setPatientIdentity(pharmacistId);
                pharmacyService.updateTakeMedicine(takeMedicineTable);
            }
            parameter.put("status","ok");
            parameter.put("msg","配药开始");
            return JSON.toJSONString(parameter);
        }
        else if(sta==1){
            TakeMedineTable takeMedineTable = new TakeMedineTable();
            List<TakeMedineTable> takeMedineTableNow = pharmacyService.selectTakeMedicineTable(tid);
            for (int i = 0; i < takeMedineTableNow.size(); i++) {
                takeMedineTable=takeMedineTableNow.get(i);
                takeMedineTable.setTakeState(2);
                pharmacyService.updateTakeMedicine(takeMedineTable);
                PrescriptionTable prescriptionTable = pharmacyService.selectPrescription(takeMedineTableNow.get(i).getPrescriptionId());
                String medicineId = prescriptionTable.getMedicineId();
                Medicine medicine = pharmacyService.getMedicine(medicineId);

                int left = medicine.getMedicineNumber()-prescriptionTable.getMedicineNumber();
                if (left>=0){
                    medicine.setMedicineNumber(left);
                    pharmacyService.updateMedicine(medicine);
                }
                else{
                    parameter.put("status","fail");
                    parameter.put("msg",medicine.getMedicineName()+"配药失败，余量不足");
                    return JSON.toJSONString(parameter);
                }
            }
            parameter.put("status","ok");
            parameter.put("msg","配药完成");
            return JSON.toJSONString(parameter);
        }
        else{
            TakeMedineTable takeMedicineTable = new TakeMedineTable();
            List<TakeMedineTable> takeMedineTableNow = pharmacyService.selectTakeMedicineTable(tid);
            for (int i = 0; i < takeMedineTableNow.size(); i++) {
                takeMedicineTable=takeMedineTableNow.get(i);
                takeMedicineTable.setTakeState(3);
                takeMedicineTable.setTakeTime(Calendar.getInstance().getTime());
                takeMedicineTable.setPharmacistId(pharmacist.getPharmacistId());
                pharmacyService.updateTakeMedicine(takeMedicineTable);
            }
            parameter.put("status","ok");
            parameter.put("msg","取药完成");
            return JSON.toJSONString(parameter);
        }
    }
    @RequestMapping("/getTmt")
    @ResponseBody//medicint name medicine number
    public void showTmt(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        response.setContentType("text/html; charset=utf-8");
        List<TakeMedineTable> takeMedineList = pharmacyService.selectAllTakeMedineTable();
        HashSet<Integer> tidSet = new HashSet<>();
        List<TakeMedicineDto> takeMedicineDtos = new ArrayList<>();
        for (int i = 0; i < takeMedineList.size(); i++) {
            if(tidSet.contains(takeMedineList.get(i).getTakeId()))continue;
            tidSet.add(takeMedineList.get(i).getTakeId());
            TakeMedicineDto takeMedicineDto = new TakeMedicineDto();
            takeMedicineDto.setTakeId(takeMedineList.get(i).getTakeId());
            takeMedicineDto.setPatientIdentity(takeMedineList.get(i).getPatientIdentity());
            takeMedicineDto.setPatientName(loginService.selectPatient(takeMedineList.get(i).getPatientIdentity()).getPatientName());
            takeMedicineDto.setMainDoc(doctorService.findById(pharmacyService.selectPrescription(takeMedineList.get(i).getPrescriptionId()).getDoctorId()).getDoctorName());
            if(takeMedineList.get(i).getPharmacistId()==null){
                takeMedicineDto.setPharDoc("暂无");
            }
            else{
                takeMedicineDto.setPharDoc(pharmacyService.selectPharmacistName(takeMedineList.get(i).getPharmacistId()));
            }
            takeMedicineDto.setTakeTime(takeMedineList.get(i).getTakeTime());
            takeMedicineDto.setBillTime(takeMedineList.get(i).getBillTime());
            int sta = takeMedineList.get(i).getTakeState();
            if(sta==0){
                takeMedicineDto.setTakeState("待配药");
            }else if(sta==1){
                takeMedicineDto.setTakeState("配药中");
            }else if(sta==2){
                takeMedicineDto.setTakeState("待取药");
            }else if(sta==3){
                takeMedicineDto.setTakeState("已取药");
            }else if(sta==4){
                takeMedicineDto.setTakeState("已退药");
            }

            takeMedicineDtos.add(takeMedicineDto);
        }
        try{
            response.getWriter().print(new GsonBuilder().serializeNulls().create().toJson(takeMedicineDtos));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/getTmtReturn")
    @ResponseBody//medicint name medicine number
    public void showTmtReturn(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        response.setContentType("text/html; charset=utf-8");
        int id = Integer.parseInt(request.getParameter("takeId"));
        List<TakeMedineTable> takeMedineList = pharmacyService.selectTakeMedicineTable(id);
        List<ReturnMedicenDto> returnMedicenDtos = new ArrayList<>();
        for (int i = 0; i < takeMedineList.size(); i++) {
            ReturnMedicenDto returnMedicenDto = new ReturnMedicenDto();
            returnMedicenDto.setPrescriptionId(takeMedineList.get(i).getPrescriptionId());
            returnMedicenDto.setTakeState(takeMedineList.get(i).getTakeState());
            String medicineId = pharmacyService.selectPrescription(takeMedineList.get(i).getPrescriptionId()).getMedicineId();
            returnMedicenDto.setMedicineId(medicineId);
            returnMedicenDto.setMedicineName(pharmacyService.getMedicine(medicineId).getMedicineName());
            returnMedicenDto.setMedicineMoney(pharmacyService.getMedicine(medicineId).getMedicineMoney());
            returnMedicenDto.setMedicineNumber(pharmacyService.selectPrescription(takeMedineList.get(i).getPrescriptionId()).getMedicineNumber());
            returnMedicenDtos.add(returnMedicenDto);
        }
        try{
            response.getWriter().print(new GsonBuilder().serializeNulls().create().toJson(returnMedicenDtos));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/ReturnMedicine")
    @ResponseBody//{'prescriptionId':'id1,id2,id3'}
    public String ReturnMedicine(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        Map<String, String> parameter = new HashMap<>();
        response.setContentType("text/html; charset=utf-8");
        String takeId = request.getParameter("takeId");
        List<String> presciptions = List.of(request.getParameter("prescriptionId").split(","));
        System.out.println(takeId);
        System.out.println(presciptions.toString());
        List<TakeMedineTable> takeMedineTableNow = pharmacyService.selectTakeMedicineTable(Integer.parseInt(takeId));
        for (int i = 0; i < takeMedineTableNow.size(); i++) {
            TakeMedineTable takeMedineTable=takeMedineTableNow.get(i);
            if(!presciptions.contains(String.valueOf(takeMedineTable.getPrescriptionId()))){
                System.out.println("fffff"+takeMedineTable.getPrescriptionId());
                continue;
            }
            takeMedineTable.setTakeState(4);
            pharmacyService.updateTakeMedicine(takeMedineTable);
            int precriptionid = takeMedineTableNow.get(i).getPrescriptionId();
            PrescriptionTable prescriptionTable = pharmacyService.selectPrescription(precriptionid);
            String medicineId = prescriptionTable.getMedicineId();
            Medicine medicine = pharmacyService.getMedicine(medicineId);
            int tot= medicine.getMedicineNumber()+prescriptionTable.getMedicineNumber();
            medicine.setMedicineNumber(tot);
            pharmacyService.updateMedicine(medicine);

            ReturnMedicineTable returnMedicineTable = new ReturnMedicineTable();
            returnMedicineTable.setMedicineId(medicineId);
            returnMedicineTable.setPatientIdentity(takeMedineTable.getPatientIdentity());
            returnMedicineTable.setPharmacistId(takeMedineTable.getPharmacistId());
            returnMedicineTable.setPrescriptionId(precriptionid);
            returnMedicineTable.setReturnNumber(prescriptionTable.getMedicineNumber());
            returnMedicineTable.setReturnTime(Calendar.getInstance().getTime());

            pharmacyService.insertReturnTable(returnMedicineTable);
            parameter.put("status","ok");
            parameter.put("msg","退药完成");

        }
        return JSON.toJSONString(parameter);
    }


}

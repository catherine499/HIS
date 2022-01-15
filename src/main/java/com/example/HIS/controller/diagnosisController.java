package com.example.HIS.controller;


import com.alibaba.fastjson.JSON;
import com.example.HIS.DTO.RecordHistoryDto;
import com.example.HIS.models.*;
import com.example.HIS.service.*;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//医生叫号及诊断
@Controller
@RequestMapping("/doctor-main")
public class diagnosisController {
    @Autowired
    RecordService recordService;

    @Autowired
    RegisterService registerService;

    @Autowired
    PatientService patientService;

    @Autowired
    CheckService checkService;

    @Autowired
    medicineService medicineService;

    @Autowired
    PrescriptionService prescriptionService;

    @Autowired
    DoctorService doctorService;
    @Autowired
    TakeNumberService takeNumberService;

    @RequestMapping("")
    @ResponseBody
    public String getFirstPatient(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html; charset=utf-8");

        Map<String, String> parameter = new HashMap<>();
        //获取下一个预约单号===========
        HttpSession session = request.getSession();
        Object userSession = session.getAttribute("doctorInfo");//查找session，获取医生信息
        Doctor doctor=(Doctor)  userSession;
        String doctorId=doctor.getDoctorId();
        System.out.println("医生姓名："+doctor.getDoctorName());
        //获取专家号等待队列-->这个医生id，未完成，今天,按时间升序排列
        //预约号
        List<DoctorQueue> reserveDoctorQueues=takeNumberService.getReserveDoctorQueueByDoctorId(doctorId);
        //现场号
        List<DoctorQueue> siteDoctorQueues=takeNumberService.getSiteDoctorQueueByDoctorId(doctorId);
        //获取科室号等待队列 -->这个科室，今天，未完成,按时间升序排列
        String deptId=doctor.getDepartmentId();
        //预约号
        List<DeptQueue> reserveDeptQueues=takeNumberService.getReserveDeptQueueByDeptId(deptId);
        //现场号
        List<DeptQueue> siteDeptQueues=takeNumberService.getSiteDeptQueueByDeptId(deptId);
        int newRegisterId = 0;
        //看预约的专家号
        if (reserveDoctorQueues.size()!=0){
            newRegisterId=reserveDoctorQueues.get(0).getRegisterId();
        }
        else{
            //看现场的专家号
            System.out.println("没有预约的专家号");
            if(siteDoctorQueues.size()!=0){
                newRegisterId=siteDoctorQueues.get(0).getRegisterId();
            }
            else{
                //看预约的科室号
                System.out.println("没有现场的专家号");
                if(reserveDeptQueues.size()!=0){
                    newRegisterId=reserveDeptQueues.get(0).getRegisterId();
                }
                else{
                    //看现场的科室号
                    System.out.println("没有预约的科室号");
                    if(siteDeptQueues.size()!=0){
                        System.out.println(siteDeptQueues);
                        newRegisterId=siteDeptQueues.get(0).getRegisterId();
                    }
                    else{
                        System.out.println("没有现场的科室号---------没有患者");
                        //所有队列中没有等待的患者
                        parameter.put("status","fail");
                        parameter.put("msg","当前无正在等待的患者");
                        return JSON.toJSONString(parameter);
                    }
                }
            }
        }
        RegisterTable newregisterTable = registerService.findById(newRegisterId);
        String patientId = newregisterTable.getPatientIdentity();
        Patient patient = patientService.selectPatient(patientId);
        parameter.put("status","ok");
        parameter.put("msg","成功获取到下一个患者信息");
        parameter.put("patientId",patientId);
        parameter.put("patientName",patient.getPatientName());
        parameter.put("registerNumber",String.valueOf(newregisterTable.getRegisterNumber()));
        parameter.put("patientGender",String.valueOf(patient.getPatientGender()));
        parameter.put("register_id",newregisterTable.getRegisterId().toString());
        return JSON.toJSONString(parameter);
    }


    //诊断完成并获取下一个病人的挂号单号，返回下一个病人的挂号信息。-->前端获取当前病人的registerId
    @RequestMapping("/next")
    @ResponseBody
    public String PatientInfo(HttpServletResponse response,HttpServletRequest request) {
        response.setContentType("text/html; charset=utf-8");

        Map<String, String> parameter = new HashMap<>();
        //获取已完成的挂号单号
        Integer registerId = Integer.valueOf(request.getParameter("registerId"));
        System.out.println("诊断完成！"+registerId);
        //获取挂号单信息
        RegisterTable registerTable=takeNumberService.getRegisterTableById(registerId);
        //根据挂号单号查询相应的队列,将状态更新为已完成诊断
        if (registerTable.getRegisterType()==1){ //科室号
            //根据挂号单号查找
            DeptQueue deptQueue=takeNumberService.getDeptQueueByRegisterId(registerId);
            deptQueue.setState(1);
            takeNumberService.updateDeptQueue(deptQueue);
        }else{//专家号
            //根据挂号单号查找
            DoctorQueue doctorQueue=takeNumberService.getDoctorQueueByRegisterId(registerId);
            doctorQueue.setState(1);
            takeNumberService.updateDoctorQueue(doctorQueue);
        }
        //获取下一个预约单号===========
        HttpSession session = request.getSession();
        Object userSession = session.getAttribute("doctorInfo");//查找session，获取医生信息
        Doctor doctor=(Doctor)  userSession;
        String doctorId=doctor.getDoctorId();
        //获取专家号等待队列-->这个医生id，未完成，今天,按时间升序排列
        //预约号
        List<DoctorQueue> reserveDoctorQueues=takeNumberService.getReserveDoctorQueueByDoctorId(doctorId);
        //现场号
        List<DoctorQueue> siteDoctorQueues=takeNumberService.getSiteDoctorQueueByDoctorId(doctorId);
        //获取科室号等待队列 -->这个科室，今天，未完成,按时间升序排列
        String deptId=doctor.getDepartmentId();
        //预约号
        List<DeptQueue> reserveDeptQueues=takeNumberService.getReserveDeptQueueByDeptId(deptId);
        //现场号
        List<DeptQueue> siteDeptQueues=takeNumberService.getSiteDeptQueueByDeptId(deptId);
        int newRegisterId = 0;
        //看预约的专家号
        if (reserveDoctorQueues.size()!=0){
            newRegisterId=reserveDoctorQueues.get(0).getRegisterId();
        }
        else{
            //看现场的专家号
            if(siteDoctorQueues.size()!=0){
                newRegisterId=siteDoctorQueues.get(0).getRegisterId();
            }
            else{
                //看预约的科室号
                if(reserveDeptQueues.size()!=0){
                    newRegisterId=reserveDeptQueues.get(0).getRegisterId();
                }
                else{
                    //看现场的科室号
                    if(siteDeptQueues.size()!=0){
                        newRegisterId=siteDeptQueues.get(0).getRegisterId();
                    }
                    else{
                        //所有队列中没有等待的患者
                        parameter.put("status","fail");
                        parameter.put("msg","当前无正在等待的患者");
                        return JSON.toJSONString(parameter);
                    }
                }
            }
        }
        RegisterTable newregisterTable = registerService.findById(newRegisterId);
        String patientId = newregisterTable.getPatientIdentity();
        Patient patient = patientService.selectPatient(patientId);
        parameter.put("status","ok");
        parameter.put("msg","成功获取到下一个患者信息");
        parameter.put("patientId",patientId);
        parameter.put("patientName",patient.getPatientName());
        parameter.put("registerNumber",String.valueOf(newregisterTable.getRegisterNumber()));
        parameter.put("patientGender",String.valueOf(patient.getPatientGender()));
        return JSON.toJSONString(parameter);
    }


    //填写病历
    @ResponseBody
    @RequestMapping("/record")
    public String recordCreate(HttpServletResponse response, HttpServletRequest request){
        response.setContentType("text/html; charset=utf-8");

        Map<String,String> parameter = new HashMap<>();

        Integer maxId = recordService.getMaxId();
        Integer recordId = maxId+1;
        Record record=new Record();
        record.setRecordId(recordId);
        HttpSession session = request.getSession();
        Object userSession = session.getAttribute("doctorInfo");//查找session，获取医生信息
        Doctor doctor=(Doctor)  userSession;
        String doctor_id=doctor.getDoctorId();
        String symptom_description = request.getParameter("symtomDescription");
        String patient_id = request.getParameter("patientId");
        record.setBillTime(new Date());
        record.setPatientIdentity(patient_id);
        record.setDoctorId(doctor_id);
        record.setSymptomDescription(symptom_description);
        System.out.println("保存病历"+record.getRecordId());
        parameter.put("recordId", String.valueOf(record.getRecordId()));
        recordService.create(record);
        parameter.put("recordStatus","ok");
        return JSON.toJSONString(parameter);
    }

    //填写检查单
    @ResponseBody
    @RequestMapping("/check")
    public String check(HttpServletResponse response, HttpServletRequest request){
        response.setContentType("text/html; charset=utf-8");

        String maxId = checkService.getMaxId();
        CheckTable check=new CheckTable();
        check.setCheckId(Integer.valueOf(maxId+1));
        String checkIds = String.valueOf(Integer.parseInt(maxId) + 1);

        Map<String,String> parameter = new HashMap<>();
        String check_description = request.getParameter("checkDescription");
        String patient_id = request.getParameter("patientId");
//        String doctor_id = request.getParameter("doctorId");
        HttpSession session = request.getSession();
        Object userSession = session.getAttribute("doctorInfo");//查找session，获取医生信息
        Doctor doctor=(Doctor)  userSession;
        String doctorId=doctor.getDoctorId();
        check.setCheckDescription(check_description);
        check.setPatientIdentity(patient_id);
        check.setDoctorId(doctorId);
        check.setBillTime(new Date());
        System.out.println("填写检查单  "+check_description+"  "+patient_id+"  "+doctorId+"   ");

        checkService.create(check);
        String recordId = request.getParameter("recordId");
        System.out.println("病历编号："+"  "+recordId);
        Record record = recordService.findByRecordId(recordId);
        record.setCheckIds(checkIds);
        recordService.updateSelective(record);
        parameter.put("checkStatus","ok");
        return JSON.toJSONString(parameter);

    }

    //检索药品
    @RequestMapping("/medicineSearch")
    @ResponseBody
    public String medicineSearch(HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/html; charset=utf-8");

        Map<String,String> parameter = new HashMap<>();
        String medicineName =  request.getParameter("medicineName");
        System.out.println("查询药品："+medicineName);
        Medicine medicine = medicineService.searchByName(medicineName);

        if(null == medicine){
            parameter.put("status","null");
            parameter.put("msg","没有这种药物");
        }
        else{
            parameter.put("status","ok");
            parameter.put("medicineId",medicine.getMedicineId());
            parameter.put("medicineName",medicine.getMedicineName());
            parameter.put("medicineNumber",String.valueOf(medicine.getMedicineNumber()));
        }
        return JSON.toJSONString(parameter);
    }

    //新增处方单
    @ResponseBody
    @RequestMapping("/prescriptionCreate")
    public String prescriptionCreate(HttpServletResponse response, HttpServletRequest request){
        response.setContentType("text/html; charset=utf-8");
        Map<String,String> parameter = new HashMap<>();
        //查找session，获取医生信息
        HttpSession session = request.getSession();
        Object userSession = session.getAttribute("doctorInfo");
        Doctor doctor=(Doctor)  userSession;
        String doctorId=doctor.getDoctorId();
        //获取前端传递的数据，药品id和数量有多个，用逗号分隔。
        String patientId = request.getParameter("patientId");
        String recordId = request.getParameter("recordId");
        String[] medicineIds = request.getParameter("medicineId").split(",");
        String[] medicineNumbers = request.getParameter("medicineNumber").split(",");
        System.out.println("新增处方单：");
        System.out.println("患者编号："+patientId);
        System.out.println("病历编号："+recordId);
        System.out.println("药品编号："+request.getParameter("medicineId"));
        System.out.println("药品数量"+request.getParameter("medicineNumber"));


        String preIds="";
        for(int i=0;i<medicineIds.length;i++ ){
            String medicineId=medicineIds[i];
            int medicneNumber=Integer.parseInt(medicineNumbers[i]);
            //开具处方单，并存入数据库，返回处方单号
            PrescriptionTable prescriptionTable=new PrescriptionTable();
            prescriptionTable.setPatientIdentity(patientId);
            prescriptionTable.setDoctorId(doctorId);
            prescriptionTable.setBillTime(new Date());
            prescriptionTable.setMedicineId(medicineId);
            prescriptionTable.setMedicineNumber(medicneNumber);
            prescriptionService.addPrescription(prescriptionTable);
            preIds=preIds+prescriptionTable.getPrescriptionId()+",";
        }
        //获取最新添加的病历信息
        Record record=recordService.findByRecordId(recordId);
        record.setPrescriptionIds(preIds);
        recordService.updateSelective(record);
        //返回信息
        parameter.put("status","ok");
        parameter.put("msg",preIds);
        return JSON.toJSONString(parameter);
    }

    //查看历史病历
    @RequestMapping("/historyRecord")
    @ResponseBody
    public void historyRecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");

        Map<String,String> parameter = new HashMap<>();
        String patientId = request.getParameter("patientId");
        List<RecordHistoryDto> recordHistoryDtos=recordService.findHistoryByPatientId(patientId);
        if (recordHistoryDtos.size()==0){
            response.getWriter().print("暂无历史病历");
        }
        else{
            try{
                String jsonString=new GsonBuilder().serializeNulls().create().toJson(recordHistoryDtos);
                response.getWriter().print(jsonString);
                System.out.println(jsonString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //病历详情
    @RequestMapping("/detailedRecord")
    @ResponseBody
    public String detailedRecord(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html; charset=utf-8");

        Map<String,String> parameter = new HashMap<>();
        String recordId = request.getParameter("recordId");

        Record record = recordService.findByRecordId(recordId);

        String symptomDescription = record.getSymptomDescription();
        parameter.put("symptomDescription",symptomDescription);

        String prescriptionIds = record.getPrescriptionIds();
        String medicineNums="";
        String medicineNames="";
        if (prescriptionIds!=null){
            String[] prescriptionId = prescriptionIds.split(",");

            for (int i = 0;i<prescriptionId.length;i++){
                PrescriptionTable prescriptionTable = prescriptionService.findById(prescriptionId[i]);
                String medicineNum = String.valueOf(prescriptionTable.getMedicineNumber());
                medicineNums=medicineNums+medicineNum+",";
                String medicineId = prescriptionTable.getMedicineId();
                Medicine medicine = medicineService.findById(medicineId);
                String medicineName = medicine.getMedicineName();
                medicineNames=medicineNames+medicineName+",";
            }
        }
        String checkDescriptions ="";

        String checkIds = record.getCheckIds();
        if (checkIds!=null){
            String[] checkId = checkIds.split(",");
            for (int i =0;i<checkId.length;i++){
                CheckTable checkTable = checkService.findById(checkId[i]);
                String checkDescription = checkTable.getCheckDescription();
                checkDescriptions=checkDescriptions+checkDescription+",";
            }
        }
        parameter.put("medicineNames",medicineNames);
        parameter.put("medicineNumbers",medicineNums);
        parameter.put("checkDescriptions",checkDescriptions);
        return JSON.toJSONString(parameter);
    }
}

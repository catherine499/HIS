package com.example.HIS.service;

import com.example.HIS.models.*;
import com.example.HIS.DTO.RemainDoctorDto;
import com.example.HIS.DTO.ReserveTableDto;

import java.util.Date;
import java.util.List;

public interface TakeNumberService {

    List<ReserveTableDto>  getReserveInfoByPIdToday(String patientIdentity);

    ReserveTable getReserveTableByPrimaryKey(int reserveId);

    int addRegisterTable(RegisterTable registerTable);

    List<RemainDeptNumber> getRemainDeptNumberToday();

    List<RemainDoctorDto> getDoctorRmainToday();

    int getMaxDeptNumberByDeptId(String departmentId);

    void addDeptqueue(DeptQueue deptQueue);

    void addDoctorqueue(DoctorQueue doctorQueue);

    RegisterTable getRegisterTableById(Integer registerId);

    DeptQueue getDeptQueueByRegisterId(Integer registerId);

    void updateDeptQueue(DeptQueue deptQueue);

    DoctorQueue getDoctorQueueByRegisterId(Integer registerId);

    void updateDoctorQueue(DoctorQueue doctorQueue);

    void updateReserveState(ReserveTable reserveTable);

    List<DoctorQueue> getDoctorQueueByDoctorId(String doctorId);

    List<DeptQueue> getDeptQueueByDeptId(String deptId);

    List<DoctorQueue> getReserveDoctorQueueByDoctorId(String doctorId);

    List<DoctorQueue> getSiteDoctorQueueByDoctorId(String doctorId);

    List<DeptQueue> getReserveDeptQueueByDeptId(String deptId);

    List<DeptQueue> getSiteDeptQueueByDeptId(String deptId);

    int getMaxDoctorNumberByDoctorId(String doctorId);

    List<RemainDoctorNumber> getRemainDcotorNumberByTimeAndDoctorId(String doctorId);

    void updateRemainDcotorNumber(RemainDoctorNumber remainDoctorNumber);
}

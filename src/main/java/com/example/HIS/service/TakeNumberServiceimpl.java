package com.example.HIS.service;

import com.example.HIS.generate.*;
import com.example.HIS.models.*;
import com.example.HIS.DTO.RemainDoctorDto;
import com.example.HIS.DTO.ReserveTableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TakeNumberServiceimpl implements TakeNumberService {
    @Autowired
    RegisterTableDao registerTableDao;
    @Autowired
    ReserveTableDao reserveTableDao;
    @Autowired
    RemainDeptNumberDao remainDeptNumberDao;
    @Autowired
    RemainDoctorNumberDao remainDoctorNumberDao;
    @Autowired
    DeptQueueDao deptQueueDao;
    @Autowired
    DoctorQueueDao doctorQueueDao;


    @Override
    public List<ReserveTableDto>  getReserveInfoByPIdToday(String patientIdentity) {
        return reserveTableDao.selectInfoByPIdToday(patientIdentity);
    }

    @Override
    public ReserveTable getReserveTableByPrimaryKey(int reserveId) {
        return reserveTableDao.selectByPrimaryKey(reserveId);
    }

    @Override
    public int addRegisterTable(RegisterTable registerTable) {
        return registerTableDao.insert(registerTable);
    }

    @Override
    public List<RemainDeptNumber> getRemainDeptNumberToday() {
        return remainDeptNumberDao.getAllToday();
    }

    @Override
    public List<RemainDoctorDto> getDoctorRmainToday() {
        return remainDoctorNumberDao.getAllDoctorRemainToday();
    }

    @Override
    public int getMaxDeptNumberByDeptId(String departmentId) {
        return deptQueueDao.getMaxIdByDeptId(departmentId);
    }

    @Override
    public int getMaxDoctorNumberByDoctorId(String doctorId) {
        return doctorQueueDao.getMaxIdByDoctorId(doctorId);
    }

    @Override
    public List<RemainDoctorNumber> getRemainDcotorNumberByTimeAndDoctorId(String doctorId) {
        return remainDoctorNumberDao.selectByDoctorIdAndTime(doctorId);
    }

    @Override
    public void updateRemainDcotorNumber(RemainDoctorNumber remainDoctorNumber) {
        remainDoctorNumberDao.updateByPrimaryKey(remainDoctorNumber);
    }

    @Override
    public void addDeptqueue(DeptQueue deptQueue) {
        deptQueueDao.insertSelective(deptQueue);
    }

    @Override
    public void addDoctorqueue(DoctorQueue doctorQueue) {
        doctorQueueDao.insertSelective(doctorQueue);
    }

    @Override
    public RegisterTable getRegisterTableById(Integer registerId) {
        return registerTableDao.selectByPrimaryKey(registerId);
    }

    @Override
    public DeptQueue getDeptQueueByRegisterId(Integer registerId) {
        return deptQueueDao.getByRegisterId(registerId);
    }

    @Override
    public void updateDeptQueue(DeptQueue deptQueue) {
        deptQueueDao.updateByPrimaryKey(deptQueue);
    }

    @Override
    public DoctorQueue getDoctorQueueByRegisterId(Integer registerId) {
        return doctorQueueDao.getByRegisterId(registerId);
    }

    @Override
    public void updateDoctorQueue(DoctorQueue doctorQueue) {
        doctorQueueDao.updateByPrimaryKey(doctorQueue);
    }

    @Override
    public void updateReserveState(ReserveTable reserveTable) {
        reserveTableDao.updateByPrimaryKey(reserveTable);
    }

    @Override
    public List<DoctorQueue> getDoctorQueueByDoctorId(String doctorId) {
        return doctorQueueDao.getByDoctorId(doctorId);
    }

    @Override
    public List<DeptQueue> getDeptQueueByDeptId(String deptId) {
        return deptQueueDao.getByDeptId(deptId);
    }

    @Override
    public List<DoctorQueue> getReserveDoctorQueueByDoctorId(String doctorId) {
        return doctorQueueDao.getReserveByDoctorId(doctorId);
    }

    @Override
    public List<DoctorQueue> getSiteDoctorQueueByDoctorId(String doctorId) {
        return doctorQueueDao.getSiteByDoctorId(doctorId);
    }

    @Override
    public List<DeptQueue> getReserveDeptQueueByDeptId(String deptId) {
        return deptQueueDao.getReserveByDeptId(deptId);
    }

    @Override
    public List<DeptQueue> getSiteDeptQueueByDeptId(String deptId) {
        return deptQueueDao.getSiteByDeptId(deptId);
    }
}

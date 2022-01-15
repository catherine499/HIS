package com.example.HIS.service;

import com.example.HIS.generate.*;
import com.example.HIS.models.*;
import com.example.HIS.tool.DateTool;
import com.example.HIS.DTO.RemainDoctorDto;
import com.example.HIS.DTO.ReserveHistoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private RemainDeptNumberDao remainDeptNumberDao;
    @Autowired
    private RemainDoctorNumberDao remainDoctorNumberDao;
    @Autowired
    private ReserveTableDao reserveTableDao;
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private ViolateTableDao violateTableDao;

    @Override
    public List<RemainDeptNumber> getAllRemainDeptNumber() {
        return remainDeptNumberDao.getAll();
    }

    @Override
    public List<RemainDoctorDto> getAllDoctorRemain() {
        return remainDoctorNumberDao.getAllDoctorRemain();
    }

    @Override
    public int addReserveTable(ReserveTable reserveTable) {
        return reserveTableDao.insert(reserveTable);
    }



    @Override
    public int getBlackFlag(Patient patient) {
        //查询违约记录，判断是否应该在黑名单中-->七天内两次，90天内5次
        List<ReserveTable> reserveTableList=reserveTableDao.selectViolateByPatientId(patient.getPatientIdentity());
        //当前时间前一周的时刻
        Calendar calendar = Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        Date lastWeek= DateTool.getPastDate(7,hour);
        int count7=0,count90=0;
        Date last90= DateTool.getPastDate(90,hour);
        for (ReserveTable table :reserveTableList){
            if (table.getReserveState()==-1){
                if (table.getReserveTime().after(lastWeek)){
                    count7 +=1;
                }
                if (table.getReserveTime().after(last90)){
                    count90 +=1;
                }
            }
        }
        if(count7 >=2 || count90>=5){
            patient.setPatientIsBlack(1);
            patientDao.updateByPrimaryKey(patient);
            return 1;
        }
        else{
            patient.setPatientIsBlack(0);
            patientDao.updateByPrimaryKey(patient);
            return 0;
        }
    }

    @Override
    public int updateRemainDeptNumber(RemainDeptNumber remainDeptNumber) {
        return remainDeptNumberDao.updateByPrimaryKey(remainDeptNumber);
    }


    @Override
    public List<RemainDeptNumber> getRemainDeptNumberByDeptId(String DeptId) {
        return remainDeptNumberDao.selectByDeptId(DeptId);
    }

    @Override
    public int addRemainDeptNumber(RemainDeptNumber remainDeptNumber) {
        return remainDeptNumberDao.insertSelective(remainDeptNumber);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentDao.getAll();
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return doctorDao.getAll();
    }

    @Override
    public void addremainDoctorNumber(RemainDoctorNumber remainDoctorNumber) {
        remainDoctorNumberDao.insertSelective(remainDoctorNumber);
    }

    @Override
    public List<RemainDoctorNumber> getRemainDeptNumberByDoctorId(String doctorId) {
        return remainDoctorNumberDao.selectByDoctorID(doctorId);
    }

    @Override
    public void updateRemainDoctorNumber(RemainDoctorNumber remainDoctorNumber) {
        remainDoctorNumberDao.updateByPrimaryKey(remainDoctorNumber);
    }

    @Override
    public List<ReserveHistoryDto> getReserveHistoryByPatientId(String patientIdentity) {
        return reserveTableDao.selectHistoryByPatientId(patientIdentity);
    }

    @Override
    public void updateReserveState(ReserveTable reserveTable) {
        reserveTableDao.updateByPrimaryKey(reserveTable);
    }

    @Override
    public ReserveTable getRserveTabltByPk(int reserveId) {
        return reserveTableDao.selectByPrimaryKey(reserveId);
    }

    @Override
    public void addViolateTable(ViolateTable violateTable) {
        violateTableDao.insertSelective(violateTable);
    }

    @Override
    public List<RemainDoctorDto> getAllDoctorRemainByDoctorId(String doctorId) {
        return remainDoctorNumberDao.selectByDoctorId(doctorId);
    }
}

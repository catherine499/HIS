package com.example.HIS.service;

import com.example.HIS.generate.CashierDao;
import com.example.HIS.generate.DoctorDao;
import com.example.HIS.generate.PatientDao;
import com.example.HIS.generate.PharmacistDao;
import com.example.HIS.models.Cashier;
import com.example.HIS.models.Doctor;
import com.example.HIS.models.Patient;
import com.example.HIS.models.Pharmacist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    PatientDao patientDao;
    @Autowired
    DoctorDao doctorDao;
    @Autowired
    CashierDao cashierDao;
    @Autowired
    PharmacistDao pharmacistDao;
    @Override
    public int login(String patientIdentity, String password) {
        return 0;
    }

    @Override
    public Patient selectPatient(String patientIdentity) {
        return patientDao.selectByPrimaryKey(patientIdentity);
    }

    @Override
    public Cashier selectCashier(String staffId) {
        return cashierDao.selectByPrimaryKey(staffId);
    }

    @Override
    public Doctor selectDoctor(String staffId) {
        return doctorDao.selectByPrimaryKey(staffId);
    }

    @Override
    public Pharmacist selectPharmacist(String staffId) {
        return pharmacistDao.selectByPrimaryKey(staffId);
    }
}

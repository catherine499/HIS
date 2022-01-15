package com.example.HIS.service;

import com.example.HIS.generate.PatientDao;
import com.example.HIS.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientDao patientDao;

    //增删改查
    public Patient selectPatient(String patientIdentity){return patientDao.selectByPrimaryKey(patientIdentity);};

}

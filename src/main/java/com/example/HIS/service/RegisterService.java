package com.example.HIS.service;

import com.example.HIS.models.Patient;
import com.example.HIS.models.RegisterTable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RegisterService {
    int addPatient(Patient patient);

    Patient selectPatient(String patientIdentity);

    RegisterTable findById(Integer registerId);
}

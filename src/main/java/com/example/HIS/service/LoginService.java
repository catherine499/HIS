package com.example.HIS.service;

import com.example.HIS.models.Cashier;
import com.example.HIS.models.Doctor;
import com.example.HIS.models.Patient;
import com.example.HIS.models.Pharmacist;

public interface LoginService {
    int login(String patientIdentity,String password);
    Patient selectPatient(String patientIdentity);

    Cashier selectCashier(String staffId);

    Doctor selectDoctor(String staffId);

    Pharmacist selectPharmacist(String staffId);
}

package com.example.HIS.service;

import com.example.HIS.models.Patient;

public interface PatientService {
    public Patient selectPatient(String patientIdentity);
}

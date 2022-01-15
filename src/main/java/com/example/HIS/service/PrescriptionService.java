package com.example.HIS.service;

import com.example.HIS.models.PrescriptionTable;

public interface PrescriptionService {
    public  Integer getMaxId();

    public Integer addPrescription(PrescriptionTable prescriptionTable);

    public PrescriptionTable findById(String prescriptionId);
}

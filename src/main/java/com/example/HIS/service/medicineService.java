package com.example.HIS.service;

import com.example.HIS.models.Medicine;

public interface medicineService {
    public Medicine searchByName(String medicineName);

    public Medicine findById(String medicineId);
}

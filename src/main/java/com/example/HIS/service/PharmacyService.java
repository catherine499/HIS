package com.example.HIS.service;

import com.example.HIS.models.Medicine;
import com.example.HIS.models.PrescriptionTable;
import com.example.HIS.models.ReturnMedicineTable;
import com.example.HIS.models.TakeMedineTable;

import java.util.List;

public interface PharmacyService {

    List<TakeMedineTable> selectAllTakeMedineTable();

    List<TakeMedineTable> selectTakeMedicineTable(int takeMedicineTableId);

    PrescriptionTable selectPrescription(int prescriptionId);

    Medicine getMedicine(String medicineId);

    void updateTakeMedicine(TakeMedineTable takeMedineTable);

    void updateMedicine(Medicine medicine);

    String selectPharmacistName(String pharmacistId);

    void insertReturnTable(ReturnMedicineTable returnMedicineTable);
}

package com.example.HIS.service;

import com.example.HIS.generate.*;
import com.example.HIS.models.Medicine;
import com.example.HIS.models.PrescriptionTable;
import com.example.HIS.models.ReturnMedicineTable;
import com.example.HIS.models.TakeMedineTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService {
    @Autowired
    TakeMedineTableDao takeMedineTableDao;
    @Autowired
    PrescriptionTableDao prescriptionTableDao;
    @Autowired
    MedicineDao medicineDao;
    @Autowired
    PharmacistDao pharmacistDao;
    @Autowired
    ReturnMedicineTableDao returnMedicineTableDao;
    @Override
    public List<TakeMedineTable> selectAllTakeMedineTable() {
        return takeMedineTableDao.selectAllTakeMedineTable();
    }

    @Override
    public List<TakeMedineTable> selectTakeMedicineTable(int takeMedicineTableId) {
        return takeMedineTableDao.selectByPrimaryKey(takeMedicineTableId);
    }

    @Override
    public PrescriptionTable selectPrescription(int prescriptionId) {
        return prescriptionTableDao.selectByPrimaryKey(prescriptionId);
    }

    @Override
    public Medicine getMedicine(String medicineId) {
        return medicineDao.selectByPrimaryKey(medicineId);
    }

    @Override
    public void updateTakeMedicine(TakeMedineTable takeMedineTable) {
        takeMedineTableDao.updateByPrimaryKey(takeMedineTable);
    }

    @Override
    public void updateMedicine(Medicine medicine) {
        medicineDao.updateByPrimaryKey(medicine);
    }

    @Override
    public String selectPharmacistName(String pharmacistId) {
        return pharmacistDao.selectByPrimaryKey(pharmacistId).getPharmacistName();
    }

    @Override
    public void insertReturnTable(ReturnMedicineTable returnMedicineTable) {
        returnMedicineTableDao.insert(returnMedicineTable);
    }
}

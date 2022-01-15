package com.example.HIS.service;

import com.example.HIS.generate.MedicineDao;
import com.example.HIS.models.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class medicineServiceImpl implements medicineService {
    @Autowired
    MedicineDao medicineDao;

    //
    public Medicine searchByName(String medicineName){ return  medicineDao.selectByName(medicineName);};

    public Medicine findById(String medicineId){return medicineDao.selectByPrimaryKey(medicineId);}
}

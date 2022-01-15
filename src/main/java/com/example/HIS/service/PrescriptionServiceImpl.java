package com.example.HIS.service;


import com.example.HIS.generate.PrescriptionTableDao;
import com.example.HIS.models.PrescriptionTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{
    @Autowired
    PrescriptionTableDao prescriptionTableDao;

    //
    public  Integer getMaxId(){return prescriptionTableDao.getMaxId();}

    public Integer addPrescription(PrescriptionTable prescriptionTable){return  prescriptionTableDao.insertSelective(prescriptionTable);}

    public PrescriptionTable findById(String prescriptionId){return prescriptionTableDao.selectByPrimaryKey(Integer.valueOf(prescriptionId));}

}

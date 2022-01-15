package com.example.HIS.service;

import com.example.HIS.DTO.CheckTableDto;
import com.example.HIS.DTO.PrescriptionTableDto;
import com.example.HIS.generate.*;
import com.example.HIS.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl  implements PaymentService{
    @Autowired
    private CheckTableDao checkTableDao;
    @Autowired
    private PrescriptionTableDao prescriptionTableDao;
    @Autowired
    private MedicineDao medicineDao;
    @Autowired
    private PayTableDao payTableDao;
    @Autowired
    private TakeMedineTableDao takeMedineTableDao;
    @Autowired
    RegisterTableDao registerTableDao;

    @Override
    public CheckTable findCheckTableById(int payId) {
        return checkTableDao.selectByPrimaryKey(payId);
    }

    @Override
    public PrescriptionTable findPrescriptionTableById(int payId) {
        return prescriptionTableDao.selectByPrimaryKey(payId);
    }

    @Override
    public Medicine getMedicineByMId(String medicineId) {
        return medicineDao.selectByPrimaryKey(medicineId);
    }

    @Override
    public CheckTableDto findCheckTableDtoById(int parseInt) {
        return checkTableDao.getCheckTableDtoById(parseInt);
    }

    @Override
    public PrescriptionTableDto findPrescriptionTableDtoById(int parseInt) {
        return prescriptionTableDao.selectPrescriptionTableDtoById(parseInt);
    }

    @Override
    public void addPayTable(PayTable payTable) {
        payTableDao.insert(payTable);
    }

    @Override
    public void addTakeMedicineTable(TakeMedineTable takeMedineTable) {
        takeMedineTableDao.insertSelective(takeMedineTable);
    }

    @Override
    public double getMedicineMoney(String medicineId) {
        return medicineDao.selectMoneyById(medicineId);
    }

    @Override
    public void updateCheckTableState(CheckTable checkTable) {
        checkTableDao.updateByPrimaryKeySelective(checkTable);
    }

    @Override
    public RegisterTable getRegisterTableById(int parseInt) {
        return registerTableDao.selectByPrimaryKey(parseInt);
    }
}

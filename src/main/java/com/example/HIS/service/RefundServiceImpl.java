package com.example.HIS.service;

import com.example.HIS.generate.*;
import com.example.HIS.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefundServiceImpl implements RefundService {
    @Autowired
    RefundTableDao refundTableDao;
    @Autowired
    PayTableDao payTableDao;
    @Autowired
    PrescriptionTableDao prescriptionTableDao;
    @Autowired
    MedicineDao medicineDao;
    @Autowired
    CheckTableDao checkTableDao;

    @Override
    public List<RefundTable> selectAllPayRefund() {
        return  refundTableDao.selectAll();
    }

//    @Override
//    public RefundTable selectPayRefund(int pid) {
//        return refundTableDao.selectByPrimaryKey(pid);
//    }

    @Override
    public RefundTable selectPayRefundByPayId(int payId) {
        return refundTableDao.getByPayId(payId);
    }

    @Override
    public PayTable getPayTableByPayId(int payId) {
        return payTableDao.selectByPrimaryKey(payId);
    }

    @Override
    public PrescriptionTable getPrescriptionTableById(int payId1) {
        return prescriptionTableDao.selectByPrimaryKey(payId1);
    }

    @Override
    public String getMedicineNameByMId(String medicineId) {
        return medicineDao.selectMedicineNameById(medicineId);
    }

    @Override
    public CheckTable getCheckTableById(int payId1) {
        return checkTableDao.selectByPrimaryKey(payId1);
    }

    @Override
    public void addRefundTable(RefundTable refundTable1) {
        refundTableDao.insertSelective(refundTable1);
    }
}

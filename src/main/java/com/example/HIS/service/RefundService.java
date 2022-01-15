package com.example.HIS.service;

import com.example.HIS.models.*;

import java.util.List;

public interface RefundService {
    List<RefundTable> selectAllPayRefund();

//    RefundTable selectPayRefund(int pid);

    RefundTable selectPayRefundByPayId(int payId);

    PayTable getPayTableByPayId(int payId);

    PrescriptionTable getPrescriptionTableById(int payId1);

    String getMedicineNameByMId(String medicineId);

    CheckTable getCheckTableById(int payId1);

    void addRefundTable(RefundTable refundTable1);
}

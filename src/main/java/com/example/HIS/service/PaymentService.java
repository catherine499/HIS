package com.example.HIS.service;

import com.example.HIS.DTO.CheckTableDto;
import com.example.HIS.DTO.PrescriptionTableDto;
import com.example.HIS.models.*;

public interface PaymentService {


    CheckTable findCheckTableById(int payId);

    PrescriptionTable findPrescriptionTableById(int payId);

    Medicine getMedicineByMId(String medicineId);

    CheckTableDto findCheckTableDtoById(int parseInt);

    PrescriptionTableDto findPrescriptionTableDtoById(int parseInt);

    void addPayTable(PayTable payTable);

    void addTakeMedicineTable(TakeMedineTable takeMedineTable);

    double getMedicineMoney(String medicineId);

    void updateCheckTableState(CheckTable checkTable);

    RegisterTable getRegisterTableById(int parseInt);
}

package com.example.HIS.service;

import com.example.HIS.generate.PayTableDao;
import com.example.HIS.DTO.PayHistoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayHistoryServiceImpl implements PayHistoryService{

    @Autowired
    private PayTableDao payTableDao;

    @Override
    public List<PayHistoryDto> getPayHistoryByPatientId(String patientIdentity) {
        return payTableDao.getHistoryByPatientIdentity(patientIdentity);
    }
}

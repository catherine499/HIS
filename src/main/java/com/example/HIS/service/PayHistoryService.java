package com.example.HIS.service;

import com.example.HIS.DTO.PayHistoryDto;

import java.util.List;

public interface PayHistoryService {

    List<PayHistoryDto> getPayHistoryByPatientId(String patientIdentity);
}

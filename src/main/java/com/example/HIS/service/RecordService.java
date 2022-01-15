package com.example.HIS.service;

import com.example.HIS.DTO.RecordHistoryDto;
import com.example.HIS.models.Record;

import java.util.List;

public interface RecordService {

    public Integer create(Record record);

    //
    public List<Record> findByPatientId(String patientId);

    //
    public Integer getMaxId();

    public Record  findByRecordId(String RecordId);

    public void updateSelective(Record record);

    public List<RecordHistoryDto> findHistoryByPatientId(String patientId);
}

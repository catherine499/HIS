package com.example.HIS.service;

import com.example.HIS.DTO.RecordHistoryDto;
import com.example.HIS.generate.RecordDao;
import com.example.HIS.models.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService{
    @Autowired
    private RecordDao recordDao;


    public Integer create(Record record){return recordDao.insert(record);};

    //
    public List<Record> findByPatientId(String patientId){return recordDao.findByPatientId(patientId);}

    //
    public Integer getMaxId(){return recordDao.getMaxId();};

    public Record  findByRecordId(String RecordId){return  recordDao.selectByPrimaryKey(Integer.valueOf(RecordId));}

    public void updateSelective(Record record) {
        recordDao.updateByPrimaryKeySelective(record);
    }

    public List<RecordHistoryDto> findHistoryByPatientId(String patientId) {
        return recordDao.findHistoryByPatientId(patientId);
    }
}

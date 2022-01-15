package com.example.HIS.generate;

import com.example.HIS.DTO.RecordHistoryDto;
import com.example.HIS.models.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordDao {
    int deleteByPrimaryKey(Integer recordId);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    Integer getMaxId();

    List<Record> findByPatientId(String patientId);

    List<RecordHistoryDto> findHistoryByPatientId(String patientId);
}
package com.example.HIS.generate;

import com.example.HIS.models.PayTable;
import com.example.HIS.DTO.PayHistoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayTableDao {
    int deleteByPrimaryKey(Integer payId);

    int insert(PayTable record);

    int insertSelective(PayTable record);

    PayTable selectByPrimaryKey(Integer payId);

    int updateByPrimaryKeySelective(PayTable record);

    int updateByPrimaryKey(PayTable record);

    List<PayHistoryDto> getHistoryByPatientIdentity(String patientIdentity);
}
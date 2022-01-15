package com.example.HIS.generate;

import com.example.HIS.models.Pharmacist;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PharmacistDao {
    int deleteByPrimaryKey(String pharmacistId);

    int insert(Pharmacist record);

    int insertSelective(Pharmacist record);

    Pharmacist selectByPrimaryKey(String pharmacistId);

    int updateByPrimaryKeySelective(Pharmacist record);

    int updateByPrimaryKey(Pharmacist record);
}
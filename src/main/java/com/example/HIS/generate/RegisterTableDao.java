package com.example.HIS.generate;

import com.example.HIS.models.RegisterTable;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterTableDao {
    int deleteByPrimaryKey(Integer registerId);

    int insert(RegisterTable record);

    int insertSelective(RegisterTable record);

    RegisterTable selectByPrimaryKey(Integer registerId);

    int updateByPrimaryKeySelective(RegisterTable record);

    int updateByPrimaryKey(RegisterTable record);

    RegisterTable selectByPId(String patientIdentity);
}
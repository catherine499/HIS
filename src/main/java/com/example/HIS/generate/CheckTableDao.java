package com.example.HIS.generate;

import com.example.HIS.DTO.CheckTableDto;
import com.example.HIS.models.CheckTable;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheckTableDao {
    int deleteByPrimaryKey(Integer checkId);

    int insert(CheckTable record);

    int insertSelective(CheckTable record);

    CheckTable selectByPrimaryKey(Integer checkId);

    int updateByPrimaryKeySelective(CheckTable record);

    int updateByPrimaryKey(CheckTable record);

    String getMaxId();

    CheckTableDto getCheckTableDtoById(int checkId);
}
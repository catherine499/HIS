package com.example.HIS.generate;

import com.example.HIS.models.Patient;
import com.example.HIS.models.ViolateTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ViolateTableDao {
    int deleteByPrimaryKey(Integer violateId);

    int insert(ViolateTable record);

    int insertSelective(ViolateTable record);

    ViolateTable selectByPrimaryKey(Integer violateId);

    int updateByPrimaryKeySelective(ViolateTable record);

}

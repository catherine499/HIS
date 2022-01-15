package com.example.HIS.generate;

import com.example.HIS.models.TakeMedineTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TakeMedineTableDao {
    int deleteByPrimaryKey(Integer takeId);

    int insert(TakeMedineTable record);

    int insertSelective(TakeMedineTable record);

    List<TakeMedineTable> selectByPrimaryKey(Integer takeId);

    List<TakeMedineTable> selectAllTakeMedineTable();

    int updateByPrimaryKeySelective(TakeMedineTable record);

    int updateByPrimaryKey(TakeMedineTable record);
}
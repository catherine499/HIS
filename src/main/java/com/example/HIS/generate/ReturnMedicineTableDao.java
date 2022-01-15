package com.example.HIS.generate;

import com.example.HIS.models.ReturnMedicineTable;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReturnMedicineTableDao {
    int deleteByPrimaryKey(Integer returnId);

    int insert(ReturnMedicineTable record);

    int insertSelective(ReturnMedicineTable record);

    ReturnMedicineTable selectByPrimaryKey(Integer returnId);

    int updateByPrimaryKeySelective(ReturnMedicineTable record);

    int updateByPrimaryKey(ReturnMedicineTable record);
}
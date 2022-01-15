package com.example.HIS.generate;

import com.example.HIS.models.Medicine;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MedicineDao {
    int deleteByPrimaryKey(String medicineId);

    int insert(Medicine record);

    int insertSelective(Medicine record);

    Medicine selectByPrimaryKey(String medicineId);

    int updateByPrimaryKeySelective(Medicine record);

    int updateByPrimaryKey(Medicine record);

    Medicine selectByName(String medicineName);

    double selectMoneyById(String medicineId);

    String selectMedicineNameById(String medicineId);
}
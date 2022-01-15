package com.example.HIS.generate;

import com.example.HIS.DTO.PrescriptionTableDto;
import com.example.HIS.models.PrescriptionTable;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrescriptionTableDao {
    int deleteByPrimaryKey(Integer prescriptionId);

    int insert(PrescriptionTable record);

    int insertSelective(PrescriptionTable record);

    PrescriptionTable selectByPrimaryKey(Integer prescriptionId);

    int updateByPrimaryKeySelective(PrescriptionTable record);

    int updateByPrimaryKey(PrescriptionTable record);

    Integer getMaxId();

    PrescriptionTableDto selectPrescriptionTableDtoById(int prescriptionId);
}
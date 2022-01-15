package com.example.HIS.generate;

import com.example.HIS.models.Patient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatientDao {
    int deleteByPrimaryKey(String patientIdentity);

    int insert(Patient record);

    int insertSelective(Patient record);

    Patient selectByPrimaryKey(String patientIdentity);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);

    List<Patient> getAll();
}
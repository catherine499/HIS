package com.example.HIS.generate;

import com.example.HIS.models.Doctor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorDao {
    int deleteByPrimaryKey(String doctorId);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    Doctor selectByPrimaryKey(String doctorId);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);

    List<Doctor> getAll();
}
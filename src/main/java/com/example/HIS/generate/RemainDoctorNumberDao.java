package com.example.HIS.generate;

import com.example.HIS.models.RemainDoctorNumber;
import com.example.HIS.DTO.RemainDoctorDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
@Mapper
public interface RemainDoctorNumberDao {

     List<RemainDoctorDto> selectByDoctorId(String doctorId);

    List<RemainDoctorDto> getAllDoctorRemain();

    int insert(RemainDoctorNumber record);

    int insertSelective(RemainDoctorNumber record);

    List<RemainDoctorNumber> selectByDoctorID(String doctorId);

    void updateByPrimaryKey(RemainDoctorNumber remainDoctorNumber);

    List<RemainDoctorDto> getAllDoctorRemainToday();

    List<RemainDoctorNumber> selectByDoctorIdAndTime(String doctorId);
}

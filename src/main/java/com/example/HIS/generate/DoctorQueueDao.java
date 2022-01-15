package com.example.HIS.generate;

import com.example.HIS.models.DoctorQueue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DoctorQueueDao {
    int deleteByPrimaryKey(Integer doctorQueueId);

    int insert(DoctorQueue record);

    int insertSelective(DoctorQueue record);

    DoctorQueue selectByPrimaryKey(Integer doctorQueueId);

    int updateByPrimaryKeySelective(DoctorQueue record);

    int updateByPrimaryKey(DoctorQueue record);

    Integer getMaxIdByDoctorId(String doctorId);

    DoctorQueue getByRegisterId(Integer registerId);

    List<DoctorQueue> getByDoctorId(String doctorId);

    List<DoctorQueue> getReserveByDoctorId(String doctorId);

    List<DoctorQueue> getSiteByDoctorId(String doctorId);
}
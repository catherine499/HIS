package com.example.HIS.generate;

import com.example.HIS.models.ReserveTable;
import com.example.HIS.DTO.ReserveHistoryDto;
import com.example.HIS.DTO.ReserveTableDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReserveTableDao {
    int deleteByPrimaryKey(Integer reserveId);

    int insert(ReserveTable record);

    int insertSelective(ReserveTable record);

    ReserveTable selectByPrimaryKey(Integer reserveId);

    int updateByPrimaryKeySelective(ReserveTable record);

    int updateByPrimaryKey(ReserveTable record);

    List<ReserveTable> selectViolateByPatientId(String patientId);

    List<ReserveHistoryDto> selectHistoryByPatientId(String patientIdentity);

    List<ReserveTableDto> selectInfoByPIdToday(String patientIdentity);
}


package com.example.HIS.generate;

import com.example.HIS.models.RemainDeptNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface RemainDeptNumberDao {
    List<RemainDeptNumber> getAll();

    int deleteByPrimaryKey(Integer remainDeptNumderId);

    int insert(RemainDeptNumber record);

    int insertSelective(RemainDeptNumber record);

    RemainDeptNumber selectByPrimaryKey(Integer remainDeptNumderId);

    int updateByPrimaryKeySelective(RemainDeptNumber record);

    int updateByPrimaryKey(RemainDeptNumber record);

    List<RemainDeptNumber> selectByDeptId(@Param("DeptId") String DeptId);

    List<RemainDeptNumber> getAllToday();
}
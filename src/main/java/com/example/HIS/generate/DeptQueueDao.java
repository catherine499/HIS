package com.example.HIS.generate;

import com.example.HIS.models.DeptQueue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DeptQueueDao {
    int deleteByPrimaryKey(Integer deptQueueId);

    int insert(DeptQueue record);

    int insertSelective(DeptQueue record);

    DeptQueue selectByPrimaryKey(Integer deptQueueId);

    int updateByPrimaryKeySelective(DeptQueue record);

    int updateByPrimaryKey(DeptQueue record);

    int getMaxIdByDeptId(String departmentId);

    DeptQueue getByRegisterId(Integer registerId);

    List<DeptQueue> getByDeptId(String deptId);

    List<DeptQueue> getReserveByDeptId(String deptId);

    List<DeptQueue> getSiteByDeptId(String deptId);
}
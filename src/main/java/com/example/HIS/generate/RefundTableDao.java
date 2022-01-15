package com.example.HIS.generate;

import com.example.HIS.models.RefundTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RefundTableDao {
    int deleteByPrimaryKey(Integer refundId);

    int insert(RefundTable record);

    int insertSelective(RefundTable record);

    RefundTable selectByPrimaryKey(Integer refundId);

    int updateByPrimaryKeySelective(RefundTable record);

    int updateByPrimaryKey(RefundTable record);

    List<RefundTable> selectAll();

    RefundTable getByPayId(int payId);
}
package com.example.HIS.models;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * dept_queue
 * @author 
 */
@Data
public class DeptQueue implements Serializable {
    /**
     * 科室号队列编号
     */
    private Integer deptQueueId;

    /**
     * 科室编号
     */
    private String departmentId;

    /**
     * 日期
     */
    private Date deptQueueDate;

    /**
     * 挂号单号
     */
    private Integer registerId;

    /**
     * 挂号单上的号码
     */
    private Integer registerNumber;

    /**
     * 是否完成诊断（1：是，0：否）
     */
    private Integer state;

    private static final long serialVersionUID = 1L;

    public Integer getDeptQueueId() {
        return deptQueueId;
    }

    public void setDeptQueueId(Integer deptQueueId) {
        this.deptQueueId = deptQueueId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Date getDeptQueueDate() {
        return deptQueueDate;
    }

    public void setDeptQueueDate(Date deptQueueDate) {
        this.deptQueueDate = deptQueueDate;
    }

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public Integer getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(Integer registerNumber) {
        this.registerNumber = registerNumber;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
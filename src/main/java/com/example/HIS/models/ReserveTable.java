package com.example.HIS.models;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * reserve_tables
 * @author 
 */
@Data
public class ReserveTable implements Serializable {
    /**
     * 预约单号
     */
    private Integer reserveId;

    /**
     * 患者身份证号
     */
    private String patientIdentity;

    /**
     * 预约的科室编号
     */
    private String departmentId;

    /**
     * 预约的医生工号
     */
    private String doctorId;

    /**
     * 预约类型1科室，0专家
     */
    private Integer reserveType;

    /**
     * 预约状态,0待确认,1已完成,-1已取消
     */
    private Integer reserveState;

    /**
     * 预约时段的起始时间
     */
    private Date reserveTime;

    private static final long serialVersionUID = 1L;

    public ReserveTable() {
    }

    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }

    public String getPatientIdentity() {
        return patientIdentity;
    }

    public void setPatientIdentity(String patientIdentity) {
        this.patientIdentity = patientIdentity;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getReserveType() {
        return reserveType;
    }

    public void setReserveType(Integer reserveType) {
        this.reserveType = reserveType;
    }

    public Integer getReserveState() {
        return reserveState;
    }

    public void setReserveState(Integer reserveState) {
        this.reserveState = reserveState;
    }

    public Date getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Date reserveTime) {
        this.reserveTime = reserveTime;
    }
}
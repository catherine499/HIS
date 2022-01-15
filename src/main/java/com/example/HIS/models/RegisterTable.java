package com.example.HIS.models;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * register_tables
 * @author 
 */
@Data
public class RegisterTable implements Serializable {
    /**
     * 挂号单号
     */
    private Integer registerId;

    /**
     * 患者身份证号
     */
    private String patientIdentity;

    /**
     * 挂号的科室编号
     */
    private String departmentId;

    /**
     * 挂号的医生工号
     */
    private String doctorId;

    /**
     * 挂号类型1科室，0专家
     */
    private Integer registerType;

    /**
     * 挂号排队类型1预约,0现场
     */
    private Integer registerQueueType;

    /**
     * 排队号
     */
    private Integer registerNumber;

    /**
     * 预约时段的起始时间
     */
    private Date registerTime;

    private static final long serialVersionUID = 1L;

    public RegisterTable() {
    }

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
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

    public Integer getRegisterType() {
        return registerType;
    }

    public void setRegisterType(Integer registerType) {
        this.registerType = registerType;
    }

    public Integer getRegisterQueueType() {
        return registerQueueType;
    }

    public void setRegisterQueueType(Integer registerQueueType) {
        this.registerQueueType = registerQueueType;
    }

    public Integer getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(Integer registerNumber) {
        this.registerNumber = registerNumber;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
}
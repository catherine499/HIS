package com.example.HIS.models;

import java.io.Serializable;
import lombok.Data;

/**
 * patients
 * @author 
 */
@Data
public class Patient implements Serializable {
    /**
     * 身份证号
     */
    private String patientIdentity;

    /**
     * 密码
     */
    private String patientPassword;

    /**
     * 姓名
     */
    private String patientName;

    /**
     * 性别1男,0女
     */
    private Integer patientGender;

    /**
     * 电话
     */
    private String patientTel;

    /**
     * 家庭住址
     */
    private String patientAddress;

    /**
     * 黑名单标记1在,0不在
     */
    private Integer patientIsBlack;

    private static final long serialVersionUID = 1L;

    public Patient(String patientIdentity, String patientPassword) {
        this.patientIdentity = patientIdentity;
        this.patientPassword = patientPassword;
    }

    public String getPatientIdentity() {
        return patientIdentity;
    }

    public void setPatientIdentity(String patientIdentity) {
        this.patientIdentity = patientIdentity;
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(Integer patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientTel() {
        return patientTel;
    }

    public void setPatientTel(String patientTel) {
        this.patientTel = patientTel;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public Integer getPatientIsBlack() {
        return patientIsBlack;
    }

    public void setPatientIsBlack(Integer patientIsBlack) {
        this.patientIsBlack = patientIsBlack;
    }
}
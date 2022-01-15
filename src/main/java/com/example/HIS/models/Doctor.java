package com.example.HIS.models;

import java.io.Serializable;
import lombok.Data;

/**
 * doctors
 * @author 
 */
@Data
public class Doctor implements Serializable {
    /**
     * 工号
     */
    private String doctorId;

    /**
     * 身份证号
     */
    private String doctorIdentity;

    /**
     * 密码
     */
    private String doctorPassword;

    /**
     * 姓名
     */
    private String doctorName;

    /**
     * 性别1男,0女
     */
    private Integer doctorGender;

    /**
     * 电话
     */
    private String doctorTel;

    /**
     * 家庭住址
     */
    private String doctorAddress;

    private String departmentId;

    private static final long serialVersionUID = 1L;

    public Doctor(String doctorId, String doctorPassword) {
        this.doctorId = doctorId;
        this.doctorPassword = doctorPassword;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorIdentity() {
        return doctorIdentity;
    }

    public void setDoctorIdentity(String doctorIdentity) {
        this.doctorIdentity = doctorIdentity;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Integer getDoctorGender() {
        return doctorGender;
    }

    public void setDoctorGender(Integer doctorGender) {
        this.doctorGender = doctorGender;
    }

    public String getDoctorTel() {
        return doctorTel;
    }

    public void setDoctorTel(String doctorTel) {
        this.doctorTel = doctorTel;
    }

    public String getDoctorAddress() {
        return doctorAddress;
    }

    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
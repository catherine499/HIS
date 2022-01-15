package com.example.HIS.models;

import java.io.Serializable;
import lombok.Data;

/**
 * pharmacists
 * @author 
 */
@Data
public class Pharmacist implements Serializable {
    /**
     * 工号
     */
    private String pharmacistId;

    /**
     * 身份证号
     */
    private String pharmacistIdentity;

    /**
     * 密码
     */
    private String pharmacistPassword;

    /**
     * 姓名
     */
    private String pharmacistName;

    /**
     * 性别1男,0女
     */
    private Integer pharmacistGender;

    /**
     * 电话
     */
    private String pharmacistTel;

    /**
     * 家庭住址
     */
    private String pharmacistAddress;

    private static final long serialVersionUID = 1L;

    public Pharmacist(String pharmacistId, String pharmacistPassword) {
        this.pharmacistId = pharmacistId;
        this.pharmacistPassword = pharmacistPassword;
    }

    public String getPharmacistId() {
        return pharmacistId;
    }

    public void setPharmacistId(String pharmacistId) {
        this.pharmacistId = pharmacistId;
    }

    public String getPharmacistIdentity() {
        return pharmacistIdentity;
    }

    public void setPharmacistIdentity(String pharmacistIdentity) {
        this.pharmacistIdentity = pharmacistIdentity;
    }

    public String getPharmacistPassword() {
        return pharmacistPassword;
    }

    public void setPharmacistPassword(String pharmacistPassword) {
        this.pharmacistPassword = pharmacistPassword;
    }

    public String getPharmacistName() {
        return pharmacistName;
    }

    public void setPharmacistName(String pharmacistName) {
        this.pharmacistName = pharmacistName;
    }

    public Integer getPharmacistGender() {
        return pharmacistGender;
    }

    public void setPharmacistGender(Integer pharmacistGender) {
        this.pharmacistGender = pharmacistGender;
    }

    public String getPharmacistTel() {
        return pharmacistTel;
    }

    public void setPharmacistTel(String pharmacistTel) {
        this.pharmacistTel = pharmacistTel;
    }

    public String getPharmacistAddress() {
        return pharmacistAddress;
    }

    public void setPharmacistAddress(String pharmacistAddress) {
        this.pharmacistAddress = pharmacistAddress;
    }
}
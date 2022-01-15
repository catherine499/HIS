package com.example.HIS.models;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * check_tables
 * @author 
 */
@Data
public class CheckTable implements Serializable {
    /**
     * 检查单号
     */
    private Integer checkId;

    /**
     * 患者身份证号
     */
    private String patientIdentity;

    /**
     * 医生工号
     */
    private String doctorId;

    /**
     * 检查项目描述
     */
    private String checkDescription;

    /**
     * 是否支付1是,0否
     */
    private Integer isPayed;

    /**
     * 是否完成检查1是,0否
     */
    private Integer isChecked;

    /**
     * 开具时间
     */
    private Date billTime;

    private static final long serialVersionUID = 1L;

    public CheckTable() {
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public String getPatientIdentity() {
        return patientIdentity;
    }

    public void setPatientIdentity(String patientIdentity) {
        this.patientIdentity = patientIdentity;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getCheckDescription() {
        return checkDescription;
    }

    public void setCheckDescription(String checkDescription) {
        this.checkDescription = checkDescription;
    }

    public Integer getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(Integer isPayed) {
        this.isPayed = isPayed;
    }

    public Integer getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Integer isChecked) {
        this.isChecked = isChecked;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }
}
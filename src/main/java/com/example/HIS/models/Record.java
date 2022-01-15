package com.example.HIS.models;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * records
 * @author 
 */
@Data
public class Record implements Serializable {
    /**
     * 病历编号
     */
    private Integer recordId;

    /**
     * 患者身份证号
     */
    private String patientIdentity;

    /**
     * 医生工号
     */
    private String doctorId;

    /**
     * 症状描述
     */
    private String symptomDescription;

    /**
     * 开具的处方单号，多个编号，逗号分隔
     */
    private String prescriptionIds;

    /**
     * 开具的检查单号，多个编号，逗号分隔
     */
    private String checkIds;

    /**
     * 开具时间
     */
    private Date billTime;

    private static final long serialVersionUID = 1L;

    public Record() {
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
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

    public String getSymptomDescription() {
        return symptomDescription;
    }

    public void setSymptomDescription(String symptomDescription) {
        this.symptomDescription = symptomDescription;
    }

    public String getPrescriptionIds() {
        return prescriptionIds;
    }

    public void setPrescriptionIds(String prescriptionIds) {
        this.prescriptionIds = prescriptionIds;
    }

    public String getCheckIds() {
        return checkIds;
    }

    public void setCheckIds(String checkIds) {
        this.checkIds = checkIds;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }
}
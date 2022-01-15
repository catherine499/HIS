package com.example.HIS.models;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * return_medicine_tables
 * @author 
 */
@Data
public class ReturnMedicineTable implements Serializable {
    /**
     * 取药单号
     */
    private Integer returnId;

    /**
     * 患者身份证号
     */
    private String patientIdentity;

    /**
     * 药剂师工号
     */
    private String pharmacistId;

    /**
     * 处方单号
     */
    private Integer prescriptionId;

    /**
     * 药品编号
     */
    private String medicineId;

    /**
     * 药品数量
     */
    private Integer returnNumber;

    /**
     * 退药时间
     */
    private Date returnTime;

    private static final long serialVersionUID = 1L;

    public ReturnMedicineTable() {
    }

    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    public String getPatientIdentity() {
        return patientIdentity;
    }

    public void setPatientIdentity(String patientIdentity) {
        this.patientIdentity = patientIdentity;
    }

    public String getPharmacistId() {
        return pharmacistId;
    }

    public void setPharmacistId(String pharmacistId) {
        this.pharmacistId = pharmacistId;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getReturnNumber() {
        return returnNumber;
    }

    public void setReturnNumber(Integer returnNumber) {
        this.returnNumber = returnNumber;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }
}
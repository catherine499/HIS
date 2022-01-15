package com.example.HIS.models;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * prescription_tables
 * @author 
 */
@Data
public class PrescriptionTable implements Serializable {
    /**
     * 处方单号
     */
    private Integer prescriptionId;

    /**
     * 患者身份证号
     */
    private String patientIdentity;

    /**
     * 医生工号
     */
    private String doctorId;

    /**
     * 药品编号
     */
    private String medicineId;

    /**
     * 药品数量
     */
    private Integer medicineNumber;

    /**
     * 开具时间
     */
    private Date billTime;

    private static final long serialVersionUID = 1L;

    public PrescriptionTable() {
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
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

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getMedicineNumber() {
        return medicineNumber;
    }

    public void setMedicineNumber(Integer medicineNumber) {
        this.medicineNumber = medicineNumber;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }
}
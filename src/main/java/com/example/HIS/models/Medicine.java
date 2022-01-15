package com.example.HIS.models;

import java.io.Serializable;
import lombok.Data;

/**
 * medicines
 * @author 
 */
@Data
public class Medicine implements Serializable {
    /**
     * 药品编号
     */
    private String medicineId;

    /**
     * 药品名称
     */
    private String medicineName;

    /**
     * 药品余量
     */
    private Integer medicineNumber;

    /**
     * 药品单价
     */
    private Double medicineMoney;

    private static final long serialVersionUID = 1L;

    public Medicine(String medicineId, String medicineName) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Integer getMedicineNumber() {
        return medicineNumber;
    }

    public void setMedicineNumber(Integer medicineNumber) {
        this.medicineNumber = medicineNumber;
    }

    public Double getMedicineMoney() {
        return medicineMoney;
    }

    public void setMedicineMoney(Double medicineMoney) {
        this.medicineMoney = medicineMoney;
    }
}
package com.example.HIS.DTO;

public class PrescriptionTableDto {//处方单号、药品Id、药品名称、药品数量、药品单价
    private String patientIdentity;
    private String patientName;
    private int prescriptionId;
    private String medicineId;
    private String medicineName;
    private  int medicineNumber;
    private float medicineMoney;


    public String getPatientIdentity() {
        return patientIdentity;
    }

    public void setPatientIdentity(String patientIdentity) {
        this.patientIdentity = patientIdentity;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
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

    public int getMedicineNumber() {
        return medicineNumber;
    }

    public void setMedicineNumber(int medicineNumber) {
        this.medicineNumber = medicineNumber;
    }

    public float getMedicineMoney() {
        return medicineMoney;
    }

    public void setMedicineMoney(float medicineMoney) {
        this.medicineMoney = medicineMoney;
    }
}

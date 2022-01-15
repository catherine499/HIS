package com.example.HIS.DTO;

public class CheckTableDto {
    private String patientIdentity;
    private String patientName;
    private int checkId;
    private String checkDescription;

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

    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    public String getCheckDescription() {
        return checkDescription;
    }

    public void setCheckDescription(String checkDescription) {
        this.checkDescription = checkDescription;
    }
}

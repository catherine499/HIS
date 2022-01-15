package com.example.HIS.DTO;

public class ReserveTableDto {
//患者姓名、患者身份证号、预约种类(1科室，0专家)、预约科室id、预约医生姓名、时间，状态(,0待确认,1已完成,-1已取消)
    int reserveId;
    String patientIdentity;
    String patientName;
    int reserveType;
    String departmentId;
    String doctorName;
    String reserveTime;
    int reserveState;

    public int getReserveId() {
        return reserveId;
    }

    public void setReserveId(int reserveId) {
        this.reserveId = reserveId;
    }

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

    public int getReserveType() {
        return reserveType;
    }

    public void setReserveType(int reserveType) {
        this.reserveType = reserveType;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(String reserveTime) {
        this.reserveTime = reserveTime;
    }

    public int getReserveState() {
        return reserveState;
    }

    public void setReserveState(int reserveState) {
        this.reserveState = reserveState;
    }
}

package com.example.HIS.DTO;

import java.util.Date;

public class ReserveHistoryDto {

    private int reserveId;
    private String reserveType;
    private String departmentName;
    private String doctorName;
    private Date reserveTime;
    private String reserveState;

    public int getReserveId() {
        return reserveId;
    }

    public void setReserveId(int reserveId) {
        this.reserveId = reserveId;
    }

    public String getReserveType() {
        return reserveType;
    }

    public void setReserveType(String reserveType) {
        this.reserveType = reserveType;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Date reserveTime) {
        this.reserveTime = reserveTime;
    }

    public String getReserveState() {
        return reserveState;
    }

    public void setReserveState(String reserveState) {
        this.reserveState = reserveState;
    }
}

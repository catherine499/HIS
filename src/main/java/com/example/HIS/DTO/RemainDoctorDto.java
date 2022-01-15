package com.example.HIS.DTO;

import java.util.Date;

public class RemainDoctorDto {
    private Integer remainDoctorNumberId;

    private String departmentId;

    private String doctorId;

    private Date time;

    private Integer number;

    private String doctorName;

    public Integer getRemainDoctorNumberId() {
        return remainDoctorNumberId;
    }

    public void setRemainDoctorNumberId(Integer remainDoctorNumberId) {
        this.remainDoctorNumberId = remainDoctorNumberId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}

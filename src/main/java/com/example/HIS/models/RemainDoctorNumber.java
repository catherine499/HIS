package com.example.HIS.models;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * remain_doctor_numders
 * @author 
 */
@Data
public class RemainDoctorNumber implements Serializable {

    private Integer remainDoctorNumberId;

    private String doctorId;

    private Date time;

    private Integer number;

    private static final long serialVersionUID = 1L;

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
}
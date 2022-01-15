package com.example.HIS.models;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * doctor_queue
 * @author 
 */
@Data
public class DoctorQueue implements Serializable {
    private Integer doctorQueueId;

    private String doctorId;

    private Date doctorQueueDate;

    private Integer registerId;

    private Integer registerNumber;

    /**
     * 是否完成诊断(1：是，0：否)
     */
    private Integer state;

    private static final long serialVersionUID = 1L;

    public Integer getDoctorQueueId() {
        return doctorQueueId;
    }

    public void setDoctorQueueId(Integer doctorQueueId) {
        this.doctorQueueId = doctorQueueId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public Date getDoctorQueueDate() {
        return doctorQueueDate;
    }

    public void setDoctorQueueDate(Date doctorQueueDate) {
        this.doctorQueueDate = doctorQueueDate;
    }

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public Integer getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(Integer registerNumber) {
        this.registerNumber = registerNumber;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
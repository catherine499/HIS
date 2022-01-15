package com.example.HIS.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
public class PayHistoryDto {
    int payId;
    String patientName;
    String patientIdentity;
    float payMoney;
    String payItem;
    String cashierName;
    Date payTime;

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientIdentity() {
        return patientIdentity;
    }

    public void setPatientIdentity(String patientIdentity) {
        this.patientIdentity = patientIdentity;
    }

    public float getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(float payMoney) {
        this.payMoney = payMoney;
    }

    public String getPayItem() {
        return payItem;
    }

    public void setPayItem(String payItem) {
        this.payItem = payItem;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}

package com.example.HIS.models;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * pay_tables
 * @author 
 */
@Data
public class PayTable implements Serializable {
    /**
     * 缴费单号
     */
    private Integer payId;

    /**
     * 患者身份证号
     */
    private String patientIdentity;

    /**
     * 收费人员工号
     */
    private String cashierId;

    /**
     * 缴费项目
     */
    private String payItem;

    /**
     * 缴费方式:0现金,1微信,2支付宝
     */
    private Integer payWay;

    /**
     * 缴费金额
     */
    private Double payMoney;

    /**
     * 缴费时间
     */
    private Date payTime;

    private static final long serialVersionUID = 1L;

    public PayTable() {
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public String getPatientIdentity() {
        return patientIdentity;
    }

    public void setPatientIdentity(String patientIdentity) {
        this.patientIdentity = patientIdentity;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    public String getPayItem() {
        return payItem;
    }

    public void setPayItem(String payItem) {
        this.payItem = payItem;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}
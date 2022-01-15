package com.example.HIS.models;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * refund_tables
 * @author 
 */
@Data
public class RefundTable implements Serializable {
    /**
     * 退费单号
     */
    private Integer refundId;

    /**
     * 患者身份证号
     */
    private String patientIdentity;

    /**
     * 收费人员工号
     */
    private String cashierId;

    /**
     * 缴费单号
     */
    private Integer payId;

    /**
     * 退费方式:0现金,1微信,2支付宝
     */
    private Integer refundWay;

    /**
     * 退费金额
     */
    private Double refundMoney;

    /**
     * 退费时间
     */
    private Date refundTime;

    private static final long serialVersionUID = 1L;

    public RefundTable() {
    }

    public Integer getRefundId() {
        return refundId;
    }

    public void setRefundId(Integer refundId) {
        this.refundId = refundId;
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

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public Integer getRefundWay() {
        return refundWay;
    }

    public void setRefundWay(Integer refundWay) {
        this.refundWay = refundWay;
    }

    public Double getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(Double refundMoney) {
        this.refundMoney = refundMoney;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }
}
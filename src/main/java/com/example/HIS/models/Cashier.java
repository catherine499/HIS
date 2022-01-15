package com.example.HIS.models;

import java.io.Serializable;
import lombok.Data;

/**
 * cashiers
 * @author 
 */
@Data
public class Cashier implements Serializable {
    /**
     * 工号
     */
    private String cashierId;

    /**
     * 身份证号
     */
    private String cashierIdentity;

    /**
     * 密码
     */
    private String cashierPassword;

    /**
     * 姓名
     */
    private String cashierName;

    /**
     * 性别1男,0女
     */
    private Integer cashierGender;

    /**
     * 电话
     */
    private String cashierTel;

    /**
     * 家庭住址
     */
    private String cashierAddress;

    private static final long serialVersionUID = 1L;

    public Cashier(String cashierId, String cashierPassword) {
        this.cashierId = cashierId;
        this.cashierPassword = cashierPassword;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    public String getCashierIdentity() {
        return cashierIdentity;
    }

    public void setCashierIdentity(String cashierIdentity) {
        this.cashierIdentity = cashierIdentity;
    }

    public String getCashierPassword() {
        return cashierPassword;
    }

    public void setCashierPassword(String cashierPassword) {
        this.cashierPassword = cashierPassword;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public Integer getCashierGender() {
        return cashierGender;
    }

    public void setCashierGender(Integer cashierGender) {
        this.cashierGender = cashierGender;
    }

    public String getCashierTel() {
        return cashierTel;
    }

    public void setCashierTel(String cashierTel) {
        this.cashierTel = cashierTel;
    }

    public String getCashierAddress() {
        return cashierAddress;
    }

    public void setCashierAddress(String cashierAddress) {
        this.cashierAddress = cashierAddress;
    }
}
package com.example.HIS.models;

import java.io.Serializable;
import lombok.Data;

/**
 * departments
 * @author 
 */
@Data
public class Department implements Serializable {
    /**
     * 科室编号
     */
    private String departmentId;

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 科室电话
     */
    private String departmentTel;

    /**
     * 科室地址
     */
    private String departmentAddress;

    private static final long serialVersionUID = 1L;

    public Department(String departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentTel() {
        return departmentTel;
    }

    public void setDepartmentTel(String departmentTel) {
        this.departmentTel = departmentTel;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }
}
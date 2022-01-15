package com.example.HIS.models;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * remain_dept_numbers
 * @author 
 */
@Data
public class RemainDeptNumber implements Serializable {
    private Integer remainDeptNumberId;

    private String departmentId;

    private Date time;

    private Integer number;

    private static final long serialVersionUID = 1L;

    public Integer getRemainDeptNumberId() {
        return remainDeptNumberId;
    }

    public void setRemainDeptNumberId(Integer remainDeptNumberId) {
        this.remainDeptNumberId = remainDeptNumberId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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
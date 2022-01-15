package com.example.HIS.models;

import java.io.Serializable;
import lombok.Data;

/**
 * violate_tables
 * @author 
 */
@Data
public class ViolateTable implements Serializable {
    /**
     * 违约记录编号
     */
    private Integer violateId;

    /**
     * 预约单号
     */
    private Integer reserveId;

    private static final long serialVersionUID = 1L;

    public ViolateTable() {
    }

    public Integer getViolateId() {
        return violateId;
    }

    public void setViolateId(Integer violateId) {
        this.violateId = violateId;
    }

    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }
}
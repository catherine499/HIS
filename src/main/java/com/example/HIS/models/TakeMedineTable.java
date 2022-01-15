package com.example.HIS.models;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * take_medine_tables
 * @author
 */
@Data
public class TakeMedineTable implements Serializable {
    /**
     * 取药单号
     */
    private Integer takeId;

    /**
     * 患者身份证号
     */
    private String patientIdentity;

    /**
     * 药剂师工号
     */
    private String pharmacistId;

    /**
     * 处方编号
     */
    private int prescriptionId;


    /**
     * 取药状态,0待配药,1配药中,2待取药,3已取药
     */
    private Integer takeState;

    /**
     * 开具时间
     */
    private Date billTime;

    /**
     * 取药时间
     */
    private Date takeTime;

    private static final long serialVersionUID = 1L;

    public TakeMedineTable() {
    }

}
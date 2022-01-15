package com.example.HIS.models;

import java.io.Serializable;
import lombok.Data;

/**
 * take_medine_tables
 * @author 
 */
@Data
public class TakeMedineTableKey implements Serializable {
    /**
     * 取药单号
     */
    private Integer takeId;

    /**
     * 药品编号
     */
    private Integer prescriptionId;

    private static final long serialVersionUID = 1L;
}
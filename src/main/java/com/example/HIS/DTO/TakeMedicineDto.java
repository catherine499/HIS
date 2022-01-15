package com.example.HIS.DTO;

import lombok.Data;

import java.util.Date;
@Data
public class TakeMedicineDto {

    private Integer takeId;

    private String patientName;

    private String patientIdentity;

    private String takeState;

    private String mainDoc;

    private String pharDoc;

    private Date billTime;

    private Date takeTime;
}

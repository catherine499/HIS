package com.example.HIS.DTO;

import lombok.Data;

import java.util.Date;
@Data
public class ReturnMedicenDto {
    private Integer prescriptionId;

    private String medicineId;

    private String medicineName;

    private int medicineNumber;

    private Double medicineMoney;

    private int takeState;

}

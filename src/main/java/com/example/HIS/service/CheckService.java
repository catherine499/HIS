package com.example.HIS.service;

import com.example.HIS.models.CheckTable;

public interface CheckService {
    public String getMaxId();

    public Integer create(CheckTable checkTable);

    public CheckTable findById(String checkId);
}

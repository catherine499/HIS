package com.example.HIS.service;

import com.example.HIS.generate.CheckTableDao;
import com.example.HIS.models.CheckTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckServiceImpl implements CheckService{
    @Autowired
    CheckTableDao checkTableDao;

    //
    public String getMaxId(){return checkTableDao.getMaxId();};

    public Integer create(CheckTable checkTable){return checkTableDao.insertSelective(checkTable);}

    public CheckTable findById(String checkId){return checkTableDao.selectByPrimaryKey(Integer.valueOf(checkId));}
}

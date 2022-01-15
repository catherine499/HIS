package com.example.HIS.service;


import com.example.HIS.generate.DoctorDao;
import com.example.HIS.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    DoctorDao doctorDao;

    //
    public Doctor findById(String doctorId){return doctorDao.selectByPrimaryKey(doctorId);}
}

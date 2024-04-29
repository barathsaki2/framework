package com.example.ce1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ce1.model.BARATHEmployee;
import com.example.ce1.repository.BARATHEmployeeRepo;

@Service
public class BARATHEmployeeService {
    @Autowired
    BARATHEmployeeRepo employeeRepo;

    @SuppressWarnings("null")
    public BARATHEmployee setEmployee(BARATHEmployee employee)
    {
        return employeeRepo.save(employee);
    }

    public List<BARATHEmployee> getInnerEmployee()
    {
        return employeeRepo.getByInnerEmployees();
    }

    public List<BARATHEmployee> getLeftOuterEmployee()
    {
        return employeeRepo.getByLeftOuterEmployees();
    }
}

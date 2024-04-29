package com.example.ce1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ce1.model.BARATHEmployee;
import com.example.ce1.service.BARATHEmployeeService;

@RestController
public class BARATHIEmployeeController {
    @Autowired
    BARATHEmployeeService employeeService;

    @PostMapping("/employee")
    public BARATHEmployee setMethod(@RequestBody BARATHEmployee employee)
    {
        return employeeService.setEmployee(employee);
    }

    @GetMapping("/employees-inner-join")
    public List<BARATHEmployee> getInnerMethod()
    {
        return employeeService.getInnerEmployee();
    }

    @GetMapping("/employees-left-outer-join")
    public List<BARATHEmployee> getLeftMethod()
    {
        return employeeService.getLeftOuterEmployee();
    }
}

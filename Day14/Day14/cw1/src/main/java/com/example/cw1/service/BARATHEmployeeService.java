package com.example.cw1.service;

import com.example.cw1.model.BARATHEmployee;
import com.example.cw1.repository.BARATHEmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BARATHEmployeeService {
    private final BARATHEmployeeRepo employeeRepo;

    public BARATHEmployeeService(BARATHEmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public BARATHEmployee createEmployee(BARATHEmployee employee) {
        return employeeRepo.save(employee);
    }

    public List<BARATHEmployee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Optional<BARATHEmployee> getEmployeeById(Long id) {
        return employeeRepo.findById(id);
    }
}

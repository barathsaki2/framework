package com.example.cw1.service;

import com.example.cw1.model.BARATHPayroll;
import com.example.cw1.repository.BARATHPayrollRepo;
import org.springframework.stereotype.Service;

@Service
public class BARATHPayrollService {
    private final BARATHPayrollRepo payrollRepo;

    public BARATHPayrollService(BARATHPayrollRepo payrollRepo) {
        this.payrollRepo = payrollRepo;
    }

    public BARATHPayroll createPayroll(BARATHPayroll payroll) {
        return payrollRepo.save(payroll);
    }

    public BARATHPayroll getPayrollByEmployeeId(Long employeeId) {
        return payrollRepo.findById(employeeId).orElse(null);
    }
}

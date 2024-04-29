package com.example.cw1.controller;

import com.example.cw1.model.BARATHPayroll;
import com.example.cw1.service.BARATHPayrollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/{employeeId}/payroll")
public class BARATHPayrollController {
    private final BARATHPayrollService payrollService;

    public BARATHPayrollController(BARATHPayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping
    public ResponseEntity<BARATHPayroll> createPayrollForEmployee(@PathVariable Long employeeId, @RequestBody BARATHPayroll payroll) {
        BARATHPayroll createdPayroll = payrollService.createPayroll(payroll);
        if (createdPayroll != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPayroll);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping
    public ResponseEntity<BARATHPayroll> getPayrollForEmployee(@PathVariable Long employeeId) {
        BARATHPayroll payroll = payrollService.getPayrollByEmployeeId(employeeId);
        if (payroll != null) {
            return ResponseEntity.ok(payroll);
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}

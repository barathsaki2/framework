package com.example.cw1.controller;

import com.example.cw1.model.BARATHEmployee;
import com.example.cw1.service.BARATHEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class BARATHEmployeeController {
    private final BARATHEmployeeService employeeService;

    public BARATHEmployeeController(BARATHEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<BARATHEmployee> createEmployee(@RequestBody BARATHEmployee employee) {
        BARATHEmployee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping
    public ResponseEntity<List<BARATHEmployee>> getAllEmployees() {
        List<BARATHEmployee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<BARATHEmployee> getEmployeeById(@PathVariable Long employeeId) {
        Optional<BARATHEmployee> employee = employeeService.getEmployeeById(employeeId);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}


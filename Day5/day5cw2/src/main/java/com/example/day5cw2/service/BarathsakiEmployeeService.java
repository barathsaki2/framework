package com.example.day5cw2.service;

import org.springframework.stereotype.Service;

import com.example.day5cw2.model.BarathsakiEmployee;
import com.example.day5cw2.repository.BarathsakiEmployeeRepo;

@Service
public class BarathsakiEmployeeService {
    public BarathsakiEmployeeRepo employeeRepo;
    public BarathsakiEmployeeService(BarathsakiEmployeeRepo employeeRepo)
    {
        this.employeeRepo = employeeRepo;
    }
    public boolean saveEmployee(BarathsakiEmployee employee)
    {
        try
        {
            employeeRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,BarathsakiEmployee employee)
    {
        if(this.getEmployeeById(id)==null)
        {
            return false;
        }
        try{
            employeeRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteEmployee(int id)
    {
        if(this.getEmployeeById(id) == null)
        {
            return false;
        }
        employeeRepo.deleteById(id);
        return true;
    }
    public BarathsakiEmployee getEmployeeById(int id)
    {
        return employeeRepo.findById(id).orElse(null);
    }
}

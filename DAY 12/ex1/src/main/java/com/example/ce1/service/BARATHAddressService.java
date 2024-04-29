package com.example.ce1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ce1.model.BARATHAddress;
import com.example.ce1.repository.BARATHAddressRepo;
import com.example.ce1.repository.BARATHEmployeeRepo;

@Service
public class BARATHAddressService {
    @Autowired
    BARATHAddressRepo addressRepo;
    @Autowired
    BARATHEmployeeRepo employeeRepo;
    public BARATHAddress setAddressById(int id,BARATHAddress address)
    {
        if(employeeRepo.existsById(id))
        {
            addressRepo.setByemployeeId(address.getCity(), address.getStreet(), id);
            return address;
        }
        else
        {
            return null;
        }
    }
}

package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.BARATHStudentDetail;
import com.example.springapp.repository.BARATHStudentDetailRepository;
import com.example.springapp.repository.BARATHStudentRepository;

@Service
public class BARATHStudentDetailService {
    @Autowired
    BARATHStudentDetailRepository studentDetailRepository;
    @Autowired
    BARATHStudentRepository studentRepository;
    public BARATHStudentDetail addStudentDetail(int id,BARATHStudentDetail studentDetail)
    {
        if(studentRepository.existsById(id))
        {
            studentDetailRepository.addStudentDetail(studentDetail.getAddress(),studentDetail.getPhoneNumber(),id);
            return studentDetail;
        }
        else
        return null;
    }
    
    
}

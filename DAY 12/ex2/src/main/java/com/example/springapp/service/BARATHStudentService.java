package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.BARATHStudent;
import com.example.springapp.repository.BARATHStudentRepository;

@Service
public class BARATHStudentService {
    @Autowired
    BARATHStudentRepository studentRepository;
    public BARATHStudent addStudents(BARATHStudent student)
    {
        return studentRepository.save(student);
    }
    public List<BARATHStudent>getStudent()
    {
        return studentRepository.findAll();
    }
    public List<BARATHStudent>getStudentInner()
    {
        return studentRepository.getStudentInner();
    }
    public List<BARATHStudent>getStudentLeftOuter()
    {
        return studentRepository.getStudentsLeftOuter();
    }
    
}

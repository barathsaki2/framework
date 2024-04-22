package com.example.day4cw4.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.day4cw4.model.BarathsakiPatient;
import com.example.day4cw4.services.BarathsakiPatientService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BarathsakiPatientController {
    public BarathsakiPatientService patientService;
    public BarathsakiPatientController(BarathsakiPatientService patientService)
    {
        this.patientService=patientService;
    }
    @PostMapping("/api/patient")
    public ResponseEntity<BarathsakiPatient> postMethodName(@RequestBody BarathsakiPatient patient) {
        if(patientService.savePatient(patient) == false)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<>(patient,HttpStatus.CREATED);
    }
    
    @GetMapping("/api/patient")
    public ResponseEntity<List<BarathsakiPatient>> getMethodName() {
        List<BarathsakiPatient> list =  patientService.getPatients();
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/api/patient/{patientId}")
    public ResponseEntity<BarathsakiPatient> getMethodName(@PathVariable("patientId") int id) {
        BarathsakiPatient p =  patientService.getPatientById(id);
        if(p==null)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
}

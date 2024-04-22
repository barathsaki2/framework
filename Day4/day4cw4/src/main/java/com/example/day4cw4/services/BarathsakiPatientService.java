package com.example.day4cw4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cw4.model.BarathsakiPatient;
import com.example.day4cw4.repository.BarathsakiPatientRepo;

@Service
public class BarathsakiPatientService {
    public BarathsakiPatientRepo patientRepo;
    public BarathsakiPatientService(BarathsakiPatientRepo patientRepo)
    {
        this.patientRepo = patientRepo;
    }
    public boolean savePatient(BarathsakiPatient patient)
    {
        try{
            patientRepo.save(patient);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<BarathsakiPatient> getPatients()
    {
        return patientRepo.findAll();
    }
    public BarathsakiPatient getPatientById(int id)
    {
        Optional<BarathsakiPatient> obj = patientRepo.findById(id);
        return obj.orElse(null);
    }
}

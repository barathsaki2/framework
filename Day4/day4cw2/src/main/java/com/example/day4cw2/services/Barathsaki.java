package com.example.day4cw2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cw2.model.BarathsakiJob;
import com.example.day4cw2.repository.BarathsakiJobRepo;

@Service
public class Barathsaki {
    public BarathsakiJobRepo jobRepo;
    public Barathsaki(BarathsakiJobRepo jobRepo)
    {
        this.jobRepo = jobRepo;
    }
    public boolean saveJob(BarathsakiJob job)
    {
        try{
            jobRepo.save(job);
        } 
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<BarathsakiJob> getJobs()
    {
        return jobRepo.findAll();
    }
    public BarathsakiJob getJobById(int id)
    {
        Optional<BarathsakiJob> obj = jobRepo.findById(id);
        return obj.orElse(null);
    }
}

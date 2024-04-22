package com.example.day5cw3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.day5cw3.model.BarathsakiLanguage;
import com.example.day5cw3.repository.BarathsakiLanguageRepo;

@Service
public class BarathsakiLanguageService {
    private BarathsakiLanguageRepo languageRepo;
    public BarathsakiLanguageService(BarathsakiLanguageRepo languageRepo)
    {
        this.languageRepo=languageRepo;
    }
    public boolean saveLanguage(BarathsakiLanguage language)
    {
        try
        {
            languageRepo.save(language);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<BarathsakiLanguage> getLanguages()
    {
        return languageRepo.findAll();
    }
    public boolean updateLanguage(int id,BarathsakiLanguage language)
    {
        if(getLanguageById(id)==null)
        {
            return false;
        }
        try{
            languageRepo.save(language);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteLanguage(int id)
    {
        if(getLanguageById(id)==null)
        {
            return false;
        }
        languageRepo.deleteById(id);
        return true;
        
    }
    public BarathsakiLanguage getLanguageById(int id)
    {
        return languageRepo.findById(id).orElse(null);
    }

}

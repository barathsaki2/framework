package com.example.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springapp.model.BarathsakiPerson;
import com.example.springapp.repository.BarathsakiPersonRepo;

@Service
public class BarathsakiPersonService {
    public BarathsakiPersonRepo personRepo;

    public BarathsakiPersonService(BarathsakiPersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public boolean savePerson(BarathsakiPerson person) {
        try {
            personRepo.save(person);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<BarathsakiPerson> getPersonByAge(int age) {
        return personRepo.findByAge(age);
    }
}

package com.example.day4cw1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day4cw1.model.Medicine;

public interface MedicineRepo extends JpaRepository<Medicine,Integer>{
    
}

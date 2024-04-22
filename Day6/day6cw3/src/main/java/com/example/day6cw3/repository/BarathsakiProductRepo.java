package com.example.day6cw3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day6cw3.model.BarathsakiProduct;

@Repository
public interface BarathsakiProductRepo extends JpaRepository<BarathsakiProduct,Integer>{
    
}

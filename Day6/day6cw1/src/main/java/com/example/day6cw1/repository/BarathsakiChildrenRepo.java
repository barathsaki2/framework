package com.example.day6cw1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day6cw1.model.BarathsakiChildren;


@Repository
public interface BarathsakiChildrenRepo extends JpaRepository<BarathsakiChildren,Integer>{
    
}

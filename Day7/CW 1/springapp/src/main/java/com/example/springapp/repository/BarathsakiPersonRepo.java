package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.Person;
import java.util.List;


@Repository
public interface BarathsakiPersonRepo extends JpaRepository<Person,Integer>{

    List<Person> findByAge(int age);
    
}

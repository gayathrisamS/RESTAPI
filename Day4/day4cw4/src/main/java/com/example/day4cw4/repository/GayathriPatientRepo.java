package com.example.day4cw4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day4cw4.model.GayathriPatient;

@Repository
public interface GayathriPatientRepo extends JpaRepository<GayathriPatient,Integer>{
    
}

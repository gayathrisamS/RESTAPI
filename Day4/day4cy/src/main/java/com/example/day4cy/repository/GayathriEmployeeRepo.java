package com.example.day4cy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day4cy.model.GayathriEmployee;


@Repository
public interface GayathriEmployeeRepo extends JpaRepository<GayathriEmployee,Integer>{
    
}

package com.example.relation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.relation.model.GayathriStudent;

@Repository
public interface GayathriStudentRepository extends JpaRepository<GayathriStudent,Integer>{
    
}

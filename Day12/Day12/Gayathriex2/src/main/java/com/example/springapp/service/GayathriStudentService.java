package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.GayathriStudent;
import com.example.springapp.model.GayathriStudent;
import com.example.springapp.repository.GayathriStudentRepository;
import com.example.springapp.repository.GayathriStudentRepository;

@Service
public class GayathriStudentService {
    @Autowired
    GayathriStudentRepository studentRepository;
    public GayathriStudent addStudents(GayathriStudent student)
    {
        return studentRepository.save(student);
    }
    public List<GayathriStudent>getStudent()
    {
        return studentRepository.findAll();
    }
    public List<GayathriStudent>getStudentInner()
    {
        return studentRepository.getStudentInner();
    }
    public List<GayathriStudent>getStudentLeftOuter()
    {
        return studentRepository.getStudentsLeftOuter();
    }
    
}

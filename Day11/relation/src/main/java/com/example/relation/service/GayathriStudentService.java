package com.example.relation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.relation.model.GayathriStudent;
import com.example.relation.repository.GayathriStudentRepository;

@Service
public class GayathriStudentService {
    public GayathriStudentRepository studentRepository;
    public GayathriStudentService(GayathriStudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }
    public GayathriStudent saveStudent(GayathriStudent student)
    {
        return studentRepository.save(student);
    }
    public List<GayathriStudent> getStudents()
    {
        return studentRepository.findAll();
    }
}

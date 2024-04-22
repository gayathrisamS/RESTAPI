package com.example.relation.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.relation.model.GayathriStudent;
import com.example.relation.service.GayathriStudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class GayathriStudentController {
    public GayathriStudentService studentService;
    public GayathriStudentController(GayathriStudentService studentService)
    {
        this.studentService = studentService;
    }
    @PostMapping("/api/student")
    public GayathriStudent postMethodName(@RequestBody GayathriStudent student) {
        return studentService.saveStudent(student);
    }
    @GetMapping("/api/student")
    public List<GayathriStudent> getMethodName() {
        return studentService.getStudents();
    }
    
}

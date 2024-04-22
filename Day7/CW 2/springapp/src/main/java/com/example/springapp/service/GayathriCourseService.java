package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.GayathriCourse;
import com.example.springapp.repository.GayathriCourseRepo;

@Service
public class GayathriCourseService {
    @Autowired
    private GayathriCourseRepo rep;

    public boolean post(GayathriCourse person)
    {
        try
        {
            rep.save(person);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public List<GayathriCourse> getAll()
    {
        return rep.findAll();
    }

    public List<GayathriCourse> getbyAge(String courseName)
    {
        return rep.findByCourseName(courseName);
    }
    
}

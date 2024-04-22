package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.GayathriCourse;
import java.util.List;


@Repository
public interface GayathriCourseRepo extends JpaRepository<GayathriCourse,Integer>{

    List<GayathriCourse> findByCourseName(String courseName);
    
}

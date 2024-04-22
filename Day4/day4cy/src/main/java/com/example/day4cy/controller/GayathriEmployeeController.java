package com.example.day4cy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day4cy.model.GayathriEmployee;
import com.example.day4cy.service.GayathriEmployeeService;

@RestController
public class GayathriEmployeeController {
    public GayathriEmployeeService employeeService;
    public GayathriEmployeeController(GayathriEmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }
    @PostMapping("/api/employee")
    public ResponseEntity<GayathriEmployee> postMethodName(@RequestBody GayathriEmployee employee) {
        if(employeeService.saveEmployee(employee))
        {
            return new ResponseEntity<>(employee,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/employee")
    public ResponseEntity<List<GayathriEmployee>> getMethodName() {
        List<GayathriEmployee> list =  employeeService.getEmployees();
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/api/employee/{employeeId}")
    public ResponseEntity<GayathriEmployee> getMethodName(@PathVariable("employeeId") int id) {
        GayathriEmployee p =  employeeService.getEmployeeById(id);
        if(p==null)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
}

package com.example.ce1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ce1.model.GayathriEmployee;
import com.example.ce1.service.GayathriEmployeeService;

@RestController
public class GayathriEmployeeController {
    @Autowired
    GayathriEmployeeService employeeService;

    @PostMapping("/employee")
    public GayathriEmployee setMethod(@RequestBody GayathriEmployee employee)
    {
        return employeeService.setEmployee(employee);
    }

    @GetMapping("/employees-inner-join")
    public List<GayathriEmployee> getInnerMethod()
    {
        return employeeService.getInnerEmployee();
    }

    @GetMapping("/employees-left-outer-join")
    public List<GayathriEmployee> getLeftMethod()
    {
        return employeeService.getLeftOuterEmployee();
    }
}

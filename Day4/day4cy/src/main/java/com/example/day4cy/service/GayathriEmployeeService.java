package com.example.day4cy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cy.model.GayathriEmployee;
import com.example.day4cy.repository.GayathriEmployeeRepo;

@Service
public class GayathriEmployeeService {
    public GayathriEmployeeRepo employeeRepo;
    public GayathriEmployeeService(GayathriEmployeeRepo employeeRepo)
    {
        this.employeeRepo=employeeRepo;
    }
    public boolean saveEmployee(GayathriEmployee employee)
    {
        try{
            employeeRepo.save(employee);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<GayathriEmployee> getEmployees()
    {
        return employeeRepo.findAll();
    }
    public GayathriEmployee getEmployeeById(int id)
    {
        Optional<GayathriEmployee> obj = employeeRepo.findById(id);
        return obj.orElse(null);
    }
}

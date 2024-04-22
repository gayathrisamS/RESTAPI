package com.example.day5cw2.service;

import org.springframework.stereotype.Service;

import com.example.day5cw2.model.GayathriEmployee;
import com.example.day5cw2.repository.GayathriEmployeeRepo;

@Service
public class GayathriEmployeeService {
    public GayathriEmployeeRepo employeeRepo;
    public GayathriEmployeeService(GayathriEmployeeRepo employeeRepo)
    {
        this.employeeRepo = employeeRepo;
    }
    public boolean saveEmployee(GayathriEmployee employee)
    {
        try
        {
            employeeRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,GayathriEmployee employee)
    {
        if(this.getEmployeeById(id)==null)
        {
            return false;
        }
        try{
            employeeRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteEmployee(int id)
    {
        if(this.getEmployeeById(id) == null)
        {
            return false;
        }
        employeeRepo.deleteById(id);
        return true;
    }
    public GayathriEmployee getEmployeeById(int id)
    {
        return employeeRepo.findById(id).orElse(null);
    }
}

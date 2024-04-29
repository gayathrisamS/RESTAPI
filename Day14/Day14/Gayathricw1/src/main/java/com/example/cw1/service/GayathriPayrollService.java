package com.example.cw1.service;

import com.example.cw1.model.GayathriPayroll;
import com.example.cw1.repository.GayathriPayrollRepo;
import org.springframework.stereotype.Service;

@Service
public class GayathriPayrollService {
    private final GayathriPayrollRepo payrollRepo;

    public GayathriPayrollService(GayathriPayrollRepo payrollRepo) {
        this.payrollRepo = payrollRepo;
    }

    public GayathriPayroll createPayroll(GayathriPayroll payroll) {
        return payrollRepo.save(payroll);
    }

    public GayathriPayroll getPayrollByEmployeeId(Long employeeId) {
        return payrollRepo.findById(employeeId).orElse(null);
    }
}

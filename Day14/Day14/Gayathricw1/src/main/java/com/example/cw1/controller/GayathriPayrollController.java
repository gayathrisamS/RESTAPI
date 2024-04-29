package com.example.cw1.controller;

import com.example.cw1.model.GayathriPayroll;
import com.example.cw1.service.GayathriPayrollService;
import com.example.cw1.service.GayathriPayrollService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/{employeeId}/payroll")
public class GayathriPayrollController {
    private final GayathriPayrollService payrollService;

    public GayathriPayrollController(GayathriPayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping
    public ResponseEntity<GayathriPayroll> createPayrollForEmployee(@PathVariable Long employeeId, @RequestBody GayathriPayroll payroll) {
        GayathriPayroll createdPayroll = payrollService.createPayroll(payroll);
        if (createdPayroll != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPayroll);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping
    public ResponseEntity<GayathriPayroll> getPayrollForEmployee(@PathVariable Long employeeId) {
        GayathriPayroll payroll = payrollService.getPayrollByEmployeeId(employeeId);
        if (payroll != null) {
            return ResponseEntity.ok(payroll);
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}

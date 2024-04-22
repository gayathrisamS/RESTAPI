package com.example.day4cw1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.day4cw1.model.GayathriMedicine;
import com.example.day4cw1.services.GayathriMedicineService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class GayathriMedicineController {

    private GayathriMedicineService medicineService;

    public GayathriMedicineController(GayathriMedicineService medicineService)
    {
        this.medicineService = medicineService;
    }
    @PostMapping("/api/medicine")
    public ResponseEntity<GayathriMedicine> postMethodName(@RequestBody GayathriMedicine medicine) {
        
        if(medicineService.saveMedicine(medicine)==false)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(medicine,HttpStatus.CREATED);
    }

    @GetMapping("/api/medicines")
    public ResponseEntity<List<GayathriMedicine>> getMethodName() {
        List<GayathriMedicine> list = medicineService.getMedicines();
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/api/medicine/{medicineId}")
    public ResponseEntity<GayathriMedicine> getMedicineById(@PathVariable("medicineId") int id) {
        GayathriMedicine m =  medicineService.MedicineById(id);
        if(m==null)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(m,HttpStatus.OK);
    }
    
    
}

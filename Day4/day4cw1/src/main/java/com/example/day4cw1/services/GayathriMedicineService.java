package com.example.day4cw1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cw1.model.GayathriMedicine;
import com.example.day4cw1.repository.GayathriMedicineRepo;

@Service
public class GayathriMedicineService {
    public GayathriMedicineRepo medicineRepo;
    public GayathriMedicineService(GayathriMedicineRepo medicineRepo)
    {
        this.medicineRepo = medicineRepo;
    }
    public boolean saveMedicine(GayathriMedicine medicine)
    {
        try{
            medicineRepo.save(medicine);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<GayathriMedicine> getMedicines()
    {
        return medicineRepo.findAll();
    }

    public GayathriMedicine MedicineById(int id)
    {
        Optional<GayathriMedicine> obj = medicineRepo.findById(id);
        return obj.orElse(new GayathriMedicine());
    }

}

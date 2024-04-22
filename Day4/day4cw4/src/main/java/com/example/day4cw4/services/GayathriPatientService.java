package com.example.day4cw4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cw4.model.GayathriPatient;
import com.example.day4cw4.repository.GayathriPatientRepo;

@Service
public class GayathriPatientService {
    public GayathriPatientRepo patientRepo;
    public GayathriPatientService(GayathriPatientRepo patientRepo)
    {
        this.patientRepo = patientRepo;
    }
    public boolean savePatient(GayathriPatient patient)
    {
        try{
            patientRepo.save(patient);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<GayathriPatient> getPatients()
    {
        return patientRepo.findAll();
    }
    public GayathriPatient getPatientById(int id)
    {
        Optional<GayathriPatient> obj = patientRepo.findById(id);
        return obj.orElse(null);
    }
}

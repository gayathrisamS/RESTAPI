package com.example.day4cw2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cw2.model.GayathriJob;
import com.example.day4cw2.repository.GayathriJobRepo;

@Service
public class GayathriJobService {
    public GayathriJobRepo jobRepo;
    public GayathriJobService(GayathriJobRepo jobRepo)
    {
        this.jobRepo = jobRepo;
    }
    public boolean saveJob(GayathriJob job)
    {
        try{
            jobRepo.save(job);
        } 
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<GayathriJob> getJobs()
    {
        return jobRepo.findAll();
    }
    public GayathriJob getJobById(int id)
    {
        Optional<GayathriJob> obj = jobRepo.findById(id);
        return obj.orElse(null);
    }
}

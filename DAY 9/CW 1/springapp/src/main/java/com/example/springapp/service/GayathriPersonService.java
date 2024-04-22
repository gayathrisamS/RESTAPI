package com.example.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springapp.model.GayathriPerson;
import com.example.springapp.repository.GayathriPersonRepo;

@Service
public class GayathriPersonService {
    public GayathriPersonRepo personRepo;

    public GayathriPersonService(GayathriPersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public boolean savePerson(GayathriPerson person) {
        try {
            personRepo.save(person);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<GayathriPerson> getPersonByAge(int age) {
        return personRepo.findByAge(age);
    }
}

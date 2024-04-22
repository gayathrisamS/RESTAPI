package com.example.day5cw3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.day5cw3.model.GayathriLanguage;
import com.example.day5cw3.repository.GayathriLanguageRepo;

@Service
public class GayathriLanguageService {
    private GayathriLanguageRepo languageRepo;
    public GayathriLanguageService(GayathriLanguageRepo languageRepo)
    {
        this.languageRepo=languageRepo;
    }
    public boolean saveLanguage(GayathriLanguage language)
    {
        try
        {
            languageRepo.save(language);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<GayathriLanguage> getLanguages()
    {
        return languageRepo.findAll();
    }
    public boolean updateLanguage(int id,GayathriLanguage language)
    {
        if(getLanguageById(id)==null)
        {
            return false;
        }
        try{
            languageRepo.save(language);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteLanguage(int id)
    {
        if(getLanguageById(id)==null)
        {
            return false;
        }
        languageRepo.deleteById(id);
        return true;
        
    }
    public GayathriLanguage getLanguageById(int id)
    {
        return languageRepo.findById(id).orElse(null);
    }

}

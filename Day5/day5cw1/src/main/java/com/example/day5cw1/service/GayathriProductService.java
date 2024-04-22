package com.example.day5cw1.service;

import org.springframework.stereotype.Service;

import com.example.day5cw1.model.GayathriProduct;
import com.example.day5cw1.repository.GayathriProductRepo;

@Service
public class GayathriProductService {
    public GayathriProductRepo productRepo;
    public GayathriProductService(GayathriProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }
    public boolean saveProduct(GayathriProduct product)
    {
        try
        {
            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,GayathriProduct product)
    {
        if(this.getProductById(id)==null)
        {
            return false;
        }
        try{
            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteProduct(int id)
    {
        if(this.getProductById(id) == null)
        {
            return false;
        }
        productRepo.deleteById(id);
        return true;
    }
    public GayathriProduct getProductById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
}

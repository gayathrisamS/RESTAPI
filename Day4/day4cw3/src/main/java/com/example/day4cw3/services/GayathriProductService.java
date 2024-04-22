package com.example.day4cw3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cw3.model.GayathriProduct;
import com.example.day4cw3.repository.GayathriProductRepo;

@Service
public class GayathriProductService {
    public GayathriProductRepo productRepo;
    public GayathriProductService(GayathriProductRepo productRepo)
    {
        this.productRepo=productRepo;
    }
    public boolean saveProduct(GayathriProduct product)
    {
        try{
            productRepo.save(product);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<GayathriProduct> getProducts()
    {
        return productRepo.findAll();
    }
    public GayathriProduct getProductById(int id)
    {
        Optional<GayathriProduct> obj = productRepo.findById(id);
        return obj.orElse(new GayathriProduct());
    }
}

package com.example.day6cw3.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6cw3.model.GayathriProduct;
import com.example.day6cw3.repository.GayathriProductRepo;

@Service
public class GayathriProductService {
    public GayathriProductRepo productRepo;
    public GayathriProductService(GayathriProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }
    public boolean postProduct(GayathriProduct product)
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
    public List<GayathriProduct> pagination(int offset,int size)
    {
        return productRepo.findAll(PageRequest.of(offset, size)).getContent();
    }
    public List<GayathriProduct> sortPagination(int offset,int size,String field)
    {
        return productRepo.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }
    public GayathriProduct getProductById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
}

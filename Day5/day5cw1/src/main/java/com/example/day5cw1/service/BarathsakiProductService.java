package com.example.day5cw1.service;

import org.springframework.stereotype.Service;

import com.example.day5cw1.model.BarathsakiProduct;
import com.example.day5cw1.repository.BarathsakiProductRepo;

@Service
public class BarathsakiProductService {
    public BarathsakiProductRepo productRepo;
    public BarathsakiProductService(BarathsakiProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }
    public boolean saveProduct(BarathsakiProduct product)
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
    public boolean updateDetails(int id,BarathsakiProduct product)
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
    public BarathsakiProduct getProductById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
}

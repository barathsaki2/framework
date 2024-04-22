package com.example.day4cw3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cw3.model.BarathsakiProduct;
import com.example.day4cw3.repository.BarathsakiProductRepo;

@Service
public class BarathsakiProductService {
    public BarathsakiProductRepo productRepo;
    public BarathsakiProductService(BarathsakiProductRepo productRepo)
    {
        this.productRepo=productRepo;
    }
    public boolean saveProduct(BarathsakiProduct product)
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
    public List<BarathsakiProduct> getProducts()
    {
        return productRepo.findAll();
    }
    public BarathsakiProduct getProductById(int id)
    {
        Optional<BarathsakiProduct> obj = productRepo.findById(id);
        return obj.orElse(new BarathsakiProduct());
    }
}

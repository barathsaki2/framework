package com.example.day6cw3.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6cw3.model.BarathsakiProduct;
import com.example.day6cw3.repository.BarathsakiProductRepo;

@Service
public class BarathsakiProductService {
    public BarathsakiProductRepo productRepo;
    public BarathsakiProductService(BarathsakiProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }
    public boolean postProduct(BarathsakiProduct product)
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
    public List<BarathsakiProduct> pagination(int offset,int size)
    {
        return productRepo.findAll(PageRequest.of(offset, size)).getContent();
    }
    public List<BarathsakiProduct> sortPagination(int offset,int size,String field)
    {
        return productRepo.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }
    public BarathsakiProduct getProductById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
}

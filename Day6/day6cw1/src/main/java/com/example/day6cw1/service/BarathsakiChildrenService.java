package com.example.day6cw1.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6cw1.model.BarathsakiChildren;
import com.example.day6cw1.repository.BarathsakiChildrenRepo;

@Service
public class BarathsakiChildrenService {
    public BarathsakiChildrenRepo childrenRepo;
    public BarathsakiChildrenService(BarathsakiChildrenRepo childrenRepo)
    {
        this.childrenRepo = childrenRepo;
    }
    public boolean postChildren(BarathsakiChildren children)
    {
        try{

            childrenRepo.save(children);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<BarathsakiChildren> getSortedChildrens(String field)
    {
        return childrenRepo.findAll(Sort.by(field));
    }
    public List<BarathsakiChildren> getPaginationChildrens(int offset,int size)
    {
        return childrenRepo.findAll(PageRequest.of(offset, size)).getContent();
        // return childrenRepo.findAll(Pageable.ofSize(size).withPage(offset)).getContent();
                        
    }
    public List<BarathsakiChildren> getSortedPaginationChildrens(int offset,int size,String field)
    {
        return childrenRepo.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }
}

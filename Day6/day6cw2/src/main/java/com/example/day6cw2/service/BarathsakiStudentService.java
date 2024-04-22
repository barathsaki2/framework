package com.example.day6cw2.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6cw2.model.BarathsakiStudent;
import com.example.day6cw2.repository.BarathsakiStudentRepo;

@Service
public class BarathsakiStudentService {
    public BarathsakiStudentRepo studentRepo;
    public BarathsakiStudentService(BarathsakiStudentRepo studentRepo)
    {
        this.studentRepo = studentRepo;
    }
    public boolean postStudent(BarathsakiStudent student)
    {
        try{

            studentRepo.save(student);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<BarathsakiStudent> paginationStudents(int pageno,int size)
    {
        return studentRepo.findAll(PageRequest.of(pageno, size)).getContent();
    }
    public List<BarathsakiStudent>  sortPaginationStudents(int pageno,int size,String field)
    {
        return studentRepo.findAll(PageRequest.of(pageno, size,Sort.by(field))).getContent();
    }
}

package com.example.day6cw2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day6cw2.model.BarathsakiStudent;
import com.example.day6cw2.service.BarathsakiStudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BarathsakiStudentController {
    public BarathsakiStudentService studentService;
    public BarathsakiStudentController(BarathsakiStudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping("/api/student")
    public ResponseEntity<BarathsakiStudent> postMethodName(@RequestBody BarathsakiStudent student) {
        if(studentService.postStudent(student))
        {
            return new ResponseEntity<>(student,HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/student")
    public ResponseEntity<List<BarathsakiStudent>> getMethodName(@RequestParam("pageNo") int pageno , @RequestParam("pageSize") int size) {
        List<BarathsakiStudent> list = studentService.paginationStudents(pageno,size);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    
    @GetMapping("/api/student/sort")
    public ResponseEntity<List<BarathsakiStudent>> getsortPagination(@RequestParam("pageNo") int pageno , @RequestParam("pageSize") int size,@RequestParam("sortBy") String field) {
        List<BarathsakiStudent> list = studentService.sortPaginationStudents(pageno, size, field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


    
}

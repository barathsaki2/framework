package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.springapp.model.BarathsakiStudent;
import com.example.springapp.service.BarathsakiStudentService;

@RestController
public class BarathsakiStudentController {
    @Autowired
    private BarathsakiStudentService studentService;

    @PostMapping("/api/student")
    public ResponseEntity<BarathsakiStudent> post(@RequestBody BarathsakiStudent student) {
        if (studentService.post(student)) {
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/student/markGreaterThan/{marks}")
    public ResponseEntity<List<BarathsakiStudent>> getGreater(@PathVariable int marks) {
        List<BarathsakiStudent> list = studentService.getGreater(marks);
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/student/markLessThan/{marks}")
    public ResponseEntity<List<BarathsakiStudent>> getLesser(@PathVariable int marks) {
        List<BarathsakiStudent> list = studentService.getLesser(marks);
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

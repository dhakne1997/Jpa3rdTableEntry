package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.Student;
import com.service.StudentService;

@RestController
@RequestMapping("/tableA")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public Student getTableA(@PathVariable Long id) {
        return studentService.getTableA(id);
    }
}

package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.Department;
import com.entity.Student;
import com.producer.KafkaProducerService;
import com.service.StudentService;

@RestController
@RequestMapping("/tableA")
public class StudentController {

    @Autowired
    private StudentService studentService;
 
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping("/{id}")
    public Student getTableA(@PathVariable Long id) {
        return studentService.getTableA(id);
    }
    
    @PostMapping("/insert")
    public Student insert(@RequestBody Student student){
    	kafkaProducerService.sendStudentDetails(student);
        return studentService.save(student);
    }
}

package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.Department;
import com.producer.KafkaProducerService;
import com.service.DepartmentService;

@RestController
@RequestMapping("/tableB")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @Autowired
    private KafkaProducerService kafkaProducerService;
    
    @GetMapping("/{id}")
    public Department getTableB(@PathVariable Long id) {
        return departmentService.getTableB(id);
    }
    
    @PostMapping("/insert")
    public Department insert(@RequestBody Department department){
    	kafkaProducerService.sendDepartmentDetails(department);
        return departmentService.save(department);
    }
}


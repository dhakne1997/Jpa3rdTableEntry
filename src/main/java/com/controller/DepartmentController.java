package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.Department;
import com.service.DepartmentService;

@RestController
@RequestMapping("/tableB")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{id}")
    public Department getTableB(@PathVariable Long id) {
        return departmentService.getTableB(id);
    }
}


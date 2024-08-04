package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.Student;
import com.service.TableAService;

@RestController
@RequestMapping("/tableA")
public class TableAController {

    @Autowired
    private TableAService tableAService;

    @GetMapping("/{id}")
    public Student getTableA(@PathVariable Long id) {
        return tableAService.getTableA(id);
    }
}

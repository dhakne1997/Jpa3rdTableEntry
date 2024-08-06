package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.Department;
import com.service.TableBService;

@RestController
@RequestMapping("/tableB")
public class TableBController {

    @Autowired
    private TableBService tableBService;

    @GetMapping("/{id}")
    public Department getTableB(@PathVariable Long id) {
        return tableBService.getTableB(id);
    }
}


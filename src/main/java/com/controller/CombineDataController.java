package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.CombineData;
import com.service.TableCService;

@RestController
@RequestMapping("/tableC")
public class TableCController {

    @Autowired
    private TableCService tableCService;

    @PostMapping("/create")
    public CombineData createTableC(@RequestParam Long tableAId, @RequestParam Long tableBId) {
        return tableCService.createTableC(tableAId, tableBId);
    }
}


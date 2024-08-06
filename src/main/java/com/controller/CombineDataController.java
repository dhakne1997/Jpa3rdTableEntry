package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.CombineData;
import com.service.CombineDataService;

@RestController
@RequestMapping("/tableC")
public class CombineDataController {

    @Autowired
    private CombineDataService combineDataService;

    @PostMapping("/create")
    public CombineData createTableC(@RequestParam Long tableAId, @RequestParam Long tableBId) {
        return combineDataService.createTableC(tableAId, tableBId);
    }
}


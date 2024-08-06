package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Department;
import com.repo.TableBRepository;

@Service
public class TableBService {

    @Autowired
    private TableBRepository tableBRepository;

    public Department getTableB(Long id) {
        return tableBRepository.findById(id).orElse(null);
    }
}


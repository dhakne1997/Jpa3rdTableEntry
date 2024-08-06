package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.repo.TableARepository;

@Service
public class TableAService {

    @Autowired
    private TableARepository tableARepository;

    public Student getTableA(Long id) {
        return tableARepository.findById(id).orElse(null);
    }
}


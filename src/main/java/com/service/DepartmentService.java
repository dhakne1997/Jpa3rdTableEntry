package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Department;
import com.repo.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department getTableB(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

	public Department save(Department department) {
		return departmentRepository.save(department);
	}
}


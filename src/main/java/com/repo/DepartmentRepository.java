package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}


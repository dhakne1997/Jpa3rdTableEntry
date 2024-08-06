package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Department;

public interface TableBRepository extends JpaRepository<Department, Long> {
}


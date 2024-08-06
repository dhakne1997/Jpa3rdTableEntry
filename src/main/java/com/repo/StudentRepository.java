package com.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Student;

public interface TableARepository extends JpaRepository<Student, Long> {
}


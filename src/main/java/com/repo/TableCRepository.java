package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.CombineData;

public interface TableCRepository extends JpaRepository<CombineData, Long> {
}


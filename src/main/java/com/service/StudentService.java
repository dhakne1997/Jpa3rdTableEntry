package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Department;
import com.entity.Student;
import com.repo.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getTableA(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

	public Student save(Student student) {
		return studentRepository.save(student);
	}
}


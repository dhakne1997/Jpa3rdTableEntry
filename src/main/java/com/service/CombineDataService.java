package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.entity.Department;
import com.entity.CombineData;
import com.repo.TableCRepository;

@Service
public class CombineDataService {

    @Autowired
    private TableCRepository tableCRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private DepartmentService departmentService;

    public CombineData createTableC(Long tableAId, Long tableBId) {
        Student student = studentService.getTableA(tableAId);
        Department department = departmentService.getTableB(tableBId);

        if (student != null && department != null) {
            CombineData combineData = new CombineData();
            combineData.setStudentA1(student.getName());
            combineData.setStudentA2(student.getEmail());
            combineData.setDepartmentB1(department.getDeptName());
            combineData.setDepartmentB2(department.getLocation());
            return tableCRepository.save(combineData);
        }

        return null;
    }
}

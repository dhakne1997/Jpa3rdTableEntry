package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.entity.Department;
import com.entity.CombineData;
import com.repo.TableCRepository;

@Service
public class TableCService {

    @Autowired
    private TableCRepository tableCRepository;
    @Autowired
    private TableAService tableAService;
    @Autowired
    private TableBService tableBService;

    public CombineData createTableC(Long tableAId, Long tableBId) {
        Student student = tableAService.getTableA(tableAId);
        Department department = tableBService.getTableB(tableBId);

        if (student != null && department != null) {
            CombineData combineData = new CombineData();
            combineData.setAttributeFromA1(student.getName());
            combineData.setAttributeFromA2(student.getEmail());
            combineData.setAttributeFromB1(department.getDeptName());
            combineData.setAttributeFromB2(department.getLocation());
            return tableCRepository.save(combineData);
        }

        return null;
    }
}

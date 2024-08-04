package com.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CombineData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String attributeFromA1;
    private String attributeFromA2;
    private String attributeFromB1;
    private String attributeFromB2;

//    private Long id;
//    private String attribute1;
//    private String attribute2;
//    private String attribute3;
//    private String attribute4;
}


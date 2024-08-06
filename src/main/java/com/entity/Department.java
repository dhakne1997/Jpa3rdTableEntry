package com.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity

@Table(name="department_")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deptName;
    private String location;
    private String head;
    private int numOfFaculties;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public int getNumOfFaculties() {
		return numOfFaculties;
	}
	public void setNumOfFaculties(int numOfFaculties) {
		this.numOfFaculties = numOfFaculties;
	}
	public Department(Long id, String deptName, String location, String head, int numOfFaculties) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.location = location;
		this.head = head;
		this.numOfFaculties = numOfFaculties;
	}

}


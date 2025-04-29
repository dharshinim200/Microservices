package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	private int empId;
	private String empName;
	private int empSal;
	private int departmentId;

}

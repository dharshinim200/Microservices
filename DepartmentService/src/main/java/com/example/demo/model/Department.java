package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // to generate setter and getter and toString
@Entity // for table
@Table(name = "department_info")
@NoArgsConstructor
@AllArgsConstructor
public class Department {

	@Id // primary key
	@Column(name = "deptno") // change a col name into the table
	private int departmentId;
	@Column(name = "deptname")
	private String departmentName;
	@Column(name = "location")
	private String departmentLocation;
}

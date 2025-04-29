package com.example.demo.service;

import java.util.List;

import com.example.demo.exceptions.DepartmentNotFound;
import com.example.demo.model.Department;

public interface DepartmentService {

	// declaring the methods for the service impl in interface

	public abstract String saveDepartment(Department department);

	public abstract Department updateDepartment(Department department);

	// we are using optional keyword for this class (It may or may not be null)
	/* while getting the dept if there is no id which we entered then it should
	   throw the exception */
	public abstract Department getDepartment(int departmentId) throws DepartmentNotFound;

	public abstract List<Department> getAllDepartments();
	
	public abstract String deleteDepartment(int departmentId);
}

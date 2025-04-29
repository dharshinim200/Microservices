package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmpDeptRequestDTO;
import com.example.demo.dto.EmpDeptResponseDTO;
import com.example.demo.model.Employee;

public interface EmployeeService {

	public abstract String saveEmployee(EmpDeptRequestDTO employee);

	public abstract Employee updateEmployee(Employee employee);

	public abstract EmpDeptResponseDTO getEmployee(int employeeId);

	public abstract List<Employee> getAllEmployees();

	public abstract String deleteEmployee(int employeeId);

}

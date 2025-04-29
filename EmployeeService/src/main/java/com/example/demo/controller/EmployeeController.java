package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmpDeptRequestDTO;
import com.example.demo.dto.EmpDeptResponseDTO;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping("/save")
	public String saveEmployee(@RequestBody EmpDeptRequestDTO employeeDept) {
		return service.saveEmployee(employeeDept);
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}

	@GetMapping("/fetchById/{eid}")
	public EmpDeptResponseDTO getEmployee(@PathVariable("eid") int employeeId) {
		return service.getEmployee(employeeId);
	}

	@GetMapping("/getAll")
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
	@DeleteMapping("/deleteById/{did}")
	public String deleteEmployee(@PathVariable("did") int employeeId) {
		return service.deleteEmployee(employeeId);
	}
	
}

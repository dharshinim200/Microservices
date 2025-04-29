package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.DepartmentNotFound;
import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("/department") // to access url the particular class
public class DepartmentController {

	@Autowired
	DepartmentService service;

	@PostMapping("/save")
	public String saveDepartment(@RequestBody Department department) { // json obj to java obj and pass it to dept so
																		// requestbody are used
		return service.saveDepartment(department);
	}

	@PutMapping("/update")
	public Department updateDepartment(@RequestBody Department department) { //
		return service.updateDepartment(department);
	}

	@GetMapping("/fetchById/{did}")
	public Department getDepartment(@PathVariable("did") int departmentId) throws DepartmentNotFound {
		return service.getDepartment(departmentId);
	}

	@GetMapping("/fetchAll")
	public List<Department> getAllDepartments() {
		return service.getAllDepartments();
	}
	
	@DeleteMapping("/deleteById/{ded}")
	public String deleteDepartment(@PathVariable("ded")int departmentId) {
		return service.deleteDepartment(departmentId);
	}

}

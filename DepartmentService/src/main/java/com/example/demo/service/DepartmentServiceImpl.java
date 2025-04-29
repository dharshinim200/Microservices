package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.DepartmentNotFound;
import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
//implemented the interface and add unimplemented methods
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository repository;

	@Override
	public String saveDepartment(Department department) {
		repository.save(department);
		return "Saved Successfully";
	}

	@Override
	public Department updateDepartment(Department department) {

		return repository.save(department);
	}

	@Override
	public Department getDepartment(int departmentId) throws DepartmentNotFound {
		// used optional method bcz the id may or may not be empty
		Optional<Department> optional = repository.findById(departmentId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new DepartmentNotFound("Invaild Department Id!!");
		}
		// return repository.findById(departmentId).get();
	}

	@Override
	public List<Department> getAllDepartments() {

		return repository.findAll();
	}

	@Override
	public String deleteDepartment(int departmentId) {

		 repository.deleteById(departmentId);
		 return "delete successfully";
	}

}

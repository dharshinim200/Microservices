package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.Department;
import com.example.demo.dto.EmpDeptRequestDTO;
import com.example.demo.dto.EmpDeptResponseDTO;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;
	@Autowired
	RestTemplate restTemplate;

	@Override
	public String saveEmployee(EmpDeptRequestDTO employeeDept) {
		repository.save(employeeDept.getEmp());

		String response = restTemplate.postForObject("http://DEPARTMENTSERVICE/department/save", employeeDept.getDept(),
				String.class);
		if (response.equals("Saved Successfully"))
			return "Employee Saved !!!";
		else
			return "Something went wrong!!!";
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		return repository.save(employee);
	}

	@Override
	public EmpDeptResponseDTO getEmployee(int employeeId) {

		Employee emp = repository.findById(employeeId).get();
		int deptno = emp.getDepartmentId();
		Department dept = restTemplate.getForObject("http://DEPARTMENTSERVICE/department/fetchById/" + deptno,
				Department.class);
		EmpDeptResponseDTO responseDTO = new EmpDeptResponseDTO(emp, dept);
		return responseDTO;
	}

	@Override
	public List<Employee> getAllEmployees() {

		return repository.findAll();
	}

	@Override
	public String deleteEmployee(int employeeId) {

		Optional<Employee> optional = repository.findById(employeeId);

		int deptno = optional.get().getDepartmentId();
		repository.deleteById(employeeId);
		restTemplate.delete("http://DEPARTMENTSERVICE/department/deleteById/" + deptno);

		return "delete successfully";
	}

}

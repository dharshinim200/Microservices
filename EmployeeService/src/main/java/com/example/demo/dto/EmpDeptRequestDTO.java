package com.example.demo.dto;

import com.example.demo.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpDeptRequestDTO {

		private Employee emp;
		private Department dept;

}

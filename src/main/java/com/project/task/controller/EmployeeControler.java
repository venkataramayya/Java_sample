package com.project.task.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.task.employee.Employee;
import com.project.task.service.EmployeeService;

@RestController
public class EmployeeControler {

	@Autowired
	private EmployeeService service;

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return service.employees();

	}

	@PostMapping("/employees")
	public List<Employee> createEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@PutMapping("/employees")
	public List<Employee> updateEmployee(@RequestBody Employee employee) {
		employee.setEmpStatus("Active");
		return service.saveEmployee(employee);

	}

	@DeleteMapping("/employees/{id}")
	public Employee deleteEmployee(@PathVariable Integer id) {
		return service.deleteEmployeee(id);
	}
}

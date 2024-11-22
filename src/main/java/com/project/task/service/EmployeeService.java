package com.project.task.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.task.employee.Employee;
import com.project.task.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	
	public List<Employee> employees(){
		return repository.findAll();
		
	}
	public List<Employee>saveEmployee(Employee employee){
		if(employee.getEmpId()==0) {
			employee.setEmpStatus("Active");
		}
		 repository.save(employee);
		 return this.employees();
		 
		
	}
	public Employee deleteEmployeee(Integer id){
		
		Employee deleteEmp = repository.findById(id).orElse(null);
		if(deleteEmp == null) {
			repository.delete(deleteEmp);
		}
		 return deleteEmp;
	}
	
	public Employee retireveEmployee(Integer id) {
		Employee emp = repository.findById(id).orElse(null);
		return emp;
	}
	
	
	

}

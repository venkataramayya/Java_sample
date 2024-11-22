package com.project.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.task.employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
}

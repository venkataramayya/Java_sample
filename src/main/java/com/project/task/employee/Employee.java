package com.project.task.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private int empId;
	private String empName;
	private String empEmail;
	private String empNumber;
	private String empDateOfJoining;
	private String Gender;
	private String empStatus;
	private float empSalary;
	public Employee(int empId, String empName, String empEmail, String number, String empDateOfJoining, String gender,
			String empStatus, float empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empNumber = number;
		this.empDateOfJoining = empDateOfJoining;
		Gender = gender;
		this.empStatus = empStatus;
		this.empSalary = empSalary;
	}
	public Employee() {
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getempNumber() {
		return empNumber;
	}
	public void setempNumber(String number) {
		empNumber = number;
	}
	public String getEmpDateOfJoining() {
		return empDateOfJoining;
	}
	public void setEmpDateOfJoining(String empDateOfJoining) {
		this.empDateOfJoining = empDateOfJoining;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	public float getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}
	
}
	
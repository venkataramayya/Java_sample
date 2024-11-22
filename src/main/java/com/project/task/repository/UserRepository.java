package com.project.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.task.employee.User;

public interface UserRepository extends JpaRepository<User,Long>{
	  User findByUsername(String username);
	
}

package com.project.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.task.employee.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{
	
	 Role findByRoleName(String roleName);
}

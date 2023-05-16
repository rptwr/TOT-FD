package com.example.app3advancedCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app3advancedCRUD.models.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	public Department findByNameAndJobRole(String name, String JobRole);
}

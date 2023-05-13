package com.example.app3advancedCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app3advancedCRUD.models.Salary;


@Repository
public interface salaryRepository extends JpaRepository<Salary, Long> {
	
	public Salary findSalaryBySalary(double salary);
	
}

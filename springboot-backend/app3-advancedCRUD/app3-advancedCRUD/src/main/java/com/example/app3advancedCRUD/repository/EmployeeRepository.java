package com.example.app3advancedCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app3advancedCRUD.models.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

package com.example.app2singlePageApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app2singlePageApp.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

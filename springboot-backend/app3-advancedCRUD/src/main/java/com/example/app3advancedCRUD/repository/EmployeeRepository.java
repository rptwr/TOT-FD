package com.example.app3advancedCRUD.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app3advancedCRUD.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query(value = "select * from Employee e where e.Date_of_join BETWEEN date :from AND date :to", nativeQuery = true)
	public List<Employee> getEmployeesJoinedBetween(LocalDate from, LocalDate to);
}

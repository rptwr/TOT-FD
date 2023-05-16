package com.example.app3advancedCRUD.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.ListModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.app3advancedCRUD.models.Employee;
import com.example.app3advancedCRUD.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * on post
	 * 
	 * http://localhost:9090/api/v1/employees
	 * 
	 * @param employee
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/employees")
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	/**
	 * on get
	 * 
	 * http://localhost:9090/api/v1/employees/load
	 * 
	 * @return
	 */
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		return employeeService.findAll();
	}

	/**
	 * on get
	 * 
	 * http://localhost:9090/api/v1/employees/152
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		return employeeService.getById(id);
	}

	/**
	 * http://localhost:9090/api/v1/employees/2022-01-01/2023-12-31
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	@GetMapping("/employees/{from}/{to}")
	public ResponseEntity<List<Employee>> getEmployeesJoinedBetween(@PathVariable String from,
			@PathVariable String to) {
		return employeeService.getEmployeesJoinedBetween(from, to);
	}

	/**
	 * on put
	 * 
	 * http://localhost:9090/api/v1/employees/152
	 * 
	 * @param id
	 * @param employeeDetails
	 * @return
	 */
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
		return employeeService.update(id, employeeDetails);
	}

	/**
	 * on delete
	 * 
	 * http://localhost:9090/api/v1/employees/152
	 * 
	 * @param id
	 * @return
	 */

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteById(@PathVariable Long id) {
		return employeeService.delete(id);
	}

}

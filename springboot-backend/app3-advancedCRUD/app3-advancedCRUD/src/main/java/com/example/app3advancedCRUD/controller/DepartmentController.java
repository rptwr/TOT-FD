package com.example.app3advancedCRUD.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app3advancedCRUD.models.Department;
import com.example.app3advancedCRUD.service.DepartmentService;

@RestController
@RequestMapping("/api/v1/employees")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	/**
	 * http://localhost:9090/api/v1/employees/department
	 * 
	 * @param department
	 * @return
	 */
	@PostMapping("/department")
	public ResponseEntity<Department> save(@RequestBody Department department) {
		return departmentService.save(department);
	}

	/**
	 * http://localhost:9090/api/v1/employees/department
	 * 
	 * @return
	 */
	@GetMapping("/department")
	public ResponseEntity<List<Department>> getSalaries() {
		return departmentService.findAll();
	}

	/**
	 * http://localhost:9090/api/v1/employees/department/123
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/department/{id}")
	public ResponseEntity<Department> getSalaryById(@PathVariable Long id) {
		return departmentService.findById(id);
	}

	/**
	 * @param id
	 * @param department
	 * @return
	 */
	@PutMapping("/department/{id}")
	public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
		return departmentService.update(id, department);
	}

	/**
	 * http://localhost:9090/api/v1/employees/department/123
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/department/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
		return departmentService.delete(id);
	}
}

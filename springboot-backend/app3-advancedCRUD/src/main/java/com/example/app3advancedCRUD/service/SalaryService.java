package com.example.app3advancedCRUD.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.app3advancedCRUD.exception.ResourceNotFoundException;
import com.example.app3advancedCRUD.models.Salary;
import com.example.app3advancedCRUD.repository.salaryRepository;

@Service
public class SalaryService {

	@Autowired
	private salaryRepository salaryRepository;

	public ResponseEntity<Salary> save(Salary salary) {
		salaryRepository.save(salary);
		return ResponseEntity.ok(salary);
	}

	public ResponseEntity<List<Salary>> findAll() {
		List<Salary> salaries = salaryRepository.findAll();
		return ResponseEntity.ok(salaries);
	}

	public ResponseEntity<Salary> findById(Long id) {
		Salary salary = salaryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Salary with " + id + " not found"));
		return ResponseEntity.ok(salary);
	}

	public ResponseEntity<Salary> update(Long id, Double amount) {
		Salary salary = salaryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Salary with " + id + " not found"));
		salary.setSalary(amount);
		return ResponseEntity.ok(salary);
	}

	public ResponseEntity<Map<String, Boolean>> delete(Long id) {
		Salary salary = salaryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Salary with " + id + " not found"));
		salaryRepository.delete(salary);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

package com.example.app3advancedCRUD.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.engine.jdbc.ClobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app3advancedCRUD.exception.ResourceNotFoundException;
import com.example.app3advancedCRUD.models.Department;
import com.example.app3advancedCRUD.models.Employee;
import com.example.app3advancedCRUD.models.Salary;
import com.example.app3advancedCRUD.models.Skill;
import com.example.app3advancedCRUD.repository.DepartmentRepository;
import com.example.app3advancedCRUD.repository.EmployeeRepository;
import com.example.app3advancedCRUD.repository.SkillRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private SkillRepository skillRepository;

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private SalaryService salaryService;

	@Autowired
	private DocumentService documentService;

	public ResponseEntity<Employee> save(Employee employee){
		Skill skill = new Skill();
		List<Skill> skills = new ArrayList<>();
		for (Skill skill2 : employee.getEmployeeSkills()) {
			skill = skillRepository.findByName(skill2.getName());
			if (skill != null) {
				skills.add(skill);
			} else {
				skillRepository.save(skill2);
				skills.add(skill2);
			}
		}
		employee.setEmployeeSkills(skills);

		Department dep = employee.getDep();
		Department department = departmentRepository.findByNameAndJobRole(dep.getName(), dep.getJobRole());
		if (department != null) {
			employee.setDep(department);
		} else {
			departmentRepository.save(dep);
//			employee.setDep(dep);
		}
		employee.getSalary().setEmployee(employee);
		employeeRepository.save(employee);
		return ResponseEntity.ok(employee);
	}

	public ResponseEntity<List<Employee>> findAll() {
		List<Employee> employees = employeeRepository.findAll();
		return ResponseEntity.ok(employees);
	}

	public ResponseEntity<Employee> getById(long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with " + id + " not found"));
		return ResponseEntity.ok(employee);
	}

	public ResponseEntity<Employee> update(Long id, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with " + id + " not found"));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());
		employee.setdateOfJoin(employeeDetails.getdateOfJoin());

		Skill skill = new Skill();
		List<Skill> skills = new ArrayList<>();
		for (Skill skill2 : employeeDetails.getEmployeeSkills()) {
			skill = skillRepository.findByName(skill2.getName());
			if (skill != null) {
				skills.add(skill);
			} else {
				skillRepository.save(skill2);
				skills.add(skill2);
			}
		}
		employee.setEmployeeSkills(skills);

		Department dep = employeeDetails.getDep();
		Department department = departmentRepository.findByNameAndJobRole(dep.getName(), dep.getJobRole());
		if (department != null) {
			employee.setDep(department);
		} else {
			departmentRepository.save(dep);
			employee.setDep(dep);
		}

		Salary salary = employee.getSalary();
		System.out.println(salary.getId());
		salaryService.update(salary.getId(), employeeDetails.getSalary().getSalary());

		employeeRepository.save(employee);
		return ResponseEntity.ok(employee);
	}

	public ResponseEntity<Map<String, Boolean>> delete(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with " + id + " not found"));
			employee.setDep(null);
		employeeRepository.delete(employee);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	public ResponseEntity<List<Employee>> getEmployeesJoinedBetween(String from, String to) {
		LocalDate fromDate = LocalDate.parse(from);
		LocalDate toDate = LocalDate.parse(to);
		List<Employee> employees = employeeRepository.getEmployeesJoinedBetween(fromDate, toDate);

		return ResponseEntity.ok(employees);
	}

}

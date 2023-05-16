package com.example.app3advancedCRUD.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Department dep;

	@Column(unique = true)
	private String email;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Skill> employeeSkills = new ArrayList<>();

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	private Salary salary;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Document> documents;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-DD")
	private LocalDate dateOfJoin;

	public Employee() {
	}

	public Employee(long id, String firstName, String lastName, Department dep, String email,
			List<Skill> employeeSkills, Salary salary, List<Document> documents, LocalDate dateOfJoin) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dep = dep;
		this.email = email;
		this.employeeSkills = employeeSkills;
		this.salary = salary;
		this.documents = documents;
		this.dateOfJoin = dateOfJoin;
	}

	public LocalDate getdateOfJoin() {
		return dateOfJoin;
	}

	public void setdateOfJoin(LocalDate dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Skill> getEmployeeSkills() {
		return employeeSkills;
	}

	public void setEmployeeSkills(List<Skill> employeeSkills) {
		this.employeeSkills = employeeSkills;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

}

//{
//    "firstName": "Ravi",
//    "lastName": "tiwari",
//    "dep": {
//        "name": "CS",
//        "jobRole": "programmer"
//    },
//    "email": "ravi@gmail.com",
//    "employeeSkills": [
//        {
//            "name": "Java"
//        }
//    ],
//    "salary": {
//        "salary": 1500.00
//    },
//    "dateOfJoin": 2023-04-16
//}
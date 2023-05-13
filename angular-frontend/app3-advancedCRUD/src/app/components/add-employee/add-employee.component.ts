import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/entity/employee';
import { EmployeeServiceService } from 'src/app/service/employee-service.service';
import { FormControl, FormBuilder, FormGroup, Validators, FormArray } from '@angular/forms'
import { Skill } from 'src/app/entity/skill';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {
  // employee:Employee=new Employee;
  employeeForm!: FormGroup;

  // skillList!:skills[];   
  employee = new Employee();
  private baseURL = "http://localhost:9093/api/v1/employees";

  constructor(private httpClient: HttpClient, private formBuilder: FormBuilder, private employeeService: EmployeeServiceService, private router: Router) { }

  addEmployee() {
    return this.employeeService.addEmployee(this.employeeForm.value).subscribe(data => {
      console.log(data);
    },
      error => console.log(error));
  }

  onSubmit() {
    console.log(this.employee);
  }

  gotoEmployeeList() {
    this.router.navigate(['/home']);
  }

  ngOnInit() {
    this.employeeForm = this.formBuilder.group({
      id: [null],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      dep: this.formBuilder.group({
        id: [null],
        name: ['', Validators.required],
        jobRole: ['', Validators.required],
      }),
      salary: this.formBuilder.group({
        id: [null],
        salary: [null, Validators.required],
      }),
      employeeSkills: new FormArray([this.formBuilder.group({
        name: ['', Validators.required]
      })]),
    });

  }
  submit() {

    this.addEmployee();
    console.log(this.employeeForm.value)
  }

  get employeeSkills() {
    return this.employeeForm.get('employeeSkills') as FormArray;
  }

  addNewEmployeeSkills($event: any) {
    this.employeeSkills.push(this.formBuilder.group({
      name: ['', Validators.required]
    }))
  }
}

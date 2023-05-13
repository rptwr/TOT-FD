import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/app/entity/employee';
import { EmployeeServiceService } from 'src/app/service/employee-service.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent {
  employee = new Employee();
  id!: number;
  private baseURL = "http://localhost:9093/api/v1/employees";

  constructor(private httpClient: HttpClient, private employeeService: EmployeeServiceService, private router: Router, private activtedroute: ActivatedRoute) { }

  onSubmit() {
    console.log(this.employee);
    this.employeeService.updateEmployee(this.id, this.employee).subscribe(data => {
      this.gotohome()
    },
      error => console.log(error));
  }

  gotohome() {
    this.router.navigate(['/home']);
  }

  //  employee1 = new Employee(); 
  ngOnInit() {
    this.id = this.activtedroute.snapshot.params[`id`];
    // this.employee =new Employee();

    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
      console.log(this.employee);
    });
  }

  gotoUpdateSkill() {
    this.router.navigate(['/update-employee/skill', this.employee.id]);
  }
}
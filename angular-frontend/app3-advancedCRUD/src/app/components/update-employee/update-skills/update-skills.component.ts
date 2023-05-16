import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/app/entity/employee';
import { Skill } from 'src/app/entity/skill';
import { EmployeeServiceService } from 'src/app/service/employee-service.service';
@Component({
  selector: 'app-update-skills',
  templateUrl: './update-skills.component.html',
  styleUrls: ['./update-skills.component.css']
})
export class UpdateSkillsComponent implements OnInit {
  index: number = 0;
  Employeeid!: number;
  skills!: Skill[];

  employee!: Employee;
  constructor(private httpClient: HttpClient, private formBuilder: FormBuilder, private employeeService: EmployeeServiceService, private activtedroute: ActivatedRoute, private router: Router) { }
  skillForm!: FormGroup;
  employeeSkills!: FormArray;
  ngOnInit(): void {
    this.skillForm = this.formBuilder.group({
      employeeSkills: new FormArray([this.formBuilder.group({
        //  skill:[new FormControl()]
        name: ['',]
      })])
    });
    this.Employeeid = this.activtedroute.snapshot.params[`id`];
    this.employeeService.getEmployeeById(this.Employeeid).subscribe(data => {
      this.employee = data;
      this.skills = data.employeeSkills;
      this.index = this.skills.length
      console.log(this.skills);
    });
  }
  gotoUpdateEmployee() {
    this.router.navigate(['update-employee/', this.Employeeid]);
  }
  Onsubmit() {

    console.log(this.employee)
    this.employeeService.updateEmployee(this.Employeeid, this.employee).subscribe(data => {
    },
      error => console.log(error));
    this.gotoUpdateEmployee();

  }


  get employeeSkill() {
    return this.skillForm.get('employeeSkills') as FormArray;
  }
  addNewEmployeeSkills() {
    this.employeeSkills.push(this.formBuilder.group({
      name: ['',]
    }));
    this.employee.employeeSkills.push({ id: this.employee.employeeSkills.length + 1, name: '' });
  }

  addSkill($event: any) {
    this.skills.push({ id: this.skills.length + 1, name: '' });
    this.employeeSkills.push({
      index: this.skills.length + 1,
      name: ['',]

    });
  }
  removeSkill(index: number) {
    this.employee.employeeSkills.splice(index, 1);
    this.employeeSkills.removeAt(index);
  }
}
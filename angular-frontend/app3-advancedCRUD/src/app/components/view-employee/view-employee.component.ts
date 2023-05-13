import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/app/entity/employee';
import { EmployeeServiceService } from 'src/app/service/employee-service.service';
import { OnInit } from '@angular/core';

@Component({
  selector: 'app-view-employee',
  templateUrl: './view-employee.component.html',
  styleUrls: ['./view-employee.component.css']
})
export class ViewEmployeeComponent implements OnInit {
  id!: number;
  employee!: Employee;
  constructor(private route: ActivatedRoute, private employeeService: EmployeeServiceService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.employee = new Employee();
    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
      console.log(this.employee);
    });

  }
}

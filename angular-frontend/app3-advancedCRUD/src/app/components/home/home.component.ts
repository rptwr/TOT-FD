import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subscribable } from 'rxjs';
import { Employee } from 'src/app/entity/employee';
import { EmployeeServiceService } from 'src/app/service/employee-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  employees!: Employee[];
  filteredEmployees!: Employee[];
  startDate!: string;
  endDate!: string;

  constructor(private employeeService: EmployeeServiceService, private router: Router) { }
  ngOnInit(): void {
    this.getEmployees();
  }
  private getEmployees() {
    this.employeeService.getEmployeesList().subscribe(data => {
      this.employees = data;
    });
  }

  view(id: number) {
    this.router.navigate([`employee-view`, id]);
  }

  delete(id: number) {
    this.employeeService.deleteEmployee(id).subscribe(data => {
      console.log(data);
    })
    this.getEmployees();
  }

  onConfirm(id: number): void {
    const confirmed = confirm('Are you sure you want to delete this item?');
    if (confirmed) {
      // delete the item
      this.delete(id);
    }
  }

  update(id: number) {
    this.router.navigate([`update-employee`, id]);
  }

  updateDocumnet(id: number) {
    this.router.navigate([`add-document`, id]);
  }

  formatStartDate(event: any) {
    this.startDate = event.target.value;
  }

  formatEndDate(event: any) {
    this.endDate = event.target.value;
  }
  search() {
    if (!this.startDate || !this.endDate) {
      return; // Exit if either date is not selected
    }

    const formattedStartDate = new Date(this.startDate);
    const formattedEndDate = new Date(this.endDate);

    const filteredEmployees = this.employees.filter(employee => {
      const joinDate = new Date(employee.dateOfJoin);
      return joinDate >= formattedStartDate && joinDate <= formattedEndDate;
    });

    this.filteredEmployees = filteredEmployees;
  }

}

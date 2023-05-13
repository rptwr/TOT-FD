import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
// updateEmployee(arg0: number) {
// throw new Error('Method not implemented.');
// }
           
   employees!: Employee[];

   constructor(private employeeService: EmployeeService, 
    private router: Router) { }
   ngOnInit(): void {

    this.getEmployees();

    //  this.employees = [
    //   {
    //     "id": 1,
    //     "firstName": "Ravi",
    //     "lastName": "Tiwari",
    //     "emailId": "ravi@gmail.com"
    //   },
    //   {
    //     "id": 2,
    //     "firstName": "Shiva",
    //     "lastName": "Krishna",
    //     "emailId": "shiva@gmail.com"
    //   }
    //  ];
   }
   private getEmployees() {
    this.employeeService.getEmployeeList().subscribe(data => {
      this.employees = data;
    });
   }
   employeeDetails(id: number) {
    this.router.navigate(['employee-details', id]);
   }

   updateEmployee(id: number) {
      this.router.navigate(['update-employee', id]);
   }

   deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id).subscribe(data => {
      console.log(data);
      this.getEmployees();
    })
   }
}

import { Component, OnInit } from '@angular/core';
import { Department } from 'src/app/entity/department';
import { DepartmentService } from 'src/app/service/department.service';

@Component({
  selector: 'app-view-department',
  templateUrl: './view-department.component.html',
  styleUrls: ['./view-department.component.css']
})
export class ViewDepartmentComponent implements OnInit{
  dep!:Department[];
  constructor(private departmentService: DepartmentService){}
  ngOnInit(): void {
   this.departmentService.getAllDepartments().subscribe(data => {
    this.dep = data;
   });
  }

}

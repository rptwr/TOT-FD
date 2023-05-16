import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Department } from '../entity/department';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  constructor(private httpClient:HttpClient, private router:Router) { }
  baseUrl="http://localhost:9093/api/v1/employees/department";
 
  getAllDepartments():Observable<Department[]>{
    return this.httpClient.get<Department[]>(`${this.baseUrl}`);
  }

  
}

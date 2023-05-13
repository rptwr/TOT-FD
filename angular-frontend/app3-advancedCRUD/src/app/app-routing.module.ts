import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewEmployeeComponent } from './components/view-employee/view-employee.component';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ViewDepartmentComponent } from './components/view-department/view-department.component';
import { AddEmployeeComponent } from './components/add-employee/add-employee.component';
import { UpdateEmployeeComponent } from './components/update-employee/update-employee.component';
import { UpdateSkillsComponent } from './components/update-employee/update-skills/update-skills.component';
import { FileUploadComponent } from './components/file-upload/file-upload.component';


const routes: Routes = [
  { path: 'employee-view/:id', component: ViewEmployeeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'add-emplyee', component: AddEmployeeComponent },
  { path: 'update-employee/:id', component: UpdateEmployeeComponent },
  { path: 'update-employee/skill/:id', component: UpdateSkillsComponent },
  { path: 'department', component: ViewDepartmentComponent },
  { path: 'file-upload', component: FileUploadComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

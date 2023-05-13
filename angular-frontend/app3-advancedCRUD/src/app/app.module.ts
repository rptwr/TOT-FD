import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule, NgbTypeaheadModule } from '@ng-bootstrap/ng-bootstrap';
import {HttpClientModule} from '@angular/common/http'
import { HomeComponent } from './components/home/home.component';
import { AsyncPipe, DecimalPipe, NgFor } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ViewEmployeeComponent } from './components/view-employee/view-employee.component';
import { ViewDepartmentComponent } from './components/view-department/view-department.component';
import { AddEmployeeComponent } from './components/add-employee/add-employee.component';
import { UpdateEmployeeComponent } from './components/update-employee/update-employee.component';
import { UpdateSkillsComponent } from './components/update-employee/update-skills/update-skills.component';
import { FileUploadComponent } from './components/file-upload/file-upload.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ViewEmployeeComponent,
    ViewDepartmentComponent,
    AddEmployeeComponent,
    UpdateEmployeeComponent,
    UpdateSkillsComponent,
    FileUploadComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    DecimalPipe,
    NgFor,
    AsyncPipe,
    ReactiveFormsModule,
    NgbTypeaheadModule,
    FormsModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


















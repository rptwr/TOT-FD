import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/app/entity/employee';
import { DocumentService } from 'src/app/service/document.service';
import { EmployeeServiceService } from 'src/app/service/employee-service.service';

@Component({
  selector: 'app-add-document',
  templateUrl: './add-documents.component.html',
  styleUrls: ['./add-documents.component.css']
})
export class AddDocumentsComponent implements OnInit {
  id!: number;
  ngOnInit(): void {
    this.id = this.activtedroute.snapshot.params[`id`];
  }
  constructor(private http: HttpClient, private activtedroute: ActivatedRoute, private router: Router, private documentService: DocumentService) { }
  selectedFiles: File[] = [];
  onFileChange(event: any) {
    const files = event.target.files;
    for (let i = 0; i < files.length; i++) {
      this.selectedFiles.push(files[i]);
    }
  }
  addFile() {
    const inputElement = document.createElement('input');
    inputElement.type = 'file';
    inputElement.accept = '.jpg, .png, .pdf';
    inputElement.addEventListener('change', (event: any) => this.onFileChange(event));
    inputElement.click();
  }

  removeFile(file: File) {
    const index = this.selectedFiles.indexOf(file);
    if (index > -1) {
      this.selectedFiles.splice(index, 1);
    }
  }

  submitForm() {
    console.log(this.selectedFiles);
    this.documentService.uploadFiles(this.selectedFiles, this.id).subscribe(data => {
      console.log(data)
      this.gotoHome();
    },
      error => console.log(error));
  }

  gotoHome() {
    this.router.navigate(['/home']);
  }




}
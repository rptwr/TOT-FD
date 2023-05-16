import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DocumentService {

  constructor(private httpclient: HttpClient) { }
  baseurl = "http://localhost:9093/api/v1/employees/documents/add-documents";

  uploadFiles(files: File[], id: number): Observable<Object> {
    const formData: FormData = new FormData();
    for (let i = 0; i < files.length; i++) {
      formData.append('files', files[i], files[i].name);
    }

    const headers = new HttpHeaders();
    return this.httpclient.post(`${this.baseurl}/${id}`, formData);
  }

}
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css']
})
export class FileUploadComponent implements OnInit {

  // file!: File;
  // constructor(private http: HttpClient) {

  // }

  // onFileChange(event) {
  //   this.file = event.target.files[0]
  // }

  // uploadFile() {

  // }
  ngOnInit(): void {

  }

}

//   onFileChange(event) {
//     this.file = event.target.files[0];
//   }

//   uploadFile() {
//     const formData = new FormData();
//     formData.append('file', this.file);

//     this.http.post('https://example.com/upload', formData, {
//       headers: new Headers({
//         'Content-Type': 'multipart/form-data'
//       })
//     }).subscribe((response) => {
//       console.log(response);
//     });
//   }

// }

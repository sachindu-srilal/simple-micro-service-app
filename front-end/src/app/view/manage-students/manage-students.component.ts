import { Component } from '@angular/core';
import {Student} from "../../dto/Student";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-manage-students',
  templateUrl: './manage-students.component.html',
  styleUrls: ['./manage-students.component.scss']
})
export class ManageStudentsComponent {
  studentList: Array<Student> = [];

  constructor(private http: HttpClient) {
    http.get<Array<Student>>('http://localhost:8080/api/v1/students')
      .subscribe(studentList => this.studentList = studentList);
  }

  saveStudent(txtName: HTMLInputElement, txtAddress: HTMLInputElement) {
    const name = txtName.value;
    const address = txtAddress.value;
    const id = null;

    if (!name.trim()){
      alert("Name can't be empty");
      txtName.select();
      return;
    }else if(!address.trim()){
      alert("Address can't be empty");
      txtAddress.select();
      return;
    }

    const newStudent = new Student(id,name, address);

    this.http.post('http://localhost:8080/api/v1/students', newStudent)
      .subscribe(result => {
        this.studentList.push(newStudent);
        txtName.value = '';
        txtAddress.value = '';
        txtName.focus();
      });

  }
  deleteStudent(id: number) {
    this.http.delete(`http://localhost:8081/api/v1/students/${id}`)
      .subscribe(result => {
        const index = this.studentList.findIndex(student => student.id === id);
        this.studentList.splice(index, 1);
      });
  }
}

import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Course} from "../../dto/Course";

@Component({
  selector: 'app-manage-courses',
  templateUrl: './manage-courses.component.html',
  styleUrls: ['./manage-courses.component.scss']
})
export class ManageCoursesComponent {
  courseList: Array<Course> = [];

  constructor(private http: HttpClient) {
    http.get<Array<Course>>('http://localhost:5050/api/v1/courses')
      .subscribe(courseList => this.courseList = courseList);
  }

  saveCourse(txtId: HTMLInputElement, txtDescription: HTMLInputElement, txtDuration: HTMLInputElement) {
    const id = txtId.value;
    const description = txtDescription.value;
    const duration = txtDuration.value;

    if (!id.trim()){
      alert("id can't be empty");
      txtId.select();
      return;
    }else if(!description.trim()){
      alert("Description can't be empty");
      txtDescription.select();
      return;
    }else if(!duration.trim()) {
      alert("Duration can't be empty");
      txtDuration.select();
      return;
    }
    const newCourse = new Course(id,description, duration);

    this.http.post('http://localhost:5050/api/v1/courses', newCourse)
      .subscribe(result => {
        this.courseList.push(newCourse);
        txtId.value = '';
        txtDescription.value = '';
        txtDuration.value = '';
        txtId.focus();
      });

  }
  deleteCourse(id:string) {
    this.http.delete(`http://localhost:5050/api/v1/courses/${id}`)
      .subscribe(result => {
        const index = this.courseList.findIndex(course => course.id == id);
        this.courseList.splice(index, 1);
      });
  }
}

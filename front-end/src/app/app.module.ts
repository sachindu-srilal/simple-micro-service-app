import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ManageStudentsComponent } from './view/manage-students/manage-students.component';
import { ManageCoursesComponent } from './view/manage-courses/manage-courses.component';
import {RouterModule, Routes} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";

const routes:Routes=[
  {
    path:'students',
    component:ManageStudentsComponent
  },
  {
    path:'courses',
    component:ManageCoursesComponent
  }
]
@NgModule({
  declarations: [
    AppComponent,
    ManageStudentsComponent,
    ManageCoursesComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

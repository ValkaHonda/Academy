import { Component, OnInit } from '@angular/core';
import { CourseService } from '../services/courseService/course.service';
import { CourseModel } from '../models/courses/courseModel';
import { Router } from '../../../node_modules/@angular/router';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {
  courses:CourseModel[];

  constructor(private router: Router, private courseService:CourseService) { 
    this.courseService.getAllCourses().subscribe(
      (data:CourseModel[])=>{
        this.courses = data
      }
    );
  }

  ngOnInit() {

  }
  goToCourse(id){
    this.router.navigate([`./courses/details/${id}`]);
  }

}

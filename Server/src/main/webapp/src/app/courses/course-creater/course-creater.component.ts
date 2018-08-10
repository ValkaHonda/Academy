import { Component, OnInit } from '@angular/core';
import { CourseService } from '../../services/courseService/course.service';
import { ModuleService } from '../../services/moduleServices/module.service';
import { ModuleModel } from '../../models/moduleModel';
import { CourseCreationModel } from '../../models/courses/courseCreationModel';
import { CourseModel } from '../../models/courses/courseModel';
import { Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-course-creater',
  templateUrl: './course-creater.component.html',
  styleUrls: ['./course-creater.component.css']
})
export class CourseCreaterComponent implements OnInit {
  exists:boolean;
  modules:ModuleModel[];
  selectedModule:ModuleModel;
  courseName:String;

  constructor(
    private courseService:CourseService,
    private moduleService:ModuleService,
    private router: Router
  ) {
    this.moduleService.getAllModules().subscribe(
      (data:ModuleModel[])=>this.modules=data
    );
   }

  ngOnInit() {
  }

  createCourse(){
    this.courseService.exists(this.courseName,this.selectedModule.name).subscribe(
      (data:boolean)=>{
        this.exists=data;
        if(this.exists==false){
          let newCourse:CourseCreationModel = new CourseCreationModel(this.courseName);
          this.courseService.addCourse(newCourse,this.selectedModule.id).subscribe(
            (data:CourseModel)=>this.router.navigate(['./courses'])
          );
        }
      }
    );
  }

}

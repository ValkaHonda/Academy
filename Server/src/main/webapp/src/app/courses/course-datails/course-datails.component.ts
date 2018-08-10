import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '../../../../node_modules/@angular/router';
import { CourseService } from '../../services/courseService/course.service';
import { CourseModel } from '../../models/courses/courseModel';
import { UserStateService } from '../../services/user-state-service/user-state.service';
import { UserLoginService } from '../../services/userLogInService/user-login.service';
import { UserProfile } from '../../modules/UserProfile';

@Component({
  selector: 'app-course-datails',
  templateUrl: './course-datails.component.html',
  styleUrls: ['./course-datails.component.css']
})
export class CourseDatailsComponent implements OnInit, OnDestroy  {
  id: number;
  private sub: any;
  course:CourseModel;

  constructor(
    private userLoginService:UserLoginService,
    private userStateService:UserStateService,
    private router: Router,
    private route: ActivatedRoute,
    private courseService:CourseService
    ) {}

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id']; // (+) converts string 'id' to a number
    });
    this.courseService.findById(this.id).subscribe(
      (data:CourseModel)=>this.course=data

    );
    
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }
  joinCourse(){
    console.log("join it");

    let userName:String = this.userStateService.token.userName;
    let user:UserProfile;
    this.userLoginService.getUserByUserName(userName).subscribe(
      (data:UserProfile)=>{
        user=data;
        this.userLoginService.joinCourse(user,this.id).subscribe(
          (data2:UserProfile)=>console.log(data2)
        );
      }
    );
    this.router.navigate(['./profile']);
  }

}

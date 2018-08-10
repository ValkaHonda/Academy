import { Component, OnInit } from '@angular/core';
import { UserStateService } from '../services/user-state-service/user-state.service';
import { UserLoginService } from '../services/userLogInService/user-login.service';
import { UserProfile } from '../modules/UserProfile';
import { Router } from '../../../node_modules/@angular/router';
import { CourseService } from '../services/courseService/course.service';
import { CourseModel } from '../models/courses/courseModel';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userName:String;
  user:UserProfile;
  courses:CourseModel[];

  constructor(
    private courseService:CourseService,
    private router: Router,
    private userStateService:UserStateService,
    private userLoginService:UserLoginService
  ) { }

  ngOnInit() {
    this.userName = this.userStateService.token.userName;
    this.userLoginService.getUserByUserName(this.userName).subscribe(
      (data:UserProfile)=>{
        this.user=data;
        this.courseService.getCoursesByUserId(this.user.id).subscribe(
          (data2:CourseModel[])=>this.courses=data2
        );
      }
    );
    
  }
  goToCourse(id){
    this.router.navigate([`./courses/details/${id}`]);
  }
}

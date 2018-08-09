import { Component, OnInit } from '@angular/core';
import { UserStateService } from '../services/user-state-service/user-state.service';
import { UserLoginService } from '../services/userLogInService/user-login.service';
import { UserProfile } from '../modules/UserProfile';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userName:String;
  user:UserProfile;

  constructor(
    private userStateService:UserStateService,
    private userLoginService:UserLoginService
  ) { }

  ngOnInit() {
    this.userName = this.userStateService.getUserName();
    this.userLoginService.getUserByUserName(this.userName).subscribe(
      (data:UserProfile)=>
        this.user=data
    );
  }
}

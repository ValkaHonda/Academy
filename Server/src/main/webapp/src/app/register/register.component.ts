import { Component, OnInit } from '@angular/core';

import {  AfterViewInit } from '@angular/core';
import { Router } from '../../../node_modules/@angular/router';
import { UserStateService } from '../services/user-state-service/user-state.service';
import { UserLoginService } from '../services/userLogInService/user-login.service';
import { TokenImpl } from '../token/token';
import { AppComponent } from '../app.component';
import { RegisterModel } from '../models/registerModel';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  firstName:String;
  lastName:String;
  userName:String;
  email:String;
  password:String;
  confirmPassword:String;
  constructor(private userLoginService:UserLoginService) {
    
   }

  ngOnInit() {
    console.log("Register page");
  }

  submit():void{
   let registerModel:RegisterModel = new RegisterModel(
    this.firstName,
    this.lastName,
    this.userName,
    this.email,
    this.password
   );
   this.userLoginService.registerUser(registerModel).subscribe(
     (data:RegisterModel)=>console.log(data.userName)
   );
  }
}

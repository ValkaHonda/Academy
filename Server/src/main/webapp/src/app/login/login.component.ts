import { Component, OnInit, Input } from '@angular/core';
import { Router } from '../../../node_modules/@angular/router';
import { UserStateService } from '../services/user-state-service/user-state.service';
import { UserLoginService } from '../services/userLogInService/user-login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username:String;
  password:String;

  constructor(private router: Router, private userLoginService:UserLoginService) { }

  ngOnInit() {
    
  }

  submit(): void{
    // console.log(this.password); 
    // console.log(this.username); 
    this.router.navigate(['./about']);
    // console.log("Locale storage is awsome!");
    localStorage.setItem('currentUser', JSON.stringify({ name: "Valka" }));

    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    // console.log(currentUser);

    // this.userLoginService.login().subscribe(
    //   (data:any) => console.log(data)
    // )
    this.userLoginService.login2();

  }

}

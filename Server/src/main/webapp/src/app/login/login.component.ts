import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Router } from '../../../node_modules/@angular/router';
import { UserStateService } from '../services/user-state-service/user-state.service';
import { UserLoginService } from '../services/userLogInService/user-login.service';
import { TokenImpl } from '../token/token';
import { AppComponent } from '../app.component';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, AfterViewInit {
  username:String;
  password:String;

  constructor(private router: Router, private userLoginService:UserLoginService) { }

  ngOnInit() {
    
  }

  ngAfterViewInit(){
    console.log("login page");
  }
  submit(): void{
     this.userLoginService.login2().subscribe(
      (data:TokenImpl) => {
          data.login = true;
          localStorage.setItem('currentUser', JSON.stringify(data));
          this.router.navigate(['./']);
      },
      error => {
          console.log("Error You will find a way to fix it!", error);
      }
    );
  }

}

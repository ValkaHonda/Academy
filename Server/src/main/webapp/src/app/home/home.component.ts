import { Component, OnInit, AfterViewInit } from '@angular/core';
import { UserStateService } from '../services/user-state-service/user-state.service';
import { Router } from '../../../node_modules/@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, AfterViewInit{
  login:boolean;
  userName:String;
  constructor(private router: Router,private userStateService:UserStateService) { 
    this.login = false;
  }

  ngOnInit() {
    console.log("homepage");
    if(this.userStateService.token != null){
      this.login = this.userStateService.login();
      if(this.login == true){
        this.userName = this.userStateService.getUserName();
      }
    } else {
      this.login = false;
    }
  }

  ngAfterViewInit(): void {  }

  logout(){
    this.userStateService.token.login=false;
    localStorage.setItem('currentUser', JSON.stringify(this.userStateService.token));
    this.login = false;
  }

}

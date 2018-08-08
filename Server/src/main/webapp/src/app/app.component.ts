import { Component } from '@angular/core';
import { Injectable } from '@angular/core';
import { UserStateService } from './services/user-state-service/user-state.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  login:boolean;
  tokenId:String;

  deleteData:any;

  constructor(private userStateService:UserStateService){
    this.login = this.userStateService.getState();

    this.deleteData = JSON.parse(localStorage.getItem('currentUser'));
    console.log(this.deleteData);
  }

  
  ngOnInit() {
    this.deleteData = JSON.parse(localStorage.getItem('currentUser'));
    console.log(this.deleteData + "ng on Init");


    console.log("Do something, Please!!!!!!!!!!!!!!!");

  }
  onActivate($event){
    console.log("Maybe a solution");
  }
}

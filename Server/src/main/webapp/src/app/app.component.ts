import { Component, AfterViewInit, OnDestroy } from '@angular/core';
import { Injectable } from '@angular/core';
import { UserStateService } from './services/user-state-service/user-state.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit {

  constructor(){ 
     
  }

  ngAfterViewInit(){
  
  }
}

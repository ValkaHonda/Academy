import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserStateService {
  login:boolean;
  constructor() { 
      this.setState(false);
  }
  getState():boolean{
      return this.login;
  }
  setState(state:boolean){
    this.login = state;
  }
}
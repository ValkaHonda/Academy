import { Injectable } from '@angular/core';
import { TokenImpl } from '../../token/token';

@Injectable({
  providedIn: 'root'
})
export class UserStateService {
  token:TokenImpl;
  constructor() { 
    this.token = JSON.parse(localStorage.getItem('currentUser'));
  }

  public login():boolean{
    this.token = JSON.parse(localStorage.getItem('currentUser'));
    if(this.token != null){
      return this.token.login;
    }
    return false;
  }

  public getToken():String{
    this.token = JSON.parse(localStorage.getItem('currentUser'));
    return this.token.id_token;
  }
  
}
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '../../../../node_modules/@angular/common/http';
import { Observable, Subscription } from '../../../../node_modules/rxjs';

interface Token{
  id:String;
  login:boolean;
}


const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token'
    })
  };

@Injectable({
  providedIn: 'root'
})
export class UserLoginService {
  constructor(private httpClient:HttpClient) { }
  
 
  
  public login(username:String,password:String){
     return this.httpClient.post("http://localhost:8080/authenticate",{
        "username": username,
        "password": password,
        "isRememberMe": false
      });
  }
  
}
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
  
  public login():Observable<any>{
    return this.httpClient.get("https://api.github.com");
  }
  
  public login2(){
     return this.httpClient.post("http://localhost:8080/authenticate",{
        "username": "javac",
        "password": "honda",
        "isRememberMe": false
      });
  }
  
}
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '../../../../node_modules/@angular/common/http';
import { Observable, Subscription } from '../../../../node_modules/rxjs';
import { UserStateService } from '../user-state-service/user-state.service';
import { RequestOptions, Headers } from '@angular/http';
import { RegisterModel } from '../../models/registerModel';
import { UserProfile } from '../../modules/UserProfile';
@Injectable({
  providedIn: 'root'
})
export class UserLoginService {
  constructor(private httpClient:HttpClient, private userStateService:UserStateService) { }
  
 
  
  public login(username:String,password:String){
     return this.httpClient.post("http://localhost:8080/authenticate",{
        "username": username,
        "password": password,
        "isRememberMe": false
      });
  }
  
  public getUserByUserName(username:String){
    let tokenId:String = "Bearer "+this.userStateService.getToken();
    let url:string = "http://localhost:8080/user/GetByUserName/"+username;
      const options = {
        headers: new HttpHeaders({
            'Authorization': tokenId.toString()
          }
        )
      };
    return this.httpClient.get(url,options);
 }
 
 public registerUser(user:RegisterModel){
  let tokenId:String = "Bearer "+this.userStateService.getToken();
  let url:string = "http://localhost:8080/user/register";
    const options = {
      headers: new HttpHeaders({
          'Authorization': tokenId.toString()
        }
      )
    };
  return this.httpClient.post(url,user,options);
 }

 public joinCourse(user:UserProfile, courseId:number){
  let tokenId:String = "Bearer "+this.userStateService.getToken();
  let url:string = "http://localhost:8080/user/assignToCourse/"+courseId;
    const options = {
      headers: new HttpHeaders({
          'Authorization': tokenId.toString()
        }
      )
    };
  return this.httpClient.post(url,user,options);
 }
}
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '../../../../node_modules/@angular/common/http';
import { Observable, Subscription } from '../../../../node_modules/rxjs';
import { UserStateService } from '../user-state-service/user-state.service';
import { RequestOptions, Headers } from '@angular/http';
import { RegisterModel } from '../../models/registerModel';
import { ModuleModel } from '../../models/moduleModel';
import { ModuleCreation } from '../../models/moduleCreationModel';
import { CourseCreationModel } from '../../models/courses/courseCreationModel';
@Injectable({
  providedIn: 'root'
})
export class CourseService {
  constructor(private httpClient:HttpClient, private userStateService:UserStateService) { }

    public getAllCourses(){
      let tokenId:String = "Bearer "+this.userStateService.getToken();
      let url:string = "http://localhost:8080/course/getAll";
        const options = {
          headers: new HttpHeaders({
              'Authorization': tokenId.toString()
            }
          )
        };
      return this.httpClient.get(url,options);
  }

  public exists(courseName:String,moduleName:String){
    let tokenId:String = "Bearer "+this.userStateService.getToken();
    let url:string = "http://localhost:8080/course/exists/" + courseName + "/" + moduleName;
      const options = {
        headers: new HttpHeaders({
            'Authorization': tokenId.toString()
          }
        )
      };
    return this.httpClient.get(url,options);
  }

  public addCourse(course:CourseCreationModel,moduleId:number){
    let tokenId:String = "Bearer "+this.userStateService.getToken();
    let url:string = "http://localhost:8080/course/create/"+moduleId;
      const options = {
        headers: new HttpHeaders({
            'Authorization': tokenId.toString()
          }
        )
      };
    return this.httpClient.post(url,course,options);
   }

   public findById(id:number){
    let tokenId:String = "Bearer "+this.userStateService.getToken();
    let url:string = "http://localhost:8080/course/getById/"+id;
      const options = {
        headers: new HttpHeaders({
            'Authorization': tokenId.toString()
          }
        )
      };
    return this.httpClient.get(url,options);
  }
}
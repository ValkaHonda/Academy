import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '../../../../node_modules/@angular/common/http';
import { Observable, Subscription } from '../../../../node_modules/rxjs';
import { UserStateService } from '../user-state-service/user-state.service';
import { RequestOptions, Headers } from '@angular/http';
import { RegisterModel } from '../../models/registerModel';
import { ModuleModel } from '../../models/moduleModel';
import { ModuleCreation } from '../../models/moduleCreationModel';
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
}
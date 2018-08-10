import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '../../../../node_modules/@angular/common/http';
import { Observable, Subscription } from '../../../../node_modules/rxjs';
import { UserStateService } from '../user-state-service/user-state.service';
import { RequestOptions, Headers } from '@angular/http';
import { RegisterModel } from '../../models/registerModel';
@Injectable({
  providedIn: 'root'
})
export class ModuleService {
  constructor(private httpClient:HttpClient, private userStateService:UserStateService) { }

  public getAllModules(){
    let tokenId:String = "Bearer "+this.userStateService.getToken();
    let url:string = "http://localhost:8080/module/getAll";
      const options = {
        headers: new HttpHeaders({
            'Authorization': tokenId.toString()
          }
        )
      };
    return this.httpClient.get(url,options);
 }
}
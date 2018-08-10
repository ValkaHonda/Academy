import { Component, OnInit } from '@angular/core';
import { ModuleService } from '../services/moduleServices/module.service';
import { ModuleModel } from '../models/moduleModel';
import { ModuleCreation } from '../models/moduleCreationModel';
import { Router } from '../../../node_modules/@angular/router';

@Component({
  selector: 'app-module-creater',
  templateUrl: './module-creater.component.html',
  styleUrls: ['./module-creater.component.css']
})
export class ModuleCreaterComponent implements OnInit {
  moduleName:String;
  exists:boolean;

  constructor(private moduleServices:ModuleService,private router: Router) {
    this.exists = true;
   }

  ngOnInit() {
  }

  createModule(){
    this.moduleServices.exists(this.moduleName).subscribe(
      (data:boolean)=>{ 
        this.exists=data;
        if(this.exists == false){
          let module:ModuleCreation = new ModuleCreation(this.moduleName);
          this.moduleServices.addModule(module).subscribe(
            (data:ModuleModel)=>this.router.navigate(['./modules'])
          );
        }
      }
    );
    
    
  }
}

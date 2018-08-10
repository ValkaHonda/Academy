import { Component, OnInit } from '@angular/core';
import { ModuleService } from '../services/moduleServices/module.service';
import { ModuleModel } from '../models/moduleModel';

@Component({
  selector: 'app-modules',
  templateUrl: './modules.component.html',
  styleUrls: ['./modules.component.css']
})
export class ModulesComponent implements OnInit {
  modules:ModuleModel[];

  constructor(private moduleServics:ModuleService) { }

  ngOnInit() {
    this.moduleServics.getAllModules().subscribe(
      (data:ModuleModel[]) => this.modules = data
    );
  }

}

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { LoginComponent } from './login/login.component';
import { AboutComponent } from './about/about.component';
import { FormsModule }   from '@angular/forms';
import { ModulesComponent } from './modules/modules.component';



const appRoutes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'about',      component: AboutComponent }
];


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AboutComponent,
    ModulesComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes
    ),
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

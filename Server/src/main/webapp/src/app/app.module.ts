import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { LoginComponent } from './login/login.component';
import { AboutComponent } from './about/about.component';
import { FormsModule }   from '@angular/forms';
import { ModulesComponent } from './modules/modules.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component'; 



const appRoutes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'about',      component: AboutComponent },
  { path: '',      component: HomeComponent }
];


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AboutComponent,
    ModulesComponent,
    HomeComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes
    ),
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

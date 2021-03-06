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
import { ProfileComponent } from './profile/profile.component';
import { CoursesComponent } from './courses/courses.component';
import { RegisterComponent } from './register/register.component';
import { ModuleCreaterComponent } from './module-creater/module-creater.component';
import { CourseCreaterComponent } from './courses/course-creater/course-creater.component';
import { CourseDatailsComponent } from './courses/course-datails/course-datails.component'; 



const appRoutes: Routes = [
  { path: 'courses/details/:id', component: CourseDatailsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'about',      component: AboutComponent },
  { path: 'profile',      component: ProfileComponent },
  { path: 'modules', component: ModulesComponent },
  { path: 'courses', component: CoursesComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'modules/create', component: ModuleCreaterComponent },
  { path: 'courses/create', component: CourseCreaterComponent },
  { path: '',      component: HomeComponent }
];


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AboutComponent,
    ModulesComponent,
    HomeComponent,
    ProfileComponent,
    CoursesComponent,
    RegisterComponent,
    ModuleCreaterComponent,
    CourseCreaterComponent,
    CourseDatailsComponent
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

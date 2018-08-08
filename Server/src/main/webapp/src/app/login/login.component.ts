import { Component, OnInit, Input } from '@angular/core';
import { Router } from '../../../node_modules/@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Input() login:boolean;
  username:String;
  password:String;

  constructor(private router: Router) { }

  ngOnInit() {
    
  }

  submit(): void{
    console.log(this.password); 
    console.log(this.username); 
    this.router.navigate(['./about']);
    this.login = false;
  }

}

import { Component, OnInit, AfterViewInit } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit, AfterViewInit{
  constructor() { }

  ngOnInit() {
  }

  ngAfterViewInit(): void {
    console.log("about page")
  }

}

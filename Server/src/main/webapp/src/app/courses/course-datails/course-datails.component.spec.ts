import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseDatailsComponent } from './course-datails.component';

describe('CourseDatailsComponent', () => {
  let component: CourseDatailsComponent;
  let fixture: ComponentFixture<CourseDatailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseDatailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseDatailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

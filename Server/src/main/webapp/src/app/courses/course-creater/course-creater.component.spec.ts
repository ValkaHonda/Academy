import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseCreaterComponent } from './course-creater.component';

describe('CourseCreaterComponent', () => {
  let component: CourseCreaterComponent;
  let fixture: ComponentFixture<CourseCreaterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseCreaterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseCreaterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

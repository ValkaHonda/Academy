import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModuleCreaterComponent } from './module-creater.component';

describe('ModuleCreaterComponent', () => {
  let component: ModuleCreaterComponent;
  let fixture: ComponentFixture<ModuleCreaterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModuleCreaterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModuleCreaterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

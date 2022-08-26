import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterScreenComponent_cl } from './register-screen.component';

describe('RegisterScreenComponent', () => {
  let component: RegisterScreenComponent_cl;
  let fixture: ComponentFixture<RegisterScreenComponent_cl>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterScreenComponent_cl ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterScreenComponent_cl);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

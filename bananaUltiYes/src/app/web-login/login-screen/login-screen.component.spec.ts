import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginScreenComponent_cl } from './login-screen.component';

describe('LoginScreenComponent', () => {
  let component: LoginScreenComponent_cl;
  let fixture: ComponentFixture<LoginScreenComponent_cl>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginScreenComponent_cl ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginScreenComponent_cl);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

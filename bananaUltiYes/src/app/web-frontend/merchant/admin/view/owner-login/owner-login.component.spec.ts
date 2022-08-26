import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerLoginComponent_cl } from './owner-login.component';

describe('OwnerLoginComponent', () => {
  let component: OwnerLoginComponent_cl;
  let fixture: ComponentFixture<OwnerLoginComponent_cl>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OwnerLoginComponent_cl ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerLoginComponent_cl);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

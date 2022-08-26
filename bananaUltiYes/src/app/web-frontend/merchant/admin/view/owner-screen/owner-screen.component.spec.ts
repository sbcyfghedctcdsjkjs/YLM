import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerScreenComponent_cl } from './owner-screen.component';

describe('OwnerScreenComponent_cl', () => {
  let component: OwnerScreenComponent_cl;
  let fixture: ComponentFixture<OwnerScreenComponent_cl>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OwnerScreenComponent_cl ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerScreenComponent_cl);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

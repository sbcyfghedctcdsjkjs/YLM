import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewerScreenComponent_cl } from './viewer-screen.component';

describe('ViewerScreenComponent_cl', () => {
  let component: ViewerScreenComponent_cl;
  let fixture: ComponentFixture<ViewerScreenComponent_cl>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewerScreenComponent_cl ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewerScreenComponent_cl);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

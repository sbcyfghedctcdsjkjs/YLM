import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowScreenComponent_cl } from './show-screen.component';

describe('ShowScreenComponent', () => {
  let component: ShowScreenComponent_cl;
  let fixture: ComponentFixture<ShowScreenComponent_cl>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowScreenComponent_cl ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowScreenComponent_cl);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

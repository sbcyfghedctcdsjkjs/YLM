import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ToolbarComponent_cl } from './toolbar.component';

describe('ToolbarComponent_cl', () => {
  let component: ToolbarComponent_cl;
  let fixture: ComponentFixture<ToolbarComponent_cl>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ToolbarComponent_cl ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ToolbarComponent_cl);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

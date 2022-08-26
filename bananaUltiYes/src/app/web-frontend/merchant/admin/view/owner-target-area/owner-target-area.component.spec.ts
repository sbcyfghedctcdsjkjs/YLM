import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerTargetAreaComponent_cl } from './owner-target-area.component';

describe('OwnerTargetAreaComponent', () => {
  let component: OwnerTargetAreaComponent_cl;
  let fixture: ComponentFixture<OwnerTargetAreaComponent_cl>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OwnerTargetAreaComponent_cl ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerTargetAreaComponent_cl);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

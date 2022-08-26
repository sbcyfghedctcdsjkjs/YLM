import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerToolbarComponent_cl } from './owner-toolbar.component';

describe('OwnerToolbarComponent_cl', () => {
  let component: OwnerToolbarComponent_cl;
  let fixture: ComponentFixture<OwnerToolbarComponent_cl>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OwnerToolbarComponent_cl ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerToolbarComponent_cl);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

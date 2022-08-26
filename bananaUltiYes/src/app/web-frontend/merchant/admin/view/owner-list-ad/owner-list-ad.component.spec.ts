import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerListAdComponent_cl } from './owner-list-ad.component';

describe('OwnerListAdComponent', () => {
  let component: OwnerListAdComponent_cl;
  let fixture: ComponentFixture<OwnerListAdComponent_cl>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OwnerListAdComponent_cl ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerListAdComponent_cl);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

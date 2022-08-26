import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerSideNavComponent_cl } from './owner-side-nav.component';

describe('OwnerSideNavComponent', () => {
  let component: OwnerSideNavComponent_cl;
  let fixture: ComponentFixture<OwnerSideNavComponent_cl>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OwnerSideNavComponent_cl ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerSideNavComponent_cl);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SideNavComponent_cl } from './side-nav.component';

describe('SideNavComponent', () => {
  let component: SideNavComponent_cl;
  let fixture: ComponentFixture<SideNavComponent_cl>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SideNavComponent_cl ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SideNavComponent_cl);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

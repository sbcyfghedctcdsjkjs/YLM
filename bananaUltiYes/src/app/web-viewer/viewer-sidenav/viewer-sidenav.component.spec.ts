import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewerSidenavComponent } from './viewer-sidenav.component';

describe('ViewerSidenavComponent', () => {
  let component: ViewerSidenavComponent;
  let fixture: ComponentFixture<ViewerSidenavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewerSidenavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewerSidenavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

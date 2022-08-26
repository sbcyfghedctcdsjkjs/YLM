import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CallOwnerUploadComponent } from './call-owner-upload.component';

describe('CallOwnerUploadComponent', () => {
  let component: CallOwnerUploadComponent;
  let fixture: ComponentFixture<CallOwnerUploadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CallOwnerUploadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CallOwnerUploadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

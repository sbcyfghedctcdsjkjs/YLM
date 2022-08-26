import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AskToResetSecretComponent } from './ask-to-reset-secret.component';

describe('AskToResetSecretComponent', () => {
  let component: AskToResetSecretComponent;
  let fixture: ComponentFixture<AskToResetSecretComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AskToResetSecretComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AskToResetSecretComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

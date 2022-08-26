import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FreeWebLoginScreenComponent } from './free-web-login-screen.component';

describe('FreeWebLoginScreenComponent', () => {
  let component: FreeWebLoginScreenComponent;
  let fixture: ComponentFixture<FreeWebLoginScreenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FreeWebLoginScreenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FreeWebLoginScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

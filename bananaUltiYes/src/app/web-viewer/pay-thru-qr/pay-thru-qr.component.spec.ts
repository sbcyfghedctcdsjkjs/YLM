import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PayThruQRComponent } from './pay-thru-qr.component';

describe('PayThruQRComponent', () => {
  let component: PayThruQRComponent;
  let fixture: ComponentFixture<PayThruQRComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PayThruQRComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PayThruQRComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

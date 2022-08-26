import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CartDeliveryAddressComponent } from './cart-delivery-address.component';

describe('CartDeliveryAddressComponent', () => {
  let component: CartDeliveryAddressComponent;
  let fixture: ComponentFixture<CartDeliveryAddressComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CartDeliveryAddressComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CartDeliveryAddressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CartDeliveryAddressComponent_cl } from './cart-delivery-address/cart-delivery-address.component';
import { CartScreenComponent_cl } from './cart-screen/cart-screen.component';
import { OrderCompletedComponent_cl } from './order-completed/order-completed.component';
const routes: Routes = [
   { path: 'cart/:p1_vb/:p2_vb', component: CartScreenComponent_cl }
  ,{ path: 'deliveryAddress/:p1_vb/:p2_vb', component: CartDeliveryAddressComponent_cl }
  
  ,{ path: 'orderCompleted/:p1_vb/:p2_vb', component: OrderCompletedComponent_cl }

];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CartViewerRoutingModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { CartViewerRoutingModule } from './cart-viewer-routing.module';
import { CartScreenComponent_cl } from './cart-screen/cart-screen.component';
import { CartToolbarComponent_cl } from './cart-toolbar/cart-toolbar.component';
import { InfiniteScrollModule } from 'ngx-infinite-scroll';
import { SharedService_cl } from './commonUsed/util/shared-service';

import { AuthServicesService_cl} from './auth/auth-services.service';
import {ApiKeyDto_cl} from './auth/model/api-key-dto';
import { CookieService } from 'ngx-cookie-service';
import { CartDeliveryAddressComponent_cl } from './cart-delivery-address/cart-delivery-address.component';
import { OrderCompletedComponent_cl } from './order-completed/order-completed.component';
import { CartDeliveryAddressMsg_cl } from './cart-delivery-address/propertyComponent/cart-delivery-address-msg';
import { CartOrderCompletedMsg_cl } from './order-completed/propertyComponent/cart-order-completed-msg';
import { CartToolbarMsg_cl } from './cart-toolbar/propertyComponent/cart-toolbar-msg';


import { CartViewerMsg_cl } from './cart-screen/propertyComponent/cart-viewer-msg';
@NgModule({
  declarations: [CartScreenComponent_cl, CartToolbarComponent_cl, CartViewerMsg_cl,
    CartDeliveryAddressMsg_cl,CartOrderCompletedMsg_cl,CartToolbarMsg_cl,
    CartDeliveryAddressComponent_cl, OrderCompletedComponent_cl],
  imports: [
    CommonModule, CartViewerRoutingModule, InfiniteScrollModule,

    
    ReactiveFormsModule, 
  ],
  providers: [AuthServicesService_cl,ApiKeyDto_cl,SharedService_cl,CookieService],
  bootstrap: []
})
export class CartViewerModule { }

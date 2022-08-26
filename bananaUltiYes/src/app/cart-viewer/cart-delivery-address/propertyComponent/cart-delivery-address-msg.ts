import { Component, OnInit, Input } from '@angular/core';
import { CartDeliveryAddressPropertiesEn } from '../../commonUsed/util/properties/appPropertiesEn';
import { CartDeliveryAddressPropertiesHn } from '../../commonUsed/util/properties/appPropertiesHn';
import { CartDeliveryAddressPropertiesBng } from '../../commonUsed/util/properties/appPropertiesBng';
import { CartDeliveryAddressPropertiesGj } from '../../commonUsed/util/properties/appPropertiesGj';
import { CartDeliveryAddressPropertiesKn } from '../../commonUsed/util/properties/appPropertiesKn';
import { CartDeliveryAddressPropertiesMl } from '../../commonUsed/util/properties/appPropertiesMl';
import { CartDeliveryAddressPropertiesMr } from '../../commonUsed/util/properties/appPropertiesMr';

import { CartDeliveryAddressPropertiesPa } from '../../commonUsed/util/properties/appPropertiesPa';
import { CartDeliveryAddressPropertiesTa } from '../../commonUsed/util/properties/appPropertiesTa';
import { CartDeliveryAddressPropertiesTe } from '../../commonUsed/util/properties/appPropertiesTe';
import { CartDeliveryAddressPropertiesUr } from '../../commonUsed/util/properties/appPropertiesUr';
import { CartToolbarComponent_cl } from '../../cart-toolbar/cart-toolbar.component';
@Component({
  selector: 'cart-delivery-address-msg',
  template: `{{finalMessage_vb}}`,
  styleUrls: ['../../commonUsed/util/properties/propertyComponents/properties.component.css']
})
export class CartDeliveryAddressMsg_cl implements OnInit {
  constructor() { }
  @Input() messageSeek_vb;
  @Input() finalMessage_vb;
  ngOnInit(): void {
    if(CartToolbarComponent_cl.language_vb=='en')
    {this.finalMessage_vb = CartDeliveryAddressPropertiesEn[this.messageSeek_vb];}
    
    if(CartToolbarComponent_cl.language_vb=='hi')
    {this.finalMessage_vb = CartDeliveryAddressPropertiesHn[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='bn')
    {this.finalMessage_vb = CartDeliveryAddressPropertiesBng[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='gu')
    {this.finalMessage_vb = CartDeliveryAddressPropertiesGj[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='kn')
    {this.finalMessage_vb = CartDeliveryAddressPropertiesKn[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ml')
    {this.finalMessage_vb = CartDeliveryAddressPropertiesMl[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='mr')
    {this.finalMessage_vb = CartDeliveryAddressPropertiesMr[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='pa')
    {this.finalMessage_vb = CartDeliveryAddressPropertiesPa[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ta')
    {this.finalMessage_vb = CartDeliveryAddressPropertiesTa[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='te')
    {this.finalMessage_vb = CartDeliveryAddressPropertiesTe[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ur')
    {this.finalMessage_vb = CartDeliveryAddressPropertiesUr[this.messageSeek_vb];}
  }

  getMsg_mt(msgSeek_vb:string):string{
    if(CartToolbarComponent_cl.language_vb=='en')
    {return CartDeliveryAddressPropertiesEn[msgSeek_vb];}
  
  
    if(CartToolbarComponent_cl.language_vb=='hi')
    {return CartDeliveryAddressPropertiesHn[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='bn')
    {return CartDeliveryAddressPropertiesBng[msgSeek_vb];}
  
    if(CartToolbarComponent_cl.language_vb=='gu')
    {return CartDeliveryAddressPropertiesGj[msgSeek_vb];}
  
  
    if(CartToolbarComponent_cl.language_vb=='kn')
    {return CartDeliveryAddressPropertiesKn[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ml')
    {return CartDeliveryAddressPropertiesMl[msgSeek_vb];}
  
  
    if(CartToolbarComponent_cl.language_vb=='mr')
    {return CartDeliveryAddressPropertiesMr[msgSeek_vb];}
  
    if(CartToolbarComponent_cl.language_vb=='pa')
    {return CartDeliveryAddressPropertiesPa[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ta')
    {return CartDeliveryAddressPropertiesTa[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='te')
    {return CartDeliveryAddressPropertiesTe[msgSeek_vb];}
  
    if(CartToolbarComponent_cl.language_vb=='ur')
    {return CartDeliveryAddressPropertiesUr[msgSeek_vb];}
  }
}
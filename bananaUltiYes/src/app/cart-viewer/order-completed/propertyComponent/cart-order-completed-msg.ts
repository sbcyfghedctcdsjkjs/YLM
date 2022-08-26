import { Component, OnInit, Input } from '@angular/core';
import { CartOrderCompletedPropertiesEn } from '../../commonUsed/util/properties/appPropertiesEn';
import { CartOrderCompletedPropertiesHn } from '../../commonUsed/util/properties/appPropertiesHn';
import { CartOrderCompletedPropertiesBng } from '../../commonUsed/util/properties/appPropertiesBng';
import { CartOrderCompletedPropertiesGj } from '../../commonUsed/util/properties/appPropertiesGj';
import { CartOrderCompletedPropertiesKn } from '../../commonUsed/util/properties/appPropertiesKn';
import { CartOrderCompletedPropertiesMl } from '../../commonUsed/util/properties/appPropertiesMl';
import { CartOrderCompletedPropertiesMr } from '../../commonUsed/util/properties/appPropertiesMr';

import { CartOrderCompletedPropertiesPa } from '../../commonUsed/util/properties/appPropertiesPa';
import { CartOrderCompletedPropertiesTa } from '../../commonUsed/util/properties/appPropertiesTa';
import { CartOrderCompletedPropertiesTe } from '../../commonUsed/util/properties/appPropertiesTe';
import { CartOrderCompletedPropertiesUr } from '../../commonUsed/util/properties/appPropertiesUr';
import { CartToolbarComponent_cl } from '../../cart-toolbar/cart-toolbar.component';
@Component({
  selector: 'cart-order-completed-msg',
  template: `{{finalMessage_vb}}`,
  styleUrls: ['../../commonUsed/util/properties/propertyComponents/properties.component.css']
})
export class CartOrderCompletedMsg_cl implements OnInit {
  constructor() { }
  @Input() messageSeek_vb;
  @Input() finalMessage_vb;
  ngOnInit(): void {
    if(CartToolbarComponent_cl.language_vb=='en')
    {this.finalMessage_vb = CartOrderCompletedPropertiesEn[this.messageSeek_vb];}
    
    if(CartToolbarComponent_cl.language_vb=='hi')
    {this.finalMessage_vb = CartOrderCompletedPropertiesHn[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='bn')
    {this.finalMessage_vb = CartOrderCompletedPropertiesBng[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='gu')
    {this.finalMessage_vb = CartOrderCompletedPropertiesGj[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='kn')
    {this.finalMessage_vb = CartOrderCompletedPropertiesKn[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ml')
    {this.finalMessage_vb = CartOrderCompletedPropertiesMl[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='mr')
    {this.finalMessage_vb = CartOrderCompletedPropertiesMr[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='pa')
    {this.finalMessage_vb = CartOrderCompletedPropertiesPa[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ta')
    {this.finalMessage_vb = CartOrderCompletedPropertiesTa[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='te')
    {this.finalMessage_vb = CartOrderCompletedPropertiesTe[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ur')
    {this.finalMessage_vb = CartOrderCompletedPropertiesUr[this.messageSeek_vb];}
    
  }

  getMsg_mt(msgSeek_vb:string):string{
    if(CartToolbarComponent_cl.language_vb=='en')
    {return CartOrderCompletedPropertiesEn[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='hi')
    {return CartOrderCompletedPropertiesHn[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='bn')
    {return CartOrderCompletedPropertiesBng[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='gu')
    {return CartOrderCompletedPropertiesGj[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='kn')
    {return CartOrderCompletedPropertiesKn[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ml')
    {return CartOrderCompletedPropertiesMl[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='mr')
    {return CartOrderCompletedPropertiesMr[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='pa')
    {return CartOrderCompletedPropertiesPa[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ta')
    {return CartOrderCompletedPropertiesTa[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='te')
    {return CartOrderCompletedPropertiesTe[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ur')
    {return CartOrderCompletedPropertiesUr[msgSeek_vb];}
  }
}
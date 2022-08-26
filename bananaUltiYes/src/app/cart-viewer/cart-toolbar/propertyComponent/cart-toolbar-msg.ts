import { Component, OnInit, Input } from '@angular/core';
import { CartToolbarComponent_cl } from '../cart-toolbar.component';
import { CartToolbarPropertiesEn } from '../../commonUsed/util/properties/appPropertiesEn';
import { CartToolbarPropertiesHn } from '../../commonUsed/util/properties/appPropertiesHn';
import { CartToolbarPropertiesBng } from '../../commonUsed/util/properties/appPropertiesBng';
import { CartToolbarPropertiesGj } from '../../commonUsed/util/properties/appPropertiesGj';
import { CartToolbarPropertiesKn } from '../../commonUsed/util/properties/appPropertiesKn';
import { CartToolbarPropertiesMl } from '../../commonUsed/util/properties/appPropertiesMl';

import { CartToolbarPropertiesMr } from '../../commonUsed/util/properties/appPropertiesMr';
import { CartToolbarPropertiesPa } from '../../commonUsed/util/properties/appPropertiesPa';
import { CartToolbarPropertiesTa } from '../../commonUsed/util/properties/appPropertiesTa';
import { CartToolbarPropertiesTe } from '../../commonUsed/util/properties/appPropertiesTe';
import { CartToolbarPropertiesUr } from '../../commonUsed/util/properties/appPropertiesUr';

@Component({
  selector: 'cart-toolbar-msg',
  template: `{{finalMessage_vb}}`,
  styleUrls: ['../../commonUsed/util/properties/propertyComponents/properties.component.css']
})
export class CartToolbarMsg_cl implements OnInit {
  constructor() { }
   
  @Input() messageSeek_vb;
  @Input() finalMessage_vb;

  ngOnInit(): void {
    if(CartToolbarComponent_cl.language_vb=='en')
    {this.finalMessage_vb = CartToolbarPropertiesEn[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='hi')
    {this.finalMessage_vb = CartToolbarPropertiesHn[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='bn')
    {this.finalMessage_vb = CartToolbarPropertiesBng[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='gu')
    {this.finalMessage_vb = CartToolbarPropertiesGj[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='kn')
    {this.finalMessage_vb = CartToolbarPropertiesKn[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ml')
    {this.finalMessage_vb = CartToolbarPropertiesMl[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='mr')
    {this.finalMessage_vb = CartToolbarPropertiesMr[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='pa')
    {this.finalMessage_vb = CartToolbarPropertiesPa[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ta')
    {this.finalMessage_vb = CartToolbarPropertiesTa[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='te')
    {this.finalMessage_vb = CartToolbarPropertiesTe[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ur')
    {this.finalMessage_vb = CartToolbarPropertiesUr[this.messageSeek_vb];}
    
  }

  getMsg_mt(msgSeek_vb:string):string{
    if(CartToolbarComponent_cl.language_vb=='en')
    {return CartToolbarPropertiesEn[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='hi')
    {return CartToolbarPropertiesHn[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='bn')
    {return CartToolbarPropertiesBng[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='gu')
    {return CartToolbarPropertiesGj[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='kn')
    {return CartToolbarPropertiesKn[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ml')
    {return CartToolbarPropertiesMl[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='mr')
    {return CartToolbarPropertiesMr[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='pa')
    {return CartToolbarPropertiesPa[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ta')
    {return CartToolbarPropertiesTa[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='te')
    {return CartToolbarPropertiesTe[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ur')
    {return CartToolbarPropertiesUr[msgSeek_vb];}
    
    
  }

}
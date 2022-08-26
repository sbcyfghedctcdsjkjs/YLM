import { Component, OnInit, Input } from '@angular/core';
import { CartViewerScreenPropertiesEn } from '../../commonUsed/util/properties/appPropertiesEn';
import { CartViewerScreenPropertiesHn } from '../../commonUsed/util/properties/appPropertiesHn';
import { CartViewerScreenPropertiesBng } from '../../commonUsed/util/properties/appPropertiesBng';
import { CartViewerScreenPropertiesGj } from '../../commonUsed/util/properties/appPropertiesGj';
import { CartViewerScreenPropertiesKn } from '../../commonUsed/util/properties/appPropertiesKn';
import { CartViewerScreenPropertiesMl } from '../../commonUsed/util/properties/appPropertiesMl';
import { CartViewerScreenPropertiesMr } from '../../commonUsed/util/properties/appPropertiesMr';

import { CartViewerScreenPropertiesPa } from '../../commonUsed/util/properties/appPropertiesPa';
import { CartViewerScreenPropertiesTa } from '../../commonUsed/util/properties/appPropertiesTa';
import { CartViewerScreenPropertiesTe } from '../../commonUsed/util/properties/appPropertiesTe';
import { CartViewerScreenPropertiesUr } from '../../commonUsed/util/properties/appPropertiesUr';
import { CartToolbarComponent_cl } from '../../cart-toolbar/cart-toolbar.component';
@Component({
  selector: 'cart-viewer-msg',
  template: `{{finalMessage_vb}}`,
  styleUrls: ['../../commonUsed/util/properties/propertyComponents/properties.component.css']
})
export class CartViewerMsg_cl implements OnInit {
  constructor() { }
  @Input() messageSeek_vb;
  @Input() finalMessage_vb;
  ngOnInit(): void {
    if(CartToolbarComponent_cl.language_vb=='en')
    {this.finalMessage_vb = CartViewerScreenPropertiesEn[this.messageSeek_vb];}
    
    if(CartToolbarComponent_cl.language_vb=='hi')
    {this.finalMessage_vb = CartViewerScreenPropertiesHn[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='bn')
    {this.finalMessage_vb = CartViewerScreenPropertiesBng[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='gu')
    {this.finalMessage_vb = CartViewerScreenPropertiesGj[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='kn')
    {this.finalMessage_vb = CartViewerScreenPropertiesKn[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ml')
    {this.finalMessage_vb = CartViewerScreenPropertiesMl[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='mr')
    {this.finalMessage_vb = CartViewerScreenPropertiesMr[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='pa')
    {this.finalMessage_vb = CartViewerScreenPropertiesPa[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ta')
    {this.finalMessage_vb = CartViewerScreenPropertiesTa[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='te')
    {this.finalMessage_vb = CartViewerScreenPropertiesTe[this.messageSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ur')
    {this.finalMessage_vb = CartViewerScreenPropertiesUr[this.messageSeek_vb];}
    
  }

  getMsg_mt(msgSeek_vb:string):string{
    if(CartToolbarComponent_cl.language_vb=='en')
    {return CartViewerScreenPropertiesEn[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='hi')
    {return CartViewerScreenPropertiesHn[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='bn')
    {return CartViewerScreenPropertiesBng[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='gu')
    {return CartViewerScreenPropertiesGj[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='kn')
    {return CartViewerScreenPropertiesKn[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ml')
    {return CartViewerScreenPropertiesMl[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='mr')
    {return CartViewerScreenPropertiesMr[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='pa')
    {return CartViewerScreenPropertiesPa[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ta')
    {return CartViewerScreenPropertiesTa[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='te')
    {return CartViewerScreenPropertiesTe[msgSeek_vb];}
    if(CartToolbarComponent_cl.language_vb=='ur')
    {return CartViewerScreenPropertiesUr[msgSeek_vb];}
  }
}
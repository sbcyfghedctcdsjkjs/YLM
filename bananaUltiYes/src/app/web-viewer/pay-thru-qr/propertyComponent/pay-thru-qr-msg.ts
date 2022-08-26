import { Component, OnInit, Input } from '@angular/core';
import { ToolbarComponent_cl } from '../../toolbar/toolbar.component';
import { PayThruQRScreenPropertiesEn } from '../../commonUsed/util/properties/appPropertiesEn';
import { PayThruQRScreenPropertiesHn } from '../../commonUsed/util/properties/appPropertiesHn';
import { PayThruQRScreenPropertiesBng } from '../../commonUsed/util/properties/appPropertiesBng';
import { PayThruQRScreenPropertiesGj } from '../../commonUsed/util/properties/appPropertiesGj';
import { PayThruQRScreenPropertiesKn } from '../../commonUsed/util/properties/appPropertiesKn';
import { PayThruQRScreenPropertiesMl } from '../../commonUsed/util/properties/appPropertiesMl';

import { PayThruQRScreenPropertiesMr } from '../../commonUsed/util/properties/appPropertiesMr';
import { PayThruQRScreenPropertiesPa } from '../../commonUsed/util/properties/appPropertiesPa';
import { PayThruQRScreenPropertiesTa } from '../../commonUsed/util/properties/appPropertiesTa';
import { PayThruQRScreenPropertiesTe } from '../../commonUsed/util/properties/appPropertiesTe';
import { PayThruQRScreenPropertiesUr } from '../../commonUsed/util/properties/appPropertiesUr';
@Component({
  selector: 'pay-thru-qr-code-msg',
  template: `{{finalMessage_vb}}`,
  styleUrls: ['../../commonUsed/util/properties/propertyComponents/properties.component.css']
})
export class PayThruQRCodeMsg_cl implements OnInit {
  constructor() { }
   
  @Input() messageSeek_vb;
  @Input() finalMessage_vb;


  ngOnInit(): void {    
    if(ToolbarComponent_cl.language_vb=='en')
    {this.finalMessage_vb = PayThruQRScreenPropertiesEn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='hi')
    {this.finalMessage_vb = PayThruQRScreenPropertiesHn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='bn')
    {this.finalMessage_vb = PayThruQRScreenPropertiesBng[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='gu')
    {this.finalMessage_vb = PayThruQRScreenPropertiesGj[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='kn')
    {this.finalMessage_vb = PayThruQRScreenPropertiesKn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ml')
    {this.finalMessage_vb = PayThruQRScreenPropertiesMl[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='mr')
    {this.finalMessage_vb = PayThruQRScreenPropertiesMr[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='pa')
    {this.finalMessage_vb = PayThruQRScreenPropertiesPa[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ta')
    {this.finalMessage_vb = PayThruQRScreenPropertiesTa[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='te')
    {this.finalMessage_vb = PayThruQRScreenPropertiesTe[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ur')
    {this.finalMessage_vb = PayThruQRScreenPropertiesUr[this.messageSeek_vb];}
    
  }

  getMsg_mt(msgSeek_vb:string):string{
    if(ToolbarComponent_cl.language_vb=='en')
    {return PayThruQRScreenPropertiesEn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='hi')
    {return PayThruQRScreenPropertiesHn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='bn')
    {return PayThruQRScreenPropertiesBng[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='gu')
    {return PayThruQRScreenPropertiesGj[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='kn')
    {return PayThruQRScreenPropertiesKn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ml')
    {return PayThruQRScreenPropertiesMl[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='mr')
    {return PayThruQRScreenPropertiesMr[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='pa')
    {return PayThruQRScreenPropertiesPa[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ta')
    {return PayThruQRScreenPropertiesTa[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='te')
    {return PayThruQRScreenPropertiesTe[msgSeek_vb];}    
    if(ToolbarComponent_cl.language_vb=='ur')
    {return PayThruQRScreenPropertiesUr[msgSeek_vb];}
  }

}
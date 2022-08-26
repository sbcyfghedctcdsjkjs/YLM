import { Component, OnInit, Input } from '@angular/core';
import { ToolbarComponent_cl } from '../toolbar.component';
import { ToolbarPropertiesEn } from '../../commonUsed/util/properties/appPropertiesEn';
import { ToolbarPropertiesHn } from '../../commonUsed/util/properties/appPropertiesHn';
import { ToolbarPropertiesBng } from '../../commonUsed/util/properties/appPropertiesBng';
import { ToolbarPropertiesGj } from '../../commonUsed/util/properties/appPropertiesGj';
import { ToolbarPropertiesKn } from '../../commonUsed/util/properties/appPropertiesKn';
import { ToolbarPropertiesMl } from '../../commonUsed/util/properties/appPropertiesMl';

import { ToolbarPropertiesMr } from '../../commonUsed/util/properties/appPropertiesMr';
import { ToolbarPropertiesPa } from '../../commonUsed/util/properties/appPropertiesPa';
import { ToolbarPropertiesTa } from '../../commonUsed/util/properties/appPropertiesTa';
import { ToolbarPropertiesTe } from '../../commonUsed/util/properties/appPropertiesTe';
import { ToolbarPropertiesUr } from '../../commonUsed/util/properties/appPropertiesUr';

@Component({
  selector: 'toolbar-msg',
  template: `{{finalMessage_vb}}`,
  styleUrls: ['../../commonUsed/util/properties/propertyComponents/properties.component.css']
})
export class ToolbarMsg_cl implements OnInit {
  constructor() { }
   
  @Input() messageSeek_vb;
  @Input() finalMessage_vb;

  ngOnInit(): void {
    if(ToolbarComponent_cl.language_vb=='en')
    {this.finalMessage_vb = ToolbarPropertiesEn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='hi')
    {this.finalMessage_vb = ToolbarPropertiesHn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='bn')
    {this.finalMessage_vb = ToolbarPropertiesBng[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='gu')
    {this.finalMessage_vb = ToolbarPropertiesGj[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='kn')
    {this.finalMessage_vb = ToolbarPropertiesKn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ml')
    {this.finalMessage_vb = ToolbarPropertiesMl[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='mr')
    {this.finalMessage_vb = ToolbarPropertiesMr[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='pa')
    {this.finalMessage_vb = ToolbarPropertiesPa[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ta')
    {this.finalMessage_vb = ToolbarPropertiesTa[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='te')
    {this.finalMessage_vb = ToolbarPropertiesTe[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ur')
    {this.finalMessage_vb = ToolbarPropertiesUr[this.messageSeek_vb];}
    
  }

  getMsg_mt(msgSeek_vb:string):string{
    if(ToolbarComponent_cl.language_vb=='en')
    {return ToolbarPropertiesEn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='hi')
    {return ToolbarPropertiesHn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='bn')
    {return ToolbarPropertiesBng[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='gu')
    {return ToolbarPropertiesGj[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='kn')
    {return ToolbarPropertiesKn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ml')
    {return ToolbarPropertiesMl[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='mr')
    {return ToolbarPropertiesMr[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='pa')
    {return ToolbarPropertiesPa[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ta')
    {return ToolbarPropertiesTa[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='te')
    {return ToolbarPropertiesTe[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ur')
    {return ToolbarPropertiesUr[msgSeek_vb];}
    
    
  }

}
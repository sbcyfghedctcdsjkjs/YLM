import { Component, OnInit, Input } from '@angular/core';
import { ToolbarComponent_cl } from '../../toolbar/toolbar.component';
import { RegisterScreenPropertiesEn } from '../../commonUsed/util/properties/appPropertiesEn';
import { RegisterScreenPropertiesHn } from '../../commonUsed/util/properties/appPropertiesHn';
import { RegisterScreenPropertiesBng } from '../../commonUsed/util/properties/appPropertiesBng';
import { RegisterScreenPropertiesGj } from '../../commonUsed/util/properties/appPropertiesGj';
import { RegisterScreenPropertiesKn } from '../../commonUsed/util/properties/appPropertiesKn';
import { RegisterScreenPropertiesMl } from '../../commonUsed/util/properties/appPropertiesMl';

import { RegisterScreenPropertiesMr } from '../../commonUsed/util/properties/appPropertiesMr';
import { RegisterScreenPropertiesPa } from '../../commonUsed/util/properties/appPropertiesPa';
import { RegisterScreenPropertiesTa } from '../../commonUsed/util/properties/appPropertiesTa';
import { RegisterScreenPropertiesTe } from '../../commonUsed/util/properties/appPropertiesTe';
import { RegisterScreenPropertiesUr } from '../../commonUsed/util/properties/appPropertiesUr';
@Component({
  selector: 'registerScreen-msg',
  template: `{{finalMessage_vb}}`,
  styleUrls: ['../../commonUsed/util/properties/propertyComponents/properties.component.css']
})
export class RegisterMsg_cl implements OnInit {

  constructor() { }
   
  @Input() messageSeek_vb;
  @Input() finalMessage_vb;

  ngOnInit(): void {    
    if(ToolbarComponent_cl.language_vb=='en')
    {this.finalMessage_vb = RegisterScreenPropertiesEn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='hn')
    {this.finalMessage_vb = RegisterScreenPropertiesHn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='bng')
    {this.finalMessage_vb = RegisterScreenPropertiesBng[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='gj')
    {this.finalMessage_vb = RegisterScreenPropertiesGj[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='kn')
    {this.finalMessage_vb = RegisterScreenPropertiesKn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ml')
    {this.finalMessage_vb = RegisterScreenPropertiesMl[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='mr')
    {this.finalMessage_vb = RegisterScreenPropertiesMr[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='pa')
    {this.finalMessage_vb = RegisterScreenPropertiesPa[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ta')
    {this.finalMessage_vb = RegisterScreenPropertiesTa[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='te')
    {this.finalMessage_vb = RegisterScreenPropertiesTe[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ur')
    {this.finalMessage_vb = RegisterScreenPropertiesUr[this.messageSeek_vb];}
    
  }

  getMsg_mt(msgSeek_vb:string):string{
    if(ToolbarComponent_cl.language_vb=='en')
    {return RegisterScreenPropertiesEn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='hn')
    {return RegisterScreenPropertiesHn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='bng')
    {return RegisterScreenPropertiesBng[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='gj')
    {return RegisterScreenPropertiesGj[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='kn')
    {return RegisterScreenPropertiesKn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ml')
    {return RegisterScreenPropertiesMl[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='mr')
    {return RegisterScreenPropertiesMr[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='pa')
    {return RegisterScreenPropertiesPa[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ta')
    {return RegisterScreenPropertiesTa[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='te')
    {return RegisterScreenPropertiesTe[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ur')
    {return RegisterScreenPropertiesUr[msgSeek_vb];}
  }
}
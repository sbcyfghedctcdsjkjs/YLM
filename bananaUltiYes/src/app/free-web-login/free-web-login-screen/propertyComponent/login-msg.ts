import { Component, OnInit, Input } from '@angular/core';
import { FreeWebLoginScreenComponent_cl } from '../free-web-login-screen.component';
import { LoginScreenPropertiesEn } from '../../commonUsed/util/properties/appPropertiesEn';
import { LoginScreenPropertiesHn } from '../../commonUsed/util/properties/appPropertiesHn';
import { LoginScreenPropertiesBng } from '../../commonUsed/util/properties/appPropertiesBng';
import { LoginScreenPropertiesGj } from '../../commonUsed/util/properties/appPropertiesGj';
import { LoginScreenPropertiesKn } from '../../commonUsed/util/properties/appPropertiesKn';
import { LoginScreenPropertiesMl } from '../../commonUsed/util/properties/appPropertiesMl';

import { LoginScreenPropertiesMr } from '../../commonUsed/util/properties/appPropertiesMr';
import { LoginScreenPropertiesPa } from '../../commonUsed/util/properties/appPropertiesPa';
import { LoginScreenPropertiesTa } from '../../commonUsed/util/properties/appPropertiesTa';
import { LoginScreenPropertiesTe } from '../../commonUsed/util/properties/appPropertiesTe';
import { LoginScreenPropertiesUr } from '../../commonUsed/util/properties/appPropertiesUr';
@Component({
  selector: 'loginScreen-msg',
  template: `{{finalMessage_vb}}`,
  styleUrls: ['../../commonUsed/util/properties/propertyComponents/properties.component.css']
})
export class FreeLoginMsg_cl implements OnInit {

  constructor() { }
   
  @Input() messageSeek_vb;
  @Input() finalMessage_vb;

  ngOnInit(): void {    
    if(FreeWebLoginScreenComponent_cl.language_vb=='en')
    {this.finalMessage_vb = LoginScreenPropertiesEn[this.messageSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='hi')
    {this.finalMessage_vb = LoginScreenPropertiesHn[this.messageSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='bn')
    {this.finalMessage_vb = LoginScreenPropertiesBng[this.messageSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='gu')
    {this.finalMessage_vb = LoginScreenPropertiesGj[this.messageSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='kn')
    {this.finalMessage_vb = LoginScreenPropertiesKn[this.messageSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='ml')
    {this.finalMessage_vb = LoginScreenPropertiesMl[this.messageSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='mr')
    {this.finalMessage_vb = LoginScreenPropertiesMr[this.messageSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='pa')
    {this.finalMessage_vb = LoginScreenPropertiesPa[this.messageSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='ta')
    {this.finalMessage_vb = LoginScreenPropertiesTa[this.messageSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='te')
    {this.finalMessage_vb = LoginScreenPropertiesTe[this.messageSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='ur')
    {this.finalMessage_vb = LoginScreenPropertiesUr[this.messageSeek_vb];}
   
  }

  getMsg_mt(msgSeek_vb:string):string{
    if(FreeWebLoginScreenComponent_cl.language_vb=='en')
    {return LoginScreenPropertiesEn[msgSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='hi')
    {return LoginScreenPropertiesHn[msgSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='bn')
    {return LoginScreenPropertiesBng[msgSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='gu')
    {return LoginScreenPropertiesGj[msgSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='kn')
    {return LoginScreenPropertiesKn[msgSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='ml')
    {return LoginScreenPropertiesMl[msgSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='mr')
    {return LoginScreenPropertiesMr[msgSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='pa')
    {return LoginScreenPropertiesPa[msgSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='ta')
    {return LoginScreenPropertiesTa[msgSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='te')
    {return LoginScreenPropertiesTe[msgSeek_vb];}
    if(FreeWebLoginScreenComponent_cl.language_vb=='ur')
    {return LoginScreenPropertiesUr[msgSeek_vb];}
  }
}
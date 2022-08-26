import { Component, OnInit, Input } from '@angular/core';
import { ToolbarComponent_cl } from '../../toolbar/toolbar.component';
import { UserSettingScreenPropertiesEn } from '../../commonUsed/util/properties/appPropertiesEn';
import { UserSettingScreenPropertiesHn } from '../../commonUsed/util/properties/appPropertiesHn';
import { UserSettingScreenPropertiesBng } from '../../commonUsed/util/properties/appPropertiesBng';
import { UserSettingScreenPropertiesGj } from '../../commonUsed/util/properties/appPropertiesGj';
import { UserSettingScreenPropertiesKn } from '../../commonUsed/util/properties/appPropertiesKn';
import { UserSettingScreenPropertiesMl } from '../../commonUsed/util/properties/appPropertiesMl';

import { UserSettingScreenPropertiesMr } from '../../commonUsed/util/properties/appPropertiesMr';
import { UserSettingScreenPropertiesPa } from '../../commonUsed/util/properties/appPropertiesPa';
import { UserSettingScreenPropertiesTa } from '../../commonUsed/util/properties/appPropertiesTa';
import { UserSettingScreenPropertiesTe } from '../../commonUsed/util/properties/appPropertiesTe';
import { UserSettingScreenPropertiesUr } from '../../commonUsed/util/properties/appPropertiesUr';


@Component({
  selector: 'user-setting-msg',
  template: `{{finalMessage_vb}}`,
  styleUrls: ['../../commonUsed/util/properties/propertyComponents/properties.component.css']
})
export class UserSettingsMsg_cl implements OnInit {
  constructor() { }
  @Input() messageSeek_vb;
  @Input() finalMessage_vb;

  ngOnInit(): void {

    if(ToolbarComponent_cl.language_vb=='en')
    {this.finalMessage_vb = UserSettingScreenPropertiesEn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='hi')
    {this.finalMessage_vb = UserSettingScreenPropertiesHn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='bn')
    {this.finalMessage_vb = UserSettingScreenPropertiesBng[this.messageSeek_vb];}

    if(ToolbarComponent_cl.language_vb=='gu')
    {this.finalMessage_vb = UserSettingScreenPropertiesGj[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='kn')
    {this.finalMessage_vb = UserSettingScreenPropertiesKn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ml')
    {this.finalMessage_vb = UserSettingScreenPropertiesMl[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='mr')
    {this.finalMessage_vb = UserSettingScreenPropertiesMr[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='pa')
    {this.finalMessage_vb = UserSettingScreenPropertiesPa[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ta')
    {this.finalMessage_vb = UserSettingScreenPropertiesTa[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='te')
    {this.finalMessage_vb = UserSettingScreenPropertiesTe[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ur')
    {this.finalMessage_vb = UserSettingScreenPropertiesUr[this.messageSeek_vb];}
    
  }

  getMsg_mt(msgSeek_vb:string):string{
    
    if(ToolbarComponent_cl.language_vb=='en')
    {return UserSettingScreenPropertiesEn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='hi')
    {return UserSettingScreenPropertiesHn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='bn')
    {return UserSettingScreenPropertiesBng[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='gu')
    {return UserSettingScreenPropertiesGj[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='kn')
    {return UserSettingScreenPropertiesKn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ml')
    {return UserSettingScreenPropertiesMl[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='mr')
    {return UserSettingScreenPropertiesMr[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='pa')
    {return UserSettingScreenPropertiesPa[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ta')
    {return UserSettingScreenPropertiesTa[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='te')
    {return UserSettingScreenPropertiesTe[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ur')
    {return UserSettingScreenPropertiesUr[msgSeek_vb];}
  }

}
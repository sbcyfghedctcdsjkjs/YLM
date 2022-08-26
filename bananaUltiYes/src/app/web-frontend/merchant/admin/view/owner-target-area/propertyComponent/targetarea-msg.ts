import { Component, OnInit, Input } from '@angular/core';
import { OwnerToolbarComponent_cl } from '../../owner-toolbar/owner-toolbar.component';
import { TargetAreaPropertiesEn } from '../../../../../commonUsed/util/properties/appPropertiesEn';
import { TargetAreaPropertiesHn } from '../../../../../commonUsed/util/properties/appPropertiesHn';
import { TargetAreaPropertiesBng } from '../../../../../commonUsed/util/properties/appPropertiesBng';
import { TargetAreaPropertiesGj } from '../../../../../commonUsed/util/properties/appPropertiesGj';
import { TargetAreaPropertiesKn } from '../../../../../commonUsed/util/properties/appPropertiesKn';
import { TargetAreaPropertiesMl } from '../../../../../commonUsed/util/properties/appPropertiesMl';

import { TargetAreaPropertiesMr } from '../../../../../commonUsed/util/properties/appPropertiesMr';
import { TargetAreaPropertiesPa } from '../../../../../commonUsed/util/properties/appPropertiesPa';
import { TargetAreaPropertiesTa } from '../../../../../commonUsed/util/properties/appPropertiesTa';
import { TargetAreaPropertiesTe } from '../../../../../commonUsed/util/properties/appPropertiesTe';
import { TargetAreaPropertiesUr } from '../../../../../commonUsed/util/properties/appPropertiesUr';

@Component({
  selector: 'targetarea-msg',
  template: `{{finalMessage_vb}}`,
  styleUrls: ['../../../../../commonUsed/util/properties/propertyComponents/properties.component.css']
})
export class TargetareaMsg_cl implements OnInit {

  constructor() { }
   
  @Input() messageSeek_vb;
  @Input() finalMessage_vb;

  ngOnInit(): void {    
    if(OwnerToolbarComponent_cl.language_vb=='en')
    {this.finalMessage_vb = TargetAreaPropertiesEn[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='hi')
    {this.finalMessage_vb = TargetAreaPropertiesHn[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='bn')
    {this.finalMessage_vb = TargetAreaPropertiesBng[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='gu')
    {this.finalMessage_vb = TargetAreaPropertiesGj[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='kn')
    {this.finalMessage_vb = TargetAreaPropertiesKn[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ml')
    {this.finalMessage_vb = TargetAreaPropertiesMl[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='mr')
    {this.finalMessage_vb = TargetAreaPropertiesMr[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='pa')
    {this.finalMessage_vb = TargetAreaPropertiesPa[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ta')
    {this.finalMessage_vb = TargetAreaPropertiesTa[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='te')
    {this.finalMessage_vb = TargetAreaPropertiesTe[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ur')
    {this.finalMessage_vb = TargetAreaPropertiesUr[this.messageSeek_vb];}
    
  }

  getMsg_mt(msgSeek_vb:string):string{
    if(OwnerToolbarComponent_cl.language_vb=='en')
    {return TargetAreaPropertiesEn[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='hi')
    {return TargetAreaPropertiesHn[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='bn')
    {return TargetAreaPropertiesBng[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='gu')
    {return TargetAreaPropertiesGj[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='kn')
    {return TargetAreaPropertiesKn[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ml')
    {return TargetAreaPropertiesMl[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='mr')
    {return TargetAreaPropertiesMr[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='pa')
    {return TargetAreaPropertiesPa[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ta')
    {return TargetAreaPropertiesTa[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='te')
    {return TargetAreaPropertiesTe[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ur')
    {return TargetAreaPropertiesUr[msgSeek_vb];}
  }
}
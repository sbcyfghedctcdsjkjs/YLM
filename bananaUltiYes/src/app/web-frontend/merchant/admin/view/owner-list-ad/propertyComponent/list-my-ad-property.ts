import { Component, OnInit, Input } from '@angular/core';
import { OwnerToolbarComponent_cl } from '../../owner-toolbar/owner-toolbar.component';
import { ListMyAddPropertiesEn } from '../../../../../commonUsed/util/properties/appPropertiesEn';
import { ListMyAddPropertiesHn } from '../../../../../commonUsed/util/properties/appPropertiesHn';
import { ListMyAddPropertiesBng } from '../../../../../commonUsed/util/properties/appPropertiesBng';
import { ListMyAddPropertiesGj } from '../../../../../commonUsed/util/properties/appPropertiesGj';
import { ListMyAddPropertiesKn } from '../../../../../commonUsed/util/properties/appPropertiesKn';
import { ListMyAddPropertiesMl } from '../../../../../commonUsed/util/properties/appPropertiesMl';

import { ListMyAddPropertiesMr } from '../../../../../commonUsed/util/properties/appPropertiesMr';
import { ListMyAddPropertiesPa } from '../../../../../commonUsed/util/properties/appPropertiesPa';
import { ListMyAddPropertiesTa } from '../../../../../commonUsed/util/properties/appPropertiesTa';
import { ListMyAddPropertiesTe } from '../../../../../commonUsed/util/properties/appPropertiesTe';
import { ListMyAddPropertiesUr } from '../../../../../commonUsed/util/properties/appPropertiesUr';
@Component({
  selector: 'list-my-ad-msg',
  template: `{{finalMessage_vb}}`,
  styleUrls: ['../../../../../commonUsed/util/properties/propertyComponents/properties.component.css']
})
export class ListMyAdProperty_cl implements OnInit {
  constructor() { toolbar}
   
  @Input() messageSeek_vb;
  @Input() finalMessage_vb;

  ngOnInit(): void {
    if(OwnerToolbarComponent_cl.language_vb=='en')
    {this.finalMessage_vb = ListMyAddPropertiesEn[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='hi')
    {this.finalMessage_vb = ListMyAddPropertiesHn[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='bn')
    {this.finalMessage_vb = ListMyAddPropertiesBng[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='gu')
    {this.finalMessage_vb = ListMyAddPropertiesGj[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='kn')
    {this.finalMessage_vb = ListMyAddPropertiesKn[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ml')
    {this.finalMessage_vb = ListMyAddPropertiesMl[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='mr')
    {this.finalMessage_vb = ListMyAddPropertiesMr[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='pa')
    {this.finalMessage_vb = ListMyAddPropertiesPa[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ta')
    {this.finalMessage_vb = ListMyAddPropertiesTa[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='te')
    {this.finalMessage_vb = ListMyAddPropertiesTe[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ur')
    {this.finalMessage_vb = ListMyAddPropertiesUr[this.messageSeek_vb];}

    
  }

  getMsg_mt(msgSeek_vb:string):string{
    if(OwnerToolbarComponent_cl.language_vb=='en')
    {return ListMyAddPropertiesEn[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='hi')
    {return ListMyAddPropertiesHn[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='bn')
    {return ListMyAddPropertiesBng[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='gu')
    {return ListMyAddPropertiesGj[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='kn')
    {return ListMyAddPropertiesKn[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ml')
    {return ListMyAddPropertiesMl[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='mr')
    {return ListMyAddPropertiesMr[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='pa')
    {return ListMyAddPropertiesPa[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ta')
    {return ListMyAddPropertiesTa[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='te')
    {return ListMyAddPropertiesTe[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ur')
    {return ListMyAddPropertiesUr[msgSeek_vb];}
  }
}
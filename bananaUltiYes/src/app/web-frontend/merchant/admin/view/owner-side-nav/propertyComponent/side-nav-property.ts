import { Component, OnInit, Input } from '@angular/core';
import { OwnerToolbarComponent_cl } from '../../owner-toolbar/owner-toolbar.component';
import { OwnerSideNavPropertiesEn } from '../../../../../commonUsed/util/properties/appPropertiesEn';
import { OwnerSideNavPropertiesHn } from '../../../../../commonUsed/util/properties/appPropertiesHn';
import { OwnerSideNavPropertiesBng } from '../../../../../commonUsed/util/properties/appPropertiesBng';
import { OwnerSideNavPropertiesGj } from '../../../../../commonUsed/util/properties/appPropertiesGj';
import { OwnerSideNavPropertiesKn } from '../../../../../commonUsed/util/properties/appPropertiesKn';
import { OwnerSideNavPropertiesMl } from '../../../../../commonUsed/util/properties/appPropertiesMl';

import { OwnerSideNavPropertiesMr } from '../../../../../commonUsed/util/properties/appPropertiesMr';
import { OwnerSideNavPropertiesPa } from '../../../../../commonUsed/util/properties/appPropertiesPa';
import { OwnerSideNavPropertiesTa } from '../../../../../commonUsed/util/properties/appPropertiesTa';
import { OwnerSideNavPropertiesTe } from '../../../../../commonUsed/util/properties/appPropertiesTe';
import { OwnerSideNavPropertiesUr } from '../../../../../commonUsed/util/properties/appPropertiesUr';
@Component({
  selector: 'owner-sidenav-msg',
  template: `{{finalMessage_vb}}`,
  styleUrls: ['../../../../../commonUsed/util/properties/propertyComponents/properties.component.css']
})
export class SideNavProperty_cl implements OnInit {

  constructor() { }
   
  @Input() messageSeek_vb;
  @Input() finalMessage_vb;

  ngOnInit(): void {
    if(OwnerToolbarComponent_cl.language_vb=='en')
    {this.finalMessage_vb = OwnerSideNavPropertiesEn[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='hi')
    {this.finalMessage_vb = OwnerSideNavPropertiesHn[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='bn')
    {this.finalMessage_vb = OwnerSideNavPropertiesBng[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='gu')
    {this.finalMessage_vb = OwnerSideNavPropertiesGj[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='kn')
    {this.finalMessage_vb = OwnerSideNavPropertiesKn[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ml')
    {this.finalMessage_vb = OwnerSideNavPropertiesMl[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='mr')
    {this.finalMessage_vb = OwnerSideNavPropertiesMr[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='pa')
    {this.finalMessage_vb = OwnerSideNavPropertiesPa[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ta')
    {this.finalMessage_vb = OwnerSideNavPropertiesTa[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='te')
    {this.finalMessage_vb = OwnerSideNavPropertiesTe[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ur')
    {this.finalMessage_vb = OwnerSideNavPropertiesUr[this.messageSeek_vb];}
   
  }

  getMsg_mt(msgSeek_vb:string):string{
    if(OwnerToolbarComponent_cl.language_vb=='en')
    {return OwnerSideNavPropertiesEn[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='hi')
    {return OwnerSideNavPropertiesHn[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='bn')
    {return OwnerSideNavPropertiesBng[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='gu')
    {return OwnerSideNavPropertiesGj[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='kn')
    {return OwnerSideNavPropertiesKn[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ml')
    {return OwnerSideNavPropertiesMl[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='mr')
    {return OwnerSideNavPropertiesMr[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='pa')
    {return OwnerSideNavPropertiesPa[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ta')
    {return OwnerSideNavPropertiesTa[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='te')
    {return OwnerSideNavPropertiesTe[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ur')
    {return OwnerSideNavPropertiesUr[msgSeek_vb];}
    
  }
}
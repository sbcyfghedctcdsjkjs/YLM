import { Component, OnInit, Input } from '@angular/core';
import { OwnerToolbarComponent_cl } from '../../owner-toolbar/owner-toolbar.component';
import { UploadAdScreenPropertiesEn } from '../../../../../commonUsed/util/properties/appPropertiesEn';
import { UploadAdScreenPropertiesHn } from '../../../../../commonUsed/util/properties/appPropertiesHn';
import { UploadAdScreenPropertiesBng } from '../../../../../commonUsed/util/properties/appPropertiesBng';
import { UploadAdScreenPropertiesGj } from '../../../../../commonUsed/util/properties/appPropertiesGj';
import { UploadAdScreenPropertiesKn } from '../../../../../commonUsed/util/properties/appPropertiesKn';
import { UploadAdScreenPropertiesMl } from '../../../../../commonUsed/util/properties/appPropertiesMl';

import { UploadAdScreenPropertiesMr } from '../../../../../commonUsed/util/properties/appPropertiesMr';
import { UploadAdScreenPropertiesPa } from '../../../../../commonUsed/util/properties/appPropertiesPa';
import { UploadAdScreenPropertiesTa } from '../../../../../commonUsed/util/properties/appPropertiesTa';
import { UploadAdScreenPropertiesTe } from '../../../../../commonUsed/util/properties/appPropertiesTe';
import { UploadAdScreenPropertiesUr } from '../../../../../commonUsed/util/properties/appPropertiesUr';
@Component({
  selector: 'upload-ads-msg',
  template: `{{finalMessage_vb}}`,
  styleUrls: ['../../../../../commonUsed/util/properties/propertyComponents/properties.component.css']
})
export class UploadAdsMsgProperty_cl implements OnInit {
  constructor() { }
  @Input() messageSeek_vb;
  @Input() finalMessage_vb;

  ngOnInit(): void {
    if(OwnerToolbarComponent_cl.language_vb=='en')
    {this.finalMessage_vb = UploadAdScreenPropertiesEn[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='hi')
    {this.finalMessage_vb = UploadAdScreenPropertiesHn[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='bn')
    {this.finalMessage_vb = UploadAdScreenPropertiesBng[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='gu')
    {this.finalMessage_vb = UploadAdScreenPropertiesGj[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='kn')
    {this.finalMessage_vb = UploadAdScreenPropertiesKn[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ml')
    {this.finalMessage_vb = UploadAdScreenPropertiesMl[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='mr')
    {this.finalMessage_vb = UploadAdScreenPropertiesMr[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='pa')
    {this.finalMessage_vb = UploadAdScreenPropertiesPa[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ta')
    {this.finalMessage_vb = UploadAdScreenPropertiesTa[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='te')
    {this.finalMessage_vb = UploadAdScreenPropertiesTe[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ur')
    {this.finalMessage_vb = UploadAdScreenPropertiesUr[this.messageSeek_vb];}
  }

  getMsg_mt(msgSeek_vb:string):string{
    if(OwnerToolbarComponent_cl.language_vb=='en')
    {return UploadAdScreenPropertiesEn[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='hi')
    {return UploadAdScreenPropertiesHn[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='bn')
    {return UploadAdScreenPropertiesBng[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='gu')
    {return UploadAdScreenPropertiesGj[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='kn')
    {return UploadAdScreenPropertiesKn[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ml')
    {return UploadAdScreenPropertiesMl[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='mr')
    {return UploadAdScreenPropertiesMr[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='pa')
    {return UploadAdScreenPropertiesPa[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ta')
    {return UploadAdScreenPropertiesTa[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='te')
    {return UploadAdScreenPropertiesTe[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ur')
    {return UploadAdScreenPropertiesUr[msgSeek_vb];}
  }
}
import { Component, OnInit, Input } from '@angular/core';
import { OwnerToolbarComponent_cl } from '../../merchant/admin/view/owner-toolbar/owner-toolbar.component';
import { CommonMessagesEn } from '../../commonUsed/util/properties/appPropertiesEn';
import { CommonMessagesHn } from '../../commonUsed/util/properties/appPropertiesHn';
import { CommonMessagesBng } from '../../commonUsed/util/properties/appPropertiesBng';
import { CommonMessagesGj } from '../../commonUsed/util/properties/appPropertiesGj';
import { CommonMessagesKn } from '../../commonUsed/util/properties/appPropertiesKn';
import { CommonMessagesUr } from '../../commonUsed/util/properties/appPropertiesUr';

@Component({
  selector: 'common-cl-msg',
  template: `{{finalMessage_vb}}`,
  styleUrls: ['../util/properties/propertyComponents/properties.component.css']
})
export class CommonMessages_cl implements OnInit {
  constructor() { toolbar}
   
  @Input() messageSeek_vb;
  @Input() finalMessage_vb;

  ngOnInit(): void {
    
    if(OwnerToolbarComponent_cl.language_vb=='en')
    {this.finalMessage_vb = CommonMessagesEn[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='hi')
    {this.finalMessage_vb = CommonMessagesHn[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='bn')
    {this.finalMessage_vb = CommonMessagesBng[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='gu')
    {this.finalMessage_vb = CommonMessagesGj[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='kn')
    {this.finalMessage_vb = CommonMessagesKn[this.messageSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ur')
    {this.finalMessage_vb = CommonMessagesUr[this.messageSeek_vb];}

    
  }

  getMsg_mt(msgSeek_vb:string):string{
    if(OwnerToolbarComponent_cl.language_vb=='en')
    {return CommonMessagesEn[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='hi')
    {return CommonMessagesHn[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='bn')
    {return CommonMessagesBng[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='gu')
    {return CommonMessagesGj[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='kn')
    {return CommonMessagesKn[msgSeek_vb];}
    if(OwnerToolbarComponent_cl.language_vb=='ur')
    {return CommonMessagesUr[msgSeek_vb];}
  }
}
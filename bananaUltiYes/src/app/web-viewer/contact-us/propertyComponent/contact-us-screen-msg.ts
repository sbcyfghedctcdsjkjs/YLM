import { Component, OnInit, Input } from '@angular/core';
import { ToolbarComponent_cl } from '../../toolbar/toolbar.component';
import { ContactUsScreenPropertiesEn } from '../../commonUsed/util/properties/appPropertiesEn';
import { ContactUsScreenPropertiesHn } from '../../commonUsed/util/properties/appPropertiesHn';
import { ContactUsScreenPropertiesBng } from '../../commonUsed/util/properties/appPropertiesBng';
import { ContactUsScreenPropertiesGj } from '../../commonUsed/util/properties/appPropertiesGj';
import { ContactUsScreenPropertiesKn } from '../../commonUsed/util/properties/appPropertiesKn';
import { ContactUsScreenPropertiesMl } from '../../commonUsed/util/properties/appPropertiesMl';

import { ContactUsScreenPropertiesMr } from '../../commonUsed/util/properties/appPropertiesMr';
import { ContactUsScreenPropertiesPa } from '../../commonUsed/util/properties/appPropertiesPa';
import { ContactUsScreenPropertiesTa } from '../../commonUsed/util/properties/appPropertiesTa';
import { ContactUsScreenPropertiesTe } from '../../commonUsed/util/properties/appPropertiesTe';
import { ContactUsScreenPropertiesUr } from '../../commonUsed/util/properties/appPropertiesUr';


@Component({
  selector: 'contact-us-screen-msg',
  template: `{{finalMessage_vb}}`,
  styleUrls: ['../../commonUsed/util/properties/propertyComponents/properties.component.css']
})
export class ContactUsScreenMsg_cl implements OnInit {
  constructor() { }
  @Input() messageSeek_vb;
  @Input() finalMessage_vb;

  ngOnInit(): void {

    if(ToolbarComponent_cl.language_vb=='en')
    {this.finalMessage_vb = ContactUsScreenPropertiesEn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='hi')
    {this.finalMessage_vb = ContactUsScreenPropertiesHn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='bn')
    {this.finalMessage_vb = ContactUsScreenPropertiesBng[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='gu')
    {this.finalMessage_vb = ContactUsScreenPropertiesGj[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='kn')
    {this.finalMessage_vb = ContactUsScreenPropertiesKn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ml')
    {this.finalMessage_vb = ContactUsScreenPropertiesMl[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='mr')
    {this.finalMessage_vb = ContactUsScreenPropertiesMr[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='pa')
    {this.finalMessage_vb = ContactUsScreenPropertiesPa[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ta')
    {this.finalMessage_vb = ContactUsScreenPropertiesTa[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='te')
    {this.finalMessage_vb = ContactUsScreenPropertiesTe[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ur')
    {this.finalMessage_vb = ContactUsScreenPropertiesUr[this.messageSeek_vb];}

  }

  getMsg_mt(msgSeek_vb:string):string{
    if(ToolbarComponent_cl.language_vb=='en')
    {return ContactUsScreenPropertiesEn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='hi')
    {return ContactUsScreenPropertiesHn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='bn')
    {return ContactUsScreenPropertiesBng[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='gu')
    {return ContactUsScreenPropertiesGj[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='kn')
    {return ContactUsScreenPropertiesKn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ml')
    {return ContactUsScreenPropertiesMl[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='mr')
    {return ContactUsScreenPropertiesMr[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='pa')
    {return ContactUsScreenPropertiesPa[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ta')
    {return ContactUsScreenPropertiesTa[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='te')
    {return ContactUsScreenPropertiesTe[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ur')
    {return ContactUsScreenPropertiesUr[msgSeek_vb];}
  }
}
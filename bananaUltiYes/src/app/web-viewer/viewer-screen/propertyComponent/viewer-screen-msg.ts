import { Component, OnInit, Input } from '@angular/core';
import { ToolbarComponent_cl } from '../../toolbar/toolbar.component';
import { ViewerScreenPropertiesEn } from '../../commonUsed/util/properties/appPropertiesEn';
import { ViewerScreenPropertiesHn } from '../../commonUsed/util/properties/appPropertiesHn';
import { ViewerScreenPropertiesBng } from '../../commonUsed/util/properties/appPropertiesBng';
import { ViewerScreenPropertiesGj } from '../../commonUsed/util/properties/appPropertiesGj';
import { ViewerScreenPropertiesKn } from '../../commonUsed/util/properties/appPropertiesKn';
import { ViewerScreenPropertiesMl } from '../../commonUsed/util/properties/appPropertiesMl';

import { ViewerScreenPropertiesMr } from '../../commonUsed/util/properties/appPropertiesMr';
import { ViewerScreenPropertiesPa } from '../../commonUsed/util/properties/appPropertiesPa';
import { ViewerScreenPropertiesTa } from '../../commonUsed/util/properties/appPropertiesTa';
import { ViewerScreenPropertiesTe } from '../../commonUsed/util/properties/appPropertiesTe';
import { ViewerScreenPropertiesUr } from '../../commonUsed/util/properties/appPropertiesUr';
@Component({
  selector: 'viewer-screen-msg',
  template: `{{finalMessage_vb}}`,
  styleUrls: ['../../commonUsed/util/properties/propertyComponents/properties.component.css']
})
export class ViewerScreenMsg_cl implements OnInit {
  constructor() { }
  @Input() messageSeek_vb;
  @Input() finalMessage_vb;

  ngOnInit(): void {

    if(ToolbarComponent_cl.language_vb=='en')
    {this.finalMessage_vb = ViewerScreenPropertiesEn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='hi')
    {this.finalMessage_vb = ViewerScreenPropertiesHn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='bn')
    {this.finalMessage_vb = ViewerScreenPropertiesBng[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='gu')
    {this.finalMessage_vb = ViewerScreenPropertiesGj[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='kn')
    {this.finalMessage_vb = ViewerScreenPropertiesKn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ml')
    {this.finalMessage_vb = ViewerScreenPropertiesMl[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='mr')
    {this.finalMessage_vb = ViewerScreenPropertiesMr[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='pa')
    {this.finalMessage_vb = ViewerScreenPropertiesPa[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ta')
    {this.finalMessage_vb = ViewerScreenPropertiesTa[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='te')
    {this.finalMessage_vb = ViewerScreenPropertiesTe[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ur')
    {this.finalMessage_vb = ViewerScreenPropertiesUr[this.messageSeek_vb];}
    
  }

  getMsg_mt(msgSeek_vb:string):string{
    if(ToolbarComponent_cl.language_vb=='en')
    {return ViewerScreenPropertiesEn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='hi')
    {return ViewerScreenPropertiesHn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='bn')
    {return ViewerScreenPropertiesBng[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='gu')
    {return ViewerScreenPropertiesGj[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='kn')
    {return ViewerScreenPropertiesKn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ml')
    {return ViewerScreenPropertiesMl[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='mr')
    {return ViewerScreenPropertiesMr[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='pa')
    {return ViewerScreenPropertiesPa[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ta')
    {return ViewerScreenPropertiesTa[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='te')
    {return ViewerScreenPropertiesTe[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ur')
    {return ViewerScreenPropertiesUr[msgSeek_vb];}
  }
}
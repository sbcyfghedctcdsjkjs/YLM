import { Component, OnInit, Input } from '@angular/core';
import { ToolbarComponent_cl } from '../../toolbar/toolbar.component';
import { ViewerSideNavPropertiesEn } from '../../commonUsed/util/properties/appPropertiesEn';
import { ViewerSideNavPropertiesHn } from '../../commonUsed/util/properties/appPropertiesHn';
import { ViewerSideNavPropertiesBng } from '../../commonUsed/util/properties/appPropertiesBng';
import { ViewerSideNavPropertiesGj } from '../../commonUsed/util/properties/appPropertiesGj';
import { ViewerSideNavPropertiesKn } from '../../commonUsed/util/properties/appPropertiesKn';
import { ViewerSideNavPropertiesMl } from '../../commonUsed/util/properties/appPropertiesMl';

import { ViewerSideNavPropertiesMr } from '../../commonUsed/util/properties/appPropertiesMr';
import { ViewerSideNavPropertiesPa } from '../../commonUsed/util/properties/appPropertiesPa';
import { ViewerSideNavPropertiesTa } from '../../commonUsed/util/properties/appPropertiesTa';
import { ViewerSideNavPropertiesTe } from '../../commonUsed/util/properties/appPropertiesTe';
import { ViewerSideNavPropertiesUr } from '../../commonUsed/util/properties/appPropertiesUr';

@Component({
  selector: 'viewer-sidenav-msg',
  template: `{{finalMessage_vb}}`,
  styleUrls: ['../../commonUsed/util/properties/propertyComponents/properties.component.css']
})
export class ViewerSideNavMsg_cl implements OnInit {
  constructor() { }
   
  @Input() messageSeek_vb;
  @Input() finalMessage_vb;

  ngOnInit(): void {
    if(ToolbarComponent_cl.language_vb=='en')
    {this.finalMessage_vb = ViewerSideNavPropertiesEn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='hi')
    {this.finalMessage_vb = ViewerSideNavPropertiesHn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='bn')
    {this.finalMessage_vb = ViewerSideNavPropertiesBng[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='gu')
    {this.finalMessage_vb = ViewerSideNavPropertiesGj[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='kn')
    {this.finalMessage_vb = ViewerSideNavPropertiesKn[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ml')
    {this.finalMessage_vb = ViewerSideNavPropertiesMl[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='mr')
    {this.finalMessage_vb = ViewerSideNavPropertiesMr[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='pa')
    {this.finalMessage_vb = ViewerSideNavPropertiesPa[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ta')
    {this.finalMessage_vb = ViewerSideNavPropertiesTa[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='te')
    {this.finalMessage_vb = ViewerSideNavPropertiesTe[this.messageSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ur')
    {this.finalMessage_vb = ViewerSideNavPropertiesUr[this.messageSeek_vb];}
    
  }


  getMsg_mt(msgSeek_vb:string):string{
    if(ToolbarComponent_cl.language_vb=='en')
    {return ViewerSideNavPropertiesEn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='hi')
    {return ViewerSideNavPropertiesHn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='bn')
    {return ViewerSideNavPropertiesBng[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='gu')
    {return ViewerSideNavPropertiesGj[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='kn')
    {return ViewerSideNavPropertiesKn[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ml')
    {return ViewerSideNavPropertiesMl[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='mr')
    {return ViewerSideNavPropertiesMr[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='pa')
    {return ViewerSideNavPropertiesPa[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ta')
    {return ViewerSideNavPropertiesTa[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='te')
    {return ViewerSideNavPropertiesTe[msgSeek_vb];}
    if(ToolbarComponent_cl.language_vb=='ur')
    {return ViewerSideNavPropertiesUr[msgSeek_vb];}
  }

}
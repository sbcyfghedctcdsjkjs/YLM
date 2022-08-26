import { Component, OnInit } from '@angular/core';
import { AuthServicesService_cl } from '../auth/auth-services.service';
import { ToolbarComponent_cl } from '../toolbar/toolbar.component';
import { ContactUsScreenMsg_cl } from "./propertyComponent/contact-us-screen-msg";
@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']

})

export class ContactUsComponent_cl implements OnInit {
  authServicesService_vb: AuthServicesService_cl;
  constructor(authServicesService_vb: AuthServicesService_cl) {
    this.authServicesService_vb=authServicesService_vb;
    this.changeLang_mt();
   }

  ngOnInit(): void {

  }

  contact_us_heading_msg_vb:string;
  contact_email_sms_whatsapp_msg_vb:string;
  create_free_add_msg_vb:string;
  free_ads_heading_msg_vb:string;
  changeLang_mt(){
    
    ToolbarComponent_cl.language_vb=this.authServicesService_vb.language_vb;
    
    let viewerScreenMsg_vb: ContactUsScreenMsg_cl = new ContactUsScreenMsg_cl();
    this.contact_us_heading_msg_vb = viewerScreenMsg_vb.getMsg_mt("contact_us_heading_msg");
    this.contact_email_sms_whatsapp_msg_vb = viewerScreenMsg_vb.getMsg_mt("contact_email_sms_whatsapp_msg");
    this.create_free_add_msg_vb = viewerScreenMsg_vb.getMsg_mt("create_free_add_msg");
    this.free_ads_heading_msg_vb =  viewerScreenMsg_vb.getMsg_mt("free_ads_heading_msg");
  }

}
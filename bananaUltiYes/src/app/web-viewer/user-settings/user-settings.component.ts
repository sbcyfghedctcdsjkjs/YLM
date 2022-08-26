import { Component, OnInit } from '@angular/core';
import { UserSettingsMsg_cl } from './propertyComponent/user-setting-msg';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthServicesService_cl } from '../auth/auth-services.service';
import { SharedService_cl } from '../commonUsed/util/shared-service';
import { LoginScreen_cl } from '../auth/model/login-screen';
import { ToolbarComponent_cl } from '../toolbar/toolbar.component';
import { ApiKeyDto_cl } from '../auth/model/api-key-dto';

import { Subscription } from 'rxjs';
@Component({
  selector: 'app-user-settings',
  templateUrl: './user-settings.component.html',
  styleUrls: ['./user-settings.component.css']
})
export class UserSettingsComponent_cl implements OnInit {
  loginScreen_vb = new LoginScreen_cl();


  loginForm_vb= this.loginScreen_vb.loginForm_vb;
  apiKeyDto_vb: ApiKeyDto_cl=new ApiKeyDto_cl();
  constructor(private router_vb: Router,private route_vb: ActivatedRoute,
    private authServicesService_vb: AuthServicesService_cl,
    private sharedService_vb:SharedService_cl  ) {
      this.authServicesService_vb.apiKeyDto_vb.apikey_vb=this.route_vb.snapshot.params.p1_vb;

      
    }
    
  ngOnInit(): void {

    this.changeLang_mt(); 

  }
  ngOnDestroy(): void {
    
  }
  doneFlag_vb:any;
  doneMsg_vb:any;
  changeLangSetting_mt(){
    
    const formData_vb = new FormData();
    formData_vb.append('p1', this.loginForm_vb.controls.lang_vb.value);
    
    this.authServicesService_vb.language_vb=this.loginForm_vb.controls.lang_vb.value;
    this.authServicesService_vb.changeLang_mt(formData_vb)
    .subscribe((userDto_vb: any) =>{
      if(userDto_vb ==null) this.doneFlag_vb=false;
                  if(userDto_vb.p3=="Y"){
                    ToolbarComponent_cl.language_vb=this.loginForm_vb.controls.lang_vb.value;
                    this.authServicesService_vb.language_vb=this.loginForm_vb.controls.lang_vb.value;
                    this.doneFlag_vb=true;                    
                    this.changeLang_mt();
                    this.doneMsg_vb=this.lang_change_done_vb;
                  }else{ this.doneFlag_vb=false;
                    ToolbarComponent_cl.language_vb=this.loginForm_vb.controls.lang_vb.value;
                    this.changeLang_mt();
                    this.doneMsg_vb=this.lang_change_not_done_vb;

                  }
                },
        (error_vb) => {this.doneFlag_vb=false;
              ToolbarComponent_cl.language_vb=this.loginForm_vb.controls.lang_vb.value;
              this.doneMsg_vb=this.lang_change_not_done_vb;
                }      
    );  

   }

  label_submit_upload_ads_vb:string;
  lang_change_done_vb:string;
  lang_change_not_done_vb:string;
  changeLang_mt(){
    
    ToolbarComponent_cl.language_vb=this.authServicesService_vb.language_vb;
    let userSettingsMsg_vb: UserSettingsMsg_cl = new UserSettingsMsg_cl();
    
    this.label_submit_upload_ads_vb= userSettingsMsg_vb.getMsg_mt("label_submit_upload_ads_msg");
    this.lang_change_done_vb= userSettingsMsg_vb.getMsg_mt("lang_change_done_msg");
    this.lang_change_not_done_vb= userSettingsMsg_vb.getMsg_mt("lang_change_not_done_msg");
    this.sharedService_vb.sendChangeLangEvent_mt();
  }
}
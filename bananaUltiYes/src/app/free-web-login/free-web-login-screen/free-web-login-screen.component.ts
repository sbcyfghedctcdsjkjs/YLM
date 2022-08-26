import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { AuthServicesService_cl } from '../auth/auth-services.service';
import { ApiKeyDto_cl } from '../auth/model/api-key-dto';
import { FreeLoginScreen_cl } from '../auth/model/free-login-screen';
import { SharedService_cl } from '../commonUsed/util/shared-service';
import { FreeLoginMsg_cl } from './propertyComponent/login-msg';


@Component({
  selector: 'app-free-web-login-screen',
  templateUrl: './free-web-login-screen.component.html',
  styleUrls: ['./free-web-login-screen.component.css']
})

export class FreeWebLoginScreenComponent_cl implements OnInit {


  loginScreen_vb: FreeLoginScreen_cl= new FreeLoginScreen_cl();
  togglePhoneActive_vb:boolean=true;
  toggleEmailActive_vb:boolean=false;
  apiKeyDto_vb: ApiKeyDto_cl=new ApiKeyDto_cl();
  secretNumberValidator_vb=false;
  authorizeDone_vb:Boolean=false;
  loginForm_vb = this.loginScreen_vb.loginForm_vb;
  constructor(apiKeyDto1_vb: ApiKeyDto_cl,private cookieService_vb: CookieService,
    private authServicesService_vb: AuthServicesService_cl,
    private sharedService_vb:SharedService_cl,private route_vb: ActivatedRoute,) { 
    
      this.apiKeyDto_vb.apikey_vb=this.route_vb.snapshot.params.p1_vb;
      this.authServicesService_vb.apiKeyDto_vb.apikey_vb=this.apiKeyDto_vb.apikey_vb;
      cookieService_vb.set("apikey_vb",this.authServicesService_vb.apiKeyDto_vb.apikey_vb);
      // this.clickEventsubscription_vb = this.sharedService_vb.getClickEvent_mt().subscribe(()=>{
      //   this.changeLang_mt();
      //   })
    }

  ngOnInit(): void {
  }

  activatePhoneContent_mt(){
    this.togglePhoneActive_vb=true;
    this.loginForm_vb.controls.ownerEmail_vb.setValue('');
    this.loginForm_vb.controls.identify_vb.setValue('phone');
  }

  activateEmailContent_mt(){
    this.togglePhoneActive_vb=false;
    this.loginForm_vb.controls.ownerPhone_vb.setValue('');
    this.loginForm_vb.controls.identify_vb.setValue('email');
  }

  loginSubmit_mt(){
  }

  static language_vb:string='en';
  login_heading_vb:string;
  forgot_secret_number_vb:string;
  login_app_desc_1_vb:string;
  login_app_desc_2_vb:string;
  login_app_desc_3_vb:string;
  login_app_desc_4_vb:string;
  login_app_desc_5_vb:string;
  label_submit_upload_ads_vb:string;
  r_u_new_user_label_vb:string;
  go_to_register_here_vb:string;
  secretNum_input_label_vb:string;
  
  email_input_label_vb:string;
  phone_input_label_vb:string;
  use_phone_auth_vb:string;
  use_email_auth_vb:string;

  changeLang_mt(){
    let loginMsg_vb: FreeLoginMsg_cl = new FreeLoginMsg_cl();

    this.login_heading_vb   = loginMsg_vb.getMsg_mt("login_heading_msg");
    this.login_app_desc_1_vb= loginMsg_vb.getMsg_mt("login_app_desc_1_msg");
    this.login_app_desc_2_vb= loginMsg_vb.getMsg_mt("login_app_desc_2_msg");
    this.login_app_desc_3_vb= loginMsg_vb.getMsg_mt("login_app_desc_3_msg");
    this.login_app_desc_4_vb= loginMsg_vb.getMsg_mt("login_app_desc_4_msg");
    this.login_app_desc_5_vb= loginMsg_vb.getMsg_mt("login_app_desc_5_msg");
    this.forgot_secret_number_vb=loginMsg_vb.getMsg_mt("forgot_secret_number_msg");
    this.label_submit_upload_ads_vb = loginMsg_vb.getMsg_mt("label_submit_upload_ads_msg");
    this.r_u_new_user_label_vb = loginMsg_vb.getMsg_mt("r_u_new_user_label_msg");
    this.go_to_register_here_vb = loginMsg_vb.getMsg_mt("go_to_register_here_msg");
    this.secretNum_input_label_vb = loginMsg_vb.getMsg_mt("secretNum_input_label_msg");
    this.email_input_label_vb = loginMsg_vb.getMsg_mt("email_input_label_msg");

    this.phone_input_label_vb = loginMsg_vb.getMsg_mt("phone_input_label_msg");
    this.use_phone_auth_vb = loginMsg_vb.getMsg_mt("use_phone_auth_msg");
    this.use_email_auth_vb = loginMsg_vb.getMsg_mt("use_email_auth_msg");

  }
}

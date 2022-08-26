import { Component, OnInit } from '@angular/core';
import {ResetSecretNumberMsg_cl} from './propertyComponent/reset-secret-num-msg';
import {LoginScreen_cl} from '../auth/model/login-screen';
import { ApiKeyDto_cl } from '../auth/model/api-key-dto';
import { Subscription } from 'rxjs';
import { AuthServicesService_cl } from '../auth/auth-services.service';
import { SharedService_cl } from '../commonUsed/util/shared-service';
import { Router } from '@angular/router';

import { ToolbarComponent_cl } from '../toolbar/toolbar.component';
@Component({
  selector: 'app-reset-secret-num',
  templateUrl: './reset-secret-num.component.html',
  styleUrls: ['./reset-secret-num.component.css']
})
export class ResetSecretNumComponent_cl implements OnInit {
  togglePhoneActive_vb:boolean=true;


  toggleEmailActive_vb:boolean=false;
  old_secretNumberValidator_vb:boolean;
  secretNumberValidator_vb:boolean;
  authorizeDone_vb:boolean=false;
  apiKeyDto_vb: ApiKeyDto_cl=new ApiKeyDto_cl();
  identifyPhoneValidator_vb:boolean=false;
  identifyEmailValidator_vb:boolean=false;
  changeLangEventsubscription_vb:Subscription;

  pageName_vb:string="zqsdxw2387d";//b
  constructor( apiKeyDto1_vb: ApiKeyDto_cl,
    private authServicesService_vb: AuthServicesService_cl,
    private sharedService_vb:SharedService_cl,private router_vb: Router) { 
      this.apiKeyDto_vb= this.authServicesService_vb.readApiKeyDto_mt();
      this.changeLangEventsubscription_vb = this.sharedService_vb.getChangeLangEvent_mt().subscribe(()=>{
        this.changeLang_mt();
        })
  }
  loginMsg_vb: ResetSecretNumberMsg_cl = new ResetSecretNumberMsg_cl();
  authorizeMsg_vb:string;
  ngOnInit(): void {
    this.arrivalToThePage_mt(this.pageName_vb);
    
  }
  ngOnDestroy(): void {
    this.changeLangEventsubscription_vb.unsubscribe();    
  }
  
  loginScreen_vb: LoginScreen_cl= new LoginScreen_cl();
  loginForm_vb = this.loginScreen_vb.loginForm_vb;


  resetFormValidatorSuccess_mt(): boolean
  {
    var isValid_vb:boolean=true ;
 
     
       if(this.togglePhoneActive_vb && 
          this.loginScreen_vb.loginForm_vb.controls.ownerPhone_vb.value=='')
        {
          this.identifyPhoneValidator_vb=true;
          this.loginScreen_vb.loginForm_vb.controls.ownerPhone_vb.setErrors({required: true});
          isValid_vb=false;
       
        }
       
      if(!this.togglePhoneActive_vb && 
          this.loginScreen_vb.loginForm_vb.controls.ownerEmail_vb.value=='')
        {
          this.identifyEmailValidator_vb=true;
          this.loginScreen_vb.loginForm_vb.controls.ownerEmail_vb.setErrors({required: true});
          isValid_vb=false;
       
        }

      
      if(this.loginScreen_vb.loginForm_vb.controls.old_secretNumber_vb.value=="")
      {
        this.old_secretNumberValidator_vb=true;
        this.loginScreen_vb.loginForm_vb.controls.old_secretNumber_vb.setErrors({required: true});

      
        isValid_vb=false;
      }

      if(this.loginScreen_vb.loginForm_vb.controls.secretNumber_vb.value=="")
      {
        this.secretNumberValidator_vb=true;
        this.loginScreen_vb.loginForm_vb.controls.secretNumber_vb.setErrors({required: true});
      
        isValid_vb=false;
      }
      return isValid_vb;
  }

 

  onSubmit_mt(){
    this.authorizeDone_vb=false;
    if(!this.resetFormValidatorSuccess_mt())
    {return;}
    const formData_vb = new FormData();


    formData_vb.append('p1', this.loginScreen_vb.loginForm_vb.controls.ownerEmail_vb.value);
    formData_vb.append('p2', this.loginScreen_vb.loginForm_vb.controls.ownerPhone_vb.value);
    formData_vb.append('p3', this.loginScreen_vb.loginForm_vb.controls.secretNumber_vb.value);
    formData_vb.append('p4', this.loginScreen_vb.loginForm_vb.controls.old_secretNumber_vb.value);
        this.authServicesService_vb.resetSecretNum_mt(formData_vb)
    .subscribe((userDto_vb: any) => {
    
                        if(userDto_vb.p3=="Y")
                        this.authorizeMsg_vb=this.loginMsg_vb.getMsg_mt("reset_secret_done_msg");
                        if(userDto_vb.p3=="N")
                        this.authorizeMsg_vb=this.loginMsg_vb.getMsg_mt("usr_not_exist_msg");
                        this.authorizeDone_vb=true;
                      },
              (err_vb) =>  {
                          this.authorizeMsg_vb=this.loginMsg_vb.getMsg_mt("msg_refresh_msg");
                          this.authorizeDone_vb=true;
                          
                        }
    );   
  }

  onClose_mt(){
    this.authServicesService_vb.setApiKeyDto_mt(this.apiKeyDto_vb);
    let goto_vb='/xskdihhsdowqi2423156471hviweroqw017ewg1632jvhq2';
    this.router_vb.navigate([goto_vb]);
  }

  arrivalToThePage_mt(pageName_vb){
    const formData_vb = new FormData();
    formData_vb.append('p1', pageName_vb);

    this.authServicesService_vb.recordPlainTrack_vb(formData_vb)
            .subscribe((arrivalRes_vb: any) =>{
              if(arrivalRes_vb.p3=="N"){
                  this.corruptEveryThing_mt();
              }

                  },
                (error_vb) => {console.log(error_vb);
                  this.corruptEveryThing_mt();
                              }      
            );  
   }

      
  corruptEveryThing_mt(){

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
  reset_secret_heading_vb:string;
  email_input_label_vb:string;
  phone_input_label_vb:string;
  use_phone_auth_vb:string;
  use_email_auth_vb:string;

  old_secretNum_input_label_vb:string;
  required_label_vb:string;
  required_email_phone_label_vb:string;
  reset_secret_message_vb:string;
  label_close_vb:string;

  changeLang_mt(){
    ToolbarComponent_cl.language_vb=this.authServicesService_vb.language_vb;
    let loginMsg_vb: ResetSecretNumberMsg_cl = new ResetSecretNumberMsg_cl();
    
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
    this.reset_secret_heading_vb = loginMsg_vb.getMsg_mt("reset_secret_heading_msg");
    this.reset_secret_message_vb = loginMsg_vb.getMsg_mt("reset_secret_message_msg");
    this.old_secretNum_input_label_vb = loginMsg_vb.getMsg_mt("old_secretNum_input_label_msg");
    this.required_label_vb=loginMsg_vb.getMsg_mt("required_label_msg");
    this.required_email_phone_label_vb=loginMsg_vb.getMsg_mt("required_email_phone_label_msg");
    this.label_close_vb=loginMsg_vb.getMsg_mt("label_close_msg");
   
  }
}

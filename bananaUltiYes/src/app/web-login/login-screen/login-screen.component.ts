import { Component, OnInit } from '@angular/core';
import { AuthServicesService_cl } from '../auth/auth-services.service';
import { LoginScreen_cl } from '../auth/model/login-screen';
import { UserDto_cl } from '../auth/model/user-dto';
import { MessageList_cl } from '../commonUsed/util/message-list';
import { ApiKeyDto_cl} from '../auth/model/api-key-dto';
import {LoginMsg_cl} from '../login-screen/propertyComponent/login-msg';
import { SharedService_cl } from '../commonUsed/util/shared-service';

import { Subscription } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-login-screen',
  templateUrl: './login-screen.component.html',
  styleUrls: ['./login-screen.component.css']
})
export class LoginScreenComponent_cl implements OnInit {
  togglePhoneActive_vb:boolean=true;
  toggleEmailActive_vb:boolean=false;

  apiKeyDto_vb: ApiKeyDto_cl=new ApiKeyDto_cl();
  loginMsg_vb: LoginMsg_cl=new LoginMsg_cl();
  clickEventsubscription_vb:Subscription;

  constructor(apiKeyDto1_vb: ApiKeyDto_cl,private cookieService_vb: CookieService,
      private authServicesService_vb: AuthServicesService_cl,
      private sharedService_vb:SharedService_cl,private route_vb: ActivatedRoute,) { 
      
        this.apiKeyDto_vb.apikey_vb=this.route_vb.snapshot.params.p1_vb;
        this.authServicesService_vb.apiKeyDto_vb.apikey_vb=this.apiKeyDto_vb.apikey_vb;
        cookieService_vb.set("apikey_vb",this.authServicesService_vb.apiKeyDto_vb.apikey_vb);
        this.clickEventsubscription_vb = this.sharedService_vb.getClickEvent_mt().subscribe(()=>{
          this.changeLang_mt();
          })
      }

  loginScreen_vb: LoginScreen_cl= new LoginScreen_cl();
  loginForm_vb = this.loginScreen_vb.loginForm_vb;
  identifyPhoneValidator_vb=false;
  identifyEmailValidator_vb=false;
  secretNumberValidator_vb=false;
  authorizeDone_vb:Boolean=false;
  messageList_vb: MessageList_cl= new MessageList_cl();
  authorizeMsg_vb: String;
  pageName_vb:string="fasSBVuJQni";
  ngOnInit(): void {
    this.loginScreen_vb.loginForm_vb.controls.identify_vb.setValue('phone');
    this.togglePhoneActive_vb=true;
    
    if(this.apiKeyDto_vb.apikey_vb==undefined)
    {       
     

    if(this.cookieService_vb.get("apikey")!='undefined' && 
    this.cookieService_vb.get("apikey")!=undefined && this.cookieService_vb.get("apikey")!='' )
      this.apiKeyDto_vb.apikey_vb=this.cookieService_vb.get("apikey");
    
    else{     
          this.authServicesService_vb.callGetAPIKey_mt(this.pageName_vb);      
        }
    }
    this.arrivalToThePage_mt(this.pageName_vb);    
  }
  ngOnDestroy(): void {
    this.clickEventsubscription_vb.unsubscribe();    
  }

  loginFormValidatorSuccess_mt(): boolean
  {
    var isValid_vb:boolean=true ;
    
   
    if(this.loginScreen_vb.loginForm_vb.controls.identify_vb.value=='phone' && 
        this.loginScreen_vb.loginForm_vb.controls.ownerPhone_vb.value=='')
      {
        this.identifyPhoneValidator_vb=true;
        this.loginScreen_vb.loginForm_vb.controls.ownerPhone_vb.setErrors({required: true});
        isValid_vb=false;
   
      }
   
    if(this.loginScreen_vb.loginForm_vb.controls.identify_vb.value=='email' && 
        this.loginScreen_vb.loginForm_vb.controls.ownerEmail_vb.value=='')
      {
        this.identifyEmailValidator_vb=true;
        this.loginScreen_vb.loginForm_vb.controls.ownerEmail_vb.setErrors({required: true});
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

  loginSubmit_mt(){
    this.authorizeMsg_vb="";
   
    if(!this.loginFormValidatorSuccess_mt())
    {return;}

    if(this.togglePhoneActive_vb) this.loginPhoneSubmit_mt();
    else this.loginEmailSubmit_mt();
  }

  loginPhoneSubmit_mt(){
    this.authorizeDone_vb=false;
   
    const formData_vb = new FormData();


    formData_vb.append('p1', this.loginScreen_vb.loginForm_vb.controls.ownerEmail_vb.value);
    formData_vb.append('p2', this.loginScreen_vb.loginForm_vb.controls.ownerPhone_vb.value);
    formData_vb.append('p3', this.loginScreen_vb.loginForm_vb.controls.secretNumber_vb.value);
    
    this.authServicesService_vb.validateUserByPhone_mt(formData_vb)
    .subscribe((userDto_vb: any) => {
                        if(userDto_vb.p3==="Y")
                        window.location.href= userDto_vb.p2; 
                        if(userDto_vb.p3==="N")
                        this.authorizeMsg_vb=this.loginMsg_vb.getMsg_mt("usr_not_exist_msg");
                        this.authorizeDone_vb=true;
                      },
              (err_vb) =>  {
                          this.authorizeMsg_vb=this.loginMsg_vb.getMsg_mt("msg_refresh_msg");
                          this.authorizeDone_vb=true;
                          
                        }
    );   
  }

  loginEmailSubmit_mt(){
    this.authorizeDone_vb=false;
    

    const formData_vb = new FormData();    
    formData_vb.append('p1', this.loginScreen_vb.loginForm_vb.controls.ownerEmail_vb.value);
    formData_vb.append('p2', this.loginScreen_vb.loginForm_vb.controls.ownerPhone_vb.value);
    formData_vb.append('p3', this.loginScreen_vb.loginForm_vb.controls.secretNumber_vb.value);

    this.authServicesService_vb.validateUserByEmail_mt(formData_vb)
    .subscribe((userDto_vb: any) => {
                        if(userDto_vb.p3==="Y")
                        window.location.href= userDto_vb.p2; 
                        if(userDto_vb.p3==="N"){
                          this.authorizeMsg_vb=this.loginMsg_vb.getMsg_mt("usr_not_exist_msg");
                          this.authorizeDone_vb=true;
                        }
                       },
              (err_vb) =>  {
                        this.authorizeMsg_vb=err_vb.error;
                        this.authorizeMsg_vb=this.loginMsg_vb.getMsg_mt("msg_refresh_msg");
                        this.authorizeDone_vb=true;
                        }
    );   
  }


  arrivalToThePage_mt(pageName_vb){
    const formData_vb = new FormData();
    formData_vb.append('p1', pageName_vb);

    this.authServicesService_vb.recordPlainTrack_mt(formData_vb)
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
   
  onSubmit_mt(){}

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
  
  email_input_label_vb:string;
  phone_input_label_vb:string;
  use_phone_auth_vb:string;
  use_email_auth_vb:string;

  changeLang_mt(){
    let loginMsg_vb: LoginMsg_cl = new LoginMsg_cl();

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

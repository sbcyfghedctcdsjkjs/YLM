import { Component, OnInit } from '@angular/core';
import {AskToResetSecretMsg_cl} from './propertyComponent/ask-to-reset-secret-msg';
import {LoginScreen_cl} from '../auth/model/login-screen';
import { ApiKeyDto_cl } from '../auth/model/api-key-dto';
import { Subscription } from 'rxjs';
import { AuthServicesService_cl } from '../auth/auth-services.service';
import { SharedService_cl } from '../commonUsed/util/shared-service';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-ask-to-reset-secret',
  templateUrl: './ask-to-reset-secret.component.html',
  styleUrls: ['./ask-to-reset-secret.component.css']
})
export class AskToResetSecretComponent_cl implements OnInit {
  togglePhoneActive_vb:boolean=true;
  toggleEmailActive_vb:boolean=false;


  authorizeDone_vb:boolean=false;
  apiKeyDto_vb: ApiKeyDto_cl=new ApiKeyDto_cl();
  clickEventsubscription_vb:Subscription;
  constructor(apiKeyDto1_vb: ApiKeyDto_cl,private cookieService_vb: CookieService,
    private authServicesService_vb: AuthServicesService_cl,
    private sharedService_vb:SharedService_cl) { 
      this.apiKeyDto_vb.apikey_vb=this.authServicesService_vb.apiKeyDto_vb.apikey_vb;
      this.clickEventsubscription_vb = this.sharedService_vb.getClickEvent_mt().subscribe(()=>{
        this.changeLang_mt();
        })
    }
  loginMsg_vb: AskToResetSecretMsg_cl = new AskToResetSecretMsg_cl();
  authorizeMsg_vb:string;
  pageName_vb:string="cAKd8wjASKN";//E
  ngOnInit(): void {
    this.arrivalToThePage_mt(this.pageName_vb);
  }
  loginScreen_vb: LoginScreen_cl= new LoginScreen_cl();
  loginForm_vb = this.loginScreen_vb.loginForm_vb;

  ngOnDestroy(): void {
    this.clickEventsubscription_vb.unsubscribe();    
  }
  onSubmit_mt(){
    this.authorizeDone_vb=false;
    
    const formData_vb = new FormData();


    formData_vb.append('p1', this.loginScreen_vb.loginForm_vb.controls.ownerEmail_vb.value);
    formData_vb.append('p2', this.loginScreen_vb.loginForm_vb.controls.ownerPhone_vb.value);
    formData_vb.append('p3', this.loginScreen_vb.loginForm_vb.controls.secretNumber_vb.value);
    
    this.authServicesService_vb.askToResetSecretNum_mt(formData_vb)
    .subscribe((userDto_vb: any) => {
                        if(userDto_vb.p3==="Y")
                        this.authorizeMsg_vb=this.loginMsg_vb.getMsg_mt("reset_secret_messag2_msg");
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
  go_to_login_here_vb:string;
  reset_secret_message_vb:string;
  changeLang_mt(){
    let loginMsg_vb: AskToResetSecretMsg_cl = new AskToResetSecretMsg_cl();
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
    this.go_to_login_here_vb = loginMsg_vb.getMsg_mt("go_to_login_here_msg");
    this.secretNum_input_label_vb = loginMsg_vb.getMsg_mt("secretNum_input_label_msg");
    this.email_input_label_vb = loginMsg_vb.getMsg_mt("email_input_label_msg");

    this.phone_input_label_vb = loginMsg_vb.getMsg_mt("phone_input_label_msg");
    this.use_phone_auth_vb = loginMsg_vb.getMsg_mt("use_phone_auth_msg");
    this.use_email_auth_vb = loginMsg_vb.getMsg_mt("use_email_auth_msg");
    this.reset_secret_heading_vb = loginMsg_vb.getMsg_mt("reset_secret_heading_msg");
    this.reset_secret_message_vb = loginMsg_vb.getMsg_mt("reset_secret_message_msg");
     
  }
}

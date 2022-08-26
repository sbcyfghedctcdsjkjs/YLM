import { Component, OnInit } from '@angular/core';
import { AuthServicesService_cl } from '../auth/auth-services.service';
import { RegisterScreen_cl } from '../auth/model/register-screen';
import { UserDto_cl } from '../auth/model/user-dto';
import { MessageList_cl } from '../commonUsed/util/message-list';
import { ApiKeyDto_cl} from '../auth/model/api-key-dto';
import { RegisterMsg_cl } from '../register-screen/propertyComponent/register-msg'
import { SharedService_cl } from '../commonUsed/util/shared-service';

import { Subscription } from 'rxjs';
import { ToolbarComponent_cl } from '../toolbar/toolbar.component';
import { CookieService } from 'ngx-cookie-service';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-register-screen',
  templateUrl: './register-screen.component.html',
  styleUrls: ['./register-screen.component.css']
})


export class RegisterScreenComponent_cl implements OnInit {
  
  
  
  toggleEmailActive_vb:boolean=false;
  clickEventsubscription_vb:Subscription;
  validatePhoneEmail_vb:boolean=false;
  secretNumberValidator_vb:boolean=false;
  registerMsg_vb: RegisterMsg_cl=new RegisterMsg_cl();
  apiKeyDto_vb: ApiKeyDto_cl=new ApiKeyDto_cl();

  constructor(apiKeyDto1_vb: ApiKeyDto_cl,private cookieService_vb: CookieService,
    private authServicesService_vb: AuthServicesService_cl
    ,private sharedService_vb:SharedService_cl,private route_vb: ActivatedRoute,) { 
      this.apiKeyDto_vb.apikey_vb=this.route_vb.snapshot.params.p1_vb;
      this.authServicesService_vb.apiKeyDto_vb.apikey_vb=this.apiKeyDto_vb.apikey_vb;
        this.clickEventsubscription_vb = this.sharedService_vb.getClickEvent_mt().subscribe(()=>{
                  this.changeLang_mt();
              })
      }

  registerScreen_vb: RegisterScreen_cl= new RegisterScreen_cl();
  registerForm_vb = this.registerScreen_vb.registerForm_vb;
  
  authorizeDone_vb:Boolean=false;
  messageList_vb: MessageList_cl= new MessageList_cl();
  authorizeMsg_vb: String;
  pageName_vb:string="gasxb26662s";//D
  ngOnInit(): void {
    this.registerScreen_vb.registerForm_vb.controls.ownerPhone_vb.setValue('');
    this.registerScreen_vb.registerForm_vb.controls.ownerEmail_vb.setValue('');
    this.registerScreen_vb.registerForm_vb.controls.secretNumber_vb.setValue('');
    this.registerScreen_vb.registerForm_vb.controls.userName_vb.setValue('');
    
    if(this.apiKeyDto_vb.apikey_vb==undefined)
    {       
      if(this.cookieService_vb.get("apikey")!=undefined)
        this.apiKeyDto_vb.apikey_vb=this.cookieService_vb.get("apikey");
      else
        this.authServicesService_vb.callGetAPIKey_mt(this.pageName_vb);
      
    }
    this.arrivalToThePage_mt(this.pageName_vb);
  }
  ngOnDestroy(): void {
    this.clickEventsubscription_vb.unsubscribe();    
  }

  registerFormValidatorSuccess_mt(): boolean
  {
    var isValid_vb:boolean=true ;
    
    if(this.registerScreen_vb.registerForm_vb.controls.ownerPhone_vb.value=='' &&  
        this.registerScreen_vb.registerForm_vb.controls.ownerEmail_vb.value=='')
      {
        this.validatePhoneEmail_vb=true;
        isValid_vb=false;
        
      } else {this.validatePhoneEmail_vb=false;}
      if(this.registerScreen_vb.registerForm_vb.controls.secretNumber_vb.value=='')
      {
        this.secretNumberValidator_vb=true;
        isValid_vb=false;
      }else {this.secretNumberValidator_vb=false;}
    return isValid_vb;
  }

  
  registerSubmit_mt(){
    if(!this.registerFormValidatorSuccess_mt())
     {return;}
  
    const formData_vb = new FormData();
    formData_vb.append('p1', this.registerScreen_vb.registerForm_vb.controls.secretNumber_vb.value);
    formData_vb.append('p2', this.registerScreen_vb.registerForm_vb.controls.ownerEmail_vb.value);
    formData_vb.append('p3', this.registerScreen_vb.registerForm_vb.controls.ownerPhone_vb.value);
    formData_vb.append('p4', this.registerScreen_vb.registerForm_vb.controls.userName_vb.value);
    formData_vb.append('p6', this.authServicesService_vb.language_vb);
    
    
    this.authServicesService_vb.registerNewUser_mt(formData_vb)
    .subscribe((userDto_vb: any) => {
                        if(userDto_vb.p3==="Y")
                        window.location.href= userDto_vb.p2; 
                        if(userDto_vb.p3==="N")
                        this.authorizeMsg_vb=this.registerMsg_vb.getMsg_mt("usr_exist_msg");
                      },
              (err_vb) =>  {
                          this.authorizeMsg_vb=this.registerMsg_vb.getMsg_mt("msg_refresh_msg");
                          if(err_vb.p3==="N")
                            this.authorizeMsg_vb=this.registerMsg_vb.getMsg_mt("usr_exist_msg");
                        
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


  onSubmit_mt(){
    
  }

  activatePhoneContent_mt(){
    
    this.registerForm_vb.controls.ownerEmail_vb.setValue('');
    
  }

  activateEmailContent_mt(){
    
    this.registerForm_vb.controls.ownerPhone_vb.setValue('');
    
  }
  register_app_desc_1_vb:string;

  register_app_desc_2_vb:string;
  register_app_desc_3_vb:string;
  register_app_desc_4_vb:string;
  register_app_desc_5_vb:string;
  register_app_desc_6_vb:string;
  register_app_desc_7_vb:string;
  phone_input_label_vb:string;
  email_input_label_vb:string;
  secretNum_input_label_vb:string;
  userName_input_label_vb:string;

  label_submit_upload_ads_vb:string;
  already_a_user_label_vb:string;
  go_to_login_here_vb:string;
  or_vb:string;

  changeLang_mt(){
    
    let registerMsg_vb: RegisterMsg_cl = new RegisterMsg_cl();

    this.register_app_desc_1_vb = registerMsg_vb.getMsg_mt("register_app_desc_1_msg");
    this.register_app_desc_2_vb = registerMsg_vb.getMsg_mt("register_app_desc_2_msg");
    this.register_app_desc_3_vb = registerMsg_vb.getMsg_mt("register_app_desc_3_msg");
    this.register_app_desc_4_vb = registerMsg_vb.getMsg_mt("register_app_desc_4_msg");
    this.register_app_desc_5_vb = registerMsg_vb.getMsg_mt("register_app_desc_5_msg");
    this.register_app_desc_6_vb = registerMsg_vb.getMsg_mt("register_app_desc_6_msg");
    this.register_app_desc_7_vb = registerMsg_vb.getMsg_mt("register_app_desc_7_msg");
    this.phone_input_label_vb = registerMsg_vb.getMsg_mt("phone_input_label_msg");
    this.email_input_label_vb = registerMsg_vb.getMsg_mt("email_input_label_msg");
    this.secretNum_input_label_vb = registerMsg_vb.getMsg_mt("secretNum_input_label_msg");
    this.userName_input_label_vb = registerMsg_vb.getMsg_mt("userName_input_label_msg");  
    this.label_submit_upload_ads_vb = registerMsg_vb.getMsg_mt("label_submit_upload_ads_msg");
    this.already_a_user_label_vb = registerMsg_vb.getMsg_mt("already_a_user_label_msg");
    this.go_to_login_here_vb = registerMsg_vb.getMsg_mt("go_to_login_here_msg");
    this.or_vb = registerMsg_vb.getMsg_mt("or_msg");
    
  }

}

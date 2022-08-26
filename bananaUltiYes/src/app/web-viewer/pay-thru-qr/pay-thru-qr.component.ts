import { Component, OnInit } from '@angular/core';
import {PayThruQRCodeMsg_cl} from './propertyComponent/pay-thru-qr-msg';
import { ApiKeyDto_cl } from '../auth/model/api-key-dto';
import { Subscription } from 'rxjs';
import { AuthServicesService_cl } from '../auth/auth-services.service';
import { SharedService_cl } from '../commonUsed/util/shared-service';
import { Router,ActivatedRoute } from '@angular/router';
import { ToolbarComponent_cl } from '../toolbar/toolbar.component';

import { MoneyTransactionScreen_cl } from 'src/app/web-viewer/auth/model/transaction-screen';
import { CookieService } from 'ngx-cookie-service';
@Component({
  selector: 'app-pay-thru-qr',
  templateUrl: './pay-thru-qr.component.html',
  styleUrls: ['./pay-thru-qr.component.css']
})
export class PayThruQRComponent_Cl implements OnInit {
  
  
  
  //apiKeyDto_vb: ApiKeyDto_cl=new ApiKeyDto_cl();
  authorizeDone_vb:boolean;
  moneyTransactionScreen_vb=new MoneyTransactionScreen_cl();
  transactionForm_vb = this.moneyTransactionScreen_vb.transactionForm_vb;
  identifyPhoneValidator_vb:boolean;identifyTransIdValidator_vb:boolean;
  pageName_vb:string="b32125ca51c";
  constructor(private router_vb: Router,private route_vb: ActivatedRoute,
    
    private authServicesService_vb: AuthServicesService_cl,private cookieService_vb: CookieService,
    private sharedService_vb:SharedService_cl ,private apiKeyDto_vb: ApiKeyDto_cl ) {
      
      this.authServicesService_vb.apiKeyDto_vb.apikey_vb=this.route_vb.snapshot.params.p1_vb;
      this.authServicesService_vb.language_vb=this.route_vb.snapshot.params.p2_vb;      
    } 

  payThruQRCodeMsg_vb: PayThruQRCodeMsg_cl = new PayThruQRCodeMsg_cl();

  authorizeMsg_vb:string;
  ngOnInit(): void {
    this.arrivalToThePage_mt(this.pageName_vb);
    this.changeLang_mt(); 
    
  }
  ngOnDestroy(): void { 
  }  
  moneyTransFormValidatorSuccess_mt(): boolean
  {
    var isValid_vb:boolean=true ;    
   
    if(this.moneyTransactionScreen_vb.transactionForm_vb.controls.ownerPhone_vb.value=='')
      {
        this.identifyPhoneValidator_vb=true;
        this.moneyTransactionScreen_vb.transactionForm_vb.controls.ownerPhone_vb.setErrors({required: true});
        isValid_vb=false;   
      }
    if(this.moneyTransactionScreen_vb.transactionForm_vb.controls.transactionId_vb.value=='')
      {
        this.identifyTransIdValidator_vb=true;
        this.moneyTransactionScreen_vb.transactionForm_vb.controls.transactionId_vb.setErrors({required: true});
        isValid_vb=false;   
      }
    return isValid_vb; 

  }

  transSubmitDone_vb:string;
  success_vb:boolean=false;
  transSubmit_mt(){
    this.transSubmitDone_vb="";

    if(!this.moneyTransFormValidatorSuccess_mt())
    {return;}
    const formData_vb = new FormData();
    formData_vb.append('p1', this.moneyTransactionScreen_vb.transactionForm_vb.controls.ownerEmail_vb.value);
    formData_vb.append('p2', this.moneyTransactionScreen_vb.transactionForm_vb.controls.ownerPhone_vb.value);

    formData_vb.append('p3', this.moneyTransactionScreen_vb.transactionForm_vb.controls.transactionId_vb.value);
   
  
    this.authServicesService_vb.payThruQRCode_mt(formData_vb)
            .subscribe((arrivalRes_vb: any) =>{
                    if(arrivalRes_vb.p3=="Y"){
                      this.transSubmitDone_vb = this.transaction_saved_vb;
                      this.corruptEveryThing_mt();
                      this.success_vb=true;
                    }
                    if(arrivalRes_vb.p3=="GM_OD_NE"){
                      this.changeLang_mt();
                      this.success_vb=false;
                      this.transSubmitDone_vb = this.registered_email_phone_wrong_vb;
                      this.corruptEveryThing_mt();
                  }
                  if(arrivalRes_vb.p3=="T_Ex"){
                    this.changeLang_mt();
                    this.success_vb=false;
                    this.transSubmitDone_vb = this.transaction_number_exist_vb;
                    this.corruptEveryThing_mt();
                }
             },

             (error_vb) => {console.log(error_vb);
                  this.corruptEveryThing_mt();
                  this.transSubmitDone_vb=this.failed_vb;
                              }      
            );  
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

  corruptEveryThing_mt() {
    
  }

  qrCodeScreen_heading_vb:string;twoStepsToPay_vb:string;registered_email_phone_wrong_vb:string;
  step_1_to_pay_vb:string;step_2_to_pay_vb:string;submit_vb:string;failed_vb:string;
  u_r_paying_to_vb:string;bank_name_vb:string;acc_no_vb:string;transaction_saved_vb:string;
  phone_input_label_vb:string;transactionId_input_label_vb:string;transaction_number_exist_vb:string;
  changeLang_mt(){
    ToolbarComponent_cl.language_vb=this.authServicesService_vb.language_vb;
    let payThruQRCodeMsg_vb: PayThruQRCodeMsg_cl = new PayThruQRCodeMsg_cl();    
    this.qrCodeScreen_heading_vb   = payThruQRCodeMsg_vb.getMsg_mt("qrCodeScreen_heading_msg");
    this.twoStepsToPay_vb = payThruQRCodeMsg_vb.getMsg_mt("twoStepsToPay_msg");
    this.step_1_to_pay_vb = payThruQRCodeMsg_vb.getMsg_mt("step_1_to_pay_msg");

    this.step_2_to_pay_vb = payThruQRCodeMsg_vb.getMsg_mt("step_2_to_pay_msg");
    this.u_r_paying_to_vb = payThruQRCodeMsg_vb.getMsg_mt("u_r_paying_to_msg");
    this.bank_name_vb = payThruQRCodeMsg_vb.getMsg_mt("bank_name_msg");
    this.acc_no_vb = payThruQRCodeMsg_vb.getMsg_mt("acc_no_msg");

    this.submit_vb = payThruQRCodeMsg_vb.getMsg_mt("submit_msg");
    this.phone_input_label_vb = payThruQRCodeMsg_vb.getMsg_mt("phone_input_label_msg");
    this.transactionId_input_label_vb = payThruQRCodeMsg_vb.getMsg_mt("transactionId_input_label_msg");
    this.registered_email_phone_wrong_vb = payThruQRCodeMsg_vb.getMsg_mt("registered_email_phone_wrong_msg");
    
    this.transaction_saved_vb = payThruQRCodeMsg_vb.getMsg_mt("transaction_saved_msg");
    this.failed_vb = payThruQRCodeMsg_vb.getMsg_mt("failed_msg");
    this.transaction_number_exist_vb = payThruQRCodeMsg_vb.getMsg_mt("transaction_number_exist_msg");
  }
}

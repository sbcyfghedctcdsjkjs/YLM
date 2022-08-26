import { Component, OnInit } from '@angular/core';
import { TargetArea_cl  } from '../owner-target-area/model/target-area';
import { OwnerScreenService_cl } from '../owner-services/owner-screen.service';
import { MyAdsDto_cl } from './model/my-ads-dto';
import { MessageList_cl } from '../../../../commonUsed/util/message-list';
import { ListMyAdProperty_cl } from './propertyComponent/list-my-ad-property';
import { ApiKeyDto_cl } from '../owner-services/model/api-key-dto';


import { SharedService_cl } from '../../../../commonUsed/util/shared-service';
import { Subscription, Observable, timer} from 'rxjs';
import { OwnerToolbarComponent_cl } from '../owner-toolbar/owner-toolbar.component';
import { CommonMessages_cl } from '../../../../commonUsed/util/common-msg';
@Component({
  selector: 'app-owner-list-ad',
  templateUrl: './owner-list-ad.component.html',
  styleUrls: ['./owner-list-ad.component.css']
})
export class OwnerListAdComponent_cl implements OnInit {
  apiKeyDto_vb: ApiKeyDto_cl;  
  awaitingAuthorizeMsg_vb:string;
  togglePhoneActive_vb:boolean=true;
  targetArea_vb: TargetArea_cl= new TargetArea_cl();
  ownerTargetAreaForm_vb=this.targetArea_vb.ownerTargetAreaForm_vb;
  authorizeDone_vb:Boolean=false;
  myAdsDto_vb:MyAdsDto_cl[];
  myAdsImageDto_vb:MyAdsDto_cl;
  imageToShowA_vb: any[];
  messageList_vb: MessageList_cl= new MessageList_cl();
  msgs_vb:ListMyAdProperty_cl=new ListMyAdProperty_cl();
  identifyPhoneValidator_vb=false;
  identifyEmailValidator_vb=false;
  secretNumberValidator_vb=false;
  clickEventsubscription_vb:Subscription;
  pageName_vb:string="ns76qfVFSS2";//h
  constructor(apiKeyDto_vb: ApiKeyDto_cl,
    private ownerScreenService_vb : OwnerScreenService_cl,
    private sharedService_vb:SharedService_cl ) {
    this.apiKeyDto_vb=apiKeyDto_vb;
   
   }
   private subscription_vb: Subscription;
   everySecond_vb: Observable<number> = timer(0, 500);
   imageIndex_vb: number=0;imageIndexInc_vb: number=0;
   ngOnInit(): void {
     this.subscription_vb = this.everySecond_vb.subscribe((seconds) => {
         if(this.myAdsDto_vb!=undefined && this.imageIndexInc_vb < this.myAdsDto_vb.length){
           this.sendGetReq_mt(this.imageIndexInc_vb);
         }
       });
    if(this.apiKeyDto_vb.apikey_vb==undefined)
    { 
      
      this.ownerScreenService_vb.callGetAPIKey_mt(this.pageName_vb);
      
    }
    this.targetArea_vb.ownerTargetAreaForm_vb.controls.identify_vb.setValue('phone');
    this.changeLang_mt();
    this.arrivalToThePage_mt(this.pageName_vb);
  }
  ngOnDestroy(): void {
    this.subscription_vb.unsubscribe(); 
   
  }
  activatePhoneContent_mt(){
  
    this.togglePhoneActive_vb=true;
  }

  activateEmailContent_mt(){
    this.togglePhoneActive_vb=false;
  }

  listMyAdFormValidatorSuccess_mt():boolean {
    var isValid_vb:boolean=true ;

    if(this.targetArea_vb.ownerTargetAreaForm_vb.controls.identify_vb.value=='phone' && 
        this.targetArea_vb.ownerTargetAreaForm_vb.controls.ownerPhone_vb.value=='')
    {
      this.identifyPhoneValidator_vb=true;
      this.targetArea_vb.ownerTargetAreaForm_vb.controls.ownerPhone_vb.setErrors({required: true});
      isValid_vb=false;

    }
    if(this.targetArea_vb.ownerTargetAreaForm_vb.controls.identify_vb.value=='email' && 
        this.targetArea_vb.ownerTargetAreaForm_vb.controls.ownerEmail_vb.value=='')
    {
      this.identifyEmailValidator_vb=true;
      this.targetArea_vb.ownerTargetAreaForm_vb.controls.ownerEmail_vb.setErrors({required: true});
      isValid_vb=false;
      
    }
    
    if(this.targetArea_vb.ownerTargetAreaForm_vb.controls.secretNumber_vb.value=="")
    {
      this.secretNumberValidator_vb=true;
      this.targetArea_vb.ownerTargetAreaForm_vb.controls.secretNumber_vb.setErrors({required: true});
      
      isValid_vb=false;
    }
    
      return isValid_vb;
  }

  loadAllMyAds_mt()
  {    
    if(!this.listMyAdFormValidatorSuccess_mt())
    {return;}
    this.awaitingAuthorizeMsg_vb=this.myAdsList_loading_plz_vb;
    const formData_vb = new FormData();    
    formData_vb.append('p1',this.targetArea_vb.ownerTargetAreaForm_vb.controls.ownerEmail_vb.value);
    formData_vb.append('p2',this.targetArea_vb.ownerTargetAreaForm_vb.controls.ownerPhone_vb.value);
    formData_vb.append('p3',this.targetArea_vb.ownerTargetAreaForm_vb.controls.secretNumber_vb.value);

    
      this.ownerScreenService_vb.getAllMyAds_mt(formData_vb)
      .subscribe((myAdsDto_vb: any[]) =>{
              if(myAdsDto_vb==null ){
                this.awaitingAuthorizeMsg_vb=this.msg_refresh_vb;  
              }
              if(myAdsDto_vb!=null || myAdsDto_vb.length>0){ 
                this.authorizeDone_vb = true;  
                this.awaitingAuthorizeMsg_vb='';  
              }                        
              this.myAdsDto_vb=myAdsDto_vb;
              
              
            },
          (error_vb) => {console.log(error_vb);
                      this.authorizeDone_vb = false; 
                      this.awaitingAuthorizeMsg_vb=this.usr_not_found_vb;
                      
          }      
      );
  }

  onSubmit_mt(){
  }



  createImageFromBlob_mt(image_vb: Blob) {
        let reader_vb = new FileReader();
        reader_vb.addEventListener("load", () => {
            this.myAdsDto_vb[this.imageIndex_vb].imageToShow_vb =reader_vb.result;         
        }, false);

        if (image_vb) {
            reader_vb.readAsDataURL(image_vb);
        }
  }

  sendGetReq_mt(i_vb:number){
    this.imageIndex_vb=i_vb;
    this.ownerScreenService_vb.getRequestCreated_mt(this.myAdsDto_vb[i_vb].p1).subscribe(data_vb => {
      this.createImageFromBlob_mt(data_vb);
      
    }, error_vb => {
      console.log(error_vb);
    });
    this.imageIndexInc_vb+=1;
  }

  arrivalToThePage_mt(pageName_vb){
    const formData_vb = new FormData();
    formData_vb.append('p1', pageName_vb);

    this.ownerScreenService_vb.recordPlainTrack_mt(formData_vb)
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

  list_myads_heading_vb:string;
  use_phone_auth_vb:string;
  use_email_auth_vb:string;
  phone_input_label_vb:string;
  required_email_phone_label_vb:string;
  email_input_label_vb:string;

  secretNum_input_label_vb:string;
  load_my_ads_label_vb:string;
  status_on_label_vb:string;
  active_date_label_vb:string;
  ad_type_label_vb:string;
  created_on_label_vb:string;
  msg_refresh_vb:string;
  myAdsList_loading_plz_vb:string;
  usr_not_found_vb:string;
  changeLang_mt(){
    OwnerToolbarComponent_cl.language_vb=this.ownerScreenService_vb.language_vb;
    let listMyAdProperty_vb: ListMyAdProperty_cl = new ListMyAdProperty_cl();
    this.list_myads_heading_vb =  listMyAdProperty_vb.getMsg_mt("list_myads_heading_msg");
    this.use_phone_auth_vb =  listMyAdProperty_vb.getMsg_mt("use_phone_auth_msg");
    this.use_email_auth_vb =  listMyAdProperty_vb.getMsg_mt("use_email_auth_msg");
    this.phone_input_label_vb =  listMyAdProperty_vb.getMsg_mt("phone_input_label_msg");
    this.email_input_label_vb =  listMyAdProperty_vb.getMsg_mt("email_input_label_msg");
    
    this.secretNum_input_label_vb =  listMyAdProperty_vb.getMsg_mt("secretNum_input_label_msg");
    this.load_my_ads_label_vb =  listMyAdProperty_vb.getMsg_mt("load_my_ads_label_msg");
    this.status_on_label_vb =  listMyAdProperty_vb.getMsg_mt("status_on_label_msg");
    this.active_date_label_vb =  listMyAdProperty_vb.getMsg_mt("active_date_label_msg");
    this.ad_type_label_vb =  listMyAdProperty_vb.getMsg_mt("ad_type_label_msg");
    this.created_on_label_vb =  listMyAdProperty_vb.getMsg_mt("created_on_label_msg");
    this.myAdsList_loading_plz_vb =  listMyAdProperty_vb.getMsg_mt("myAdsList_loading_plz_msg");
    let commonMsgProperty_vb: CommonMessages_cl = new CommonMessages_cl();
    this.msg_refresh_vb= commonMsgProperty_vb.getMsg_mt("msg_refresh_msg");
    this.usr_not_found_vb= commonMsgProperty_vb.getMsg_mt("usr_not_found_msg");    
    this.sharedService_vb.sendClickEvent_mt();
  }
}
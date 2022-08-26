import { Component, OnInit, Input,ViewChild,ElementRef } from '@angular/core';
import { FormBuilder, FormGroup, FormControl,FormArray } from '@angular/forms';
import { OwnerScreenService_cl } from '../owner-services/owner-screen.service';
import { OwnerScreen_cl } from '../owner-services/model/owner-screen';
import { ResponseSuccess_cl } from '../owner-services/model/response-success';
import { ApiKeyDto_cl } from '../owner-services/model/api-key-dto';
import { MessageList_cl } from '../../../../commonUsed/util/message-list';
import { MyAdsDto_cl } from '../owner-list-ad/model/my-ads-dto';

import { ActivatedRoute } from '@angular/router';
import { UploadAdsMsgProperty_cl } from './propertyComponent/uploadAds-msg-property';
import { Subscription } from 'rxjs';
import { SharedService_cl } from '../../../../commonUsed/util/shared-service';
import { CommonMessages_cl } from '../../../../commonUsed/util/common-msg';
import { OwnerToolbarComponent_cl } from '../owner-toolbar/owner-toolbar.component';
import { CategoryDto_cl } from '../../../../commonUsed/util/category-dto';


@Component({
  selector: 'app-owner-screen',
  templateUrl: './owner-screen.component.html',
  styleUrls: ['./owner-screen.component.css'] })



export class OwnerScreenComponent_cl implements OnInit {
  apiKeyDto_vb: ApiKeyDto_cl=new ApiKeyDto_cl();
  responseSuccess_vb: ResponseSuccess_cl;
  selectedFile_vb: File
  imageSrc_vb: any='assets/images/p300.jpg';
  showFileName_vb:string;
  uploadMsg_vb:string;
  contentDescMaxLength_vb:number;
  contentDescCurrentLength_vb:number=0;;
  messageList_vb: MessageList_cl= new MessageList_cl();
  identifyPhoneValidator_vb=false;
  identifyEmailValidator_vb=false;
  secretNumberValidator_vb=false;
  ownerFileValidator_vb=false;
  adTypeValidator_vb=false;
  showSampleView1Flag_vb:boolean=true;
  showSampleView2Flag_vb:boolean=false;
  showSampleView3Flag_vb:boolean=false;
  isModify_vb:boolean=false;
  isModifyId_vb:string;
  myAdsDto_vb:MyAdsDto_cl;  
  selectedCategory_vb:string=",";

  categoryTypeValidator_vb=false;
  categoryDto_vb:CategoryDto_cl[];
  pageName_vb:string="dbcb2dsf301";//I
  @ViewChild('inputFileBrowse') inputFileBrowse_vb: ElementRef<HTMLElement>;

  constructor(apiKeyDto1_vb: ApiKeyDto_cl, private formBuilder_vb: FormBuilder,
              private ownerScreenService_vb : OwnerScreenService_cl,
              private route_vb: ActivatedRoute,private sharedService_vb:SharedService_cl ) {
      this.contentDescMaxLength_vb=1000;
      
      this.apiKeyDto_vb=ownerScreenService_vb.readApiKey_mt();
      
  }

  togglePhoneActive_vb:boolean =true;
  gotoTargetsAreaScreen_vb:boolean =false;
  
  ownerScreen_vb: OwnerScreen_cl= new OwnerScreen_cl();
  ownerUploadForm_vb:FormGroup = this.ownerScreen_vb.ownerUploadForm_vb;

  ngOnInit(): void {
    
    if(this.apiKeyDto_vb.apikey_vb == undefined){
    }

    this.route_vb.params.subscribe(params_vb => {
       if(params_vb.p2_vb != 'a'){
        this.isModifyId_vb=params_vb.p2_vb
       }
      
      this.ownerScreenService_vb.readApiKey_mt().apikey_vb=params_vb.p1_vb;
      this.apiKeyDto_vb.apikey_vb=this.ownerScreenService_vb.readApiKey_mt().apikey_vb;
    
    });

    this.changeLang_mt();
    this.loadCategory_mt();
    
    if(this.apiKeyDto_vb.apikey_vb==undefined)
    { 
      this.ownerScreenService_vb.callGetAPIKey_mt(this.pageName_vb);
      
    }
    if(this.isModifyId_vb==undefined)
    {
      this.ownerScreen_vb.ownerUploadForm_vb.controls.status_vb.setValue('Y');
      this.ownerScreen_vb.ownerUploadForm_vb.controls.adDisplayType_vb.setValue('1');
      this.ownerScreen_vb.ownerUploadForm_vb.controls.identify_vb.setValue('phone');


    }else
    {
      this.ownerScreen_vb.ownerUploadForm_vb.controls.identify_vb.setValue('phone');
      this.isModify_vb=true;
      this.loadMyAd_mt();
    }
    
    this.arrivalToThePage_mt(this.pageName_vb);
  }
  ngOnDestroy(): void {
   
  }
  
  loadMyAd_mt()
  {      
   
    const formData_vb = new FormData();
    formData_vb.append('p1',this.isModifyId_vb);
    
    
      this.ownerScreenService_vb.getAdWithId_mt(formData_vb)
      .subscribe((myAdsDto_vb: any) =>{
            
              this.myAdsDto_vb=myAdsDto_vb;
              this.ownerScreen_vb.ownerUploadForm_vb.controls.contentDesc_vb.setValue(this.myAdsDto_vb.p2);
              this.ownerScreen_vb.ownerUploadForm_vb.controls.adType_vb.setValue(this.myAdsDto_vb.p5+'');
              this.ownerScreen_vb.ownerUploadForm_vb.controls.adDisplayType_vb.setValue(this.myAdsDto_vb.p7+'');
              this.ownerScreen_vb.ownerUploadForm_vb.controls.status_vb.setValue(this.myAdsDto_vb.p4);
              this.chooseSampleViewDisplayType_mt(this.myAdsDto_vb.p7);
              this.selectedCategory_vb=this.myAdsDto_vb.p10;
              this.sendGetReq_mt(this.isModifyId_vb);
              this.selectCategoryItemsOnLoad_mt();
            },
          (error_vb) => {console.log(error_vb);
              
          }      
      );
  }

  
  selectCategoryItemsOnLoad_mt(){

    let catArr = this.selectedCategory_vb.split(",");
    var n=4;
    while(n < this.categoryDto_vb.length){
      if(this.selectedCategory_vb.indexOf(","+  this.categoryDto_vb[n].p13 +",") > -1)
      {
        this.categoryDto_vb[n].p1='1';
        
      }
      n++;
    }
  }

  loadCategory_mt(){
    const formData_vb = new FormData();
    
    this.ownerScreenService_vb.getAllCategory_mt(formData_vb)
        .subscribe((categoryDto_vb: any[]) =>{
          if(categoryDto_vb[0].p3=='N'){
            this.uploadMsg_vb=this.msg_refresh_vb;
          }
           if(categoryDto_vb.length>1){
            this.categoryDto_vb=categoryDto_vb;
    
           }
          },
        (error_vb) => {console.log(error_vb);
                  
    
        }      
    );  
   }

   categorySelected_mt(id_vb:string){
    if(this.selectedCategory_vb.indexOf(","+id_vb+",") > -1) {
      this.selectedCategory_vb =this.selectedCategory_vb.replace(","+id_vb+",", ",");
    } else {
      this.selectedCategory_vb =this.selectedCategory_vb+id_vb+",";
    }
    this.selectCategoryItemsOnLoad_mt();
   }

  ownerUploadFormValidatorSuccess_mt():boolean {
    var isValid_vb:boolean=true ;
   if(this.selectedCategory_vb==","){
    this.categoryTypeValidator_vb=true;
    this.ownerScreen_vb.ownerUploadForm_vb.controls.categoryType_vb.setErrors({required: true});
    isValid_vb=false;
   } 
   if(this.ownerScreen_vb.ownerUploadForm_vb.controls.identify_vb.value==''){
    this.identifyPhoneValidator_vb=true;
    this.ownerScreen_vb.ownerUploadForm_vb.controls.ownerPhone_vb.setErrors({required: true});
    isValid_vb=false;
   }
    if(this.ownerScreen_vb.ownerUploadForm_vb.controls.identify_vb.value=='phone' && 
        this.ownerScreen_vb.ownerUploadForm_vb.controls.ownerPhone_vb.value=='')
      {
        this.identifyPhoneValidator_vb=true;
        this.ownerScreen_vb.ownerUploadForm_vb.controls.ownerPhone_vb.setErrors({required: true});
        isValid_vb=false;
      }
    if(this.ownerScreen_vb.ownerUploadForm_vb.controls.identify_vb.value=='email' && 
        this.ownerScreen_vb.ownerUploadForm_vb.controls.ownerEmail_vb.value=='')
      {
        this.identifyEmailValidator_vb=true;
        this.ownerScreen_vb.ownerUploadForm_vb.controls.ownerEmail_vb.setErrors({required: true});
        isValid_vb=false;
      }
     
     if(this.ownerScreen_vb.ownerUploadForm_vb.controls.file_vb.value=="" && this.myAdsDto_vb==undefined)
      {
        this.ownerFileValidator_vb=true;
        this.ownerScreen_vb.ownerUploadForm_vb.controls.file_vb.setErrors({required: true});
        isValid_vb=false;
      }

      if(this.ownerScreen_vb.ownerUploadForm_vb.controls.adType_vb.value=="")
      {
        this.adTypeValidator_vb=true;
        this.ownerScreen_vb.ownerUploadForm_vb.controls.adType_vb.setErrors({required: true});
        isValid_vb=false;
      }

      if(this.ownerScreen_vb.ownerUploadForm_vb.controls.secretNumber_vb.value=="")
      {
        this.secretNumberValidator_vb=true;
        this.ownerScreen_vb.ownerUploadForm_vb.controls.secretNumber_vb.setErrors({required: true});
        isValid_vb=false;
      }
    return isValid_vb;
  }

  onSubmit_mt(){
    if(this.apiKeyDto_vb.apikey_vb==undefined){
      return;
    }

    if(this.myAdsDto_vb==undefined){
      this.onSubmitReal_mt();
    }else{
      this.onModifyReal_mt()
    }
  }

  onSubmitReal_mt() {
    if(!this.ownerUploadFormValidatorSuccess_mt())
    {return;}

    const formData_vb = new FormData();
    
    formData_vb.append('p1', this.ownerScreen_vb.ownerUploadForm_vb.controls.ownerPhone_vb.value);
    formData_vb.append('p2', this.ownerScreen_vb.ownerUploadForm_vb.controls.ownerEmail_vb.value);
    formData_vb.append('p3', this.ownerScreen_vb.ownerUploadForm_vb.controls.secretNumber_vb.value);
    formData_vb.append('p4', this.ownerScreen_vb.ownerUploadForm_vb.controls.contentDesc_vb.value);
    formData_vb.append('p5', this.ownerScreen_vb.ownerUploadForm_vb.controls.adType_vb.value);
    formData_vb.append('p6', this.ownerScreen_vb.ownerUploadForm_vb.controls.status_vb.value);
    formData_vb.append('p7', this.ownerScreen_vb.ownerUploadForm_vb.controls.adDisplayType_vb.value);
    formData_vb.append('p8', this.selectedFile_vb);
    formData_vb.append('p10', this.selectedCategory_vb);

    if(this.selectedFile_vb.type.indexOf("image/")!=0) {
      this.uploadMsg_vb=this.file_not_acc_vb;
      this.changeLang_mt();
      return;
    }
    this.ownerScreenService_vb.uploadDataAndImage_mt(formData_vb)
    .subscribe((responseSuccess_vb: any) => {
                        this.gotoTargetsAreaScreen_vb = true;
                        this.uploadMsg_vb=this.file_upld_done_vb;  },
              (err_vb) =>  {console.log(err_vb.error)
                          if(err_vb.error=='limit_reach_msg')
                          this.uploadMsg_vb=this.limit_reach_vb;
                          else if(err_vb.error=='file_not_acc_msg')
                          this.uploadMsg_vb=this.file_not_acc_vb;
                          else if(err_vb.error=='usr_not_found_msg')
                          this.uploadMsg_vb=this.usr_not_found_vb;
                        }

    );         
  } 

  onModifyReal_mt() {
    if(!this.ownerUploadFormValidatorSuccess_mt())
    {return;}

    const formData_vb = new FormData();
    
    formData_vb.append('p1', this.ownerScreen_vb.ownerUploadForm_vb.controls.ownerPhone_vb.value);
    formData_vb.append('p2', this.ownerScreen_vb.ownerUploadForm_vb.controls.ownerEmail_vb.value);
    formData_vb.append('p3', this.ownerScreen_vb.ownerUploadForm_vb.controls.secretNumber_vb.value);
    formData_vb.append('p4', this.ownerScreen_vb.ownerUploadForm_vb.controls.contentDesc_vb.value);
    formData_vb.append('p5', this.ownerScreen_vb.ownerUploadForm_vb.controls.adType_vb.value);
    formData_vb.append('p6', this.ownerScreen_vb.ownerUploadForm_vb.controls.status_vb.value);
    formData_vb.append('p7', this.ownerScreen_vb.ownerUploadForm_vb.controls.adDisplayType_vb.value);
    formData_vb.append('p8', this.selectedFile_vb);
    


    if(this.selectedFile_vb != undefined  && this.selectedFile_vb.type.indexOf("image/")!=0) {
      this.uploadMsg_vb=this.file_not_acc_vb;;
      return;
    }
    
    formData_vb.append('p10', this.myAdsDto_vb.p1+''); 
    formData_vb.append('p11', this.selectedCategory_vb);
    this.ownerScreenService_vb.modifyAd_mt(formData_vb)
          .subscribe((responseSuccess_vb: any) => {console.log(responseSuccess_vb);
                              this.gotoTargetsAreaScreen_vb = true;
                              this.uploadMsg_vb="modify_done_msg";  },
                    (err_vb) =>  {console.log(err_vb.error)
                                this.uploadMsg_vb=this.usr_not_found_vb;
                              }
          );
  }

 


  onUpload_mt() {
 
  }
  file_vb: string;

  handleChange_mt(files_vb: FileList) {
    if (files_vb && files_vb.length) {
      this.file_vb = files_vb[0].name;
    }
  }  

  activatePhoneContent_mt(){
    this.togglePhoneActive_vb=true;
    this.ownerUploadForm_vb.controls.ownerEmail_vb.setValue('');
  }

  activateEmailContent_mt(){
    this.togglePhoneActive_vb=false;
    this.ownerUploadForm_vb.controls.ownerPhone_vb.setValue('');
  }

  onSubmit2_mt(){
  }

  browseFile_mt() {
    let el: HTMLElement = this.inputFileBrowse_vb.nativeElement;
    el.click();
  }

  onFileSelect_mt(event_vb) {
    if (event_vb.target.files.length > 0) {
      const file_vb = event_vb.target.files[0];
      this.selectedFile_vb = file_vb;
      this.showFileName_vb=this.ownerUploadForm_vb.controls.file_vb.value;
      const reader_vb = new FileReader();
      reader_vb.onload = e => this.imageSrc_vb = reader_vb.result;

      reader_vb.readAsDataURL(file_vb);
      
    }
    
  }

  onKeyCountChar_mt(event_vb: any) {
    const eTarget_vb = event_vb.target;
    const maxLength_vb = eTarget_vb.getAttribute("maxlength");
    const currentLength_vb = eTarget_vb.value.length;
    this.contentDescCurrentLength_vb=eTarget_vb.value.length;
    if (currentLength_vb >= maxLength_vb) {
        return ;
    }
    
  }

 chooseSampleViewDisplayType_mt(i_vb){
   if(i_vb=='1'){
    this.showSampleView1_mt();
   }
   if(i_vb=='2'){
    this.showSampleView2_mt();
   }
   if(i_vb=='3'){
    this.showSampleView3_mt();
   }
 }
  showSampleView1_mt(){
    this.showSampleView1Flag_vb=true;
    this.showSampleView2Flag_vb=false;
    this.showSampleView3Flag_vb=false;
  }

  showSampleView2_mt(){
    this.showSampleView1Flag_vb=false;
    this.showSampleView2Flag_vb=true;
    this.showSampleView3Flag_vb=false;
  }

  showSampleView3_mt(){
    this.showSampleView1Flag_vb=false;
    this.showSampleView2Flag_vb=false;
    this.showSampleView3Flag_vb=true;
  }

  createImageFromBlob_mt(image_vb: Blob) {
    let reader_vb = new FileReader();
    reader_vb.addEventListener("load", () => {
      this.imageSrc_vb =reader_vb.result;         
    }, false);

    if (image_vb) {
        reader_vb.readAsDataURL(image_vb);
    }
  }

  sendGetReq_mt(id_vb:string){
      this.ownerScreenService_vb.getRequestCreated_mt(id_vb).subscribe(data_vb => {
        this.createImageFromBlob_mt(data_vb);
    
      }, error_vb => {
        console.log(error_vb);
      });
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

  upload_ads_step1_heading_vb:string;
  status_yes_label_vb:string;
  status_no_label_vb:string;
  displayType_heading_vb:string;
  displayType1_vb:string;
  displayType2_vb:string;
  displayType3_vb:string;
  ad_type_heading_vb:string;
  ad_type_12_hrs_vb:string;
  ad_type_1_week_vb:string;
  ad_type_1_month_vb:string;
  ad_type_1_year_vb:string;
  chose_ad_label_vb:string;
  desc_offer_label_vb:string;
  desc_word_length_label_vb:string;
  use_phone_auth_vb:string;
  use_email_auth_vb:string;
  phone_input_label_vb:string;
  email_input_label_vb:string;
  secretNum_input_label_vb:string;
  label_submit_upload_ads_vb:string;
  file_not_acc_vb:string;
  usr_not_found_vb:string;
  file_upld_done_vb:string;
  modify_done_vb:string;
  limit_reach_vb:string;
  chose_category_label_vb:string;
  msg_refresh_vb:string;
  changeLang_mt(){
    OwnerToolbarComponent_cl.language_vb=this.ownerScreenService_vb.language_vb;
    let uploadAdsMsgProperty_vb: UploadAdsMsgProperty_cl = new UploadAdsMsgProperty_cl();
    this.upload_ads_step1_heading_vb= uploadAdsMsgProperty_vb.getMsg_mt("upload_ads_step1_heading_msg");
    this.status_yes_label_vb= uploadAdsMsgProperty_vb.getMsg_mt("status_yes_label_msg");
    this.status_no_label_vb= uploadAdsMsgProperty_vb.getMsg_mt("status_no_label_msg");
    this.displayType_heading_vb= uploadAdsMsgProperty_vb.getMsg_mt("displayType_heading_msg");
    this.displayType1_vb= uploadAdsMsgProperty_vb.getMsg_mt("displayType1_msg");
    this.displayType2_vb= uploadAdsMsgProperty_vb.getMsg_mt("displayType2_msg");
    this.displayType3_vb= uploadAdsMsgProperty_vb.getMsg_mt("displayType3_msg");
    this.ad_type_heading_vb= uploadAdsMsgProperty_vb.getMsg_mt("ad_type_heading_msg");
    this.ad_type_12_hrs_vb= uploadAdsMsgProperty_vb.getMsg_mt("ad_type_12_hrs_msg");
    this.ad_type_1_week_vb= uploadAdsMsgProperty_vb.getMsg_mt("ad_type_1_week_msg");
    this.ad_type_1_month_vb= uploadAdsMsgProperty_vb.getMsg_mt("ad_type_1_month_msg");
    this.ad_type_1_year_vb= uploadAdsMsgProperty_vb.getMsg_mt("ad_type_1_year_msg");
    this.chose_ad_label_vb= uploadAdsMsgProperty_vb.getMsg_mt("chose_ad_label_msg");
    this.desc_offer_label_vb= uploadAdsMsgProperty_vb.getMsg_mt("desc_offer_label_msg");
    this.desc_word_length_label_vb= uploadAdsMsgProperty_vb.getMsg_mt("desc_word_length_label_msg");
    this.use_phone_auth_vb= uploadAdsMsgProperty_vb.getMsg_mt("use_phone_auth_msg");
    this.use_email_auth_vb= uploadAdsMsgProperty_vb.getMsg_mt("use_email_auth_msg");
    this.phone_input_label_vb= uploadAdsMsgProperty_vb.getMsg_mt("phone_input_label_msg");
    this.email_input_label_vb= uploadAdsMsgProperty_vb.getMsg_mt("email_input_label_msg");
    this.secretNum_input_label_vb= uploadAdsMsgProperty_vb.getMsg_mt("secretNum_input_label_msg");
    this.label_submit_upload_ads_vb= uploadAdsMsgProperty_vb.getMsg_mt("label_submit_upload_ads_msg");
    this.chose_category_label_vb= uploadAdsMsgProperty_vb.getMsg_mt("chose_category_label_msg");
    let commonMsgProperty_vb: CommonMessages_cl = new CommonMessages_cl();
    this.file_not_acc_vb= commonMsgProperty_vb.getMsg_mt("file_not_acc_msg");
    this.usr_not_found_vb= commonMsgProperty_vb.getMsg_mt("usr_not_found_msg");
    this.file_upld_done_vb= commonMsgProperty_vb.getMsg_mt("file_upld_done_msg");
    this.modify_done_vb= commonMsgProperty_vb.getMsg_mt("modify_done_msg");
    this.limit_reach_vb= commonMsgProperty_vb.getMsg_mt("limit_reach_msg");
    this.msg_refresh_vb= commonMsgProperty_vb.getMsg_mt("msg_refresh_msg");
    this.sharedService_vb.sendClickEvent_mt();
  }
}
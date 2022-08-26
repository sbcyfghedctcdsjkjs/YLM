import { Component, OnInit,Input } from '@angular/core';
import { FormGroup, FormArray,FormBuilder } from '@angular/forms';
import { TargetArea_cl  } from '../owner-target-area/model/target-area';
import { OwnerScreenService_cl } from '../owner-services/owner-screen.service';
import { TargetAreaDto_cl } from '../owner-services/model/target-area-dto';
import { ResponseSuccess_cl } from '../owner-services/model/response-success';
import { MessageList_cl } from '../../../../commonUsed/util/message-list';
import { TargetareaMsg_cl } from './propertyComponent/targetarea-msg';


import { ApiKeyDto_cl } from '../owner-services/model/api-key-dto';
import { ActivatedRoute } from '@angular/router';
import { SharedService_cl } from '../../../../commonUsed/util/shared-service';
import { Subscription, Observable, timer} from 'rxjs';
import { CommonMessages_cl } from '../../../../commonUsed/util/common-msg';
import { OwnerToolbarComponent_cl } from '../owner-toolbar/owner-toolbar.component';



@Component({
  selector: 'app-owner-target-area',
  templateUrl: './owner-target-area.component.html',
  styleUrls: ['./owner-target-area.component.css']
})
export class OwnerTargetAreaComponent_cl implements OnInit {
  apiKeyDto_vb: ApiKeyDto_cl=new ApiKeyDto_cl();

  responseSuccess_vb: ResponseSuccess_cl;
  togglePhoneActive_vb:boolean =true;
  taSize_vb=5;
  targetArea_vb: TargetArea_cl= new TargetArea_cl();
  targetAreaDto_vb: TargetAreaDto_cl ;
  ownerTargetAreaForm_vb=this.targetArea_vb.ownerTargetAreaForm_vb;
  @Input() msgFromUpload_vb: string;
  @Input() ownerPhoneNum_vb: string;
  awaitingTargetArea_vb:string;
  awaitingSaveTargetArea_vb:string;
  authorizeDone_vb:Boolean=false;
  messageList_vb: MessageList_cl= new MessageList_cl();
  msgs_vb:TargetareaMsg_cl=new TargetareaMsg_cl();
  identifyPhoneValidator_vb=false;
  identifyEmailValidator_vb=false;
  secretNumberValidator_vb=false;
  taCount_vb:number=0;

  pageName_vb:string="vqxsdcNgvsU";//G
  clickEventsubscription_vb:Subscription;
  
  constructor(private formBuilder_vb: FormBuilder,
    private ownerScreenService_vb : OwnerScreenService_cl,apiKeyDto1_vb: ApiKeyDto_cl,
    private route_vb: ActivatedRoute,private sharedService_vb:SharedService_cl  ) 
  { 
  

    this.apiKeyDto_vb=apiKeyDto1_vb;
  
  }

  ngOnInit(): void {   
    if(this.apiKeyDto_vb.apikey_vb==undefined)
    { 
      
    
      this.apiKeyDto_vb.apikey_vb="start looking..."
      this.ownerScreenService_vb.callGetAPIKey_mt(this.pageName_vb);
      
    }
    this.targetArea_vb.ownerTargetAreaForm_vb.controls.identify_vb.setValue('phone'); 
    
    this.changeLang_mt();
    this.arrivalToThePage_mt(this.pageName_vb);
  }

  ngOnDestroy(): void {
   
  }

  ownerTargetAreaFormValidatorSuccess_mt():boolean {
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

  loadAllTargetArea_mt()
  {
    if(!this.ownerTargetAreaFormValidatorSuccess_mt())
    {return;}
    
    this.awaitingTargetArea_vb=this.ta_loading_plz_vb;
    

    const formData_vb = new FormData();
    formData_vb.append('p1',this.targetArea_vb.ownerTargetAreaForm_vb.controls.ownerPhone_vb.value);
    formData_vb.append('p2',this.targetArea_vb.ownerTargetAreaForm_vb.controls.ownerEmail_vb.value);
    formData_vb.append('p3',this.targetArea_vb.ownerTargetAreaForm_vb.controls.secretNumber_vb.value);
    

    this.ownerScreenService_vb.getAllTargetArea_mt(formData_vb).subscribe((targetAreaDto_vb: any) =>{
              this.authorizeDone_vb = true;
              this.awaitingTargetArea_vb='';
              this.targetAreaDto_vb=targetAreaDto_vb;
              this.populateTargetAreas_mt();
            
            },
          (error_vb) => {console.log(error_vb);
                      if(error_vb.status ==401)
                        this.awaitingTargetArea_vb=this.usr_not_found_vb; 
                      
          }      
      );
  }

  populateTargetAreas_mt()
  {
    for (var val_vb of this.targetAreaDto_vb.p14) {
      this.addTarget_mt(val_vb);
    }

    
  }

  targetsArray_mt() : FormArray {
    return this.targetArea_vb.ownerTargetAreaForm_vb.get("targets_vb") as FormArray
  }

  newTarget_mt(val_vb:string): FormGroup {
    return this.formBuilder_vb.group({
      p14: val_vb
    })
  }

  addTarget_mt(val_vb:string) {
    if(this.taCount_vb+1 > this.taSize_vb) return;
    this.taCount_vb=this.taCount_vb+1;
    this.targetsArray_mt().push(this.newTarget_mt(val_vb));
  }

  removeTarget_mt(i:number) {
    this.taCount_vb=this.taCount_vb-1;
    this.targetsArray_mt().removeAt(i);
  }

  onSubmit_mt() {
    this.awaitingSaveTargetArea_vb="";
    const formData_vb = new FormData();
    formData_vb.append('p1',this.targetArea_vb.ownerTargetAreaForm_vb.controls.ownerPhone_vb.value);
    formData_vb.append('p2',this.targetArea_vb.ownerTargetAreaForm_vb.controls.ownerEmail_vb.value);
    formData_vb.append('p3',this.targetArea_vb.ownerTargetAreaForm_vb.controls.secretNumber_vb.value);
    if(this.targetArea_vb.ownerTargetAreaForm_vb.controls.targets_vb.value.length==0){
      formData_vb.append('p4[]', undefined);
    }
    for (var val_vb of this.targetArea_vb.ownerTargetAreaForm_vb.controls.targets_vb.value) {
      formData_vb.append('p4[]', val_vb.p14);      
    }
    
    
    
    this.ownerScreenService_vb.uploadTargetArea_mt(formData_vb)
    .subscribe((responseSuccess_vb: ResponseSuccess_cl) => {console.log(responseSuccess_vb)
                        this.changeLang_mt();
                        this.awaitingSaveTargetArea_vb=this.ta_save_success_vb;
                },
               (error_vb) => {console.log(error_vb)
                        this.awaitingSaveTargetArea_vb=error_vb.error;
                        
                        }
    );
    
  }

  onSubmit2_mt() {
    const formData_vb = new FormData();
    
    
    for (var val of this.targetArea_vb.ownerTargetAreaForm_vb.controls.targets_vb.value) {
    
    }
    
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
  activatePhoneContent_mt(){
    this.togglePhoneActive_vb=true;
    this.ownerTargetAreaForm_vb.controls.ownerEmail_vb.setValue('');
  }

  activateEmailContent_mt(){
    this.togglePhoneActive_vb=false;
    this.ownerTargetAreaForm_vb.controls.ownerPhone_vb.setValue('');
  }

  TargetArea_step2_heading_vb:string;
  use_phone_auth_vb:string;
  use_email_auth_vb:string;
  phone_input_label_vb:string;
  email_input_label_vb:string;
  secretNum_input_label_vb:string;  
  load_ta_label_vb:string;
  ta_heading_vb:string;
  sample_address_syntax_vb:string;
  sample_address_start_vb:string;
  sample_address_1_vb:string;
  sample_address_2_vb:string;
  sample_address_3_vb:string;
  sample_address_4_vb:string;   
  address_label_part1_vb:string;
  address_label_part2_vb:string;
  remove_label_vb:string;
  add_targetarea_label_vb:string;
  label_submit_targetarea_vb:string;
  usr_not_found_vb:string;
  ta_save_success_vb:string;
  ta_loading_plz_vb:string;
  changeLang_mt(){
    OwnerToolbarComponent_cl.language_vb=this.ownerScreenService_vb.language_vb;
    let targetArea_vb: TargetareaMsg_cl = new TargetareaMsg_cl();
    this.TargetArea_step2_heading_vb=  targetArea_vb.getMsg_mt("TargetArea_step2_heading_msg");
    this.use_phone_auth_vb=  targetArea_vb.getMsg_mt("use_phone_auth_msg");
    this.use_email_auth_vb=  targetArea_vb.getMsg_mt("use_email_auth_msg");
    this.phone_input_label_vb=  targetArea_vb.getMsg_mt("phone_input_label_msg");
    this.email_input_label_vb=  targetArea_vb.getMsg_mt("email_input_label_msg");
    this.secretNum_input_label_vb=  targetArea_vb.getMsg_mt("secretNum_input_label_msg");    
    this.load_ta_label_vb=  targetArea_vb.getMsg_mt("load_ta_label_msg");
    this.ta_heading_vb=  targetArea_vb.getMsg_mt("ta_heading_msg");
    this.sample_address_syntax_vb=  targetArea_vb.getMsg_mt("sample_address_syntax_msg");
    this.sample_address_start_vb=  targetArea_vb.getMsg_mt("sample_address_start_msg");
    this.sample_address_1_vb=  targetArea_vb.getMsg_mt("sample_address_1_msg");
    this.sample_address_2_vb=  targetArea_vb.getMsg_mt("sample_address_2_msg");
    this.sample_address_3_vb=  targetArea_vb.getMsg_mt("sample_address_3_msg");
    this.sample_address_4_vb=  targetArea_vb.getMsg_mt("sample_address_4_msg");   
    this.address_label_part1_vb=  targetArea_vb.getMsg_mt("address_label_part1_msg");
    this.address_label_part2_vb=  targetArea_vb.getMsg_mt("address_label_part2_msg");
    this.remove_label_vb=  targetArea_vb.getMsg_mt("remove_label_msg");
    this.add_targetarea_label_vb=  targetArea_vb.getMsg_mt("add_targetarea_label_msg");
    this.label_submit_targetarea_vb=  targetArea_vb.getMsg_mt("label_submit_targetarea_msg");
    this.ta_save_success_vb= targetArea_vb.getMsg_mt("ta_save_success_msg");  
    let commonMsgProperty_vb: CommonMessages_cl = new CommonMessages_cl();    
    this.usr_not_found_vb= commonMsgProperty_vb.getMsg_mt("usr_not_found_msg");    
    this.ta_loading_plz_vb= commonMsgProperty_vb.getMsg_mt("ta_loading_plz_msg");
    this.sharedService_vb.sendClickEvent_mt();
  }
}

import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl,FormArray } from '@angular/forms';
import { OwnerScreenService_cl } from '../owner-services/owner-screen.service';
import { OwnerScreen_cl } from '../owner-services/model/owner-screen';
import { ApiKeyDto_cl } from '../owner-services/model/api-key-dto';

@Component({
  selector: 'app-owner-login',
  templateUrl: './owner-login.component.html',
  styleUrls: ['./owner-login.component.css']
})
export class OwnerLoginComponent_cl implements OnInit {
  apiKeyDto_vb: ApiKeyDto_cl;
  constructor(apiKeyDto_vb: ApiKeyDto_cl,private ownerScreenService_vb : OwnerScreenService_cl) {
    this.apiKeyDto_vb=apiKeyDto_vb;
   }

  ngOnInit(): void {
    if(this.apiKeyDto_vb.apikey_vb==undefined)
    { 
 
    }
  }

  
  ownerScreen_vb: OwnerScreen_cl= new OwnerScreen_cl()
  togglePhoneActive_vb:boolean =true;
  ownerUploadForm_vb:FormGroup = this.ownerScreen_vb.ownerUploadForm_vb;
  activatePhoneContent_mt(){
    this.togglePhoneActive_vb=true;
    this.ownerUploadForm_vb.controls.ownerEmail_vb.setValue('');
  }

  activateEmailContent_mt(){
    this.togglePhoneActive_vb=false;
    this.ownerUploadForm_vb.controls.ownerPhone_vb.setValue('');
  }
}

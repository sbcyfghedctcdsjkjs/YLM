import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiKeyDto_cl } from '../owner-services/model/api-key-dto';
import { SharedService_cl } from '../../../../commonUsed/util/shared-service';
import { ToolbarMsg_cl } from './propertyComponent/toolbar-msg';
import { OwnerScreenService_cl } from '../owner-services/owner-screen.service';
import { Subscription, Observable, timer} from 'rxjs';
@Component({
  selector: 'app-owner-toolbar',

  templateUrl: './owner-toolbar.component.html',
  styleUrls: ['./owner-toolbar.component.css']
})
export class OwnerToolbarComponent_cl implements OnInit {
  apiKeyDto_vb: ApiKeyDto_cl; 
  clickEventsubscription_vb:Subscription;
  constructor( apiKeyDto_vb: ApiKeyDto_cl,private router_vb: Router,
    
    
    private sharedService_vb: SharedService_cl,private ownerScreenService_vb : OwnerScreenService_cl,  ) {
    this.apiKeyDto_vb=apiKeyDto_vb;
    this.clickEventsubscription_vb = this.sharedService_vb.getClickEvent_mt().subscribe(()=>{
      this.changeLang_mt();
    });    
   }
  static language_vb:string='en';
   
  ngOnInit(): void {
    
    
  }
  ngOnDestroy(): void {
    this.clickEventsubscription_vb.unsubscribe();    
  }
  showSideNavToggle_vb: boolean=false;
  
  showSideNav_mt(){
    this.showSideNavToggle_vb=!this.showSideNavToggle_vb;
  }

  hideSideNav_mt(){
    this.showSideNavToggle_vb=false;
  }

  arrivalToThePage_mt(){
    const formData_vb = new FormData();
    formData_vb.append('p1', 'H');

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
  changeLang_mt1(lang_vb:string){
    OwnerToolbarComponent_cl.language_vb=lang_vb;
    let goto_vb='/tellTargets';
    if(this.router_vb.url === goto_vb){
      goto_vb='/listMyAds'
    }    
    this.router_vb.navigate([goto_vb]);    
  }

  step1_btn_label_vb:string;
  step2_btn_label_vb:string;
  myads_btn_label_vb:string;

  changeLang_mt(){
    OwnerToolbarComponent_cl.language_vb=this.ownerScreenService_vb.language_vb;
   
    let toolbarMsg_vb:ToolbarMsg_cl=new ToolbarMsg_cl();
    this.step1_btn_label_vb= toolbarMsg_vb.getMsg_mt("step1_btn_label_msg");
    this.step2_btn_label_vb= toolbarMsg_vb.getMsg_mt("step2_btn_label_msg");
    this.myads_btn_label_vb= toolbarMsg_vb.getMsg_mt("myads_btn_label_msg");
   
    this.arrivalToThePage_mt();
   
  }
}

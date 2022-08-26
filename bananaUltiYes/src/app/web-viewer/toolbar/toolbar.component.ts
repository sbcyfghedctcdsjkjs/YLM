import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ApiKeyDto_cl} from '../auth/model/api-key-dto';
import { SearchLocation_cl } from '../auth/model/search-loc';
import { AuthServicesService_cl } from '../auth/auth-services.service';
import { MyAdsDto_cl } from '../auth/model/my-ads-dto';
import { MessageList_cl } from '../commonUsed/util/message-list';
import { UserDto_cl } from '../auth/model/user-dto';
import { ToolbarMsg_cl } from './propertyComponent/toolbar-msg';
import { SharedService_cl } from '../commonUsed/util/shared-service';
import { CookieService } from 'ngx-cookie-service';
import { Subscription } from 'rxjs';
@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})


export class ToolbarComponent_cl implements OnInit {
  searchLocation_vb:SearchLocation_cl = new SearchLocation_cl(); 
  searchArr_vb:string[];
  searchIndex_vb:number=0;
  logInOutEventsubscription_vb:Subscription;
  authServicesService_vb: AuthServicesService_cl;
  apiKeyDto_vb: ApiKeyDto_cl=new ApiKeyDto_cl();
  userDto_vb: UserDto_cl = new UserDto_cl();

  searchForm_vb=this.searchLocation_vb.searchForm_vb;
  changeLangEventsubscription_vb:Subscription;
  
  constructor( apiKeyDto_vb: ApiKeyDto_cl, private router_vb: Router, private route_vb: ActivatedRoute,
              authServicesService_vb: AuthServicesService_cl, searchLocation_vb: SearchLocation_cl,
               private sharedService_vb: SharedService_cl,private cookieService_vb: CookieService) {

                
    this.apiKeyDto_vb=apiKeyDto_vb;
    this.searchLocation_vb=searchLocation_vb;
    this.authServicesService_vb=authServicesService_vb;

    
    if(this.authServicesService_vb.apiKeyDto_vb.apikey_vb!=""){

      this.apiKeyDto_vb=this.authServicesService_vb.apiKeyDto_vb;
    }

    if(this.apiKeyDto_vb.apikey_vb==undefined)
      {
    
      let pageName_vb:string="x823uqwy21w";
      this.authServicesService_vb.callGetAPIKey_mt(pageName_vb);
      
      }

    this.changeLangEventsubscription_vb = this.sharedService_vb.getChangeLangEvent_mt().subscribe(()=>{
      this.changeLang_mt();
      })


    this.logInOutEventsubscription_vb = this.sharedService_vb.getLogInOutClickEvent_mt().subscribe(()=>{       
      this.userDto_vb.userId_vb= this.sharedService_vb.getLoginId_mt();                   
      this.userDto_vb.userName_vb= this.sharedService_vb.getLoginName_mt();                   
      
      });

    
   }
  placeholderText_vb:string ;
  myAdsDto_vb:MyAdsDto_cl[];
  
  static language_vb:string='en';
  
  awaitingSearchMsg_vb:string;
  searchDone_vb:Boolean=false;
  messageList_vb: MessageList_cl= new MessageList_cl();
  ngOnInit(): void {
    this.placeholderText_vb = (<HTMLLabelElement>document.getElementsByName('placeholderText_vb')[0]).textContent;
    this.placeholderText_vb="";
   
  }



  ngOnDestroy(): void {
    this.changeLangEventsubscription_vb.unsubscribe();    
  }
  searchFormValidatorSuccess_mt(){
    var isValid:Boolean=true;
    if(this.searchForm_vb.get('search_vb').value==""){
      isValid=false;
    }
    return isValid;
  }

  placeholderText_mt(){
    
    
  }

 
  onSubmit_mt(){
    if(!this.searchFormValidatorSuccess_mt())    {return;}
      this.userDto_vb.search_vb=this.searchForm_vb.get('search_vb').value;
        this.sharedService_vb.sendLoadAdsClickEvent_mt(this.userDto_vb.search_vb);
      
  }
  
  logout_mt(){
    this.sharedService_vb.sendLogInOutClickEvent_mt(undefined,"","Y");
    this.router_vb.navigate(['xskdihhsdowqi2423156471hviweroqw017ewg1632jvhq2']);
  }

  onSubmit_mt1(){
  
    if(!this.searchFormValidatorSuccess_mt())    {return;}

    this.searchArr_vb[this.searchIndex_vb]=this.searchForm_vb.get('search_vb').value;
    this.searchIndex_vb+=1;
   
   const formData_vb = new FormData();
   formData_vb.append('search_vb', this.searchForm_vb.get('search_vb').value);
   
   this.authServicesService_vb.searchAndLoadAdsForLoc_mt(formData_vb)
   .subscribe((myAdsDto_vb: any[]) =>{
           if(myAdsDto_vb!=null || myAdsDto_vb.length>0){ 
             this.searchDone_vb = true;  
             this.awaitingSearchMsg_vb='';  
           }else{
             this.awaitingSearchMsg_vb=this.messageList_vb.httpCodes_vb[0];;  
           }
                     
           this.myAdsDto_vb=myAdsDto_vb;
           
   
         },
       (error_vb) => {console.log(error_vb);
                   this.searchDone_vb = false; 
                   this.awaitingSearchMsg_vb=this.messageList_vb.httpCodes_vb[''+error_vb.status];  
   
       }      
   );  
  }
  
  showSideNavToggle_vb: boolean=false;
  
  showSideNav_mt(){
    this.showSideNavToggle_vb=!this.showSideNavToggle_vb;
  }

  hideSideNav_mt(){
    this.showSideNavToggle_vb=false;
  }

  label_submit_upload_ads_vb:string;
  logout_vb:string;
  login_vb:string;
  changeLang_mt(){
    ToolbarComponent_cl.language_vb=this.authServicesService_vb.language_vb;
    let toolbarMsg_vb: ToolbarMsg_cl = new ToolbarMsg_cl();
    
    this.placeholderText_vb= toolbarMsg_vb.getMsg_mt("search_placeholder_text_msg");
    this.label_submit_upload_ads_vb= toolbarMsg_vb.getMsg_mt("label_submit_upload_ads_msg");
    this.login_vb= toolbarMsg_vb.getMsg_mt("login_msg");
    this.logout_vb= toolbarMsg_vb.getMsg_mt("logout_msg");
     
  }

}

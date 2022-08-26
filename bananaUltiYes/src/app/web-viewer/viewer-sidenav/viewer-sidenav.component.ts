import { Component, OnInit } from '@angular/core';
import { ApiKeyDto_cl } from '../auth/model/api-key-dto';
import { AuthServicesService_cl } from '../auth/auth-services.service';
import { ViewerSideNavMsg_cl } from './propertyComponent/viewer-sidenav-msg';
import { ToolbarComponent_cl } from '../toolbar/toolbar.component';
import { Router, ActivatedRoute } from '@angular/router';
import { SharedService_cl } from '../commonUsed/util/shared-service';
import { CategoryDto_cl } from '../auth/model/category-dto';

import { Subscription, Observable, timer} from 'rxjs';
import { UserDto_cl } from '../auth/model/user-dto';
@Component({
  selector: 'app-viewer-sidenav',
  templateUrl: './viewer-sidenav.component.html',
  styleUrls: ['./viewer-sidenav.component.css']
})
export class ViewerSidenavComponent_cl implements OnInit {


    apiKeyDto_vb: ApiKeyDto_cl; 
    
    userName_vb:string;uploadUrl_vb:string;
    userDto_vb:UserDto_cl=new UserDto_cl();
    userLogin_vb:boolean=false;
    categoryDto_vb:CategoryDto_cl[];
    selectedFilter_vb:string=",";

    selectedAdType_vb:string=",";

    logoutFlag_vb:string="Y";    
    logInOutEventsubscription_vb:Subscription;
    constructor( apiKeyDto_vb: ApiKeyDto_cl,private authServicesService_vb : AuthServicesService_cl,
      private router_vb: Router ,private sharedService_vb:SharedService_cl) 
      {    
      this.apiKeyDto_vb=authServicesService_vb.apiKeyDto_vb;
        
      this.apiKeyDto_vb.language_vb=authServicesService_vb.language_vb;
        this.logInOutEventsubscription_vb = this.sharedService_vb.getLogInOutClickEvent_mt().subscribe(()=>{       
          if(this.sharedService_vb.getLogout_mt()==this.logoutFlag_vb){
            this.logout_mt();
          }                   
        });                 
      } 
  
      private timeSubscription_vb: Subscription;
      
      everySecond_vb: Observable<number> = timer(0, 1000);
    ngOnInit(): void {
      sessionStorage.setItem("ad","12223");
      var iPageTabID = sessionStorage.getItem("tabID");
      
      this.timeSubscription_vb = this.everySecond_vb.subscribe((seconds) =>   {
        
        if(this.authServicesService_vb.webViewerProperties_vb!=undefined){
        
        }

        if(this.authServicesService_vb.apiKeyDto_vb.apikey_vb!="" && this.categoryDto_vb==undefined){
          this.userInfo_mt();
          if(this.authServicesService_vb.categoryDto_vb==undefined)
          { 
             this.loadCategory_mt();

          }else{
            this.categoryDto_vb=this.authServicesService_vb.categoryDto_vb;
            this.selectedFilter_vb=this.authServicesService_vb.selectedFilter_vb;
            this.selectedAdType_vb=this.authServicesService_vb.selectedAdType_vb;            
          }
          
          this.timeSubscription_vb.unsubscribe();
        }
      });
      this.changeLang_mt();      
    }

    ngOnDestroy(): void {
      
    }


    userInfo_mt(){

      const formData_vb = new FormData();
      
      this.authServicesService_vb.getUserInfo_mt(formData_vb)
          .subscribe((userInfo_vb: any) =>{
             if(userInfo_vb.p3==="Y"){
              this.userName_vb=userInfo_vb.p2;
              this.userDto_vb.userName_vb=userInfo_vb.p2;
              this.userDto_vb.userId_vb=userInfo_vb.p1;
              this.uploadUrl_vb=userInfo_vb.p4;
              this.userLogin_vb=true;
              this.authServicesService_vb.language_vb=userInfo_vb.p6;
              this.authServicesService_vb.apiKeyDto_vb.userId_vb=userInfo_vb.p1;
              this.authServicesService_vb.apiKeyDto_vb.userName_vb=userInfo_vb.p2;

              
              this.apiKeyDto_vb.language_vb=userInfo_vb.p6;
              this.sharedService_vb.sendLogInOutClickEvent_mt(userInfo_vb.p1,userInfo_vb.p2,"N");
              this.changeLang_mt();
                      
             }else {
              this.authServicesService_vb.language_vb="en";
              this.changeLang_mt();
             }
            },
          (error_vb) => {console.log(error_vb);
            this.authServicesService_vb.language_vb="en";
            this.userLogin_vb=false;
            this.changeLang_mt();            
              
          }      
      );  
     }

    loadCategory_mt(){
      
      const formData_vb = new FormData();
      
      this.authServicesService_vb.getAllCategory_mt(formData_vb)
          .subscribe((categoryDto_vb: any[]) =>{
             if(categoryDto_vb.length>1){
              this.categoryDto_vb=categoryDto_vb;
              this.authServicesService_vb.categoryDto_vb=this.categoryDto_vb;
             }
            },
          (error_vb) => {console.log(error_vb);
                    
      
          }      
      );  
     }

     filterSelected_mt(id_vb:string){
      if(this.selectedFilter_vb.indexOf(","+id_vb+",") > -1) {
        this.selectedFilter_vb =this.selectedFilter_vb.replace(","+id_vb+",", ",");
        this.sharedService_vb.setSelecetdFilter_mt(this.selectedFilter_vb);
      } else {
        this.selectedFilter_vb =this.selectedFilter_vb+id_vb+",";
        this.sharedService_vb.setSelecetdFilter_mt(this.selectedFilter_vb);
      }
      this.authServicesService_vb.selectedFilter_vb=this.selectedFilter_vb;  
     }
     adTypeSelected_mt(id_vb:string){
      if(this.selectedAdType_vb.indexOf(","+id_vb+",") > -1) {
        this.selectedAdType_vb =this.selectedAdType_vb.replace(","+id_vb+",", ",");
        this.sharedService_vb.setSelecetdAdType_mt(this.selectedAdType_vb);
      } else {
        this.selectedAdType_vb =this.selectedAdType_vb+id_vb+",";
        this.sharedService_vb.setSelecetdAdType_mt(this.selectedAdType_vb);
      }
      this.authServicesService_vb.selectedAdType_vb=this.selectedAdType_vb;      
     }

     loadLikedAds_mt(){     
        //this.userDto_vb.search_vb=this.searchForm_vb.get('search_vb').value;
          this.sharedService_vb.sendLoadLikedAdsClickEvent_mt();
        
    }
     logout_mt(){
      const formData_vb = new FormData();
      
      formData_vb.append('p1', this.userDto_vb.userId_vb);
      
    
      this.authServicesService_vb.logout_mt(formData_vb)
          .subscribe((logout_vb: any) =>{
              if(logout_vb.p3="Y")
              {
                this.userName_vb="";
                this.sharedService_vb.sendLogInOutClickEvent_mt(undefined,this.userName_vb,"N"); 
                this.userLogin_vb=false;
              }
            },
          (error_vb) => {console.log(error_vb);
      
          }      
      );  
      this.router_vb.navigate(['xskdihhsdowqi2423156471hviweroqw017ewg1632jvhq2']);
     }

     menu_instant_ads_vb:string;
     menu_weekly_ads_vb:string;

     menu_monthly_ads_vb:string;
     menu_yearly_ads_vb:string;pay_not_in_cash_vb:string;
     reset_secret_number_vb:string;announcementHeading_vb:string;
     merchant_upload_screen_vb:string;user_menu_heading_vb:string;
     user_settings_screen_vb:string;my_useful_ads_vb:string;
     login_vb:string;change_lang_menu_vb:string;category_more_vb:string;
     logout_vb:string;contactUs_vb:string;filter_vb:string;
     changeLang_mt(){

      ToolbarComponent_cl.language_vb=this.authServicesService_vb.language_vb;
      let viewerSideNavMsg_vb: ViewerSideNavMsg_cl = new ViewerSideNavMsg_cl();
      
      this.menu_instant_ads_vb= viewerSideNavMsg_vb.getMsg_mt("menu_instant_ads_msg");
      this.menu_weekly_ads_vb= viewerSideNavMsg_vb.getMsg_mt("menu_weekly_ads_msg");
      this.reset_secret_number_vb= viewerSideNavMsg_vb.getMsg_mt("reset_secret_number_msg");
      this.login_vb= viewerSideNavMsg_vb.getMsg_mt("login_msg");
      this.merchant_upload_screen_vb= viewerSideNavMsg_vb.getMsg_mt("merchant_upload_screen_msg");
      this.menu_monthly_ads_vb= viewerSideNavMsg_vb.getMsg_mt("menu_monthly_ads_msg");
      this.menu_yearly_ads_vb= viewerSideNavMsg_vb.getMsg_mt("menu_yearly_ads_msg");
      this.logout_vb= viewerSideNavMsg_vb.getMsg_mt("logout_msg");
      this.contactUs_vb= viewerSideNavMsg_vb.getMsg_mt("contactUs_msg");
      this.filter_vb= viewerSideNavMsg_vb.getMsg_mt("filter_msg");
      this.user_settings_screen_vb= viewerSideNavMsg_vb.getMsg_mt("user_settings_screen_msg");
      this.change_lang_menu_vb= viewerSideNavMsg_vb.getMsg_mt("change_lang_menu_msg");

      this.announcementHeading_vb= viewerSideNavMsg_vb.getMsg_mt("announcementHeading_msg");
      this.my_useful_ads_vb= viewerSideNavMsg_vb.getMsg_mt("my_useful_ads_msg");
      this.user_menu_heading_vb= viewerSideNavMsg_vb.getMsg_mt("user_menu_heading_msg");
      this.pay_not_in_cash_vb= viewerSideNavMsg_vb.getMsg_mt("pay_not_in_cash_msg");
      this.category_more_vb= viewerSideNavMsg_vb.getMsg_mt("category_more_msg");
      this.sharedService_vb.sendChangeLangEvent_mt();
  
    }
}

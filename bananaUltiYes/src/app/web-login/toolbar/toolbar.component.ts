import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiKeyDto_cl } from '../auth/model/api-key-dto';
import { SharedService_cl } from '../commonUsed/util/shared-service';
import { CookieService } from 'ngx-cookie-service';
import { AuthServicesService_cl } from '../auth/auth-services.service';
@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']

})

export class ToolbarComponent_cl implements OnInit {
  apiKeyDto_vb: ApiKeyDto_cl; 
  static language_vb:string='en';
  constructor( apiKeyDto_vb: ApiKeyDto_cl,private router_vb: Router,
        private authServicesService_vb: AuthServicesService_cl,
        private sharedService_vb:SharedService_cl,private cookieService_vb: CookieService,  ) {
    this.apiKeyDto_vb=apiKeyDto_vb;
    

    this.changeLang_mt(ToolbarComponent_cl.language_vb);
  }
 
  ngOnInit(): void {    
    this.cookieService_vb.set("apikey", this.apiKeyDto_vb.apikey_vb);
    

  }
  
  showSideNavToggle_vb: boolean=false;
  
  showSideNav_mt(){
    this.showSideNavToggle_vb=!this.showSideNavToggle_vb;
  }

  hideSideNav_mt(){
    this.showSideNavToggle_vb=false;
  }

  changeLang_mt1(lang_vb:string){
    
    ToolbarComponent_cl.language_vb=lang_vb;
    let goto_vb='/showRegister';
    if(this.router_vb.url === goto_vb){
      goto_vb='/showLogin'
    }    
    this.router_vb.navigate([goto_vb]);    
  }

  changeLang_mt(lang_vb:string){
    
    
    ToolbarComponent_cl.language_vb=lang_vb;
    this.authServicesService_vb.language_vb=lang_vb;
    

    this.sharedService_vb.sendClickEvent_mt();
  }
}
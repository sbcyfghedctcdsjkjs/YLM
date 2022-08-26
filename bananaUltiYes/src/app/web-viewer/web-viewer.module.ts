import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { WebViewerRoutingModule } from './web-viewer-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ToolbarComponent_cl } from './toolbar/toolbar.component';
import { ViewerScreenComponent_cl } from './viewer-screen/viewer-screen.component';
import {ApiKeyDto_cl} from './auth/model/api-key-dto';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';

import { ToolbarMsg_cl } from './toolbar/propertyComponent/toolbar-msg';
import { AuthServicesService_cl} from './auth/auth-services.service';
import { SearchLocation_cl } from './auth/model/search-loc';
import { InfiniteScrollModule } from 'ngx-infinite-scroll';
import { ViewerSidenavComponent_cl } from './viewer-sidenav/viewer-sidenav.component'
import { ViewerSideNavMsg_cl } from './viewer-sidenav/propertyComponent/viewer-sidenav-msg';
import { ViewerScreenMsg_cl } from './viewer-screen/propertyComponent/viewer-screen-msg'
import { SharedService_cl } from './commonUsed/util/shared-service';


import { ResetSecretNumComponent_cl } from './reset-secret-num/reset-secret-num.component';
import { CallViewerComponent_cl } from './call-viewer/call-viewer.component';
import { ContactUsComponent_cl } from './contact-us/contact-us.component';
import { UserSettingsComponent_cl } from './user-settings/user-settings.component';
import { CookieService } from 'ngx-cookie-service';
import { UserSettingsMsg_cl } from './user-settings/propertyComponent/user-setting-msg';
import { ContactUsScreenMsg_cl } from './contact-us/propertyComponent/contact-us-screen-msg';

import { PayThruQRComponent_Cl } from './pay-thru-qr/pay-thru-qr.component';

import { PayThruQRCodeMsg_cl } from './pay-thru-qr/propertyComponent/pay-thru-qr-msg';
import { PromotionPage1Component_cl } from './promotion-page1/promotion-page1.component';
@NgModule({
  declarations: [
    ToolbarComponent_cl,
    ViewerScreenMsg_cl,
    ViewerScreenComponent_cl,
    ToolbarMsg_cl,
    ViewerSideNavMsg_cl,
    ViewerSidenavComponent_cl,
    ResetSecretNumComponent_cl,
    
    CallViewerComponent_cl,
    ContactUsComponent_cl,ContactUsScreenMsg_cl,

    UserSettingsComponent_cl,UserSettingsMsg_cl, PayThruQRComponent_Cl,PayThruQRCodeMsg_cl, PromotionPage1Component_cl,
  ],
  imports: [
    CommonModule,
    WebViewerRoutingModule,
     InfiniteScrollModule,
     ReactiveFormsModule, 
     
  ],

  providers: [AuthServicesService_cl,ApiKeyDto_cl,SearchLocation_cl,SharedService_cl,CookieService],
  bootstrap: []
  
})

export class WebViewerModule { }
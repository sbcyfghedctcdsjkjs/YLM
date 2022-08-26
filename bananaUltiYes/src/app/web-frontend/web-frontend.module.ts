import { WebFrontendRoutingModule } from './web-frontend-routing.module';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ToolbarComponent_cl } from './audience/view/toolbar/toolbar.component';
import { ShowScreenComponent_cl } from './audience/view/show-screen/show-screen.component';
import { InvalidUrlComponent_cl } from './audience/error/invalid-url/invalid-url.component';
import { SideNavComponent_cl } from './audience/view/side-nav/side-nav.component';
import { LocationComponent_cl } from './audience/view/toolbar/location/location.component';

import { ReactiveFormsModule } from '@angular/forms';
import { OwnerScreenComponent_cl } from './merchant/admin/view/owner-screen/owner-screen.component';
import { OwnerToolbarComponent_cl } from './merchant/admin/view/owner-toolbar/owner-toolbar.component';
import { OwnerSideNavComponent_cl } from './merchant/admin/view/owner-side-nav/owner-side-nav.component';
import { OwnerLoginComponent_cl } from './merchant/admin/view/owner-login/owner-login.component';
import { OwnerScreenService_cl } from './merchant/admin/view/owner-services/owner-screen.service';
import { OwnerTargetAreaComponent_cl } from './merchant/admin/view/owner-target-area/owner-target-area.component';
import { OwnerListAdComponent_cl } from './merchant/admin/view/owner-list-ad/owner-list-ad.component';
import { ToolbarMsg_cl } from './merchant/admin/view/owner-toolbar/propertyComponent/toolbar-msg';
import { TargetareaMsg_cl } from './merchant/admin/view/owner-target-area/propertyComponent/targetarea-msg';
import { SideNavProperty_cl } from './merchant/admin/view/owner-side-nav/propertyComponent/side-nav-property';
import { ListMyAdProperty_cl } from './merchant/admin/view/owner-list-ad/propertyComponent/list-my-ad-property';
import { UploadAdsMsgProperty_cl } from './merchant/admin/view/owner-screen/propertyComponent/uploadAds-msg-property';
import { PropertiesComponent_cl} from './commonUsed/util/properties/propertyComponents/properties.component';

import { ApiKeyDto_cl } from './merchant/admin/view/owner-services/model/api-key-dto';

import { CommonMessages_cl } from './commonUsed/util/common-msg';
import { SharedService_cl } from './commonUsed/util/shared-service';
import { CallOwnerUploadComponent_cl } from './call-owner-upload/call-owner-upload.component';
@NgModule({
  declarations: [
    ToolbarComponent_cl,
    ShowScreenComponent_cl,
    InvalidUrlComponent_cl,
    SideNavComponent_cl,
    LocationComponent_cl,
    OwnerScreenComponent_cl,
    OwnerToolbarComponent_cl,
    OwnerSideNavComponent_cl,
    OwnerLoginComponent_cl,
    OwnerTargetAreaComponent_cl,
    OwnerListAdComponent_cl,CommonMessages_cl,
    PropertiesComponent_cl,ToolbarMsg_cl,TargetareaMsg_cl,
    SideNavProperty_cl,ListMyAdProperty_cl,UploadAdsMsgProperty_cl, CallOwnerUploadComponent_cl
  ],
  imports: [
    CommonModule,
    WebFrontendRoutingModule,

    ReactiveFormsModule,
  ],
  providers: [OwnerScreenService_cl,ApiKeyDto_cl,SharedService_cl],  
  bootstrap: []
})
export class WebFrontendModule { }

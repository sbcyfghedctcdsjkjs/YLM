import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InvalidUrlComponent_cl } from './audience/error/invalid-url/invalid-url.component';
import { ShowScreenComponent_cl } from './audience/view/show-screen/show-screen.component';
import { OwnerScreenComponent_cl } from './merchant/admin/view/owner-screen/owner-screen.component';
import { OwnerTargetAreaComponent_cl } from './merchant/admin/view/owner-target-area/owner-target-area.component';
import { OwnerListAdComponent_cl } from './merchant/admin/view/owner-list-ad/owner-list-ad.component';
import { ApiKeyDto_cl } from './merchant/admin/view/owner-services/model/api-key-dto';

import { CallOwnerUploadComponent_cl } from './call-owner-upload/call-owner-upload.component';
const routes: Routes = [
 { path: 'showMain', component: ShowScreenComponent_cl }
,{ path: 'tellTargets', component: OwnerTargetAreaComponent_cl }
,{ path: 'listMyAds', component: OwnerListAdComponent_cl }
,{ path: 'owner/:p1_vb/:p2_vb', component: OwnerScreenComponent_cl }
,{ path: 'listMyAds/owner/upload/modify/:p1_vb/:p2_vb',   component: OwnerScreenComponent_cl }

,{ path: '', component: CallOwnerUploadComponent_cl }
,{ path: '**', component: InvalidUrlComponent_cl
}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WebFrontendRoutingModule { }

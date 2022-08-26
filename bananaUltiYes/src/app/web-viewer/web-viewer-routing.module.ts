import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewerScreenComponent_cl } from './viewer-screen/viewer-screen.component';
import { CallViewerComponent_cl } from './call-viewer/call-viewer.component';
import { ContactUsComponent_cl } from './contact-us/contact-us.component';
import { UserSettingsComponent_cl } from './user-settings/user-settings.component';
import { ResetSecretNumComponent_cl } from './reset-secret-num/reset-secret-num.component';
import { PayThruQRComponent_Cl } from './pay-thru-qr/pay-thru-qr.component';


const routes: Routes = [   
   { path: '', component: ViewerScreenComponent_cl }
  ,{ path: 'callViewer/:p1_vb/:p2_vb', component: CallViewerComponent_cl}
  ,{ path: 'contactUs', component: ContactUsComponent_cl}
  ,{ path: 'userSettings/:p1_vb', component: UserSettingsComponent_cl}
  ,{ path: 'resetSecretNumber', component: ResetSecretNumComponent_cl}
  ,{ path: 'showQR/:p1_vb/:p2_vb', component: PayThruQRComponent_Cl}



];
  @NgModule({  
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WebViewerRoutingModule { }
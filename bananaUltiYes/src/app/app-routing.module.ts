import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'xskdihhsdowqi2423156471hviweroqw017ewg1632jvhq2',   loadChildren: () => import('./web-viewer/web-viewer.module').then(m => m.WebViewerModule)}
 ,{ path: 'xskdihhsdowqi2423156471hviwerocw017ewg1632jvhq2',   loadChildren: () => import('./cart-viewer/cart-viewer.module').then(m => m.CartViewerModule)}
  //loadChildren: './web-viewer/web-viewer.module#WebViewerModule'}
  //{ path: 'xskdihhsdowqi2423156471hviweroqw017ewg1632jvhq2',   loadChildren: () => import('./free-web-login/free-web-login.module').then(m => m.FreeWebLoginModule)}
  // {  path: 'xskdihhsdowqi2423156471hviweroqw017ewg1632jvhq2',  component: ViewerScreenComponent_cl}
  
  ,{ path: 'showLogin/:p1_vb',   loadChildren: () => import('./web-login/web-login.module').then(m => m.WebLoginModule)}
  ,{ path: 'callOwner/:p1_vb/:p2_vb',   loadChildren: () => import('./web-frontend/web-frontend.module').then(m => m.WebFrontendModule)}
  ,{ path: '', redirectTo: '/xskdihhsdowqi2423156471hviweroqw017ewg1632jvhq2' ,pathMatch:'full'}  
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]


})
export class AppRoutingModule { }

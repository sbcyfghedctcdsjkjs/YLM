import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AskToResetSecretComponent_cl } from './ask-to-reset-secret/ask-to-reset-secret.component';
import { LoginScreenComponent_cl } from './login-screen/login-screen.component';
import { RegisterScreenComponent_cl } from './register-screen/register-screen.component';
const routes: Routes = [
  
  { path: '', component: LoginScreenComponent_cl }

  ,{ path: 'showRegister/:p1_vb',pathMatch:'full', component: RegisterScreenComponent_cl }
  ,{ path: 'askToResetSecret', pathMatch:'full', component: AskToResetSecretComponent_cl }
  
  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})


export class WebLoginRoutingModule { }
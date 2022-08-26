import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FreeWebLoginScreenComponent_cl } from './free-web-login-screen/free-web-login-screen.component';

const routes: Routes = [
  { path: '', component: FreeWebLoginScreenComponent_cl }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FreeWebLoginRoutingModule { }

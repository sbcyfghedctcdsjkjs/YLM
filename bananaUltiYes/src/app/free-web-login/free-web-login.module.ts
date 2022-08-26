import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FreeWebLoginRoutingModule } from './free-web-login-routing.module';
import { FreeWebLoginScreenComponent_cl } from './free-web-login-screen/free-web-login-screen.component';
import { ApiKeyDto_cl } from './auth/model/api-key-dto';
import { CookieService } from 'ngx-cookie-service';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';

import { FreeLoginMsg_cl } from './free-web-login-screen/propertyComponent/login-msg';
import { AuthServicesService_cl } from './auth/auth-services.service';
import { SharedService_cl } from './commonUsed/util/shared-service';

@NgModule({
  declarations: [FreeWebLoginScreenComponent_cl,FreeLoginMsg_cl],
  imports: [
    CommonModule,
    FreeWebLoginRoutingModule,
    ReactiveFormsModule,
  ],
  
  providers: [AuthServicesService_cl,ApiKeyDto_cl,SharedService_cl,CookieService],
  bootstrap: []
})
export class FreeWebLoginModule { }

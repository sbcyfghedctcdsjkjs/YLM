import { CommonModule } from '@angular/common';
import { WebLoginRoutingModule } from './web-login-routing.module';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { LoginScreenComponent_cl } from './login-screen/login-screen.component';
import { RegisterScreenComponent_cl } from './register-screen/register-screen.component';
import { ToolbarComponent_cl } from './toolbar/toolbar.component';


import { SharedService_cl } from './commonUsed/util/shared-service';
import { CookieService } from 'ngx-cookie-service';
import { AskToResetSecretComponent_cl } from './ask-to-reset-secret/ask-to-reset-secret.component';
import { AskToResetSecretMsg_cl } from './ask-to-reset-secret/propertyComponent/ask-to-reset-secret-msg';
import { AuthServicesService_cl } from './auth/auth-services.service';
import { ApiKeyDto_cl } from './auth/model/api-key-dto';
import { PropertiesComponent_cl } from './commonUsed/util/properties/propertyComponents/properties.component';
import { LoginMsg_cl } from './login-screen/propertyComponent/login-msg';
import { RegisterMsg_cl } from './register-screen/propertyComponent/register-msg';
import { ToolbarMsg_cl } from './toolbar/propertyComponent/toolbar-msg';

@NgModule({

  declarations: [
    LoginScreenComponent_cl,
    RegisterScreenComponent_cl,PropertiesComponent_cl,
    ToolbarComponent_cl,ToolbarMsg_cl,LoginMsg_cl,RegisterMsg_cl, 
    AskToResetSecretMsg_cl,AskToResetSecretComponent_cl,

  ],
  imports: [
    CommonModule,
    WebLoginRoutingModule,
    ReactiveFormsModule,
  ],
  providers: [AuthServicesService_cl,ApiKeyDto_cl,SharedService_cl,CookieService],
  bootstrap: []
})
export class WebLoginModule { }

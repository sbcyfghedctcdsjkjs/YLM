import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { ApiKeyDto_cl } from '../auth/model/api-key-dto';
import { CookieService } from 'ngx-cookie-service';
@Injectable({
  providedIn: 'root'
})


export class AuthServicesService_cl {  
  private baseUrl_vb = "http://localhost:8020/ba"; 
  // private baseUrl_vb = "https://wed2vvssbk2h2mm2mbvhabsksljw2ns83h872w6jhwd152.shosayty.com/ba"; // 
  language_vb:string="en";
  apiKeyDto_vb: ApiKeyDto_cl=new ApiKeyDto_cl();
  private loginApiKey_vb = this.baseUrl_vb + "/6l3AQeyhgQwedGW2vVSSBjkj2H2jmm2mbVhaBsKSLjw2NSazanqqs"; 
  private validateUserByPhoneUri_vb = this.baseUrl_vb + "/kK324h34gv6upopsbc2378av278sad738bvqv67svkerntpt"; 
  private validateUserByEmailUri_vb = this.baseUrl_vb + "/ncsiow22uiANSX2klsaLAKskj2KSJd546kt1j21k"; 
  private registerNewUserUri_vb = this.baseUrl_vb + "/bjh234b2d2CSjk2kj24KnH546hjL87lasnAKJ"; 


  private recordTrackUri_vb = this.baseUrl_vb + "/kmJHjsAWHBJWD672Bkj83nka348632678dsacKRmAqlweCio43nSDA4wcDF67wiAuq"; //NOT secure, fix it
  private askToResetSecretNum_vb = this.baseUrl_vb + "/kQlsERdcRT03nawBBowp12p31012k3IO4HJM2VC"; 
  constructor(apiKeyDto1_vb: ApiKeyDto_cl,private http_vb: HttpClient) {
    this.apiKeyDto_vb=apiKeyDto1_vb;
  }

  getApiKey_mt(formData_vb: FormData) {    
    return this.http_vb.post(this.loginApiKey_vb,formData_vb);
  }
  
  validateUserByPhone_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.validateUserByPhoneUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }

  validateUserByEmail_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.validateUserByEmailUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }


  registerNewUser_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.registerNewUserUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }


  askToResetSecretNum_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.askToResetSecretNum_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }
  recordPlainTrack_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.recordTrackUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }
  
  callGetAPIKey_mt(pageName_vb)
  {      
    const formData_vb = new FormData();
    this.apiKeyDto_vb.apikey_vb="";
    formData_vb.append('p1',pageName_vb);
      this.getApiKey_mt(formData_vb)
      .subscribe((apiKeyDto_vb: any) =>{
              this.apiKeyDto_vb.apikey_vb=apiKeyDto_vb.p1;
              
            },
          (error_vb) => {console.log(error_vb);
                  
                }      
      );
      
      return this.apiKeyDto_vb.apikey_vb;
  }

}

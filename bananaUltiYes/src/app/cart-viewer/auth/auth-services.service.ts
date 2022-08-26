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
  private recordTrackUri_vb = this.baseUrl_vb + "/kmJHjsAWHBJWD672Bkj83nka348632678dsacKRmAqlweCio43nSDA4wcDF67wiAuq"; //NOT secure, fix it
  

  private getCartProdUri_vb = this.baseUrl_vb + "/w342sawSAWVDSSAQrfhb23784gDERQefr324VbA"; 
  private ownerGetOneImage_vb = this.baseUrl_vb + "/wuiebpd23i2SD3be226kwjbedwedhwe"; 
  private listProdFromCartUri_vb = this.baseUrl_vb + "/whbe6723ve672dc1287e2vdv2378vd67V3DWvvvw78vwe7Vvuv"; 
  private addProdToCartUri_vb = this.baseUrl_vb + "/ewhfYQW827WEH2y2u38bwes287rjhs7826v34hcDSFdq5DFG6eHFDwd"; 
  constructor(apiKeyDto1_vb: ApiKeyDto_cl,private http_vb: HttpClient) {
    this.apiKeyDto_vb=apiKeyDto1_vb;
  }
  readApiKeyDto_mt() {    
    return this.apiKeyDto_vb;
  }
  getApiKey_mt(formData_vb: FormData) {    
    return this.http_vb.post(this.loginApiKey_vb,formData_vb);
  }

  recordPlainTrack_vb(formData_vb: FormData) {   
    return this.http_vb.post(this.recordTrackUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }
  getCartProds_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.listProdFromCartUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }

  getImageRequestCreated_mt(i_vb:string) {    
    return this.http_vb.get(this.ownerGetOneImage_vb+"/"+this.apiKeyDto_vb.apikey_vb+'/'+i_vb,{ responseType: 'blob' });
  }
  addProdToCart_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.addProdToCartUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
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

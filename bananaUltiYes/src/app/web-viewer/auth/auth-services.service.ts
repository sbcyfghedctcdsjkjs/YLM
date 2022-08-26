import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { ApiKeyDto_cl } from '../auth/model/api-key-dto';
import { CategoryDto_cl } from './model/category-dto';

@Injectable({
  providedIn: 'root'
})


export class AuthServicesService_cl {
  private loginDnsName_vb = "http://localhost:4200";
  private baseUrl_vb = "http://localhost:8020/ba";
  // private loginDnsName_vb = "https://www.yeslocalmarket.com";
  // private baseUrl_vb = "https://wed2vvssbk2h2mm2mbvhabsksljw2ns83h872w6jhwd152.shosayty.com/ba";
  apiKeyDto_vb: ApiKeyDto_cl=new ApiKeyDto_cl();
  categoryDto_vb:CategoryDto_cl[];


  selectedFilter_vb:string=",";
  selectedAdType_vb:string=",";
  language_vb:string="en";
  private loginApiKey_vb = this.baseUrl_vb + "/6l3AQeyhgQwedGW2vVSSBjkj2H2jmm2mbVhaBsKSLjw2NSazanqqs"; 
  private searchAndLoadAdsForLocUri_vb = this.baseUrl_vb + "/w342sawSAWVDSSAQrfhb23784gDERQefr324VbA"; 
  private ownerGetOneImage_vb = this.baseUrl_vb + "/wuiebpd23i2SD3be226kwjbedwedhwe"; 
  private saveLikedItemIdsUri_vb = this.baseUrl_vb + "/ldwbpdsdsj81267gds2qwu672lkopwmw";
  private loadLikedItemIdsUri_vb = this.baseUrl_vb + "/wqed278gvb2378d3762lkpoumkn51op1m";
  private loadLikedAdsUri_vb = this.baseUrl_vb + "/ujwvex23wytiqweqwo23sdf42sdf34er67vwe6723vge2ved2yuve";

  private recordTrackUri_vb = this.baseUrl_vb + "/kmJHjsAWHBJWD672Bkj83nka348632678dsacKRmAqlweCio43nSDA4wcDF67wiAuq"; //NOT secure, fix it
  private resetSecretNum_vb = this.baseUrl_vb + "/sdre3SJKFW43WQ83UJsdfNKreJAJMer2VhiolC"; 
  private getAllCategoryUri_vb = this.baseUrl_vb + "/aWEsTRHvTYd213YUJen23dRT3nRTruRT48bfTR56gT45nTHiTYgJ8Uw3wifq283f"; 
  private logoutUri_vb = this.baseUrl_vb + "/sTRHvTYUJeqwn23vbdRT3nRTTYgJ8Uw3wifq28esdo3iutdf"; 
  private userInfoUri_vb = this.baseUrl_vb + "/vb2378dYUJeq5dfDwnvGFbEdRTGH3nGHW2JHv8Uw3wfqtdfrtr"; 
  private changeLangUri_vb = this.baseUrl_vb + "/AmAa2sdssaEWKIU52dfDwnvfdsFbEdRTGHwssdg53487034Uw3"; 
  private loadLangPropertiesMsgUri_vb = this.baseUrl_vb + "/RsfaS43FG456GAEW3276567JYfgh678RTYRE76e457jhgdse454Ew3"; 
  private payThruQRCodeUri_vb = this.baseUrl_vb + "/qwSStyEWRq223ty5321c8734834bADSasd6SD72vcNgsBq21"; 
  private addProdToCartUri_vb = this.baseUrl_vb + "/ewhfYQW827WEH2y2u38bwes287rjhs7826v34hcDSFdq5DFG6eHFDwd"; 
  
  webViewerProperties_vb:Map<string,string> = undefined;
  constructor(apiKeyDto1_vb: ApiKeyDto_cl,private http_vb: HttpClient) {
    this.apiKeyDto_vb=apiKeyDto1_vb;
  }

  getApiKey_mt(formData_vb: FormData) {    
    return this.http_vb.post(this.loginApiKey_vb,formData_vb);
  }

  setApiKeyDto_mt(apiKeyDto_vb: ApiKeyDto_cl) {    
    this.apiKeyDto_vb=apiKeyDto_vb;
  }

  readApiKeyDto_mt() {    
    return this.apiKeyDto_vb;
  }
 
  searchAndLoadAdsForLoc_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.searchAndLoadAdsForLocUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }

  getAllCategory_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.getAllCategoryUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }

  getUserInfo_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.userInfoUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }
  
  logout_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.logoutUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);

  }

  
  
  changeLang_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.changeLangUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }

  getImageRequestCreated_mt(i_vb:string) {    
    return this.http_vb.get(this.ownerGetOneImage_vb+"/"+this.apiKeyDto_vb.apikey_vb+'/'+i_vb,{ responseType: 'blob' });
  }
  

  saveLikedItemsId_mt(formData_vb: FormData) {    
    return this.http_vb.post(this.saveLikedItemIdsUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  
  }
  loadLikedItemsId_mt(formData_vb: FormData) {    
    return this.http_vb.post(this.loadLikedItemIdsUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  
  }
  loadMyLikedAds_mt(formData_vb: FormData) {    
    return this.http_vb.post(this.loadLikedAdsUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  
  }
  resetSecretNum_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.resetSecretNum_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }

  recordPlainTrack_vb(formData_vb: FormData) {   
    return this.http_vb.post(this.recordTrackUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }
  payThruQRCode_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.payThruQRCodeUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }
  loadLangPropertiesMsgUrl_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.loadLangPropertiesMsgUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
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
      
    
  }

  loadProperties_mt(lang_vb: any)
  {
      const formData_vb = new FormData();

      formData_vb.append('p1', lang_vb);

      this.loadLangPropertiesMsgUrl_mt(formData_vb)
              .subscribe((webViewerProperties_vb: any) =>{
                  this.webViewerProperties_vb=webViewerProperties_vb;
                  if(webViewerProperties_vb.p3=="Y"){
                      
                  }
              },
              (error_vb) => {console.log(error_vb);
                  
                              }      
              );  
  }

}

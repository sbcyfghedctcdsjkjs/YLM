import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { ApiKeyDto_cl } from '../owner-services/model/api-key-dto';

@Injectable({
  providedIn: 'root'
})
export class OwnerScreenService_cl {
  
  apiKeyDto_vb: ApiKeyDto_cl=new ApiKeyDto_cl();
  private baseUrl_vb = "http://localhost:8020/ba"; 
  // private baseUrl_vb = "https://wed2vvssbk2h2mm2mbvhabsksljw2ns83h872w6jhwd152.shosayty.com/ba"; 
  language_vb:string="en"; 
  private ownerScreenApiKey_vb = this.baseUrl_vb + "/6l3AQeyhgQwedGW2vVSSBjkj2H2jmm2mbVhaBsKSLjw2NSazanqqs"; 
  private ownerScreenUploadUrl_vb = this.baseUrl_vb + "/s2V3dGwdJwKQ23yKbd25KH612vkmSWwscx562ldw23suAJWQUI"; 
  private ownerScreenModifyUrl_vb = this.baseUrl_vb + "/12iuhQidsdwdt823DAjckaq32a4slkadn2JKAsygxvbjajdgyuy";
  private ownerTargetAreaSaveUrl_vb = this.baseUrl_vb + "/jkfw983H872gw6jhwd152esd62gqjs532gh32zl4v23z04g2h";  
  private ownerTargetAreaLoadUrl_vb = this.baseUrl_vb + "/12fF6712f1726fshjLKKL23gsv2dJK62wvs26w2LKL22"; 
  private ownerLoadAllMyAdsUrl_vb = this.baseUrl_vb + "/a4qaSDfgVMscaw343jd32d322asdJKA3jd";
  private ownerLoadAdWithIdUrl_vb = this.baseUrl_vb + "/jqhs233kjqaSW2Yo1q132323JKJdkk23eb2ed23td3d3";  
  private ownerGetOneImage_vb = this.baseUrl_vb + "/wuiebpd23i2SD3be226kwjbedwedhwe"; 
  private recordTrackUri_vb = this.baseUrl_vb + "/kmJHjsAWHBJWD672Bkj83nka348632678dsacKRmAqlweCio43nSDA4wcDF67wiAuq"; 
  private getAllCategoryUri_vb = this.baseUrl_vb + "/aWEsTRHvTYd213YUJen23dRT3nRTruRT48bfTR56gT45nTHiTYgJ8Uw3wifq283f"; 
  private sortedEmpListUrl_vb = this.baseUrl_vb + "/emp/sort/3/d";
  private arrangeIn_vb: string ="a"; 
  httpOptions = {
    headers: new HttpHeaders({
      
      'Content-Type':  'multipart/form-data'
    })
  };
  
  constructor(apiKeyDto1_vb: ApiKeyDto_cl,private http_vb: HttpClient) {
    this.apiKeyDto_vb=apiKeyDto1_vb;
  }

  getAllEmployees_mt() {
      
      return this.http_vb.get(this.ownerScreenUploadUrl_vb);
  }

  getSortedEmpList_mt(orderByCol_vb : String,arrangeInAsc_vb: boolean) {
    if(arrangeInAsc_vb) this.arrangeIn_vb="a";
    else this.arrangeIn_vb="d";
    return this.http_vb.get(this.baseUrl_vb + "/emp/"+"sort/"+orderByCol_vb+"/"+this.arrangeIn_vb);
  }

  readApiKey_mt(){
    return this.apiKeyDto_vb;
  }

  uploadDataAndImage_mt(formData_vb: FormData){
      return this.http_vb.post(this.ownerScreenUploadUrl_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }

  modifyAd_mt(formData_vb: FormData){
    return this.http_vb.post(this.ownerScreenModifyUrl_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }  

  uploadTargetArea_mt(formData_vb: FormData){
    return this.http_vb.post(this.ownerTargetAreaSaveUrl_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }

  getAllTargetArea_mt(formData_vb: FormData) { 
    return this.http_vb.post(this.ownerTargetAreaLoadUrl_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }

  getAllMyAds_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.ownerLoadAllMyAdsUrl_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }

  
  getAdWithId_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.ownerLoadAdWithIdUrl_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }

  getApiKey_mt(formData_vb: FormData) {    
    return this.http_vb.post(this.ownerScreenApiKey_vb,formData_vb);
  }

  getAllCategory_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.getAllCategoryUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);
  }
 
  recordPlainTrack_mt(formData_vb: FormData) {   
    return this.http_vb.post(this.recordTrackUri_vb+"/"+this.apiKeyDto_vb.apikey_vb,formData_vb);

  }
  
  loadDoc_mt() {
    var xhttp_vb = new XMLHttpRequest();
    xhttp_vb.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        document.getElementById("demo").innerHTML =
        this.responseText;
      }
    };
    xhttp_vb.open("GET", "ajax_info.txt", true);
    xhttp_vb.send();
  }

  getRequestCreated_mt(i_vb:string) {    
    return this.http_vb.get(this.ownerGetOneImage_vb+"/"+this.apiKeyDto_vb.apikey_vb+'/'+i_vb,{ responseType: 'blob' });
  }

  

  callGetAPIKey_mt(pageName_vb)
  {      
    const formData_vb = new FormData();
    this.apiKeyDto_vb.apikey_vb="countdown Startt...";
    formData_vb.append('id',pageName_vb);
      this.getApiKey_mt(formData_vb)
      .subscribe((apiKeyDto_vb: any) =>{
              this.apiKeyDto_vb.apikey_vb=apiKeyDto_vb.p1;
            },
          (error_vb) => {console.log(error_vb);
                }      
      );
     
  }
}

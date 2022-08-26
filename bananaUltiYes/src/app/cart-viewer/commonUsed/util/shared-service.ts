import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable()
export class SharedService_cl {
  private changeLang_subject_vb = new Subject<any>();
  sendChangeLangEvent_mt() {
    this.changeLang_subject_vb.next();
  }
  getChangeLangEvent_mt(): Observable<any>{ 
    
    return this.changeLang_subject_vb.asObservable();
  }

  private loadAds_subject_vb = new Subject<any>();
  private search_vb:string;
  sendLoadAdsClickEvent_mt(search_vb:string) {
    this.search_vb=search_vb;
    this.loadAds_subject_vb.next(search_vb);
  }
  getLoadAdsClickEvent_mt(): Observable<any>{ 
    
    return this.loadAds_subject_vb.asObservable();
  }

  getSearch_mt(){
    return this.search_vb;
  }

  private loadLikedAds_subject_vb = new Subject<any>();
  sendLoadLikedAdsClickEvent_mt() {
    //this.search_vb=search_vb;
    this.loadLikedAds_subject_vb.next();
  }
  getLoadLikedAdsClickEvent_mt(): Observable<any>{ 
    
    return this.loadLikedAds_subject_vb.asObservable();
  }


  private logInOut_subject_vb = new Subject<any>();
  private loginId_vb:string;
  private logout_vb:string;
  private loginName_vb:string;

  sendLogInOutClickEvent_mt(loginId_vb:string,loginName_vb:string, logout_vb:string) {
    this.loginId_vb=loginId_vb;
    this.loginName_vb=loginName_vb;
    this.logout_vb=logout_vb;
    this.logInOut_subject_vb.next();
  }
  getLogInOutClickEvent_mt(): Observable<any>{ 
    
    return this.logInOut_subject_vb.asObservable();
  }

  getLoginId_mt(){
    return this.loginId_vb;
  }

  getLogout_mt(){
    return this.logout_vb;
  }

  getLoginName_mt(){
    return this.loginName_vb;
  }

  private selectedFilter_vb:string;
  getSelectedFilter_mt(){

    return this.selectedFilter_vb;
  }
  setSelecetdFilter_mt(selectedFilter_vb:string){
    this.selectedFilter_vb=selectedFilter_vb;

  }
  private selectedAdType_vb:string;
  getSelectedAdType_mt(){

    return this.selectedAdType_vb;
  }
  setSelecetdAdType_mt(selectedAdType_vb:string){
    this.selectedAdType_vb=selectedAdType_vb;

  }
}
import 'dart:collection';

import 'package:yeslocalmarket01aa/mvvm2/fetchAdsCategory/FetchAdsCategoryViewModel.dart';

class UserInfo_cl {
  String locationSearch_vb;
  static int pageNum_vb;
  static bool searchStarted_vb=false;
  static bool noResultFound_vb=false;
  static String id_vb;
  String userId_vb;
  String phone_vb;
  String email_vb;
  String secretNumber_vb;
  static String likedAdsAtOnLoad_vb="";
  static String categoryByDurationIdList_vb;
  static String categoryByTypeIdList_vb;
  static String idOfLikedAds_vb;
  static String apiKey_vb;
  static List<FetchAdsCatgeoryViewModel_cl> adsCategoryVMList_vb;
  static String loginOutWait_vb;
  UserInfo_cl({ this.locationSearch_vb,this.userId_vb,this.phone_vb,this.email_vb,this.secretNumber_vb});

  factory UserInfo_cl.fromJson_mt(Map<String, dynamic> json_vb) {
    id_vb=json_vb['p10'];
    likedAdsAtOnLoad_vb=json_vb['p4'];
    idOfLikedAds_vb=json_vb['p6'];
    return UserInfo_cl(
      phone_vb: json_vb['p1'],
      email_vb: json_vb['p2'],
      secretNumber_vb: json_vb['p3'],
      userId_vb: json_vb['p10'],

    );
  }

  void set setLocationSearch_mt(String str){
    locationSearch_vb=str;
  }

  String get getLocationSearch_mt{
    return locationSearch_vb;
  }

  void set setPageNum_mt(String str){
    locationSearch_vb=str;
  }

  String get getPageNum_mt{
    return locationSearch_vb;
  }

  void set setIdR_mt(String n){
    id_vb=n;
  }

  String get getIdR_mt{
    return id_vb;
  }

  void set setUserId_mt(String n){
    userId_vb=n;
  }

  String get getUserId_mt{
    return userId_vb;
  }

  void set setIdOfLikedAds_mt(String n){
    idOfLikedAds_vb=n;
  }

  String get getIdOfLikedAds_mt{
    return idOfLikedAds_vb;
  }

  void set setLikedAdsAtOnLoad_mt(String str){
    likedAdsAtOnLoad_vb=str;
  }

  String get getLikedAdsAtOnLoad_mt{
    return likedAdsAtOnLoad_vb;
  }

  void set setApiKey_mt(String str){
    apiKey_vb=str;
  }

  String get getApiKey_mt{
    return apiKey_vb;
  }

  void setAdsCategoryVMList_mt(List<FetchAdsCatgeoryViewModel_cl> list){
    adsCategoryVMList_vb=list;
  }

  List<FetchAdsCatgeoryViewModel_cl> get getAdsCategoryVMList_mt{
    return adsCategoryVMList_vb;
  }

  void setCategoryByDurationIdList_mt(String list){
    categoryByDurationIdList_vb=list;
  }

  String get getCategoryByDurationIdList_mt{
    return categoryByDurationIdList_vb;
  }


  void setCategoryByTypeIdList_mt(String list){
    categoryByTypeIdList_vb=list;
  }

  String get getCategoryByTypeIdList_mt{
    return categoryByTypeIdList_vb;
  }

  void setLoginOutWait_mt(String loginOutWait){
    loginOutWait_vb=loginOutWait;
  }

  String get getLoginOutWait_mt{
    return loginOutWait_vb;
  }
}
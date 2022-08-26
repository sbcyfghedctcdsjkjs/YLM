import 'package:flutter/material.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAds/FetchAdsContent.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAds/FetchAdsWebService.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAds/FetchAdsViewModel.dart';
import 'package:yeslocalmarket01aa/mvvm2/modelDTO/userInfo.dart';

enum LoadingStatus_cl {
  completed_vb,
  searching_vb,
  empty_vb,
}

class FetchAdsNotifier_cl with ChangeNotifier {
  LoadingStatus_cl loadingStatus_vb = LoadingStatus_cl.searching_vb;
  List<FetchAdsViewModel_cl> myAdsVMList_vb = List<FetchAdsViewModel_cl>();
  List<FetchAdsViewModel_cl> ownerAdsVMList_vb = List<FetchAdsViewModel_cl>();
  Future<List<FetchAdsViewModel_cl>>  fectchAdsInPagesByPageNum2_mt(int pageNum_vb, String locationSearch_vb
      ,String adTypes,String filters ) async {
    if(UserInfo_cl.searchStarted_vb) pageNum_vb=1;
    List<FetchAdsContent_cl> myAds = await FetchAdsWebService_cl().fectchAdsInPagesByPageNum_mt(pageNum_vb, locationSearch_vb,adTypes,filters);
    notifyListeners();

    //myAdsVMList_vbTemp = myAds.map((myAdsData) => MyAdContentViewModel(myADContent: myAdsData)).toList();
    if(this.myAdsVMList_vb.isEmpty){
      List<FetchAdsViewModel_cl> tempVMList_vb =myAds.map((myAdsData_vb) => FetchAdsViewModel_cl(fetchAdsContent_vb: myAdsData_vb)).toList();
      if(tempVMList_vb.length > 0)
      {
        this.myAdsVMList_vb =tempVMList_vb;
        UserInfo_cl.searchStarted_vb=false;
      }else  // No results found
          {
        UserInfo_cl.noResultFound_vb=true;
      }

    }
    else{
      this.myAdsVMList_vb += myAds.map((myAdsData_vb) => FetchAdsViewModel_cl(fetchAdsContent_vb: myAdsData_vb)).toList();
    }

    return this.myAdsVMList_vb;
  }


  void fectchAdsInPagesByPageNum_mt(int pageNum_vb, String locationSearch_vb
                                  ,String adTypes,String filters ) async {
    if(UserInfo_cl.searchStarted_vb) pageNum_vb=1;
    List<FetchAdsContent_cl> myAds = await FetchAdsWebService_cl().fectchAdsInPagesByPageNum_mt(pageNum_vb, locationSearch_vb,adTypes,filters);
    notifyListeners();

    //myAdsVMList_vbTemp = myAds.map((myAdsData) => MyAdContentViewModel(myADContent: myAdsData)).toList();
    if(this.myAdsVMList_vb.isEmpty){
      List<FetchAdsViewModel_cl> tempVMList_vb =myAds.map((myAdsData_vb) => FetchAdsViewModel_cl(fetchAdsContent_vb: myAdsData_vb)).toList();
        if(tempVMList_vb.length > 0)
        {
          this.myAdsVMList_vb =tempVMList_vb;
          UserInfo_cl.searchStarted_vb=false;
        }else  // No results found
          {
            UserInfo_cl.noResultFound_vb=true;
          }

    }
    else{
      this.myAdsVMList_vb += myAds.map((myAdsData_vb) => FetchAdsViewModel_cl(fetchAdsContent_vb: myAdsData_vb)).toList();
    }

    if (this.myAdsVMList_vb.isEmpty) {
      this.loadingStatus_vb = LoadingStatus_cl.empty_vb;
    } else {
      this.loadingStatus_vb = LoadingStatus_cl.completed_vb;
    }
    //printMyAdsVMListId("pageNum: "+pageNum.toString());
    notifyListeners();

  }

//  void fectchAdsInPagesByPageNumOnLoadWithApiKey(int pageNum,
//      String locationSearch,String apiKey) async {
//    print("fectchAdsInPagesByPageNumOnLoadWithApiKey 1 pageNum: " + pageNum.toString());
//    locationSearch==null ? print("fectchAdsInPagesByPageNumOnLoadWithApiKey loc=null"):print("fectchAdsInPagesByPageNumOnLoadWithApiKey loc="+locationSearch );
//    // locationSearch="delhi";
//
//    //if (UserInfo.searchStarted) pageNum = 1;
//
//    List<FetchAdsContent> myAds1 = await FetchAdsWebService()
//        .fectchAdsInPagesByPageNumWithApiKey(pageNum, locationSearch,apiKey);
//    notifyListeners();
//    print("fectchAdsInPagesByPageNumOnLoad 2 " + myAds1.length.toString());
//    if (myAds1.length > 0) {
//      this.myAdsVMList_vb += myAds1.map((myAdsData) =>
//          FetchAdsViewModel(fetchAdsContent: myAdsData)).toList();
//    }
//    if (this.myAdsVMList_vb.isEmpty) {
//      this.loadingStatus = LoadingStatus_cl.empty;
//    } else {
//      print("fectchAdsInPagesByPageNumOnLoad completed this.myAdsVMList_vb: " +
//          this.myAdsVMList_vb.length.toString());
//      this.loadingStatus = LoadingStatus_cl.completed;
//    }
//    notifyListeners();
//  }
  Future<List<FetchAdsViewModel_cl>> fectchAdsInPagesByPageNumOnLoad2_mt(int pageNum,
      String locationSearch,String adTypes,String filters ) async {
    //locationSearch==null ? print("fectchAdsInPagesByPageNumOnLoad loc=null"):print("fectchAdsInPagesByPageNumOnLoad loc="+locationSearch );

    List<FetchAdsContent_cl> myAds1 = await FetchAdsWebService_cl().fectchAdsInPagesByPageNum_mt(pageNum, locationSearch
        ,adTypes,filters);
    //notifyListeners();
    if (myAds1.length > 0) {
      this.myAdsVMList_vb += myAds1.map((myAdsData_vb) =>
          FetchAdsViewModel_cl(fetchAdsContent_vb: myAdsData_vb)).toList();
    }
    return this.myAdsVMList_vb;
    // if (this.myAdsVMList_vb.isEmpty) {
    //   this.loadingStatus_vb = LoadingStatus_cl.empty_vb;
    // } else {
    //   this.loadingStatus_vb = LoadingStatus_cl.completed_vb;
    // }
    //notifyListeners();
  }



  void fectchAdsInPagesByPageNumOnLoad_mt(int pageNum,
      String locationSearch,String adTypes,String filters ) async {
    //locationSearch==null ? print("fectchAdsInPagesByPageNumOnLoad loc=null"):print("fectchAdsInPagesByPageNumOnLoad loc="+locationSearch );

    List<FetchAdsContent_cl> myAds1 = await FetchAdsWebService_cl().fectchAdsInPagesByPageNum_mt(pageNum, locationSearch
                                                                  ,adTypes,filters);
    notifyListeners();
    if (myAds1.length > 0) {
      this.myAdsVMList_vb += myAds1.map((myAdsData_vb) =>
          FetchAdsViewModel_cl(fetchAdsContent_vb: myAdsData_vb)).toList();
    }
    if (this.myAdsVMList_vb.isEmpty) {
      this.loadingStatus_vb = LoadingStatus_cl.empty_vb;
    } else {
      this.loadingStatus_vb = LoadingStatus_cl.completed_vb;
    }
    notifyListeners();
  }

  Future<List<FetchAdsViewModel_cl>> fectchAdsInPagesByPageNumOnSearchLoad2_mt(int pageNum,
      String locationSearch,String adTypes,String filters ) async {
    List<FetchAdsContent_cl> myAds1 = await FetchAdsWebService_cl().fectchAdsInPagesByPageNum_mt(pageNum, locationSearch,adTypes,filters);
    notifyListeners();

    List<FetchAdsViewModel_cl> tempVMList = myAds1.map((myAdsData_vb) =>
        FetchAdsViewModel_cl(fetchAdsContent_vb: myAdsData_vb)).toList();
    if (tempVMList.length > 0) {
      this.myAdsVMList_vb = tempVMList;
    } else // No results found
        {
      UserInfo_cl.noResultFound_vb = true;
    }

    // if (this.myAdsVMList_vb.isEmpty) {
    //   this.loadingStatus_vb = LoadingStatus_cl.empty_vb;
    // } else {
    //   this.loadingStatus_vb = LoadingStatus_cl.completed_vb;
    // }

    //notifyListeners();
    return this.myAdsVMList_vb;
  }

  Future<List<FetchAdsViewModel_cl>> fetchOwnerHisOwnAds2_mt(String id_vb) async {
    List<FetchAdsContent_cl> myAds1 = await FetchAdsWebService_cl().fectchOwnerHisOwnAds_mt(id_vb);
    notifyListeners();

    List<FetchAdsViewModel_cl> tempVMList = myAds1.map((myAdsData_vb) =>
        FetchAdsViewModel_cl(fetchAdsContent_vb: myAdsData_vb)).toList();
    if (tempVMList.length > 0) {
      this.ownerAdsVMList_vb = tempVMList;
    } else // No results found
        {
      UserInfo_cl.noResultFound_vb = true;
    }

    /*if (this.myAdsVMList_vb.isEmpty) {
      this.loadingStatus_vb = LoadingStatus_cl.empty_vb;
    } else {
      this.loadingStatus_vb = LoadingStatus_cl.completed_vb;
    }

    notifyListeners();*/
    return this.ownerAdsVMList_vb;
  }

  void fectchAdsInPagesByPageNumOnSearchLoad_mt(int pageNum,
      String locationSearch,String adTypes,String filters ) async {
    List<FetchAdsContent_cl> myAds1 = await FetchAdsWebService_cl().fectchAdsInPagesByPageNum_mt(pageNum, locationSearch,adTypes,filters);
    notifyListeners();

    List<FetchAdsViewModel_cl> tempVMList = myAds1.map((myAdsData_vb) =>
        FetchAdsViewModel_cl(fetchAdsContent_vb: myAdsData_vb)).toList();
    if (tempVMList.length > 0) {
      this.myAdsVMList_vb = tempVMList;
    } else // No results found
        {
      UserInfo_cl.noResultFound_vb = true;
    }

    if (this.myAdsVMList_vb.isEmpty) {
      this.loadingStatus_vb = LoadingStatus_cl.empty_vb;
    } else {
      this.loadingStatus_vb = LoadingStatus_cl.completed_vb;
    }

    notifyListeners();

  }

//  printMyAdsVMListId(String idntyStr){
//    int n=0;
//    String str="";
//    while(n < myAdsVMList_vb.length)
//    {
//      str += ","+myAdsVMList_vb[n].adId.toString();
//
//
//      n++;
//    }
//    print("printMyAdsVMListId > "+idntyStr+" >>> myAdsVMList_vb ids: "+str);
//    str=null;
//    n=null;
//  }
//
//
//  void fectchAdsInPagesByPageNumGOOD(int pageNum, String locationSearch) async {
//    if(UserInfo.searchStarted) pageNum=1;
//
//    List<FetchAdsContent> myAds = await FetchAdsWebService().fectchAdsInPagesByPageNum(pageNum, locationSearch);
//    notifyListeners();
//
//    //myAdsVMList_vbTemp = myAds.map((myAdsData) => MyAdContentViewModel(myADContent: myAdsData)).toList();
//    if(UserInfo.searchStarted){
//      List<FetchAdsViewModel> tempVMList =myAds.map((myAdsData) => FetchAdsViewModel(fetchAdsContent: myAdsData)).toList();
//      if(tempVMList.length > 0)
//      {
//        this.myAdsVMList_vb =tempVMList;
//        UserInfo.searchStarted=false;
//      }else  // No results found
//          {
//        UserInfo.noResultFound=true;
//      }
//
//    }
//    else{
//      this.myAdsVMList_vb += myAds.map((myAdsData) => FetchAdsViewModel(fetchAdsContent: myAdsData)).toList();
//    }
//
//    if (this.myAdsVMList_vb.isEmpty) {
//      this.loadingStatus = LoadingStatus_cl.empty;
//    } else {
//      this.loadingStatus = LoadingStatus_cl.completed;
//    }
//    notifyListeners();
//  }
}

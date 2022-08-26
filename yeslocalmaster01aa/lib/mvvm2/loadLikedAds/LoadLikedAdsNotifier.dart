import 'package:flutter/material.dart';
import 'package:yeslocalmarket01aa/mvvm2/loadLikedAds/LoadLikedAdsModel.dart';
import 'package:yeslocalmarket01aa/mvvm2/loadLikedAds/LoadLikedAdsWebService.dart';
import 'package:yeslocalmarket01aa/mvvm2/loadLikedAds/LoadLikedAdsViewModel.dart';
import 'package:yeslocalmarket01aa/mvvm2/modelDTO/userInfo.dart';

enum LoadingStatusTemp {
  completed_vb,
  searching_vb,
  empty_vb,
}

class LoadLikedAdsNotifier_cl with ChangeNotifier {
  LoadingStatusTemp loadingStatusTemp_vb = LoadingStatusTemp.searching_vb;
  List<LoadLikedAdsViewModel_cl> myAdsVMList_vb = List<LoadLikedAdsViewModel_cl>();
  LoadLikedAdsModel_cl myAdContent_vb=LoadLikedAdsModel_cl();

//  void loadLikedAds(UserInfo userInfo) async {
//    myAdContent  = await LoadLikedAdsWebService().loadLikedAds(userInfo.getIdR.toString());
//    List<LoadLikedAdsViewModel> testVMList = List<LoadLikedAdsViewModel>();
//    this.myAdContent.likedAdsId==null ? print("1 this.myAdContent.likedAdsId==null") : print("1 this.myAdContent.likedAdsId!=null >> "+this.myAdContent.likedAdsId);
//    //this.myAdContent=myAd;
//    //notifyListeners();
//    //myAdsVMListTemp = myAds.map((myAdsData) => MyAdContentViewModel(myADContent: myAdsData)).toList();
//    //testVMList +=  myAds.map((myAdsData) => MyAdContentViewModelTemp(myADContent: myAdsData)).toList();
//
//    if (testVMList.isEmpty) {
//      //this.loadingStatusTemp = LoadingStatusTemp.empty;
//    } else {
//      print("MyAdContentListViewModelTemp loadLikedAds() likedAdsId: "+ myAdContent.likedAdsId);
//      //this.loadingStatusTemp = LoadingStatusTemp.completed;
//    }
//    this.myAdContent.likedAdsId==null ? print("2 this.myAdContent.likedAdsId==null") : print("2 this.myAdContent.likedAdsId!=null");
//    //notifyListeners();
//  }

//  void saveLikedAds(String likedAdsIds) async {
//    String myAd  = await WebServiceTemp().saveLikedAds(likedAdsIds);
//    List<MyAdContentViewModelTemp> testVMList = List<MyAdContentViewModelTemp>();
//    //this.myAdContent=myAd;
//    notifyListeners();
//    //myAdsVMListTemp = myAds.map((myAdsData) => MyAdContentViewModel(myADContent: myAdsData)).toList();
//    //testVMList +=  myAds.map((myAdsData) => MyAdContentViewModelTemp(myADContent: myAdsData)).toList();
//
//    if (testVMList.isEmpty) {
//      this.loadingStatusTemp = LoadingStatusTemp.empty;
//    } else {
//      //print("MyAdContentListViewModelTemp test() likedAdsId: "+ myAd.likedAdsId);
//      this.loadingStatusTemp = LoadingStatusTemp.completed;
//    }
//    notifyListeners();
//  }

//  void test3() async {
//    List<MyAdContentTemp> myAds  = await WebServiceTemp().test3();
//    List<MyAdContentViewModelTemp> testVMList = List<MyAdContentViewModelTemp>();
//    //notifyListeners();
//    //myAdsVMListTemp = myAds.map((myAdsData) => MyAdContentViewModel(myADContent: myAdsData)).toList();
//    testVMList +=  myAds.map((myAdsData) => MyAdContentViewModelTemp(myADContent: myAdsData)).toList();
//
//    if (testVMList.isEmpty) {
//      //this.loadingStatusTemp = LoadingStatusTemp.empty;
//    } else {
//      print("MyAdContentListViewModelTemp test() likedAdsId: "+ testVMList[0].pageNum.toString());
//      //this.loadingStatusTemp = LoadingStatusTemp.completed;
//    }
//    //notifyListeners();
//  }


//  void fectchAdsInPagesByPageNum(int pageNum) async {
//
//    List<MyAdContentTemp> myAds = await WebServiceTemp().fectchAdsInPagesByPageNum(pageNum);
//    notifyListeners();
//
//    //myAdsVMListTemp = myAds.map((myAdsData) => MyAdContentViewModel(myADContent: myAdsData)).toList();
//    this.myAdsVMList +=  myAds.map((myAdsData) => MyAdContentViewModelTemp(myADContent: myAdsData)).toList();
//
//    if (this.myAdsVMList.isEmpty) {
//      //this.loadingStatusTemp = LoadingStatusTemp.empty;
//    } else {
//      print("Lenmght11  temp this.myAdsVMList: "+ this.myAdsVMList.length.toString());
//      //this.loadingStatusTemp = LoadingStatusTemp.completed;
//    }
//
//    notifyListeners();
//  }
//
//  void getAdsCount() async {
//
//    List<MyAdContent> myAds = await WebService().fectchAdsCount();
//    notifyListeners();
//
//    this.myAdsVMList = myAds
//        .map((myAdsData) => MyAdContentViewModel(myADContent: myAdsData))
//        .toList();
//
//    if (this.myAdsVMList.isEmpty) {
//      this.loadingStatus = LoadingStatus.empty;
//    } else {
//      this.loadingStatus = LoadingStatus.completed;
//    }
//
//    notifyListeners();
//  }
//
//  void adsOfRegion(String regionAddress) async {
//    this.loadingStatus = LoadingStatus.searching;
//    notifyListeners();
//
//    List<MyAdContent> myAds =
//        await WebService().fectchAdsByRegion(regionAddress);
//
//    this.myAdsVMList = myAds
//        .map((myAdsData) => MyAdContentViewModel(myADContent: myAdsData))
//        .toList();
//
//    if (this.myAdsVMList.isEmpty) {
//      this.loadingStatus = LoadingStatus.empty;
//    } else {
//      this.loadingStatus = LoadingStatus.completed;
//    }
//
//    notifyListeners();
//  }
//
//  void adsOfNearByRegion() async {
//
//    List<MyAdContent> myAds = await WebService().fectchAdsOfNearByRegion();
//    notifyListeners();
//
//    this.myAdsVMList = myAds
//        .map((myAdsData) => MyAdContentViewModel(myADContent: myAdsData))
//        .toList();
//
//    if (this.myAdsVMList.isEmpty) {
//      this.loadingStatus = LoadingStatus.empty;
//    } else {
//      this.loadingStatus = LoadingStatus.completed;
//    }
//
//    notifyListeners();
//  }
}

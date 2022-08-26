import 'package:flutter/material.dart';
import 'package:yeslocalmarket01aa/mvvm2/modelDTO/userInfo.dart';
import 'FetchAdsCategory.dart';
import 'FetchAdsCategoryViewModel.dart';
import 'FetchAdsCategoryWebService.dart';
enum CategoryLoadingStatus_cl {
  completed_vb,
  searching_vb,

  empty_vb,
}

class FetchAdsCategoryNotifier_cl with ChangeNotifier {
  CategoryLoadingStatus_cl loadingStatus_vb = CategoryLoadingStatus_cl.searching_vb;
  List<FetchAdsCatgeoryViewModel_cl> myAdsCategoryVMList_vb = List<FetchAdsCatgeoryViewModel_cl>();

  void fectchAllAdsCategory_mt() async {
    //if(UserInfo_cl.searchStarted_vb) pageNum_vb=1;
    List<FetchAdsCategory_cl> myAds = await FetchAdsCategoryWebService_cl().fectchAdsCategory_mt();
    notifyListeners();

    //myAdsVMList_vbTemp = myAds.map((myAdsData) => MyAdContentViewModel(myADContent: myAdsData)).toList();
    if(this.myAdsCategoryVMList_vb.isEmpty){
      List<FetchAdsCatgeoryViewModel_cl> tempVMList_vb =myAds.map((myAdsData_vb) => FetchAdsCatgeoryViewModel_cl(fetchAdsCategory_vb: myAdsData_vb)).toList();
        if(tempVMList_vb.length > 0)
        {
          this.myAdsCategoryVMList_vb =tempVMList_vb;
          UserInfo_cl.searchStarted_vb=false;
        }else  // No results found
          {
            UserInfo_cl.noResultFound_vb=true;
          }

    }
    else{
      this.myAdsCategoryVMList_vb += myAds.map((myAdsData_vb) => FetchAdsCatgeoryViewModel_cl(fetchAdsCategory_vb: myAdsData_vb)).toList();
    }

    if (this.myAdsCategoryVMList_vb.isEmpty) {
      this.loadingStatus_vb = CategoryLoadingStatus_cl.empty_vb;
    } else {
      this.loadingStatus_vb = CategoryLoadingStatus_cl.completed_vb;
    }
    //printMyAdsVMListId("pageNum: "+pageNum.toString());
    notifyListeners();

  }
 /* void fectchAdsInPagesByPageNumOnLoad_mt(int pageNum,
      String locationSearch) async {
    //locationSearch==null ? print("fectchAdsInPagesByPageNumOnLoad loc=null"):print("fectchAdsInPagesByPageNumOnLoad loc="+locationSearch );

    List<FetchAdsContent_cl> myAds1 = await FetchAdsWebService_cl().fectchAdsInPagesByPageNum_mt(pageNum, locationSearch);
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

  void fectchAdsInPagesByPageNumOnSearchLoad_mt(int pageNum,
      String locationSearch) async {
    List<FetchAdsContent_cl> myAds1 = await FetchAdsWebService_cl().fectchAdsInPagesByPageNum_mt(pageNum, locationSearch);
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
*/

}

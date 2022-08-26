import 'package:flutter/material.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchOwnerAds/FetchOwnerAdsContent.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchOwnerAds/FetchOwnerAdsWebService.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchOwnerAds/FetchOwnerAdsViewModel.dart';
import 'package:yeslocalmarket01aa/mvvm2/modelDTO/userInfo.dart';

enum LoadingStatus_cl {
  completed_vb,

  searching_vb,
  empty_vb,
}

class FetchOwnerAdsNotifier_cl with ChangeNotifier {
  LoadingStatus_cl loadingStatus_vb = LoadingStatus_cl.searching_vb;
  List<FetchOwnerAdsViewModel_cl> ownerAdsVMList_vb = List<FetchOwnerAdsViewModel_cl>();


  Future<List<FetchOwnerAdsViewModel_cl>> fetchOwnerHisOwnAds2_mt(String id_vb) async {
    List<FetchOwnerAdsContent_cl> myAds1 = await FetchOwnerAdsWebService_cl().fectchOwnerHisOwnAds_mt(id_vb);
    notifyListeners();

    List<FetchOwnerAdsViewModel_cl> tempVMList = myAds1.map((myAdsData_vb) =>
        FetchOwnerAdsViewModel_cl(fetchOwnerAdsContent_vb: myAdsData_vb)).toList();
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

}

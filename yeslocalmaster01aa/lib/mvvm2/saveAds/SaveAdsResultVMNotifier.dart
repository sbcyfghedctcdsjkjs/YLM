import 'package:flutter/material.dart';
import 'package:yeslocalmarket01aa/mvvm2/modelDTO/userInfo.dart';
import 'package:yeslocalmarket01aa/mvvm2/saveAds/SaveAdsWebService.dart';
import 'SaveAdsResult.dart';

enum SaveAdsResultLoadingStatus_cl {
  completed_vb,
  searching_vb,

  empty_vb,
}

class SaveAdsResultVMNotifier_cl with ChangeNotifier {
  SaveAdsResultLoadingStatus_cl loadingStatusTemp_vb = SaveAdsResultLoadingStatus_cl.searching_vb;
  SaveAdsResult_cl saveAdsResult_vb=SaveAdsResult_cl();

   saveLikedAds_mt(String likedAdsIds_vb,UserInfo_cl userInfo_vb) async {
    SaveAdsResult_cl saveLikes  = await SaveAdsWebService_cl().saveLikedAds_mt(likedAdsIds_vb,
                                                            userInfo_vb.getIdR_mt.toString(),
                                                            userInfo_vb.getIdOfLikedAds_mt);

    this.saveAdsResult_vb=saveLikes;
    notifyListeners();
    if (saveAdsResult_vb==null) {
      this.loadingStatusTemp_vb = SaveAdsResultLoadingStatus_cl.empty_vb;
    } else {
      this.loadingStatusTemp_vb = SaveAdsResultLoadingStatus_cl.completed_vb;
    }

    notifyListeners();
    return saveLikes;
  }
}
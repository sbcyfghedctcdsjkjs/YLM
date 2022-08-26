import 'package:dio/dio.dart';
import 'package:yeslocalmarket01aa/mvvm2/utils/constants.dart';

import 'SaveAdsResult.dart';

class SaveAdsWebService_cl {

  var dio_vb = new Dio();

  Future<SaveAdsResult_cl> saveLikedAds_mt(String likedAdsId_vb,String userId_vb,String idOfLikedAds_vb) async {

    print("saveLikedAds_mt  >> p3="+ userId_vb+" ,p2="+likedAdsId_vb+" ,p1="+(idOfLikedAds_vb==null ? "": idOfLikedAds_vb.toString()));

    final response_vb = await dio_vb.post(Constants_cl.saveLikedAdsTestUrl_mt(),data: {
      "p2": "$likedAdsId_vb",
      "p3": "$userId_vb",
      "p1": idOfLikedAds_vb==null ? "": idOfLikedAds_vb.toString(),
    });




    if (response_vb.statusCode == 200) {
      final result_vb = response_vb.data;
      return SaveAdsResult_cl.fromJson_mt(result_vb);
    } else {
      throw Exception("Failled to get ads for the near by region");
    }

  }

}



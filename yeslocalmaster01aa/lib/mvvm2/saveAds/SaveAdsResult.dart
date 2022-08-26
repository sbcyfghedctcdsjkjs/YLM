import 'dart:collection';

class SaveAdsResult_cl {
  String done_vb;
  String likedAdsId_vb="";
  final String idOfLikedAds_vb;

  SaveAdsResult_cl({ this.done_vb,this.likedAdsId_vb, this.idOfLikedAds_vb});

  factory SaveAdsResult_cl.fromJsonList_mt(List<dynamic> json_vb) {
    return SaveAdsResult_cl(
      done_vb: json_vb[0]['p3'],
      likedAdsId_vb: json_vb[0]['p2'],
      idOfLikedAds_vb: json_vb[0]['p1'],
    );
  }

  factory SaveAdsResult_cl.fromJson_mt(Map<String, dynamic> json_vb) {
    return SaveAdsResult_cl(
      done_vb: json_vb['p3'],
      likedAdsId_vb: json_vb['p2'],
      idOfLikedAds_vb: json_vb['p1'],
    );
  }

}


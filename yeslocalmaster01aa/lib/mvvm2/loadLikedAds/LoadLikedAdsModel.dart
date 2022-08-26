import 'dart:collection';

class LoadLikedAdsModel_cl {
  final String ownerPhone;
  final String ownerEmail;
  final String secretNumber;
  final String contentDesc;
  final int adType;
  final String adId;
  final String status;
  final int adDisplayType;
  final String createdDate;
  bool likedIt;
  final String generatedFileName;
  final int pageNum;
  String likedAdsId;
  String likedAdsIdWithLogin;
  final int adViewerId;
   int idOfLikedAds;

  LoadLikedAdsModel_cl(
      { this.ownerPhone,this.ownerEmail,this.secretNumber,
        this.contentDesc,this.adType,this.status,this.adDisplayType,
        this.createdDate,this.adId,this.likedIt,this.generatedFileName,this.pageNum,
        this.likedAdsId,this.adViewerId,this.idOfLikedAds});


  factory LoadLikedAdsModel_cl.fromJsonHashMap(HashMap<String, dynamic> json) {

    return LoadLikedAdsModel_cl(
      ownerPhone: json['ownerPhone'],
      ownerEmail: json['ownerEmail'],
      secretNumber: json['secretNumber'],
      contentDesc: json['contentDesc'],
      adType: 1,
      status: 'Y',
      adDisplayType: 1,
      createdDate: json['createdOn'],
      adId: '1',
      likedIt:false,
      generatedFileName: json['generatedFileName'],
      pageNum: json['pageNum'],
      likedAdsId: json['likedAdsId'] == null ? "":json['likedAdsId'],
      adViewerId: json['adViewerId'],
      idOfLikedAds: json['idOfLikedAds'],

    );
  }



    factory LoadLikedAdsModel_cl.fromJsonList(List<dynamic> json) {

    return LoadLikedAdsModel_cl(
      ownerPhone: json[0]['ownerPhone'],
      ownerEmail: json[0]['ownerEmail'],
      secretNumber: json[0]['secretNumber'],
      contentDesc: json[0]['contentDesc'],
      adType: 1,
      status: 'Y',
      adDisplayType: 1,
      createdDate: json[0]['createdOn'],
      adId: '1',
      likedIt:false,
      generatedFileName: json[0]['generatedFileName'],
      pageNum: json[0]['pageNum'],
    );
  }

  factory LoadLikedAdsModel_cl.fromJson(Map<String, dynamic> json) {

    return LoadLikedAdsModel_cl(
      ownerPhone: json['ownerPhone'],
      adId: json['id'].toString(),
      adDisplayType: json['adDisplayType'],
      adType: json['adType'],
      createdDate: json['createdOn'],
      contentDesc: json['contentDesc'],
      likedIt:false,
      generatedFileName: json['generatedFileName'],
      pageNum: json['pageNum'],
      adViewerId: json['adViewerId'],
      idOfLikedAds: json['idOfLikedAds'],
      likedAdsId: json['likedAdsId'] == null ? "":json['likedAdsId'],

    );
  }


  void set setIdOfLikedAds(int id){
    idOfLikedAds = id;
  }
//  factory MyAdContentTemp.fromJson(Map<String, dynamic> json) {
//
//    return MyAdContentTemp(
//      ownerPhone: json['ownerPhone'],
//      adId: json['id'].toString(),
//      adDisplayType: json['adDisplayType'].toString(),
//      adType: json['adType'].toString(),
//      createdDate: json['createdOn'],
//      contentDesc: json['contentDesc'],
//      likedIt:false,
//      generatedFileName: json['generatedFileName'],
//      pageNum: json['pageNum'],
//      likedAdsId: json['likedAdsId'],
//    );
//  }
}


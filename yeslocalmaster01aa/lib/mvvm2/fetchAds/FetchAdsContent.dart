class FetchAdsContent_cl {
  final String ownerPhone_vb;
  final String ownerEmail_vb;
  final String secretNumber_vb;
  final String contentDesc_vb;
  final String adType_vb;
  final String adId_vb;
  final String status_vb;
  final String adDisplayType_vb;
  final String createdDate_vb;
  bool likedIt_vb;
  final String generatedFileName_vb;
  final int pageNum_vb;


  FetchAdsContent_cl(
      { this.ownerPhone_vb,
        this.ownerEmail_vb,
        this.secretNumber_vb,
        this.contentDesc_vb,
        this.adType_vb,
        this.status_vb,
        this.adDisplayType_vb,
        this.createdDate_vb,this.adId_vb,this.likedIt_vb,this.generatedFileName_vb,this.pageNum_vb});

  factory FetchAdsContent_cl.fromJson_mt(Map<String, dynamic> json_vb) {
    //ownerPhone_vb: json_vb['ownerPhone'],
    //generatedFileName_vb: json_vb['generatedFileName'],
    return FetchAdsContent_cl(

      adId_vb: json_vb['p1'],
      createdDate_vb: json_vb['p2'],
      contentDesc_vb: json_vb['p3'],
      adDisplayType_vb: json_vb['p4'],
      pageNum_vb: json_vb['p5'],
      adType_vb: json_vb['p7'].toString(),
      likedIt_vb:false,
    );
  }

  factory FetchAdsContent_cl.fromJson2_mt(Map<String, dynamic> json_vb) {
    //ownerPhone_vb: json_vb['ownerPhone'],
    //generatedFileName_vb: json_vb['generatedFileName'],
    return FetchAdsContent_cl(

      adId_vb: json_vb['p1'],
      contentDesc_vb: json_vb['p2'],
      status_vb: json_vb['p3'],
      createdDate_vb: json_vb['p4'],
      adType_vb: json_vb['p5'],
      pageNum_vb:1,
      adDisplayType_vb: json_vb['p7'].toString(),
      likedIt_vb:false,
    );
  }
}


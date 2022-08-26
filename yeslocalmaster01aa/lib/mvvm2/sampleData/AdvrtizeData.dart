import 'package:yeslocalmarket01aa/mvvm2/fetchAds/FetchAdsContent.dart';

class AdvertizeData_cl {
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


  AdvertizeData_cl(
      { this.ownerPhone_vb,
        this.ownerEmail_vb,
        this.secretNumber_vb,
        this.contentDesc_vb,
        this.adType_vb,
        this.status_vb,
        this.adDisplayType_vb,
        this.createdDate_vb,this.adId_vb,this.likedIt_vb,this.generatedFileName_vb,this.pageNum_vb});

   List<FetchAdsContent_cl> createData() {
    //ownerPhone_vb: json_vb['ownerPhone'],
    //generatedFileName_vb: json_vb['generatedFileName'],
     FetchAdsContent_cl f1 =FetchAdsContent_cl(
      adId_vb: 'jqhdgjqhjq',
      createdDate_vb: '23645273564',
      contentDesc_vb: 'dog 1',
      adDisplayType_vb: '1',
      pageNum_vb: 1,
      adType_vb: 1.toString(),
      likedIt_vb:false,
    );
     FetchAdsContent_cl f2 =FetchAdsContent_cl(
       adId_vb: 'gjrnmddkjnv',
       createdDate_vb: '3452345345',
       contentDesc_vb: 'dog 2',
       adDisplayType_vb: '1',
       pageNum_vb: 1,
       adType_vb: 1.toString(),
       likedIt_vb:false,
     );

     return [f1,f2].toList();
  }
}
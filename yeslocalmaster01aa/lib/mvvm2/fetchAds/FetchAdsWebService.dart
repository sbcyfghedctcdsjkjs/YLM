import 'package:dio/dio.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAds/FetchAdsContent.dart';
import 'package:yeslocalmarket01aa/mvvm2/sampleData/AdvrtizeData.dart';
import 'package:yeslocalmarket01aa/mvvm2/utils/constants.dart';

class FetchAdsWebService_cl {
  var dio_vb = new Dio();

//  Future<List<FetchAdsContent>> fectchAdsCount() async {
//
//    final response = await dio.post(Constants.addressMatchCountUrl(),data: {
//      "ownerPhone": "2",
//      "ownerEmail": "",
//      "secretNumber": "3"
//    });
//
//    print("fectchAdsCount NON TEMP this is done 2");
//    if (response.statusCode == 200) {
//      final result = response.data;
//      Iterable list = result;
//
//      return list.map((result) => FetchAdsContent.fromJson(result)).toList();
//    } else {
//      throw Exception("Failled to get ads for the near by region");
//    }
//  }

  Future<List<FetchAdsContent_cl>> fectchAdsInPagesByPageNum_mt_data(int pageNum_vb,String locationSearch_vb
      ,String adType,String filters) async {

    print("fectchAdsInPagesByPageNum non temp 1");
    return await AdvertizeData_cl().createData();
  }

    Future<List<FetchAdsContent_cl>> fectchAdsInPagesByPageNum_mt(int pageNum_vb,String locationSearch_vb
                                                  ,String adType,String filters) async {
    print("fectchAdsInPagesByPageNum non temp 1");

    final response_vb = await dio_vb.post(Constants_cl.adsInPagesUrl_mt(),data: {
      "p1": "$pageNum_vb",
      "p2": "$locationSearch_vb",
      "p3": "$filters",
      "p4": "$adType",
    });
    print("fectchAdsInPagesByPageNum non temp 2");
    if (response_vb.statusCode == 200) {
      final result_vb = response_vb.data;
      Iterable list = result_vb;

      return list.map((result_vb) => FetchAdsContent_cl.fromJson_mt(result_vb)).toList();
    } else {
      throw Exception("Failled to get ads for the near by region");
    }
  }

  Future<List<FetchAdsContent_cl>> fectchOwnerHisOwnAds_mt(String id_vb) async {
    print("fectchAdsInPagesByPageNum non temp 1");

    final response_vb = await dio_vb.post(Constants_cl.ownerGetHisOwnAds_mt(),data: {
      "p1": "$id_vb"
    });
    if (response_vb.statusCode == 200) {

      final result_vb = response_vb.data;
      Iterable list = result_vb;
      return list.map((result_vb) => FetchAdsContent_cl.fromJson2_mt(result_vb)).toList();
    } else {
      throw Exception("Failled to get ads for the near by region");

    }
  }

//  Future<List<FetchAdsContent>> fectchAdsInPagesByPageNumWithApiKey(int pageNum,String locationSearch, String apiKey) async {
//    print("fectchAdsInPagesByPageNumWithApiKey non temp 1 apiKey: "+apiKey);
//    //Constants.API_KEY=apiKey;
//    final response = await dio.post(Constants.adsInPagesUrl(),data: {
//      "pageNum": "$pageNum",
//      "addressSearch": "$locationSearch",
//    });
//    print("fectchAdsInPagesByPageNum non temp 2");
//    if (response.statusCode == 200) {
//      final result = response.data;
//      Iterable list = result;
//
//      return list.map((result) => FetchAdsContent.fromJson(result)).toList();
//    } else {
//
//      throw Exception("Failled to get ads for the near by region");
//    }
//  }

}



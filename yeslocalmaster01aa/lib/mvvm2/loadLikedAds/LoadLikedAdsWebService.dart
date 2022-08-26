import 'package:dio/dio.dart';
import 'package:yeslocalmarket01aa/mvvm2/loadLikedAds/LoadLikedAdsModel.dart';
//import 'package:yeslocalmarket01aa/mvvm2/temp/appUser.dart';
import 'package:yeslocalmarket01aa/mvvm2/utils/constants.dart';

class LoadLikedAdsWebService_cl {
  var dio_vb = new Dio();


//  Future<LoadLikedAdsModel> loadLikedAds(String userId) async {
//
//    // String url = Constants.TOP_TEN_ADS_URL;
//    print("WebServiceTemp loadLikedAds   1");
//    //final response = await dio.get(url);
//
//    final response = await dio.post(Constants.getLikedAdsTestUrl(),data: {
//      //"idOfLikedAds": "1",
//      "adViewerId": "$userId"
//    });
//
//
//    if (response.statusCode == 200) {
//      final result = response.data;
//      //Iterable list = result;
//      print("WebServiceTemp loadLikedAds  2 result: $result");
//      return LoadLikedAdsModel.fromJson(result);//list.map((result) => MyAdContentTemp.fromJson(result)).toList();
//    } else {
//      throw Exception("Failled to get ads for the near by region");
//    }
//  }

//
//  Future<MyAdContentTemp> test1() async {
//
//    // String url = Constants.TOP_TEN_ADS_URL;
//    print("temp test  1");
//    //final response = await dio.get(url);
//
//    final response = await dio.post(Constants.getTestUrl(),data: {
//      "pageNum": "1",
//      "addressSearch": "Noida"
//    });
//
//
//    if (response.statusCode == 200) {
//      final result = response.data;
//      //Iterable list = result;
//      print("temp test 2 result: $result");
//      return MyAdContentTemp.fromJson(result);//list.map((result) => MyAdContentTemp.fromJson(result)).toList();
//    } else {
//      throw Exception("Failled to get ads for the near by region");
//    }
//  }
//
//  Future<List<MyAdContentTemp>> test3() async {
//
//    // String url = Constants.TOP_TEN_ADS_URL;
//    print("temp test  1");
//    //final response = await dio.get(url);
//
//    final response = await dio.post(Constants.getTestUrl(),data: {
//      "pageNum": "1",
//      "addressSearch": "Noida"
//    });
//
//    print("temp test 2");
//    if (response.statusCode == 200) {
//      final result = response.data;
//      Iterable list = result;
//
//      return list.map((result) => MyAdContentTemp.fromJson(result)).toList();
//    } else {
//      throw Exception("Failled to get ads for the near by region");
//    }
//  }
//
//  Future<List<MyAdContentTemp>> fectchAdsInPagesByPageNum(int pageNum) async {
//
//    // String url = Constants.TOP_TEN_ADS_URL;
//    print("fectchAdsInPagesByPageNum 1");
//    //final response = await dio.get(url);
//
//
//    final response = await dio.post(Constants.adsInPagesUrl(),data: {
//      "pageNum": "$pageNum",
//      "addressSearch": "Noida"
//    });
//    print("this is done 2");
//    if (response.statusCode == 200) {
//      final result = response.data;
//      Iterable list = result;
//
//      return list.map((result) => MyAdContentTemp.fromJson(result)).toList();
//    } else {
//      throw Exception("Failled to get ads for the near by region");
//    }
//  }

//  Future<List<MyAdContentTemp>> fectchAdsCount() async {
//
//   // String url = Constants.TOP_TEN_ADS_URL;
//    print("this is done 1");
//    //final response = await dio.get(url);
//
//    final response = await dio.post(Constants.addressMatchCountUrl(),data: {
//      "ownerPhone": "2",
//      "ownerEmail": "",
//      "secretNumber": "3"
//    });
//
//    print("this is done 2");
//    if (response.statusCode == 200) {
//      final result = response.data;
//      Iterable list = result;
//
//      return list.map((result) => MyAdContentTemp.fromJson(result)).toList();
//    } else {
//      throw Exception("Failled to get ads for the near by region");
//    }
//  }



//  Future<AppUser> fectchLikedAdsByUser(int id) async {
//
//    final response = await dio.post(Constants.getAllLikedAdsUrl(),data: {
//      "id": "$id"
//    });
//    if (response.statusCode == 200) {
//      final result = response.data;
//      print("response.data: "+response.data);
//  //    return AppUser.fromJson(result);
//    } else {
//      throw Exception("Failled to get liked ads");
//    }
//  }
//
//  Future<AppUser> fectchLikedAdsByUser1(int id) async {
//    final response = await dio.post(Constants.getAllLikedAdsUrl(),data: {
//      "id": "$id"
//    });
//    if (response.statusCode == 200) {
//      final result = response.data;
//      return AppUser.fromJson(result);
//    } else {
//      throw Exception("Failled to get liked ads");
//    }
//  }



//  Future<List<MyAdContent>> fectchAdsByRegionPost(String regionAddress) async {
//    final response = await dio.post(Constants.getAdsListUrl(regionAddress),data: {
//      "ownerPhone": "2",
//      "ownerEmail": "",
//      "secretNumber": "3"
//    });
//
//    if (response.statusCode == 200) {
//      final result = response.data;
//      Iterable list = result['articles'];
//      return list.map((result) => MyAdContent.fromJson(result)).toList();
//    } else {
//      throw Exception("Failled to get ads for the region");
//    }
//  }
//
//  Future<List<MyAdContent>> fectchAdsByRegion(String regionAddress) async {
//    //final response = await dio.get(Constants.getAdsListUrl(regionAddress));
//    final response = await dio.post(Constants.getAdsListUrl(regionAddress),data: {
//      "ownerPhone": "2",
//      "ownerEmail": "",
//      "secretNumber": "3"
//    });
//    if (response.statusCode == 200) {
//      final result = response.data;
//      Iterable list = result;
//      return list.map((article) => MyAdContent.fromJson(article)).toList();
//    } else {
//      throw Exception("Failled to get ads for the region");
//    }
//  }
//
//  Future<List<MyAdContent>> fectchAdsOfNearByRegion() async {
//    String url = Constants.TOP_TEN_ADS_URL;
//    print("this is done 1");
//    //final response = await dio.get(url);
//    final response = await dio.post(Constants.getAdsListUrl(url),data: {
//      "ownerPhone": "2",
//      "ownerEmail": "",
//      "secretNumber": "3"
//    });
//
//    print("this is done 2");
//    if (response.statusCode == 200) {
//      final result = response.data;
//      Iterable list = result;
//
//      return list.map((result) => MyAdContent.fromJson(result)).toList();
//    } else {
//      throw Exception("Failled to get ads for the near by region");
//    }
//
//  }


}



import 'package:dio/dio.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAds/FetchAdsContent.dart';
import 'package:yeslocalmarket01aa/mvvm2/modelDTO/userInfo.dart';
import 'package:yeslocalmarket01aa/mvvm2/sampleData/LoginData.dart';
import 'package:yeslocalmarket01aa/mvvm2/utils/constants.dart';

class AuthWebService_cl {
  var dio_vb = new Dio();

  Future<UserInfo_cl> registerNewUser_mt(String ph_vb,String em_vb, String sn_vb) async {
    final response_vb = await dio_vb.post(Constants_cl.registerNewUserUrl_mt(),data: {
      "p1": "$ph_vb",
      "p2": "$em_vb",
      "p3": "$sn_vb"
    });

    if (response_vb.statusCode == 200) {
      final result = response_vb.data;
      //Iterable list = result;

      return UserInfo_cl.fromJson_mt(result);//list.map((result) => FetchAdsContent.fromJson(result)).toList();
    } else {
      throw Exception("Failled to register New User ");
    }
  }

  Future<UserInfo_cl> loginByPhone_mt_data(String ph_vb, String sn_vb) async {
    return await LoginData_cl().createUserInfoData();
  }

  Future<UserInfo_cl> loginByPhone_mt(String ph_vb, String sn_vb) async {
    final response = await dio_vb.post(Constants_cl.loginByPhoneUrl_mt(),data: {
      "p1": "$ph_vb",
      "p3": "$sn_vb"
    });

    if (response.statusCode == 200) {
      final result = response.data;
      //Iterable list = result;
      return UserInfo_cl.fromJson_mt(result);//list.map((result) => FetchAdsContent.fromJson(result)).toList();
    } else {
      throw Exception("Failled to register New User ");
    }
  }


  Future<UserInfo_cl> loginByEmail_mt(String em_vb, String sn_vb) async {

    final response_vb = await dio_vb.post(Constants_cl.loginByEmailUrl_mt(),data: {
      "p2": "$em_vb",
      "p3": "$sn_vb"
    });

    if (response_vb.statusCode == 200) {
      final result_vb = response_vb.data;
      //Iterable list = result;

      return UserInfo_cl.fromJson_mt(result_vb);//list.map((result) => FetchAdsContent.fromJson(result)).toList();
    } else {
      throw Exception("Failled to register New User ");
    }
  }
}


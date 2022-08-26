import 'dart:io';

import 'package:dio/dio.dart';
import 'package:yeslocalmarket01aa/mvvm2/apikey/ApiKeyModel.dart';
import 'package:yeslocalmarket01aa/mvvm2/utils/constants.dart';

class ApiKeyWebService_cl {
  var dio_vb = new Dio();

  Future<ApiKeyModel_cl> getApiKey_mt2() async {
    print("call ApiKeyWebService_cl.getApiKeyURL_mt() ");
    final response_vb = await dio_vb.post(Constants_cl.getApiKeyURL_mt(),data: {

      //"ownerPhone": "2"
    });

    print("getApiKey_mt() ");
    while(response_vb.statusCode != 200) {
      //sleep(const Duration(seconds: 1));
      //await Future.delayed(Duration(seconds: 1));
      print("Inside While loop response_vb.statusCode != 200 ");
    }
    if (response_vb.statusCode == 200) {
      final result_vb = response_vb.data;
      //Iterable list = result;


      return ApiKeyModel_cl.fromJson_mt(result_vb);
    } else {
      throw Exception("Failled to get ads for the near by region");
    }
  }

  ApiKeyModel_cl getApiKey_mt()  {
    ApiKeyModel_cl apiKeyModel_vb =new ApiKeyModel_cl();

    print("call ApiKeyWebService_cl.getApiKey_mt1() ");
    final response_vb =  dio_vb.post(Constants_cl.getApiKeyURL_mt(),data: {
      //"ownerPhone": "2"
    }).then((response_vb) =>{
        print("API key is success"),
      apiKeyModel_vb =ApiKeyModel_cl.fromJson_mt(response_vb.data)})
      .catchError((e)=>{
        print(e.toString())
      })
      .whenComplete(() => print("API key work is complete"));

    print("getApiKey_mt1() ");
  return apiKeyModel_vb;
  }




}



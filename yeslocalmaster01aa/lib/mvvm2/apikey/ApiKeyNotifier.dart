import 'package:flutter/material.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAds/FetchAdsContent.dart';
import 'package:yeslocalmarket01aa/mvvm2/apikey/ApiKeyWebService.dart';
import 'package:yeslocalmarket01aa/mvvm2/apikey/ApiKeyModel.dart';
import 'package:yeslocalmarket01aa/mvvm2/modelDTO/userInfo.dart';
import 'package:yeslocalmarket01aa/mvvm2/sampleData/ApikeyData.dart';

class ApiKeyNotifier_cl with ChangeNotifier {
  ApiKeyModel_cl apiKeyModel_vb = ApiKeyModel_cl();

  Future<void> getApiKey5_mt() async {
    print("ApiKeyNotifier_cl.getApiKey2() called................");
    ApiKeyModel_cl apiKeyTemp_vb;
    await ApiKeyWebService_cl().getApiKey_mt2().then((ApiKeyModel_cl apikeyModel_vb){
      apiKeyTemp_vb=apikeyModel_vb;
    });
    //print("waiting starts................");

//    notifyListeners();
    while(apiKeyModel_vb.apiKey_vb==null)
    {
      //sleep(const Duration(seconds:30));
     await Future.delayed(Duration(seconds:30));
    }

    //print("waiting End................"+apiKeyTemp.apiKey);
    apiKeyModel_vb=apiKeyTemp_vb;
    //return apiKeyModel_vb.apiKey_vb;
    //notifyListeners();
  }

  void getApiKey3_mt() async {
    print("ApiKeyNotifier_cl.getApiKey2() called................");
    ApiKeyModel_cl apiKeyTemp_vb = await ApiKeyWebService_cl().getApiKey_mt2();
    //print("waiting starts................");

//    notifyListeners();


    //print("waiting End................"+apiKeyTemp.apiKey);
    apiKeyModel_vb=apiKeyTemp_vb;
   // return apiKeyModel_vb.apiKey_vb;
    //notifyListeners();
  }

  Future<String> getApiKey2_mt_data() async {
    print("ApiKeyNotifier_cl.getApiKey2() called................");
    ApiKeyModel_cl apiKeyTemp_vb = await ApiKeyData_cl().getApikeyData();
    //print("waiting starts................");

//    notifyListeners();


    //print("waiting End................"+apiKeyTemp.apiKey);
    apiKeyModel_vb=apiKeyTemp_vb;
    return apiKeyModel_vb.apiKey_vb;
    //notifyListeners();
  }

  Future<String> getApiKey2_mt() async {
    print("ApiKeyNotifier_cl.getApiKey2() called................");
    ApiKeyModel_cl apiKeyTemp_vb = await ApiKeyWebService_cl().getApiKey_mt2();
    //print("waiting starts................");

//    notifyListeners();


    //print("waiting End................"+apiKeyTemp.apiKey);
    apiKeyModel_vb=apiKeyTemp_vb;
    return apiKeyModel_vb.apiKey_vb;
    //notifyListeners();
  }

  ApiKeyModel_cl getApiKey()  {
    print("ApiKeyNotifier_cl.getApiKey() called................");
    apiKeyModel_vb =  ApiKeyWebService_cl().getApiKey_mt();
    //print("waiting starts................");

//    notifyListeners();


    //print("waiting End................"+apiKeyTemp.apiKey);
    //apiKeyModel_vb=apiKeyTemp_vb;

    //notifyListeners();
  }

}

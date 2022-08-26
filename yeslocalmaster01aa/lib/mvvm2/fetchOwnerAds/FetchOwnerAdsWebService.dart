import 'package:dio/dio.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchOwnerAds/FetchOwnerAdsContent.dart';
import 'package:yeslocalmarket01aa/mvvm2/sampleData/AdvrtizeData.dart';
import 'package:yeslocalmarket01aa/mvvm2/utils/constants.dart';

class FetchOwnerAdsWebService_cl {
  var dio_vb = new Dio();

  Future<List<FetchOwnerAdsContent_cl>> fectchOwnerHisOwnAds_mt(String id_vb) async {
    print("fectchAdsInPagesByPageNum non temp 1");

    final response_vb = await dio_vb.post(Constants_cl.ownerGetHisOwnAds_mt(),data: {
      "p1": "$id_vb"
    });
    if (response_vb.statusCode == 200) {

      final result_vb = response_vb.data;
      Iterable list = result_vb;
      return list.map((result_vb) => FetchOwnerAdsContent_cl.fromJson_mt(result_vb)).toList();
    } else {
      throw Exception("Failled to get ads for the near by region");

    }
  }

}



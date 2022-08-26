import 'package:intl/intl.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchOwnerAds/FetchOwnerAdsContent.dart';

class FetchOwnerAdsViewModel_cl {
  FetchOwnerAdsContent_cl _fetchOwnerAdsContent_vb;

  FetchOwnerAdsViewModel_cl({FetchOwnerAdsContent_cl fetchOwnerAdsContent_vb}) : _fetchOwnerAdsContent_vb = fetchOwnerAdsContent_vb;

  String get ownerPhone_mt {
    return _fetchOwnerAdsContent_vb.ownerPhone_vb;
  }

  String get ownerEmail_mt {
    return _fetchOwnerAdsContent_vb.ownerEmail_vb;
  }

  String get secretNumber_mt {
    return _fetchOwnerAdsContent_vb.secretNumber_vb;
  }

  String get adType_mt {
    return _fetchOwnerAdsContent_vb.adType_vb;
  }

  String get status_mt {
    return _fetchOwnerAdsContent_vb.status_vb;
  }

  String get contentDesc_mt {
    return _fetchOwnerAdsContent_vb.contentDesc_vb;
  }

  String get adDisplayType_mt {
    return _fetchOwnerAdsContent_vb.adDisplayType_vb;
  }

  String get adId_mt {
    return _fetchOwnerAdsContent_vb.adId_vb;
  }

  String get createdDate_mt {
    return _fetchOwnerAdsContent_vb.createdDate_vb;
  }

  String get publishedAt_mt {
        //final dateTime = DateFormat('yyyy-MM-ddTHH:mm:ssZ').parse(_myADContent.createdDate, false);
        //return  DateFormat('yyyy-MM-ddTHH:mm').parse(DateTime.fromMillisecondsSinceEpoch(int.parse(_myADContent.createdDate)).toString(),false).toString();
        return DateTime.fromMillisecondsSinceEpoch(int.parse(_fetchOwnerAdsContent_vb.createdDate_vb)).toString();

//    return DateFormat.yMMMMEEEEd('en-us').format(dateTime).toString();
  }

  void set likedIt_mt(bool v) {
    _fetchOwnerAdsContent_vb.likedIt_vb=v;
  }

  bool get likedIt_mt {
    return _fetchOwnerAdsContent_vb.likedIt_vb;
  }

  int get pageNum_mt {
    return _fetchOwnerAdsContent_vb.pageNum_vb;
  }
}

/*

I/flutter ( 5334): <><><><><><><><><><><><><><><><><><><><><>CALLED 1
I/flutter ( 5334): this is done 1
I/flutter ( 5334): this is done 2
I/flutter ( 5334): Lenmght11  this.myAdsVMList: 6
I/flutter ( 5334): _AdsListInstaState calling initState() ***********************
I/flutter ( 5334): buttonFunction1 calling setState()--------------------
 */
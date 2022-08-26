import 'package:intl/intl.dart';
import 'package:yeslocalmarket01aa/mvvm2/loadLikedAds/LoadLikedAdsModel.dart';

class LoadLikedAdsViewModel_cl {
  LoadLikedAdsModel_cl _myADContentTemp_vb;

  LoadLikedAdsViewModel_cl({LoadLikedAdsModel_cl loadLikedAds_vb}) : _myADContentTemp_vb = loadLikedAds_vb;

  String get ownerPhone {
    return _myADContentTemp_vb.ownerPhone;
  }

  String get ownerEmail {
    return _myADContentTemp_vb.ownerEmail;
  }

  String get secretNumber {
    return _myADContentTemp_vb.secretNumber;
  }

  int get adType {
    return _myADContentTemp_vb.adType;
  }

  String get status {
    return _myADContentTemp_vb.status;
  }

  String get contentDesc {
    return _myADContentTemp_vb.contentDesc;
  }

  int get adDisplayType {
    return _myADContentTemp_vb.adDisplayType;
  }

  String get adId {
    return _myADContentTemp_vb.adId;
  }

  String get createdDate {
    return _myADContentTemp_vb.createdDate;
  }

  String get publishedAt {
        //final dateTime = DateFormat('yyyy-MM-ddTHH:mm:ssZ').parse(_myADContentTemp_vb.createdDate, false);
        //return  DateFormat('yyyy-MM-ddTHH:mm').parse(DateTime.fromMillisecondsSinceEpoch(int.parse(_myADContentTemp_vb.createdDate)).toString(),false).toString();
        return DateTime.fromMillisecondsSinceEpoch(int.parse(_myADContentTemp_vb.createdDate)).toString();

//    return DateFormat.yMMMMEEEEd('en-us').format(dateTime).toString();
  }

  void set likedIt(bool v) {
    _myADContentTemp_vb.likedIt=v;
  }

  bool get likedIt {
    return _myADContentTemp_vb.likedIt;
  }

  int get pageNum {
    return _myADContentTemp_vb.pageNum;
  }

  String get likedAdsId {
    return _myADContentTemp_vb.likedAdsId;
  }

  void set likedAdsId(String s) {
     _myADContentTemp_vb.likedAdsId=s;
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
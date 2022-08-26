import 'package:yeslocalmarket01aa/mvvm2/modelDTO/userInfo.dart';

class LoginData_cl {
  String locationSearch_vb;
  static int pageNum_vb;
  static bool searchStarted_vb = false;
  static bool noResultFound_vb = false;
  static String id_vb;
  String userId_vb;
  String phone_vb;
  String email_vb;
  String secretNumber_vb;
  static String likedAdsAtOnLoad_vb = "";
  static String categoryByDurationIdList_vb;
  static String categoryByTypeIdList_vb;
  static String idOfLikedAds_vb;
  static String apiKey_vb;

  LoginData_cl(
      { this.locationSearch_vb, this.userId_vb, this.phone_vb, this.email_vb, this.secretNumber_vb});

  UserInfo_cl createUserInfoData() {
    id_vb = 'kjasbdkhofiwewe';
    likedAdsAtOnLoad_vb = 'efoiwejfojeorffer,qweojowiqjeriojwqer';
    idOfLikedAds_vb = 'wefklwejrgioe';
    return UserInfo_cl(
      phone_vb: '1122',
      email_vb: 'qweq@wedwe.com',
      secretNumber_vb: '100',
      userId_vb: 'wdwqefqwefqwefw',

    );
  }

}
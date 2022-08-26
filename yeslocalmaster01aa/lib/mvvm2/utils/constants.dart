class Constants_cl {
  static String API_KEY = '';
  static const String baseUrl_emulator = "http://10.0.2.2:8020/ba";
  static const String baseUrl_NOT_WORKING = "http://127.0.0.1:8020/ba";
  static const String baseUrl_NOT_WORKING_2 = "http://192.168.42.158:8020/ba";
  static const String baseUrl = "https://wed2vvssbk2h2mm2mbvhabsksljw2ns83h872w6jhwd152.shosayty.com/ba";
  static const String imageUri="/wuiebpd23i2SD3be226kwjbedwedhwe";
  static const String imageIconUri="/K2312536132fc2eqwd7845lkgdkvdf0skl";
  static const String ads_in_pages_uri = "/wqedw2FRT3dndi33io4jirU3jr3ojw621223nn";

  static const String adViewerLikedIt_save_uri = "/231guRbjhbdbcsncklnsioe83jY4dbsak";
  static const String registerNewUserUri = "/qJKSWQ23wpoejfd45kgde02ds213NsdDfrg4D";
  static const String loginByPhoneUri = "/3467d6712FGgjsdad78d1gwqFGHdas87FG1j2HJsvFGvasxk";
  static const String loginByEmailUri = "/swchbqw623vvjha6712vvaj67x21kfFls2te"; //Done
  static const String getApiKeyUri = "/sJWk4jFd23cskhw6iqu1d8Q2wetgFuy343qwSd71rt23feq671";//Done
  static const slash="/";
  static const String fetchCategoryUri = "/aMEsTRHvTYd213YUJen23dRT3nRTruRT48bfTR56gT45nTHiTYgJ8Uw3wifq283f";
  static const String ownerGetHisOwnAdsUri = "/Bkjedkfjsoiwenbs232DF4ishd62FDH45652uvds5SD62Klvdas56ytcETGd";
//  static const String address_match_count_uri = "/wjw1uc834d23qcDoHnSmwp43W22856jndfkwsw21346ns";//Not in use
//  static const String retrieve_test_uri = "/kfd90834h38WqVdftyJ628373DWKQW234L3gq";//Not in use
//  static const String adViewerLikedIt_load_uri = "/2di2u372Dbb278dkwlenwiueqapq";//Not in use
//  static const String user_validatebyPhone_uri = "/3467d6712FGgjsdad78d1gwqFGHdas87FG1j2HJsvFGvasxk";//Not in use
//
//
//  static const String user_validatebyEmail_uri = "/swchbqw623vvjha6712vvaj67x21kfFls2te";//Not in use
//  static const String user_list_of_like_ads_uri = "/43dfer23Ferqoei23445Hw7d45h38650ed";//Not in use
//  static const String fetchAdsList = "/25n3asgdywhbwGFFed2Fe4lFwnwieuFTGFxbcuewb";//Not in use


/*  static const String fetchAdsList = "/retrieve/adsList";
  static const String imageUri="/imageshow/image/show/";

  static const String address_match_count_uri = "/ta/address/match/count";
  static const String ads_in_pages_uri = "/retrieve/adsListInPages";
  static const String retrieve_test_uri = "/retrieve/test";
  static const String adViewerLikedIt_load_uri = "/adViewerLikedIt/loadLikedAds";

  static const String adViewerLikedIt_save_uri = "/adViewerLikedIt/saveAdsLiked";

  static const String user_validatebyPhone_uri = "/adViewer/validateUserPhone";
  static const String user_validatebyEmail_uri = "/adViewer/validateUserEmail";

  static const String user_list_of_like_ads_uri = "/adViewerLikedIt/likedAdsList";

  static const String registerNewUserUri = "/adViewer/registerNewUser";

  static const String loginByPhoneUri = "/adViewer/validateUserPhone";
  static const String loginByEmailUri = "/adViewer/validateUserEmail";
  static const String getApiKey = "/apikey/mobileGenerateNewKey";
*/
  static String getApiKeyURL_mt(){
    String url=baseUrl+getApiKeyUri+slash+API_KEY;
    return url;
  }
  static String loginByPhoneUrl_mt(){
    String url=baseUrl+loginByPhoneUri+slash+API_KEY;
    return url;
  }

  static String loginByEmailUrl_mt(){
    String url=baseUrl+loginByEmailUri+slash+API_KEY;
    return url;
  }

  static String registerNewUserUrl_mt(){
    String url=baseUrl+registerNewUserUri+slash+API_KEY;
    return url;
  }

  static String saveLikedAdsTestUrl_mt() {
    String url=baseUrl+adViewerLikedIt_save_uri+slash+API_KEY;
    return url;
  }


  static String getAdImageIconUrl_mt(String id_vb) {
    String url=baseUrl+imageIconUri+slash+API_KEY+slash+id_vb;
    return url;
  }



  static String getAdImageUrl_mt(String id_vb) {
    String url=baseUrl+imageUri+slash+API_KEY+slash+id_vb;
    return url;
  }

  static String getAllCategory_mt(){
    String url=baseUrl+fetchCategoryUri+slash+API_KEY;
    return url;
  }

  static String adsInPagesUrl_mt() {
    API_KEY==null ? print("APIKEY is null") : print('API_KEY: not null ');
    String url=baseUrl+ads_in_pages_uri+slash+API_KEY;
    return url;
  }



  static String ownerGetHisOwnAds_mt(){
    String url=baseUrl+ownerGetHisOwnAdsUri+slash+API_KEY;
    return url;
  }

//  static String getAllLikedAdsUrl() { // not in use
//    String url=baseUrl+user_list_of_like_ads_uri+"/"+API_KEY;
//    return url;
//  }
//
//
//  static String addressMatchCountUrl() { // Not in use
//    String url=baseUrl+address_match_count_uri+"/"+API_KEY;
//    return url;
//  }
//
//  static String getAdsListUrl(String regionAddress) {//Not in use
//    String url=baseUrl+fetchAdsList+"/"+API_KEY;
//    return url;
//  }
//
//  static String validatebyPhoneUrl() { //Not in use
//    String url=baseUrl+user_validatebyPhone_uri+"/"+API_KEY;
//    return url;
//  }
//
//  static String validatebyEmailUrl() { //Not in use
//    String url=baseUrl+user_validatebyEmail_uri+"/"+API_KEY;
//    return url;
//  }
//
//  static String getLikedAdsTestUrl() {  // Not in use
//    String url=baseUrl+adViewerLikedIt_load_uri+"/"+API_KEY;
//    return url;
//  }
//
//  static String getTestUrl() { // Not in use
//    String url=baseUrl+retrieve_test_uri+"/"+API_KEY;
//    return url;
//  }



}
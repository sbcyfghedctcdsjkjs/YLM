import 'dart:async';
import 'dart:io';

import 'package:flutter/material.dart';
import 'package:yeslocalmarket01aa/mvvm2/apikey/ApiKeyNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/customIcons/like_icon_below_ad.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAds/FetchAdsNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAdsCategory/FetchAdsCategoryNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/saveAds/SaveAdsResultVMNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/utils/constants.dart';

import 'package:yeslocalmarket01aa/mvvm2/widgets/AdsMenuDrawer.dart';
import 'package:yeslocalmarket01aa/mvvm2/widgets/RectangleImage.dart';
import 'package:yeslocalmarket01aa/mvvm2/modelDTO/userInfo.dart';
import 'package:provider/provider.dart';
import 'package:intl/intl.dart';
import 'package:yeslocalmarket01aa/intl15/MyAdsLocalization.dart';

class JointAdsGridListScreenSliver3_cl extends StatefulWidget {
  @override
  _AdsScreenState_cl createState() => _AdsScreenState_cl();
}

class _AdsScreenState_cl extends State<JointAdsGridListScreenSliver3_cl> {
  UserInfo_cl userInfo_vb=UserInfo_cl();
  int pageNum_vb=1;//Page number at the time of loading
  TextEditingController _searchQueryController_vb = TextEditingController();
  Widget loginSwitchLogout_vb =null;
  var _controller_vb = ScrollController();

  final GlobalKey<ScaffoldState> _AppBarScaffoldKey_vb = new GlobalKey<ScaffoldState>();
  @override
  void initState() {
    super.initState();
    //Provider.of<ApiKeyNotifier_cl>(context, listen: false).getApiKey3_mt();
    new ApiKeyNotifier_cl().getApiKey5_mt();
    // new ApiKeyNotifier_cl().getApiKey2_mt().then((String apikey){
    //   setState(() {
    //    userInfo_vb.setApiKey_mt  = apikey;
    //   });
    // });
    while(userInfo_vb.getApiKey_mt==null)
    {
        sleep(const Duration(seconds:30));

    }
    //userInfo_vb.setApiKey_mt = ApiKeyNotifier_cl().getApiKey().apiKey_vb;


    //await Future.delayed(Duration(seconds: 5));
    print("<>_AdsScreenState<><><><><><><><><><><>CALLED 1");
    _searchQueryController_vb.text="noida"; // delete it --------------------------&&&&&&&&&&&&&***************

    String temp_vb="";
    print("_AdsScreenState 1 >> _searchQueryController.text: "+_searchQueryController_vb.text);
    temp_vb=_searchQueryController_vb.text;
    userInfo_vb.setLocationSearch_mt=temp_vb;
    print("Start Calling Timer JointAdsGridListScreenSliver initState");


      while(Provider.of<ApiKeyNotifier_cl>(context, listen: false).apiKeyModel_vb==null) {
       // Timer _time = new Timer(const Duration(seconds: 8), () {
          if(Provider
              .of<ApiKeyNotifier_cl>(context, listen: false)
              .apiKeyModel_vb != null) {
            userInfo_vb.setApiKey_mt = Provider
                .of<ApiKeyNotifier_cl>(context, listen: false)
                .apiKeyModel_vb
                .apiKey_vb;
            Constants_cl.API_KEY = Provider.of<ApiKeyNotifier_cl>(context, listen: false).apiKeyModel_vb.apiKey_vb;
          }
          int i=0;
        print("while loop waiting for APIKey ...."+(i++).toString());
        //});
      }

      Provider.of<FetchAdsCategoryNotifier_cl>(context, listen: false).fectchAllAdsCategory_mt();

      Provider.of<FetchAdsNotifier_cl>(context, listen: false).fectchAdsInPagesByPageNumOnLoad_mt(
                                                      pageNum_vb,userInfo_vb.getLocationSearch_mt,
                                                      userInfo_vb.getCategoryByDurationIdList_mt,

                                                      userInfo_vb.getCategoryByTypeIdList_mt);
      print("I am waiting in JointAdsGridListScreenSliver initState");

    //});
    //Provider.of<FetchAdsNotifier>(context, listen: false).fectchAdsInPagesByPageNumOnLoad(pageNum,userInfo.getLocationSearch);

    print("End Calling Timer JointAdsGridListScreenSliver initState");


    _controller_vb.addListener(() {
      if (_controller_vb.position.atEdge)
      {
        if(this.userInfo_vb.getIdOfLikedAds_mt==null){
          this.userInfo_vb.setIdOfLikedAds_mt=Provider.of<SaveAdsResultVMNotifier_cl>(context, listen: false).saveAdsResult_vb.idOfLikedAds_vb;
        }

        if (_controller_vb.position.pixels == 0) {
        }
        else{
          UserInfo_cl.searchStarted_vb=false;
          var vs_vb  = Provider.of<FetchAdsNotifier_cl>(context, listen: false);
          Provider.of<FetchAdsNotifier_cl>(context, listen: false)
              .fectchAdsInPagesByPageNum_mt(vs_vb.myAdsVMList_vb[vs_vb.myAdsVMList_vb.length-1].pageNum_mt+1,
              this.userInfo_vb.getLocationSearch_mt,
              userInfo_vb.getCategoryByDurationIdList_mt,
              userInfo_vb.getCategoryByTypeIdList_mt);
        }
      }
    });

    temp_vb=null;
    Timer _time11=  new Timer(const Duration(seconds: 5),(){ });
    userInfo_vb.setAdsCategoryVMList_mt(Provider.of<FetchAdsCategoryNotifier_cl>(context, listen: false).myAdsCategoryVMList_vb);
  }




  likeIconButtonFunction_mt(id_vb,index_vb)
  {
    if(userInfo_vb.getIdR_mt ==null) {

      final snackBar_vb = SnackBar(

          content: Text(
            labelsTextI10n_mt("ads_list_insta_loginRequired"),
            style: TextStyle(
              fontSize:  MediaQuery.of(context).size.height * 0.15*.20,
            ),
          )
      );
      // Find the Scaffold in the widget tree and use it to show a SnackBar.
      _AppBarScaffoldKey_vb.currentState.showSnackBar(snackBar_vb);
      //Scaffold.of(context).showSnackBar(snackBar);
      return;
    }

    String likedAds_vb=this.userInfo_vb.getLikedAdsAtOnLoad_mt;
    if(likedAds_vb == null)
    {
      likedAds_vb =",";
    }

    if(likedAds_vb.trim().length < 1){
      likedAds_vb =",";
    }
    if(likedAds_vb.contains(","+id_vb.toString()+",")) {
      likedAds_vb =likedAds_vb.replaceAll(","+id_vb.toString()+",",       ",");
    } else {
      likedAds_vb =likedAds_vb+id_vb.toString()+",";
    }
    this.userInfo_vb.setLikedAdsAtOnLoad_mt=likedAds_vb;
    setState(() { });
    //if(index_vb==2)
    {
      if(this.userInfo_vb.getIdOfLikedAds_mt.trim().length==0)
        this.userInfo_vb.setIdOfLikedAds_mt=Provider.of<SaveAdsResultVMNotifier_cl>(context, listen: false).saveAdsResult_vb.idOfLikedAds_vb;

      Provider.of<SaveAdsResultVMNotifier_cl>(context, listen: false).saveLikedAds_mt(likedAds_vb, this.userInfo_vb );
      String  idOfLikedAds_vb  =Provider.of<SaveAdsResultVMNotifier_cl>(context, listen: false).saveAdsResult_vb.idOfLikedAds_vb;

    }
  }


  performSearch_mt(){
    String loc_vb;
    UserInfo_cl.searchStarted_vb=true;
    UserInfo_cl.noResultFound_vb=false;
    userInfo_vb==null ? print("AdsGridListScreen 2 userInfo==null") : print("AdsGridListScreen 2 userInfo!=null");
    userInfo_vb==null ? print("AdsGridListScreen 21 userInfo==null") : print("AdsGridListScreen 21 userInfo!=null static pageNum"+UserInfo_cl.pageNum_vb.toString());
    loc_vb=_searchQueryController_vb.text;
    userInfo_vb.setLocationSearch_mt=loc_vb;
    //searchLoc=_searchQueryController.text;
    print("_AdsScreenState 2 >> performSearch_mt _searchQueryController.text / loc: "+loc_vb);
    Provider.of<FetchAdsNotifier_cl>(context, listen: false)
        .fectchAdsInPagesByPageNumOnSearchLoad_mt(pageNum_vb,userInfo_vb.getLocationSearch_mt,
                                                    userInfo_vb.getCategoryByDurationIdList_mt,
                                                    userInfo_vb.getCategoryByTypeIdList_mt);
    loc_vb=null;
    userInfo_vb==null ? print("AdsGridListScreen 3 userInfo==null") : print("AdsGridListScreen 3 userInfo!=null");

  }

  String labelsTextI10n_mt(String label_vb) {
    return Intl.message('',
      name: '$label_vb',
      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
  }



  @override
  Widget build(BuildContext context) {
    var vs_vb  = Provider.of<FetchAdsNotifier_cl>(context);
    var deviceSize_vb = MediaQuery.of(context).size;
    //final GlobalKey<ScaffoldState> _AppBarScaffoldKey = new GlobalKey<ScaffoldState>();
    //var vs1 = Provider.of<MyAdContentListViewModelTemp>(context);
    return Scaffold(
      backgroundColor: Colors.blue[50],
      key: _AppBarScaffoldKey_vb,
      body: CustomScrollView(
        controller: _controller_vb,
        physics: const BouncingScrollPhysics(),
        slivers: <Widget>[
          SliverAppBar(
            backgroundColor: Colors.blueAccent,
            title: TextField(
              controller: _searchQueryController_vb,
              cursorColor: Colors.white,
              cursorWidth: deviceSize_vb.width * 0.1*.03,
              showCursor: true,

              style: TextStyle(
                fontSize: deviceSize_vb.height * 0.15*.22,
                color: Colors.white,
              ),
              decoration: InputDecoration(
                suffix: IconButton(
                  icon: Icon(
                    Icons.search,
                    color: Colors.white,
                  ),
                  iconSize: deviceSize_vb.height * 0.15*.25,
                  onPressed: (){
                    FocusScope.of(context).unfocus();
                    performSearch_mt();
                    return ;
                  },
                ),
                hintText: sampleAddressFormat,
              ),
//                  onEditingComplete: () { NOT Working
//                    SnackBar(
//
//                      content: Text("snack: "),
//                    );
//                  },
              onSubmitted: (str){
                FocusScope.of(context).unfocus();
                performSearch_mt();
                return ;
              },
            ),
//            actions: <Widget>[
//              TextField(
//
//                controller: _searchQueryController,
//                style: TextStyle(
//                  fontSize: deviceSize_vb.height * 0.15*.22,
//                ),
//
//                decoration: InputDecoration(
//                  hintText: "sampleAddressFormat",
//
//                ),
////                  onEditingComplete: () { NOT Working
////                    SnackBar(
////
////                      content: Text("snack: "),
////                    );
////                  },
//                onSubmitted: (str){
//                  FocusScope.of(context).unfocus();
//                  performSearch();
//                  return ;
//                },
//              ),
//              IconButton(
//                  icon: Icon(Icons.search),
//                  iconSize: deviceSize_vb.height * 0.15*.26,
//                  onPressed: () {
//                    FocusScope.of(context).unfocus();
//                    performSearch();
//                    UserInfo.noResultFound==true ?? showDialog(
//                      context: context,
//                      builder: (context) {
//                        return AlertDialog(
//                          // Retrieve the text the that user has entered by using the
//                          // TextEditingController.
//                          content: Text(noResFound+_searchQueryController.text),
//
//                        );
//                      },
//                    );
//                  }
//
//              ),
//            ],
            floating: true,
            snap: true,
            pinned: false,
            //stretch: true,

            onStretchTrigger: () {
              // Function callback for stretch
              return;
            },

            expandedHeight: deviceSize_vb.height * 0.15*.44,
//            flexibleSpace: FlexibleSpaceBar(
//              stretchModes: <StretchMode>[
//                StretchMode.zoomBackground,
//                StretchMode.blurBackground,
//                StretchMode.fadeTitle,
//              ],
//              centerTitle: true,
//              title: const Text('Ads Entering..'),
//              background: Stack(
//                fit: StackFit.expand,
//                children: [
//                  TextField(
//                    controller: _searchQueryController,
//                    style: TextStyle(
//                      fontSize: deviceSize_vb.height * 0.15*.22,
//                    ),
//
//                    decoration: InputDecoration(
//                      hintText: sampleAddressFormat,
//
//                    ),
////                  onEditingComplete: () { NOT Working
////                    SnackBar(
////
////                      content: Text("snack: "),
////                    );
////                  },
//                    onSubmitted: (str){
//                      FocusScope.of(context).unfocus();
//                      performSearch();
//                      return ;
//                    },
//                  ),
//                  IconButton(
//                      icon: Icon(Icons.search),
//                      iconSize: deviceSize_vb.height * 0.15*.26,
//                      onPressed: () {
//                        FocusScope.of(context).unfocus();
//                        performSearch();
//                        UserInfo.noResultFound==true ?? showDialog(
//                          context: context,
//                          builder: (context) {
//                            return AlertDialog(
//                              // Retrieve the text the that user has entered by using the
//                              // TextEditingController.
//                              content: Text(noResFound+_searchQueryController.text),
//
//                            );
//                          },
//                        );
//                      }
//
//                  ),
//                  Image.network(
//                    'https://flutter.github.io/assets-for-api-docs/assets/widgets/owl-2.jpg',
//                    fit: BoxFit.cover,
//                  ),
//                  const DecoratedBox(
//                    decoration: BoxDecoration(
//                      gradient: LinearGradient(
//                        begin: Alignment(0.0, 0.5),
//                        end: Alignment(0.0, 0.0),
//                        colors: <Color>[
//                          Color(0x62066000),
//                          Color(0x00000000),
//                        ],
//                      ),
//                    ),
//                  ),
//                ],
//              ),
//            ),
          ),
          _buildListErrorOrSliver_mt(vs_vb),

        ],
      ),
      drawer : AdsMenuDrawer_cl(userInfo_vb: this.userInfo_vb),


    );
  }

  Widget _buildListErrorOrSliver_mt(FetchAdsNotifier_cl adsListvm_vb) {
    switch (adsListvm_vb.loadingStatus_vb) {

      case LoadingStatus_cl.searching_vb:
        return
          SliverToBoxAdapter(child: CircularProgressIndicator(),);
      case LoadingStatus_cl.completed_vb:
        return _buildListSliver_mt();


      case LoadingStatus_cl.empty_vb:

      default:
        return SliverToBoxAdapter(
          child: Text("No results found"),
        );
    }
  }

  Widget _buildListSliver_mt() {
    var vs_vb  = Provider.of<FetchAdsNotifier_cl>(context);
    var deviceSize_vb = MediaQuery.of(context).size;
    return
      SliverList(
        delegate: SliverChildBuilderDelegate((BuildContext context, index) =>
            Container(
              child:  SafeArea(
                child:  Card(
                  elevation: 8,
                  borderOnForeground: true,
                  shadowColor: Colors.black,
                  //color: Colors.blueAccent,
                  margin: EdgeInsets.fromLTRB(0, 0, 0, 0),
                  child:  Column(
                      mainAxisAlignment: MainAxisAlignment.start,
                      mainAxisSize: MainAxisSize.min,
                      crossAxisAlignment: CrossAxisAlignment.stretch,
                      children: <Widget>[
                        Padding(
                          padding: const EdgeInsets.fromLTRB(16.0, 16.0, 8.0, 16.0),
                          child: Row(
                            mainAxisAlignment: MainAxisAlignment.spaceBetween,
                            children: <Widget>[
                              Row(
                                children: <Widget>[
                                  new Container(
                                    height: 40.0,
                                    width: 40.0,
                                    decoration: new BoxDecoration(
                                      shape: BoxShape.circle,
                                      image: new DecorationImage(  // Top Thumbnail image
                                          fit: BoxFit.fill,
                                          image: new NetworkImage(
                                              Constants_cl.getAdImageIconUrl_mt(
                                              vs_vb.myAdsVMList_vb[index].adId_mt),)
                                              //"http://10.0.2.2:8020/ba/imageshow/image/show/"+vs.myAdsVMList_vb[index].adId.toString())
                                      ),
                                    ),
                                  ),
                                  new SizedBox(
                                    width: 10.0,
                                  ),

                                ],
                              ),
                              new IconButton(
                                icon: Icon(Icons.more),
                                iconSize: deviceSize_vb.height * 0.15*.23,
                                onPressed: null,
                              )
                            ],
                          ),
                        ),
                        Flexible(
                          fit: FlexFit.loose,
                          child: RectangleImage_cl(
                            imageUrl_vb: Constants_cl.getAdImageUrl_mt(
                                vs_vb.myAdsVMList_vb[index].adId_mt),
                          ),
                        ),
                        Padding(
                          padding: const EdgeInsets.all(16.0),
                          child: Row(
                            mainAxisAlignment: MainAxisAlignment.spaceBetween,
                            children: <Widget>[
                              new Row(
                                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                                children: <Widget>[
                                  new LikeIconButton_cl(
                                    id_vb: vs_vb.myAdsVMList_vb[index].adId_mt,
                                    index_vb:index,
                                    onPressed_vb:  likeIconButtonFunction_mt,
                                    likedIt_vb: this.userInfo_vb.getLikedAdsAtOnLoad_mt==null ? ",":this.userInfo_vb.getLikedAdsAtOnLoad_mt,
                                    size_vb: deviceSize_vb.height * 0.15*.23,
                                  ),
                                  new SizedBox(
                                    width: 36.0,
                                  ),

                                  new SizedBox(
                                    width: 32.0,
                                  ),
                                  // new Icon(Icons.airplanemode_active),
                                ],
                              ),
                              new Icon(Icons.bookmark,size: deviceSize_vb.height * 0.15*.23)
                            ],
                          ),
                        ),
                        Padding(
                          padding: const EdgeInsets.symmetric(horizontal: 5.0),
                          child:Text(
                            vs_vb.myAdsVMList_vb[index].contentDesc_mt +" SANJEECV: "+DateTime.now().toString()
                                +"زبانِ اُردُوئے معلّٰى   created: "+vs_vb.myAdsVMList_vb[index].createdDate_mt
                                +"index :"+index.toString()+" id: "+ vs_vb.myAdsVMList_vb[index].adId_mt +"   pageNum: "+vs_vb.myAdsVMList_vb[index].pageNum_mt.toString()
                                ,
                            //Description section
                            style: TextStyle(
                              fontWeight: FontWeight.w500,
                              fontSize: deviceSize_vb.height * 0.15*.15,
                              color: Colors.black,
                              wordSpacing: 2,
                              letterSpacing: 1,
                              height: 1.6,
                            ),
                          ),
                        ),
                        Padding(
                          padding: const EdgeInsets.fromLTRB(16.0, 16.0, 0.0, 8.0),
                          child: Row(
                            mainAxisAlignment: MainAxisAlignment.start,
                            children: <Widget>[
                              new Container( // Bottom Thumbnail Image
                                height: 40.0,
                                width: 40.0,
                                decoration: new BoxDecoration(
                                  shape: BoxShape.circle,
                                  image: new DecorationImage(
                                    fit: BoxFit.fill,
                                    //image: AssetImage('assets/images/sql.jpg'), //image at comment
                                    image: new NetworkImage(
                                        Constants_cl.getAdImageIconUrl_mt(
                                            vs_vb.myAdsVMList_vb[index].adId_mt),),
                                  ),
                                ),
                              ),
                              new SizedBox(
                                width: 10.0,
                              ),
                              Expanded(
                                child: new TextField(
                                  decoration: new InputDecoration(
                                    border: InputBorder.none,
                                    enabled: false,
                                    //hintText: "Add a comment...",
                                  ),
                                ),
                              ),
                            ],
                          ),
                        ),
                        Padding(
                          padding: const EdgeInsets.symmetric(horizontal: 16.0),
                          child:
                          Text(
                              vs_vb.myAdsVMList_vb[index].publishedAt_mt.substring(0,16),
                              style:
                              TextStyle(
                                color: Colors.black,
                                fontWeight: FontWeight.w500,
                                fontSize: deviceSize_vb.height * 0.15*.12,
                                wordSpacing: 2,
                                letterSpacing: 1,
                                height: 1.6,
                              )
                          ),
                        ),
//                        Padding(
//                          padding: const EdgeInsets.symmetric(horizontal: 16.0),
//                          child: Row( children: [Expanded(
//                            child: Column(
//                              children: [Divider(
//                              color: Colors.black,
//                              thickness: .71,
//                            ),
//                            ]
//                            ),
//                          ),
//                          ],
//                          ),
//                        ),
                      ],
                    ),
                ),
              ),
            ),
          childCount: vs_vb.myAdsVMList_vb.length,
        ),
      )
    ;

  }

  String sampleAddressFormat1()
  {
    return Intl.message(
      'local,city,state',
      name: 'sampleAddressFormat',
      args: [],
      desc: 'address format',
      //examples: const {'name': 'Emily'}
    );
    //  pub run intl_translation:extract_to_arb --output-dir=/home/sunjiv6/sunws/ProjectWS/AndroidWs/FlutterWS/flutter_app_02/lib/intl15 ads_grid_list_screen.dart
  }

  String get sampleAddressFormat {
    return Intl.message(
      'Hello World',
      name: 'sampleAddressFormat',
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
  }

  String get noResFound {
    return Intl.message(
      'Hello World',
      name: 'noResFound',
      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
  }

  String get startSearching {
    return Intl.message(
      'Hello World',
      name: 'startSearching',
      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
  }

  String get loginText {
    return Intl.message(
      'Hello World',
      name: 'loginText',
      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
  }

  String get regsiterText {
    return Intl.message(
      'Hello World',
      name: 'regsiterText',
      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
  }


}
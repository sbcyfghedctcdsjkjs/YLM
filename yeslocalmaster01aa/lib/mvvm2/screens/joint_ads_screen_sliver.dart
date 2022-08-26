import 'dart:async';

import 'package:flutter/material.dart';
import 'package:yeslocalmarket01aa/generated/l10n.dart';
import 'package:yeslocalmarket01aa/mvvm2/apikey/ApiKeyNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/customIcons/like_icon_below_ad.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAds/FetchAdsNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAds/FetchAdsViewModel.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAdsCategory/FetchAdsCategoryNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/saveAds/SaveAdsResultVMNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/utils/constants.dart';

import 'package:yeslocalmarket01aa/mvvm2/widgets/AdsMenuDrawer.dart';
import 'package:yeslocalmarket01aa/mvvm2/widgets/RectangleImage.dart';
import 'package:yeslocalmarket01aa/mvvm2/modelDTO/userInfo.dart';
import 'package:provider/provider.dart';
import 'package:intl/intl.dart';
import 'package:yeslocalmarket01aa/intl15/MyAdsLocalization.dart';

class JointAdsGridListScreenSliver_cl extends StatefulWidget {
  @override
  _AdsScreenState_cl createState() => _AdsScreenState_cl();
}

class _AdsScreenState_cl extends State<JointAdsGridListScreenSliver_cl> {
  UserInfo_cl userInfo_vb=UserInfo_cl();
  int pageNum_vb=1;//Page number at the time of loading
  TextEditingController _searchQueryController_vb = TextEditingController();
  Widget loginSwitchLogout_vb =null;
  var _controller_vb = ScrollController();
  String likeIcon_Temp="thumb_up";
  var likedIconIdsList=[','];
  Widget _body = CircularProgressIndicator();  // Default Body
  final GlobalKey<ScaffoldState> _AppBarScaffoldKey_vb = new GlobalKey<ScaffoldState>();
  //String likeIcon_Temp = 'no-action';
  int num=0;

  @override
  void initState() {
    super.initState();
    userInfo_vb.setLoginOutWait_mt("wait");
    //Provider.of<ApiKeyNotifier_cl>(context, listen: false).getApiKey2_mt();
    //userInfo_vb.setApiKey_mt = ApiKeyNotifier_cl().getApiKey().apiKey_vb;
    new ApiKeyNotifier_cl().getApiKey2_mt().then((String apikey){
      setState(() {
        userInfo_vb.setApiKey_mt  = apikey;
        print("setState count=1");
        //this.userInfo_vb.setLikedAdsAtOnLoad_mt=",jqhdgjqhjq,";//await Future.delayed(Duration(seconds: 5));
        print("<>_AdsScreenState<><><><><><><><><><><>CALLED 1");
        _searchQueryController_vb.text=""; // delete it --------------------------&&&&&&&&&&&&&***************

        String temp_vb="";
        print("_AdsScreenState 1 >> _searchQueryController.text: "+_searchQueryController_vb.text);
        temp_vb=_searchQueryController_vb.text;
        userInfo_vb.setLocationSearch_mt=temp_vb;
        print("Start Calling Timer JointAdsGridListScreenSliver initState");
        //Timer _time = new Timer(const Duration(seconds: 8),(){
        //userInfo_vb.setApiKey_mt = Provider.of<ApiKeyNotifier_cl>(context, listen: false).apiKeyModel_vb.apiKey_vb;
        Constants_cl.API_KEY=userInfo_vb.getApiKey_mt;
        Provider.of<FetchAdsCategoryNotifier_cl>(context, listen: false).fectchAllAdsCategory_mt();
        // Provider.of<FetchAdsNotifier_cl>(context, listen: false).fectchAdsInPagesByPageNumOnLoad_mt(
        //                                                 pageNum_vb,userInfo_vb.getLocationSearch_mt,
        //                                                 userInfo_vb.getCategoryByDurationIdList_mt,
        //                                                 userInfo_vb.getCategoryByTypeIdList_mt);
        /*new FetchAdsNotifier_cl().fectchAdsInPagesByPageNumOnLoad2_mt(
            pageNum_vb,userInfo_vb.getLocationSearch_mt,
            userInfo_vb.getCategoryByDurationIdList_mt,
            userInfo_vb.getCategoryByTypeIdList_mt)
            .then((List<FetchAdsViewModel_cl> myAdsVMList_vb){setState((){
          // FetchAdsNotifier_cl vs_vb = new FetchAdsNotifier_cl();
          // vs_vb.myAdsVMList_vb=myAdsVMList_vb;
          // vs_vb.loadingStatus_vb=LoadingStatus_cl.completed_vb;
          print("setState count=2");
          if(myAdsVMList_vb.length>0) {
            Provider
                .of<FetchAdsNotifier_cl>(context, listen: false)
                .myAdsVMList_vb = myAdsVMList_vb;
            Provider
                .of<FetchAdsNotifier_cl>(context, listen: false)
                .loadingStatus_vb = LoadingStatus_cl.completed_vb;
          }else{
            // Provider
            //     .of<FetchAdsNotifier_cl>(context, listen: false)
            //     .loadingStatus_vb = LoadingStatus_cl.empty_vb;
          }
          //_body =  mainAdScreen();
        });});*/
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
              // Provider.of<FetchAdsNotifier_cl>(context, listen: false)
              //     .fectchAdsInPagesByPageNum_mt(vs_vb.myAdsVMList_vb[vs_vb.myAdsVMList_vb.length-1].pageNum_mt+1,
              //     this.userInfo_vb.getLocationSearch_mt,
              //     userInfo_vb.getCategoryByDurationIdList_mt,
              //     userInfo_vb.getCategoryByTypeIdList_mt);
              new FetchAdsNotifier_cl().fectchAdsInPagesByPageNum2_mt(vs_vb.myAdsVMList_vb[vs_vb.myAdsVMList_vb.length-1].pageNum_mt+1,
                  this.userInfo_vb.getLocationSearch_mt,
                  userInfo_vb.getCategoryByDurationIdList_mt,
                  userInfo_vb.getCategoryByTypeIdList_mt)
                  .then((List<FetchAdsViewModel_cl> myAdsVMList_vb){setState((){
                print("setState count=3");
                // FetchAdsNotifier_cl vs_vb = new FetchAdsNotifier_cl();
                // vs_vb.myAdsVMList_vb=myAdsVMList_vb;
                // vs_vb.loadingStatus_vb=LoadingStatus_cl.completed_vb;
                Provider.of<FetchAdsNotifier_cl>(context, listen: false).myAdsVMList_vb+=myAdsVMList_vb;
                Provider.of<FetchAdsNotifier_cl>(context, listen: false).loadingStatus_vb=LoadingStatus_cl.completed_vb;
                //_body =  mainAdScreen();

              });});
            }
          }
        });
        temp_vb=null;

        Timer _time11=  new Timer(const Duration(seconds: 2),(){ print("Timer seconds : 2");});
        userInfo_vb.setAdsCategoryVMList_mt(Provider.of<FetchAdsCategoryNotifier_cl>(context, listen: false).myAdsCategoryVMList_vb);
        //_body =  mainAdScreen();
      });//setState(()
    });//new ApiKeyNotifier_cl().getApiKey2_mt()

    const repeatAfterSec = const Duration(seconds:2);
    new Timer.periodic(repeatAfterSec, (Timer t) {


      if(this.userInfo_vb.getLoginOutWait_mt.endsWith("login") || this.userInfo_vb.getLoginOutWait_mt.endsWith("logout"))
      {
        print('duration 2 sec! DO refresh');
        this.userInfo_vb.setLoginOutWait_mt("wait");
        setState((){

        });

      }else{print('duration 2 sec! NOT refresh');}

    });
  }


  void initStateORIG() {
    super.initState();
    userInfo_vb.setLoginOutWait_mt("wait");
    //Provider.of<ApiKeyNotifier_cl>(context, listen: false).getApiKey2_mt();
    //userInfo_vb.setApiKey_mt = ApiKeyNotifier_cl().getApiKey().apiKey_vb;
    new ApiKeyNotifier_cl().getApiKey2_mt().then((String apikey){
      setState(() {
        userInfo_vb.setApiKey_mt  = apikey;
        print("setState count=1");
        //this.userInfo_vb.setLikedAdsAtOnLoad_mt=",jqhdgjqhjq,";//await Future.delayed(Duration(seconds: 5));
        print("<>_AdsScreenState<><><><><><><><><><><>CALLED 1");
        _searchQueryController_vb.text="noida"; // delete it --------------------------&&&&&&&&&&&&&***************

        String temp_vb="";
        print("_AdsScreenState 1 >> _searchQueryController.text: "+_searchQueryController_vb.text);
        temp_vb=_searchQueryController_vb.text;
        userInfo_vb.setLocationSearch_mt=temp_vb;
        print("Start Calling Timer JointAdsGridListScreenSliver initState");
        //Timer _time = new Timer(const Duration(seconds: 8),(){
        //userInfo_vb.setApiKey_mt = Provider.of<ApiKeyNotifier_cl>(context, listen: false).apiKeyModel_vb.apiKey_vb;
        Constants_cl.API_KEY=userInfo_vb.getApiKey_mt;
        Provider.of<FetchAdsCategoryNotifier_cl>(context, listen: false).fectchAllAdsCategory_mt();
        // Provider.of<FetchAdsNotifier_cl>(context, listen: false).fectchAdsInPagesByPageNumOnLoad_mt(
        //                                                 pageNum_vb,userInfo_vb.getLocationSearch_mt,
        //                                                 userInfo_vb.getCategoryByDurationIdList_mt,
        //                                                 userInfo_vb.getCategoryByTypeIdList_mt);
        new FetchAdsNotifier_cl().fectchAdsInPagesByPageNumOnLoad2_mt(
            pageNum_vb,userInfo_vb.getLocationSearch_mt,
            userInfo_vb.getCategoryByDurationIdList_mt,
            userInfo_vb.getCategoryByTypeIdList_mt)
            .then((List<FetchAdsViewModel_cl> myAdsVMList_vb){setState((){
          // FetchAdsNotifier_cl vs_vb = new FetchAdsNotifier_cl();
          // vs_vb.myAdsVMList_vb=myAdsVMList_vb;
          // vs_vb.loadingStatus_vb=LoadingStatus_cl.completed_vb;
          print("setState count=2");
          if(myAdsVMList_vb.length>0) {
            Provider
                .of<FetchAdsNotifier_cl>(context, listen: false)
                .myAdsVMList_vb = myAdsVMList_vb;
            Provider
                .of<FetchAdsNotifier_cl>(context, listen: false)
                .loadingStatus_vb = LoadingStatus_cl.completed_vb;
          }else{
            // Provider
            //     .of<FetchAdsNotifier_cl>(context, listen: false)
            //     .loadingStatus_vb = LoadingStatus_cl.empty_vb;
          }
          //_body =  mainAdScreen();
        });});
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
              // Provider.of<FetchAdsNotifier_cl>(context, listen: false)
              //     .fectchAdsInPagesByPageNum_mt(vs_vb.myAdsVMList_vb[vs_vb.myAdsVMList_vb.length-1].pageNum_mt+1,
              //     this.userInfo_vb.getLocationSearch_mt,
              //     userInfo_vb.getCategoryByDurationIdList_mt,
              //     userInfo_vb.getCategoryByTypeIdList_mt);
              new FetchAdsNotifier_cl().fectchAdsInPagesByPageNum2_mt(vs_vb.myAdsVMList_vb[vs_vb.myAdsVMList_vb.length-1].pageNum_mt+1,
                  this.userInfo_vb.getLocationSearch_mt,
                  userInfo_vb.getCategoryByDurationIdList_mt,
                  userInfo_vb.getCategoryByTypeIdList_mt)
                  .then((List<FetchAdsViewModel_cl> myAdsVMList_vb){setState((){
                print("setState count=3");
                // FetchAdsNotifier_cl vs_vb = new FetchAdsNotifier_cl();
                // vs_vb.myAdsVMList_vb=myAdsVMList_vb;
                // vs_vb.loadingStatus_vb=LoadingStatus_cl.completed_vb;
                Provider.of<FetchAdsNotifier_cl>(context, listen: false).myAdsVMList_vb+=myAdsVMList_vb;
                Provider.of<FetchAdsNotifier_cl>(context, listen: false).loadingStatus_vb=LoadingStatus_cl.completed_vb;
                //_body =  mainAdScreen();

              });});
            }
          }
        });
        temp_vb=null;

        Timer _time11=  new Timer(const Duration(seconds: 2),(){ print("Timer seconds : 2");});
        userInfo_vb.setAdsCategoryVMList_mt(Provider.of<FetchAdsCategoryNotifier_cl>(context, listen: false).myAdsCategoryVMList_vb);
        //_body =  mainAdScreen();
      });//setState(()
    });//new ApiKeyNotifier_cl().getApiKey2_mt()

    const repeatAfterSec = const Duration(seconds:2);
    new Timer.periodic(repeatAfterSec, (Timer t) {


      if(this.userInfo_vb.getLoginOutWait_mt.endsWith("login") || this.userInfo_vb.getLoginOutWait_mt.endsWith("logout"))
      {
        print('duration 2 sec! DO refresh');
        this.userInfo_vb.setLoginOutWait_mt("wait");
        setState((){

        });

      }else{print('duration 2 sec! NOT refresh');}

    });
  }

  @override
  void dispose(){super.dispose();}
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
      likedIconIdsList.remove(id_vb.toString());
    } else {
      likedAds_vb =likedAds_vb+id_vb.toString()+",";
      likedIconIdsList.add(id_vb.toString());
    }
    int i=0;
    this.userInfo_vb.setLikedAdsAtOnLoad_mt=likedAds_vb;
    setState(() {
      print("setState count=4");
      // this.userInfo_vb.getLikedAdsAtOnLoad_mt.contains(","+vs_vb.myAdsVMList_vb[index].adId_mt.toString()+",")
      //     ? this.likeIcon_Temp = 'thumb_up': this.likeIcon_Temp = 'thumbDown';
      // print('this.likeIcon_Temp: '+this.likeIcon_Temp);
      // print(this.userInfo_vb.getLikedAdsAtOnLoad_mt+' :contains: '+vs_vb.myAdsVMList_vb[index].adId_mt.toString());
    });
    //if(index_vb==2)
        {
      if(this.userInfo_vb.getIdOfLikedAds_mt==null || this.userInfo_vb.getIdOfLikedAds_mt.trim().length==0)
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
    // Provider.of<FetchAdsNotifier_cl>(context, listen: false)
    //     .fectchAdsInPagesByPageNumOnSearchLoad_mt(pageNum_vb,userInfo_vb.getLocationSearch_mt,
    //                                                 userInfo_vb.getCategoryByDurationIdList_mt,
    //                                                 userInfo_vb.getCategoryByTypeIdList_mt);

    new FetchAdsNotifier_cl().fectchAdsInPagesByPageNumOnSearchLoad2_mt(
        pageNum_vb,userInfo_vb.getLocationSearch_mt,
        userInfo_vb.getCategoryByDurationIdList_mt,
        userInfo_vb.getCategoryByTypeIdList_mt)
        .then((List<FetchAdsViewModel_cl> myAdsVMList_vb){setState((){
      // FetchAdsNotifier_cl vs_vb = new FetchAdsNotifier_cl();
      // vs_vb.myAdsVMList_vb=myAdsVMList_vb;
      // vs_vb.loadingStatus_vb=LoadingStatus_cl.completed_vb;
      print("setState count=5");
      Provider.of<FetchAdsNotifier_cl>(context, listen: false).myAdsVMList_vb=myAdsVMList_vb;
      if(myAdsVMList_vb.length<1)
        Provider.of<FetchAdsNotifier_cl>(context, listen: false).loadingStatus_vb=LoadingStatus_cl.empty_vb;
      else
        Provider.of<FetchAdsNotifier_cl>(context, listen: false).loadingStatus_vb=LoadingStatus_cl.completed_vb;


    });});

    loc_vb=null;
    userInfo_vb==null ? print("AdsGridListScreen 3 userInfo==null") : print("AdsGridListScreen 3 userInfo!=null");

  }

  Widget mainAdScreen2NOTINUSE() {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('Login '+this.likeIcon_Temp),
      ),
      body: new Container(
        child: new Center(
          child: new IconButton(
              key: UniqueKey(),
              icon: this.likeIcon_Temp.endsWith("OnLoad") ? Icon(Icons.eighteen_mp): Icon(Icons.thumb_up),
              color: this.likeIcon_Temp.endsWith("OnLoad") ? Colors.black: Colors.blue,
              onPressed: (){
                setState(() {
                  print("setState count=6");
                  this.likeIcon_Temp.endsWith("OnLoad") ? this.likeIcon_Temp = 'OnPress': this.likeIcon_Temp = 'OnLoad';
                  //this.likeIcon_Temp = 'OnPress';
                  print('this.likeIcon_Temp: '+this.likeIcon_Temp);
                });
              }
          ),
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    //const repeatAfterSec = const Duration(seconds:2);
    //new Timer.periodic(repeatAfterSec, (Timer t) {


      if(this.userInfo_vb.getApiKey_mt != null)
      {
        print('show main screen');
        //this.userInfo_vb.setLoginOutWait_mt("wait");
        return mainAdScreen();
      }else{print('show Logo & CircularProgressIndicator');
      return Material(
          type: MaterialType.transparency,
          child: new Container(
          color: Color(0xFF1B5E20),
          // width: 1.5,
          // height: 1.5,
          child: Column(
            children: <Widget>[
              Padding(
                padding: const EdgeInsets.fromLTRB(26.0, 26.0, 28.0, 26.0),
              ),

              // Flexible(
              //   fit: FlexFit.loose,
              //   child: new Text("ShosayTy"),
              // ),
              Padding(
                padding: const EdgeInsets.fromLTRB(16.0, 136.0, 8.0, 16.0),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: <Widget>[
                    Row(
                      children: <Widget>[
                        new Container(
                          height: 40.0,
                          width: 40.0,
                          // decoration: new BoxDecoration(
                          //   shape: BoxShape.circle,
                          //   image: new DecorationImage(  // Top Thumbnail image
                          //       fit: BoxFit.fill,
                          //       image: new NetworkImage(
                          //         Constants_cl.getAdImageIconUrl_mt(
                          //             vs_vb.myAdsVMList_vb[index].adId_mt),)
                          //     //"http://10.0.2.2:8020/ba/imageshow/image/show/"+vs.myAdsVMList_vb[index].adId.toString())
                          //   ),
                          // ),
                        ),
                        new SizedBox(
                          width: 10.0,
                        ),

                      ],
                    ),
                    // new IconButton(
                    //   icon: Icon(Icons.more),
                    //   iconSize: MediaQuery.of(context).size.height * 0.15*.23,
                    //   onPressed: null,
                    // )
                  ],
                ),
              ),
              new Center(
              child: Text(
                  appNameLogoText,
                  style: TextStyle(
                    color: Colors.white,
                    fontWeight: FontWeight.w800,
                    fontSize: MediaQuery.of(context).size.height *.15 * .5,
                    wordSpacing: 2,
                    letterSpacing: 1,
                    height: 1.6,
                  ),
                ),
              ),
              new Center(
                child: Text(
                  appNameLogoText2,
                  style: TextStyle(
                    color: Colors.white,
                    fontWeight: FontWeight.w800,
                    fontSize: MediaQuery.of(context).size.height *.15 * .5,
                    wordSpacing: 2,
                    letterSpacing: 1,
                    height: 1.6,
                  ),
                ),
              ),
              new Center(
                child: CircularProgressIndicator(
                  backgroundColor: Colors.white,
                  strokeWidth: 2,
                )
            // padding: EdgeInsets.fromLTRB(
            //         MediaQuery.of(context).size.width *.15 *.4 ,
            //         MediaQuery.of(context).size.height *.15 *.3, 0.0, 0.0 ),
          )])
      ));

      }

   // });

  }

  Widget mainAdScreen(){
    var vs_vb  = Provider.of<FetchAdsNotifier_cl>(context, listen: false);
    var deviceSize_vb = MediaQuery.of(context).size;
    var msg="";
    if(UserInfo_cl.noResultFound_vb){
      msg=noResFound;
      UserInfo_cl.noResultFound_vb=false;
    } else{
      msg="Enter street,city,state";
    }
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
              onSubmitted: (str){
                FocusScope.of(context).unfocus();
                performSearch_mt();
                return ;
              },
            ),

            floating: true,
            snap: true,
            pinned: false,
            //stretch: true,
            onStretchTrigger: () {
              // Function callback for stretch
              return;
            },
            expandedHeight: deviceSize_vb.height * 0.15*.44,
          ),
          (vs_vb.myAdsVMList_vb.length > 0) ? _buildListErrorOrSliver_mt(vs_vb):
          SliverToBoxAdapter(
            child: Text(msg,

              textAlign: TextAlign.center,
              style: TextStyle(
                  color: Colors.blue,
                  fontWeight: FontWeight.w300,
                  fontSize: MediaQuery.of(context).size.height *.1 * .3,
                  height: 3.2

              ),),
          )

        ],
      ),
      drawer : AdsMenuDrawer_cl(userInfo_vb: this.userInfo_vb),
    );
  }



  Widget _buildListErrorOrSliver_mt(var adsListvm_vb) {
    switch (adsListvm_vb.loadingStatus_vb) {

      case LoadingStatus_cl.searching_vb:
        return
          SliverToBoxAdapter(child: CircularProgressIndicator(),);
      case LoadingStatus_cl.completed_vb:
        return _buildListSliver_mt();


      case LoadingStatus_cl.empty_vb:
        return SliverToBoxAdapter(
          child: Text(noResFound,
            textAlign: TextAlign.center,
            style: TextStyle(
                color: Colors.blue,
                fontWeight: FontWeight.w300,
                fontSize: MediaQuery.of(context).size.height *.1 * .3

            ),),
        );
      default:
        return SliverToBoxAdapter(
          child: Text(noResFound,
            textAlign: TextAlign.center,
            style: TextStyle(
                color: Colors.blue,
                fontWeight: FontWeight.w300,
                fontSize: MediaQuery.of(context).size.height *.1 * .3

            ),),
        );
    }
  }

  Widget _buildListSliver_mt() {
    var vs_vb  = Provider.of<FetchAdsNotifier_cl>(context,listen: false);
    var deviceSize_vb = MediaQuery.of(context).size;
    return //(vs_vb.myAdsVMList_vb.length > 0) ?
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
                                  // decoration: new BoxDecoration(
                                  //   shape: BoxShape.circle,
                                  //   image: new DecorationImage(  // Top Thumbnail image
                                  //       fit: BoxFit.fill,
                                  //       image: new NetworkImage(
                                  //         Constants_cl.getAdImageIconUrl_mt(
                                  //             vs_vb.myAdsVMList_vb[index].adId_mt),)
                                  //     //"http://10.0.2.2:8020/ba/imageshow/image/show/"+vs.myAdsVMList_vb[index].adId.toString())
                                  //   ),
                                  // ),
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
                                // new IconButton(
                                //     key: UniqueKey(),
                                //     iconSize:  deviceSize_vb.height * 0.15*.23,
                                //     icon: this.userInfo_vb.getLikedAdsAtOnLoad_mt.contains(","+vs_vb.myAdsVMList_vb[index].adId_mt.toString()+",") ? Icon(Icons.thumb_up): Icon(Icons.eighteen_mp),
                                //     color: this.userInfo_vb.getLikedAdsAtOnLoad_mt.contains(","+vs_vb.myAdsVMList_vb[index].adId_mt.toString()+",") ? Colors.blue: Colors.black,
                                //     onPressed: likeIconButtonFunction_mt(vs_vb.myAdsVMList_vb[index].adId_mt,index),
                                // ),


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
                          vs_vb.myAdsVMList_vb[index].contentDesc_mt,//Description section
                          key: UniqueKey(),
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
                              /*decoration: new BoxDecoration(
                                shape: BoxShape.circle,
                                image: new DecorationImage(
                                  fit: BoxFit.fill,
                                  //image: AssetImage('assets/images/sql.jpg'), //image at comment
                                  image: new NetworkImage(
                                    Constants_cl.getAdImageIconUrl_mt(
                                        vs_vb.myAdsVMList_vb[index].adId_mt),),
                                ),
                              ),*/
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
                    ],
                  ),
                ),
              ),
            ),
          childCount: vs_vb.myAdsVMList_vb.length,
        ),
      );
       /* :
    SliverList(
        delegate: SliverChildBuilderDelegate((BuildContext context, index) =>
          Container(
              child: Text("Enter valid street,city,state")
          )
        )
    );*/

  }

    String labelsTextI10n_mt(String label_vb) {
    return Intl.message('',
      name: '$label_vb',


      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
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

  String get appNameLogoText {
    return Intl.message(
      'Hello World',
      name: 'app_name_loadscreen',
      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
  }
  String get appNameLogoText2 {
    return Intl.message(
      'Hello World',
      name: 'app_name_loadscreen2',
      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
  }

}
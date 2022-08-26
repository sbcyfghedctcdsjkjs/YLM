import 'dart:async';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:yeslocalmarket01aa/mvvm2/customIcons/categoryCheckBox.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAdsCategory/FetchAdsCategory.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAdsCategory/FetchAdsCategoryNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAdsCategory/FetchAdsCategoryViewModel.dart';
import 'package:yeslocalmarket01aa/mvvm2/modelDTO/userInfo.dart';
import 'package:yeslocalmarket01aa/mvvm2/utils/constants.dart';
import 'package:intl/intl.dart';
import 'package:yeslocalmarket01aa/intl15/MyAdsLocalization.dart';
import 'package:yeslocalmarket01aa/mvvm2/auth/LoginAdViewer.dart';
import 'package:yeslocalmarket01aa/mvvm2/auth/RegisterAdViewer.dart';
import 'package:provider/provider.dart';

class AdsMenuDrawerOLD_cl extends StatefulWidget {
  UserInfo_cl userInfo_vb;

  AdsMenuDrawerOLD_cl({this.userInfo_vb});



  @override
  _AdsMenuDrawerStateOLD_cl createState() => _AdsMenuDrawerStateOLD_cl(this.userInfo_vb);
}

class _AdsMenuDrawerStateOLD_cl extends State<AdsMenuDrawerOLD_cl> {
  Widget loginSwitchLogout_vb =null;
  UserInfo_cl userInfo_vb;
  Widget registerWidget_vb;
  //List<FetchAdsCatgeoryViewModel_cl> adsCategoryList_vb = null;
  _AdsMenuDrawerStateOLD_cl(userInfo_vb)
  {    this.userInfo_vb=userInfo_vb;  }



  @override
  void initState() {

  super.initState();

    //Timer _time = new Timer(const Duration(seconds: 5),(){


  //    Provider.of<FetchAdsNotifier_cl>(context, listen: false).fectchAdsInPagesByPageNumOnLoad_mt(pageNum_vb,userInfo_vb.getLocationSearch_mt);
      print("I am waiting in _AdsMenuDrawerState_cl initState");

    //});
  }

  @override
  void dispose() {
    int n=0;
    super.dispose();

  }

  @override
  Widget build(BuildContext context) {
    var deviceSize_vb = MediaQuery.of(context).size;
    return Container(
      width: deviceSize_vb.width * .60,
      child:  Drawer(
        // Add a ListView to the drawer. This ensures the user can scroll
        // through the options in the drawer if there isn't enough vertical
        // space to fit everything.
        child: ListView(
          // Important: Remove any padding from the ListView.
          padding: EdgeInsets.zero,
          children: <Widget>[
            Container(color: Colors.blue,
              height: deviceSize_vb.height * .1,
              margin:  EdgeInsets.fromLTRB(deviceSize_vb.width *.15 *.4 , deviceSize_vb.height *.15 *.3, 0.0, 0.0),
              child: Row(
                children: <Widget>[
                  Icon(
                     userInfo_vb.getIdR_mt==null ? Icons.done:Icons.contacts ,
                     size: deviceSize_vb.height * 0.25*.2,
                     color: Colors.white,
                  ),
                  Text(
                     userInfo_vb.getIdR_mt==null ? defaultDrawerTitle: userLoginDrawerTitle,
                     style: TextStyle (
                         fontSize: deviceSize_vb.height * 0.1*.2,
                       color: Colors.white
                     ),
                  ),

                ],
              )
            ),

            callLoginSwitchLogout_mt(),
            registerWidget_vb ,
            ListTile(  // uploadAdsTextAtDrawer
              leading: Icon(
                Icons.cloud_upload,
                size:  deviceSize_vb.height * 0.15*.3,
                color: Colors.blue,
              ),
              contentPadding: EdgeInsets.fromLTRB(
                  deviceSize_vb.width *.15 *.4 , deviceSize_vb.height *.15 *.3, 0.0, 0.0 ),
              title: Text(
                uploadAdsTextAtDrawer,
                style: TextStyle(
                    fontSize: deviceSize_vb.height  * .2 * .13,
                  fontWeight: FontWeight.w400,
                ),
              ),
              trailing: Icon(
                Icons.open_in_browser,
                size:  deviceSize_vb.height * 0.15*.3,
                color: Colors.blue,
              ),
              onTap: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => LoginAdViewer_cl()),
                );
              },
            ),

            ListTile( //instant12hrsAds
              leading: Icon(
                Icons.av_timer,
                size:  deviceSize_vb.height * 0.15*.3,
                color: Colors.blue,
              ),
              contentPadding: EdgeInsets.fromLTRB(
                  deviceSize_vb.width *.15 *.4 , deviceSize_vb.height *.15 *.3, 0.0, 0.0 ),
              title: Text(
                instant12hrsAds,
                style: TextStyle(
                    fontSize: deviceSize_vb.height  * .2 * .13,
                    fontWeight: FontWeight.w400,
                ),
              ),

              onTap: () {
                Navigator.pop(context);
              },
            ),

            ListTile( //instant12hrsAds
              leading: Icon(
                Icons.local_car_wash,
                size:  deviceSize_vb.height * 0.15*.3,
                color: Colors.blue,
              ),
              contentPadding: EdgeInsets.fromLTRB(
                  deviceSize_vb.width *.15 *.4 , deviceSize_vb.height *.15 *.3, 0.0, 0.0 ),
              title: Text(
                forAWeekAds,
                style: TextStyle(
                  fontSize: deviceSize_vb.height * .2 * .13,
                  fontWeight: FontWeight.w400,
                ),
              ),

              onTap: () {
                Navigator.pop(context);
              },
            ),
            createTop4Category_mt()[0],
            createTop4Category_mt()[1],
            createTop4Category_mt()[2],
            createTop4Category_mt()[3],
          ],
        ),
      )
    );

  }

  Widget callLoginSwitchLogout_mt()
  {
    userInfo_vb.getIdR_mt==null ? print("callLoginSwitchLogout() userInfo.getId==null") : print("callLoginSwitchLogout() userInfo.getId !=null");
    if (userInfo_vb.getIdR_mt ==   null) {
      loginSwitchLogout_vb = createLoginWidget_mt();
      registerWidget_vb=createRegisterWidget_mt();
    } else {

      loginSwitchLogout_vb = createLogoutWidget_mt();
      registerWidget_vb=ListTile(
      );
    }
    return loginSwitchLogout_vb;
  }
  Widget createLoginWidget_mt(){
    var deviceSize = MediaQuery.of(context).size;
    return ListTile(
      leading: Icon(
          Icons.account_circle,
          size:  deviceSize.height * 0.15*.3,
          color: Colors.blue,
      ),
      contentPadding: EdgeInsets.fromLTRB(
          deviceSize.width *.15 *.4 , deviceSize.height *.15 *.3, 0.0, 0.0 ),
      title: Text(loginText,
        style: TextStyle(
            fontSize: deviceSize.height * .2 * .13,
            fontWeight: FontWeight.w400,
        ),
      ),

      onTap: () {
        Navigator.pop(context);
        Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => LoginAdViewer_cl(userInfo_vb: userInfo_vb,)),
        );
      },
    );
  }

  Widget createRegisterWidget_mt(){
    var deviceSize_vb = MediaQuery.of(context).size;
    return ListTile(
      leading: Icon(
        Icons.assignment_turned_in,
        size:  deviceSize_vb.height * 0.15*.3,
        color: Colors.blue,
      ),
      contentPadding: EdgeInsets.fromLTRB(
          deviceSize_vb.width *.15 *.4 , deviceSize_vb.height *.15 *.4, 0.0, 0.0 ),
      title: Text(
        regsiterText,
        style: TextStyle(
            fontSize: deviceSize_vb.height * .2 * .13,
            fontWeight: FontWeight.w400,
        ),
      ),
      onTap: () {
        Navigator.pop(context);
        Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => RegisterAdViewer_cl(userInfo_vb: this.widget.userInfo_vb,)),
        );
      },
    );
  }


  Widget createLogoutWidget_mt(){
    var deviceSize_vb = MediaQuery.of(context).size;
    return ListTile(
      leading: Icon(
        Icons.account_box,
        size:  deviceSize_vb.height * 0.15*.3,
        color: Colors.blue,
      ),
      contentPadding: EdgeInsets.fromLTRB(
          deviceSize_vb.width *.15 *.4 , deviceSize_vb.height *.15 *.3, 0.0, 0.0 ),
      title: Text(logoutText,
        style: TextStyle(
            fontSize: deviceSize_vb.height * .2 * .13,
            fontWeight: FontWeight.w400,
        ),
      ),
      onTap: () {
       this.widget.userInfo_vb.setIdR_mt = null;
       this.widget.userInfo_vb.setUserId_mt=null;
       this.widget.userInfo_vb.setLikedAdsAtOnLoad_mt=null;
       this.widget.userInfo_vb.setIdOfLikedAds_mt=null;
       Navigator.pop(context);
      },
    );
  }

  categoryCheckBoxClicked(String id_vb,int index_vb,bool flag){
    print("categoryCheckBoxClicked ");
  }

  List<Widget> createTop4Category_mt(){
    List<Widget> lw =[];//new List<Widget>();
    List<FetchAdsCatgeoryViewModel_cl> categoryVMList = Provider.of<FetchAdsCategoryNotifier_cl>(context, listen: false).myAdsCategoryVMList_vb;
    int n=0;
    while(n<4)
    {
      lw.add(CategoryCheckBox_cl(
          selected_vb: false,
          index_vb: n,
          id_vb: categoryVMList[n].id_mt,
          //onPressed_vb: categoryCheckBoxClicked,
          categoryName_vb: categoryVMList[n].categoryName_mt,
          //selected: false,
          ));
      n++;
    }
    return lw;
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

  String get logoutText {
    return Intl.message(
      'Hello World',
      name: 'logoutText',
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

  String get defaultDrawerTitle {
    return Intl.message(
      'Hello World',
      name: 'defaultDrawerTitle',
      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
  }

  String get userLoginDrawerTitle {
    return Intl.message(
      'Hello World',
      name: 'userLoginDrawerTitle',
      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
  }

  String get uploadAdsTextAtDrawer {
    return Intl.message(
      'Hello World',
      name: 'uploadAdsTextAtDrawer',
      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
  }

  String get instant12hrsAds {
    return Intl.message(
      'Hello World',
      name: 'instant12hrsAds',
      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
  }


  String get forAWeekAds {
    return Intl.message(
      'Hello World',
      name: 'forAWeekAds',
      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
  }

}
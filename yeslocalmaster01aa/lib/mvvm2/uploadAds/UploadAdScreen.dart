import 'package:flutter/material.dart';
import 'package:yeslocalmarket01aa/intl15/MyAdsLocalization.dart';
import 'package:yeslocalmarket01aa/mvvm2/modelDTO/userInfo.dart';
import 'package:intl/intl.dart';

void main() {
  runApp(MaterialApp(
    home: UploadAds_cl(),
  ));
}

class UploadAds_cl extends StatefulWidget {
  UserInfo_cl userInfo_vb;
  UploadAds_cl({this.userInfo_vb});
  @override
  _State_cl createState() => _State_cl(this.userInfo_vb);
}
class _State_cl extends State<UploadAds_cl> {
  UserInfo_cl userInfo_vb;


  final GlobalKey<ScaffoldState> _AppBarScaffoldKey_vb = new GlobalKey<ScaffoldState>();
  var _controller_vb = ScrollController();
  _State_cl(userInfo_vb){
    this.userInfo_vb=userInfo_vb;
  }

  @override
  void initState() {

  }
  @override
  Widget build(BuildContext context) {
    var deviceSize_vb = MediaQuery.of(context).size;
    return Scaffold(
      backgroundColor: Colors.blue[50],
      key: _AppBarScaffoldKey_vb,
      body: CustomScrollView(
        controller: _controller_vb,
        physics: const BouncingScrollPhysics(),
        slivers: <Widget>[
          SliverAppBar(
            backgroundColor: Colors.blueAccent,
            title: Text(uploadMyAdHeading,
              style: TextStyle(
                fontSize: deviceSize_vb.height * 0.15*.18,
                color: Colors.white,
              ),),
            floating: false,
            //snap: true,
            pinned: true,
            //stretch: true,
            onStretchTrigger: () {
              // Function callback for stretch
              return;
            },
            expandedHeight: deviceSize_vb.height * 0.15*.44,
          ),
          supportContent(),
        ],
      ),
    );
  }

  Widget supportContent() {
   return SliverToBoxAdapter(
        child: Column(
          children: <Widget>[
            Padding(
              padding: const EdgeInsets.fromLTRB(26.0, 26.0, 28.0, 26.0),
            ),
            Text(textPara1,
                textAlign: TextAlign.center,
                style: TextStyle(
                color: Colors.black,
                fontWeight: FontWeight.w300,
                fontSize: MediaQuery.of(context).size.height *.1 * .3
              ),
            ),
            Padding(
              padding: const EdgeInsets.fromLTRB(26.0, 26.0, 28.0, 26.0),
            ),
            Text(textPara2,
              textAlign: TextAlign.center,
              style: TextStyle(
                  color: Colors.black,
                  fontWeight: FontWeight.w300,
                  fontSize: MediaQuery.of(context).size.height *.1 * .3
              ),
            ),
            Padding(
              padding: const EdgeInsets.fromLTRB(26.0, 26.0, 28.0, 26.0),
            ),
            Text(textPara3,
              textAlign: TextAlign.center,
              style: TextStyle(
                  color: Colors.black,
                  fontWeight: FontWeight.w300,
                  fontSize: MediaQuery.of(context).size.height *.1 * .3
              ),
            ),
   ]));
  }

  String get uploadMyAdHeading {
    return Intl.message(
      'Hello World',
      name: 'uploadMyAdHeading',
      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
  }

  String get textPara1 {
    return Intl.message(
      'Hello World',
      name: 'uploadMyAd_textPara_1',
      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
  }
  String get textPara2 {
    return Intl.message(
      'Hello World',
      name: 'uploadMyAd_textPara_2',
      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
  }
  String get textPara3 {
    return Intl.message(
      'Hello World',
      name: 'uploadMyAd_textPara_3',
      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );
  }
}
import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:yeslocalmarket01aa/mvvm2/apikey/ApiKeyNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAds/FetchAdsNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAdsCategory/FetchAdsCategoryNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/loadLikedAds/LoadLikedAdsNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/saveAds/SaveAdsResultVMNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/screens/joint_ads_screen_sliver.dart';
import 'package:provider/provider.dart';

import 'package:yeslocalmarket01aa/intl15/MyAdsLocalization.dart';

//import '/fetchAdsCategory/FetchAdsCategoryNotifier.dart';
//https://github.com/PuzzleLeaf/flutter_mvvm_tutorial

void main() => runApp(MvvmNews_cl());

class MvvmNews_cl extends StatelessWidget {
  // This widget is the root of application.
  @override
  Widget build(BuildContext context_vb) {
    return MaterialApp(
        localizationsDelegates: [
          const MyAdsLocalizationsDelegate_cl(),
          GlobalMaterialLocalizations.delegate,
          GlobalWidgetsLocalizations.delegate,
          GlobalCupertinoLocalizations.delegate,
        ],

        supportedLocales: [
          const Locale('en', 'US'),const Locale('as', 'IN'), // Assamese
          const Locale('bng', 'IN'),const Locale('bh', 'IN'),
          const Locale('gu', 'IN'),const Locale('hi', 'IN'),const Locale('kn', 'IN'),
          const Locale('ks', 'IN'),const Locale('ml', 'IN'),const Locale('mr', 'IN'),
          const Locale('or', 'IN'),const Locale('pa', 'IN'),const Locale('sa', 'IN'),
          const Locale('sd', 'IN'),const Locale('ta', 'IN'),const Locale('te', 'IN'),
          // ... other locales the app supports
        ],

        debugShowCheckedModeBanner: false,
        title: "Shop Say",
        theme: ThemeData(
          scaffoldBackgroundColor: Color(0xffFEFDFD),
          appBarTheme: AppBarTheme(
            color: Color(0xffFEFDFD),
            elevation: 0,
            textTheme: TextTheme(
              headline1: TextStyle(
                color: Colors.orange,
                fontWeight: FontWeight.bold,

              ),
            ),
            iconTheme: IconThemeData(
              color: Colors.black,
            ),
            actionsIconTheme: IconThemeData(
              color: Colors.black,
            ),
          ),
        ),
        home: MultiProvider(
          providers: [
            ChangeNotifierProvider(
              create: (_) => FetchAdsNotifier_cl(),
            ),
            ChangeNotifierProvider(
              create: (_) => LoadLikedAdsNotifier_cl(),
            ),
            ChangeNotifierProvider(
              create: (_) => SaveAdsResultVMNotifier_cl(),
            ),
            ChangeNotifierProvider(
              create: (_) => ApiKeyNotifier_cl(),
            ),
            ChangeNotifierProvider(
              create: (_) => FetchAdsCategoryNotifier_cl(),
            ),
          ],
          child: JointAdsGridListScreenSliver_cl(),
        ));
  }
}
/*
Show my liked ads,Show ads that I own
Show "That's All" message at the end


 */
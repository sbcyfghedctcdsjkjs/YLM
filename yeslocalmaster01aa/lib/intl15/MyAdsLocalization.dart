
// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// A simple example of localizing a Flutter app written with the
// Dart intl package (see https://pub.dartlang.org/packages/intl).
//
// Spanish and English (locale language codes 'en' and 'es') are
// supported.

// The pubspec.yaml file must include flutter_localizations and the
// Dart intl packages in its dependencies section. For example:
//
// dependencies:
//   flutter:
//   sdk: flutter
//  flutter_localizations:
//    sdk: flutter
//  intl: 0.15.1
//  intl_translation: 0.15.0

// If you run this app with the device's locale set to anything but
// English or Spanish, the app's locale will be English. If you
// set the device's locale to Spanish, the app's locale will be
// Spanish.

import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:intl/intl.dart';

// This file was generated in two steps, using the Dart intl tools. With the
// app's root directory (the one that contains pubspec.yaml) as the current
// directory:
//
// flutter pub get
// flutter pub pub run intl_translation:extract_to_arb --output-dir=lib/l10n lib/main.dart
// flutter pub pub run intl_translation:generate_from_arb --output-dir=lib/l10n --no-use-deferred-loading lib/main.dart lib/l10n/intl_*.arb
//
// The second command generates intl_messages.arb and the third generates
// messages_all.dart. There's more about this process in
// https://pub.dev/packages/intl.
import 'package:yeslocalmarket01aa/generated/intl/messages_all.dart';

class MyAdsLocalizations_cl {
  MyAdsLocalizations_cl(this.localeName_vb);

  static Future<MyAdsLocalizations_cl> load_mt(Locale locale_vb) {
    final String name = locale_vb.countryCode.isEmpty ? locale_vb.languageCode : locale_vb.toString();
    final String localeName_vb = Intl.canonicalizedLocale(name);

    return initializeMessages(localeName_vb).then((_) {
      return MyAdsLocalizations_cl(localeName_vb);
    });
  }

  static MyAdsLocalizations_cl of(BuildContext context_vb) {
    return Localizations.of<MyAdsLocalizations_cl>(context_vb, MyAdsLocalizations_cl);
  }

  String get myAdsLocaleName_mt {
    return localeName_vb;
  }

  final String localeName_vb;

  String get sampleAddressFormat {
    return Intl.message(
      'Hello World',
      name: 'sampleAddressFormat',
      desc: 'Title for the Demo application',
      locale: localeName_vb,
    );
  }
}

class MyAdsLocalizationsDelegate_cl extends LocalizationsDelegate<MyAdsLocalizations_cl> {
  const MyAdsLocalizationsDelegate_cl();

  @override
  bool isSupported(Locale locale_vb) => ['en','as','bn','bh','gu','hi',
                                      'kn','ks','ml', 'mr','or', 'pa',
                                      'sa','sd', 'ta', 'te'].contains(locale_vb.languageCode);

  @override
  Future<MyAdsLocalizations_cl> load(Locale locale_vb) => MyAdsLocalizations_cl.load_mt(locale_vb);

  @override
  bool shouldReload(MyAdsLocalizationsDelegate_cl old) => false;
}

class DemoApp extends StatelessWidget {
  @override
  Widget build(BuildContext context_vb) {
    return Scaffold(
      appBar: AppBar(
        title: Text(MyAdsLocalizations_cl.of(context_vb).sampleAddressFormat),
      ),
      body: Center(
        child: Text(MyAdsLocalizations_cl.of(context_vb).sampleAddressFormat),
      ),
    );
  }
}

//class Demo extends StatelessWidget {
//  @override
//  Widget build(BuildContext context) {
//    return MaterialApp(
//      onGenerateTitle: (BuildContext context) => MyAdsLocalizations.of(context).sampleAddressFormat,
//      localizationsDelegates: [
//        const MyAdsLocalizationsDelegate(),
//        GlobalMaterialLocalizations.delegate,
//        GlobalWidgetsLocalizations.delegate,
//      ],
//      supportedLocales: [
//        const Locale('en', ''),
//        const Locale('hi', ''),
//      ],
//      // Watch out: MaterialApp creates a Localizations widget
//      // with the specified delegates. MyAdsLocalizations.of()
//      // will only find the app's Localizations widget if its
//      // context is a child of the app.
//      home: DemoApp(),
//    );
//  }
//}
//
//void main() {
//  runApp(Demo());
//}
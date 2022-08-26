// GENERATED CODE - DO NOT MODIFY BY HAND
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'intl/messages_all.dart';

// **************************************************************************
// Generator: Flutter Intl IDE plugin
// Made by Localizely
// **************************************************************************

// ignore_for_file: non_constant_identifier_names, lines_longer_than_80_chars
// ignore_for_file: join_return_with_assignment, prefer_final_in_for_each
// ignore_for_file: avoid_redundant_argument_values

class S {
  S();
  
  static S current;
  
  static const AppLocalizationDelegate delegate =
    AppLocalizationDelegate();

  static Future<S> load(Locale locale) {
    final name = (locale.countryCode?.isEmpty ?? false) ? locale.languageCode : locale.toString();
    final localeName = Intl.canonicalizedLocale(name); 
    return initializeMessages(localeName).then((_) {
      Intl.defaultLocale = localeName;
      S.current = S();
      
      return S.current;
    });
  } 

  static S of(BuildContext context) {
    return Localizations.of<S>(context, S);
  }

  /// `local,city,state`
  String get sampleAddressFormat {
    return Intl.message(
      'local,city,state',
      name: 'sampleAddressFormat',
      desc: '',
      args: [],
    );
  }

  /// `No result found`
  String get noResFound {
    return Intl.message(
      'No result found',
      name: 'noResFound',
      desc: '',
      args: [],
    );
  }

  /// `Logout`
  String get logoutText {
    return Intl.message(
      'Logout',
      name: 'logoutText',
      desc: '',
      args: [],
    );
  }

  /// `Login`
  String get loginText {
    return Intl.message(
      'Login',
      name: 'loginText',
      desc: '',
      args: [],
    );
  }

  /// `Register`
  String get regsiterText {
    return Intl.message(
      'Register',
      name: 'regsiterText',
      desc: '',
      args: [],
    );
  }

  /// ``
  String get loginScreenTitle {
    return Intl.message(
      '',
      name: 'loginScreenTitle',
      desc: '',
      args: [],
    );
  }

  /// `3-Digit Secret Number*`
  String get secretNumber {
    return Intl.message(
      '3-Digit Secret Number*',
      name: 'secretNumber',
      desc: '',
      args: [],
    );
  }

  /// `Phone`
  String get phone {
    return Intl.message(
      'Phone',
      name: 'phone',
      desc: '',
      args: [],
    );
  }

  /// `Email`
  String get email {
    return Intl.message(
      'Email',
      name: 'email',
      desc: '',
      args: [],
    );
  }

  /// `Submit/Login`
  String get loginSubmit {
    return Intl.message(
      'Submit/Login',
      name: 'loginSubmit',
      desc: '',
      args: [],
    );
  }

  /// `Type Location`
  String get startSearching {
    return Intl.message(
      'Type Location',
      name: 'startSearching',
      desc: '',
      args: [],
    );
  }

  /// `Ads Entering`
  String get defaultDrawerTitle {
    return Intl.message(
      'Ads Entering',
      name: 'defaultDrawerTitle',
      desc: '',
      args: [],
    );
  }

  /// `Hello\nWelcome `
  String get userLoginDrawerTitle {
    return Intl.message(
      'Hello\nWelcome ',
      name: 'userLoginDrawerTitle',
      desc: '',
      args: [],
    );
  }

  /// `Upload Ads`
  String get uploadAdsTextAtDrawer {
    return Intl.message(
      'Upload Ads',
      name: 'uploadAdsTextAtDrawer',
      desc: '',
      args: [],
    );
  }

  /// `Register New User`
  String get RegisterAdViewer_heading_RegisterNewUser {
    return Intl.message(
      'Register New User',
      name: 'RegisterAdViewer_heading_RegisterNewUser',
      desc: '',
      args: [],
    );
  }

  /// `Phone`
  String get RegisterAdViewer_label_phone {
    return Intl.message(
      'Phone',
      name: 'RegisterAdViewer_label_phone',
      desc: '',
      args: [],
    );
  }

  /// `OR`
  String get RegisterAdViewer_label_or {
    return Intl.message(
      'OR',
      name: 'RegisterAdViewer_label_or',
      desc: '',
      args: [],
    );
  }

  /// `Email`
  String get RegisterAdViewer_label_email {
    return Intl.message(
      'Email',
      name: 'RegisterAdViewer_label_email',
      desc: '',
      args: [],
    );
  }

  /// `Password cannot be empty`
  String get RegisterAdViewer_msg_pwdIsEmpty {
    return Intl.message(
      'Password cannot be empty',
      name: 'RegisterAdViewer_msg_pwdIsEmpty',
      desc: '',
      args: [],
    );
  }

  /// `3-Digit Secret Number*`
  String get RegisterAdViewer_label_secretNumber {
    return Intl.message(
      '3-Digit Secret Number*',
      name: 'RegisterAdViewer_label_secretNumber',
      desc: '',
      args: [],
    );
  }

  /// `Submit / Register`
  String get RegisterAdViewer_label_submit {
    return Intl.message(
      'Submit / Register',
      name: 'RegisterAdViewer_label_submit',
      desc: '',
      args: [],
    );
  }

  /// `Already a registered User? >>`
  String get RegisterAdViewer_label_alreadyAUser {
    return Intl.message(
      'Already a registered User? >>',
      name: 'RegisterAdViewer_label_alreadyAUser',
      desc: '',
      args: [],
    );
  }

  /// `Login`
  String get RegisterAdViewer_label_login {
    return Intl.message(
      'Login',
      name: 'RegisterAdViewer_label_login',
      desc: '',
      args: [],
    );
  }

  /// `Phone or Email is required.`
  String get RegisterAdViewer_msg_phoneEmailIsRequired {
    return Intl.message(
      'Phone or Email is required.',
      name: 'RegisterAdViewer_msg_phoneEmailIsRequired',
      desc: '',
      args: [],
    );
  }

  /// `3 digit secret number is required`
  String get RegisterAdViewer_msg_secretNumIsRequired {
    return Intl.message(
      '3 digit secret number is required',
      name: 'RegisterAdViewer_msg_secretNumIsRequired',
      desc: '',
      args: [],
    );
  }

  /// `Phone/Email already exist`
  String get RegisterAdViewer_msg_phoneEmailAlreadyExist {
    return Intl.message(
      'Phone/Email already exist',
      name: 'RegisterAdViewer_msg_phoneEmailAlreadyExist',
      desc: '',
      args: [],
    );
  }

  /// `Login`
  String get LoginAdViewer_heading_loginScreenTitle {
    return Intl.message(
      'Login',
      name: 'LoginAdViewer_heading_loginScreenTitle',
      desc: '',
      args: [],
    );
  }

  /// `Phone`
  String get LoginAdViewer_label_phone {
    return Intl.message(
      'Phone',
      name: 'LoginAdViewer_label_phone',
      desc: '',
      args: [],
    );
  }

  /// `OR`
  String get LoginAdViewer_label_or {
    return Intl.message(
      'OR',
      name: 'LoginAdViewer_label_or',
      desc: '',
      args: [],
    );
  }

  /// `Email`
  String get LoginAdViewer_label_email {
    return Intl.message(
      'Email',
      name: 'LoginAdViewer_label_email',
      desc: '',
      args: [],
    );
  }

  /// `Password cannot be empty`
  String get LoginAdViewer_label_pwdIsEmpty {
    return Intl.message(
      'Password cannot be empty',
      name: 'LoginAdViewer_label_pwdIsEmpty',
      desc: '',
      args: [],
    );
  }

  /// `3-Digit Secret Number*`
  String get LoginAdViewer_label_secretNumber {
    return Intl.message(
      '3-Digit Secret Number*',
      name: 'LoginAdViewer_label_secretNumber',
      desc: '',
      args: [],
    );
  }

  /// `Login`
  String get LoginAdViewer_label_loginSubmit {
    return Intl.message(
      'Login',
      name: 'LoginAdViewer_label_loginSubmit',
      desc: '',
      args: [],
    );
  }

  /// `New User? >>`
  String get LoginAdViewer_label_rUnewUser {
    return Intl.message(
      'New User? >>',
      name: 'LoginAdViewer_label_rUnewUser',
      desc: '',
      args: [],
    );
  }

  /// `Register`
  String get LoginAdViewer_label_register {
    return Intl.message(
      'Register',
      name: 'LoginAdViewer_label_register',
      desc: '',
      args: [],
    );
  }

  /// `Phone or Email is required.`
  String get LoginAdViewer_msg_phoneIsRequired {
    return Intl.message(
      'Phone or Email is required.',
      name: 'LoginAdViewer_msg_phoneIsRequired',
      desc: '',
      args: [],
    );
  }

  /// `3 digit secret number is required`
  String get LoginAdViewer_msg_secretNumIsRequired {
    return Intl.message(
      '3 digit secret number is required',
      name: 'LoginAdViewer_msg_secretNumIsRequired',
      desc: '',
      args: [],
    );
  }

  /// `Please give correct information`
  String get LoginAdViewer_msg_phoneNumIsWrong {
    return Intl.message(
      'Please give correct information',
      name: 'LoginAdViewer_msg_phoneNumIsWrong',
      desc: '',
      args: [],
    );
  }

  /// `Please give correct information`
  String get LoginAdViewer_msg_secretNumIsWrong {
    return Intl.message(
      'Please give correct information',
      name: 'LoginAdViewer_msg_secretNumIsWrong',
      desc: '',
      args: [],
    );
  }

  /// `Login required`
  String get ads_list_insta_loginRequired {
    return Intl.message(
      'Login required',
      name: 'ads_list_insta_loginRequired',
      desc: '',
      args: [],
    );
  }

  /// `Instant Ads\n(Don't Miss...)`
  String get instant12hrsAds {
    return Intl.message(
      'Instant Ads\n(Don\'t Miss...)',
      name: 'instant12hrsAds',
      desc: '',
      args: [],
    );
  }

  /// `Plan Weekend around this... `
  String get forAWeekAds {
    return Intl.message(
      'Plan Weekend around this... ',
      name: 'forAWeekAds',
      desc: '',
      args: [],
    );
  }

  /// `See All Category`
  String get seeAllCategoryMenuText {
    return Intl.message(
      'See All Category',
      name: 'seeAllCategoryMenuText',
      desc: '',
      args: [],
    );
  }

  /// `All Category`
  String get all_category_screen_heading {
    return Intl.message(
      'All Category',
      name: 'all_category_screen_heading',
      desc: '',
      args: [],
    );
  }

  /// `My Ads`
  String get drawer_ownerSeeHisOwnAdsText {
    return Intl.message(
      'My Ads',
      name: 'drawer_ownerSeeHisOwnAdsText',
      desc: '',
      args: [],
    );
  }

  /// `That's all. Thanks`
  String get thatIsAllFolks {
    return Intl.message(
      'That\'s all. Thanks',
      name: 'thatIsAllFolks',
      desc: '',
      args: [],
    );
  }

  /// `Ads I Own`
  String get myOwnAds_heading {
    return Intl.message(
      'Ads I Own',
      name: 'myOwnAds_heading',
      desc: '',
      args: [],
    );
  }

  /// `Yes Local`
  String get app_name_loadscreen {
    return Intl.message(
      'Yes Local',
      name: 'app_name_loadscreen',
      desc: '',
      args: [],
    );
  }

  /// `Market`
  String get app_name_loadscreen2 {
    return Intl.message(
      'Market',
      name: 'app_name_loadscreen2',
      desc: '',
      args: [],
    );
  }

  /// `Upload My Ad`
  String get uploadMyAdHeading {
    return Intl.message(
      'Upload My Ad',
      name: 'uploadMyAdHeading',
      desc: '',
      args: [],
    );
  }

  /// `My Ad`
  String get showAllMyAdHeading {
    return Intl.message(
      'My Ad',
      name: 'showAllMyAdHeading',
      desc: '',
      args: [],
    );
  }

  /// `Please send Hello to:`
  String get uploadMyAd_textPara_1 {
    return Intl.message(
      'Please send Hello to:',
      name: 'uploadMyAd_textPara_1',
      desc: '',
      args: [],
    );
  }

  /// `contact@yeslocalmarket.com`
  String get uploadMyAd_textPara_2 {
    return Intl.message(
      'contact@yeslocalmarket.com',
      name: 'uploadMyAd_textPara_2',
      desc: '',
      args: [],
    );
  }

  /// `And we will contact you back, so your business will be online in one day`
  String get uploadMyAd_textPara_3 {
    return Intl.message(
      'And we will contact you back, so your business will be online in one day',
      name: 'uploadMyAd_textPara_3',
      desc: '',
      args: [],
    );
  }
}

class AppLocalizationDelegate extends LocalizationsDelegate<S> {
  const AppLocalizationDelegate();

  List<Locale> get supportedLocales {
    return const <Locale>[
      Locale.fromSubtags(languageCode: 'en'),
      Locale.fromSubtags(languageCode: 'bng'),
      Locale.fromSubtags(languageCode: 'gj'),
      Locale.fromSubtags(languageCode: 'hi'),
      Locale.fromSubtags(languageCode: 'kn'),
      Locale.fromSubtags(languageCode: 'ml'),
      Locale.fromSubtags(languageCode: 'mr'),
      Locale.fromSubtags(languageCode: 'pa'),
      Locale.fromSubtags(languageCode: 'ta'),
      Locale.fromSubtags(languageCode: 'te'),
      Locale.fromSubtags(languageCode: 'ur'),
    ];
  }

  @override
  bool isSupported(Locale locale) => _isSupported(locale);
  @override
  Future<S> load(Locale locale) => S.load(locale);
  @override
  bool shouldReload(AppLocalizationDelegate old) => false;

  bool _isSupported(Locale locale) {
    if (locale != null) {
      for (var supportedLocale in supportedLocales) {
        if (supportedLocale.languageCode == locale.languageCode) {
          return true;
        }
      }
    }
    return false;
  }
}
import 'package:flutter/material.dart';
import 'package:yeslocalmarket01aa/intl15/MyAdsLocalization.dart';
import 'package:yeslocalmarket01aa/mvvm2/auth/RegisterAdViewer.dart';
import 'package:yeslocalmarket01aa/mvvm2/loadLikedAds/LoadLikedAdsNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/modelDTO/userInfo.dart';
import 'package:provider/provider.dart';

import 'AuthWebService.dart';
import 'package:intl/intl.dart';


void main() {
  runApp(MaterialApp(
    home: LoginAdViewer_cl(),
  ));
}

class LoginAdViewer_cl extends StatefulWidget {
  UserInfo_cl userInfo_vb;
  LoginAdViewer_cl({this.userInfo_vb});

  @override
  _LoginState_cl createState() => _LoginState_cl(this.userInfo_vb);
}

class _LoginState_cl extends State<LoginAdViewer_cl> {
  bool emailEnable_vb=false;
  bool phoneEnable_vb=false;
  UserInfo_cl userInfo_vb;
  _LoginState_cl(userInfo1_vb)
  {
    userInfo_vb =userInfo1_vb;
  }

  TextEditingController phoneController_vb = TextEditingController();
  TextEditingController emailController_vb = TextEditingController();
  TextEditingController passwordController_vb = TextEditingController();
  TextEditingController error_vb = TextEditingController();
//  String get loginScreenTitle {
//    return Intl.message(
//      'Hello World',
//
//      name: 'loginScreenTitle',
//      args: [],
//      desc: 'Title for the Demo application',
//      locale: MyAdsLocalizations.of(context).myAdsLocaleName,
//    );
//
//  }

  String labelsTextI10n_mt(String label_vb) {
    return Intl.message(
      'Hello World',

      name: '$label_vb',
      args: [],
      desc: 'Title for the Demo application',
      locale: MyAdsLocalizations_cl.of(context).myAdsLocaleName_mt,
    );

  }


  @override
  Widget build(BuildContext context) {
    var deviceSize_vb = MediaQuery.of(context).size;
    return Scaffold(
        appBar: AppBar(
          iconTheme:  IconThemeData(
            size: deviceSize_vb.height *.2 * .4,
            color: Colors.blue,
          ),

        ),
        body: Padding(
            padding: EdgeInsets.all(10),
            child: ListView(
              children: <Widget>[
                Container(
                    alignment: Alignment.center,
                    padding: EdgeInsets.all(10),
                    child: Text(
                      labelsTextI10n_mt("LoginAdViewer_heading_loginScreenTitle"),//loginScreenTitle,
                      style: TextStyle(
                          color: Colors.blue,
                          fontWeight: FontWeight.w200,
                          fontSize: deviceSize_vb.height *.1 * 1),
                    )),
                Container(
                  padding: EdgeInsets.all(10),
                  child: new TextFormField(
                    maxLines: 1,
                    maxLength: 10,
                    style: TextStyle(
                        color: Colors.blue,
                        fontWeight: FontWeight.w300,
                        fontSize: deviceSize_vb.height *.1 * .3

                    ),
                    keyboardType: TextInputType.phone,
                    controller: phoneController_vb,
                    autofocus: false,
                    //enabled: phoneEnable,
                    onChanged: (text){
                      //emailEnable=false;
                      emailController_vb.text="";
                      setState(() {

                      });
                    },
                    decoration: new InputDecoration(
                        counterStyle: TextStyle(
                            color: Colors.blue,
                            fontWeight: FontWeight.w300,
                            fontSize: deviceSize_vb.height *.1 * .2
                        ),
                        hintStyle:  TextStyle(
                            color: Colors.blue,
                            fontWeight: FontWeight.w300,
                            fontSize: deviceSize_vb.height *.1 * .3
                        ),
                        hintText: labelsTextI10n_mt("LoginAdViewer_label_phone"),
                        icon: new Icon(
                          Icons.phone,
                          color: Colors.grey,
                          size: deviceSize_vb.height *.1 * .3
                        )),
                    //validator: (value) => value.isEmpty ? 'Phone can\'t be empty' : null,
                    //onSaved: (value) => _email = value.trim(),
                  ),
                ),
                Container(
                  padding: EdgeInsets.all(5),

                  child: new Text(
                      labelsTextI10n_mt("LoginAdViewer_label_or"),
                      style: TextStyle(
                        color: Colors.grey,
                        fontSize: deviceSize_vb.height *.1 * .3,
                      ),
                   ),
                ),
                Container(
                  padding: EdgeInsets.all(10),
                  child: new TextFormField(

                    maxLines: 1,
                    maxLength: 20,
                    style: TextStyle(
                        color: Colors.blue,
                        fontWeight: FontWeight.w300,
                        fontSize: deviceSize_vb.height *.1 * .3

                    ),
                    keyboardType: TextInputType.emailAddress,
                    controller: emailController_vb,
                    autofocus: false,
                    //enabled: emailEnable,
                    onChanged: (text){
                      //phoneEnable=false;
                      phoneController_vb.text="";
                      setState(() {

                      });
                    },
                    decoration: new InputDecoration(
                        counterStyle: TextStyle(
                            color: Colors.blue,
                            fontWeight: FontWeight.w300,
                            fontSize: deviceSize_vb.height *.1 * .2
                        ),
                        hintStyle:  TextStyle(
                            color: Colors.blue,
                            fontWeight: FontWeight.w300,
                            fontSize: deviceSize_vb.height *.1 * .3
                        ),
                        hintText: labelsTextI10n_mt("LoginAdViewer_label_email"),
                        icon: new Icon(
                          Icons.mail,
                          color: Colors.grey,
                          size: deviceSize_vb.height *.1 * .3
                        )),
                    //validator: (value) => value.isEmpty ? 'Email can\'t be empty' : null,
                    //onSaved: (value) => _email = value.trim(),
                  ),
                ),
                Container(
                  padding: EdgeInsets.fromLTRB(10, 10, 10, 0),
                  child: TextFormField(

                    obscureText: true,
                    maxLength: 3,
                    style: TextStyle(
                        color: Colors.blue,
                        fontWeight: FontWeight.w300,
                        fontSize: deviceSize_vb.height *.1 * .3

                    ),
                    controller: passwordController_vb,
                    validator: (value) => value.isEmpty ? labelsTextI10n_mt("LoginAdViewer_label_pwdIsEmpty") : null,
                    decoration: InputDecoration(
                      counterStyle: TextStyle(
                          color: Colors.blue,
                          fontWeight: FontWeight.w300,
                          fontSize: deviceSize_vb.height *.1 * .2
                      ),
                      hintStyle:  TextStyle(
                          color: Colors.blue,
                          fontWeight: FontWeight.w300,
                          fontSize: deviceSize_vb.height *.1 * .26
                      ),
                      border: OutlineInputBorder(),
                      labelText: labelsTextI10n_mt("LoginAdViewer_label_secretNumber"),
                    ),
                  ),
                ),
                FlatButton(
                    child: new Text(
                      error_vb.text ,
                      style: TextStyle(fontSize: deviceSize_vb.height *.1 * .26,
                          color: Colors.red,
                          height: 1.0,
                          fontWeight: FontWeight.w500),
                    )
                ),
                Container(
                    height: deviceSize_vb.height *.1 * .5,
                    padding: EdgeInsets.fromLTRB(10, 0, 10, 0),
                    child: RaisedButton(
                      textColor: Colors.white,
                      color: Colors.blue,
                      child: Text(
                          labelsTextI10n_mt("LoginAdViewer_label_loginSubmit"),
                          style: TextStyle(fontSize: deviceSize_vb.height *.1 * .3)
                      ),
                      onPressed: () {
                        validate_mt();
                        print(phoneController_vb.text);
                        print(emailController_vb.text);
                        print(passwordController_vb.text);
                        //Navigator.pop(context);
                      },
                    )),

                FlatButton(
                  onPressed: (){
                    //forgot password screen
                  },
                  textColor: Colors.blue,
                  child: Text('  '),
                ),
                Container(
                    child: Row(
                      children: <Widget>[
                        Text(
                          labelsTextI10n_mt("LoginAdViewer_label_rUnewUser"),
                          style: TextStyle(fontSize: deviceSize_vb.height *.1 * .26,color: Colors.green,),
                        ),
                        FlatButton(
                          textColor: Colors.blue,
                          child: Text(
                            labelsTextI10n_mt("LoginAdViewer_label_register"),
                            style: TextStyle(fontSize: deviceSize_vb.height *.1 * .3),
                          ),
                          onPressed: () {
                            Navigator.pop(context);
                            Navigator.push(
                              context,
                              MaterialPageRoute(builder: (context) => RegisterAdViewer_cl()),
                            );
                          },
                        )
                      ],
                      mainAxisAlignment: MainAxisAlignment.center,
                    ))
              ],
            )));
  }


  void validate_mt() {
    String _errorMessage_vb="";
    if(phoneController_vb.text.trim().isEmpty && emailController_vb.text.trim().isEmpty){
      _errorMessage_vb=labelsTextI10n_mt("LoginAdViewer_msg_phoneIsRequired");
    }
    else if (passwordController_vb.text.trim().isEmpty || passwordController_vb.text.trim().length < 3 ){
      _errorMessage_vb=labelsTextI10n_mt("LoginAdViewer_msg_secretNumIsRequired");
    }
    else _errorMessage_vb="";

    print("validate is called _errorMessage: "+ _errorMessage_vb);
    error_vb.text=_errorMessage_vb;
    setState(() {

    });

    if(!phoneController_vb.text.trim().isEmpty){
      loginByPhone_mt();
    } else if(!emailController_vb.text.trim().isEmpty){
      loginByEmail_mt();
    }

  }

  void loginByPhone_mt() async {
    UserInfo_cl validUser_vb = await AuthWebService_cl().
        loginByPhone_mt(phoneController_vb.text.trim(),
        passwordController_vb.text.trim());

    if(validUser_vb.userId_vb==null || validUser_vb.userId_vb.length < 1){
      error_vb.text=labelsTextI10n_mt("LoginAdViewer_msg_phoneNumIsWrong");

    }else{
      copyValuesFromLocalToWidget_mt(validUser_vb);
      Navigator.pop(context);
    }
    setState(() {});

  }

  void loginByEmail_mt() async {
    UserInfo_cl validUser_vb = await AuthWebService_cl().
    loginByEmail_mt(emailController_vb.text.trim(),
        passwordController_vb.text.trim());
    if(validUser_vb.userId_vb==null || validUser_vb.userId_vb.length < 1){
      error_vb.text=labelsTextI10n_mt("LoginAdViewer_msg_secretNumIsWrong");
      setState(() {});
    }else{

      copyValuesFromLocalToWidget_mt(validUser_vb);
      Navigator.pop(context);
    }
    setState(() {});
  }

  void copyValuesFromLocalToWidget_mt(UserInfo_cl validUser_vb) {
    this.widget.userInfo_vb.userId_vb=validUser_vb.userId_vb;

    this.widget.userInfo_vb.setIdR_mt=validUser_vb.userId_vb;

    this.widget.userInfo_vb.setIdOfLikedAds_mt=validUser_vb.getIdOfLikedAds_mt;
    this.widget.userInfo_vb.setLikedAdsAtOnLoad_mt=validUser_vb.getLikedAdsAtOnLoad_mt;
    this.widget.userInfo_vb.setLoginOutWait_mt("login");
  }
}
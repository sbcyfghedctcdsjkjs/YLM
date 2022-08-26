import 'package:flutter/material.dart';
import 'package:yeslocalmarket01aa/mvvm2/modelDTO/userInfo.dart';
import 'AuthWebService.dart';
import 'LoginAdViewer.dart';
import 'package:intl/intl.dart';
import 'package:yeslocalmarket01aa/intl15/MyAdsLocalization.dart';

void main() {
  runApp(MaterialApp(
    home: RegisterAdViewer_cl(),
  ));
}

class RegisterAdViewer_cl extends StatefulWidget {
  UserInfo_cl userInfo_vb;
  RegisterAdViewer_cl({this.userInfo_vb});



  @override
  _State_cl createState() => _State_cl();
}

class _State_cl extends State<RegisterAdViewer_cl> {
  TextEditingController phoneController_vb = TextEditingController();
  TextEditingController emailController_vb = TextEditingController();
  TextEditingController passwordController_vb = TextEditingController();
  TextEditingController error_vb = TextEditingController();

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
                      labelsTextI10n_mt('RegisterAdViewer_heading_RegisterNewUser'),
                      style: TextStyle(
                          color: Colors.blue,
                          fontWeight: FontWeight.w300,
                          fontSize: deviceSize_vb.height *.1 * .5),
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
                        hintText: labelsTextI10n_mt('RegisterAdViewer_label_phone'),
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
                      labelsTextI10n_mt('RegisterAdViewer_label_or'),
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
                        hintText: labelsTextI10n_mt('RegisterAdViewer_label_email'),
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
                    style: TextStyle(
                        color: Colors.blue,
                        fontWeight: FontWeight.w300,
                        fontSize: deviceSize_vb.height *.1 * .3

                    ),
                    controller: passwordController_vb,
                    validator: (value) => value.isEmpty ? labelsTextI10n_mt('RegisterAdViewer_msg_pwdIsEmpty') : null,
                    maxLength: 3,
                    decoration: InputDecoration(
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
                      border: OutlineInputBorder(),

                      labelText: labelsTextI10n_mt('RegisterAdViewer_label_secretNumber'),
                    ),
                  ),
                ),
                FlatButton(
                    child: new Text(
                      error_vb.text ,
                      style: TextStyle(fontSize: deviceSize_vb.height *.1 * .3,
                          color: Colors.red,
                          height: 1.0,
                          fontWeight: FontWeight.w300),
                    )
                ),
                Container(
                    height: deviceSize_vb.height *.1 * .5,
                    padding: EdgeInsets.fromLTRB(10, 0, 10, 0),
                    child: RaisedButton(
                      textColor: Colors.white,
                      color: Colors.blue,
                      child: Text(
                          labelsTextI10n_mt('RegisterAdViewer_label_submit'),
                          style: TextStyle(fontSize: deviceSize_vb.height *.1 * .3)
                      ),
                      onPressed: () {
                        validate_mt();
//                        print(phoneController.text);
//                        print(emailController.text);
//                        print(passwordController.text);
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
                          labelsTextI10n_mt("RegisterAdViewer_label_alreadyAUser"),
                          style: TextStyle(
                              fontSize: deviceSize_vb.height *.1 * .26,
                              color: Colors.green,
                          ),

                        ),
                        FlatButton(
                          textColor: Colors.blue,
                          child: Text(
                            labelsTextI10n_mt('RegisterAdViewer_label_login'),
                            style: TextStyle(fontSize: deviceSize_vb.height *.1 * .3),
                          ),
                          onPressed: () {
                            Navigator.pop(context);
                            Navigator.push(
                              context,
                              MaterialPageRoute(builder: (context) => LoginAdViewer_cl()),
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
    String _errorMessage="";
    if(phoneController_vb.text.trim().isEmpty && emailController_vb.text.trim().isEmpty){
      _errorMessage=labelsTextI10n_mt('RegisterAdViewer_msg_phoneEmailIsRequired');
    }
    else if (passwordController_vb.text.trim().isEmpty || passwordController_vb.text.trim().length < 3 ){
      _errorMessage=labelsTextI10n_mt('RegisterAdViewer_msg_secretNumIsRequired');
    }
    else _errorMessage="";

    //print("validate is called _errorMessage: "+ _errorMessage);
    error_vb.text=_errorMessage;
    setState(() {

    });

    saveNewUser_mt();
  }



  void saveNewUser_mt() async {
    UserInfo_cl newUser = await AuthWebService_cl().
                                registerNewUser_mt(phoneController_vb.text.trim(),
                                                emailController_vb.text.trim(),
                                                passwordController_vb.text.trim());

    if(newUser.userId_vb==null || newUser.userId_vb.length < 1){
      error_vb.text=labelsTextI10n_mt("RegisterAdViewer_msg_phoneEmailAlreadyExist");
      setState(() {});
    }else{
      newUser.setIdR_mt=newUser.userId_vb;
      this.widget.userInfo_vb=newUser;
      Navigator.pop(context);
    }
    setState(() {});
  }


}
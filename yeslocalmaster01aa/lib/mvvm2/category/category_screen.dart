import 'package:flutter/material.dart';
import 'package:yeslocalmarket01aa/mvvm2/customIcons/categoryCheckBox.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAdsCategory/FetchAdsCategoryNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAdsCategory/FetchAdsCategoryViewModel.dart';
import 'package:yeslocalmarket01aa/mvvm2/modelDTO/userInfo.dart';

import 'package:intl/intl.dart';
import 'package:yeslocalmarket01aa/intl15/MyAdsLocalization.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(MaterialApp(
    home: CategoryScreen_cl(),
  ));
}





class CategoryScreen_cl extends StatefulWidget {
  UserInfo_cl userInfo_vb;

  CategoryScreen_cl({this.userInfo_vb});
  @override
  _State_cl createState() => _State_cl(this.userInfo_vb);
}

class _State_cl extends State<CategoryScreen_cl> {
  TextEditingController phoneController_vb = TextEditingController();
  TextEditingController emailController_vb = TextEditingController();
  TextEditingController passwordController_vb = TextEditingController();
  TextEditingController error_vb = TextEditingController();
  UserInfo_cl userInfo_vb;
  List<FetchAdsCatgeoryViewModel_cl> categoryVMList=null;
  _State_cl(userInfo_vb){
    this.userInfo_vb=userInfo_vb;
  }


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
    this.categoryVMList= this.userInfo_vb.getAdsCategoryVMList_mt;//Provider.of<FetchAdsCategoryNotifier_cl>(context, listen: false).myAdsCategoryVMList_vb;
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
              children: createCategoryByType_mt(),
            )));
  }

  List<Widget> createCategoryByType_mt(){
    List<Widget> lw1 =[];//new List<Widget>();

    var deviceSize_vb = MediaQuery.of(context).size;
    lw1.add(Container(
        alignment: Alignment.center,
        padding: EdgeInsets.all(10),

        child: Text(
          labelsTextI10n_mt('all_category_screen_heading'),
          style: TextStyle(
              color: Colors.blue,
              fontWeight: FontWeight.w300,
              fontSize: deviceSize_vb.height *.1 * .5),
        )));
    int n=4;

    while(n<this.categoryVMList.length)
    {
      lw1.add(
          Container(
              alignment: Alignment.center,
              padding: EdgeInsets.fromLTRB(0, 0, 0, 0),
              margin: EdgeInsets.fromLTRB(0, 0, 0, 0),
              child: CategoryCheckBox_cl(
                selected_vb: false,
                index_vb: n,
                id_vb: this.categoryVMList[n].id_mt,
                onChanged: categoryByTypeCheckBoxClicked_mt,
                categoryName_vb: this.categoryVMList[n].categoryName_mt,
                checkedIdList_vb: this.userInfo_vb.getCategoryByTypeIdList_mt==null ? ",":this.userInfo_vb.getCategoryByTypeIdList_mt,
                //selected: false,
              )



          ));

      n++;
    }
    return lw1;
  }

  void categoryByTypeCheckBoxClicked_mt(String id_vb,int index_vb,bool flag){
    //createTop4Category_mt()[index_vb].
    String categorySelected_vb=this.userInfo_vb.getCategoryByTypeIdList_mt;
    if(categorySelected_vb == null)
    {
      categorySelected_vb =",";
    }

    if(categorySelected_vb.trim().length < 1){
      categorySelected_vb =",";
    }
    if(categorySelected_vb.contains(","+id_vb.toString()+",")) {
      categorySelected_vb =categorySelected_vb.replaceAll(","+id_vb.toString()+",",       ",");
    } else {
      categorySelected_vb =categorySelected_vb+id_vb.toString()+",";
    }
    this.userInfo_vb.setCategoryByTypeIdList_mt(categorySelected_vb);
    setState(() { });
    print("). categoryCheckBoxClicked: "+categorySelected_vb);
  }

}
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class CategoryCheckBox_cl extends StatefulWidget {
  final String id_vb;
  final int index_vb;
  final Function(String,int,bool) onChanged;
  final String categoryName_vb;
  final bool selected_vb;
  final String checkedIdList_vb;
  const CategoryCheckBox_cl({Key key, this.index_vb, this.id_vb, this.onChanged,this.categoryName_vb,
                                      this.selected_vb,this.checkedIdList_vb}) : super(key: key);
   //  LikeIconButton({Key key}) : super(key: key);

  @override
  _CategoryCheckBoxState_cl createState() => _CategoryCheckBoxState_cl();
}

class _CategoryCheckBoxState_cl extends State<CategoryCheckBox_cl> {
//  bool isPress=false;
//  int _volume=0;
  Widget build(BuildContext context) {

    return
      CheckboxListTile(
         // icon: Icon(this.widget.likedIt  ? Icons.airplanemode_active : Icons.thumb_up),
          value:this.widget.checkedIdList_vb.contains(","+this.widget.id_vb.toString()+",") ? true:false,
          title: Text(this.widget.categoryName_vb,
            style: TextStyle(
              fontSize: MediaQuery.of(context).size.height  * .12 * .15,
              fontWeight: FontWeight.w400,
            ),),
          controlAffinity: ListTileControlAffinity.leading,
          onChanged: (bool flag) {
            this.widget.onChanged(this.widget.id_vb,this.widget.index_vb,flag);
            setState((){

            });
//            this.isPress=this.widget.likedIt ;
            },

        );
  }
}

//select * from owner_content where id in ( 294,293,292,291,290,289,289,287,286)
//new LikeIconButton(
//id: int.parse(this.widget.myAdsVMList[index].adId),
//onPressed: buttonFunction1,
//),
/*

1_1596288024059_1
1_1596280496410_1
1_1596280215164_1
1_1596280042412_1
1_1596279899091_1
1_1596279647884_1
1_1596279441332_1
1_1596279232072_1

 */
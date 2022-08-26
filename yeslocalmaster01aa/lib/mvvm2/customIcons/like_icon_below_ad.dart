import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class LikeIconButton_cl extends StatefulWidget {
  final String id_vb;
  final double size_vb;
  final int index_vb;
  final Function(String,int) onPressed_vb;
  final String likedIt_vb;

  const LikeIconButton_cl({Key key, this.index_vb, this.id_vb, this.onPressed_vb,this.likedIt_vb,this.size_vb}) : super(key: key);
  //  LikeIconButton({Key key}) : super(key: key);

  @override
  _LikeIconButtonState_cl createState() => _LikeIconButtonState_cl();
}

class _LikeIconButtonState_cl extends State<LikeIconButton_cl> {
//  bool isPress=false;
//  int _volume=0;
  Widget build(BuildContext context) {

    return
      IconButton(
        // icon: Icon(this.widget.likedIt  ? Icons.airplanemode_active : Icons.thumb_up),
        iconSize:  this.widget.size_vb,
        icon: Icon(Icons.thumb_up),
        color: this.widget.likedIt_vb.contains(","+this.widget.id_vb.toString()+",")  ? Colors.lightBlue : Colors.black,
        onPressed: () {
          this.widget.onPressed_vb(this.widget.id_vb,this.widget.index_vb);
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
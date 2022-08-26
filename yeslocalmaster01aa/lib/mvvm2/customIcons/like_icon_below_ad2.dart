import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class LikeIconButton2_cl extends StatefulWidget {
  final String id_vb;
  final double size_vb;
  final int index_vb;
  final Function(String,int) onPressed_vb;

  final String likedIt_vb;
  final String temp;
  const LikeIconButton2_cl({Key key, this.index_vb, this.id_vb, this.onPressed_vb,this.likedIt_vb,
                    this.size_vb,this.temp}) : super(key: key);
  //  LikeIconButton({Key key}) : super(key: key);

  @override
  _LikeIconButtonState_cl createState() => _LikeIconButtonState_cl();
}



class _LikeIconButtonState_cl extends State<LikeIconButton2_cl> {
//  bool isPress=false;
//  int _volume=0;
  Widget build(BuildContext context) {
    bool blueOnOff = this.widget.likedIt_vb.contains(","+this.widget.id_vb.toString()+",")  ? true : false;
    //print("this.widget.pbool onLoad : "+this.widget.pbool.toString());
    return
        IconButton(
         // icon: Icon(this.widget.likedIt  ? Icons.airplanemode_active : Icons.thumb_up),
          iconSize:  this.widget.size_vb,
          icon: Icon(Icons.thumb_up),
          color: blueOnOff  ? Colors.lightBlue : Colors.black,
          onPressed: () {
            setState((){
              this.widget.temp==null ? print("temp is null") : print("temp NOT null"+this.widget.temp);
              if(this.widget.likedIt_vb.contains(","+this.widget.id_vb.toString()+",")){
                print (this.widget.likedIt_vb+"before: Contains > "+this.widget.id_vb);
              }else print (this.widget.likedIt_vb+"before: Not contains > "+this.widget.id_vb);
              blueOnOff=this.widget.likedIt_vb.contains(","+this.widget.id_vb.toString()+",")  ? true : false;
            }
            );
            //blueOnOff=this.widget.likedIt_vb.contains(","+this.widget.id_vb.toString()+",")  ? false : true;
            //print('this.widget.pbool onPressed : '+this.widget.pbool.toString());
            this.widget.onPressed_vb(this.widget.id_vb,this.widget.index_vb);
            setState((){
              this.widget.temp==null ? print("temp is null") : print("temp NOT null"+this.widget.temp);
              if(this.widget.likedIt_vb.contains(","+this.widget.id_vb.toString()+",")){
                print (this.widget.likedIt_vb+"after: Contains > "+this.widget.id_vb);
              }else print (this.widget.likedIt_vb+"after: Not contains > "+this.widget.id_vb);

              blueOnOff=this.widget.likedIt_vb.contains(","+this.widget.id_vb.toString()+",")  ? true : false;
            }
            );
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
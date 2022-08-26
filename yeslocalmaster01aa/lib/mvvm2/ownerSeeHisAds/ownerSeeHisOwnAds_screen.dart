import 'package:flutter/material.dart';
import 'package:yeslocalmarket01aa/mvvm2/customIcons/categoryCheckBox.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchOwnerAds/FetchOwnerAdsNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchOwnerAds/FetchOwnerAdsViewModel.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAdsCategory/FetchAdsCategoryNotifier.dart';
import 'package:yeslocalmarket01aa/mvvm2/modelDTO/userInfo.dart';
import 'package:yeslocalmarket01aa/mvvm2/utils/constants.dart';
import 'package:yeslocalmarket01aa/mvvm2/widgets/RectangleImage.dart';
import 'package:intl/intl.dart';
import 'package:yeslocalmarket01aa/intl15/MyAdsLocalization.dart';

import 'package:provider/provider.dart';
void main() {
  runApp(MaterialApp(
    home: OwnerSeeHisOwnAds_cl(),
  ));
}
class OwnerSeeHisOwnAds_cl extends StatefulWidget {
  UserInfo_cl userInfo_vb;


  OwnerSeeHisOwnAds_cl({this.userInfo_vb});
  @override
  _State_cl createState() => _State_cl(this.userInfo_vb);
}
class _State_cl extends State<OwnerSeeHisOwnAds_cl> {
   UserInfo_cl userInfo_vb;
   List<FetchOwnerAdsViewModel_cl> ownerAdsVMList_vb=null;

   final GlobalKey<ScaffoldState> _AppBarScaffoldKey_vb = new GlobalKey<ScaffoldState>();
   TextEditingController _searchQueryController_vb = TextEditingController();
   var _controller_vb = ScrollController();
   Widget _body = CircularProgressIndicator();
   LoadingStatus_cl loadingStatus_vb;
   _State_cl(userInfo_vb){
     this.userInfo_vb=userInfo_vb;
  }
   @override
   void initState() {

     super.initState();
     this.loadingStatus_vb = LoadingStatus_cl.searching_vb;
     new FetchOwnerAdsNotifier_cl().fetchOwnerHisOwnAds2_mt(this.userInfo_vb.getIdR_mt)
         .then((List<FetchOwnerAdsViewModel_cl> ownerAdsVMList_vb){setState((){
       // FetchAdsNotifier_cl vs_vb = new FetchAdsNotifier_cl();
       // vs_vb.myAdsVMList_vb=myAdsVMList_vb;
       // vs_vb.loadingStatus_vb=LoadingStatus_cl.completed_vb;
       if(ownerAdsVMList_vb.length>0) {
         this.ownerAdsVMList_vb = ownerAdsVMList_vb;
         this.loadingStatus_vb = LoadingStatus_cl.completed_vb;
       }else{
         // Provider
         //     .of<FetchAdsNotifier_cl>(context, listen: false)
         //     .loadingStatus_vb = LoadingStatus_cl.empty_vb;
       }
       //_body =  mainAdScreen();
     });});
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
     return mainAdScreen1();
   }

   Widget mainAdScreen1(){
     var vs_vb  = this.ownerAdsVMList_vb;//= Provider.of<FetchOwnerAdsNotifier_cl>(context, listen: false).ownerAdsVMList_vb;//this.userInfo_vb.getAdsCategoryVMList_mt;
     var deviceSize_vb = MediaQuery.of(context).size;
     //final GlobalKey<ScaffoldState> _AppBarScaffoldKey = new GlobalKey<ScaffoldState>();
     //var vs1 = Provider.of<MyAdContentListViewModelTemp>(context);
     return Scaffold(
       backgroundColor: Colors.blue[50],
       key: _AppBarScaffoldKey_vb,
       body: CustomScrollView(
         controller: _controller_vb,
         physics: const BouncingScrollPhysics(),
         slivers: <Widget>[
           SliverAppBar(
             backgroundColor: Colors.blueAccent,
             title: Text("My Ads",
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
           _buildListErrorOrSliver_mt(vs_vb),
         ],
       ),
     );
   }

   Widget _buildListErrorOrSliver_mt(var adsListvm_vb) {
     switch (this.loadingStatus_vb) {

       case LoadingStatus_cl.searching_vb:
         return
           SliverToBoxAdapter(child: CircularProgressIndicator(),);
       case LoadingStatus_cl.completed_vb:
         return _buildListSliver_mt();


       case LoadingStatus_cl.empty_vb:
         return SliverToBoxAdapter(
           child: Text("No results found",
             textAlign: TextAlign.center,
             style: TextStyle(
                 color: Colors.blue,
                 fontWeight: FontWeight.w300,
                 fontSize: MediaQuery.of(context).size.height *.1 * .3

             ),),
         );
       default:
         return SliverToBoxAdapter(
           child: Text("No results found",
             textAlign: TextAlign.center,
             style: TextStyle(
                 color: Colors.blue,
                 fontWeight: FontWeight.w300,
                 fontSize: MediaQuery.of(context).size.height *.1 * .3

             ),),
         );
     }
   }

   Widget _buildListSliver_mt() {
     //var vs_vb  = this.ownerAdsVMList_vb;
     var deviceSize_vb = MediaQuery.of(context).size;
     return
       SliverList(
         delegate: SliverChildBuilderDelegate((BuildContext context, index) =>
             Container(
               child:  SafeArea(
                 child:  Card(
                   elevation: 8,
                   borderOnForeground: true,
                   shadowColor: Colors.black,
                   //color: Colors.blueAccent,
                   margin: EdgeInsets.fromLTRB(0, 0, 0, 0),
                   child:  Column(
                     mainAxisAlignment: MainAxisAlignment.start,
                     mainAxisSize: MainAxisSize.min,
                     crossAxisAlignment: CrossAxisAlignment.stretch,
                     children: <Widget>[
                       Padding(
                         padding: const EdgeInsets.fromLTRB(16.0, 16.0, 8.0, 16.0),
                         child: Row(
                           mainAxisAlignment: MainAxisAlignment.spaceBetween,
                           children: <Widget>[
                             Row(
                               children: <Widget>[
                                 new Container(
                                   height: 40.0,
                                   width: 40.0,
                                   // decoration: new BoxDecoration(
                                   //   shape: BoxShape.circle,
                                   //   image: new DecorationImage(  // Top Thumbnail image
                                   //       fit: BoxFit.fill,
                                   //       image: new NetworkImage(
                                   //         Constants_cl.getAdImageIconUrl_mt(
                                   //             vs_vb.myAdsVMList_vb[index].adId_mt),)
                                   //     //"http://10.0.2.2:8020/ba/imageshow/image/show/"+vs.myAdsVMList_vb[index].adId.toString())
                                   //   ),
                                   // ),
                                 ),
                                 new SizedBox(
                                   width: 10.0,
                                 ),

                               ],
                             ),
                             new IconButton(
                               icon: Icon(Icons.more),
                               iconSize: deviceSize_vb.height * 0.15*.23,
                               onPressed: null,
                             )
                           ],
                         ),
                       ),
                       Flexible(
                         fit: FlexFit.loose,
                         child: RectangleImage_cl(
                           imageUrl_vb: Constants_cl.getAdImageUrl_mt(
                               this.ownerAdsVMList_vb[index].adId_mt),
                         ),
                       ),
                       Padding(
                         padding: const EdgeInsets.all(16.0),
                         child: Row(
                           mainAxisAlignment: MainAxisAlignment.spaceBetween,
                           children: <Widget>[
                             new Row(
                               mainAxisAlignment: MainAxisAlignment.spaceBetween,
                               children: <Widget>[
                                 // new IconButton(
                                 //     key: UniqueKey(),
                                 //     iconSize:  deviceSize_vb.height * 0.15*.23,
                                 //     icon: this.userInfo_vb.getLikedAdsAtOnLoad_mt.contains(","+vs_vb.myAdsVMList_vb[index].adId_mt.toString()+",") ? Icon(Icons.thumb_up): Icon(Icons.eighteen_mp),
                                 //     color: this.userInfo_vb.getLikedAdsAtOnLoad_mt.contains(","+vs_vb.myAdsVMList_vb[index].adId_mt.toString()+",") ? Colors.blue: Colors.black,
                                 //     onPressed: likeIconButtonFunction_mt(vs_vb.myAdsVMList_vb[index].adId_mt,index),
                                 // ),

                                 // new LikeIconButton_cl(
                                 //   id_vb: vs_vb.ownerAdsVMList_vb[index].adId_mt,
                                 //   index_vb:index,
                                 //   onPressed_vb:  likeIconButtonFunction_mt,
                                 //   likedIt_vb: this.userInfo_vb.getLikedAdsAtOnLoad_mt==null ? ",":this.userInfo_vb.getLikedAdsAtOnLoad_mt,
                                 //   size_vb: deviceSize_vb.height * 0.15*.23,
                                 //
                                 // ),
                                 new SizedBox(
                                   width: 36.0,
                                 ),

                                 new SizedBox(
                                   width: 32.0,
                                 ),
                                 // new Icon(Icons.airplanemode_active),
                               ],
                             ),
                             new Icon(Icons.bookmark,size: deviceSize_vb.height * 0.15*.23)
                           ],
                         ),
                       ),
                       Padding(
                         padding: const EdgeInsets.symmetric(horizontal: 5.0),
                         child:Text(
                           this.ownerAdsVMList_vb[index].contentDesc_mt+" && "+this.userInfo_vb.getLikedAdsAtOnLoad_mt ,//Description section
                           key: UniqueKey(),
                           style: TextStyle(
                             fontWeight: FontWeight.w500,
                             fontSize: deviceSize_vb.height * 0.15*.15,
                             color: Colors.black,
                             wordSpacing: 2,
                             letterSpacing: 1,
                             height: 1.6,
                           ),
                         ),
                       ),
                       Padding(
                         padding: const EdgeInsets.fromLTRB(16.0, 16.0, 0.0, 8.0),
                         child: Row(
                           mainAxisAlignment: MainAxisAlignment.start,
                           children: <Widget>[
                             new Container( // Bottom Thumbnail Image
                               height: 40.0,
                               width: 40.0,
                               /*decoration: new BoxDecoration(
                                shape: BoxShape.circle,
                                image: new DecorationImage(
                                  fit: BoxFit.fill,
                                  //image: AssetImage('assets/images/sql.jpg'), //image at comment
                                  image: new NetworkImage(
                                    Constants_cl.getAdImageIconUrl_mt(
                                        vs_vb.myAdsVMList_vb[index].adId_mt),),
                                ),
                              ),*/
                             ),
                             new SizedBox(
                               width: 10.0,
                             ),
                             Expanded(
                               child: new TextField(
                                 decoration: new InputDecoration(
                                   border: InputBorder.none,
                                   enabled: false,
                                   //hintText: "Add a comment...",
                                 ),
                               ),
                             ),
                           ],
                         ),
                       ),
                       Padding(
                         padding: const EdgeInsets.symmetric(horizontal: 16.0),
                         child:
                         Text(
                             this.ownerAdsVMList_vb[index].publishedAt_mt.substring(0,16),
                             style:
                             TextStyle(
                               color: Colors.black,
                               fontWeight: FontWeight.w500,
                               fontSize: deviceSize_vb.height * 0.15*.12,
                               wordSpacing: 2,
                               letterSpacing: 1,
                               height: 1.6,
                             )
                         ),
                       ),
                     ],
                   ),
                 ),
               ),
             ),
           childCount: this.ownerAdsVMList_vb.length,
         ),
       );
   }


   //
  Widget build1(BuildContext context) {
    var deviceSize_vb = MediaQuery.of(context).size;
    this.ownerAdsVMList_vb= Provider.of<FetchOwnerAdsNotifier_cl>(context, listen: false).ownerAdsVMList_vb;//this.userInfo_vb.getAdsCategoryVMList_mt;

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
              children:
              [Container(
                alignment: Alignment.center,
                padding: EdgeInsets.all(10),
                child: Text("sd"),
              )],


            )
        ));
        /*body: Padding(
            padding: EdgeInsets.all(10),
            child: ListView(
              children: createAdsCards_mt(),
            )));*/
  }

  List<Widget> createAdsCards_mt(){
    List<Widget> lw1 =[];//new List<Widget>();

    var deviceSize_vb = MediaQuery.of(context).size;
    lw1.add(Container(
        alignment: Alignment.center,
        padding: EdgeInsets.all(10),

        child: Text(
          labelsTextI10n_mt('myOwnAds_heading'),
          style: TextStyle(
              color: Colors.blue,
              fontWeight: FontWeight.w300,
              fontSize: deviceSize_vb.height *.1 * .5),
        )));
    int n=4;

    while(n<this.ownerAdsVMList_vb.length)
    {
      /*lw1.add(
          Container(
              alignment: Alignment.center,
              padding: EdgeInsets.fromLTRB(0, 0, 0, 0),
              margin: EdgeInsets.fromLTRB(0, 0, 0, 0),
              child: CategoryCheckBox_cl(
                selected_vb: false,
                index_vb: n,
                id_vb: this.ownerAdsVMList[n].id_mt,
                onChanged: categoryByTypeCheckBoxClicked_mt,
                categoryName_vb: this.ownerAdsVMList[n].categoryName_mt,
                checkedIdList_vb: this.userInfo_vb.getCategoryByTypeIdList_mt==null ? ",":this.userInfo_vb.getCategoryByTypeIdList_mt,
                //selected: false,
              )
          ));*/
      lw1.add(Container(
        child:  SafeArea(
          child:  Card(
            elevation: 8,
            borderOnForeground: true,
            shadowColor: Colors.black,
            //color: Colors.blueAccent,
            margin: EdgeInsets.fromLTRB(0, 0, 0, 0),
            child:  Column(
              mainAxisAlignment: MainAxisAlignment.start,
              mainAxisSize: MainAxisSize.min,
              crossAxisAlignment: CrossAxisAlignment.stretch,
              children: <Widget>[
                Padding(
                  padding: const EdgeInsets.fromLTRB(16.0, 16.0, 8.0, 16.0),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: <Widget>[
                      Row(
                        children: <Widget>[
                          new Container(
                            height: 40.0,
                            width: 40.0,
                            // decoration: new BoxDecoration(
                            //   shape: BoxShape.circle,
                            //   image: new DecorationImage(  // Top Thumbnail image
                            //       fit: BoxFit.fill,
                            //       image: new NetworkImage(
                            //         Constants_cl.getAdImageIconUrl_mt(
                            //             vs_vb.myAdsVMList_vb[index].adId_mt),)
                            //     //"http://10.0.2.2:8020/ba/imageshow/image/show/"+vs.myAdsVMList_vb[index].adId.toString())
                            //   ),
                            // ),
                          ),
                          new SizedBox(
                            width: 10.0,
                          ),

                        ],
                      ),
                      new IconButton(
                        icon: Icon(Icons.more),
                        iconSize: deviceSize_vb.height * 0.15*.23,
                        onPressed: null,
                      )
                    ],
                  ),
                ),
                Flexible(
                  fit: FlexFit.loose,
                  child: RectangleImage_cl(
                    imageUrl_vb: Constants_cl.getAdImageUrl_mt(
                        this.ownerAdsVMList_vb[n].adId_mt),
                  ),
                ),
                Padding(
                  padding: const EdgeInsets.all(16.0),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: <Widget>[
                      new Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: <Widget>[
                          // new IconButton(
                          //     key: UniqueKey(),
                          //     iconSize:  deviceSize_vb.height * 0.15*.23,
                          //     icon: this.userInfo_vb.getLikedAdsAtOnLoad_mt.contains(","+vs_vb.myAdsVMList_vb[index].adId_mt.toString()+",") ? Icon(Icons.thumb_up): Icon(Icons.eighteen_mp),
                          //     color: this.userInfo_vb.getLikedAdsAtOnLoad_mt.contains(","+vs_vb.myAdsVMList_vb[index].adId_mt.toString()+",") ? Colors.blue: Colors.black,
                          //     onPressed: likeIconButtonFunction_mt(vs_vb.myAdsVMList_vb[index].adId_mt,index),
                          // ),

                          // new LikeIconButton_cl(
                          //   id_vb: vs_vb.myAdsVMList_vb[index].adId_mt,
                          //   index_vb:index,
                          //   onPressed_vb:  likeIconButtonFunction_mt,
                          //   likedIt_vb: this.userInfo_vb.getLikedAdsAtOnLoad_mt==null ? ",":this.userInfo_vb.getLikedAdsAtOnLoad_mt,
                          //   size_vb: deviceSize_vb.height * 0.15*.23,
                          //
                          // ),
                          new SizedBox(
                            width: 36.0,
                          ),

                          new SizedBox(
                            width: 32.0,
                          ),
                          // new Icon(Icons.airplanemode_active),
                        ],
                      ),
                      new Icon(Icons.bookmark,size: deviceSize_vb.height * 0.15*.23)
                    ],
                  ),
                ),
                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 5.0),
                  child:Text(
                    this.ownerAdsVMList_vb[n].contentDesc_mt,//Description section
                    key: UniqueKey(),
                    style: TextStyle(
                      fontWeight: FontWeight.w500,
                      fontSize: deviceSize_vb.height * 0.15*.15,
                      color: Colors.black,
                      wordSpacing: 2,
                      letterSpacing: 1,
                      height: 1.6,
                    ),
                  ),
                ),
                Padding(
                  padding: const EdgeInsets.fromLTRB(16.0, 16.0, 0.0, 8.0),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.start,
                    children: <Widget>[
                      new Container( // Bottom Thumbnail Image
                        height: 40.0,
                        width: 40.0,
                        /*decoration: new BoxDecoration(
                                shape: BoxShape.circle,
                                image: new DecorationImage(
                                  fit: BoxFit.fill,
                                  //image: AssetImage('assets/images/sql.jpg'), //image at comment
                                  image: new NetworkImage(
                                    Constants_cl.getAdImageIconUrl_mt(
                                        vs_vb.myAdsVMList_vb[index].adId_mt),),
                                ),
                              ),*/
                      ),
                      new SizedBox(
                        width: 10.0,
                      ),
                      Expanded(
                        child: new TextField(
                          decoration: new InputDecoration(
                            border: InputBorder.none,
                            enabled: false,
                            //hintText: "Add a comment...",
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
                Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 16.0),
                  child:
                  Text(
                      this.ownerAdsVMList_vb[n].publishedAt_mt.substring(0,16),
                      style:
                      TextStyle(
                        color: Colors.black,
                        fontWeight: FontWeight.w500,
                        fontSize: deviceSize_vb.height * 0.15*.12,
                        wordSpacing: 2,
                        letterSpacing: 1,
                        height: 1.6,
                      )
                  ),
                ),
              ],
            ),
          ),
        ),
      ),);
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
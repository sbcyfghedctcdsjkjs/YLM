import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';

class RectangleImage_cl extends StatelessWidget {

  final String imageUrl_vb;

  const RectangleImage_cl({Key key, this.imageUrl_vb}) : super(key: key);

  Widget _imageWidget(ImageProvider imageProvider_vb, double height_vb) {

    return Container(
      height: height_vb,
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(0),
        image: DecorationImage(
          image: imageProvider_vb,
          fit: BoxFit.fill,
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context_vb) {
    var deviceSize_vb = MediaQuery.of(context_vb).size;
    return CachedNetworkImage(
      imageUrl: imageUrl_vb ?? '',
      imageBuilder: (context_vb, imageProvider_vb) {
        return _imageWidget(imageProvider_vb,deviceSize_vb.height * .6);
      },
      placeholder: (context, url) {
        return Center(child: CircularProgressIndicator());
      },
      // errorWidget: (context, url, error) {
      //   return _imageWidget(
      //     AssetImage(
      //       'assets/images/p550.jpg',
      //     ),
      //       deviceSize_vb.height * .6
      //   );
      // },
    );
  }
}

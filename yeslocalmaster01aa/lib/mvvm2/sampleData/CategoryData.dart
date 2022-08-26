import 'package:yeslocalmarket01aa/mvvm2/apikey/ApiKeyModel.dart';
import 'package:yeslocalmarket01aa/mvvm2/fetchAdsCategory/FetchAdsCategory.dart';

class CategoryData_cl{
   String id_vb;
   String categoryName_vb;
  String apiKey_vb;
  String updatedOn_vb='[{"p1":null,"p2":"Instant Ads(Dot Miss)","p3":null,"p4":null,"p5":null,"p6":null,"p7":null,'
                      '"p10":null,"p11":null,"p12":null,"p13":1},{"p1":null,"p2":"Plan your weekend around these",'
                      '"p3":null,"p4":null,"p5":null,"p6":null,"p7":null,"p10":null,"p11":null,"p12":null,"p13":2},'
                      '{"p1":null,"p2":"Limited for 1 Month only","p3":null,"p4":null,"p5":null,"p6":null,"p7":null,'
                      '"p10":null,"p11":null,"p12":null,"p13":3},{"p1":null,"p2":"You can count on Us","p3":null,"p4":null,'
                      '"p5":null,"p6":null,"p7":null,"p10":null,"p11":null,"p12":null,"p13":4},{"p1":null,'
                      '"p2":"Fruit Shop","p3":null,"p4":null,"p5":null,"p6":null,"p7":null,"p10":null,"p11":null,'
                      '"p12":null,"p13":5},{"p1":null,"p2":"Vegetable Shop","p3":null,"p4":null,"p5":null,"p6":null,'
                      '"p7":null,"p10":null,"p11":null,"p12":null,"p13":6},{"p1":null,"p2":"Carpenter Shop","p3":null,'
                      '"p4":null,"p5":null,"p6":null,"p7":null,"p10":null,"p11":null,"p12":null,"p13":7},{"p1":null,'
      '"p2":"Furniture Shop","p3":null,"p4":null,"p5":null,"p6":null,"p7":null,"p10":null,"p11":null,"p12":null,"p13":8},'
      '{"p1":null,"p2":"Mobile Shop","p3":null,"p4":null,"p5":null,"p6":null,"p7":null,"p10":null,"p11":null,"p12":null,"p13":9},'
      '{"p1":null,"p2":"Property Dealer","p3":null,"p4":null,"p5":null,"p6":null,"p7":null,"p10":null,"p11":null,"p12":null,"p13":10}]';

   CategoryData_cl(
       { this.id_vb,this.categoryName_vb  });

   List<FetchAdsCategory_cl> getCategoryData() {
    FetchAdsCategory_cl f1= FetchAdsCategory_cl(
      id_vb: "",
      categoryName_vb: "Instant Ads(Dot Miss)",);

    FetchAdsCategory_cl f2= FetchAdsCategory_cl(
      id_vb: "",
      categoryName_vb: "Plan your weekend around these",);

    FetchAdsCategory_cl f3= FetchAdsCategory_cl(
      id_vb: "",
      categoryName_vb: "Limited for 1 Month only",);

    FetchAdsCategory_cl f4= FetchAdsCategory_cl(
      id_vb: "",
      categoryName_vb: "You can count on Us",);
    return [f1,f2,f3,f4].toList();
  }


}


class FetchAdsCategory_cl {
  String p2;
  String p13;
  final String id_vb;
  final String categoryName_vb;

  FetchAdsCategory_cl(
      { this.id_vb,
        this.categoryName_vb,});

  factory FetchAdsCategory_cl.fromJson_mt(Map<String, dynamic> json_vb) {
    //ownerPhone_vb: json_vb['ownerPhone'],
    //generatedFileName_vb: json_vb['generatedFileName'],
    return FetchAdsCategory_cl(

      id_vb: json_vb['p13'].toString(),
      categoryName_vb: json_vb['p2'],
    );
  }
}
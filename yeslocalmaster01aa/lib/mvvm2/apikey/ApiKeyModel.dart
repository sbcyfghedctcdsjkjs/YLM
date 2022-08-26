class ApiKeyModel_cl{

  String apiKey_vb;
  String updatedOn_vb;

  ApiKeyModel_cl(
    { this.apiKey_vb,this.updatedOn_vb  });


  factory ApiKeyModel_cl.fromJson_mt(Map<String, dynamic> json_vb) {
    print("API key server is >>> "+json_vb['p1']);
    return ApiKeyModel_cl(
      apiKey_vb: json_vb['p1'],
      updatedOn_vb: json_vb['p2'],
    );
  }

  factory ApiKeyModel_cl.fromJson_mtORIG(Map<String, dynamic> json_vb) {
    print("API key server is >>> "+json_vb['p1']);
    return ApiKeyModel_cl(
      apiKey_vb: json_vb['p1'],
      updatedOn_vb: json_vb['p2'],
    );
  }

}
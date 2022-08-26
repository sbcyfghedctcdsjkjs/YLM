import 'ApiKeyModel.dart';

class ApiKeyViewModel_cl{

  ApiKeyModel_cl _apiKeyModel_vb;
  ApiKeyViewModel_cl({ApiKeyModel_cl apiKeyModel_vb}) : _apiKeyModel_vb = apiKeyModel_vb;

  String get apiKey_mt{

    return _apiKeyModel_vb.apiKey_vb;
  }

  void set apiKey_mt(String v) {
    _apiKeyModel_vb.apiKey_vb=v;
  }

  String get updatedOn_mt{
    return _apiKeyModel_vb.updatedOn_vb;

  }

  void set updatedOn_mt(String v) {
    _apiKeyModel_vb.updatedOn_vb=v;
  }

}
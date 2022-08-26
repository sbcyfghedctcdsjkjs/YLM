/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;

import com.bananabkend.bananaBkEnd1A.model.SecurityApi;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sunjiv6
 */
public interface ApiKeyService {    
    
    
    public SecurityApi save(SecurityApi securityApi) throws Exception;
   
    public SecurityApi update(SecurityApi securityApi) throws Exception;
    
    public String generateNewKey() throws Exception;
    
    public SecurityApi getApiKeyRecordWithApiKey(String apikey) throws Exception;
    public Long getTotalRowsCount() throws Exception;
    public Integer getTotalRegistrationCount() throws Exception;
    List<SecurityApi> getTopNRows() throws Exception;
    
}

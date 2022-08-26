/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;

import com.bananabkend.bananaBkEnd1A.model.SecurityApi;

import com.bananabkend.bananaBkEnd1A.repository.SecurityApiRepo;
import com.bananabkend.bananaBkEnd1A.repository.SecurityApiRepo2;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sunjiv6
 */
@Service
@Transactional
public class ApikeyServiceImpl implements ApiKeyService{

    
    private SecurityApiRepo securityApiRepo;
    private SecurityApiRepo2 securityApiRepo2;
    public ApikeyServiceImpl(SecurityApiRepo securityApiRepo,SecurityApiRepo2 securityApiRepo2) {
            this.securityApiRepo = securityApiRepo;
            this.securityApiRepo2 = securityApiRepo2;
    }
    
    @Override
    public SecurityApi save(SecurityApi securityApi) throws Exception {
        return securityApiRepo.save(securityApi);            
    }
    
    @Override
    public SecurityApi update(SecurityApi securityApi) throws Exception {
        return securityApiRepo.save(securityApi);            
    }


    @Override
    public String generateNewKey() throws Exception 
    { 
      // chose a Character random from this String 
        String AlphaNumericString = "ABbCDEFGbaHIbsJKldsLMNObsPwQRSTUVWxXYZ"
                                    + "0123556788"
                                    + "asbscdefghijlkqnlqmnbopqdsrstxuevxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(30); 
  
        for (int i = 0; i < 30; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
     
    }

    @Override
    public SecurityApi getApiKeyRecordWithApiKey(String apikey) throws Exception {
        SecurityApi s = securityApiRepo.getApiKeyRecordWithApiKey(apikey); 
        if(s==null) return new SecurityApi();
        
        return s;
    }

     @Override
    public Long getTotalRowsCount() throws Exception{
        return securityApiRepo.getTotalRowsCount();        
    }
    
    
    public Integer getTotalRegistrationCount(){
        return securityApiRepo.getTotalRegistrationCount();
    }
    
    @Override
    public List<SecurityApi> getTopNRows(){
        return securityApiRepo2.getTopNRows();
    }
}

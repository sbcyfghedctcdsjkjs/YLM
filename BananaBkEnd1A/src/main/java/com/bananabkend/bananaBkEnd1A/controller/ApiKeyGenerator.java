/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.controller;

import com.bananabkend.bananaBkEnd1A.Utility.AngularPageNameEncryptor;
import com.bananabkend.bananaBkEnd1A.Utility.property.ContentStatus;
import com.bananabkend.bananaBkEnd1A.model.OwnerTargetArea;
import com.bananabkend.bananaBkEnd1A.model.SecurityApi;
import com.bananabkend.bananaBkEnd1A.model.UserOwner;
import com.bananabkend.bananaBkEnd1A.model.dto.SecurityApiDto;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import com.bananabkend.bananaBkEnd1A.service.ApiKeyService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunjiv6
 */
@RestController
@RequestMapping("/apikey")
public class ApiKeyGenerator {
    
    ApiKeyService apiKeyService;

    public ApiKeyGenerator(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }
    
    
    @PostMapping("/ngwebGenerateNewKey/{apiUniqueId}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<AnonymousDto> generateNewKey(@PathVariable String apiUniqueId,AnonymousDto anoDto)//(@RequestBody OwnerContent ownerContent) 
    {
        ResponseEntity<AnonymousDto> response=null;
        SecurityApi securityApi =new  SecurityApi();
        SecurityApiDto securityApiDto = new SecurityApiDto();
        try {
            if(AngularPageNameEncryptor.decryptPageName(anoDto.getP1())==null ) 
                return response=ResponseEntity.status(HttpStatus.BAD_REQUEST)
                               .body(anoDto);
            securityApi.setCreatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi.setUriAccessed(","+apiUniqueId+"_"+AngularPageNameEncryptor.decryptPageName(anoDto.getP1())+",");
            securityApi.setApikey(apiKeyService.generateNewKey());
            securityApi = apiKeyService.save(securityApi);
            
        } catch (Exception ex) {            
            Logger.getLogger(ApiKeyGenerator.class.getName()).log(Level.SEVERE, null, ex);
            anoDto.setP1("");
            response=ResponseEntity.status(HttpStatus.BAD_REQUEST)
                               .body(anoDto);
            return response;
        }
        securityApiDto.setApikey_vb(securityApi.getApikey());
        securityApiDto.setUpdatedOn_vb(securityApi.getUpdatedOn());
        
        
        anoDto.setP1(securityApi.getApikey());        
        anoDto.setP2(securityApi.getUpdatedOn());
        
        response=ResponseEntity.status(HttpStatus.OK).body(anoDto);
        
        return response;
    }
    
    @PostMapping("/mobileGenerateNewKey/{apiUniqueId}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<AnonymousDto> mobileGenerateNewKey(@PathVariable String apiUniqueId,AnonymousDto anoDto)//(@RequestBody OwnerContent ownerContent) 
    {
        ResponseEntity<AnonymousDto> response=null;
        SecurityApi securityApi =new  SecurityApi();
        SecurityApiDto securityApiDto = new SecurityApiDto();
        
        try {
            securityApi.setCreatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi.setUriAccessed(","+apiUniqueId+"_M,");
            securityApi.setApikey(apiKeyService.generateNewKey());
            securityApi = apiKeyService.save(securityApi);
            
        } catch (Exception ex) {            
            Logger.getLogger(ApiKeyGenerator.class.getName()).log(Level.SEVERE, null, ex);
            anoDto.setP1("");
            response=ResponseEntity.status(HttpStatus.BAD_REQUEST)
                               .body(anoDto);
            return response;
        }
        
        securityApiDto.setApikey_vb(securityApi.getApikey());
        securityApiDto.setUpdatedOn_vb(securityApi.getUpdatedOn());
        
        anoDto.setP1(securityApi.getApikey());
        anoDto.setP2(securityApi.getUpdatedOn());
        
        response=ResponseEntity.status(HttpStatus.OK)
                               .body(anoDto);
        return response;
    }
    
    
}
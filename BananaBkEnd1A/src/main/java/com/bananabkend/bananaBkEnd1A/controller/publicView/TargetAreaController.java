/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.controller.publicView;

import com.bananabkend.bananaBkEnd1A.Utility.property.ContentStatus;
import com.bananabkend.bananaBkEnd1A.model.OwnerTargetArea;
import com.bananabkend.bananaBkEnd1A.model.SecurityApi;
import com.bananabkend.bananaBkEnd1A.model.UserOwner;
import com.bananabkend.bananaBkEnd1A.model.dto.SecurityApiDto;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent;
import com.bananabkend.bananaBkEnd1A.service.ApiKeyService;
import com.bananabkend.bananaBkEnd1A.service.OwnerTargetService;
import com.bananabkend.bananaBkEnd1A.service.UserOwnerService;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunjiv6
 */
@Api(value = "TargetAreaController", tags = {"REST APIs to retrieve ad for public view !!!!","TargetAreaController"})
@RestController
@RequestMapping("/ta NOTINUSE")
public class TargetAreaController {
    UserOwnerService userOwnerService;    
    OwnerTargetService ownerTargetService;
     ApiKeyService apiKeyService;
    public TargetAreaController(OwnerTargetService ownerTargetService, UserOwnerService userOwnerService
                                ,ApiKeyService apiKeyService) {
        this.ownerTargetService = ownerTargetService;
        this.userOwnerService = userOwnerService;
        this.apiKeyService = apiKeyService;
    }
    
    @RequestMapping(value = "/address/match/count/NOT IN USE/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Integer> activeAdsRecordsCountNOTINUSE(@PathVariable String apiUniqueId,
            @PathVariable String apiKey,@RequestBody String address) 
    {
        
            ResponseEntity<Integer> response=null;
            SecurityApiDto securityApiDto=new SecurityApiDto();
            securityApiDto.setApikey_vb(apiKey);
            SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
            if(!securityApi.getValid()){
                return response = ResponseEntity.status(HttpStatus.OK)
                      .body(null);     
            }
            
            
            try {
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi=apiKeyService.save(securityApi);
            } catch (Exception ex) {
                Logger.getLogger(TargetAreaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            List<String> addList=null;
            //------------  security is pending -----------
            //RetrieveAdsContent ownerContent = ownerContent1.get(0);
            //        UserOwner owner= new UserOwner();
            //        owner.setUserPhone(ownerContent.getOwnerPhone());
            //        owner.setUserEmail(ownerContent.getOwnerEmail());
            //        owner.setSecretNumberEncoded(ownerContent.getSecretNumber());
            if(address.trim().length()<1) return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Status code", HttpStatus.NOT_FOUND.toString())
                    .header("StatusCode", HttpStatus.NOT_FOUND.toString())
                    .body(0);
            
            try{ // check if whole address match 
                Integer count= ownerTargetService.recordsCount(address.trim().toUpperCase());
                if(count >= ContentStatus.minRecordCount){
                    return response=ResponseEntity.status(HttpStatus.OK)
                            .body(count);
                }
            }catch(Exception ex){
                    response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Status code", HttpStatus.NOT_FOUND.toString())
                    .header("StatusCode", HttpStatus.NOT_FOUND.toString())
                    .body(0);
                    return response;
            }

            try {  // check if comma exist then split address by comma
                    if(address.indexOf(",") > 0)
                    {
                        addList=null;
                        addList=Arrays.asList(address.split(","));
                        for (String region : addList) {
                                Integer count= ownerTargetService.recordsCount(region.trim().toUpperCase());
                                if(count >= ContentStatus.minRecordCount){
                                    return response=ResponseEntity.status(HttpStatus.OK)
                                            .body(count);
                                }
                             }
                    }
                }catch (Exception ex) {
                    Logger.getLogger(TargetAreaController.class.getName()).log(Level.SEVERE, null, ex);
                    response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Status code", HttpStatus.NOT_FOUND.toString())
                    .header("StatusCode", HttpStatus.NOT_FOUND.toString())
                    .body(0);
                    return response;
                }
            
            try {   // see if check exist then split address by space
                    if(address.indexOf(" ")> 0)
                    {
                        addList=null;
                        addList=Arrays.asList(address.split(" "));
                        for (String region : addList) {
                            Integer count=0;
                            if(region.length() > 0){
                                count= ownerTargetService.recordsCount(region.toUpperCase());
                                if(count >= ContentStatus.minRecordCount){
                                    return response=ResponseEntity.status(HttpStatus.OK)
                                            .body(count);
                                }
                            }
                        }
                    }
                }catch (Exception ex) {
                    Logger.getLogger(TargetAreaController.class.getName()).log(Level.SEVERE, null, ex);
                    response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Status code", HttpStatus.NOT_FOUND.toString())
                    .header("StatusCode", HttpStatus.NOT_FOUND.toString())
                    .body(0);
                    return response;
                }
            
            
            return response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Status code", HttpStatus.NOT_FOUND.toString())
                    .header("StatusCode", HttpStatus.NOT_FOUND.toString())
                    .body(0);

    }

    public SecurityApi validate30MinApiKey(SecurityApiDto securityApiDto) {        
       ResponseEntity<String> response=null;
       SecurityApi securityApi =new  SecurityApi();
        try {
            securityApi=apiKeyService.getApiKeyRecordWithApiKey(securityApiDto.getApikey_vb());
        } catch (Exception ex) {
            securityApi.setValid(false);
            return securityApi;}
        finally{
            if(securityApi==null || securityApi.getId()<0){
                securityApi.setValid(false);
                
                return securityApi;}          
    
        }
        
        try {        
            Long diff = System.currentTimeMillis() - Long.valueOf(securityApi.getUpdatedOn());
            Long inMinutes = diff / (60*1000) %60;
            if( inMinutes > 30){ securityApi.setValid(false);
                
                
                return securityApi;
            }
        } catch (Exception ex) {
            securityApi.setValid(false);
            return securityApi;}
        finally{}
        securityApi.setValid(true);
        return securityApi;    
    }
    
}

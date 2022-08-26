/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.controller.publicView;

import com.bananabkend.bananaBkEnd1A.Utility.IdEncryptor;
import com.bananabkend.bananaBkEnd1A.Utility.property.ContentStatus;
import com.bananabkend.bananaBkEnd1A.model.SecurityApi;
import com.bananabkend.bananaBkEnd1A.model.dto.SecurityApiDto;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.UserAdViewerLikedItDTO;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewerLikedIt;
import com.bananabkend.bananaBkEnd1A.service.ApiKeyService;
import com.bananabkend.bananaBkEnd1A.service.publicViewServices.AdViewerLikedItService;
import com.bananabkend.bananaBkEnd1A.service.publicViewServices.UserAdViewerService;
import io.swagger.annotations.Api;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunjiv6
 */
@Api(value = "UserAdViewerLikedItController", tags = {"REST APIs to create user for public view !!!!","UserAdViewer"})
@RestController
@RequestMapping("/adViewerLikedIt")
public class UserAdViewerLikedItController {
    
    AdViewerLikedItService adViewerLikedItService;
    ApiKeyService apiKeyService;

    public UserAdViewerLikedItController(AdViewerLikedItService adViewerLikedItService,ApiKeyService apiKeyService) {
        this.adViewerLikedItService = adViewerLikedItService;
        this.apiKeyService = apiKeyService;
    }

    @PostMapping(value = "/saveAdsLiked/{apiUniqueId}/{apiKey}",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto> saveLikedAds(@PathVariable String apiUniqueId,@PathVariable String apiKey,
            @RequestBody AnonymousDto anoDto) 
    {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> saveLikedAds : ");
        boolean adViewerExist=false;
        AnonymousDto sanoDto= new AnonymousDto();
        ResponseEntity<AnonymousDto> response=null;
        IdEncryptor enc=new IdEncryptor();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        UserAdViewerLikedIt savedData =null; 
        HashMap<String,String> hashMap = new HashMap<String,String>();
        RetrieveAdsContent retrieveAdsContent=new RetrieveAdsContent();
        UserAdViewerLikedIt userAdViewerLikedIt =new UserAdViewerLikedIt() ;
        
        UserAdViewerLikedItDTO userAdViewerLikedItDTO= new UserAdViewerLikedItDTO();
        userAdViewerLikedItDTO.setUserId(anoDto.getP3());
        userAdViewerLikedItDTO.setLiked(anoDto.getP2());
        userAdViewerLikedItDTO.setId(anoDto.getP1());
        if(!securityApi.getValid()){
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null);     
        }
        
        
        try {
        
            userAdViewerLikedIt.setUserAdViewerId(enc.decryptId(userAdViewerLikedItDTO.getUserId()));
            if(securityApi.getViewerUserId()==null)
            {   
                securityApi.setViewerUserId(userAdViewerLikedIt.getUserAdViewerId());}
        } catch (Exception ex) {
            Logger.getLogger(WebLikedItController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi=apiKeyService.save(securityApi);
        } catch (Exception ex) {
            Logger.getLogger(WebLikedItController.class.getName()).log(Level.SEVERE, null, ex);
            response = ResponseEntity.status(HttpStatus.OK)
              .body(sanoDto);
        }
        
        
        try{
            userAdViewerLikedIt.setId(enc.decryptId(userAdViewerLikedItDTO.getId()));
        }catch(Exception ex){ex.printStackTrace();}            
        finally{}
        
        try{
                String[] likeIds = userAdViewerLikedItDTO.getLiked().split(",");
                StringBuilder strB=new StringBuilder();
                strB.append(",");


                for (int i = 1; i < likeIds.length; i++) {
                    strB.append(enc.decryptId(likeIds[i]));
                    strB.append(",");                
                }
                userAdViewerLikedIt.setAllLikedIds(strB.toString());
                //userAdViewerLikedIt.setOwnerContentId(userAdViewerLikedItDTO.getContentId());                        
                savedData = this.adViewerLikedItService.saveLikedAds(userAdViewerLikedIt);
                sanoDto.setP1(enc.encryptId(savedData.getId()));
        }catch(Exception ex){ex.printStackTrace();}            
        finally{
            if(savedData==null ){ // Tested working for list == null
                sanoDto.setP3("N");
//                    retrieveAdsContent.setLikedAdsId(userAdViewerLikedItDTO.getLiked());
//                    retrieveAdsContent.setDone("N");
	System.out.println(">>>>>>1 P1="+sanoDto.getP1());        
                response = ResponseEntity.status(HttpStatus.OK)
                  .body(sanoDto);
                return response;    
            } 
            else {
//                response = ResponseEntity.status(HttpStatus.OK)
//                      .header("Status code", HttpStatus.OK.toString())
//                      .header("StatusCode", HttpStatus.OK.toString())
//                      .body(lo.get(0));
               }
        }                 
            
            
        sanoDto.setP2(userAdViewerLikedIt.getAllLikedIds());  //LikedItemIds          
        sanoDto.setP3("Y");    
	System.out.println(">>>>>>2 P1="+sanoDto.getP1());        
//            retrieveAdsContent.setIdOfLikedAds(savedData.getId());
//            retrieveAdsContent.setLikedAdsId(userAdViewerLikedItDTO.getLiked());
//            retrieveAdsContent.setDone("Y");
        response = ResponseEntity.status(HttpStatus.OK)
          .body(sanoDto);

        return response; 
    }

    
    @PostMapping(value = "/saveAdsLiked2/{apiUniqueId}/{apiKey}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<RetrieveAdsContent> saveLikedAds2(@PathVariable String apiUniqueId,@PathVariable String apiKey,
            @RequestBody UserAdViewerLikedItDTO userAdViewerLikedItDTO) {        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> saveLikedAds : "+userAdViewerLikedItDTO.getUserId());
        boolean adViewerExist=false;
        ResponseEntity<RetrieveAdsContent> response=null;
        IdEncryptor enc=new IdEncryptor();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        UserAdViewerLikedIt savedData =null; 
        HashMap<String,String> hashMap = new HashMap<String,String>();
        RetrieveAdsContent retrieveAdsContent=new RetrieveAdsContent();
        
        if(!securityApi.getValid()){
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null);     
        }
        
        try {
            if(securityApi.getViewerUserId()==null)
            {   securityApi.setViewerUserId(enc.decryptId(userAdViewerLikedItDTO.getUserId()));}
        } catch (Exception ex) {
            Logger.getLogger(UserAdViewerLikedItController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi=apiKeyService.save(securityApi);
        } catch (Exception ex) {
            Logger.getLogger(UserAdViewerLikedItController.class.getName()).log(Level.SEVERE, null, ex);
            response = ResponseEntity.status(HttpStatus.OK)
              .body(retrieveAdsContent);
        }
        

            try{

                UserAdViewerLikedIt userAdViewerLikedIt =new UserAdViewerLikedIt() ;
                //userAdViewerLikedIt.setId(enc.decryptId(userAdViewerLikedItDTO.getId()));
                userAdViewerLikedIt.setUserAdViewerId(enc.decryptId(userAdViewerLikedItDTO.getUserId()));
                
                
                try{
                    String[] likeIds = userAdViewerLikedItDTO.getLiked().split(",");
                    StringBuilder strB=new StringBuilder();
                    strB.append(",");
                    for (int i = 1; i < likeIds.length; i++) {
                        strB.append(enc.decryptId(likeIds[i]));


                        strB.append(",");                
                    }
                    userAdViewerLikedIt.setAllLikedIds(strB.toString());
                }catch(Exception ex){}                
                //userAdViewerLikedIt.setOwnerContentId(userAdViewerLikedItDTO.getContentId());                        
                savedData = this.adViewerLikedItService.saveLikedAds(userAdViewerLikedIt);
                
            }catch(Exception ex){ex.printStackTrace();}            
            finally{
                
                if(savedData==null ){ // Tested working for list == null
                    retrieveAdsContent.setLikedAdsId(userAdViewerLikedItDTO.getLiked());
                    retrieveAdsContent.setDone("N");
                    
                    response = ResponseEntity.status(HttpStatus.OK)
                      .body(retrieveAdsContent);
                    return response;    
                } 
                else {
//                response = ResponseEntity.status(HttpStatus.OK)
//                      .header("Status code", HttpStatus.OK.toString())
//                      .header("StatusCode", HttpStatus.OK.toString())
//                      .body(lo.get(0));
                   }
            }            
            retrieveAdsContent.setIdOfLikedAds(savedData.getId());
            retrieveAdsContent.setLikedAdsId(userAdViewerLikedItDTO.getLiked());
            retrieveAdsContent.setDone("Y");
            
            
            response = ResponseEntity.status(HttpStatus.OK)
              .body(retrieveAdsContent);
            
            return response; 
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

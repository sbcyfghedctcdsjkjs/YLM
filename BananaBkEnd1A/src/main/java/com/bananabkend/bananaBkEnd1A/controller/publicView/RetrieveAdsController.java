/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.controller.publicView;

import com.bananabkend.bananaBkEnd1A.Utility.IdEncryptor;
import com.bananabkend.bananaBkEnd1A.Utility.property.ContentStatus;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent;
import com.bananabkend.bananaBkEnd1A.model.SecurityApi;
import com.bananabkend.bananaBkEnd1A.model.dto.SecurityApiDto;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.RetrieveAdsContentDto;
import com.bananabkend.bananaBkEnd1A.service.ApiKeyService;
import com.bananabkend.bananaBkEnd1A.service.publicViewServices.RetrieveAdsContentService;
import com.bananabkend.bananaBkEnd1A.service.UserOwnerService;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author sunjiv6
 */
//VRFY2021
@Api(value = "RetrieveAdsController", tags = {"REST APIs to retrieve ad for public view !!!!","RetrieveAdsContent"})
@RestController
@RequestMapping("/retrieve")
public class RetrieveAdsController {

    RetrieveAdsContentService retrieveAdsContentService;
    UserOwnerService userOwnerService;    
    ApiKeyService apiKeyService;
    
    public RetrieveAdsController(RetrieveAdsContentService retrieveAdsContentService, UserOwnerService userOwnerService
                                    ,ApiKeyService apiKeyService) {
        this.retrieveAdsContentService = retrieveAdsContentService;
        this.userOwnerService = userOwnerService;
        this.apiKeyService = apiKeyService;
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
    
    //VRFY2021
    @RequestMapping(value = "/adsListInPagesByCategory/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AnonymousDto>> listOfAdsInPagesByCategory(@PathVariable String apiUniqueId,@PathVariable String apiKey,
            @RequestBody AnonymousDto anoDto) 
    {
        
        ResponseEntity<List<AnonymousDto>> response=null;
        RetrieveAdsContent retrieveAdsContent= new RetrieveAdsContent();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        retrieveAdsContent.setPageNum(Integer.valueOf(anoDto.getP1()));
        retrieveAdsContent.setAddressSearch(anoDto.getP2());
        retrieveAdsContent.setSelectedFilters(anoDto.getP3());
        retrieveAdsContent.setSelectedAdtype(anoDto.getP4());
        String prodOrBznzType="P";
        if(anoDto.getP10().equals("2"))
        {
            prodOrBznzType="A";
        }
        AnonymousDto sanoDto= new AnonymousDto(); 
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
            Logger.getLogger(RetrieveAdsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{        
            if(retrieveAdsContent.getSelectedAdtype().equals("null") || retrieveAdsContent.getSelectedAdtype().equals(",")){
                retrieveAdsContent.setSelectedAdtype("1,2,3,4");
            }else{
                retrieveAdsContent.setSelectedAdtype(retrieveAdsContent.getSelectedAdtype().
                                substring(1, retrieveAdsContent.getSelectedAdtype().length()-1));//remove commas from Start and End
                 }
            
            List<RetrieveAdsContent> listAdsContent= null;
            if(retrieveAdsContent.getSelectedFilters().equals("null") ||retrieveAdsContent.getSelectedFilters().equals(",")){
                listAdsContent = this.retrieveAdsContentService.getAdsInPages(retrieveAdsContent.getPageNum(),
                                                        ContentStatus.PageSizeOrTotalRecordsSentToUI,
                                                        retrieveAdsContent.getAddressSearch().toUpperCase(),
                                                        retrieveAdsContent.getSelectedAdtype(),prodOrBznzType);
            }else{
                listAdsContent = this.retrieveAdsContentService.getAdsInPagesByCategory(retrieveAdsContent.getPageNum(),
                                                        ContentStatus.WebPageSizeOrTotalRecordsSentToUI,
                                                        retrieveAdsContent.getAddressSearch().toUpperCase(),
                                                        retrieveAdsContent.getSelectedAdtype(),
                                                        retrieveAdsContent.getSelectedFilters(),prodOrBznzType);
            }
//            listAdsContent= this.retrieveAdsContentService.
//                                                getAdsInPages(retrieveAdsContent.getPageNum(),
//                                                        ContentStatus.PageSizeOrTotalRecordsSentToUI,
//                                                        retrieveAdsContent.getAddressSearch().toUpperCase(),
//                                                        retrieveAdsContent.getSelectedAdtype());
            IdEncryptor enc = new IdEncryptor();
            ArrayList<AnonymousDto> listAdsContentDto= new ArrayList<AnonymousDto>();
            RetrieveAdsContentDto rDto=null;
            for (RetrieveAdsContent r : listAdsContent) {
                rDto = new RetrieveAdsContentDto();
                
                rDto.setId(enc.encryptId(r.getId()));
		rDto.setContentDesc(r.getContentDesc());
                rDto.setAdType(r.getAdType());
                rDto.setAdDisplayType(r.getAdDisplayType());
                rDto.setCreatedOn(r.getCreatedOn());
                //rDto.setActiveDate(r.getActiveDate());
                rDto.setPageNum(r.getPageNum());                
                
                sanoDto = new AnonymousDto();
                sanoDto.setP1(rDto.getId());
                sanoDto.setP2(rDto.getCreatedOn());
                sanoDto.setP3(rDto.getContentDesc());
                sanoDto.setP4(String.valueOf(rDto.getAdDisplayType()));
                sanoDto.setP5(rDto.getPageNum());
                sanoDto.setP7(rDto.getAdType());
                listAdsContentDto.add(sanoDto);
                
                

            }
            
//            for (RetrieveAdsContent retrieveAdsContent1 : dtoOwnerContent) {

//                System.out.println(retrieveAdsContent.getAddressSearch()+ "<><><><>id: "+retrieveAdsContent1.getId());

//            }
            
            //System.out.println("<><><><><><><><><><><><><>Size is: "+dtoOwnerContent.size());
            response=ResponseEntity.status(HttpStatus.OK)
                .body(listAdsContentDto);
        }
        catch(Exception ex){

            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(null);                   
        }
        return response;
    }
    
    @RequestMapping(value = "/adsListInPages/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AnonymousDto>> listOfAdsInPages(@PathVariable String apiUniqueId,@PathVariable String apiKey,
            @RequestBody AnonymousDto anoDto) 
    {
        
        ResponseEntity<List<AnonymousDto>> response=null;
        RetrieveAdsContent retrieveAdsContent= new RetrieveAdsContent();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        retrieveAdsContent.setPageNum(Integer.valueOf(anoDto.getP1()));
        retrieveAdsContent.setAddressSearch(anoDto.getP2());
        retrieveAdsContent.setSelectedFilters(anoDto.getP3());
        AnonymousDto sanoDto= new AnonymousDto(); 
        String prodOrBznzType="P";
        if(anoDto.getP10().equals("2"))
        {
            prodOrBznzType="A";
        }
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
            Logger.getLogger(RetrieveAdsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{        
            retrieveAdsContent.setSelectedAdtype("1,2,3,4");
        
            List<RetrieveAdsContent> listAdsContent= this.retrieveAdsContentService.
                                                getAdsInPages(retrieveAdsContent.getPageNum(),
                                                        ContentStatus.PageSizeOrTotalRecordsSentToUI,
                                                        retrieveAdsContent.getAddressSearch().toUpperCase(),
                                                        retrieveAdsContent.getSelectedAdtype(),prodOrBznzType);
            IdEncryptor enc = new IdEncryptor();
            ArrayList<AnonymousDto> listAdsContentDto= new ArrayList<AnonymousDto>();
            RetrieveAdsContentDto rDto=null;
            for (RetrieveAdsContent r : listAdsContent) {
                rDto = new RetrieveAdsContentDto();
                
                rDto.setId(enc.encryptId(r.getId()));
		rDto.setContentDesc(r.getContentDesc());
                rDto.setAdType(r.getAdType());
                rDto.setAdDisplayType(r.getAdDisplayType());
                rDto.setCreatedOn(r.getCreatedOn());
                //rDto.setActiveDate(r.getActiveDate());
                rDto.setPageNum(r.getPageNum());                
                
                sanoDto = new AnonymousDto();
                sanoDto.setP1(rDto.getId());
                sanoDto.setP2(rDto.getCreatedOn());
                sanoDto.setP3(rDto.getContentDesc());
                sanoDto.setP4(String.valueOf(rDto.getAdDisplayType()));
                sanoDto.setP5(rDto.getPageNum());
                sanoDto.setP7(rDto.getAdType());
                listAdsContentDto.add(sanoDto);
                
                

            }
            
//            for (RetrieveAdsContent retrieveAdsContent1 : dtoOwnerContent) {

//                System.out.println(retrieveAdsContent.getAddressSearch()+ "<><><><>id: "+retrieveAdsContent1.getId());

//            }
            
            //System.out.println("<><><><><><><><><><><><><>Size is: "+dtoOwnerContent.size());
            response=ResponseEntity.status(HttpStatus.OK)
                .body(listAdsContentDto);
        }
        catch(Exception ex){

            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(null);                   
        }
        return response;
    }
    


    
}

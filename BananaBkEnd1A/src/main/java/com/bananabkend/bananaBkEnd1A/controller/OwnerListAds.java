/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.controller;

import com.bananabkend.bananaBkEnd1A.Utility.IdEncryptor;
import com.bananabkend.bananaBkEnd1A.Utility.property.ContentStatus;
import com.bananabkend.bananaBkEnd1A.model.OwnerContent;
import com.bananabkend.bananaBkEnd1A.model.OwnerTargetArea;
import com.bananabkend.bananaBkEnd1A.model.SecurityApi;
import com.bananabkend.bananaBkEnd1A.model.UserOwner;
import com.bananabkend.bananaBkEnd1A.model.dto.OwnerContentDto;
import com.bananabkend.bananaBkEnd1A.model.dto.SecurityApiDto;
import com.bananabkend.bananaBkEnd1A.model.dto.UserOwnerDto;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.RetrieveAdsContentDto;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewerLikedIt;
import com.bananabkend.bananaBkEnd1A.service.ApiKeyService;
import com.bananabkend.bananaBkEnd1A.service.OwnerContentService;
import com.bananabkend.bananaBkEnd1A.service.UserOwnerService;
import com.bananabkend.bananaBkEnd1A.service.publicViewServices.AdViewerLikedItService;
import com.bananabkend.bananaBkEnd1A.service.publicViewServices.RetrieveAdsContentService;
import com.bananabkend.bananaBkEnd1A.service.publicViewServices.UserAdViewerService;
import io.swagger.annotations.Api;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.StreamUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author sunjiv6
 */
@Api(value = "OwnerListAds", tags = {"REST APIs to receive ad!!!!","OwnerContent"})
@RestController
@RequestMapping("/owner")
public class OwnerListAds {

    UserAdViewerService userAdViewerService;
    OwnerContentService ownerContentService;
    UserOwnerService userOwnerService;   
    ApiKeyService apiKeyService;
    RetrieveAdsContentService retrieveAdsContentService;
    AdViewerLikedItService adViewerLikedItService; 
    
    public OwnerListAds(OwnerContentService ownerContentService, UserOwnerService userOwnerService,
            UserAdViewerService userAdViewerService,AdViewerLikedItService adViewerLikedItService
                                ,ApiKeyService apiKeyService,RetrieveAdsContentService retrieveAdsContentService) {
        this.ownerContentService = ownerContentService;
        this.userOwnerService = userOwnerService;
        this.apiKeyService = apiKeyService;
        this.userAdViewerService =userAdViewerService;
        this.retrieveAdsContentService= retrieveAdsContentService;
        this.adViewerLikedItService=adViewerLikedItService;
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
    
    
//    START TRying
    @PostMapping(value = "/myList01/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<ArrayList<AnonymousDto>> ownerSeeHisOwnAdsByPhoneEmailPassword(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,BindingResult bindingResult) 
    {
        ResponseEntity<ArrayList<AnonymousDto>> response=null;
        AnonymousDto sanoDto = new AnonymousDto();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid()){
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null); 
            
        }
        IdEncryptor enc = new IdEncryptor();
        UserAdViewer userAdViewer = new UserAdViewer();
//        userAdViewer.setAdViewerEmail(anoDto.getP1());
//        userAdViewer.setAdViewerPhone(anoDto.getP2());
//        userAdViewer.setSecretNumber(anoDto.getP3());
        
        boolean ownerExist=false;
        List<UserAdViewer> lo =null;
        try{ // check if user is genuine
//            lo=userAdViewer.getAdViewerPhone().length()<1 ? this.userAdViewerService.getUserByEmailAndSecretNumber(userAdViewer):
//                    this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer);
            //lo = this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer);
            userAdViewer.setId(enc.decryptId(anoDto.getP1()));            
            lo = this.userAdViewerService.getUserById(userAdViewer);
            if(!lo.isEmpty() && lo.get(0).getId()>0L){
                ownerExist=true;
//                if(securityApi.getOwnerUserId()==null)
//                {   securityApi.setOwnerUserId(lo.get(0).getId());}
                
                
                securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");
                securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                //securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
                securityApi=apiKeyService.save(securityApi);                
            }
            
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!ownerExist){
                response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                  .header("Status code", HttpStatus.UNAUTHORIZED.toString())
                  .header("StatusCode", HttpStatus.UNAUTHORIZED.toString())
                  .body(null);
                return response;
            }
        }
        
        try{        
            ArrayList<OwnerContent> modelOwnerContentList= this.ownerContentService.getAllActiveContentForOwnerUser(
                                            lo.get(0),ContentStatus.ContentType_Ads);
            ArrayList<AnonymousDto> dtoOwnerContentList=new ArrayList<AnonymousDto>() ;
            
            OwnerContentDto dtoOwnerContent= null;
            
            for(OwnerContent modelOwnerContent : modelOwnerContentList)
            {
//                dtoOwnerContent= new OwnerContentDto();
//                dtoOwnerContent.setId_vb(enc.encryptId(modelOwnerContent.getId()));
                
                //dtoOwnerContent.setOwnerUserId_vb(modelOwnerContent.getOwnerUserId());
                //dtoOwnerContent.setUploadedFileName_vb(modelOwnerContent.getUploadedFileName());
//                dtoOwnerContent.setContentDesc_vb(modelOwnerContent.getContentDesc());
//                
//                
//                dtoOwnerContent.setAdType_vb(modelOwnerContent.getAdType());
//                dtoOwnerContent.setCreatedOn_vb(modelOwnerContent.getCreatedOn());
//                dtoOwnerContent.setStatus_vb(modelOwnerContent.getStatus());
//                dtoOwnerContent.setAdDisplayType_vb(modelOwnerContent.getAdDisplayType());
//                dtoOwnerContent.setActiveDate_vb(modelOwnerContent.getActiveDate());

                sanoDto = new AnonymousDto();
                sanoDto.setP1(enc.encryptId(modelOwnerContent.getId()));
                sanoDto.setP2(modelOwnerContent.getContentDesc());
                sanoDto.setP3(modelOwnerContent.getStatus());
                sanoDto.setP4(modelOwnerContent.getCreatedOn());
                sanoDto.setP5(modelOwnerContent.getAdType());
                sanoDto.setP6(modelOwnerContent.getActiveDate());
                sanoDto.setP7(modelOwnerContent.getAdDisplayType());
                
                dtoOwnerContentList.add(sanoDto);
            }
            response=ResponseEntity.status(HttpStatus.OK)
                .body(dtoOwnerContentList);
        }
        catch(Exception ex){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(null);                   
        }
        return response;
    }
    
    @PostMapping(value = "/myList02/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.MULTIPART_FORM_DATA_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<ArrayList<AnonymousDto>> myList02(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,BindingResult bindingResult) 
    {
        ResponseEntity<ArrayList<AnonymousDto>> response=null;
        return response;
    }
    
    @RequestMapping(value = "/myList03/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ArrayList<AnonymousDto>> myList03(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@RequestBody AnonymousDto anoDto,BindingResult bindingResult) 
    {
        //ownerContentDto.setInputFile01_vb(null);//This method/EndPoint doesn't expect any file upload
        ResponseEntity<ArrayList<AnonymousDto>> response=null;
        return response;
    }
    
    
//    STOP TRYING    
    
    
//    @PostMapping(value = "/myList/{apiUniqueId}/{apiKey}",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
//    //@ResponseStatus(value = HttpStatus.CREATED)
//    @ResponseBody
    //VRFY2021
    //@RequestMapping(value = "/myList/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    @PostMapping(value = "/myList/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<ArrayList<AnonymousDto>> myList(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@RequestBody AnonymousDto anoDto,BindingResult bindingResult) 
    {
        //ownerContentDto.setInputFile01_vb(null);//This method/EndPoint doesn't expect any file upload
        ResponseEntity<ArrayList<AnonymousDto>> response=null;
        AnonymousDto sanoDto = new AnonymousDto();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid()){
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null); 
            
        }
        
        //securityApi=apiKeyService.getApiKeyRecordWithApiKey(securityApiDto.getApikey());
        
        
//        UserOwner owner= new UserOwner();
//        owner.setUserPhone(ownerContentDto.getOwnerPhone_vb());
//        owner.setUserEmail(ownerContentDto.getOwnerEmail_vb());
//        owner.setSecretNumberEncoded(ownerContentDto.getSecretNumber_vb());
        
        UserAdViewer userAdViewer = new UserAdViewer();
        userAdViewer.setAdViewerEmail(anoDto.getP1());
        userAdViewer.setAdViewerPhone(anoDto.getP2());
        userAdViewer.setSecretNumber(anoDto.getP3());
        
        boolean ownerExist=false;
        List<UserAdViewer> lo =null;
        try{ // check if user is genuine
            lo=userAdViewer.getAdViewerPhone().length()<1 ? this.userAdViewerService.getUserByEmailAndSecretNumber(userAdViewer):
                    this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer);
            //lo = this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer);
            if(!lo.isEmpty() && lo.get(0).getId()>0L){
                ownerExist=true;
//                if(securityApi.getOwnerUserId()==null)
//                {   securityApi.setOwnerUserId(lo.get(0).getId());}
                
                
                securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");
                securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                //securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
                securityApi=apiKeyService.save(securityApi);                
            }
            
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!ownerExist){
                response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                  .header("Status code", HttpStatus.NOT_FOUND.toString())
                  .header("StatusCode", HttpStatus.NOT_FOUND.toString())
                  .body(null);
                return response;
            }
        }
        
        try{        
            ArrayList<OwnerContent> modelOwnerContentList= this.ownerContentService.getAllActiveContentForOwnerUser(
                                                    lo.get(0),ContentStatus.ContentType_Ads);
            ArrayList<AnonymousDto> dtoOwnerContentList=new ArrayList<AnonymousDto>() ;
            IdEncryptor enc=new IdEncryptor();
            OwnerContentDto dtoOwnerContent= null;
            
            for(OwnerContent modelOwnerContent : modelOwnerContentList)
            {
//                dtoOwnerContent= new OwnerContentDto();
//                dtoOwnerContent.setId_vb(enc.encryptId(modelOwnerContent.getId()));
                
                //dtoOwnerContent.setOwnerUserId_vb(modelOwnerContent.getOwnerUserId());
                //dtoOwnerContent.setUploadedFileName_vb(modelOwnerContent.getUploadedFileName());
//                dtoOwnerContent.setContentDesc_vb(modelOwnerContent.getContentDesc());
//                
//                
//                dtoOwnerContent.setAdType_vb(modelOwnerContent.getAdType());
//                dtoOwnerContent.setCreatedOn_vb(modelOwnerContent.getCreatedOn());
//                dtoOwnerContent.setStatus_vb(modelOwnerContent.getStatus());
//                dtoOwnerContent.setAdDisplayType_vb(modelOwnerContent.getAdDisplayType());
//                dtoOwnerContent.setActiveDate_vb(modelOwnerContent.getActiveDate());

                sanoDto = new AnonymousDto();
                sanoDto.setP1(enc.encryptId(modelOwnerContent.getId()));
                sanoDto.setP2(modelOwnerContent.getContentDesc());
                sanoDto.setP3(modelOwnerContent.getStatus());
                sanoDto.setP4(modelOwnerContent.getCreatedOn());
                sanoDto.setP5(modelOwnerContent.getAdType());
                sanoDto.setP6(modelOwnerContent.getActiveDate());
                sanoDto.setP7(modelOwnerContent.getAdDisplayType());
                
                dtoOwnerContentList.add(sanoDto);
            }
            response=ResponseEntity.status(HttpStatus.OK)
                .body(dtoOwnerContentList);
        }
        catch(Exception ex){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(null);                   
        }
        return response;
    }
    
    //VRFY2021
    @RequestMapping(value = "/ownerSeeHisOwnAdsByOwnerId/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ArrayList<AnonymousDto>> ownerSeeHisOwnAdsByOwnerId(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@RequestBody AnonymousDto anoDto,BindingResult bindingResult) 
    {
        //ownerContentDto.setInputFile01_vb(null);//This method/EndPoint doesn't expect any file upload
        ResponseEntity<ArrayList<AnonymousDto>> response=null;
        AnonymousDto sanoDto = new AnonymousDto();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        IdEncryptor enc=new IdEncryptor();
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid()){
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null); 
            
        }
        
        //securityApi=apiKeyService.getApiKeyRecordWithApiKey(securityApiDto.getApikey());
        
        
//        UserOwner owner= new UserOwner();
//        owner.setUserPhone(ownerContentDto.getOwnerPhone_vb());
//        owner.setUserEmail(ownerContentDto.getOwnerEmail_vb());
//        owner.setSecretNumberEncoded(ownerContentDto.getSecretNumber_vb());
        
        UserAdViewer userAdViewer = new UserAdViewer();
        try {
            userAdViewer.setId(enc.decryptId(anoDto.getP1()));
//        userAdViewer.setAdViewerEmail(anoDto.getP1());
//        userAdViewer.setAdViewerPhone(anoDto.getP2());
//        userAdViewer.setSecretNumber(anoDto.getP3());
        } catch (Exception ex) {
            Logger.getLogger(OwnerListAds.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean ownerExist=false;
        List<UserAdViewer> lo =null;
        try{ // check if user is genuine
            lo= this.userAdViewerService.getUserById(userAdViewer);
            //lo = this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer);
            if(lo != null && !lo.isEmpty() ){
                ownerExist=true;
//                if(securityApi.getOwnerUserId()==null)
//                {   securityApi.setOwnerUserId(lo.get(0).getId());}
                
                
                securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");
                securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                //securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
                securityApi=apiKeyService.save(securityApi);                
            }
            
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!ownerExist){
                response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                  .header("Status code", HttpStatus.NOT_FOUND.toString())
                  .header("StatusCode", HttpStatus.NOT_FOUND.toString())
                  .body(null);
                return response;
            }
        }
        
        try{        
            ArrayList<OwnerContent> modelOwnerContentList= this.ownerContentService.getAllActiveContentForOwnerUser(
                                        lo.get(0),ContentStatus.ContentType_Ads);
            ArrayList<AnonymousDto> dtoOwnerContentList=new ArrayList<AnonymousDto>() ;
            
            OwnerContentDto dtoOwnerContent= null;
            
            for(OwnerContent modelOwnerContent : modelOwnerContentList)
            {
//                dtoOwnerContent= new OwnerContentDto();
//                dtoOwnerContent.setId_vb(enc.encryptId(modelOwnerContent.getId()));
                
                //dtoOwnerContent.setOwnerUserId_vb(modelOwnerContent.getOwnerUserId());
                //dtoOwnerContent.setUploadedFileName_vb(modelOwnerContent.getUploadedFileName());
//                dtoOwnerContent.setContentDesc_vb(modelOwnerContent.getContentDesc());
//                
//                
//                dtoOwnerContent.setAdType_vb(modelOwnerContent.getAdType());
//                dtoOwnerContent.setCreatedOn_vb(modelOwnerContent.getCreatedOn());
//                dtoOwnerContent.setStatus_vb(modelOwnerContent.getStatus());
//                dtoOwnerContent.setAdDisplayType_vb(modelOwnerContent.getAdDisplayType());
//                dtoOwnerContent.setActiveDate_vb(modelOwnerContent.getActiveDate());

                sanoDto = new AnonymousDto();
                sanoDto.setP1(enc.encryptId(modelOwnerContent.getId()));
                sanoDto.setP2(modelOwnerContent.getContentDesc());
                sanoDto.setP3(modelOwnerContent.getStatus());
                sanoDto.setP4(modelOwnerContent.getCreatedOn());
                sanoDto.setP5(modelOwnerContent.getAdType());
                sanoDto.setP6(modelOwnerContent.getActiveDate());
                sanoDto.setP7(modelOwnerContent.getAdDisplayType());
                
                dtoOwnerContentList.add(sanoDto);
            }
            response=ResponseEntity.status(HttpStatus.OK)
                .body(dtoOwnerContentList);
        }
        catch(Exception ex){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(null);                   
        }
        return response;
    }
    
    @PostMapping(value = "/one/ad/info/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto> oneAdInfo(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto) 
    {
        //ownerContent.setInputFile01(null);//This method/EndPoint doesn't expect any file upload
        ResponseEntity<AnonymousDto> response=null;
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid()){
        
            return response = ResponseEntity.status(HttpStatus.OK).body(null);             
        }
        try {
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_C"+anoDto.getP1()+",");
            //securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi=apiKeyService.save(securityApi);
        } catch (Exception ex) {
            Logger.getLogger(OwnerListAds.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        UserOwner owner= new UserOwner();
//        owner.setUserPhone(ownerContentDto.getOwnerPhone_vb());
//        owner.setUserEmail(ownerContentDto.getOwnerEmail_vb());
//        owner.setSecretNumberEncoded(ownerContentDto.getSecretNumber_vb());
        
//        UserAdViewer userAdViewer = new UserAdViewer();
//        userAdViewer.setAdViewerEmail(ownerContentDto.getOwnerEmail_vb());
//        userAdViewer.setAdViewerPhone(ownerContentDto.getOwnerPhone_vb());
//        userAdViewer.setSecretNumber(ownerContentDto.getSecretNumber_vb());
        
        boolean ownerExist=false;
        List<UserAdViewer> lo =null;
//        try{ // check if user is genuine
//            lo = this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer);
//            if(!lo.isEmpty() && lo.get(0).getId()>0L)ownerExist=true;
//        }catch(Exception ex){ex.printStackTrace();}
//        finally{
//            if(!ownerExist){
//                response = ResponseEntity.status(HttpStatus.NOT_FOUND)
//                  .header("Status code", HttpStatus.NOT_FOUND.toString())
//                  .header("StatusCode", HttpStatus.NOT_FOUND.toString())
//                  .body(null);
//                return response;
//            }
//        }

        
        try{      
        IdEncryptor enc=new IdEncryptor();
        Long decryptId = enc.decryptId(anoDto.getP1());
        com.bananabkend.bananaBkEnd1A.model.OwnerContent modelOwnerContent= 
                                                        this.ownerContentService.getOwnerContentById(decryptId);
        com.bananabkend.bananaBkEnd1A.model.dto.OwnerContentDto dtoOwnerContent= new com.bananabkend.bananaBkEnd1A.model.dto.OwnerContentDto();
        AnonymousDto sanoDto = new AnonymousDto();
//        dtoOwnerContent.setId_vb(anoDto.getP1());
        
        //dtoOwnerContent.setOwnerUserId_vb(modelOwnerContent.getOwnerUserId());
        //dtoOwnerContent.setUploadedFileName_vb(modelOwnerContent.getUploadedFileName());
        //dtoOwnerContent.setGeneratedFileName_vb(modelOwnerContent.getGeneratedFileName());
//        dtoOwnerContent.setContentDesc_vb(modelOwnerContent.getContentDesc());
//        dtoOwnerContent.setAdType_vb(modelOwnerContent.getAdType());
//        dtoOwnerContent.setCreatedOn_vb(modelOwnerContent.getCreatedOn());
//        dtoOwnerContent.setStatus_vb(modelOwnerContent.getStatus());
//        dtoOwnerContent.setAdDisplayType_vb(modelOwnerContent.getAdDisplayType());
//        dtoOwnerContent.setActiveDate_vb(modelOwnerContent.getActiveDate());
            //ArrayList<com.bananabkend.bananaBkEnd1A.model.dto.OwnerContentDto> dtoOwnerContent= this.ownerContentService.getAllActiveContentForOwnerUser(lo.get(0));
            
        sanoDto.setP1(anoDto.getP1());
        sanoDto.setP2(modelOwnerContent.getContentDesc());                    
        sanoDto.setP3(modelOwnerContent.getCreatedOn());
        sanoDto.setP4(modelOwnerContent.getStatus());
        sanoDto.setP5(modelOwnerContent.getAdType());
        sanoDto.setP6(modelOwnerContent.getActiveDate());       
        sanoDto.setP7(modelOwnerContent.getAdDisplayType());
        sanoDto.setP10(modelOwnerContent.getCategory());
            response=ResponseEntity.status(HttpStatus.OK)
                .body(sanoDto);
        }
        catch(Exception ex){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(null);                   
        }
        return response;
    }
    
    
    @PostMapping(value = "/myList2/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<ArrayList<AnonymousDto>> myList2(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,BindingResult bindingResult) 
    {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> myList2 by phone: ");
        //ownerContentDto.setInputFile01_vb(null);//This method/EndPoint doesn't expect any file upload
        ResponseEntity<ArrayList<AnonymousDto>> response=null;
        RetrieveAdsContent retrieveAdsContent= new RetrieveAdsContent();
        
        retrieveAdsContent.setPageNum(Integer.valueOf(anoDto.getP2()));
        retrieveAdsContent.setAddressSearch(anoDto.getP3());
        retrieveAdsContent.setSelectedFilters(anoDto.getP4());
        retrieveAdsContent.setSelectedAdtype(anoDto.getP6());
        String prodOrBznzType="A";
//        if(anoDto.getP10().equals("2"))
//        {
//            prodOrBznzType="A";
//        }
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid()  ){
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null);             
        }
        
        IdEncryptor enc = new IdEncryptor();
        //securityApi=apiKeyService.getApiKeyRecordWithApiKey(securityApiDto.getApikey());
        
        
//        UserOwner owner= new UserOwner();
//        owner.setUserPhone(ownerContentDto.getOwnerPhone_vb());
//        owner.setUserEmail(ownerContentDto.getOwnerEmail_vb());
//        owner.setSecretNumberEncoded(ownerContentDto.getSecretNumber_vb());
        
        UserAdViewer userAdViewer = new UserAdViewer();
        
//        userAdViewer.setAdViewerEmail(ownerContentDto.getOwnerEmail_vb());
//        userAdViewer.setAdViewerPhone(ownerContentDto.getOwnerPhone_vb());
//        userAdViewer.setSecretNumber(ownerContentDto.getSecretNumber_vb());
        List<UserAdViewer> lo =null;
        if(anoDto.getP1().equals("undefined")){
                securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
            }else{        
                    try{ // check if user is genuine
                    userAdViewer.setId(enc.decryptId(anoDto.getP1()));
                    lo = this.userAdViewerService.getUserById(userAdViewer);
                        if(!lo.isEmpty() && lo.get(0).getId()>0L){
                           
                            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");                            
                        }
                    } catch(Exception ex){ex.printStackTrace();}
            }
        
        try { //saveTrack
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            //securityApi.setSearch(securityApi.getSearch() - 1);
            securityApi=apiKeyService.save(securityApi);
            
            if(lo.get(0).getSearch()<1){ // when access limit is reached
                response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(null);  
            }else{
                lo.get(0).setSearch(lo.get(0).getSearch()-1);
                this.userAdViewerService.save(lo.get(0));
            }
        } catch (Exception ex) {
        
            Logger.getLogger(OwnerListAds.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       try{        
            Integer pageNum = Integer.parseInt(anoDto.getP2());
            String searchStr = anoDto.getP3();
            searchStr=searchStr.trim().replaceAll("\\s+", " ");   // multiple space to a single space
            searchStr=searchStr.trim().replaceAll(",\\s+", ",");   // comma & multiple space to a single comma
            searchStr=searchStr.trim().replaceAll(",\\s", ","); // comma & single space to a single comma
            searchStr=searchStr.trim().replaceAll("\\s+,", " ,"); // multi space & comma to a single space & comma
            searchStr=searchStr.trim().replaceAll("\\s,", ","); // single space & comma to a single comma
            if(retrieveAdsContent.getSelectedAdtype().equals(",") ||retrieveAdsContent.getSelectedAdtype().equals("undefined")){
                retrieveAdsContent.setSelectedAdtype("1,2,3,4");
            }else{
                retrieveAdsContent.setSelectedAdtype(retrieveAdsContent.getSelectedAdtype().
                                substring(1, retrieveAdsContent.getSelectedAdtype().length()-1));//remove commas from Start and End
                 }
            List<RetrieveAdsContent> listAdsContent= null;
                    
            if(retrieveAdsContent.getSelectedFilters().equals(",") ||retrieveAdsContent.getSelectedFilters().equals("undefined")){
                listAdsContent = this.retrieveAdsContentService.getAdsInPages(pageNum,
                                                        ContentStatus.WebPageSizeOrTotalRecordsSentToUI,
                                                        searchStr.toUpperCase(),
                                                        retrieveAdsContent.getSelectedAdtype(),prodOrBznzType);
            }else{
                listAdsContent = this.retrieveAdsContentService.getAdsInPagesByCategory(pageNum,
                                                        ContentStatus.WebPageSizeOrTotalRecordsSentToUI,
                                                        searchStr.toUpperCase(),
                                                        retrieveAdsContent.getSelectedAdtype(),
                                                        retrieveAdsContent.getSelectedFilters(),prodOrBznzType);
            }
            ArrayList<AnonymousDto> listAdsContentDto= new ArrayList<AnonymousDto>();
            AnonymousDto sanoDto= new AnonymousDto();
            
            OwnerContentDto oDto=null;
            for (RetrieveAdsContent r : listAdsContent) {
                sanoDto= new AnonymousDto();
//                oDto = new OwnerContentDto();                
//                oDto.setId_vb(enc.encryptId(r.getId()));
//                
//                oDto.setContentDesc_vb(r.getContentDesc());
//                oDto.setAdType_vb(r.getAdType());
//                oDto.setAdDisplayType_vb(r.getAdDisplayType());
//                oDto.setCreatedOn_vb(r.getCreatedOn());
//                oDto.setPageNum(r.getPageNum()); 
//                
                
                sanoDto.setP1(enc.encryptId(r.getId()));
                //sanoDto.setP1(String.valueOf(r.getId()));
                sanoDto.setP2(r.getContentDesc());
                sanoDto.setP3(String.valueOf(r.getPageNum())); 
                //sanoDto.setP4
                sanoDto.setP5(r.getAdType());
                sanoDto.setP6(r.getCreatedOn());  
                sanoDto.setP7(r.getAdDisplayType());  
                sanoDto.setP10(anoDto.getP10());  
                sanoDto.setP11(String.valueOf(r.getPrice()));
                sanoDto.setP12(r.getUnitDetail());     
                sanoDto.setP15(r.getContentName());
                listAdsContentDto.add(sanoDto);
            }
            response=ResponseEntity.status(HttpStatus.OK)
                .body(listAdsContentDto);
        }
        catch(Exception ex){

            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(null);                   
        }
        
//        try{        
//            ArrayList<OwnerContent> modelOwnerContentList= this.ownerContentService.getAllActiveContentForOwnerUser(lo.get(0));
//            ArrayList<OwnerContentDto> dtoOwnerContentList=new ArrayList<OwnerContentDto>() ;
//            OwnerContentDto dtoOwnerContent= null;
//            for(OwnerContent modelOwnerContent : modelOwnerContentList)
//            {
//                dtoOwnerContent= new OwnerContentDto();
//                dtoOwnerContent.setId_vb(enc.encryptId(modelOwnerContent.getId()));
//                dtoOwnerContent.setOwnerUserId_vb(modelOwnerContent.getOwnerUserId());
//                dtoOwnerContent.setUploadedFileName_vb(modelOwnerContent.getUploadedFileName());
//                dtoOwnerContent.setContentDesc_vb(modelOwnerContent.getContentDesc());
//                
//                dtoOwnerContent.setAdType_vb(modelOwnerContent.getAdType());
//                dtoOwnerContent.setCreatedOn_vb(modelOwnerContent.getCreatedOn());
//                dtoOwnerContent.setStatus_vb(modelOwnerContent.getStatus());
//                dtoOwnerContent.setAdDisplayType_vb(modelOwnerContent.getAdDisplayType());
//                dtoOwnerContent.setActiveDate_vb(modelOwnerContent.getActiveDate());
//                dtoOwnerContentList.add(dtoOwnerContent);
//            }
//            response=ResponseEntity.status(HttpStatus.OK)
//                .body(dtoOwnerContentList);
//        }
//        catch(Exception ex){
//            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                  .body(null);                   
//        }
        return response; 
    }

    @PostMapping(value = "/likedAdsListInPagesByCategory/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<ArrayList<AnonymousDto>> likedAdsListInPagesByCategory(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,BindingResult bindingResult) 
    {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> likedAdsListInPagesByCategory by web: ");
        //ownerContentDto.setInputFile01_vb(null);//This method/EndPoint doesn't expect any file upload
        ResponseEntity<ArrayList<AnonymousDto>> response=null;
        RetrieveAdsContent retrieveAdsContent= new RetrieveAdsContent();
        
        retrieveAdsContent.setPageNum(Integer.valueOf(anoDto.getP2()));
        retrieveAdsContent.setAddressSearch(anoDto.getP3());
        retrieveAdsContent.setSelectedFilters(anoDto.getP4());
        retrieveAdsContent.setSelectedAdtype(anoDto.getP6());
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid()  ){
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null);             
        }
        
        IdEncryptor enc = new IdEncryptor();
        //securityApi=apiKeyService.getApiKeyRecordWithApiKey(securityApiDto.getApikey());
        
        
//        UserOwner owner= new UserOwner();
//        owner.setUserPhone(ownerContentDto.getOwnerPhone_vb());
//        owner.setUserEmail(ownerContentDto.getOwnerEmail_vb());
//        owner.setSecretNumberEncoded(ownerContentDto.getSecretNumber_vb());
        
        UserAdViewer userAdViewer = new UserAdViewer();
        
//        userAdViewer.setAdViewerEmail(ownerContentDto.getOwnerEmail_vb());
//        userAdViewer.setAdViewerPhone(ownerContentDto.getOwnerPhone_vb());
//        userAdViewer.setSecretNumber(ownerContentDto.getSecretNumber_vb());
        List<UserAdViewer> lo =null;
        if(anoDto.getP1().equals("undefined")){
                securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
            }else{        
                    try{ // check if user is genuine
                    userAdViewer.setId(enc.decryptId(anoDto.getP1()));
                    lo = this.userAdViewerService.getUserById(userAdViewer);
                        if(!lo.isEmpty() && lo.get(0).getId()>0L){
                           
                            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");                            
                        }
                    } catch(Exception ex){ex.printStackTrace();}
            }
        
        try { //saveTrack
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            //securityApi.setSearch(securityApi.getSearch() - 1);
            securityApi=apiKeyService.save(securityApi);
            
            if(lo.get(0).getSearch()<1){ // when access limit is reached
                response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(null);  
            }else{
                lo.get(0).setSearch(lo.get(0).getSearch()-1);
                this.userAdViewerService.save(lo.get(0));
            }
        } catch (Exception ex) {
        
            Logger.getLogger(OwnerListAds.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       try{        
            Integer pageNum = Integer.parseInt(anoDto.getP2());
            String searchStr = anoDto.getP3();
            if(retrieveAdsContent.getSelectedAdtype().equals(",") ||retrieveAdsContent.getSelectedAdtype().equals("undefined")){
                retrieveAdsContent.setSelectedAdtype("1,2,3,4");
            }else{
                retrieveAdsContent.setSelectedAdtype(retrieveAdsContent.getSelectedAdtype().
                                substring(1, retrieveAdsContent.getSelectedAdtype().length()-1));//remove commas from Start and End
                 }
            List<RetrieveAdsContent> listAdsContent= null;
            String likedIds = this.adViewerLikedItService.getLikedAdsContentIdWithCommaStr(new UserAdViewerLikedIt(userAdViewer.getId()));
            if(likedIds.length()>2){
                likedIds=likedIds.substring(1, likedIds.length()-1);
            }
            
            if(retrieveAdsContent.getSelectedFilters().equals(",") ||retrieveAdsContent.getSelectedFilters().equals("undefined")){
                listAdsContent = this.adViewerLikedItService.getLikedAdsInPages(pageNum,
                                                        ContentStatus.WebPageSizeOrTotalRecordsSentToUI,
                                                        retrieveAdsContent.getSelectedAdtype(),likedIds,userAdViewer.getId());
            }else{
                listAdsContent = this.adViewerLikedItService.getLikedAdsInPagesByCategory(pageNum,
                                                        ContentStatus.WebPageSizeOrTotalRecordsSentToUI,
                                                        //searchStr.toUpperCase(),
                                                        
                                                        retrieveAdsContent.getSelectedAdtype(),retrieveAdsContent.getSelectedFilters(),
                                                        likedIds,userAdViewer.getId());
            }
            ArrayList<AnonymousDto> listAdsContentDto= new ArrayList<AnonymousDto>();
            AnonymousDto sanoDto= new AnonymousDto();
            
            OwnerContentDto oDto=null;
            for (RetrieveAdsContent r : listAdsContent) {
                sanoDto= new AnonymousDto();
//                oDto = new OwnerContentDto();                
//                oDto.setId_vb(enc.encryptId(r.getId()));
//                
//                oDto.setContentDesc_vb(r.getContentDesc());
//                oDto.setAdType_vb(r.getAdType());
//                oDto.setAdDisplayType_vb(r.getAdDisplayType());
//                oDto.setCreatedOn_vb(r.getCreatedOn());
//                oDto.setPageNum(r.getPageNum()); 
//                
                
                sanoDto.setP1(enc.encryptId(r.getId()));
                //sanoDto.setP1(String.valueOf(r.getId()));
                sanoDto.setP2(r.getContentDesc());
                sanoDto.setP3(String.valueOf(r.getPageNum())); 
                //sanoDto.setP4
                sanoDto.setP5(r.getAdType());
                sanoDto.setP6(r.getCreatedOn());  
                sanoDto.setP7(r.getAdDisplayType());  
                listAdsContentDto.add(sanoDto);
            }
            response=ResponseEntity.status(HttpStatus.OK)
                .body(listAdsContentDto);
        }
        catch(Exception ex){

            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(null);                   
        }
        
//        try{        
//            ArrayList<OwnerContent> modelOwnerContentList= this.ownerContentService.getAllActiveContentForOwnerUser(lo.get(0));
//            ArrayList<OwnerContentDto> dtoOwnerContentList=new ArrayList<OwnerContentDto>() ;
//            OwnerContentDto dtoOwnerContent= null;
//            for(OwnerContent modelOwnerContent : modelOwnerContentList)
//            {
//                dtoOwnerContent= new OwnerContentDto();
//                dtoOwnerContent.setId_vb(enc.encryptId(modelOwnerContent.getId()));
//                dtoOwnerContent.setOwnerUserId_vb(modelOwnerContent.getOwnerUserId());
//                dtoOwnerContent.setUploadedFileName_vb(modelOwnerContent.getUploadedFileName());
//                dtoOwnerContent.setContentDesc_vb(modelOwnerContent.getContentDesc());
//                
//                dtoOwnerContent.setAdType_vb(modelOwnerContent.getAdType());
//                dtoOwnerContent.setCreatedOn_vb(modelOwnerContent.getCreatedOn());
//                dtoOwnerContent.setStatus_vb(modelOwnerContent.getStatus());
//                dtoOwnerContent.setAdDisplayType_vb(modelOwnerContent.getAdDisplayType());
//                dtoOwnerContent.setActiveDate_vb(modelOwnerContent.getActiveDate());
//                dtoOwnerContentList.add(dtoOwnerContent);
//            }
//            response=ResponseEntity.status(HttpStatus.OK)
//                .body(dtoOwnerContentList);
//        }
//        catch(Exception ex){
//            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                  .body(null);                   
//        }
        return response; 
    }

}

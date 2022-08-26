/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.controller;

import com.bananabkend.bananaBkEnd1A.Utility.IdEncryptor;
import com.bananabkend.bananaBkEnd1A.Utility.property.ContentStatus;
import com.bananabkend.bananaBkEnd1A.model.OwnerContent;
import com.bananabkend.bananaBkEnd1A.model.SecurityApi;
import com.bananabkend.bananaBkEnd1A.model.dto.OwnerContentDto;
import com.bananabkend.bananaBkEnd1A.model.dto.SecurityApiDto;
import com.bananabkend.bananaBkEnd1A.service.ApiKeyService;
import com.bananabkend.bananaBkEnd1A.service.OwnerContentService;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunjiv6
 */
@RestController
@RequestMapping("/imageshow")
public class ShowImageController {
    
    OwnerContentService ownerContentService;
    ApiKeyService apiKeyService;
    
    public ShowImageController(OwnerContentService ownerContentService,ApiKeyService apiKeyService) {
        this.ownerContentService = ownerContentService;
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
    
    @GetMapping(value = { "/image/show/{apiUniqueId}/{apiKey}/{contentIdStr}" })
    public ResponseEntity<byte[]> showImage(@PathVariable String apiUniqueId,@PathVariable String contentIdStr,
            @PathVariable String apiKey) {
        byte[] bytes=null;
        Long contentId=0L;
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        String ext = null;
        if(!securityApi.getValid()){
            return null; 
            
            
        }                
        try {
            IdEncryptor enc = new IdEncryptor();
            contentId= enc.decryptId(contentIdStr);
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_C"+contentId+",");
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi=apiKeyService.save(securityApi);
        } catch (Exception ex) {
            Logger.getLogger(ShowImageController.class.getName()).log(Level.SEVERE, null, ex);
            ResponseEntity
                .ok()
                .body(bytes);
        }
        
        try {
        com.bananabkend.bananaBkEnd1A.model.OwnerContent modelOwnerContent= 
                                                        this.ownerContentService.getOwnerContentById(contentId);
//        OwnerContentDto dtoOwnerContent= new OwnerContentDto();
//        dtoOwnerContent.setId_vb(modelOwnerContent.getId());
//        dtoOwnerContent.setOwnerUserId_vb(modelOwnerContent.getOwnerUserId());
//        dtoOwnerContent.setUploadedFileName_vb(modelOwnerContent.getUploadedFileName());
//        dtoOwnerContent.setGeneratedFileName_vb(modelOwnerContent.getGeneratedFileName());
//        dtoOwnerContent.setContentDesc_vb(modelOwnerContent.getContentDesc());
//        dtoOwnerContent.setAdType_vb(modelOwnerContent.getAdType());
//        dtoOwnerContent.setCreatedOn_vb(modelOwnerContent.getCreatedOn());
//        dtoOwnerContent.setStatus_vb(modelOwnerContent.getStatus());
//        dtoOwnerContent.setAdDisplayType_vb(modelOwnerContent.getAdDisplayType());
//        dtoOwnerContent.setActiveDate_vb(modelOwnerContent.getActiveDate());
        File diskFile =null;
        ext = modelOwnerContent.getUploadedFileName().substring(modelOwnerContent.getUploadedFileName().lastIndexOf(".")+1);
        String rootPath = ContentStatus.DirPathArray[ContentStatus.DirPathIndex];
        File dir = new File(rootPath);
        diskFile = new File(dir.getAbsolutePath() + File.separator + modelOwnerContent.getGeneratedFileName());
        
        
            bytes = StreamUtils.copyToByteArray(new FileInputStream(diskFile));
        } catch (Exception ex) {
            Logger.getLogger(ShowImageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf("image/"+ext))
                .body(bytes);
    }
    
    @GetMapping(value = { "/image/icon/{apiUniqueId}/{apiKey}/{contentIdStr}" })
    public ResponseEntity<byte[]> showImageIcon(@PathVariable String apiUniqueId,@PathVariable String contentIdStr,
            @PathVariable String apiKey) {
        byte[] bytes=null;
        String ext = null;
        Long contentId=0L;
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid()){
            return null;             
        }
                
        try {
            IdEncryptor enc = new IdEncryptor();
            contentId= enc.decryptId(contentIdStr);
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_C"+contentId+",");
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi=apiKeyService.save(securityApi);
        } catch (Exception ex) {
            Logger.getLogger(ShowImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
        com.bananabkend.bananaBkEnd1A.model.OwnerContent modelOwnerContent= 
                                                        this.ownerContentService.getOwnerContentById(contentId);
//        OwnerContentDto dtoOwnerContent= new OwnerContentDto();
//        dtoOwnerContent.setId_vb(modelOwnerContent.getId());
//        dtoOwnerContent.setOwnerUserId_vb(modelOwnerContent.getOwnerUserId());
//        dtoOwnerContent.setUploadedFileName_vb(modelOwnerContent.getUploadedFileName());
//        dtoOwnerContent.setGeneratedFileName_vb(modelOwnerContent.getGeneratedFileName());
//        dtoOwnerContent.setContentDesc_vb(modelOwnerContent.getContentDesc());
//        dtoOwnerContent.setAdType_vb(modelOwnerContent.getAdType());
//        dtoOwnerContent.setCreatedOn_vb(modelOwnerContent.getCreatedOn());
//        dtoOwnerContent.setStatus_vb(modelOwnerContent.getStatus());
//        dtoOwnerContent.setAdDisplayType_vb(modelOwnerContent.getAdDisplayType());
//        dtoOwnerContent.setActiveDate_vb(modelOwnerContent.getActiveDate());
        File diskFile =null;
        ext = modelOwnerContent.getUploadedFileName().substring(modelOwnerContent.getUploadedFileName().lastIndexOf(".")+1);
                
        String rootPath = ContentStatus.DirPathArray[ContentStatus.DirPathIndex];
        File dir = new File(rootPath);
        diskFile = new File(dir.getAbsolutePath() + File.separator + modelOwnerContent.getGeneratedFileName()+"_icon");
        
        
            bytes = StreamUtils.copyToByteArray(new FileInputStream(diskFile));
        } catch (Exception ex) {
            Logger.getLogger(ShowImageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf("image/"+ext))
                .body(bytes);
    }
    
    
    //NOT WORKING
    @PostMapping(value = { "/image/showPost" })
    public ResponseEntity<byte[]> showImagePost(@ModelAttribute OwnerContent ownerContent) {
        byte[] bytes=null;
        try {
        
            com.bananabkend.bananaBkEnd1A.model.OwnerContent modelOwnerContent= 
                                                        this.ownerContentService.getOwnerContentById(1L);
//            OwnerContentDto dtoOwnerContent= new OwnerContentDto();
//        //dtoOwnerContent.setId_vb(modelOwnerContent.getId());
//        dtoOwnerContent.setOwnerUserId_vb(modelOwnerContent.getOwnerUserId());
//        dtoOwnerContent.setUploadedFileName_vb(modelOwnerContent.getUploadedFileName());
//        dtoOwnerContent.setGeneratedFileName_vb(modelOwnerContent.getGeneratedFileName());
//        dtoOwnerContent.setContentDesc_vb(modelOwnerContent.getContentDesc());
//        dtoOwnerContent.setAdType_vb(modelOwnerContent.getAdType());
//        dtoOwnerContent.setCreatedOn_vb(modelOwnerContent.getCreatedOn());
//        dtoOwnerContent.setStatus_vb(modelOwnerContent.getStatus());
//        dtoOwnerContent.setAdDisplayType_vb(modelOwnerContent.getAdDisplayType());
//        dtoOwnerContent.setActiveDate_vb(modelOwnerContent.getActiveDate());
        File diskFile =null;
        String rootPath = ContentStatus.DirPathArray[ContentStatus.DirPathIndex];
        File dir = new File(rootPath);
        diskFile = new File(dir.getAbsolutePath() + File.separator + modelOwnerContent.getGeneratedFileName());
        
        
            bytes = StreamUtils.copyToByteArray(new FileInputStream(diskFile));
        } catch (Exception ex) {
            Logger.getLogger(ShowImageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(bytes);
    }
}
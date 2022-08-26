/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.controller;

import com.bananabkend.bananaBkEnd1A.Utility.IdEncryptor;
import com.bananabkend.bananaBkEnd1A.Utility.property.ContentStatus;
import com.bananabkend.bananaBkEnd1A.model.SecurityApi;
import com.bananabkend.bananaBkEnd1A.model.dto.SecurityApiDto;
import com.bananabkend.bananaBkEnd1A.model.dto.UserOwnerDto;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer;
import com.bananabkend.bananaBkEnd1A.service.ApiKeyService;
import com.bananabkend.bananaBkEnd1A.service.UserOwnerService;
import com.bananabkend.bananaBkEnd1A.service.publicViewServices.UserAdViewerService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunjiv6
 */
@PropertySource(value = "classpath:/application.properties", ignoreResourceNotFound = true)
@RestController
@RequestMapping("/opsLogin")
public class OperatorLoginController {
    UserAdViewerService userAdViewerService;
    UserOwnerService userOwnerService;   
    ApiKeyService apiKeyService;
    
    
    @Value("${dns.name}")
    private String dnsName;
    
    public OperatorLoginController(UserAdViewerService userAdViewerService,UserOwnerService userOwnerService,ApiKeyService apiKeyService) {
        
        this.userAdViewerService = userAdViewerService;
        this.userOwnerService = userOwnerService;
        this.apiKeyService = apiKeyService;
    }
    
    
    @PostMapping(value = "/myList2/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<ArrayList<UserOwnerDto>> myList2(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute UserOwnerDto ownerContentDto,BindingResult bindingResult) 
    {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> myList2 by phone: ");
        ResponseEntity<ArrayList<UserOwnerDto>> response=null;
        
        response = ResponseEntity.status(HttpStatus.OK).body(null);
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
    
    @PostMapping(value = "/validateUserPhone/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto> validateUserPhone(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult,HttpServletRequest req ) 
    {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> op validate by phone: ");
        boolean adViewerExist=false;
        ResponseEntity<AnonymousDto> response=null;
        IdEncryptor enc = new IdEncryptor();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid()){ //check API key
            return response = ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                  .body(null);     
        
        }
       
        UserAdViewer userAdViewer=new UserAdViewer();
        UserOwnerDto  userDto= new UserOwnerDto();
        AnonymousDto sanoDto=new AnonymousDto();
        List<UserAdViewer> lo =null;
        try{ // check if user is genuine
            
            userAdViewer.setAdViewerEmail(anoDto.getP1());
            userAdViewer.setAdViewerPhone(anoDto.getP2());
            userAdViewer.setSecretNumber(anoDto.getP3());
            
            lo = this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer);
            if(!lo.isEmpty() && lo.get(0).getId()>0L)adViewerExist=true;
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!adViewerExist){
                response = ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                  
                  .header("StatusCode", HttpStatus.NOT_MODIFIED.toString())
                  .body(sanoDto);
                return response;    
            }            
        }
        try { //Save access track
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi=apiKeyService.save(securityApi);
            userDto.setId(enc.encryptId(lo.get(0).getId()));
            if(lo.get(0).getUserType().equals(ContentStatus.AdminUser))
                sanoDto.setP1("true");
            else throw new Exception("");
        } catch (Exception ex) {
            Logger.getLogger(OperatorLoginController.class.getName()).log(Level.SEVERE, null, ex);
            response = ResponseEntity.status(HttpStatus.NOT_MODIFIED)
              .body(sanoDto);
        }
        response = ResponseEntity.status(HttpStatus.OK).body(sanoDto);
        return response; 
    }    
    
    @PostMapping(value = "/validateUserEmail/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto> validateUserEmail(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult, HttpServletRequest req) 
    {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> op validateUserEmail: ");
        boolean adViewerExist=false;
        ResponseEntity<AnonymousDto> response=null;
        IdEncryptor enc = new IdEncryptor();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid()){ //check API key
            return response = ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                  .body(null);     
        
        }
       
        UserAdViewer userAdViewer=new UserAdViewer();
        UserOwnerDto  userDto= new UserOwnerDto();
        AnonymousDto sanoDto=new AnonymousDto();
        List<UserAdViewer> lo =null;
        try{ // check if user is genuine
            
            userAdViewer.setAdViewerEmail(anoDto.getP3());
            userAdViewer.setAdViewerPhone(anoDto.getP2());
            userAdViewer.setSecretNumber(anoDto.getP1());
            
            lo = this.userAdViewerService.getUserByEmailAndSecretNumber(userAdViewer);
            if(!lo.isEmpty() && lo.get(0).getId()>0L)adViewerExist=true;
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!adViewerExist){
                response = ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                  .body(sanoDto);
                return response;    
            }

        }
                 
        try { //Save access track
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi=apiKeyService.save(securityApi);
            userDto.setId(enc.encryptId(lo.get(0).getId()));
            
            if(lo.get(0).getUserType().equals(ContentStatus.AdminUser))
                sanoDto.setP1("true");
            else throw new Exception("");
            
        } catch (Exception ex) {
            Logger.getLogger(OperatorLoginController.class.getName()).log(Level.SEVERE, null, ex);
            response = ResponseEntity.status(HttpStatus.NOT_MODIFIED)
              .body(sanoDto);
        }
        response = ResponseEntity.status(HttpStatus.OK).body(sanoDto);
        return response;         
    }    
    
    
    @PostMapping(value = "/registerNewUser/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<UserOwnerDto> registerNewUser(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult,HttpServletRequest req) 
    {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> op registerNewUser: ");
        ResponseEntity<UserOwnerDto> response=null;
        SecurityApiDto securityApiDto=new SecurityApiDto();
            securityApiDto.setApikey_vb(apiKey);
            SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid()){
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null);     
        }
        
        UserAdViewer newUserAdViewer=null;
        UserAdViewer userAdViewer=new UserAdViewer();
        UserOwnerDto  userDto= new UserOwnerDto();
        try {
            //userAdViewer.setId(Long.MIN_VALUE);
             userAdViewer.setAdViewerPhone(anoDto.getP3());
             userAdViewer.setAdViewerEmail(anoDto.getP2());
             userAdViewer.setSecretNumber(anoDto.getP1());
             userAdViewer.setUserName(anoDto.getP4());
             userAdViewer.setUserCreatedDate(String.valueOf(System.currentTimeMillis()));
             userAdViewer.setUserType(ContentStatus.OpsUser);
             userAdViewer.setCreateLimit(0);
             userAdViewer.setCreateCount(0);
             userAdViewer.setUserStatus("Y");
             
            newUserAdViewer = userAdViewerService.registerNewUserByPhone(userAdViewer);
        } catch (Exception ex) {
            Logger.getLogger(OperatorLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {            
            securityApi.setViewerUserId(newUserAdViewer==null ? 0: newUserAdViewer.getId());
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+String.valueOf(securityApi.getViewerUserId())+",");
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi=apiKeyService.save(securityApi);
        } catch (Exception ex) {
            Logger.getLogger(OperatorLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(newUserAdViewer ==null) {
            response = ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                       .header("StatusCode", HttpStatus.NOT_MODIFIED.toString())
                       .body(userDto);
        } else {
            IdEncryptor enc = new IdEncryptor();
            try {
                userDto.setId(enc.encryptId(newUserAdViewer.getId()));
                String host =req.getHeader("host");            
                String[] hostnPort = host.split(":");
                

                if(newUserAdViewer.getUserType().equals(ContentStatus.OwnerUser))    // will always fail            
                    userDto.setMsg_vb(req.getScheme()+"://"+hostnPort[0]+":4011/owner");

                if(newUserAdViewer.getUserType().equals(ContentStatus.ViewerUser))                
                    userDto.setMsg_vb(req.getScheme()+"://"+hostnPort[0]+":4110/showMain/"+apiKey+"/"+userDto.getId());

                } catch (Exception ex) {
                    Logger.getLogger(OperatorLoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                response = ResponseEntity.status(HttpStatus.OK)
                      .body(userDto);
        }
        return response;
        
    }  
    
}
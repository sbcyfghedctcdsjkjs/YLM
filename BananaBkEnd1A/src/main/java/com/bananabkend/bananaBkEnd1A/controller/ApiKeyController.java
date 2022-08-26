/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.controller;

import com.bananabkend.bananaBkEnd1A.Utility.AngularPageNameEncryptor;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunjiv6
 */
@RestController
@RequestMapping("/apiTracker")
public class ApiKeyController {
    
    private ApiKeyService apiKeyService;
    
    public ApiKeyController(ApiKeyService apiKeyService) {
        
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
            if(securityApi.getId()==null){
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
    
    @PostMapping(value = "/recordStep01/{apiUniqueId}/{apiKey}",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto> recordStep01(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult ) 
    {
         System.out.println(">>>>>>>>>>>>>>>>>>>>>> validate by phone: ");
         return null;
    } 
    
    @PostMapping(value = "/recordStep02/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto> recordStep02(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult,HttpServletRequest req ) 
    {
         System.out.println(">>>>>>>>>>>>>>>>>>>>>> validate by phone: ");
         return null;
    } 
    
    
    @PostMapping(value = "/recordStep/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
        public ResponseEntity<AnonymousDto> recordStep(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult,HttpServletRequest req ) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> validate by phone: ");
        boolean adViewerExist=false;
        ResponseEntity<AnonymousDto> response=null;
        IdEncryptor enc = new IdEncryptor();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        AnonymousDto sanoDto = new AnonymousDto();
        if(!securityApi.getValid()){ //check API key
            sanoDto.setP3("N");
            return response = ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                  .body(sanoDto);     
        
        }
       
        UserAdViewer userAdViewer=new UserAdViewer();
        UserOwnerDto  userDto= new UserOwnerDto();
        List<UserAdViewer> lo =null;
        try{ // check if user is genuine
            if(AngularPageNameEncryptor.decryptPageName(anoDto.getP1())==null) throw new Exception("Virus Error: Request Modified: Email>50:  "+anoDto.getP1().substring(0,10));
//            if(anoDto.getP2().length()>15) throw new Exception("Virus Error: Request Modified: Phone>15:  "+anoDto.getP2().substring(0,10));
//            if(anoDto.getP3().length()>3) throw new Exception("Virus Error: Request Modified: secretNum>3:  "+anoDto.getP1().substring(0,3));
//            userAdViewer.setAdViewerEmail(anoDto.getP1());
//            userAdViewer.setAdViewerPhone(anoDto.getP2());
//            userAdViewer.setSecretNumber(anoDto.getP3());
//            
            //lo = this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer);
            //if(!lo.isEmpty() && lo.get(0).getId()>0L)adViewerExist=true;
        }catch(Exception ex){ex.printStackTrace();
        
                sanoDto.setP3("N");
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST)                  
                  .header("StatusCode", HttpStatus.BAD_REQUEST.toString())
                  .body(sanoDto);
                return response;  
        }
        finally{
//            if(!adViewerExist){
//                try {
//                    securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_g,");
//                    securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
//                    securityApi=apiKeyService.save(securityApi);
//                } catch (Exception ex) {
//                    Logger.getLogger(WebLoginController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                sanoDto.setP3("N");
//                response = ResponseEntity.status(HttpStatus.OK)
//                  
//                  .header("StatusCode", HttpStatus.OK.toString())
//                  .body(sanoDto);
//                return response;    
//            }            
        }
        try { //Save access track
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_S"+
                                                            AngularPageNameEncryptor.decryptPageName(anoDto.getP1())+",");
            securityApi=apiKeyService.save(securityApi);
            
            
        } catch (Exception ex) {
            sanoDto.setP3("N");
            Logger.getLogger(WebLoginController.class.getName()).log(Level.SEVERE, null, ex);
            response = ResponseEntity.status(HttpStatus.OK)
              .body(sanoDto);
        }
        
        sanoDto.setP1("");
        sanoDto.setP2("");        
        sanoDto.setP3("Y");
        
        response = ResponseEntity.status(HttpStatus.OK).body(sanoDto);
        return response; 
    }
}

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
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.UserAdViewerDTO;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewerLikedIt;
import com.bananabkend.bananaBkEnd1A.service.ApiKeyService;
import com.bananabkend.bananaBkEnd1A.service.publicViewServices.AdViewerLikedItService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunjiv6
 */
@PropertySource(value = "classpath:/application.properties", ignoreResourceNotFound = true)
@RestController
@RequestMapping("/userAuth")
public class UserAdViewerAuthController {
    UserAdViewerService userAdViewerService;
    AdViewerLikedItService adViewerLikedItService;
    
    ApiKeyService apiKeyService;
    @Value("${merchant.dns.name}")
    private String merchantDnsName;
    public UserAdViewerAuthController(UserAdViewerService userAdViewerService,
            AdViewerLikedItService adViewerLikedItService
            ,ApiKeyService apiKeyService) {

        this.userAdViewerService = userAdViewerService;
        this.adViewerLikedItService = adViewerLikedItService;
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
    
    
    @PostMapping(value = "/logout/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto> logout(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,BindingResult bindingResult) 
    {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> validate by phone: ");
        boolean adViewerExist=false;
        ResponseEntity<AnonymousDto> response=null;
        UserAdViewerDTO userDto=new UserAdViewerDTO();
        AnonymousDto sanoDto =new AnonymousDto();
        sanoDto=anoDto;
        IdEncryptor enc = new IdEncryptor();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid()){
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null);     
        
        }
       
        UserAdViewer userAdViewer=new UserAdViewer();
        List<UserAdViewer> lo =null;
        try{ // check if user is genuine
//            if(anoDto.getP1().length()>50) throw new Exception("Virus Error: Request Modified: Email>50:  "+anoDto.getP1().substring(0,10));
//            if(anoDto.getP2().length()>15) throw new Exception("Virus Error: Request Modified: Phone>15:  "+anoDto.getP2().substring(0,10));
//            if(anoDto.getP3().length()>3) throw new Exception("Virus Error: Request Modified: secretNum>3:  "+anoDto.getP1().substring(0,3));
//                        
            
//            userAdViewer.setAdViewerPhone(anoDto.getP1());
//            userAdViewer.setAdViewerEmail(anoDto.getP2());
              userAdViewer.setId(enc.decryptId(anoDto.getP1()));
//            userAdViewer.setSecretNumber(anoDto.getP3());

              securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_g,");
              securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
              securityApi.setViewerUserId(null);
              securityApi=apiKeyService.save(securityApi);
              sanoDto.setP3("Y");
              response = ResponseEntity.status(HttpStatus.OK)
              .body(sanoDto);
            
        }catch(Exception ex){ex.printStackTrace();
            sanoDto.setP3("N");
            response = ResponseEntity.status(HttpStatus.OK)
              .body(sanoDto);
            
        }  
        return response; 
    }
    
    
    @PostMapping(value = "/userInfo/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto> userInfo(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult,HttpServletRequest req) 
    {
        
        boolean adViewerExist=false;
        ResponseEntity<AnonymousDto> response=null;
        UserAdViewerDTO userDto=new UserAdViewerDTO();
        AnonymousDto sanoDto =new AnonymousDto();
        sanoDto=anoDto;
        IdEncryptor enc = new IdEncryptor();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid() ){
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null);     
        
        }
       
        UserAdViewer userAdViewer=new UserAdViewer();
        List<UserAdViewer> lo =null;
        try{ // check if user is genuine
//            if(anoDto.getP1().length()>50) throw new Exception("Virus Error: Request Modified: Email>50:  "+anoDto.getP1().substring(0,10));
//            if(anoDto.getP2().length()>15) throw new Exception("Virus Error: Request Modified: Phone>15:  "+anoDto.getP2().substring(0,10));
//            if(anoDto.getP3().length()>3) throw new Exception("Virus Error: Request Modified: secretNum>3:  "+anoDto.getP1().substring(0,3));
                if(securityApi.getViewerUserId()==null){
                        securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_b,");
                        securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                        securityApi=apiKeyService.save(securityApi);
                }else{
                    userAdViewer.setId(securityApi.getViewerUserId());
                    lo = this.userAdViewerService.getUserById(userAdViewer);
                    if(!lo.isEmpty() && lo.get(0).getId()>0L)adViewerExist=true;                    
                    securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");
                    securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                    //securityApi.setUserInfo(securityApi.getUserInfo()-1);
                    securityApi=apiKeyService.save(securityApi);
                }
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!adViewerExist){    
                try {
                        securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_b,");
                        securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                        securityApi=apiKeyService.save(securityApi);
                    } catch (Exception ex) {
                        Logger.getLogger(UserAdViewerController.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
                sanoDto.setP3("N");
                response = ResponseEntity.status(HttpStatus.OK)
                  .body(sanoDto);
                return response;    
            }

        }     
        
        if(lo.get(0).getUserInfo() < 1){ //When access limit is reached
            sanoDto.setP3("N");
            sanoDto.setP6(lo.get(0).getLang());
            response = ResponseEntity.status(HttpStatus.OK).body(sanoDto);        
                return response; 
        }        
//        String host =req.getHeader("host");
//        String[] hostnPort = host.split(":");
        
        if(lo.get(0).getUserType().equals(ContentStatus.OwnerUser)){                
                sanoDto.setP4(req.getScheme()+"://"+this.merchantDnsName+"/uploadbznzbage/");
                sanoDto.setP10(req.getScheme()+"://"+this.merchantDnsName+"/uploadProduct/");
            }
        
        try{ 
            sanoDto.setP1(enc.encryptId(lo.get(0).getId()));
            sanoDto.setP2(lo.get(0).getUserName());
            sanoDto.setP3("Y");
            if(lo.get(0).getLang()==null || lo.get(0).getLang().length()<2)
                sanoDto.setP6("en");
            else sanoDto.setP6(lo.get(0).getLang());
        }catch(Exception ex){}        
        
        response = ResponseEntity.status(HttpStatus.OK).body(sanoDto);        
                return response; 
    }
    
    @PostMapping(value = "/changeLang/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto> changeLang(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,BindingResult bindingResult) 
    {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> changeLang: ");
        ResponseEntity<AnonymousDto> response=null;
        UserAdViewerDTO userDto=new UserAdViewerDTO();
        AnonymousDto sanoDto =new AnonymousDto();
        sanoDto=anoDto;
        IdEncryptor enc = new IdEncryptor();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid() ){
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null);     
        
        }
       
        UserAdViewer userAdViewer=new UserAdViewer();
        List<UserAdViewer> lo =null;
        try{ // check if user is genuine
              securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+ ",");

              securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));  
              //securityApi.setNgChangeLang(securityApi.getNgChangeLang()-1);
              securityApi=apiKeyService.save(securityApi);
              
              userAdViewer.setId(securityApi.getViewerUserId());
              lo = this.userAdViewerService.getUserById(userAdViewer);   
              if(lo.get(0).getNgChangeLang() > 0){//When access limit is NOT reached
                lo.get(0).setLang(anoDto.getP1());
                lo.get(0).setNgChangeLang(lo.get(0).getNgChangeLang()-1 ) ;
                this.userAdViewerService.save(lo.get(0));
                sanoDto.setP3("Y");
              }else sanoDto.setP3("N"); //When access limit is reached
              
              response = ResponseEntity.status(HttpStatus.OK)
              .body(sanoDto);
            
        }catch(Exception ex){ex.printStackTrace();
            sanoDto.setP3("N");
            response = ResponseEntity.status(HttpStatus.OK)
              .body(sanoDto);            
        }  
        
        return response; 
    }
}

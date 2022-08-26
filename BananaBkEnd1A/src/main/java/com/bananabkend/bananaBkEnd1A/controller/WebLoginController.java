/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.controller;

import com.bananabkend.bananaBkEnd1A.Utility.IdEncryptor;
import com.bananabkend.bananaBkEnd1A.Utility.property.ContentStatus;
import com.bananabkend.bananaBkEnd1A.model.ProductCart;
import com.bananabkend.bananaBkEnd1A.model.SecurityApi;
import com.bananabkend.bananaBkEnd1A.model.dto.SecurityApiDto;
import com.bananabkend.bananaBkEnd1A.model.dto.UserOwnerDto;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer;
import com.bananabkend.bananaBkEnd1A.service.ApiKeyService;
import com.bananabkend.bananaBkEnd1A.service.ProductCartService;
import com.bananabkend.bananaBkEnd1A.service.UserOwnerService;
import com.bananabkend.bananaBkEnd1A.service.publicViewServices.ResetSecretNumberService;
import com.bananabkend.bananaBkEnd1A.service.publicViewServices.UserAdViewerService;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunjiv6
 */
@PropertySource(value = "classpath:/application.properties", ignoreResourceNotFound = true)
@RestController
@RequestMapping("/webLogin")
public class WebLoginController {
    @Value("${web.viewer.dns.name}")
    private String webViewerDnsName;
    private String webViewerModuleString="xskdihhsdowqi2423156471hviweroqw017ewg1632jvhq2";
    private UserAdViewerService userAdViewerService;
    private UserOwnerService userOwnerService;   
    private ApiKeyService apiKeyService;
    private ProductCartService productCartService;
    public WebLoginController(UserAdViewerService userAdViewerService,UserOwnerService userOwnerService
                                ,ApiKeyService apiKeyService,ProductCartService productCartService) {
        this.userAdViewerService = userAdViewerService;
        this.userOwnerService = userOwnerService;
        this.apiKeyService = apiKeyService;
        this.productCartService = productCartService;
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

    @PostMapping(value = "/validateUserPhoneMltiPart/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto> validateUserPhoneMltiPart(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult,HttpServletRequest req )  {
        return validateUserPhone(apiUniqueId,apiKey,anoDto,req); 
    }   
    @RequestMapping(value = "/validateUserPhone/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AnonymousDto> validateUserPhoneForCmd(@PathVariable String apiUniqueId,@PathVariable String apiKey,
            @RequestBody AnonymousDto anoDto,HttpServletRequest req) {
        return validateUserPhone(apiUniqueId,apiKey,anoDto,req);
    }
    
    public ResponseEntity<AnonymousDto> validateUserPhone(@PathVariable String apiUniqueId,@PathVariable String apiKey,
            @RequestBody AnonymousDto anoDto,HttpServletRequest req) 
    {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> validate by phone: ");
        boolean adViewerExist=false;
        ResponseEntity<AnonymousDto> response=null;
        IdEncryptor enc = new IdEncryptor();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        AnonymousDto sanoDto = new AnonymousDto();
        if(!securityApi.getValid() ){ //check API key
            sanoDto.setP3("N");
            return response = ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                  .body(sanoDto);     
        
        }
       
        UserAdViewer userAdViewer=new UserAdViewer();
        UserOwnerDto  userDto= new UserOwnerDto();
        List<UserAdViewer> lo =null;
        try{ // check if user is genuine
            //if(anoDto.getP1().length()>50) throw new Exception("Virus Error: Request Modified: Email>50:  "+anoDto.getP1().substring(0,10));
            if(anoDto.getP2().length()>15) throw new Exception("Virus Error: Request Modified: Phone>15:  "+anoDto.getP2().substring(0,10));
            if(anoDto.getP3().length()>3) throw new Exception("Virus Error: Request Modified: secretNum>3:  "+anoDto.getP1().substring(0,3));
            //userAdViewer.setAdViewerEmail(anoDto.getP1());
            userAdViewer.setAdViewerPhone(anoDto.getP2());
            userAdViewer.setSecretNumber(anoDto.getP3());
            
            lo = this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer);
            if(lo.get(0).getValidatePhone() > 0)//When access limit is reached
                if(!lo.isEmpty() && lo.get(0).getId()>0L)adViewerExist=true;
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!adViewerExist){
                try {
                    securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_g,");
                    securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                    //securityApi.setValidatePhone(securityApi.getValidatePhone()-1);
                    securityApi=apiKeyService.save(securityApi);
                } catch (Exception ex) {
                    Logger.getLogger(WebLoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                sanoDto.setP3("N");
                response = ResponseEntity.status(HttpStatus.OK)
                  
                  .header("StatusCode", HttpStatus.OK.toString())
                  .body(sanoDto);
                return response;    
            }            
        }
        try { //Save access track
            lo.get(0).setValidatePhone(lo.get(0).getValidatePhone()-1);            
            this.userAdViewerService.save(lo.get(0));
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");
            securityApi.setViewerUserId(lo.get(0).getId());
            securityApi=apiKeyService.save(securityApi);
            userDto.setId(enc.encryptId(lo.get(0).getId()));
//            String host =req.getHeader("host");
//            String[] hostnPort = host.split(":");
            
            if(lo.get(0).getUserType().equals(ContentStatus.OwnerUser))                
                userDto.setMsg_vb(req.getScheme()+"://"+this.webViewerDnsName+"/"+webViewerModuleString+"/callViewer/"+apiKey+"/"+userDto.getId());
            
            if(lo.get(0).getUserType().equals(ContentStatus.ViewerUser))                
                userDto.setMsg_vb(req.getScheme()+"://"+this.webViewerDnsName+"/"+webViewerModuleString+"/callViewer/"+apiKey+"/"+userDto.getId());
            
        } catch (Exception ex) {
            sanoDto.setP3("N");
            Logger.getLogger(WebLoginController.class.getName()).log(Level.SEVERE, null, ex);
            response = ResponseEntity.status(HttpStatus.OK)
              .body(sanoDto);
        }
        
        sanoDto.setP1(userDto.getId());
        sanoDto.setP2(userDto.getMsg_vb());        
        sanoDto.setP3("Y");
        
        response = ResponseEntity.status(HttpStatus.OK).body(sanoDto);
        return response; 
    }
    
//    @PostMapping(value = "/validateUserEmail/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
//    //@ResponseStatus(value = HttpStatus.CREATED)
//    @ResponseBody
//    public ResponseEntity<AnonymousDto> validateUserEmail(
//            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
//            BindingResult bindingResult,HttpServletRequest req ) 
    //@RequestMapping(value = "/validateUserEmail/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    
    @PostMapping(value = "/validateUserEmailMltiPart/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto>validateUserEmailMltiPart(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult,HttpServletRequest req )  {
        return validateUserEmail(apiUniqueId,apiKey,anoDto,req); 
    }   
    @RequestMapping(value = "/validateUserEmail/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AnonymousDto> validateUserEmailForCmd(@PathVariable String apiUniqueId,@PathVariable String apiKey,
            @RequestBody AnonymousDto anoDto,HttpServletRequest req) {
        return validateUserEmail(apiUniqueId,apiKey,anoDto,req);
    }
    
    
    public ResponseEntity<AnonymousDto> validateUserEmail(@PathVariable String apiUniqueId,@PathVariable String apiKey,
            @RequestBody AnonymousDto anoDto,HttpServletRequest req) 
    {  
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> validate by email: ");
        
        boolean adViewerExist=false;
        ResponseEntity<AnonymousDto> response=null;
        IdEncryptor enc = new IdEncryptor();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        AnonymousDto sanoDto = new AnonymousDto();
        if(!securityApi.getValid()  ){ //check API key
            sanoDto.setP3("N");
            return response = ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                  .body(sanoDto);     
        
        }
       
        UserAdViewer userAdViewer=new UserAdViewer();
        UserOwnerDto  userDto= new UserOwnerDto();
        List<UserAdViewer> lo =null;
        try{ // check if user is genuine
            
            if(anoDto.getP1().length()>50) throw new Exception("Virus Error: Request Modified: Email>50:  "+anoDto.getP1().substring(0,10));
            //if(anoDto.getP2().length()>15) throw new Exception("Virus Error: Request Modified: Phone>15:  "+anoDto.getP2().substring(0,10));
            if(anoDto.getP3().length()>3) throw new Exception("Virus Error: Request Modified: secretNum>3:  "+anoDto.getP1().substring(0,3));
            userAdViewer.setAdViewerEmail(anoDto.getP1());
            //userAdViewer.setAdViewerPhone(anoDto.getP2());
            userAdViewer.setSecretNumber(anoDto.getP3());
            
            lo = this.userAdViewerService.getUserByEmailAndSecretNumber(userAdViewer);
            if(lo.get(0).getValidateEmail() > 0)//When access limit is reached
                if(!lo.isEmpty() && lo.get(0).getId()>0L)adViewerExist=true;
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!adViewerExist){
                
                try {
                    securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_g,");
                    securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                    //securityApi.setValidateEmail(securityApi.getValidateEmail()-1);
                    securityApi=apiKeyService.save(securityApi);
                } catch (Exception ex) {
                    Logger.getLogger(WebLoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                sanoDto.setP3("N");
                response = ResponseEntity.status(HttpStatus.OK)
                  
                  .header("StatusCode", HttpStatus.OK.toString())
                  .body(sanoDto);
                return response;    
            }            
        }
        try { //Save access track
            lo.get(0).setValidateEmail(lo.get(0).getValidateEmail()-1);
            this.userAdViewerService.save(lo.get(0));
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");
            securityApi.setViewerUserId(lo.get(0).getId());
            //securityApi.setValidateEmail(securityApi.getValidateEmail()-1);
            securityApi=apiKeyService.save(securityApi);
            userDto.setId(enc.encryptId(lo.get(0).getId()));
//            String host =req.getHeader("host");            
//            String[] hostnPort = host.split(":");
            
            if(lo.get(0).getUserType().equals(ContentStatus.OwnerUser)){                
                userDto.setMsg_vb(req.getScheme()+"://"+this.webViewerDnsName+"/"+webViewerModuleString+"/callViewer/"+apiKey+"/"+userDto.getId());                
            }
            
            if(lo.get(0).getUserType().equals(ContentStatus.ViewerUser))                
                userDto.setMsg_vb(req.getScheme()+"://"+this.webViewerDnsName+"/"+webViewerModuleString+"/callViewer/"+apiKey+"/"+userDto.getId());
            
        } catch (Exception ex) {
            sanoDto.setP3("N");
            Logger.getLogger(WebLoginController.class.getName()).log(Level.SEVERE, null, ex);
            response = ResponseEntity.status(HttpStatus.OK)
              .body(sanoDto);
        }
        
        sanoDto.setP1(userDto.getId());
        sanoDto.setP2(userDto.getMsg_vb());        
        sanoDto.setP3("Y");
        
        response = ResponseEntity.status(HttpStatus.OK).body(sanoDto);
        return response; 
    }
    
    @PostMapping(value = "/registerNewUser/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto> registerNewUser(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult,HttpServletRequest req) 
    {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> registerNewUser: ");
        ResponseEntity<AnonymousDto> response=null;
        AnonymousDto sanoDto= new AnonymousDto();
        Integer totalRegistrationCnt=0;
        SecurityApiDto securityApiDto=new SecurityApiDto();
            securityApiDto.setApikey_vb(apiKey);
            SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid() ){
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null);     
        }
        
        UserAdViewer newUserAdViewer=null;
        UserAdViewer userAdViewer=new UserAdViewer();
        UserOwnerDto  userDto= new UserOwnerDto();
        try {
            //userAdViewer.setId(Long.MIN_VALUE);
            if(anoDto.getP3().length()>15) throw new Exception("Virus Error: Request Modified: Phone>15:  "+anoDto.getP2().substring(0,10));
            if(anoDto.getP2().length()>50) throw new Exception("Virus Error: Request Modified: Email>50:  "+anoDto.getP1().substring(0,10));            
            if(anoDto.getP1().length()>3) throw new Exception("Virus Error: Request Modified: secretNum>3:  "+anoDto.getP1().substring(0,3));
            
             userAdViewer.setAdViewerPhone(anoDto.getP3().trim().length()<1 ? null: anoDto.getP3());
             userAdViewer.setAdViewerEmail(anoDto.getP2().trim().length()<1 ? null: anoDto.getP2());
             userAdViewer.setSecretNumber(anoDto.getP1());
             userAdViewer.setUserName(anoDto.getP4());
             userAdViewer.setUserCreatedDate(String.valueOf(System.currentTimeMillis()));
             userAdViewer.setUserType(ContentStatus.ViewerUser);
             userAdViewer.setCreateLimit(ContentStatus.AdCreationLimitForOwner);
             userAdViewer.setCreateCount(0);
             userAdViewer.setUserStatus("Y");
             userAdViewer.setLang(anoDto.getP6());
             
            newUserAdViewer = userAdViewerService.registerNewUser(userAdViewer);
            if(newUserAdViewer!=null && newUserAdViewer.getId()>0){
                ProductCart cart = new ProductCart();
                cart.setUserId(newUserAdViewer.getId());
                cart.setCartItemsList(",");
                productCartService.registerNewCart(cart);
                newUserAdViewer.setCartId(cart.getId());
                userAdViewerService.save(newUserAdViewer);
            }
            
            securityApi.setViewerUserId(newUserAdViewer==null ? 0: newUserAdViewer.getId());
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+String.valueOf(securityApi.getViewerUserId())+",");
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            //securityApi.setRegisterCnt(securityApi.getRegisterCnt()-1);
            totalRegistrationCnt=apiKeyService.getTotalRegistrationCount();
            if(totalRegistrationCnt == ContentStatus.RegistrationLimit){
                throw new Exception("Limit Reached: "+ContentStatus.RegistrationLimit);
            }
            if(securityApi.getRegisterCnt()==null) securityApi.setRegisterCnt(1);
                else securityApi.setRegisterCnt(securityApi.getRegisterCnt()+1);
            
            securityApi=apiKeyService.save(securityApi);
            
        } catch (Exception ex) {
            
            Logger.getLogger(WebLoginController.class.getName()).log(Level.SEVERE, null, ex);
            try {
                    securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_g,");
                    securityApi=apiKeyService.save(securityApi);
                } catch (Exception ex1) {
                    Logger.getLogger(WebLoginController.class.getName()).log(Level.SEVERE, null, ex1);
                }
        }
        
        if(newUserAdViewer ==null) {
            sanoDto.setP3("N");
            response = ResponseEntity.status(HttpStatus.OK)
                       .header("StatusCode", HttpStatus.OK.toString())
                       .body(sanoDto);
        } else {
            IdEncryptor enc = new IdEncryptor();
            try {
                userDto.setId(enc.encryptId(newUserAdViewer.getId()));
//                String host =req.getHeader("host");            
//                String[] hostnPort = host.split(":");

                if(newUserAdViewer.getUserType().equals(ContentStatus.OwnerUser))    // will always fail            
                    userDto.setMsg_vb(req.getScheme()+"://"+this.webViewerDnsName+"/"+webViewerModuleString+"/callViewer/"+apiKey+"/"+userDto.getId());

                if(newUserAdViewer.getUserType().equals(ContentStatus.ViewerUser))                
                    userDto.setMsg_vb(req.getScheme()+"://"+this.webViewerDnsName+"/"+webViewerModuleString+"/callViewer/"+apiKey+"/"+userDto.getId());

                } catch (Exception ex) {
                    Logger.getLogger(WebLoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                sanoDto.setP2(userDto.getMsg_vb());
                sanoDto.setP3("Y");
                response = ResponseEntity.status(HttpStatus.OK)
                      .body(sanoDto);
        }
        return response;
        
    }  
    
    
}
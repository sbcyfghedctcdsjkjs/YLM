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
import io.swagger.annotations.Api;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunjiv6
 */
@Api(value = "UserAdViewerController", tags = {"REST APIs to create user for public view !!!!","UserAdViewer"})
@RestController
@RequestMapping("/adViewer")

public class UserAdViewerController {
    UserAdViewerService userAdViewerService;
    AdViewerLikedItService adViewerLikedItService;
    ApiKeyService apiKeyService;
   

    public UserAdViewerController(UserAdViewerService userAdViewerService,
            AdViewerLikedItService adViewerLikedItService
            ,ApiKeyService apiKeyService) {

        this.userAdViewerService = userAdViewerService;
        this.adViewerLikedItService = adViewerLikedItService;
        this.apiKeyService = apiKeyService;
    }
    
    @PostMapping(value = "/validateUserPhone/{apiUniqueId}/{apiKey}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<AnonymousDto> validateUserPhone(@PathVariable String apiUniqueId,
            @PathVariable String apiKey,@RequestBody AnonymousDto anoDto) {        
        
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
                        
            userAdViewer.setAdViewerPhone(anoDto.getP1());
            userAdViewer.setAdViewerEmail(anoDto.getP2());
            userAdViewer.setSecretNumber(anoDto.getP3());
            lo = this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer);
            if(!lo.isEmpty() && lo.get(0).getId()>0L)adViewerExist=true;
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            try {
                    securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_g,");
                    securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                    securityApi=apiKeyService.save(securityApi);
                } catch (Exception ex) {
                    Logger.getLogger(UserAdViewerController.class.getName()).log(Level.SEVERE, null, ex);
                }
            if(!adViewerExist){
                response = ResponseEntity.status(HttpStatus.OK)
                  .body(sanoDto);
                return response;    
            }

        }
        
         
        try {
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");
            securityApi.setViewerUserId(lo.get(0).getId());
            securityApi=apiKeyService.save(securityApi);
        } catch (Exception ex) {
            Logger.getLogger(UserAdViewerLikedItController.class.getName()).log(Level.SEVERE, null, ex);
            response = ResponseEntity.status(HttpStatus.OK)
              .body(sanoDto);
        }
        
	System.out.println(">>>>>>>>>>>>>>>>>>>>>> lo.get(0).getId(): "+lo.get(0).getId());
                List<Long> list =null;
        UserAdViewerLikedIt newUserAdViewerLikedIt=new UserAdViewerLikedIt();
        try{
            userDto.setUserId(enc.encryptId(lo.get(0).getId()));
            UserAdViewerLikedIt userAdViewerLikedIt =new UserAdViewerLikedIt() ;
            
            userAdViewerLikedIt.setUserAdViewerId(lo.get(0).getId());
          
            newUserAdViewerLikedIt = this.adViewerLikedItService.getLikedAdsContentIdWithComma(userAdViewerLikedIt);    
            }catch(Exception ex){ex.printStackTrace();}
            finally{
            //System.out.println("LikedAdslist : "+newUserAdViewerLikedIt.getAllLikedIds());
                if(newUserAdViewerLikedIt==null || newUserAdViewerLikedIt.getAllLikedIds()==null || newUserAdViewerLikedIt.getAllLikedIds().length()<2){ // Testes working for list == null
		    newUserAdViewerLikedIt=new UserAdViewerLikedIt();
                
                    
                    newUserAdViewerLikedIt.setAllLikedIds(",");
                }
        }
        try{
            String[] likeIds = newUserAdViewerLikedIt.getAllLikedIds().split(",");
            StringBuilder strB=new StringBuilder();
            strB.append(",");
            for (int i = 1; i < likeIds.length; i++) {
                strB.append(enc.encryptId(Long.parseLong(likeIds[i])));
             
                
                strB.append(",");                
            }
            userDto.setLikedAdsId(strB.toString());
            userDto.setIdOfLikedAds(enc.encryptId(newUserAdViewerLikedIt.getId()));
            sanoDto.setP2(lo.get(0).getUserName());
            sanoDto.setP4(userDto.getLikedAdsId());
            sanoDto.setP6(userDto.getIdOfLikedAds());
            sanoDto.setP10(userDto.getUserId());
        }catch(Exception ex){}        
        response = ResponseEntity.status(HttpStatus.OK).body(sanoDto);
        
                return response; 
    }
    
    @PostMapping(value = "/validateUserEmail/{apiUniqueId}/{apiKey}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<AnonymousDto> validateUserEmail(@PathVariable String apiUniqueId,
            @PathVariable String apiKey,@RequestBody AnonymousDto anoDto) {        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> validate by email: ");
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
             
            userAdViewer.setAdViewerPhone(anoDto.getP1());
            userAdViewer.setAdViewerEmail(anoDto.getP2());
            userAdViewer.setSecretNumber(anoDto.getP3());
            
            lo = this.userAdViewerService.getUserByEmailAndSecretNumber(userAdViewer);
            if(!lo.isEmpty() && lo.get(0).getId()>0L)adViewerExist=true;
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            try {
                    securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_g,");
                    securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                    securityApi=apiKeyService.save(securityApi);
                } catch (Exception ex) {
                    Logger.getLogger(UserAdViewerController.class.getName()).log(Level.SEVERE, null, ex);
                }
            if(!adViewerExist){
                response = ResponseEntity.status(HttpStatus.OK).body(sanoDto);
                
                return response;   
            } 
        }
        
        try {
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");
            securityApi=apiKeyService.save(securityApi);
        } catch (Exception ex) {
            Logger.getLogger(UserAdViewerLikedItController.class.getName()).log(Level.SEVERE, null, ex);
            response = ResponseEntity.status(HttpStatus.OK)
              .body(sanoDto);
        }
        
	System.out.println(">>>>>>>>>>>>>>>>>>>>>> lo.get(0).getId(): "+lo.get(0).getId());
        List<Long> list =null;
        UserAdViewerLikedIt newUserAdViewerLikedIt=new UserAdViewerLikedIt();

        try{

            userDto.setUserId(enc.encryptId(lo.get(0).getId()));
                UserAdViewerLikedIt userAdViewerLikedIt =new UserAdViewerLikedIt() ;
                userAdViewerLikedIt.setUserAdViewerId(lo.get(0).getId());
          
                newUserAdViewerLikedIt = this.adViewerLikedItService.getLikedAdsContentIdWithComma(userAdViewerLikedIt);
                
            }catch(Exception ex){ex.printStackTrace();}
            finally{ 		
                
                
                if(newUserAdViewerLikedIt==null || newUserAdViewerLikedIt.getAllLikedIds()==null || newUserAdViewerLikedIt.getAllLikedIds().length()<2){ // Testes working for list == null
		    newUserAdViewerLikedIt=new UserAdViewerLikedIt();
                    newUserAdViewerLikedIt.setAllLikedIds(",");
                
                }
            }
        
            try{
                String[] likeIds = newUserAdViewerLikedIt.getAllLikedIds().split(",");
                StringBuilder strB=new StringBuilder();
                strB.append(",");
                
                for (int i = 1; i < likeIds.length; i++) {
                    strB.append(enc.encryptId(Long.parseLong(likeIds[i])));
                    strB.append(",");
                }
                userDto.setLikedAdsId(strB.toString());      
                userDto.setIdOfLikedAds(enc.encryptId(newUserAdViewerLikedIt.getId()));
            }catch(Exception ex){

            }
            sanoDto.setP2(lo.get(0).getUserName());
         sanoDto.setP4(userDto.getLikedAdsId());
         sanoDto.setP6(userDto.getIdOfLikedAds());
         sanoDto.setP10(userDto.getUserId());
        response = ResponseEntity.status(HttpStatus.OK).body(sanoDto);                  
        return response;       
    }
    
    @PostMapping(value = "/registerbyEmailNOTUSED/{apiUniqueId}/{apiKey}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED) //fiterPending
    public ResponseEntity<UserAdViewer> registerByEmailNOTUSED(@PathVariable String apiUniqueId,
            @PathVariable String apiKey,@RequestBody UserAdViewer userAdViewer) {        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> register by email: "+userAdViewer.getAdViewerEmail());
        ResponseEntity<UserAdViewer> response=null;
        //List<BorrowerUser> borrowerList = borrowerUserService.getOneBorrowerForLogin(borrowerUser.get(0).getEncMobileNum(), borrowerUser.get(0).getEncPassword());
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid()){
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null);     
        }
        UserAdViewer newUserAdViewer=null;
        
        try {
            userAdViewer.setUserCreatedDate(String.valueOf(System.currentTimeMillis()));
            userAdViewer.setUserType(ContentStatus.ViewerUser);
            userAdViewer.setUserStatus("Y");
            newUserAdViewer = userAdViewerService.registerNewUserByEmail(userAdViewer);
        } catch (Exception ex) {
            Logger.getLogger(UserAdViewerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        if(newUserAdViewer ==null) {
            response = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                  .header("Status code", HttpStatus.NOT_ACCEPTABLE.toString())
                  .header("StatusCode", HttpStatus.NOT_ACCEPTABLE.toString())
                  .body(null);
        } else {
            response = ResponseEntity.status(HttpStatus.OK)
                  .header("Status code", HttpStatus.OK.toString())
                  .header("StatusCode", HttpStatus.OK.toString())
                  .body(newUserAdViewer);
        }
        return response;
        
    }
    
    @PostMapping(value = "/registerbyPhoneNOTUSED/{apiUniqueId}/{apiKey}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED) //fiterPending
    public ResponseEntity<UserAdViewer> registerByPhoneNOTUSED(@PathVariable String apiUniqueId,
            @PathVariable String apiKey,@RequestBody UserAdViewer userAdViewer) {        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> register by phone: "+userAdViewer.getAdViewerPhone());
        ResponseEntity<UserAdViewer> response=null;
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid()){
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null);     
        }
        UserAdViewer newUserAdViewer=null;
        
        
        
        
        try {
             userAdViewer.setUserCreatedDate(String.valueOf(System.currentTimeMillis()));
             userAdViewer.setUserType(ContentStatus.ViewerUser);
             userAdViewer.setUserStatus("Y");
            newUserAdViewer = userAdViewerService.registerNewUserByPhone(userAdViewer);
        } catch (Exception ex) {
            Logger.getLogger(UserAdViewerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
            
            securityApi.setViewerUserId(newUserAdViewer.getId());
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi=apiKeyService.save(securityApi);
        } catch (Exception ex) {
            Logger.getLogger(UserAdViewerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(newUserAdViewer ==null) {
            response = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                  .header("Status code", HttpStatus.NOT_ACCEPTABLE.toString())
                  .header("StatusCode", HttpStatus.NOT_ACCEPTABLE.toString())
                  .body(newUserAdViewer);
        } else {
            response = ResponseEntity.status(HttpStatus.OK)
                  .header("Status code", HttpStatus.OK.toString())
                  .header("StatusCode", HttpStatus.OK.toString())
                  .body(newUserAdViewer);
        }
        return response;
    }

    
    @PostMapping(value = "/registerNewUser/{apiUniqueId}/{apiKey}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED) 
    public ResponseEntity<AnonymousDto> registerNewUser(@PathVariable String apiUniqueId,
            @PathVariable String apiKey,@RequestBody AnonymousDto anoDto) {        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> register new User: ");
        ResponseEntity<AnonymousDto> response=null;
        UserAdViewerDTO userDto= new UserAdViewerDTO();
        AnonymousDto sanoDto = new AnonymousDto();
        sanoDto=anoDto;
        
        SecurityApiDto securityApiDto=new SecurityApiDto();
            securityApiDto.setApikey_vb(apiKey);
            SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid()){
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null);     
        }
        
        UserAdViewer newUserAdViewer=null;
        UserAdViewer userAdViewer=new UserAdViewer();
        
        try {
            //userAdViewer.setId(Long.MIN_VALUE);
//            if(anoDto.getP1().length()>15) throw new Exception("Virus Error: Request Modified: Phone>15:  "+anoDto.getP2().substring(0,10));
//            if(anoDto.getP2().length()>50) throw new Exception("Virus Error: Request Modified: Email>50:  "+anoDto.getP1().substring(0,10));            
//            if(anoDto.getP3().length()>3) throw new Exception("Virus Error: Request Modified: secretNum>3:  "+anoDto.getP1().substring(0,3));
//            
            userAdViewer.setAdViewerPhone(anoDto.getP1());
            userAdViewer.setAdViewerEmail(anoDto.getP2());
            userAdViewer.setSecretNumber(anoDto.getP3());
            userAdViewer.setUserCreatedDate(String.valueOf(System.currentTimeMillis()));
            userAdViewer.setUserType(ContentStatus.ViewerUser);
            userAdViewer.setUserStatus("Y");
            newUserAdViewer = userAdViewerService.registerNewUserByPhone(userAdViewer);
               
            securityApi.setViewerUserId(newUserAdViewer.getId());
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+String.valueOf(newUserAdViewer.getId())+",");
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi=apiKeyService.save(securityApi);
        } catch (Exception ex) {
            
            Logger.getLogger(UserAdViewerController.class.getName()).log(Level.SEVERE, null, ex);
            try {
                    securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_g,");
                    securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                    securityApi=apiKeyService.save(securityApi);
                } catch (Exception ex1) {
                    Logger.getLogger(UserAdViewerController.class.getName()).log(Level.SEVERE, null, ex1);
                }
        }
        
        if(newUserAdViewer ==null) {
            response = ResponseEntity.status(HttpStatus.OK)                  
                  .body(sanoDto);
        } else {
            IdEncryptor enc = new IdEncryptor();
            try {
                userDto.setUserId(enc.encryptId(newUserAdViewer.getId()));
                sanoDto.setP4(",");
                sanoDto.setP6("");
                sanoDto.setP10(userDto.getUserId());
            } catch (Exception ex) {
                Logger.getLogger(UserAdViewerController.class.getName()).log(Level.SEVERE, null, ex);
            }
            response = ResponseEntity.status(HttpStatus.OK)
                  .body(sanoDto);
        }
        return response;
    }
    
    @PostMapping(value = "/modifyUserByPhoneNOTUSED/{apiUniqueId}/{apiKey}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED) //fiterPending
    public ResponseEntity<String> modifyUserByPhoneNOTUSED(@PathVariable String apiUniqueId,
            @PathVariable String apiKey,@RequestBody UserAdViewer userAdViewer) {        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> modify by phone: "+userAdViewer.getAdViewerPhone());
        boolean adViewerExist=false;
        ResponseEntity<String> response=null;
        
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid()){
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null);     
        }
        
        UserAdViewer newUserAdViewer=null;
        List<UserAdViewer> lo =null;
        try{ // check if user is genuine
            lo = this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer);
            if(!lo.isEmpty() && lo.get(0).getId()>0L)adViewerExist=true;
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!adViewerExist){
                response = ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                  .header("Status code", HttpStatus.UNAUTHORIZED.toString())
                  .header("StatusCode", HttpStatus.UNAUTHORIZED.toString())
                  .body("User not Found. Please check Phone/Email and Secret Number.");
                return response;    
            }            
        }
        
        
        try { //NOT IMPLEMENTED
             //userAdViewer.setUserCreatedDate(String.valueOf(System.currentTimeMillis()));
             //userAdViewer.setUserStatus("Y");
            newUserAdViewer = userAdViewerService.registerNewUserByPhone(userAdViewer);
        } catch (Exception ex) {
            Logger.getLogger(UserAdViewerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(newUserAdViewer ==null) {
            response = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                  .header("Status code", HttpStatus.NOT_ACCEPTABLE.toString())
                  .header("StatusCode", HttpStatus.NOT_ACCEPTABLE.toString())
                  .body("User not Found. Please check Phone/Email and Secret Number.");
        } else {
            response = ResponseEntity.status(HttpStatus.OK)
                  .header("Status code", HttpStatus.OK.toString())
                  .header("StatusCode", HttpStatus.OK.toString())
                  .body("{\"message\": \"User modify done.\"}");
        }
        return response;
    }
    @PostMapping(value = "/modifyUserByEmailNOTUSED/{apiUniqueId}/{apiKey}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED) //fiterPending
    public ResponseEntity<String> modifyUserByEmailNOTUSED(@PathVariable String apiUniqueId,
            @PathVariable String apiKey,@RequestBody UserAdViewer userAdViewer) {        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> modify by emial: "+userAdViewer.getAdViewerPhone());
        boolean adViewerExist=false;
        ResponseEntity<String> response=null;
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid()){
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null);     
        }
        
        
        UserAdViewer newUserAdViewer=null;
        List<UserAdViewer> lo =null;
        try{ // check if user is genuine
            lo = this.userAdViewerService.getUserByEmailAndSecretNumber(userAdViewer);
            if(!lo.isEmpty() && lo.get(0).getId()>0L)adViewerExist=true;
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!adViewerExist){
                response = ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                  .header("Status code", HttpStatus.UNAUTHORIZED.toString())
                  .header("StatusCode", HttpStatus.UNAUTHORIZED.toString())
                  .body("User not Found. Please check Phone/Email and Secret Number.");
                return response;    
            }            
        }
        
        
        try {//NOT IMPLEMENTED
             //userAdViewer.setUserCreatedDate(String.valueOf(System.currentTimeMillis()));
             //userAdViewer.setUserStatus("Y");
            newUserAdViewer = userAdViewerService.registerNewUserByEmail(userAdViewer);
        } catch (Exception ex) {
            Logger.getLogger(UserAdViewerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(newUserAdViewer ==null) {
            response = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                  .header("Status code", HttpStatus.NOT_ACCEPTABLE.toString())
                  .header("StatusCode", HttpStatus.NOT_ACCEPTABLE.toString())
                  .body("User not Found. Please check Phone/Email and Secret Number.");
        } else {
            response = ResponseEntity.status(HttpStatus.OK)
                  .header("Status code", HttpStatus.OK.toString())
                  .header("StatusCode", HttpStatus.OK.toString())
                  .body("{\"message\": \"User modify done.\"}");
        }
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
            if( inMinutes > 120){ securityApi.setValid(false);
                
                
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.controller.publicView;

import com.bananabkend.bananaBkEnd1A.Utility.IdEncryptor;
import com.bananabkend.bananaBkEnd1A.controller.WebLoginController;
import com.bananabkend.bananaBkEnd1A.model.SecurityApi;
import com.bananabkend.bananaBkEnd1A.model.dto.SecurityApiDto;
import com.bananabkend.bananaBkEnd1A.model.dto.UserOwnerDto;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.ResetSecretNumber;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer;
import com.bananabkend.bananaBkEnd1A.service.ApiKeyService;
import com.bananabkend.bananaBkEnd1A.service.UserOwnerService;
import com.bananabkend.bananaBkEnd1A.service.publicViewServices.ResetSecretNumberService;
import com.bananabkend.bananaBkEnd1A.service.publicViewServices.UserAdViewerService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
@RequestMapping("/secretNumber")
public class ResetSecretNumberController {
    private UserAdViewerService userAdViewerService;
    private ApiKeyService apiKeyService;
    private ResetSecretNumberService resetSecretNumberService;
    
    public ResetSecretNumberController(UserAdViewerService userAdViewerService
                                ,ApiKeyService apiKeyService,ResetSecretNumberService resetSecretNumberService) {
        this.userAdViewerService = userAdViewerService;
        //this.userOwnerService = userOwnerService;
        this.apiKeyService = apiKeyService;
        this.resetSecretNumberService= resetSecretNumberService;
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

    @PostMapping(value = "/askToReset/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto> askToReset(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult,HttpServletRequest req ) 
    {
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
            if(anoDto.getP1().length()>50) throw new Exception("Virus Error: Request Modified: Email>50:  "+anoDto.getP1().substring(0,10));
            if(anoDto.getP2().length()>15) throw new Exception("Virus Error: Request Modified: Phone>15:  "+anoDto.getP2().substring(0,10));
            if(anoDto.getP3().length()>3) throw new Exception("Virus Error: Request Modified: secretNum>3:  "+anoDto.getP1().substring(0,3));
            userAdViewer.setAdViewerEmail(anoDto.getP1());
            userAdViewer.setAdViewerPhone(anoDto.getP2());
            userAdViewer.setSecretNumber(anoDto.getP3());
            
            lo = this.userAdViewerService.getUserByPhone(userAdViewer);
            if(lo.get(0).getResetSecretCnt() > 0)//When access Limit is NOT reached 
                if(!lo.isEmpty() && lo.get(0).getId()>0L)adViewerExist=true;
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!adViewerExist){
                try {
                    securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_g,");
                    securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
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
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");
            securityApi=apiKeyService.save(securityApi);
            
            lo.get(0).setResetSecretCnt(lo.get(0).getResetSecretCnt()-1);
            this.userAdViewerService.save(lo.get(0));
            
            ResetSecretNumber resetSecretNumber = new ResetSecretNumber();
            resetSecretNumber.setEmail(anoDto.getP1());
            resetSecretNumber.setPhoneNumber(anoDto.getP2());
            
            resetSecretNumber.setCreatedOn(String.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))));
            this.resetSecretNumberService.save(resetSecretNumber);
            sanoDto.setP3("Y");   
            
            
//            String host =req.getHeader("host");
//            
//            String[] hostnPort = host.split(":");
//            
//            if(lo.get(0).getUserType().equals(ContentStatus.OwnerUser))                
//                userDto.setMsg_vb(req.getScheme()+"://"+hostnPort[0]+":4011/owner");
//            
//            if(lo.get(0).getUserType().equals(ContentStatus.ViewerUser))                
//                userDto.setMsg_vb(req.getScheme()+"://"+hostnPort[0]+":4110/showMain/"+apiKey+"/"+userDto.getId());
//            
        } catch (Exception ex) {
            sanoDto.setP3("N");
            Logger.getLogger(WebLoginController.class.getName()).log(Level.SEVERE, null, ex);
            response = ResponseEntity.status(HttpStatus.OK)
              .body(sanoDto);
        }
        
        //sanoDto.setP1(userDto.getId());
        //sanoDto.setP2(userDto.getMsg_vb());        
        //sanoDto.setP3("Y");
        
        response = ResponseEntity.status(HttpStatus.OK).body(sanoDto);
        return response; 
    }
    
        
    @PostMapping(value = "/reset/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto> reset(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult,HttpServletRequest req ) 
    {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> reset: ");
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
            if(anoDto.getP1().length()>50 && anoDto.getP1().length()< 6) throw new Exception("Virus Error: Request Modified: Email>50:  "+anoDto.getP1().substring(0,10));
            if(anoDto.getP2().length()>15 && anoDto.getP2().length()< 10) throw new Exception("Virus Error: Request Modified: Phone>15:  "+anoDto.getP2().substring(0,10));
            if(anoDto.getP3().length()>3 && anoDto.getP3().length()< 3) throw new Exception("Virus Error: Request Modified: secretNum>3:  "+anoDto.getP1().substring(0,3));
            userAdViewer.setAdViewerEmail(anoDto.getP1());
            userAdViewer.setAdViewerPhone(anoDto.getP2());
            userAdViewer.setSecretNumber(anoDto.getP4());
            
            //if(securityApi.getViewerUserId()==null)
            lo = userAdViewer.getAdViewerEmail().trim().length()<1 ? this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer) :
                    this.userAdViewerService.getUserByEmailAndSecretNumber(userAdViewer); 
            if(lo.get(0).getResetSecretCnt() > 0)//When access Limit is NOT reached 
                if(!lo.isEmpty() && lo.get(0).getId()>0L)adViewerExist=true;
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!adViewerExist){
                try {
                    securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_g,");
                    securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
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
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");
            securityApi=apiKeyService.save(securityApi);
            
            //userDto.setId(enc.encryptId(lo.get(0).getId()));
            lo.get(0).setResetSecretCnt(lo.get(0).getResetSecretCnt()-1);
            lo.get(0).setSecretNumber(anoDto.getP3());
            this.userAdViewerService.save(lo.get(0));
            sanoDto.setP3("Y");   
            
            
//            String host =req.getHeader("host");
//            
//            String[] hostnPort = host.split(":");
//            
//            if(lo.get(0).getUserType().equals(ContentStatus.OwnerUser))                
//                userDto.setMsg_vb(req.getScheme()+"://"+hostnPort[0]+":4011/owner");
//            
//            if(lo.get(0).getUserType().equals(ContentStatus.ViewerUser))                
//                userDto.setMsg_vb(req.getScheme()+"://"+hostnPort[0]+":4110/showMain/"+apiKey+"/"+userDto.getId());
//            
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
    
    @PostMapping(value = "/resetOthersByAdmin/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto> resetOthersByAdmin(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult,HttpServletRequest req ) 
    {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> reset: ");
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
        
        boolean ownerExist=false;
        try{ // check if Admin is genuine
            userAdViewer.setId(enc.decryptId(anoDto.getP6()));
            
            lo = this.userAdViewerService.getUserById(userAdViewer);
            if(!lo.isEmpty() && lo.get(0).getId()>0L){
                if(!lo.get(0).getUserType().equals("T")) throw new Exception(lo.get(0).getId()+" not a T user."); 
                ownerExist=true;
                securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_T"+lo.get(0).getId()+",");
                //securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
                securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                securityApi=apiKeyService.save(securityApi);    
                
            }            
            
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!ownerExist){
                sanoDto.setP3("N");
                response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                  .header("Status code", HttpStatus.NOT_FOUND.toString())
                  .header("StatusCode", HttpStatus.NOT_FOUND.toString())
                  .body(sanoDto);
                return response;
            }
        }
        
        try{ // check if user is genuine
//            if(anoDto.getP1().length()>50 && anoDto.getP1().length()< 6) throw new Exception("Virus Error: Request Modified: Email>50:  "+anoDto.getP1().substring(0,10));
//            if(anoDto.getP2().length()>15 && anoDto.getP2().length()< 10) throw new Exception("Virus Error: Request Modified: Phone>15:  "+anoDto.getP2().substring(0,10));
//            if(anoDto.getP3().length()>3 && anoDto.getP3().length()< 3) throw new Exception("Virus Error: Request Modified: secretNum>3:  "+anoDto.getP1().substring(0,3));
            userAdViewer.setAdViewerEmail(anoDto.getP2());
            userAdViewer.setAdViewerPhone(anoDto.getP1());
            userAdViewer.setSecretNumber(anoDto.getP3());
            
            //if(securityApi.getViewerUserId()==null)
            lo = userAdViewer.getAdViewerEmail().trim().length()<1 ? this.userAdViewerService.getUserByPhone(userAdViewer) :
                    this.userAdViewerService.getUserByEmail(userAdViewer); 
            
            if(!lo.isEmpty() && lo.get(0).getId()>0L)adViewerExist=true;
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!adViewerExist){
                try {
                    securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_g,");
                    securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
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
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");
            securityApi=apiKeyService.save(securityApi);
            
            //userDto.setId(enc.encryptId(lo.get(0).getId()));
            //lo.get(0).setResetSecretCnt(lo.get(0).getResetSecretCnt()-1);
            lo.get(0).setSecretNumber(anoDto.getP3());
            this.userAdViewerService.save(lo.get(0));
            sanoDto.setP3("Y");   
            
            
//            String host =req.getHeader("host");
//            
//            String[] hostnPort = host.split(":");
//            
//            if(lo.get(0).getUserType().equals(ContentStatus.OwnerUser))                
//                userDto.setMsg_vb(req.getScheme()+"://"+hostnPort[0]+":4011/owner");
//            
//            if(lo.get(0).getUserType().equals(ContentStatus.ViewerUser))                
//                userDto.setMsg_vb(req.getScheme()+"://"+hostnPort[0]+":4110/showMain/"+apiKey+"/"+userDto.getId());
//            
        } catch (Exception ex) {
            sanoDto.setP3("N");
            Logger.getLogger(WebLoginController.class.getName()).log(Level.SEVERE, null, ex);
            response = ResponseEntity.status(HttpStatus.OK)
              .body(sanoDto);
        }
        
        sanoDto.setP3("Y");
        
        response = ResponseEntity.status(HttpStatus.OK).body(sanoDto);
        return response; 
    }
    
}
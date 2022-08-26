/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.controller;

import com.bananabkend.bananaBkEnd1A.Utility.IdEncryptor;
import com.bananabkend.bananaBkEnd1A.Utility.property.ContentStatus;
import com.bananabkend.bananaBkEnd1A.model.SecurityApi;
import com.bananabkend.bananaBkEnd1A.model.TransactionMoney;
import com.bananabkend.bananaBkEnd1A.model.dto.SecurityApiDto;
import com.bananabkend.bananaBkEnd1A.model.dto.UserOwnerDto;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer;
import com.bananabkend.bananaBkEnd1A.service.ApiKeyService;
import com.bananabkend.bananaBkEnd1A.service.TransactionMoneyService;
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
@RequestMapping("/transactionMoney")
public class TransactionMoneyController {
    
    private UserAdViewerService userAdViewerService;
    private TransactionMoneyService transactionMoneyService; 
    private ApiKeyService apiKeyService;
    public TransactionMoneyController(TransactionMoneyService transactionMoneyService,ApiKeyService apiKeyService,
            UserAdViewerService userAdViewerService) {
        this.transactionMoneyService = transactionMoneyService;
        this.apiKeyService = apiKeyService;
        this.userAdViewerService = userAdViewerService;
    
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
            if(securityApi==null || securityApi.getId()==null || securityApi.getId()<0){
                securityApi.setValid(false);
                
                return securityApi;}          
    
        }
        
        try {        
            Long diff = System.currentTimeMillis() - Long.valueOf(securityApi.getUpdatedOn());
            Long inMinutes = diff / (60*1000) %60;
            if( inMinutes > 300){ securityApi.setValid(false);//because payment takes time
                
                
                return securityApi;
            }
        } catch (Exception ex) {
            securityApi.setValid(false);
            return securityApi;}
        finally{}
        securityApi.setValid(true);
        return securityApi;    
    }
    
    
    @PostMapping(value = "/validateUserEmail/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto> validateUserEmail(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult,HttpServletRequest req ) 
    {
        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> validate by email: ");
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
        UserAdViewer lo =null;
        try{ // check if user is genuine
            
            //if(anoDto.getP1().length()>50) throw new Exception("Virus Error: Request Modified: Email>50:  "+anoDto.getP1().substring(0,10));
            //if(anoDto.getP2().length()>15) throw new Exception("Virus Error: Request Modified: Phone>15:  "+anoDto.getP2().substring(0,10));
            //if(anoDto.getP3().length()>3) throw new Exception("Virus Error: Request Modified: secretNum>3:  "+anoDto.getP1().substring(0,3));
            userAdViewer.setAdViewerEmail(anoDto.getP1());
            userAdViewer.setAdViewerPhone(anoDto.getP2());
            userAdViewer.setSecretNumber(anoDto.getP3());
            
            lo = this.userAdViewerService.authorizeAdminTransactionUser(userAdViewer);
            if(lo!=null && lo.getId()>0L)adViewerExist=true;
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
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_T"+lo.getId()+",");
            securityApi=apiKeyService.save(securityApi);
            userDto.setId(enc.encryptId(lo.getId()));
//            userDto.setId(enc.encryptId(lo.get(0).getId()));
//            String host =req.getHeader("host");
//            
//            String[] hostnPort = host.split(":");
//            
//            if(lo.get(0).getUserType().equals(ContentStatus.OwnerUser))                
//                userDto.setMsg_vb(req.getScheme()+"://"+hostnPort[0]+":4011/owner");
//            
//            if(lo.get(0).getUserType().equals(ContentStatus.ViewerUser))                
//                userDto.setMsg_vb(req.getScheme()+"://"+hostnPort[0]+":4110/showMain/"+apiKey+"/"+userDto.getId());
            
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
    
    
    @PostMapping(value = "/save/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<AnonymousDto> saveTransaction(@PathVariable String apiUniqueId,
            @PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto) 
    {
        ResponseEntity<AnonymousDto> response=null;
        SecurityApiDto securityApiDto=new SecurityApiDto();
        
        
        AnonymousDto sanoDto = new AnonymousDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        if(!securityApi.getValid()){     
            sanoDto.setP3("Nk");
            return response = ResponseEntity.status(HttpStatus.OK).body(sanoDto);                 
        }        
        TransactionMoney ta = new TransactionMoney();
        

        ta.setOwnerPhoneNum(anoDto.getP1());
        ta.setOwnerEmail(anoDto.getP2());
        ta.setSecret(anoDto.getP3());
        ta.setTransactionString(anoDto.getP4());
        
        //ta.setTransactionUserEmail(anoDto.getP6());
        //ta.setUpdatedByUser(Long.valueOf(anoDto.getP6()));
        ta.setRemarks(anoDto.getP6());
        
        UserAdViewer userAdViewer = new UserAdViewer(); 
        try{
            if(ta.getSecret().equals(ContentStatus.SecretPhrase[1]))
            {
                ta.setCreatedOn(String.valueOf(System.currentTimeMillis()));
                //userAdViewer.setAdViewerEmail(ta.getTransactionUserEmail());
                //userAdViewerService.findAdminTransactionUser(userAdViewer);
                //if(userAdViewer.getId()!=null && userAdViewer.getId()>0)
                if(transactionMoneyService.getTrans(ta)!=null) sanoDto.setP3("T_Ex");
                else
                {   transactionMoneyService.save(ta);
                    sanoDto.setP3("Y");
                    userAdViewer.setAdViewerPhone(ta.getOwnerPhoneNum());
                    userAdViewer.setAdViewerEmail(ta.getOwnerEmail());
                    List<UserAdViewer> viewerExist = (ta.getOwnerPhoneNum().trim().length()>0) ? userAdViewerService.getUserByPhone(userAdViewer): userAdViewerService.getUserByEmail(userAdViewer);
                    sanoDto.setP3("SY_OW_"+viewerExist.size());
                    if(viewerExist.size()==1){
                        viewerExist.get(0).setUserType("O");
                        userAdViewerService.save(viewerExist.get(0));//update to Owner
                    }
                }
            }else 
            sanoDto.setP3("Np");
        }catch(Exception ex){
            
            response = ResponseEntity.status(HttpStatus.OK).body(sanoDto);
            
            return response;
        
        }
        response=ResponseEntity.status(HttpStatus.OK)
                .body(sanoDto);
        return response;
    }
    
    @PostMapping(value = "/payThruQR/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<AnonymousDto> payThruQR(@PathVariable String apiUniqueId,
            @PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto) 
    {
        ResponseEntity<AnonymousDto> response=null;
        SecurityApiDto securityApiDto=new SecurityApiDto();
        
        
        AnonymousDto sanoDto = new AnonymousDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        if(!securityApi.getValid()){     
            sanoDto.setP3("Nk");
            return response = ResponseEntity.status(HttpStatus.OK).body(sanoDto);                 
        }        
        TransactionMoney ta = new TransactionMoney();
        

        //ta.setOwnerPhoneNum(anoDto.getP1());
        //ta.setOwnerEmail(anoDto.getP2());
        ta.setTransactionString(anoDto.getP3());
        
        //ta.setTransactionUserEmail(anoDto.getP6());
        //ta.setUpdatedByUser(Long.valueOf(anoDto.getP6()));
        //ta.setRemarks(anoDto.getP6());
        
        UserAdViewer userAdViewer = new UserAdViewer(); 
        try{
            //if(ta.getSecret().equals(ContentStatus.SecretPhrase[1]))
            
                ta.setCreatedOn(String.valueOf(System.currentTimeMillis()));
                ta.setRemarks("PayThruQR");
                //userAdViewer.setAdViewerEmail(ta.getTransactionUserEmail());
                //userAdViewerService.findAdminTransactionUser(userAdViewer);
                //if(userAdViewer.getId()!=null && userAdViewer.getId()>0)                
                if(transactionMoneyService.getTrans(ta)!=null) sanoDto.setP3("T_Ex");
                else
                {   
                    userAdViewer.setAdViewerPhone(anoDto.getP2());
                    //userAdViewer.setAdViewerEmail(ta.getOwnerEmail());
                    List<UserAdViewer> viewerExist = null;//(ta.getOwnerPhoneNum().trim().length()>0) ? 
                    viewerExist = userAdViewerService.getUserByPhone(userAdViewer);//: userAdViewerService.getUserByEmail(userAdViewer);
                    
                    if(viewerExist.size()==1){
                        ta.setOwnerPhoneNum(anoDto.getP2());
                        transactionMoneyService.save(ta);
                        viewerExist.get(0).setUserType("O");
                        userAdViewerService.save(viewerExist.get(0));//update to Owner
                        sanoDto.setP3("Y");
                    }else{
                        userAdViewer.setAdViewerEmail(anoDto.getP2());
                        viewerExist = userAdViewerService.getUserByEmail(userAdViewer);//: userAdViewerService.getUserByEmail(userAdViewer);
                        if(viewerExist.size()==1){
                            ta.setOwnerEmail(anoDto.getP2());
                            transactionMoneyService.save(ta);
                            viewerExist.get(0).setUserType("O");
                            userAdViewerService.save(viewerExist.get(0));//update to Owner
                            sanoDto.setP3("Y");
                        }
                    }
                    
                    if(viewerExist.size()!=1){
                        //ta.setRemarks("Unknown User PayThruQR");
                        //transactionMoneyService.save(ta);
                        sanoDto.setP3("GM_OD_NE");
                    }
                }
            
//            else 
//            sanoDto.setP3("Np");
        }catch(Exception ex){
            
            response = ResponseEntity.status(HttpStatus.OK).body(sanoDto);
            
            return response;
        
        }
        response=ResponseEntity.status(HttpStatus.OK)
                .body(sanoDto);
        return response;
    }
    
    
}

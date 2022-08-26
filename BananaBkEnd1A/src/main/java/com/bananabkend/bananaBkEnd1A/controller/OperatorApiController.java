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
import com.bananabkend.bananaBkEnd1A.service.OwnerContentService;
import com.bananabkend.bananaBkEnd1A.service.publicViewServices.UserAdViewerService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
@RequestMapping("/opsApi")
public class OperatorApiController {
  
    private OwnerContentService ownerContentService;
    private UserAdViewerService userAdViewerService;
    private ApiKeyService apiKeyService;
    
    public OperatorApiController(OwnerContentService ownerContentService,UserAdViewerService userAdViewerService,
            ApiKeyService apiKeyService) {
        this.ownerContentService= ownerContentService;
        this.userAdViewerService = userAdViewerService;
        this.apiKeyService =apiKeyService;
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
            if(securityApi==null || securityApi.getId()==null || securityApi.getId()<0){
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
    
    @PostMapping(value = "/getRowsCount/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto> getRowsCount(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult ) 
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
       AnonymousDto sanoDto=new AnonymousDto();
//        UserAdViewer userAdViewer=new UserAdViewer();
//        UserOwnerDto  userDto= new UserOwnerDto();
//        
//        List<UserAdViewer> lo =null;
//        try{ // check if user is genuine
//            
//            userAdViewer.setAdViewerEmail(anoDto.getP1());
//            userAdViewer.setAdViewerPhone(anoDto.getP2());
//            userAdViewer.setSecretNumber(anoDto.getP3());
//            
//            lo = this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer);
//            if(!lo.isEmpty() && lo.get(0).getId()>0L)adViewerExist=true;
//        }catch(Exception ex){ex.printStackTrace();}
//        finally{
//            if(!adViewerExist){
//                response = ResponseEntity.status(HttpStatus.NOT_MODIFIED)
//                  
//                  .header("StatusCode", HttpStatus.NOT_MODIFIED.toString())
//                  .body(sanoDto);
//                return response;    
//            }            
//        }
        try { //Save access track
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+"A"+",");
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi=apiKeyService.save(securityApi);
            
            Long userCnt = userAdViewerService.getUserCountByUserType(ContentStatus.ViewerUser);
            Long ownerCnt = ownerContentService.getOwnerContentRowsCount();
            Long apiKeyCount = apiKeyService.getTotalRowsCount();
            {
                sanoDto.setP1(String.valueOf(userCnt));
                sanoDto.setP2(String.valueOf(ownerCnt));
                sanoDto.setP6(String.valueOf(apiKeyCount));
            }
           
        } catch (Exception ex) {
            Logger.getLogger(OperatorApiController.class.getName()).log(Level.SEVERE, null, ex);
            response = ResponseEntity.status(HttpStatus.NOT_MODIFIED)
              .body(sanoDto);
        }
        response = ResponseEntity.status(HttpStatus.OK).body(sanoDto);
        return response; 
    }

    
    @PostMapping(value = "/getTopNRows/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<List<AnonymousDto>> getTopNRows(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult ) 
    {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> op validate by phone: ");
        boolean adViewerExist=false;
        ResponseEntity<List<AnonymousDto>> response=null;
        IdEncryptor enc = new IdEncryptor();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        if(!securityApi.getValid()){ //check API key
            return response = ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                  .body(null);     
        
        }
       List<AnonymousDto> listSanoDto=new ArrayList<AnonymousDto>();
//        UserAdViewer userAdViewer=new UserAdViewer();
//        UserOwnerDto  userDto= new UserOwnerDto();
//        
//        List<UserAdViewer> lo =null;
//        try{ // check if user is genuine
//            
//            userAdViewer.setAdViewerEmail(anoDto.getP1());
//            userAdViewer.setAdViewerPhone(anoDto.getP2());
//            userAdViewer.setSecretNumber(anoDto.getP3());
//            
//            lo = this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer);
//            if(!lo.isEmpty() && lo.get(0).getId()>0L)adViewerExist=true;
//        }catch(Exception ex){ex.printStackTrace();}
//        finally{
//            if(!adViewerExist){
//                response = ResponseEntity.status(HttpStatus.NOT_MODIFIED)
//                  
//                  .header("StatusCode", HttpStatus.NOT_MODIFIED.toString())
//                  .body(sanoDto);
//                return response;    
//            }            
//        }
        try { //Save access track
//            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+"A"+",");
//            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
//            securityApi=apiKeyService.save(securityApi);
//            
//            Long userCnt = userAdViewerService.getUserCountByUserType(ContentStatus.ViewerUser);
//            Long ownerCnt = ownerContentService.getOwnerContentRowsCount();
//            Long apiKeyCount = apiKeyService.getTotalRowsCount();
//            {
//                sanoDto.setP1(String.valueOf(userCnt));
//                sanoDto.setP2(String.valueOf(ownerCnt));
//                sanoDto.setP6(String.valueOf(apiKeyCount));
//            }
              DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss zz");
              Calendar calendar = Calendar.getInstance();
              
              List<SecurityApi> al=  apiKeyService.getTopNRows();
              for (SecurityApi sa : al) {
                  AnonymousDto sanoDto=new AnonymousDto();
                  calendar.setTimeInMillis(Long.parseLong(sa.getCreatedOn()));
                  //System.out.println("createdOn: "+dateFormat.format(calendar.getTime()));
                  sanoDto.setP1(String.valueOf(sa.getId()));
                  sanoDto.setP2(dateFormat.format(calendar.getTime()));//createdOn
                  calendar.setTimeInMillis(Long.parseLong(sa.getUpdatedOn()));
                  sanoDto.setP3(dateFormat.format(calendar.getTime()));//updatedOn
                  
                  sanoDto.setP4(sa.getUriAccessed());                 
                  listSanoDto.add(sanoDto);
                }
              
              al.size();
           
        } catch (Exception ex) {
            Logger.getLogger(OperatorApiController.class.getName()).log(Level.SEVERE, null, ex);
            response = ResponseEntity.status(HttpStatus.NOT_MODIFIED)
              .body(listSanoDto);
        }
        response = ResponseEntity.status(HttpStatus.OK).body(listSanoDto);
        return response; 
    }    
    
}

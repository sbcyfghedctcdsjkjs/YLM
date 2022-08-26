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
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import com.bananabkend.bananaBkEnd1A.service.ApiKeyService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
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
@RequestMapping("/loadProperties")
public class LoadPropertiesMsg {

    private ApiKeyService apiKeyService;
    
    public LoadPropertiesMsg(ApiKeyService apiKeyService) {
        this.apiKeyService= apiKeyService;
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

    @PostMapping(value = "/webViewer/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<HashMap<String,String>> readProperty(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult,HttpServletRequest req ) 
    {
        ResponseEntity<HashMap<String,String>> response=null;
        IdEncryptor enc = new IdEncryptor();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        AnonymousDto sanoDto = new AnonymousDto();
        if(!securityApi.getValid()){ //check API key
            sanoDto.setP3("N");
            return response = ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);     
        
        }
        
        try {
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_L"+anoDto.getP1());
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi=apiKeyService.save(securityApi);
        } catch (Exception ex) {
            Logger.getLogger(WebLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Properties property = new Properties();
        InputStream iStream = null;
        
        try {
            iStream = new FileInputStream("src/main/resources/webViewer/webViewer_"+anoDto.getP1()+".properties");
            property.load(iStream);
        } catch (Exception ex) {
            Logger.getLogger(LoadPropertiesMsg.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(iStream != null){
                    iStream.close();
                }
            }catch(Exception ex){
                Logger.getLogger(LoadPropertiesMsg.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Set<String> propNames=property.stringPropertyNames();
        HashMap map = new HashMap<String,String>();
        
        for (String key : propNames) {
            map.put(key, property.getProperty(key));
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(map);     
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.controller.publicView;

import com.bananabkend.bananaBkEnd1A.Utility.IdEncryptor;
import com.bananabkend.bananaBkEnd1A.Utility.property.ContentStatus;
import com.bananabkend.bananaBkEnd1A.model.CategoryModel;
import com.bananabkend.bananaBkEnd1A.model.SecurityApi;
import com.bananabkend.bananaBkEnd1A.model.dto.OwnerContentDto;
import com.bananabkend.bananaBkEnd1A.model.dto.SecurityApiDto;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer;
import com.bananabkend.bananaBkEnd1A.service.ApiKeyService;
import com.bananabkend.bananaBkEnd1A.service.CategoryService;
import com.bananabkend.bananaBkEnd1A.service.publicViewServices.UserAdViewerService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sunjiv6
 */
@RestController
@RequestMapping("/category")
public class CategoryController {    
    
    private CategoryService categoryService;
    private ApiKeyService apiKeyService; 
    private UserAdViewerService userAdViewerService;
    
    
    public CategoryController(CategoryService categoryService,ApiKeyService apiKeyService,
            UserAdViewerService userAdViewerService) {
        this.categoryService =categoryService;
    
        this.userAdViewerService = userAdViewerService;
        this.apiKeyService =apiKeyService;
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
    
    @PostMapping(value = "/create/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<AnonymousDto> create(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,BindingResult bindingResult) 
    {
        ResponseEntity<AnonymousDto> response=null;
        
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);        
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        AnonymousDto sanoDto = new AnonymousDto();
        if(!securityApi.getValid()){
            sanoDto.setP3("N");
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(sanoDto);             
        }
        
        IdEncryptor enc = new IdEncryptor();
        UserAdViewer userAdViewer = new UserAdViewer();
        
        boolean ownerExist=false;
        List<UserAdViewer> lo =null;
        try{ // check if user is genuine
            userAdViewer.setId(enc.decryptId(anoDto.getP6()));
            
            lo = this.userAdViewerService.getUserById(userAdViewer);
            if(!lo.isEmpty() && lo.get(0).getId()>0L){
                ownerExist=true;
                securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");
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
       try{        
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setCategoryName_en(anoDto.getP1());
            categoryModel.setStatus(anoDto.getP2());
            categoryModel.setCreatedOn(String.valueOf(System.currentTimeMillis()));
            this.categoryService.save(categoryModel);
            sanoDto.setP1("");
            sanoDto.setP3("Y");            
            response=ResponseEntity.status(HttpStatus.OK).body(sanoDto);
            
        }
        catch(Exception ex){
            sanoDto.setP3("N");
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(sanoDto);
        }        
        return response; 
    }
    
    
//    @PostMapping(value = "/getAllForM/{apiUniqueId}/{apiKey}",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
//    @ResponseBody
//    public ResponseEntity<ArrayList<AnonymousDto>> getAllActiveCategoryForM(
//            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
//              BindingResult bindingResult)     
    @RequestMapping(value = "/getAllForM/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ArrayList<AnonymousDto>> getAllActiveCategoryForM(@PathVariable String apiUniqueId,@PathVariable String apiKey,
            @RequestBody AnonymousDto anoDto,HttpServletRequest req)     
    {
        ResponseEntity<ArrayList<AnonymousDto>> response=null;
        response = getAllActiveCategoryImpl(apiUniqueId,apiKey,anoDto);
        return response;
    }
    

    //@RequestMapping(value = "/getAllForW/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<ArrayList<AnonymousDto>> getAllActiveCategoryForW(@PathVariable String apiUniqueId,@PathVariable String apiKey,
//            @RequestBody AnonymousDto anoDto,HttpServletRequest req)
    @PostMapping(value = "/getAllForW/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<ArrayList<AnonymousDto>> getAllActiveCategoryForW(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult) 
            
            
    {
        ResponseEntity<ArrayList<AnonymousDto>> response=null;
        response = getAllActiveCategoryImpl(apiUniqueId,apiKey,anoDto);
        return response;
    }
    
//    @PostMapping(value = "/getAll1/{apiUniqueId}/{apiKey}",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
//    @ResponseBody
    public ResponseEntity<ArrayList<AnonymousDto>> getAllActiveCategoryImpl(String apiUniqueId,String apiKey,AnonymousDto anoDto) 
    {
        ResponseEntity<ArrayList<AnonymousDto>> response=null;
        
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        AnonymousDto sanoDto = new AnonymousDto();
        ArrayList<AnonymousDto> list =  new ArrayList<AnonymousDto>();
        list.add(sanoDto);
        if(!securityApi.getValid()){
            sanoDto.setP3("N");
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(list);             
        }
        
        IdEncryptor enc = new IdEncryptor();
        UserAdViewer userAdViewer = new UserAdViewer();
        
        
        List<UserAdViewer> lo =null;
        try{
            securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
            //securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
            securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            securityApi=apiKeyService.save(securityApi);    
        }catch(Exception ex){
            //ex.printStackTrace();
                    sanoDto.setP3("N");
                response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                  .header("Status code", HttpStatus.NOT_FOUND.toString())
                  .header("StatusCode", HttpStatus.NOT_FOUND.toString())
                  .body(list);
                return response;
        
        }
        ArrayList<AnonymousDto> arrList=new ArrayList<AnonymousDto>();
        try{        
           String userLangInDB=null;
           if(securityApi.getViewerUserId()!=null){
               userAdViewer.setId(securityApi.getViewerUserId());
               lo = this.userAdViewerService.getUserById(userAdViewer);
               if(!lo.isEmpty() && lo.get(0).getId()>0L){
                   userLangInDB=lo.get(0).getLang();
                }
           }
           CategoryModel categoryModel=new CategoryModel();
           
           if(userLangInDB != null)  anoDto.setP2(userLangInDB);
           if(anoDto.getP2()==null) anoDto.setP2("en"); 
           if(anoDto.getP2().equals("bn"))
            arrList= this.categoryService.getAllActiveCategoryInAnoDto_bn(categoryModel);
           
           if(anoDto.getP2().equals("en") || anoDto.getP2().equals("en-in") || "en_au,en_ca,en_gb,en_ie,en_sg,en_za".contains(anoDto.getP2()))
            arrList= this.categoryService.getAllActiveCategoryInAnoDto_en(categoryModel);
           
           if(anoDto.getP2().equals("gu"))
            arrList= this.categoryService.getAllActiveCategoryInAnoDto_gu(categoryModel);
           if(anoDto.getP2().equals("hi"))
            arrList= this.categoryService.getAllActiveCategoryInAnoDto_hi(categoryModel);
           if(anoDto.getP2().equals("kn"))
            arrList= this.categoryService.getAllActiveCategoryInAnoDto_kn(categoryModel);
           if(anoDto.getP2().equals("ml"))
            arrList= this.categoryService.getAllActiveCategoryInAnoDto_ml(categoryModel);
           if(anoDto.getP2().equals("mr"))
            arrList= this.categoryService.getAllActiveCategoryInAnoDto_mr(categoryModel);
           if(anoDto.getP2().equals("pa"))
            arrList= this.categoryService.getAllActiveCategoryInAnoDto_pa(categoryModel);
           if(anoDto.getP2().equals("ta"))
            arrList= this.categoryService.getAllActiveCategoryInAnoDto_ta(categoryModel);
           if(anoDto.getP2().equals("te"))
            arrList= this.categoryService.getAllActiveCategoryInAnoDto_te(categoryModel);
           if(anoDto.getP2().equals("ur"))
            arrList= this.categoryService.getAllActiveCategoryInAnoDto_ur(categoryModel);           
           
           response=ResponseEntity.status(HttpStatus.OK).body(arrList);

        }
        catch(Exception ex){
            sanoDto.setP3("N");
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(list);                   
        }        
        return response; 
    }    
    
    
}
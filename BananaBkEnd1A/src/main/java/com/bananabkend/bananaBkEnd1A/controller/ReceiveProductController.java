/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.controller;

import com.bananabkend.bananaBkEnd1A.Utility.IdEncryptor;
//import com.bananabkend.bananaBkEnd1A.Utility.Scalr;// to create Image Icon
import com.bananabkend.bananaBkEnd1A.Utility.property.ContentStatus;
import com.bananabkend.bananaBkEnd1A.model.OwnerContent;
import com.bananabkend.bananaBkEnd1A.model.OwnerTargetArea;
import com.bananabkend.bananaBkEnd1A.model.Pricing;
import com.bananabkend.bananaBkEnd1A.model.SecurityApi;
import com.bananabkend.bananaBkEnd1A.model.UserOwner;
import com.bananabkend.bananaBkEnd1A.model.dto.OwnerContentDto;
import com.bananabkend.bananaBkEnd1A.model.dto.SecurityApiDto;
import com.bananabkend.bananaBkEnd1A.model.dto.TargetAreaDto;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousFileDto;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer;
import com.bananabkend.bananaBkEnd1A.service.ApiKeyService;
import com.bananabkend.bananaBkEnd1A.service.OwnerContentService;
import com.bananabkend.bananaBkEnd1A.service.OwnerTargetService;
import com.bananabkend.bananaBkEnd1A.service.PricingService;
import com.bananabkend.bananaBkEnd1A.service.UserOwnerService;
import com.bananabkend.bananaBkEnd1A.service.publicViewServices.UserAdViewerService;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author sunjiv6
 */
@RestController
@RequestMapping("/receiveProduct")
public class ReceiveProductController {
    UserAdViewerService userAdViewerService;

    UserOwnerService userOwnerService;
    OwnerContentService ownerContentService;
    OwnerTargetService ownerTargetService;
    ApiKeyService apiKeyService;
    PricingService pricingService;
    public ReceiveProductController(UserOwnerService userOwnerService,OwnerContentService ownerContentService,
            UserAdViewerService userAdViewerService,
            OwnerTargetService ownerTargetService,ApiKeyService apiKeyService,PricingService pricingService) {
        this.userOwnerService = userOwnerService;
        this.ownerContentService = ownerContentService;
        
        this.ownerTargetService =ownerTargetService;
        this.userAdViewerService= userAdViewerService;
        
        this.apiKeyService = apiKeyService;
        this.pricingService = pricingService;
    }
//    https://www.journaldev.com/2573/spring-mvc-file-upload-example-single-multiple-files
//    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
//    public @ResponseBody
//    String uploadFileHandler(@RequestParam("name") String name,
//                    @RequestParam("file") MultipartFile file) 
    //Working Example
    //curl --header "Content-Type: multipart/form-data"  -F 'inputFile01=@/home/sunjiv6/sunws/ProjectWS/bananaWS/AngularWS/frontendbanana/src/assets/images/c1.png' http://127.0.0.1:8020/ba/receiveAd/owner/uploadAd2
    //@ResponseStatus(value = HttpStatus.CREATED)
    
    
    @PostMapping(value = "/owner/uploadAd2/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseBody
    public ResponseEntity<String> ownerUploadAd2(@PathVariable String apiUniqueId,
            @PathVariable String apiKey,@ModelAttribute AnonymousFileDto anoDto) 
    {
        ResponseEntity<String> response=null;
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        Pricing pricing = new Pricing();
        if(!securityApi.getValid()){        
            return response = ResponseEntity.status(HttpStatus.OK).body(null);                 
        }
        
        OwnerContentDto ownerContentDto= new OwnerContentDto();
        ownerContentDto.setContentName_vb(anoDto.getP2());
        ownerContentDto.setPrice_vb(anoDto.getP3());
        ownerContentDto.setContentDesc_vb(anoDto.getP4());
        ownerContentDto.setTaxPercent_vb(anoDto.getP11());
        ownerContentDto.setTaxDetails_vb(anoDto.getP6());
        ownerContentDto.setTotalQntty_vb(anoDto.getP12());
        ownerContentDto.setQnttyUnit_vb(anoDto.getP14());
        
        
        ownerContentDto.setStatus_vb(anoDto.getP15());
        ownerContentDto.setInputFile01_vb(anoDto.getP8());
        ownerContentDto.setSelectedCategoryList_vb(anoDto.getP10());
        ownerContentDto.setAdDisplayType_vb(1);
        ownerContentDto.setAdType_vb(4);
        UserAdViewer userAdViewer=new UserAdViewer();
        IdEncryptor enc = new IdEncryptor();
        
        
        OwnerContent newOwnerContent;
        boolean ownerExist=false;
        
        BufferedOutputStream stream =null;
        File diskFile =null;
        List<UserAdViewer> lo =null;
        try{ // check if user is genuine
            userAdViewer.setId(enc.decryptId(anoDto.getP1()));
            
            lo = this.userAdViewerService.getUserById(userAdViewer);
            if(!lo.isEmpty() && lo.get(0).getId()>0L){
                ownerExist=true;
                securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()
                        +"_Cr8");
                //securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
                securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                securityApi=apiKeyService.save(securityApi);    
                
            }            
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!ownerExist){
                response = ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                  .header("Status code", HttpStatus.UNAUTHORIZED.toString())
                  .header("StatusCode", HttpStatus.UNAUTHORIZED.toString())
                  
                   
                  .body("usr_not_found_msg");
                return response;    
            }
            if(!lo.isEmpty() && lo.get(0).getCreateCount()+1 > lo.get(0).getCreateLimit()){
                response = ResponseEntity.status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE)
                  .header("Status code", HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE.toString())
                  .header("StatusCode", HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE.toString())
                  .body("limit_reach_msg");
                return response; 
            }
        }
        try{
            if(!ownerContentDto.getInputFile01_vb().getContentType().startsWith("image/")){
                response = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                      .header("Status code", HttpStatus.NOT_ACCEPTABLE.toString())
                      .header("StatusCode", HttpStatus.NOT_ACCEPTABLE.toString())
                      .body("file_not_acc_msg");
                    return response; 
            }

            if(ownerContentDto.getInputFile01_vb().getSize() > ContentStatus.FileSize){ 
                response = ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE)
                      .header("Status code", HttpStatus.PAYLOAD_TOO_LARGE.toString())
                      .header("StatusCode", HttpStatus.PAYLOAD_TOO_LARGE.toString())
                      .body("size_heavy");
                    return response; 

            }
        }catch(Exception ex){ex.printStackTrace();}
        
        
        try{ // store file on disk
                
                pricing.setPrice(Double.parseDouble(ownerContentDto.getPrice_vb()));
                pricing.setUnitDetail(ownerContentDto.getQnttyUnit_vb());
                pricing.setAvailableQuantity(Integer.parseInt(ownerContentDto.getTotalQntty_vb()));
                pricing.setTaxPercent(Double.parseDouble(ownerContentDto.getTaxPercent_vb()));
                pricing.setTaxDetail(ownerContentDto.getTaxDetails_vb());
                pricing.setSoldQuantity(0);
                pricing.setStatus("Y");
                pricing=pricingService.registerNewPricing(pricing);
                newOwnerContent = new OwnerContent();
                String genName = lo.get(0).getId()+"_"+System.currentTimeMillis()+"_"+ContentStatus.DirPathIndex;
                String ext = ownerContentDto.getInputFile01_vb().getOriginalFilename().substring(ownerContentDto.getInputFile01_vb().getOriginalFilename().lastIndexOf("."));
                
                //generateImageDisplayType(ownerContentDto.getInputFile01_vb(),genName,ext);
                     
                newOwnerContent.setOwnerUserId(lo.get(0).getId());
                newOwnerContent.setContentType(ContentStatus.ContentType_Product);
                newOwnerContent.setGeneratedFileName(genName );
                newOwnerContent.setUploadedFileName(ownerContentDto.getInputFile01_vb().getOriginalFilename());
                newOwnerContent.setDirectoryPathsId(ContentStatus.DirPathIndex);
                newOwnerContent.setContentDesc(ownerContentDto.getContentDesc_vb());
                newOwnerContent.setAdType(ownerContentDto.getAdType_vb());
                newOwnerContent.setAdDisplayType(ownerContentDto.getAdDisplayType_vb()); 
                newOwnerContent.setContentName(ownerContentDto.getContentName_vb());
                newOwnerContent.setCreatedOn(String.valueOf(System.currentTimeMillis()));
                newOwnerContent.setPricingId(pricing.getId());
                newOwnerContent.setCategory(ownerContentDto.getSelectedCategoryList_vb());
                if(ownerContentDto.getStatus_vb().equals("Y")) 
                        newOwnerContent.setActiveDate(String.valueOf(System.currentTimeMillis()));
                
                newOwnerContent.setStatus(ownerContentDto.getStatus_vb());
                 
                byte[] bytes = ownerContentDto.getInputFile01_vb().getBytes();
                // Creating the directory to store file
                String rootPath = ContentStatus.DirPathArray[ContentStatus.DirPathIndex];
                File dir = new File(rootPath);
//                if (!dir.exists())
//                    dir.mkdirs();

                // Create the file on server
                diskFile = new File(dir.getAbsolutePath() + File.separator + genName);
                stream = new BufferedOutputStream(new FileOutputStream(diskFile));
                stream.write(bytes);
                
        }catch(Exception ex){
            response = ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                      .header("Status code", HttpStatus.NOT_MODIFIED.toString())
                      .header("StatusCode", HttpStatus.NOT_MODIFIED.toString())
                      .body("store_fail");
                    return response;   
        }finally{
            try{
                if(stream!=null)stream.close();
            }catch(Exception ex){ex.printStackTrace();}
        }
        
        
        try{  //store new record in database
            newOwnerContent=ownerContentService.createNewContentAd(newOwnerContent);  
            pricing.setOwnerContentId(newOwnerContent.getId());
            pricingService.save(pricing);
        }catch(Exception ex){           
            
            //delete the stored file on disk
            
            if(diskFile !=null) diskFile.delete();
            response = ResponseEntity.status(HttpStatus.CREATED)
                  .header("Status code", HttpStatus.CREATED.toString())
                  .header("StatusCode", HttpStatus.CREATED.toString())
                  .body("store_fail");
                return response;   
        }finally{
           diskFile=null;
        }
        
        try{  //update create count in database
            lo.get(0).setCreateCount(lo.get(0).getCreateCount()+1);
            userAdViewerService.save(lo.get(0));            
        }catch(Exception ex){
             ex.printStackTrace();
        }
        
        response=ResponseEntity.status(HttpStatus.OK)
                .body("{\"message\": \"File upload done. Please confirm 'Target Area'.\"}");
                
        return response;
    }
    
    
    
    //Working Example
    @PostMapping("/owner/modify/ad2/{apiUniqueId}/{apiKey}")
    @ResponseBody
    public ResponseEntity<String> ownerModifyAd2(@PathVariable String apiUniqueId,@PathVariable String apiKey,
            @ModelAttribute AnonymousFileDto anoDto,BindingResult bindingResult )//(@RequestBody OwnerContent ownerContent) 
    {
        ResponseEntity<String> response=null;
        SecurityApiDto securityApiDto=new SecurityApiDto();
            securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        Pricing pricing = new Pricing();
        if(!securityApi.getValid()){
        
            return response = ResponseEntity.status(HttpStatus.OK).body(null);     
            
        }
//        UserOwner owner= new UserOwner();
//        owner.setUserPhone(ownerContentDto.getOwnerPhone_vb());
//        owner.setUserEmail(ownerContentDto.getOwnerEmail_vb());
//        owner.setSecretNumberEncoded(ownerContentDto.getSecretNumber_vb());


        OwnerContentDto ownerContentDto= new OwnerContentDto();
        // ownerContentDto.setOwnerPhone_vb(anoDto.getP1());        
        ownerContentDto.setContentName_vb(anoDto.getP2());
        ownerContentDto.setPrice_vb(anoDto.getP3());
        ownerContentDto.setContentDesc_vb(anoDto.getP4());
        ownerContentDto.setTaxPercent_vb(anoDto.getP11());
        ownerContentDto.setTaxDetails_vb(anoDto.getP6());
        ownerContentDto.setTotalQntty_vb(anoDto.getP12());
        ownerContentDto.setQnttyUnit_vb(anoDto.getP14());
        ownerContentDto.setStatus_vb(anoDto.getP15());
        ownerContentDto.setInputFile01_vb(anoDto.getP8());

        ownerContentDto.setSelectedCategoryList_vb(anoDto.getP10());
        ownerContentDto.setId_vb(anoDto.getP16());
        ownerContentDto.setAdDisplayType_vb(1);
        ownerContentDto.setAdType_vb(4);
        UserAdViewer userAdViewer = new UserAdViewer();
        OwnerContent newOwnerContent;

        boolean ownerExist=false;
        BufferedOutputStream stream =null;

        File diskFile =null;
        File oldDiskFile =null;
        List<UserAdViewer> lo =null;
        File dir = null;
        Long userId =0l;Long contentId=0l;
        IdEncryptor enc = new IdEncryptor();
        try{ // check if user is genuine            
            contentId = enc.decryptId(ownerContentDto.getId_vb());
            
            userId=enc.decryptId(anoDto.getP1());
            userAdViewer.setId(enc.decryptId(anoDto.getP1()));
            
            lo = this.userAdViewerService.getUserById(userAdViewer);
            if(!lo.isEmpty() && lo.get(0).getId()>0L){
                ownerExist=true;
                securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_Prd"+lo.get(0).getId()+"_Mdf");
                //securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
                securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                securityApi=apiKeyService.save(securityApi);  
            }            
           
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!ownerExist){
                response = ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                  .header("Status code", HttpStatus.UNAUTHORIZED.toString())
                  .header("StatusCode", HttpStatus.UNAUTHORIZED.toString())
                  .body("chk_phn_eml");
                return response;    
            }            
        }
        
        try{    // modify content 
                newOwnerContent = ownerContentService.getOwnerContentByIdForForm(contentId);
                Pricing oldPricing = pricingService.getPricingInfoFromId(newOwnerContent.getPricingId());
                if(oldPricing.getPrice()!=Double.parseDouble(ownerContentDto.getPrice_vb())
                        || !oldPricing.getUnitDetail().equals(ownerContentDto.getQnttyUnit_vb())
                        || oldPricing.getAvailableQuantity()!=Integer.parseInt(ownerContentDto.getTotalQntty_vb())
                        || oldPricing.getTaxPercent()!=Double.parseDouble(ownerContentDto.getTaxPercent_vb())
                        || !oldPricing.getTaxDetail().equals(ownerContentDto.getTaxDetails_vb())
                        ){                
                    oldPricing.setStatus("N");                 
                    oldPricing=pricingService.save(oldPricing);
                    pricing.setPrice(Double.parseDouble(ownerContentDto.getPrice_vb()));
                    pricing.setUnitDetail(ownerContentDto.getQnttyUnit_vb());
                    pricing.setAvailableQuantity(Integer.parseInt(ownerContentDto.getTotalQntty_vb()));
                    pricing.setTaxPercent(Double.parseDouble(ownerContentDto.getTaxPercent_vb()));
                    pricing.setTaxDetail(ownerContentDto.getTaxDetails_vb());
                    pricing.setOwnerContentId(contentId);
                    pricing.setSoldQuantity(0);
                    pricing.setStatus("Y");

                    pricing=pricingService.registerNewPricing(pricing);
                    newOwnerContent.setPricingId(pricing.getId());
                }
                
                // modify content 
                newOwnerContent.setContentDesc(ownerContentDto.getContentDesc_vb());                
                newOwnerContent.setAdType(ownerContentDto.getAdType_vb());
                newOwnerContent.setAdDisplayType(ownerContentDto.getAdDisplayType_vb());
                newOwnerContent.setCategory(ownerContentDto.getSelectedCategoryList_vb());
                if(ownerContentDto.getStatus_vb().equals("Y")) newOwnerContent.setActiveDate(String.valueOf(System.currentTimeMillis()));
                newOwnerContent.setStatus(ownerContentDto.getStatus_vb());
                newOwnerContent.setContentName(ownerContentDto.getContentName_vb());
                if(ownerContentDto.getInputFile01_vb()!=null && ownerContentDto.getInputFile01_vb().getBytes().length>0){
                   
                    if(!ownerContentDto.getInputFile01_vb().getContentType().startsWith("image/")){
                        response = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                              .header("Status code", HttpStatus.NOT_ACCEPTABLE.toString())
                              .header("StatusCode", HttpStatus.NOT_ACCEPTABLE.toString())
                              .body("file_not_acc");
                            return response; 
                    }

                    if(ownerContentDto.getInputFile01_vb().getSize() > ContentStatus.FileSize){ // less than 500 KiloBytes
                        response = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                              .header("Status code", HttpStatus.NOT_ACCEPTABLE.toString())
                              .header("StatusCode", HttpStatus.NOT_ACCEPTABLE.toString())
                              .body("file_not_acc");
                            return response; 

                    }
                   
                    try{
                        String rootPath = ContentStatus.DirPathArray[ContentStatus.DirPathIndex];
                        dir = new File(rootPath);                                
                        oldDiskFile = new File(dir.getAbsolutePath() + File.separator + newOwnerContent.getGeneratedFileName());
                        oldDiskFile.delete();
                    }catch(Exception ex){                        
                        ex.printStackTrace();
                    }
                    String genName = lo.get(0).getId()+"_"+System.currentTimeMillis()+"_"+ContentStatus.DirPathIndex;
                    String ext = ownerContentDto.getInputFile01_vb().getOriginalFilename().substring(ownerContentDto.getInputFile01_vb().getOriginalFilename().lastIndexOf("."));
                
                    //generateImageDisplayType(ownerContentDto.getInputFile01_vb(),genName,ext);
               
                    newOwnerContent.setGeneratedFileName(genName);
                    
                    newOwnerContent.setUploadedFileName(ownerContentDto.getInputFile01_vb().getOriginalFilename());
                    newOwnerContent.setDirectoryPathsId(ContentStatus.DirPathIndex);

                    byte[] bytes = ownerContentDto.getInputFile01_vb().getBytes();
                    // Creating the directory to store file

    //                if (!dir.exists())
    //                    dir.mkdirs();
                    // Create the file on server
                    diskFile = new File(dir.getAbsolutePath() + File.separator + genName);                
                    stream = new BufferedOutputStream(new FileOutputStream(diskFile));
                    stream.write(bytes);
                }
                
        }catch(Exception ex){       
            //ex.printStackTrace();
             //delete the stored file on disk
           response = ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                      .header("Status code", HttpStatus.NOT_MODIFIED.toString())
                      .header("StatusCode", HttpStatus.NOT_MODIFIED.toString())
                      .body("store_fail");
                    return response;   
        }finally{
           try{
                if(stream!=null)stream.close();
            }catch(Exception ex){ex.printStackTrace();}
        }
        
        
        try{  //store modified record in database
            
            ownerContentService.modifyAd(newOwnerContent);            
        }catch(Exception ex){           
            //ex.printStackTrace();
             //delete the stored file on disk
            if(diskFile !=null) diskFile.delete();
            response = ResponseEntity.status(HttpStatus.CREATED)
                  .header("Status code", HttpStatus.CREATED.toString())
                  .header("StatusCode", HttpStatus.CREATED.toString())
                  .body("store_fail");
                return response;   
        }finally{
           diskFile=null;
        }
        
         response=ResponseEntity.status(HttpStatus.OK)
                .body("{\"message\": \"Ad modify done.\"}");
                
        return response;
    }
 
    //Working Example
    @PostMapping("/owner/saveTargetArea2/{apiUniqueId}/{apiKey}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<String> ownerSaveTargetArea2(@PathVariable String apiUniqueId,@PathVariable String apiKey,
            @RequestParam String p1,@RequestParam(value="p4[]") ArrayList<String> target)//(@RequestBody OwnerContent ownerContent) 
    {
        ResponseEntity<String> response=null;        
        SecurityApiDto securityApiDto=new SecurityApiDto();
       
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        if(!securityApi.getValid() || target.size() > ContentStatus.TargetAreasLimitForOwner){ //APIkey Invalid OR target size invalid       
            return response = ResponseEntity.status(HttpStatus.OK).body(null);     
            
        }
        List<UserAdViewer> lo =null;

        Boolean ownerExist=false;
//        UserOwner owner= new UserOwner();        
//        owner.setUserPhone(ownerPhone);
//        owner.setUserEmail(ownerEmail);
//        owner.setSecretNumberEncoded(secretNumber); 
        
        UserAdViewer userAdViewer = new UserAdViewer();
//        userAdViewer.setAdViewerPhone(p1);
//        userAdViewer.setAdViewerEmail(p2);        
//        userAdViewer.setSecretNumber(p3);
        
        try{ // check if user is genuine
            IdEncryptor enc = new IdEncryptor();
            userAdViewer.setId(enc.decryptId(p1));            
            lo = this.userAdViewerService.getUserById(userAdViewer);
            //lo = this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer);
//            lo=userAdViewer.getAdViewerPhone().length()<1 ? this.userAdViewerService.getUserByEmailAndSecretNumber(userAdViewer):
//                    this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer);
            
            if(!lo.isEmpty() && lo.get(0).getId()>0L){
                ownerExist=true;
//                if(securityApi.getOwnerUserId()==null)
//                {   
//                    securityApi.setOwnerUserId(lo.get(0).getId());
//                }
                securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");
                securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                securityApi=apiKeyService.save(securityApi);
                
                if(target.size()==1 && target.get(0).equals("undefined")){ //Empty TA not allowed
                    response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .header("Status code", HttpStatus.INTERNAL_SERVER_ERROR.toString())
                        .header("StatusCode", HttpStatus.INTERNAL_SERVER_ERROR.toString())
                        .body("Empty NA");
                    return response;
                 }
            }
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!ownerExist | target.size() > ContentStatus.TargetAreaCount){
                response = ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                  .header("Status code", HttpStatus.UNAUTHORIZED.toString())
                  .header("StatusCode", HttpStatus.UNAUTHORIZED.toString())
                  .body("chk_phn_eml");
                return response;    
            }
        }
        OwnerTargetArea ownerTargetArea= null;
        
        try{
            ownerTargetArea = this.ownerTargetService.getTargetIdForOwnerUserId(lo.get(0).getId());
        }catch(Exception ex)
        {
                response = ResponseEntity.status(HttpStatus.NO_CONTENT)
                  .header("Status code", HttpStatus.NO_CONTENT.toString())
                  .header("StatusCode", HttpStatus.NO_CONTENT.toString())
                  .body("Create new.");
                return response;                
        }
        
        if(ownerTargetArea==null) ownerTargetArea= new OwnerTargetArea();
        
        ownerTargetArea.setTarget(target); 
//        ArrayList<String> tempTarget=null;
//        tempTarget.addAll(target);  // to break the link between uppercase target and lowercase target
        try{                 
            
            ArrayList<String> upperCaseListofTarget=new ArrayList<String>();
            upperCaseListofTarget.addAll(target);
            upperCaseListofTarget.replaceAll(String::toUpperCase);
            upperCaseListofTarget.replaceAll(String::trim);
            
            String allTargets = String.join(",[][],",upperCaseListofTarget);
            allTargets=allTargets.trim().replaceAll("\\s+", " ");   // multiple space to a single space
            allTargets=allTargets.trim().replaceAll(",\\s+", ",");   // comma & multiple space to a single comma
            allTargets=allTargets.trim().replaceAll(",\\s", ","); // comma & single space to a single comma
            allTargets=allTargets.trim().replaceAll("\\s+,", " ,"); // multi space & comma to a single space & comma
            allTargets=allTargets.trim().replaceAll("\\s,", ","); // single space & comma to a single comma
            
            
            ownerTargetArea.setAllTargets(allTargets);
            ownerTargetArea.setUserOwnerId(lo.get(0).getId());
            this.ownerTargetService.saveTargetArea(ownerTargetArea);

        }
        catch(Exception ex){   
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .header("Status code", HttpStatus.INTERNAL_SERVER_ERROR.toString())
                  .header("StatusCode", HttpStatus.INTERNAL_SERVER_ERROR.toString())
                  .body("store_fail");
                return response;    
        }
        
        response=ResponseEntity.status(HttpStatus.OK)
                                .body("{\"message\": \"Target Area stored.\"}");        
        return response;
    } 
    
    @PostMapping("/owner/loadTargetArea2/{apiUniqueId}/{apiKey}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<AnonymousDto> ownerLoadTargetArea2(@PathVariable String apiUniqueId,
            @PathVariable String apiKey,@RequestParam String p1)//(@RequestBody OwnerContent ownerContent) 
    {
        ResponseEntity<AnonymousDto> response=null;
        AnonymousDto sanoDto = new AnonymousDto();
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        if(!securityApi.getValid()){
        
            return response = ResponseEntity.status(HttpStatus.OK).body(null);     
            
        }
        List<UserAdViewer> lo =null;
        Boolean ownerExist=false;
//        UserOwner owner= new UserOwner();
//        owner.setUserPhone(ownerPhone);
//        owner.setUserEmail(ownerEmail);
//        owner.setSecretNumberEncoded(secretNumber);
        UserAdViewer userAdViewer = new UserAdViewer();
//        userAdViewer.setAdViewerPhone(p1);
//        userAdViewer.setAdViewerEmail(p2);        
//        userAdViewer.setSecretNumber(p3);
               
        try{ // check if user is genuine
            IdEncryptor enc = new IdEncryptor();
            userAdViewer.setId(enc.decryptId(p1));
            
            lo = this.userAdViewerService.getUserById(userAdViewer);
//            lo=userAdViewer.getAdViewerPhone().length()<1 ? this.userAdViewerService.getUserByEmailAndSecretNumber(userAdViewer):
//                    this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer);
            //lo = this.userAdViewerService.getUserByPhoneAndSecretNumber(userAdViewer);
            if(!lo.isEmpty() && lo.get(0).getId()>0L){
                ownerExist=true;
//                if(securityApi.getOwnerUserId()==null)
//                {   
//                    securityApi.setOwnerUserId(lo.get(0).getId());
//                }
                //securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
                
                securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+",");
                securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                securityApi=apiKeyService.save(securityApi);                
            }
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!ownerExist){
                response = ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                  .header("Status code", HttpStatus.UNAUTHORIZED.toString())
                  .header("StatusCode", HttpStatus.UNAUTHORIZED.toString())
                  .body(new AnonymousDto());
                return response;    
            }
        }
        
        try{
            OwnerTargetArea ota = this.ownerTargetService.getTargetAreaForSingleOwner(lo.get(0).getId());
            
            
            TargetAreaDto targetAreaDto = new TargetAreaDto();
            targetAreaDto.setId_vb("");
            //targetAreaDto.setOwnerEmail_vb(ota.getOwnerEmail());
            //targetAreaDto.setOwnerPhone_vb(ota.getOwnerPhone());
            //targetAreaDto.setSecretNumber_vb(ota.getSecretNumber());
            
            if(ota!=null){
                sanoDto.setP14(ota.getTarget());
                targetAreaDto.setTarget_vb(ota.getTarget());
            }
            else targetAreaDto.setTarget_vb(new ArrayList());
            //targetAreaDto.setAllTargets_vb(ota.getAllTargets());
            //targetAreaDto.setUserOwnerId_vb(ota.getUserOwnerId());
            
            
            response=ResponseEntity.status(HttpStatus.OK)
                .body(sanoDto);
        }
        catch(Exception ex){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(new AnonymousDto());                   
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

    private void generateImageDisplayType(MultipartFile inputFile01, String genName, String fileExt) throws Exception{
        InputStream stream  = null;
        try{
        String rootPath = ContentStatus.DirPathArray[ContentStatus.DirPathIndex];
        File targetDir = new File(rootPath);
        // Create the file on server
        
        long start = System.currentTimeMillis();
        stream=inputFile01.getInputStream();
        BufferedImage src = ImageIO.read(stream);
        //System.out.println(System.currentTimeMillis());
        
        //Icon
//        BufferedImage target = Scalr.resize(src,30 );            
//        File outputName = new File(targetDir.getAbsolutePath() + File.separator + genName+"_icon");//+fileExt);   
//        ImageIO.write(target, fileExt.substring(1), outputName);
//        System.out.println("output file: "+outputName.getPath());

//        target = Scalr.resize(src,250,250 );            
//        outputName = new File(targetDir.getAbsolutePath() + File.separator + genName+"_250x."+fileExt);            
//        ImageIO.write(target, fileExt, outputName);
//        System.out.println("output file: "+outputName.getPath());
//
//        target = Scalr.resize(src,500,500 );            
//        outputName = new File(targetDir.getAbsolutePath() + File.separator + genName+"_500x."+fileExt);        
//        ImageIO.write(target,fileExt, outputName);
//        System.out.println("output file: "+outputName.getPath());
//
//        target = Scalr.resize(src,750,750 );            
//        outputName = new File(targetDir.getAbsolutePath() + File.separator + genName+"_750x."+fileExt); 
//        ImageIO.write(target, fileExt, outputName);
//        System.out.println("output file: "+outputName.getPath());

        long end = System.currentTimeMillis();
        long finish = end-start;
        System.out.println("Finish time: "+finish);
        
        
        }catch(Exception ex){
        }finally{
            try{
                if(stream!=null)stream.close();
            }catch(Exception ex){ex.printStackTrace();}
        }
    }
}

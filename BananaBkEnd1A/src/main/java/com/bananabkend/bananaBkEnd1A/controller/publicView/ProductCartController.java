/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.controller.publicView;
import com.bananabkend.bananaBkEnd1A.Utility.IdEncryptor;
import com.bananabkend.bananaBkEnd1A.Utility.property.ContentStatus;
import com.bananabkend.bananaBkEnd1A.model.ProductCart;
import com.bananabkend.bananaBkEnd1A.model.SecurityApi;
import com.bananabkend.bananaBkEnd1A.model.dto.SecurityApiDto;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer;
import com.bananabkend.bananaBkEnd1A.service.ApiKeyService;
import com.bananabkend.bananaBkEnd1A.service.ProductCartService;
import com.bananabkend.bananaBkEnd1A.service.publicViewServices.RetrieveAdsContentService;
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
 * @author bunsiv
 */


@RestController
@RequestMapping("/prodCart")

public class ProductCartController {
    private ApiKeyService apiKeyService; 
    private ProductCartService productCartService;
    private UserAdViewerService userAdViewerService;
    RetrieveAdsContentService retrieveAdsContentService;
    public ProductCartController(ProductCartService productCartService,UserAdViewerService userAdViewerService,
            ApiKeyService apiKeyService,RetrieveAdsContentService retrieveAdsContentService) {
        this.productCartService = productCartService;
        this.userAdViewerService = userAdViewerService;
        this.apiKeyService = apiKeyService;
        this.retrieveAdsContentService= retrieveAdsContentService;
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
    
    @RequestMapping(value = "/addToCartForM/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AnonymousDto> addToCartForM(@PathVariable String apiUniqueId,@PathVariable String apiKey,
            @RequestBody AnonymousDto anoDto,HttpServletRequest req)     
    {
        ResponseEntity<AnonymousDto> response=null;
        response = addToCartImpl(apiUniqueId,apiKey,anoDto);
        return response;
    }
    

    //@RequestMapping(value = "/getAllForW/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<ArrayList<AnonymousDto>> getAllActiveCategoryForW(@PathVariable String apiUniqueId,@PathVariable String apiKey,
//            @RequestBody AnonymousDto anoDto,HttpServletRequest req)
    @PostMapping(value = "/addToCartForW/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<AnonymousDto> addToCartForW(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult) 
    {
        ResponseEntity<AnonymousDto> response=null;
        response = addToCartImpl(apiUniqueId,apiKey,anoDto);
        return response;
    }

    private ResponseEntity<AnonymousDto> addToCartImpl(String apiUniqueId, String apiKey, AnonymousDto anoDto) {        
        ResponseEntity<AnonymousDto> response=null;        
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);        
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        
        AnonymousDto sanoDto = new AnonymousDto();
        //ArrayList<AnonymousDto> list =  new ArrayList<AnonymousDto>();
        //list.add(sanoDto);
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
            userAdViewer.setId(enc.decryptId(anoDto.getP1()));
            
            lo = this.userAdViewerService.getUserById(userAdViewer);
            if(!lo.isEmpty() && lo.get(0).getId()>0L){
                ownerExist=true;
                securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()
                        +"_K"+lo.get(0).getCartId()+"_P"+enc.decryptId(anoDto.getP2())+",");
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
            Integer qnty=0;
            ProductCart cart = new ProductCart();
            cart.setId(lo.get(0).getCartId());
            cart = productCartService.getActiveCartInfoFromId(cart);
            if(cart==null){
                cart = new ProductCart();
                cart.setUserId(lo.get(0).getId());
                cart.setCartItemsList(",");
                cart.setStatus("Y");
                cart=productCartService.save(cart);
                lo.get(0).setCartId(cart.getId());
                this.userAdViewerService.getUserById(lo.get(0));
            }
            cart.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
            
            Long prodId=enc.decryptId(anoDto.getP2());

            if(anoDto.getP3().equals("1")){//add
                if(cart.getCartItemsList().contains(","+String.valueOf(prodId)+"_")){ //already exist product
                    int start = cart.getCartItemsList().indexOf(","+String.valueOf(prodId)+"_")+ (","+String.valueOf(prodId)+"_").length();//cartt.indexOf(","+r.getId()+"_")+(","+r.getId()+"_").length;
                    qnty = Integer.parseInt(cart.getCartItemsList().substring(start,start+2));
                    //qnty++;
                    if(qnty < 20+ContentStatus.ExtraCartProdQuantity){
                        String str1 =cart.getCartItemsList().replaceAll(","+String.valueOf(prodId)+"_"+String.valueOf(qnty)+",",","+String.valueOf(prodId)+"_"+String.valueOf(qnty+1)+",");
                    
                        cart.setCartItemsList(str1);
                        
                        qnty=qnty+1;
                    }
                }else{//new prod
                    cart.setCartItemsList(cart.getCartItemsList()+String.valueOf(prodId)+"_"+(ContentStatus.ExtraCartProdQuantity+1)+",");
                    qnty=ContentStatus.ExtraCartProdQuantity+1;
                }
            }
            if(anoDto.getP3().equals("2")) {//remove
//                int start = cart.getCartItemsList().indexOf(","+String.valueOf(prodId)+"_")+ (","+String.valueOf(prodId)+"_").length();//cartt.indexOf(","+r.getId()+"_")+(","+r.getId()+"_").length;
//                Integer qnty = Integer.parseInt(cart.getCartItemsList().substring(start,start+2));
                //if(qnty-1==ContentStatus.ExtraCartProdQuantity)                {//quantity is 0 so remove
                    //cart.setCartItemsList(cart.getCartItemsList().replaceFirst(","+String.valueOf(prodId)+",", ","));                
                    cart.setCartItemsList(cart.getCartItemsList().replaceAll(","+String.valueOf(prodId)+"_\\d\\d,",","));                
//              }  else{// decrease the quantity
//                    cart.setCartItemsList(cart.getCartItemsList().replaceAll(","+String.valueOf(prodId)+"_"+String.valueOf(qnty),","+String.valueOf(prodId)+"_"+String.valueOf(qnty-1)));
//                }
            }
            if(anoDto.getP3().equals("3")){// set the quantity
                int start = cart.getCartItemsList().indexOf(","+String.valueOf(prodId)+"_")+ (","+String.valueOf(prodId)+"_").length();//cartt.indexOf(","+r.getId()+"_")+(","+r.getId()+"_").length;
                
                qnty = Integer.parseInt(cart.getCartItemsList().substring(start,start+2));
                if(qnty-1 > 0+ContentStatus.ExtraCartProdQuantity){
                    cart.setCartItemsList(cart.getCartItemsList().replaceAll(","+String.valueOf(prodId)+"_"+String.valueOf(qnty),
                                                ","+String.valueOf(prodId)+"_"+String.valueOf(qnty-1)));
                    qnty=qnty-1;
                }
            }
//            
//            String[] cartItems = anoDto.getP6().split(",");
//                StringBuilder strB=new StringBuilder();
//                strB.append(",");
//
//
//                for (int i = 1; i < cartItems.length; i++) {
//                    strB.append(enc.decryptId(cartItems[i]));
//                    strB.append(",");                
//                }
//                
//            cart.setCartItemsList(strB.toString());
            this.productCartService.save(cart);
            sanoDto.setP1("");
            sanoDto.setP2(String.valueOf(qnty-ContentStatus.ExtraCartProdQuantity));      
            sanoDto.setP3("Y");  
            sanoDto.setP4(anoDto.getP4());
            response=ResponseEntity.status(HttpStatus.OK).body(sanoDto);
            
        }
        catch(Exception ex){
            sanoDto.setP3("N");
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(sanoDto);
        }    
        return response;
    }
    
    @RequestMapping(value = "/listCartItemsForM/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ArrayList<AnonymousDto>> listCartItemsForM(@PathVariable String apiUniqueId,@PathVariable String apiKey,
            @RequestBody AnonymousDto anoDto,HttpServletRequest req)     
    {
        ResponseEntity<ArrayList<AnonymousDto>> response=null;
        response = listCartItemsImpl(apiUniqueId,apiKey,anoDto);
        return response;
    }
    

    //@RequestMapping(value = "/getAllForW/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<ArrayList<AnonymousDto>> getAllActiveCategoryForW(@PathVariable String apiUniqueId,@PathVariable String apiKey,
//            @RequestBody AnonymousDto anoDto,HttpServletRequest req)
    @PostMapping(value = "/listCartItemsForW/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<ArrayList<AnonymousDto>> listCartItemsForW(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult) 
    {
        ResponseEntity<ArrayList<AnonymousDto>>response=null;
        response = listCartItemsImpl(apiUniqueId,apiKey,anoDto);
        return response;
    }

    private ResponseEntity<ArrayList<AnonymousDto>> listCartItemsImpl(String apiUniqueId, String apiKey, AnonymousDto anoDto) {
        
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
        boolean ownerExist=false;
        List<UserAdViewer> lo =null;
        try{ // check if user is genuine
            userAdViewer.setId(enc.decryptId(anoDto.getP1()));
            
            lo = this.userAdViewerService.getUserById(userAdViewer);
            if(!lo.isEmpty() && lo.get(0).getId()>0L){
                ownerExist=true;
                securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()
                        +"_K"+lo.get(0).getCartId()+",");
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
                  .body(list);
                return response;
            }
        }
       try{  
            ProductCart cart = new ProductCart();
            cart.setId(lo.get(0).getCartId());
            cart = productCartService.getActiveCartInfoFromId(cart);
            String cartItemsList = cart.getCartItemsList().replaceAll("_\\d\\d,",",");
            List<RetrieveAdsContent> listAdsContent= null;  
            AnonymousDto sanoPriceDto= new AnonymousDto();
            Double price=0.0;
            listAdsContent = this.retrieveAdsContentService.getContentForMultipleIds(cartItemsList.substring(1, cartItemsList.length()-1));
            //OwnerContentDto oDto=null;
            list =  new ArrayList<AnonymousDto>();
            for (RetrieveAdsContent r : listAdsContent) {
                sanoDto= new AnonymousDto();
               
                sanoDto.setP1(enc.encryptId(r.getId()));
                int start = cart.getCartItemsList().indexOf(","+r.getId()+"_")+(","+r.getId()+"_").length();
                Integer qnty = Integer.parseInt(cart.getCartItemsList().substring(start,start+2))- ContentStatus.ExtraCartProdQuantity;
                //sanoDto.setP1(String.valueOf(r.getId()));
                sanoDto.setP2(r.getContentDesc());
                sanoDto.setP3(String.valueOf(r.getPageNum())); 
                sanoDto.setP4(String.valueOf(listAdsContent.size()));
                sanoDto.setP5(r.getAdType());
                sanoDto.setP6(r.getCreatedOn());  
                sanoDto.setP7(r.getAdDisplayType());  
                sanoDto.setP10(String.valueOf(r.getPrice()));  
                sanoDto.setP11(r.getUnitDetail());
                sanoDto.setP15(String.valueOf(qnty));
                price=Double.valueOf(r.getPrice()+"")*qnty + price;
                list.add(sanoDto);
            }
            sanoPriceDto.setP1(String.valueOf(price).split("\\.")[0]);
            sanoPriceDto.setP2((String.valueOf(price).split("\\.")[1]+"00").substring(0,2));
//            sanoPriceDto.setP3(String.valueOf().split("\\.")[0]);
//            sanoPriceDto.setP4(String.valueOf().split("\\.")[1]+"00").substring(0,2));
//            sanoPriceDto.setP6(String.valueOf().split("\\.")[0]);
//            sanoPriceDto.setP10(String.valueOf().split("\\.")[1]+"00").substring(0,2));
//            sanoPriceDto.setP2(String.valueOf(price));
            list.add(sanoPriceDto);
            response=ResponseEntity.status(HttpStatus.OK)
                .body(list);           
            //response=ResponseEntity.status(HttpStatus.OK).body(sanoDto);
            
        }
        catch(Exception ex){
            sanoDto.setP3("N");
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(list);
        }    
        return response;
    }
}

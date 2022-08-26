/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.controller.publicView;

import com.bananabkend.bananaBkEnd1A.Utility.IdEncryptor;
import com.bananabkend.bananaBkEnd1A.Utility.property.ContentStatus;
import com.bananabkend.bananaBkEnd1A.model.OwnerContent;
import com.bananabkend.bananaBkEnd1A.model.Pricing;
import com.bananabkend.bananaBkEnd1A.model.ProductCart;
import com.bananabkend.bananaBkEnd1A.model.ProductOrderPlaced;
import com.bananabkend.bananaBkEnd1A.model.SecurityApi;
import com.bananabkend.bananaBkEnd1A.model.dto.SecurityApiDto;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer;
import com.bananabkend.bananaBkEnd1A.service.ApiKeyService;
import com.bananabkend.bananaBkEnd1A.service.OwnerContentService;
import com.bananabkend.bananaBkEnd1A.service.PricingService;
import com.bananabkend.bananaBkEnd1A.service.ProductCartService;
import com.bananabkend.bananaBkEnd1A.service.ProductOrderPlacedService;
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
@RequestMapping("/prodInCartOrderPlaced")
public class ProductOrderPlacedController {
    private ApiKeyService apiKeyService; 
    private ProductOrderPlacedService productOrderPlacedService;
    private UserAdViewerService userAdViewerService;
    private OwnerContentService ownerContentService;
    
    private ProductCartService productCartService;
    private PricingService pricingService;
    public ProductOrderPlacedController(ApiKeyService apiKeyService, ProductOrderPlacedService productOrderPlacedService, 
            UserAdViewerService userAdViewerService,ProductCartService productCartService,
            OwnerContentService ownerContentService,PricingService pricingService) {
        
        this.apiKeyService = apiKeyService;
        this.productOrderPlacedService = productOrderPlacedService;
        this.userAdViewerService = userAdViewerService;
        this.productCartService =productCartService;
        this.ownerContentService= ownerContentService;
        this.pricingService =pricingService;
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
    
    
    @RequestMapping(value = "/productOrderPlacedForM/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AnonymousDto> productOrderPlacedForM(@PathVariable String apiUniqueId,@PathVariable String apiKey,
            @RequestBody AnonymousDto anoDto,HttpServletRequest req)     
    {
        ResponseEntity<AnonymousDto> response=null;
        response = productOrderPlacedImpl(apiUniqueId,apiKey,anoDto);
        return response;
    }
    

    //@RequestMapping(value = "/getAllForW/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<ArrayList<AnonymousDto>> getAllActiveCategoryForW(@PathVariable String apiUniqueId,@PathVariable String apiKey,
//            @RequestBody AnonymousDto anoDto,HttpServletRequest req)
    @PostMapping(value = "/productOrderPlacedForW/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<AnonymousDto> productOrderPlacedForW(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult) 
    {
        ResponseEntity<AnonymousDto> response=null;
        response = productOrderPlacedImpl(apiUniqueId,apiKey,anoDto);
        return response;
    }

    private ResponseEntity<AnonymousDto> productOrderPlacedImpl(String apiUniqueId, String apiKey, AnonymousDto anoDto) {
        ResponseEntity<AnonymousDto> response=null;
        
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        OwnerContent productContent=null;
        
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
            userAdViewer.setId(enc.decryptId(anoDto.getP2()));            
            lo = this.userAdViewerService.getUserById(userAdViewer);    //{1st} DB access
            
            if(!lo.isEmpty() && lo.get(0).getId()>0L){
                ownerExist=true;
                securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+"_KcartId_PproductId,");
                //securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
                securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                securityApi=apiKeyService.save(securityApi);    //{2nd} DB access
                
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
            
            ProductCart cart = new ProductCart();
            cart.setId(lo.get(0).getCartId());
            cart = productCartService.getActiveCartInfoFromId(cart);   //{3rd} DB access
            String cartItemsList = cart.getCartItemsList().replaceAll("_\\d\\d,",",");
            
            ProductOrderPlaced productOrder=null;
            for(String id:cartItemsList.substring(1, cartItemsList.length()-1).split(",")){
                productOrder = new ProductOrderPlaced();
                productOrder.setCartId(lo.get(0).getCartId());
                productOrder.setBuyerId(enc.decryptId(anoDto.getP2()));
                productOrder.setOrderStartDate(String.valueOf(System.currentTimeMillis()));

                productOrder.setProductId(Long.parseLong(id));
                productContent=ownerContentService.getOwnerContentById(Long.parseLong(id));  //{4th} DB access
                productOrder.setSellerId(productContent.getOwnerUserId());
                Pricing pricing =pricingService.getPricingInfoFromId(productContent.getPricingId());    //{5th} DB access
                int start = cart.getCartItemsList().indexOf(","+id+"_")+(","+id+"_").length();
                Integer qnty = Integer.parseInt(cart.getCartItemsList().substring(start,start+2))- ContentStatus.ExtraCartProdQuantity;
                
                pricing.setSoldQuantity(pricing.getSoldQuantity()+qnty);
                pricing.setAvailableQuantity(pricing.getAvailableQuantity()-qnty);
                pricingService.save(pricing);       //{6th} DB access
                productOrder.setPrice(pricing.getPrice());
                productOrder.setQuantity(qnty);
                productOrder.setNewAddress(anoDto.getP1());
                productOrder.setUnitDetail(pricing.getUnitDetail());
                productOrder.setContentName(productContent.getContentName());
                productOrder.setOrderPlacedStatus("1");
                this.productOrderPlacedService.save(productOrder);      //{7th} DB access
                
            }
                cart.setStatus("N");
                productCartService.save(cart);         //{8th} DB access
                ProductCart newCart = new ProductCart();
                newCart.setUserId(enc.decryptId(anoDto.getP2()));
                newCart.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                newCart.setStatus("Y");
                newCart.setCartItemsList(",");
                newCart =productCartService.registerNewCart(newCart);          //{10th} DB access 
                lo.get(0).setCartId(newCart.getId());
                this.userAdViewerService.save(lo.get(0));        //{11th} DB access
//                String[] cartItems = anoDto.getP6().split(",");
//                StringBuilder strB=new StringBuilder();
//                strB.append(",");
//
//
//                for (int i = 1; i < cartItems.length; i++) {
//                    strB.append(enc.decryptId(cartItems[i]));
//                    strB.append(",");                
//                }
//                
//            //cart.setCartItemsList(strB.toString());
//            
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
    
    @RequestMapping(value = "/showCustomerHisAllBoughtProductsForM/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ArrayList<AnonymousDto>> showCustomerHisAllBoughtProductsForM(@PathVariable String apiUniqueId,@PathVariable String apiKey,
            @RequestBody AnonymousDto anoDto,HttpServletRequest req)     
    {
        ResponseEntity<ArrayList<AnonymousDto>> response=null;
        response = showCustomerHisAllBoughtProductsImpl(apiUniqueId,apiKey,anoDto);
        return response;
    }
    

    //@RequestMapping(value = "/getAllForW/{apiUniqueId}/{apiKey}",method = RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<ArrayList<AnonymousDto>> getAllActiveCategoryForW(@PathVariable String apiUniqueId,@PathVariable String apiKey,
//            @RequestBody AnonymousDto anoDto,HttpServletRequest req)
    @PostMapping(value = "/showCustomerHisAllBoughtProductsForW/{apiUniqueId}/{apiKey}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<ArrayList<AnonymousDto>> showCustomerHisAllBoughtProductsForW(
            @PathVariable String apiUniqueId,@PathVariable String apiKey,@ModelAttribute AnonymousDto anoDto,
            BindingResult bindingResult) 
    {
        ResponseEntity<ArrayList<AnonymousDto>> response=null;
        response = showCustomerHisAllBoughtProductsImpl(apiUniqueId,apiKey,anoDto);
        return response;
    }

    private ResponseEntity<ArrayList<AnonymousDto>> showCustomerHisAllBoughtProductsImpl(String apiUniqueId, String apiKey, AnonymousDto anoDto) {
        ResponseEntity<ArrayList<AnonymousDto>> response=null;
        
        SecurityApiDto securityApiDto=new SecurityApiDto();
        securityApiDto.setApikey_vb(apiKey);
        //OwnerContent productContent=null;
        ArrayList<AnonymousDto> childSanoList=new ArrayList<AnonymousDto>();
        SecurityApi securityApi = validate30MinApiKey(securityApiDto);
        AnonymousDto sanoDto = new AnonymousDto();
        //ArrayList<AnonymousDto> list =  new ArrayList<AnonymousDto>();
        //list.add(sanoDto);
        if(!securityApi.getValid()){
            sanoDto.setP3("N");
            return response = ResponseEntity.status(HttpStatus.OK)
                  .body(null);             
        }
        
        IdEncryptor enc = new IdEncryptor();
        
        UserAdViewer userAdViewer = new UserAdViewer();
        boolean ownerExist=false;
        List<UserAdViewer> lo =null;
        try{ // check if user is genuine
            userAdViewer.setId(enc.decryptId(anoDto.getP1()));            
            lo = this.userAdViewerService.getUserById(userAdViewer);    //{1st} DB access
            
            if(!lo.isEmpty() && lo.get(0).getId()>0L){
                ownerExist=true;
                securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+"_U"+lo.get(0).getId()+"_KcartId_PproductId,");
                //securityApi.setUriAccessed(securityApi.getUriAccessed()+apiUniqueId+",");
                securityApi.setUpdatedOn(String.valueOf(System.currentTimeMillis()));
                securityApi=apiKeyService.save(securityApi);    //{2nd} DB access
                
            }            
            
        }catch(Exception ex){ex.printStackTrace();}
        finally{
            if(!ownerExist){
                sanoDto.setP3("N");
                
                response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                  .header("Status code", HttpStatus.NOT_FOUND.toString())
                  .header("StatusCode", HttpStatus.NOT_FOUND.toString())
                  .body(null);
                return response;
            }
        }
        try{  
            ArrayList<ProductOrderPlaced> productOrderPlacedList = this.productOrderPlacedService.getAllOrderForBuyer(lo.get(0).getId());
            
            for(ProductOrderPlaced productOrderPlaced :productOrderPlacedList){
                sanoDto = new AnonymousDto();
                sanoDto.setP1(String.valueOf(productOrderPlaced.getId()));
                sanoDto.setP2(productOrderPlaced.getContentName());
                sanoDto.setP3(productOrderPlaced.getUnitDetail());
                sanoDto.setP4(ContentStatus.deliveryStatusName[Integer.parseInt(productOrderPlaced.getOrderPlacedStatus())]);
                sanoDto.setP5(productOrderPlaced.getQuantity());
                childSanoList.add(sanoDto);
            }
            
            response=ResponseEntity.status(HttpStatus.OK).body(childSanoList);            
        }
        catch(Exception ex){
            sanoDto.setP3("N");
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body(null);
        }    
        return response;
    }
}

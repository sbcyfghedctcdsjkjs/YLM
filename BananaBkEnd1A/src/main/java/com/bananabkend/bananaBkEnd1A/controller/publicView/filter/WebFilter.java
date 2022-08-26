/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.controller.publicView.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 *
 * @author sunjiv6
 */
@Component
@Order(3)
public class WebFilter implements Filter{
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse  httpResponse= (HttpServletResponse) response;
        String ngGenerateNewKey = "/6l3AQeyhgQwedGW2vVSSBjkj2H2jmm2mbVhaBsKSLjw2NSazanqqs";
        //String imageUri="/wuiebpd23i2SD3be226kwjbedwedhwe"; 
        String payThruQRCodeUrl = "/qwSStyEWRq223ty5321c8734834bADSasd6SD72vcNgsBq21";
        
        String ngOwnerLoadAllMyAdsUrl   = "/a4qaSDfgVMscaw343jd32d322asdJKA3jd";
        String ngOwnerLoadAdWithIdUrl   = "/jqhs233kjqaSW2Yo1q132323JKJdkk23eb2ed23td3d3";
        String ngOwnerTargetAreaLoadUrl = "/12fF6712f1726fshjLKKL23gsv2dJK62wvs26w2LKL22"; 
        String ngOwnerTargetAreaSaveUrl = "/jkfw983H872gw6jhwd152esd62gqjs532gh32zl4v23z04g2h";  
        String ngOwnerScreenModifyUrl   = "/12iuhQidsdwdt823DAjckaq32a4slkadn2JKAsygxvbjajdgyuy";
        String ngOwnerScreenUploadUrl   = "/s2V3dGwdJwKQ23yKbd25KH612vkmSWwscx562ldw23suAJWQUI";
        String ngWebValidatePhone = "/kK324h34gv6upopsbc2378av278sad738bvqv67svkerntpt";
        String ngWebValidateEmail = "/ncsiow22uiANSX2klsaLAKskj2KSJd546kt1j21k";
        String ngWebRegisterNewUser = "/bjh234b2d2CSjk2kj24KnH546hjL87lasnAKJ";
        String ngSearchAndLoadAds = "/w342sawSAWVDSSAQrfhb23784gDERQefr324VbA";
        
        String validateOperatorByPhoneUri_vb = "/5tdwe24wepsbc2378av278sad738bvqv67sv23ewdpt"; 
        
        String validateOperatorByEmailUri_vb = "/tt324wss34SX2klsaLAKskj2KSJd54cs34321k"; 
        //String registerNewOperatorUri_vb = "/zdsvh2sdcsdxre3j24KnH546hjL8uk8iasnAKJ"; 
        String getRowsCount_vb = "/bsadfwj3535h56rftht6uighg2sdcsdxre3ji23wcsffuaw8";
        String saveLikedItemIdsUri_vb = "/ldwbpdsdsj81267gds2qwu672lkopwmw";
        
        String loadLikedItemIdsUri_vb = "/wqed278gvb2378d3762lkpoumkn51op1m"; 
        String taMoney_login_vb = "/weiugf734ugyf66Q3GC83wbC98B76V2bvavduyg";
        String taMoney_save_trans_vb = "/xAsScvSzx89bfw546323jdsDSFGvlpmaWEw06Tpwfe";
        String ngAskToReset = "/kQlsERdcRT03nawBBowp12p31012k3IO4HJM2VC";
        
        String ngChangePassword = "/sdre3SJKFW43WQ83UJsdfNKreJAJMer2VhiolC";
        String ngApiTracker = "/kmJHjsAWHBJWD672Bkj83nka348632678dsacKRmAqlweCio43nSDA4wcDF67wiAuq";
        String ngCreateCategory = "/sSD2F34b43237bd3y2362VDSWDhjemE45wedfwe83f";
        
        String ngGetAllCategory = "/aWEsTRHvTYd213YUJen23dRT3nRTruRT48bfTR56gT45nTHiTYgJ8Uw3wifq283f";
        String ngLogout = "/sTRHvTYUJeqwn23vbdRT3nRTTYgJ8Uw3wifq28esdo3iutdf";
        String ngUserInfo = "/vb2378dYUJeq5dfDwnvGFbEdRTGH3nGHW2JHv8Uw3wfqtdfrtr";
        String ngChangeLang = "/AmAa2sdssaEWKIU52dfDwnvfdsFbEdRTGHwssdg53487034Uw3";
        String ngLoadLangProperties = "/RsfaS43FG456GAEW3276567JYfgh678RTYRE76e457jhgdse454Ew3";
        
        String resetSecretNumForOthersByAdmin = "/hqgwe2fgffhisoijf238HGFYS2yuf2gHIUg12yJJh237h";
        String likedAds_in_pages_uri = "/ujwvex23wytiqweqwo23sdf42sdf34er67vwe6723vge2ved2yuve";
        
        String getTopNRowsFromSecurity = "/ShhWQvg4TCfedwwvgdc6723v2365dv56CJ6qycv67Qvvw2vyq762VVCSJ";
        String addProductToCart = "/ewhfYQW827WEH2y2u38bwes287rjhs7826v34hcDSFdq5DFG6eHFDwd";
        String productOrderPlaced = "/djuyc623278GVSUY8723HJJHUIWE8234862487267g3djs67wfcvvjhs";
        String listProdFromCart = "/whbe6723ve672dc1287e2vdv2378vd67V3DWvvvw78vwe7Vvuv";
        String ngUploadNewProductUrl = "/kHQ62167hasdv6523023rejkb2dbVGCra4khsbdc2362hg48jb";
        String ngUploadModifyProductUrl = "/jgori637v2jhj37vdbVGCra4khsbdc2362hsywevwcs";
        
        String ngOwnerListProductUrl = "/ud2yvuvqwd8921tGCSTYT63272cty672TUYWE2hjdv634d";
        
        String ngOwnerLoadProductWithIdUrl = "/W825WEH2y2u38bwes287rjhs7822ctsdv6523023rejkb2dbVGC";
        String ngOwnerMarketLoadUrl= "/8Uw3wifq28esd23rejkb2dbVGCctsdv652307e2vdv23";
        String ngOwnerMarketSaveUrl= "/728esd23rejkb2dbVGC822ctsdv6523W825WEH2y2u38bwes2";
        String ngOwnerCustomerOrderListUrl= "/7d2yvuvqwd8921t22ctsdHUIWE823486edwwvgdc67Cra4khsbdc223v";
        String ngProductOrderPlacedUrl= "/uvqwd8921t2E823486edwwvgdc67Cra4khsbdc223v2ctsdHUIW";
        String ngDeliveryStatusChangedUrl= "/aw343jd32d322asdJ3nUJen23dRT3nRTR56gT45nTHiTYgJ8Uw3wifq283f";
        
        
        String ngListAllOrderForCustomerUrl= "/iebpd23i2SD3b6edwwv2y2u38bwes287223vDWvvvw78v223vDWvvvw78vIW";
        String ngSearchAndLoadProducts = "bpd23i2S486edwwvgdcDsd23rejkb2dbVGC3486edwwvgdc6cwd8921t22ctsdHUIWE823";
        if (httpRequest.getRequestURL().toString().indexOf(ngGenerateNewKey)>0){
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/apikey/ngwebGenerateNewKey/51");
            rd.forward(request, response);        }

        if (httpRequest.getRequestURL().toString().indexOf(ngOwnerLoadAllMyAdsUrl)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/owner/myList01/52"+httpRequest.getRequestURL().toString().split(ngOwnerLoadAllMyAdsUrl)[1]);
            rd.forward(request, response);
        }

        
        if (httpRequest.getRequestURL().toString().indexOf(ngOwnerLoadAdWithIdUrl)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/owner/one/ad/info/53"+httpRequest.getRequestURL().toString().split(ngOwnerLoadAdWithIdUrl)[1]);
        
            rd.forward(request, response);
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(ngOwnerTargetAreaLoadUrl)>0){// Web Use
         
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/receiveAd/owner/loadTargetArea2/55"+httpRequest.getRequestURL().toString().split(ngOwnerTargetAreaLoadUrl)[1]);
            rd.forward(request, response);        
        }

        if (httpRequest.getRequestURL().toString().indexOf(ngOwnerTargetAreaSaveUrl)>0){// Web Use
         
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/receiveAd/owner/saveTargetArea2/56"+httpRequest.getRequestURL().toString().split(ngOwnerTargetAreaSaveUrl)[1]);
            rd.forward(request, response);        
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(ngOwnerScreenModifyUrl)>0){// Web Use
         
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/receiveAd/owner/modify/ad2/57"+httpRequest.getRequestURL().toString().split(ngOwnerScreenModifyUrl)[1]);
            rd.forward(request, response);        
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(ngOwnerScreenUploadUrl)>0){// Web Use
         
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/receiveAd/owner/uploadAd2/58"+httpRequest.getRequestURL().toString().split(ngOwnerScreenUploadUrl)[1]);
            rd.forward(request, response);        
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(ngWebValidatePhone)>0){// Web Use // This will not work from CMD/terminal
         
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/webLogin/validateUserPhoneMltiPart/60"+httpRequest.getRequestURL().toString().split(ngWebValidatePhone)[1]);
            rd.forward(request, response);        
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(ngWebValidateEmail)>0){// Web Use
         
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/webLogin/validateUserEmailMltiPart/61"+httpRequest.getRequestURL().toString().split(ngWebValidateEmail)[1]);
            rd.forward(request, response);        
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(ngWebRegisterNewUser)>0){// Web Use
         
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/webLogin/registerNewUser/62"+httpRequest.getRequestURL().toString().split(ngWebRegisterNewUser)[1]);
            rd.forward(request, response);        
        }
        if (httpRequest.getRequestURL().toString().indexOf(ngSearchAndLoadAds)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/owner/myList2/64"+httpRequest.getRequestURL().toString().split(ngSearchAndLoadAds)[1]);
            rd.forward(request, response);
        }
        
        
        if (httpRequest.getRequestURL().toString().indexOf(validateOperatorByPhoneUri_vb)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/opsLogin/validateUserPhone/65"+httpRequest.getRequestURL().toString().split(validateOperatorByPhoneUri_vb)[1]);
            rd.forward(request, response);
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(validateOperatorByEmailUri_vb)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/opsLogin/validateUserEmail/66"+httpRequest.getRequestURL().toString().split(validateOperatorByEmailUri_vb)[1]);
            rd.forward(request, response);
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(getRowsCount_vb)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/opsApi/getRowsCount/68"+httpRequest.getRequestURL().toString().split(getRowsCount_vb)[1]);
            rd.forward(request, response);
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(saveLikedItemIdsUri_vb)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/webLikedIt/saveAdsLiked/75"+httpRequest.getRequestURL().toString().split(saveLikedItemIdsUri_vb)[1]);
            rd.forward(request, response);
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(loadLikedItemIdsUri_vb)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/webLikedIt/loadLikedAds/76"+httpRequest.getRequestURL().toString().split(loadLikedItemIdsUri_vb)[1]);
            rd.forward(request, response);
        }
                
        if (httpRequest.getRequestURL().toString().indexOf(taMoney_login_vb)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/transactionMoney/validateUserEmail/77"+httpRequest.getRequestURL().toString().split(taMoney_login_vb)[1]);
            rd.forward(request, response);
        }
                
        if (httpRequest.getRequestURL().toString().indexOf(taMoney_save_trans_vb)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/transactionMoney/save/78"+httpRequest.getRequestURL().toString().split(taMoney_save_trans_vb)[1]);
            rd.forward(request, response);
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(ngAskToReset)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/secretNumber/askToReset/80"+httpRequest.getRequestURL().toString().split(ngAskToReset)[1]);
            rd.forward(request, response);
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(ngChangePassword)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/secretNumber/reset/82"+httpRequest.getRequestURL().toString().split(ngChangePassword)[1]);
            rd.forward(request, response);
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(ngApiTracker)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/apiTracker/recordStep/83"+httpRequest.getRequestURL().toString().split(ngApiTracker)[1]);
            rd.forward(request, response);
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(ngGetAllCategory)>0){// Web Use
            
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/category/getAllForW/84"+httpRequest.getRequestURL().toString().split(ngGetAllCategory)[1]);
            rd.forward(request, response);
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(ngCreateCategory)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/category/create/85"+httpRequest.getRequestURL().toString().split(ngCreateCategory)[1]);
            rd.forward(request, response);
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(ngLogout)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/userAuth/logout/86"+httpRequest.getRequestURL().toString().split(ngLogout)[1]);
            rd.forward(request, response);
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(ngUserInfo)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/userAuth/userInfo/88"+httpRequest.getRequestURL().toString().split(ngUserInfo)[1]);
            rd.forward(request, response);
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(ngChangeLang)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/userAuth/changeLang/100"+httpRequest.getRequestURL().toString().split(ngChangeLang)[1]);
            rd.forward(request, response);
        }

        if (httpRequest.getRequestURL().toString().indexOf(ngLoadLangProperties)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/loadProperties/webViewer/101"+httpRequest.getRequestURL().toString().split(ngLoadLangProperties)[1]);
            rd.forward(request, response);
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(resetSecretNumForOthersByAdmin)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/secretNumber/resetOthersByAdmin/102"+httpRequest.getRequestURL().toString().split(resetSecretNumForOthersByAdmin)[1]);
            rd.forward(request, response);
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(likedAds_in_pages_uri)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/owner/likedAdsListInPagesByCategory/103"+httpRequest.getRequestURL().toString().split(likedAds_in_pages_uri)[1]);
            rd.forward(request, response); 
        
        }
        if (httpRequest.getRequestURL().toString().indexOf(payThruQRCodeUrl)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/transactionMoney/payThruQR/104"+httpRequest.getRequestURL().toString().split(payThruQRCodeUrl)[1]);
        
            rd.forward(request, response); 
        }
        if (httpRequest.getRequestURL().toString().indexOf(getTopNRowsFromSecurity)>0){// Web Use
            
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/opsApi/getTopNRows/105"+httpRequest.getRequestURL().toString().split(getTopNRowsFromSecurity)[1]);
            rd.forward(request, response); 
        }
        if (httpRequest.getRequestURL().toString().indexOf(addProductToCart)>0){// Web Use
            
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/prodCart/addToCartForW/106"+httpRequest.getRequestURL().toString().split(addProductToCart)[1]);
            rd.forward(request, response); 
        }
        if (httpRequest.getRequestURL().toString().indexOf(productOrderPlaced)>0){// Web Use
            
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/prodCartOrderPlaced/productOrderPlacedForW/107"+httpRequest.getRequestURL().toString().split(productOrderPlaced)[1]);
            rd.forward(request, response); 
        }
        if (httpRequest.getRequestURL().toString().indexOf(listProdFromCart)>0){// Web Use
            
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/prodCart/listCartItemsForW/110"+httpRequest.getRequestURL().toString().split(listProdFromCart)[1]);
            rd.forward(request, response); 
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(ngUploadNewProductUrl)>0){// Web Use         
        
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/receiveProduct/owner/uploadAd2/111"+httpRequest.getRequestURL().toString().split(ngUploadNewProductUrl)[1]);
            rd.forward(request, response);        
        }
        if (httpRequest.getRequestURL().toString().indexOf(ngUploadModifyProductUrl)>0){// Web Use
         
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/receiveProduct/owner/modify/ad2/112"+httpRequest.getRequestURL().toString().split(ngUploadModifyProductUrl)[1]);
            rd.forward(request, response);        
        }
        if (httpRequest.getRequestURL().toString().indexOf(ngOwnerListProductUrl)>0){// Web Use
         
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/ownerListProduct/myList01/113"+httpRequest.getRequestURL().toString().split(ngOwnerListProductUrl)[1]);
            rd.forward(request, response);        
        }
        
        
        if (httpRequest.getRequestURL().toString().indexOf(ngOwnerLoadProductWithIdUrl)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/ownerListProduct/one/ad/info/114"+httpRequest.getRequestURL().toString().split(ngOwnerLoadProductWithIdUrl)[1]);
        
            rd.forward(request, response);
        }
        if (httpRequest.getRequestURL().toString().indexOf(ngOwnerMarketLoadUrl)>0){// Web Use
         
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/receiveProduct/owner/loadTargetArea2/55"+httpRequest.getRequestURL().toString().split(ngOwnerMarketLoadUrl)[1]);
            rd.forward(request, response);        
        }

        
        if (httpRequest.getRequestURL().toString().indexOf(ngOwnerMarketSaveUrl)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/receiveProduct/owner/saveTargetArea2/116"+httpRequest.getRequestURL().toString().split(ngOwnerMarketSaveUrl)[1]);
            rd.forward(request, response);        
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(ngOwnerCustomerOrderListUrl)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/customerOrderListProduct/myList01/118"+httpRequest.getRequestURL().toString().split(ngOwnerCustomerOrderListUrl)[1]);
            rd.forward(request, response);        
        }        
        if (httpRequest.getRequestURL().toString().indexOf(ngProductOrderPlacedUrl)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/prodInCartOrderPlaced/productOrderPlacedForW/120"+httpRequest.getRequestURL().toString().split(ngProductOrderPlacedUrl)[1]);
            rd.forward(request, response);        
        }
        if (httpRequest.getRequestURL().toString().indexOf(ngDeliveryStatusChangedUrl)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/customerOrderListProduct/changeDeliveryStatus/121"+httpRequest.getRequestURL().toString().split(ngDeliveryStatusChangedUrl)[1]);
            rd.forward(request, response);        
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(ngListAllOrderForCustomerUrl)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/prodInCartOrderPlaced/showCustomerHisAllBoughtProductsForW/122"+httpRequest.getRequestURL().toString().split(ngListAllOrderForCustomerUrl)[1]);
            rd.forward(request, response);        
        }
        if (httpRequest.getRequestURL().toString().indexOf(ngSearchAndLoadProducts)>0){// Web Use
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/ownerListProduct/myList2/64"+httpRequest.getRequestURL().toString().split(ngSearchAndLoadProducts)[1]);
            rd.forward(request, response);
        }
        
//       getTopNRowsFromSecurity
//        if (httpRequest.getRequestURL().toString().indexOf(imageUri) > 0){// Use in Mobile , Web USe
//            RequestDispatcher rd = httpRequest.getRequestDispatcher("/imageshow/image/show/10"
//                    +httpRequest.getRequestURL().toString().split(imageUri)[1]);
//            rd.forward(request, response);
//        }
//            
    }
}

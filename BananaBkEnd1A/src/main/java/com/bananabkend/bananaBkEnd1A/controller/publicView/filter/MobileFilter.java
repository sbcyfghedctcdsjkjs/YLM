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
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 *
 * @author sunjiv6
 */
@Component
@Order(2)
public class MobileFilter implements Filter{
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        String mobileGenerateNewKey = "/sJWk4jFd23cskhw6iqu1d8Q2wetgFuy343qwSd71rt23feq671";
        String imageUri="/wuiebpd23i2SD3be226kwjbedwedhwe";
        String imageIconUri="/K2312536132fc2eqwd7845lkgdkvdf0skl";
        String ads_in_pages_uri = "/wqedw2FRT3dndi33io4jirU3jr3ojw621223nn";
        String adViewerLikedIt_save_uri = "/231guRbjhbdbcsncklnsioe83jY4dbsak";
        String user_validatebyPhone_uri = "/3467d6712FGgjsdad78d1gwqFGHdas87FG1j2HJsvFGvasxk";
        String user_validatebyEmail_uri = "/swchbqw623vvjha6712vvaj67x21kfFls2te";
        String registerNewUserUri = "/qJKSWQ23wpoejfd45kgde02ds213NsdDfrg4D";
        String getAllCategory = "/aMEsTRHvTYd213YUJen23dRT3nRTruRT48bfTR56gT45nTHiTYgJ8Uw3wifq283f";
        String ownerGetHisOwnAds = "/Bkjedkfjsoiwenbs232DF4ishd62FDH45652uvds5SD62Klvdas56ytcETGd";
        if (httpRequest.getRequestURL().toString().indexOf(imageUri) > 0){// Use in Mobile , Web USe
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/imageshow/image/show/10"
                    +httpRequest.getRequestURL().toString().split(imageUri)[1]);
            rd.forward(request, response);
        }
        
        if (httpRequest.getRequestURL().toString().indexOf(imageIconUri) > 0){// Use in Mobile , Web USe
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/imageshow/image/icon/20"
                    +httpRequest.getRequestURL().toString().split(imageIconUri)[1]);
            rd.forward(request, response);
        }

        if (httpRequest.getRequestURL().toString().indexOf(mobileGenerateNewKey)>0){// Use in Mobile 
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/apikey/mobileGenerateNewKey/1");
            rd.forward(request, response);
        }        

        if (httpRequest.getRequestURL().toString().indexOf(ads_in_pages_uri) > 0){// Use in Mobile 
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/retrieve/adsListInPagesByCategory/12"+httpRequest.getRequestURL().toString().split(ads_in_pages_uri)[1]);
            rd.forward(request, response); }
  

        if (httpRequest.getRequestURL().toString().indexOf(adViewerLikedIt_save_uri)>0){// Use in Mobile 
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/adViewerLikedIt/saveAdsLiked/13"+httpRequest.getRequestURL().toString().split(adViewerLikedIt_save_uri)[1]);
            rd.forward(request, response);
        }
        if (httpRequest.getRequestURL().toString().indexOf(user_validatebyEmail_uri)>0){// Use in Mobile 
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/adViewer/validateUserEmail/14"+httpRequest.getRequestURL().toString().split(user_validatebyEmail_uri)[1]);
            rd.forward(request, response);      }
        
        if (httpRequest.getRequestURL().toString().indexOf(user_validatebyPhone_uri)>0){// Use in Mobile 
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/adViewer/validateUserPhone/15"+httpRequest.getRequestURL().toString().split(user_validatebyPhone_uri)[1]);
            rd.forward(request, response);
        }                
        
        if (httpRequest.getRequestURL().toString().indexOf(registerNewUserUri)>0){// Use in Mobile 
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/adViewer/registerNewUser/16"+httpRequest.getRequestURL().toString().split(registerNewUserUri)[1]);

            rd.forward(request, response);        }
        
        if (httpRequest.getRequestURL().toString().indexOf(getAllCategory)>0){// Web Use            
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/category/getAllForM/17"+httpRequest.getRequestURL().toString().split(getAllCategory)[1]);
            rd.forward(request, response);
        }
        if (httpRequest.getRequestURL().toString().indexOf(ownerGetHisOwnAds)>0){// Web Use            
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/owner/ownerSeeHisOwnAdsByOwnerId/20"+httpRequest.getRequestURL().toString().split(ownerGetHisOwnAds)[1]);
            rd.forward(request, response);
        }
        chain.doFilter(request, response);   
    }
}

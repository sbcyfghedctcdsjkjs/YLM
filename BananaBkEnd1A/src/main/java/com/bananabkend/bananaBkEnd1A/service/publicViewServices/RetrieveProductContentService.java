/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service.publicViewServices;

import com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent;
import com.bananabkend.bananaBkEnd1A.model.UserOwner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sunjiv6
 */
public interface RetrieveProductContentService {
    
    
    public ArrayList<RetrieveAdsContent> getAllActiveContentForOwnerUser(UserOwner userOwner) throws Exception;
    
    public RetrieveAdsContent getOwnerContentById(Long contentId) throws Exception;
    
    public RetrieveAdsContent getOwnerContentByIdForForm(Long contentId) throws Exception; 
    
    public List<RetrieveAdsContent> getProductsInPages(int pageNumber,int pageSize,String address,String adType,String prodOrBznzType) throws Exception;
    
    public List<RetrieveAdsContent> getProductsInPagesByCategory(int pageNumber,int pageSize,String address,String adType,String selectedCategory,String prodOrBznzType) throws Exception;
    //public Long recordsCountMoreThan(int count, String address) throws Exception;
    public List<RetrieveAdsContent> getContentForMultipleIds(String commaSeparatedIds) throws Exception;
}

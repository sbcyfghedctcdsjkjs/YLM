/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service.publicViewServices;

import com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent;
import com.bananabkend.bananaBkEnd1A.model.UserOwner;
import com.bananabkend.bananaBkEnd1A.repository.publicViewRepo.RetrieveAdsContentRepo;
import com.bananabkend.bananaBkEnd1A.repository.publicViewRepo.RetrieveAdsInPagesByCategoryRepo;
import com.bananabkend.bananaBkEnd1A.repository.publicViewRepo.RetrieveAdsInPagesRepo;
import com.bananabkend.bananaBkEnd1A.repository.publicViewRepo.RetrieveProdInCartRepo;
import com.bananabkend.bananaBkEnd1A.repository.publicViewRepo.RetrieveProductsInPagesByCategoryRepo;
import com.bananabkend.bananaBkEnd1A.repository.publicViewRepo.RetrieveProductsInPagesRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sunjiv6
 */
@Service
@Transactional
public class RetrieveProductContentServiceImpl implements RetrieveProductContentService{
    
    private RetrieveAdsContentRepo retrieveAdsContentRepo;
    private RetrieveProductsInPagesRepo retrieveProductsInPagesRepo;
    private RetrieveProductsInPagesByCategoryRepo retrieveProductsInPagesByCategoryRepo;
    private RetrieveProdInCartRepo retrieveProdInCartRepo;

    public RetrieveProductContentServiceImpl(RetrieveAdsContentRepo retrieveAdsContentRepo,
            RetrieveProductsInPagesRepo retrieveProductsInPagesRepo,
            RetrieveProductsInPagesByCategoryRepo retrieveProductsInPagesByCategoryRepo,RetrieveProdInCartRepo retrieveProdInCartRepo) {
        this.retrieveAdsContentRepo = retrieveAdsContentRepo;
        this.retrieveProductsInPagesRepo=retrieveProductsInPagesRepo;
        this.retrieveProductsInPagesByCategoryRepo=retrieveProductsInPagesByCategoryRepo;
        this.retrieveProdInCartRepo = retrieveProdInCartRepo;
    }
    
    @Override
    public ArrayList<RetrieveAdsContent> getAllActiveContentForOwnerUser(UserOwner userOwner) throws Exception {
        return this.retrieveAdsContentRepo.getAllActiveContentForOwnerUser(userOwner.getId());
    }

    @Override
    public RetrieveAdsContent getOwnerContentById(Long contentId) throws Exception {
        return this.retrieveAdsContentRepo.getOneOwnerContentById(contentId);
    }

    @Override
    public RetrieveAdsContent getOwnerContentByIdForForm(Long contentId) throws Exception {
        return this.retrieveAdsContentRepo.getOneOwnerContentByIdForForm(contentId);
    }
    
    @Override
    public List<RetrieveAdsContent> getProductsInPages(int pageNumber,int pageSize,String address,String adType,String prodOrBznzType) throws Exception {   
        return this.retrieveProductsInPagesRepo.getProductsInPages(pageNumber,pageSize, address, adType ,prodOrBznzType);
    }

    public List<RetrieveAdsContent> getProductsInPagesByCategory(int pageNumber,int pageSize,String address,String adType,String selectedCategory,String prodOrBznzType) {
        
            return this.retrieveProductsInPagesByCategoryRepo.getProductsInPagesByCategory(pageNumber,pageSize, address, adType,selectedCategory,prodOrBznzType);
    }    
    @Override
    public List<RetrieveAdsContent> getContentForMultipleIds(String commaSeparatedIds) throws Exception {
        return this.retrieveProdInCartRepo.getContentForMultipleIds(commaSeparatedIds);
    }
    
}
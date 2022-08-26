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
public class RetrieveAdsContentServiceImpl implements RetrieveAdsContentService{
    
    private RetrieveAdsContentRepo retrieveAdsContentRepo;
    private RetrieveAdsInPagesRepo retrieveAdsInPagesRepo;
    private RetrieveAdsInPagesByCategoryRepo retrieveAdsInPagesByCategoryRepo;
    private RetrieveProdInCartRepo retrieveProdInCartRepo;

    public RetrieveAdsContentServiceImpl(RetrieveAdsContentRepo retrieveAdsContentRepo,
            RetrieveAdsInPagesRepo retrieveAdsInPagesRepo,
            RetrieveAdsInPagesByCategoryRepo retrieveAdsInPagesByCategoryRepo,RetrieveProdInCartRepo retrieveProdInCartRepo) {
        this.retrieveAdsContentRepo = retrieveAdsContentRepo;
        this.retrieveAdsInPagesRepo=retrieveAdsInPagesRepo;
        this.retrieveAdsInPagesByCategoryRepo=retrieveAdsInPagesByCategoryRepo;
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
    public List<RetrieveAdsContent> getAdsInPages(int pageNumber,int pageSize,String address,String adType,String prodOrBznzType) throws Exception {   
        return this.retrieveAdsInPagesRepo.getAdsInPages(pageNumber,pageSize, address, adType ,prodOrBznzType);
    }

    public List<RetrieveAdsContent> getAdsInPagesByCategory(int pageNumber,int pageSize,String address,String adType,String selectedCategory,String prodOrBznzType) {
        
            return this.retrieveAdsInPagesByCategoryRepo.getAdsInPagesByCategory(pageNumber,pageSize, address, adType,selectedCategory,prodOrBznzType);
    }    
    @Override
    public List<RetrieveAdsContent> getContentForMultipleIds(String commaSeparatedIds) throws Exception {
        return this.retrieveProdInCartRepo.getContentForMultipleIds(commaSeparatedIds);
    }
    
}
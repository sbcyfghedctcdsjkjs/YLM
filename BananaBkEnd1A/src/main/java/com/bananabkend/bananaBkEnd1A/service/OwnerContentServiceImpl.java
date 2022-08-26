/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;

import com.bananabkend.bananaBkEnd1A.model.OwnerContent;
import com.bananabkend.bananaBkEnd1A.model.UserOwner;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer;
import com.bananabkend.bananaBkEnd1A.repository.OwnerContentRepo;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sunjiv6
 */
@Service
@Transactional
public class OwnerContentServiceImpl implements OwnerContentService{
    
    private OwnerContentRepo ownerContentRepo;

    public OwnerContentServiceImpl(OwnerContentRepo ownerContentRepo) {
        this.ownerContentRepo = ownerContentRepo;
    }    
    
    @Override
    public OwnerContent createNewContentAd(OwnerContent ownerContent) throws Exception {
        return this.ownerContentRepo.save(ownerContent);
    } 
    
    @Override
    public OwnerContent modifyAd(OwnerContent ownerContent) throws Exception {
        return this.ownerContentRepo.save(ownerContent);
    }
    
    @Override
    public ArrayList<com.bananabkend.bananaBkEnd1A.model.OwnerContent> getAllActiveContentForOwnerUser(UserOwner userOwner, 
            String contentType) throws Exception {
        return this.ownerContentRepo.getAllActiveContentForOwnerUser(userOwner.getId(),contentType);
    }
    
    @Override
    public ArrayList<com.bananabkend.bananaBkEnd1A.model.OwnerContent> getAllActiveContentForOwnerUser(UserAdViewer userAdViewer, 
            String contentType) throws Exception {
        return this.ownerContentRepo.getAllActiveContentForOwnerUser(userAdViewer.getId(),contentType);
    }

    @Override
    public com.bananabkend.bananaBkEnd1A.model.OwnerContent getOwnerContentById(Long contentId) throws Exception {
        return this.ownerContentRepo.getOneOwnerContentById(contentId);
    }

    @Override
    public OwnerContent getOwnerContentByIdForForm(Long contentId) throws Exception {
        return this.ownerContentRepo.getOneOwnerContentByIdForForm(contentId);
    }
    
    public Long getOwnerContentRowsCount() throws Exception{
        return this.ownerContentRepo.getOwnerContentRowsCount();
    }
}
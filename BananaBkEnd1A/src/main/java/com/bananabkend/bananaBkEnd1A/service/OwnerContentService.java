/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;

import com.bananabkend.bananaBkEnd1A.model.OwnerContent;
import com.bananabkend.bananaBkEnd1A.model.UserOwner;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer;
import java.util.ArrayList;

/**
 *
 * @author sunjiv6
 */
public interface OwnerContentService {
    
    OwnerContent createNewContentAd(OwnerContent ownerContent) throws Exception;
    
    OwnerContent modifyAd(OwnerContent ownerContent) throws Exception;
    
    public ArrayList<com.bananabkend.bananaBkEnd1A.model.OwnerContent> getAllActiveContentForOwnerUser(UserOwner userOwner,
            String contentType) throws Exception;
    
    public ArrayList<com.bananabkend.bananaBkEnd1A.model.OwnerContent> getAllActiveContentForOwnerUser(UserAdViewer userAdViewer,
            String contentType) throws Exception;
    
    
    public com.bananabkend.bananaBkEnd1A.model.OwnerContent getOwnerContentById(Long contentId) throws Exception;
    
    public com.bananabkend.bananaBkEnd1A.model.OwnerContent getOwnerContentByIdForForm(Long contentId) throws Exception; 
    
    public Long getOwnerContentRowsCount() throws Exception;
}

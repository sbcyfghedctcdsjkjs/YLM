/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.repository.publicViewRepo;

import com.bananabkend.bananaBkEnd1A.model.OwnerContent;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author sunjiv6
 */
public interface RetrieveAdsContentRepo extends CrudRepository<OwnerContent, Long> {

    @Query("select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent("
            + "t.id,t.ownerUserId,t.uploadedFileName,t.generatedFileName,t.contentDesc,t.adType,t.createdOn,t.status,t.adDisplayType,"
            + "t.activeDate) "
            + "from OwnerContent t ")    
    public ArrayList<com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent> getAllActiveContentForOwnerUser(Long ownerUserId);

    @Query("select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent("
            + "t.id,t.ownerUserId,t.uploadedFileName,t.generatedFileName,t.contentDesc,t.adType,t.createdOn,t.status,t.adDisplayType,"
            + "t.activeDate) "
            + "from OwnerContent t where t.id=?1") 
    public com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent getOneOwnerContentById(Long contentId);
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent("
            + "t.id,t.ownerUserId,t.uploadedFileName,t.generatedFileName,t.contentDesc,t.adType,t.createdOn,t.status,t.adDisplayType,"
            + "t.activeDate) "
            + "from OwnerContent t where t.id=?1") 
    public com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent getOneOwnerContentByIdForForm(Long contentId);
    
    //public Long recordsCountMoreThan(int count, String address);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.repository;

import com.bananabkend.bananaBkEnd1A.model.OwnerContent;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author sunjiv6
 */
public interface OwnerContentRepo extends CrudRepository<OwnerContent, Long> {

    @Query("select new com.bananabkend.bananaBkEnd1A.model.OwnerContent("
            + "t.id,t.ownerUserId,t.uploadedFileName,t.generatedFileName,t.contentDesc,t.adType,t.createdOn,t.status,t.adDisplayType,"
            + "t.activeDate,t.category,t.pricingId,t.contentName,t.contentType) "
            + "from OwnerContent t where t.ownerUserId=?1 and t.contentType=?2 order by t.id desc")    
    public ArrayList<com.bananabkend.bananaBkEnd1A.model.OwnerContent> getAllActiveContentForOwnerUser(Long ownerUserId,String contentType);

    @Query("select new com.bananabkend.bananaBkEnd1A.model.OwnerContent("
            + "t.id,t.ownerUserId,t.uploadedFileName,t.generatedFileName,t.contentDesc,t.adType,t.createdOn,t.status,t.adDisplayType,"
            + "t.activeDate,t.category,t.pricingId,t.contentName,t.contentType) "
            + "from OwnerContent t where t.id=?1") 
    public com.bananabkend.bananaBkEnd1A.model.OwnerContent getOneOwnerContentById(Long contentId);
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.OwnerContent("
            + "t.id,t.ownerUserId,t.uploadedFileName,t.generatedFileName,t.contentDesc,t.adType,t.createdOn,t.status,t.adDisplayType,"
            + "t.activeDate,t.category,t.pricingId,t.contentName,t.contentType) "
            + "from OwnerContent t where t.id=?1") 
    public com.bananabkend.bananaBkEnd1A.model.OwnerContent getOneOwnerContentByIdForForm(Long contentId);
    
    @Query("select "
            + " count(*)  "
            + "from OwnerContent t") 
    public Long getOwnerContentRowsCount();
    
}

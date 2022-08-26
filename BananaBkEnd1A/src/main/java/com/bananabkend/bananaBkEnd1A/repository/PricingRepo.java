/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.repository;

import com.bananabkend.bananaBkEnd1A.model.Pricing;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author bunsiv
 */
public interface PricingRepo extends CrudRepository<Pricing, Object>{
   
    @Query("select new com.bananabkend.bananaBkEnd1A.model.Pricing("
            + " p.id, p.ownerContentId, p.price,  p.unitDetail, p.availableQuantity,"
            + " p.taxPercent,p.taxDetail, p.soldQuantity,p.status)"
            + " from Pricing p where p.id=?1")  
    public Pricing getPricingInfoFromId(Long id);    
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.Pricing("
            + " p.id, p.ownerContentId, p.price,  p.unitDetail, p.availableQuantity,"
            + " p.taxPercent,p.taxDetail, p.soldQuantity,p.status)"
            + " from Pricing p where p.status='Y'and p.ownerContentId= ?1")  
    public Pricing getAcivePricingInfoForProductId(Long id); 
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.Pricing("
            + " p.id, p.ownerContentId, p.price,  p.unitDetail, p.availableQuantity,"
            + " p.taxPercent,p.taxDetail, p.soldQuantity,p.status)"
            + " from Pricing p where p.ownerContentId= ?1 order by p.id desc")  
    public ArrayList<Pricing> getAllPricingInfoForProductId(Long id); 

}
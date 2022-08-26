/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.repository;

import com.bananabkend.bananaBkEnd1A.model.ProductOrderPlaced;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author bunsiv
 */


public interface ProductOrderPlacedRepo extends CrudRepository<ProductOrderPlaced, Object>{
    @Query("select new com.bananabkend.bananaBkEnd1A.model.ProductOrderPlaced( "
       +  " p.id,  p.buyerId,  p.cartId,  p.productId,  p.sellerId, " 
       +  " p.newAddressStatus,  p.newAddress,  p.orderStartDate,  p.orderPlacedStatus, " 
       +  " p.orderPlacedDate,  p.price,  p.quantity,  p.discountOffer ,p.unitDetail,p.contentName)"
       +  " from ProductOrderPlaced p where p.sellerId=?1 order by p.orderStartDate desc ")  
    public ArrayList<ProductOrderPlaced> getAllOrderForSeller(Long id);  
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.ProductOrderPlaced( "
       +  " p.id,  p.buyerId,  p.cartId,  p.productId,  p.sellerId, " 
       +  " p.newAddressStatus,  p.newAddress,  p.orderStartDate,  p.orderPlacedStatus, " 
       +  " p.orderPlacedDate,  p.price,  p.quantity,  p.discountOffer ,p.unitDetail,p.contentName )"
       +  " from ProductOrderPlaced p where p.buyerId=?1 order by p.orderStartDate desc ")  
    public ArrayList<ProductOrderPlaced> getAllOrderForBuyer(Long id);  
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.ProductOrderPlaced( "
       +  " p.id,  p.buyerId,  p.cartId,  p.productId,  p.sellerId, " 
       +  " p.newAddressStatus,  p.newAddress,  p.orderStartDate,  p.orderPlacedStatus, " 
       +  " p.orderPlacedDate,  p.price,  p.quantity,  p.discountOffer ,p.unitDetail,p.contentName)"
       +  " from ProductOrderPlaced p where p.id=?1 ")  
    public ProductOrderPlaced getProductOrderFromId(Long id);  
    
}
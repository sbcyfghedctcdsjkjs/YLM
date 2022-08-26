/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.repository;

import com.bananabkend.bananaBkEnd1A.model.ProductCart;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author bunsiv
 */
public interface ProductCartRepo extends CrudRepository<ProductCart, Object>{
    
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.ProductCart("
       + " p.id,p.userId,p.cartItemsList,p.updatedOn,p.status ) "
       + " from ProductCart p where p.id=?1 and p.status='Y'")  
    public ProductCart getActiveCartInfoFromId(Long id);  
    
     @Query("select new com.bananabkend.bananaBkEnd1A.model.ProductCart("
            + " p.id,p.userId,p.cartItemsList,p.updatedOn,p.status ) "
            + " from ProductCart p where p.id=?1 ")  
    public ProductCart getOneCartInfoFromId(Long id);    
    

}

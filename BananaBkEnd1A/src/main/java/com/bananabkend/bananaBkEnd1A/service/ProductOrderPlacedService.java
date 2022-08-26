/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;

import com.bananabkend.bananaBkEnd1A.model.ProductOrderPlaced;
import java.util.ArrayList;

/**
 *
 * @author bunsiv
 */
public interface ProductOrderPlacedService {
    public ProductOrderPlaced save(ProductOrderPlaced orderPlaced) throws Exception;
    public ArrayList<ProductOrderPlaced> getAllOrderForSeller(Long sellerId) throws Exception;
    public ArrayList<ProductOrderPlaced> getAllOrderForBuyer(Long buyerId) throws Exception;
    public ProductOrderPlaced getProductOrderFromId(Long id) throws Exception;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;

import com.bananabkend.bananaBkEnd1A.model.ProductOrderPlaced;
import com.bananabkend.bananaBkEnd1A.repository.ProductOrderPlacedRepo;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author bunsiv
 */


@Service
@Transactional
public class ProductOrderPlacedServiceImpl implements ProductOrderPlacedService{
    private ProductOrderPlacedRepo productOrderPlacedRepo;

    public ProductOrderPlacedServiceImpl(ProductOrderPlacedRepo productOrderPlacedRepo) {
        this.productOrderPlacedRepo = productOrderPlacedRepo;
    }
    public ProductOrderPlaced save(ProductOrderPlaced orderPlaced) throws Exception{
        return productOrderPlacedRepo.save(orderPlaced);
    }

    @Override
    public ArrayList<ProductOrderPlaced> getAllOrderForSeller(Long sellerId) throws Exception {
        return productOrderPlacedRepo.getAllOrderForSeller(sellerId);
    }
    
    public ArrayList<ProductOrderPlaced> getAllOrderForBuyer(Long buyerId) throws Exception{
        return productOrderPlacedRepo.getAllOrderForBuyer(buyerId);
    }
    
    @Override
    public ProductOrderPlaced getProductOrderFromId(Long id) throws Exception {
        return productOrderPlacedRepo.getProductOrderFromId(id);
    }
    
}

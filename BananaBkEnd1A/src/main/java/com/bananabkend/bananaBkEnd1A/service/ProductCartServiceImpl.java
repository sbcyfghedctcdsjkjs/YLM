/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;
import com.bananabkend.bananaBkEnd1A.model.CategoryModel;
import com.bananabkend.bananaBkEnd1A.model.ProductCart;
import com.bananabkend.bananaBkEnd1A.repository.ProductCartRepo;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author bunsiv
 */



@Service
@Transactional
public class ProductCartServiceImpl implements ProductCartService{    
    private ProductCartRepo productCartRepo;
    public ProductCartServiceImpl(ProductCartRepo productCartRepo) {
        this.productCartRepo = productCartRepo;
    }

    @Override
    public ProductCart registerNewCart(ProductCart productCart) throws Exception {
        return productCartRepo.save(productCart);
    }    
    
    @Override
    public ProductCart save(ProductCart productCart) throws Exception{
        return productCartRepo.save(productCart);
    }

    @Override
    public ProductCart getActiveCartInfoFromId(ProductCart productCart) throws Exception{
        return productCartRepo.getActiveCartInfoFromId(productCart.getId());
    }

    @Override
    public ProductCart getOneCartInfoFromId(ProductCart productCart) throws Exception{
        return productCartRepo.getOneCartInfoFromId(productCart.getId());
    }
}

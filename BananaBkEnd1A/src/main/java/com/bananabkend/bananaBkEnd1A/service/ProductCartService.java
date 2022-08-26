/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;

import com.bananabkend.bananaBkEnd1A.model.ProductCart;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import java.util.ArrayList;

/**
 *
 * @author bunsiv
 */
public interface ProductCartService {
    public ProductCart registerNewCart(ProductCart productCart) throws Exception;
    public ProductCart save(ProductCart productCart) throws Exception;
    public ProductCart getActiveCartInfoFromId(ProductCart productCart) throws Exception;
    public ProductCart getOneCartInfoFromId(ProductCart productCart) throws Exception;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;

import com.bananabkend.bananaBkEnd1A.model.Pricing;
import java.util.ArrayList;

/**
 *
 * @author bunsiv
 */
public interface PricingService {
    public Pricing registerNewPricing(Pricing pricing) throws Exception;
    public Pricing save(Pricing pricing) throws Exception;
    
    
    public Pricing getPricingInfoFromId(Long Id) throws Exception;
    public Pricing getAcivePricingInfoForProductId(Long ownerContentId) throws Exception;
    public ArrayList<Pricing> getAllPricingInfoForProductId(Long ownerContentId) throws Exception;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;
import com.bananabkend.bananaBkEnd1A.model.Pricing;
import com.bananabkend.bananaBkEnd1A.repository.PricingRepo;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
* @author bunsiv
 */



@Service
@Transactional
public class PricingServiceImpl implements PricingService{    
    private PricingRepo pricingRepo;
    public PricingServiceImpl(PricingRepo pricingRepo) {
        this.pricingRepo = pricingRepo;
    }



    @Override
    public Pricing registerNewPricing(Pricing pricing) throws Exception {
        return pricingRepo.save(pricing);
    }    
    
    @Override
    public Pricing save(Pricing pricing) throws Exception{
        return pricingRepo.save(pricing);
    }

    @Override
    public Pricing getPricingInfoFromId(Long id) throws Exception {
        return pricingRepo.getPricingInfoFromId(id);
    }

    @Override
    public Pricing getAcivePricingInfoForProductId(Long ownerContentId) throws Exception {
        return pricingRepo.getAcivePricingInfoForProductId(ownerContentId);
    }

    @Override
    public ArrayList<Pricing> getAllPricingInfoForProductId(Long ownerContentId) throws Exception {
        return pricingRepo.getAllPricingInfoForProductId(ownerContentId);
    }

}

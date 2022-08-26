/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service.publicViewServices;

import com.bananabkend.bananaBkEnd1A.model.publicViewModel.ResetSecretNumber;
import com.bananabkend.bananaBkEnd1A.repository.publicViewRepo.ResetSecretNumberRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sunjiv6
 */
@Service
@Transactional
public class ResetSecretNumberServiceImpl implements ResetSecretNumberService {
    ResetSecretNumberRepo resetSecretNumberRepo;
    
    public ResetSecretNumberServiceImpl(ResetSecretNumberRepo resetSecretNumberRepo) {
        this.resetSecretNumberRepo= resetSecretNumberRepo;
    }
    
    @Override
    public ResetSecretNumber save (ResetSecretNumber resetSecretNumber) throws Exception
    {
        return this.resetSecretNumberRepo.save(resetSecretNumber);
    }

    @Override
    public ResetSecretNumber findByPhoneNumber(ResetSecretNumber resetSecretNumber) throws Exception {
         return this.resetSecretNumberRepo.findByPhoneNumber(resetSecretNumber.getPhoneNumber());
    }
    
    @Override
    public ResetSecretNumber findByEmail(ResetSecretNumber resetSecretNumber) throws Exception {        
        return this.resetSecretNumberRepo.findByEmail(resetSecretNumber.getEmail());
    }
}
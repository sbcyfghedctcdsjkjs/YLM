/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service.publicViewServices;

import com.bananabkend.bananaBkEnd1A.model.publicViewModel.ResetSecretNumber;

/**
 *
 * @author sunjiv6
 */
public interface ResetSecretNumberService {
    ResetSecretNumber save (ResetSecretNumber resetSecretNumber) throws Exception;
    ResetSecretNumber findByPhoneNumber(ResetSecretNumber resetSecretNumber) throws Exception;
    ResetSecretNumber findByEmail(ResetSecretNumber resetSecretNumber) throws Exception;
}

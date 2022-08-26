/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;

import com.bananabkend.bananaBkEnd1A.model.UserOwner;
import java.util.List;

/**
 *
 * @author sunjiv6
 */
public interface ReceiveAdService {    

    public UserOwner validateUserAndSaveAd(UserOwner userOwner) throws Exception;
    public UserOwner registerNewUserByEmail(UserOwner userOwner) throws Exception;
    public List<UserOwner> getUserByPhoneAndSecretNumber(UserOwner phone) throws Exception;
    public List<UserOwner> getUserByEmailAndSecretNumber(UserOwner email) throws Exception;
    
}

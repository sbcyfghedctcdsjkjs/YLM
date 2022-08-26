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
public interface UserOwnerService {    

    UserOwner modifyUserCount(UserOwner userOwner) throws Exception;
    UserOwner registerNewUserByPhone(UserOwner userOwner) throws Exception;
    UserOwner registerNewUserByEmail(UserOwner userOwner) throws Exception;
    Boolean userExistByPhoneAndSecretNumber(UserOwner userOwner) throws Exception;
    Boolean userExistByEmailAndSecretNumber(UserOwner userOwner) throws Exception;
    List<UserOwner> getUserByPhoneAndSecretNumber(UserOwner userOwner) throws Exception;
    List<UserOwner> getUserByEmailAndSecretNumber(UserOwner userOwner) throws Exception;
    
}

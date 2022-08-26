/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service.publicViewServices;

import com.bananabkend.bananaBkEnd1A.model.UserOwner;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer;
import java.util.List;

/**
 *
 * @author sunjiv6
 */
public interface UserAdViewerService {
    UserAdViewer save(UserAdViewer userAdViewer) throws Exception;    
    public UserAdViewer registerNewUser(UserAdViewer userAdViewer) throws Exception;
    UserAdViewer registerNewUserByPhone(UserAdViewer userAdViewer) throws Exception; 
    UserAdViewer registerNewUserByEmail(UserAdViewer userAdViewer) throws Exception;
    
    Boolean userExistByPhoneAndSecretNumber(UserAdViewer userAdViewer) throws Exception;
    Boolean userExistByEmailAndSecretNumber(UserAdViewer userAdViewer) throws Exception;
    List<UserAdViewer> getUserByPhoneAndSecretNumber(UserAdViewer userAdViewer) throws Exception;
    List<UserAdViewer> getUserByEmailAndSecretNumber(UserAdViewer userAdViewer) throws Exception;
    List<UserAdViewer> getUserById(UserAdViewer userAdViewer) throws Exception;
    List<UserAdViewer> getUserByPhone(UserAdViewer userAdViewer) throws Exception;
    List<UserAdViewer> getUserByEmail(UserAdViewer userAdViewer) throws Exception;
    Long getUserCountByUserType(String userType) throws Exception;
    UserAdViewer findAdminTransactionUser(UserAdViewer userAdViewer) throws Exception;
    UserAdViewer authorizeAdminTransactionUser(UserAdViewer userAdViewer) throws Exception;
}

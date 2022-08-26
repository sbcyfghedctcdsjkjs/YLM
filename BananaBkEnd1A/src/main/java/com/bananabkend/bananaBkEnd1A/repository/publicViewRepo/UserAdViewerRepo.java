/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.repository.publicViewRepo;

import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author sunjiv6
 */
public interface UserAdViewerRepo  extends CrudRepository<UserAdViewer, Long> {
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer("
            + " u.id, u.adViewerPhone, u.adViewerEmail, u.userName, u.secretNumber, "
            + " u.userType, u.transactionId, u.userCreatedDate, u.userStatus, "
            + " u.createLimit, u.createCount,u.lang,"
            + " u.search,u.userInfo,u.validatePhone,u.validateEmail,u.ngChangeLang,u.resetSecretCnt,u.cartId,u.seeCartInfoCnt "            
            + ") from UserAdViewer u "
            + " WHERE u.adViewerPhone=?1 ")
    public UserAdViewer findByPhoneNum(String mobileNum);

    @Query("select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer("
            + " u.id, u.adViewerPhone, u.adViewerEmail, u.userName, u.secretNumber, "
            + " u.userType, u.transactionId, u.userCreatedDate, u.userStatus, "
            + " u.createLimit, u.createCount,u.lang,"
            + " u.search,u.userInfo,u.validatePhone,u.validateEmail,u.ngChangeLang,u.resetSecretCnt,u.cartId,u.seeCartInfoCnt"            
            + ") from UserAdViewer u "
            + " WHERE u.adViewerEmail=?1 ")
    public UserAdViewer findByEmail(String email);
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer(u.id,u.adViewerPhone,u.adViewerEmail,"
            + "u.userName) from UserAdViewer u "
            + " WHERE u.adViewerPhone=?1 or u.adViewerEmail=?2 ")
    public ArrayList<UserAdViewer> findByPhoneNumOrEmail(String mobileNum,String email);
    
//    @Query("select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer(u.id,u.adViewerPhone,u.adViewerEmail,"
//            + "u.userName, l.allLikedIds) from UserAdViewer u, UserAdViewerLikedIt l  "
//            + " WHERE u.adViewerPhone=?1 and u.secretNumber=?2 and l.userAdViewerId = u.id")
//    public UserAdViewer findByPhoneNumAndSecretNumber(String adViewerPhone, String secretNumber);
    
     @Query("select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer("
            + " u.id, u.adViewerPhone, u.adViewerEmail, u.userName, u.secretNumber, "
            + " u.userType, u.transactionId, u.userCreatedDate, u.userStatus, "
            + " u.createLimit, u.createCount,u.lang,"
            + " u.search,u.userInfo,u.validatePhone,u.validateEmail,u.ngChangeLang,u.resetSecretCnt,u.cartId,u.seeCartInfoCnt"            
            + ") from UserAdViewer u "
            + " WHERE u.adViewerPhone=?1 and secretNumber=?2")
    public UserAdViewer findByPhoneNumAndSecretNumber(String adViewerPhone, String secretNumber);

    @Query("select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer("
            + " u.id, u.adViewerPhone, u.adViewerEmail, u.userName, u.secretNumber, "
            + " u.userType, u.transactionId, u.userCreatedDate, u.userStatus, "
            + " u.createLimit, u.createCount,u.lang,"
            + " u.search,u.userInfo,u.validatePhone,u.validateEmail,u.ngChangeLang,u.resetSecretCnt,u.cartId,u.seeCartInfoCnt"            
            + ") from UserAdViewer u "
            + " WHERE u.adViewerEmail=?1 and secretNumber=?2")
    public UserAdViewer findByEmailAndSecretNumber(String adViewerEmail, String secretNumber);    
        
    @Query("select count(*) from UserAdViewer u "
            + " WHERE  u.userType='?1' ")
    public Long getUserCountByUserType(String userType);
    
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer("
            + " u.id, u.adViewerPhone, u.adViewerEmail, u.userName, u.secretNumber, "
            + " u.userType, u.transactionId, u.userCreatedDate, u.userStatus, "
            + " u.createLimit, u.createCount,u.lang,"
            + " u.search,u.userInfo,u.validatePhone,u.validateEmail,u.ngChangeLang,u.resetSecretCnt,u.cartId,u.seeCartInfoCnt"            
            + ") from UserAdViewer u "
            + " WHERE u.adViewerEmail=?1 and u.userType='T'")
    public UserAdViewer findAdminTransactionUser(String adViewerEmail);
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer("
            + " u.id, u.adViewerPhone, u.adViewerEmail, u.userName, u.secretNumber, "
            + " u.userType, u.transactionId, u.userCreatedDate, u.userStatus, "
            + " u.createLimit, u.createCount,u.lang,"
            + " u.search,u.userInfo,u.validatePhone,u.validateEmail,u.ngChangeLang,u.resetSecretCnt,u.cartId,u.seeCartInfoCnt"            
            + ") from UserAdViewer u "
            + " WHERE u.adViewerEmail=?1 and u.userType='T' and u.secretNumber=?2")
    public UserAdViewer authorizeAdminTransactionUser(String adViewerEmail,String sec);
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.repository;



import com.bananabkend.bananaBkEnd1A.model.UserOwner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author sunjiv6
 */
public interface UserRepository extends CrudRepository<UserOwner, Long>{
 
    @Query("select new com.bananabkend.bananaBkEnd1A.model.UserOwner(u.id,u.userType,u.userName,"
            + "u.userCreatedDate,u.userEmail,u.userPhone,u.secretNumberEncoded,createLimit,createCount) from UserOwner u "
            + " WHERE u.userPhone=?1 ")
    public UserOwner findByPhoneNum(String mobileNum);
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.UserOwner(u.id,u.userType,u.userName,"
            + "u.userCreatedDate,u.userEmail,u.userPhone,u.secretNumberEncoded,createLimit,createCount) from UserOwner u "
            + " WHERE u.userPhone=?1 and u.secretNumberEncoded=?2 ")
    public UserOwner findByPhoneNumAndSecretNumber(String mobileNum, String secretNum );
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.UserOwner(u.id,u.userType,u.userName,"
            + "u.userCreatedDate,u.userEmail,u.userPhone,u.secretNumberEncoded,createLimit,createCount) from UserOwner u "
            + " WHERE u.userEmail=?1  ")
    public UserOwner findByEmail(String email);
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.UserOwner(u.id,u.userType,u.userName,"
            + "u.userCreatedDate,u.userEmail,u.userPhone,u.secretNumberEncoded,createLimit,createCount) from UserOwner u "
            + " WHERE u.userEmail=?1 and u.secretNumberEncoded=?2")
    public UserOwner findByEmailAndSecretNumber(String email, String secretNum);

    
}

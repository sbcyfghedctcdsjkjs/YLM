/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.repository.publicViewRepo;

import com.bananabkend.bananaBkEnd1A.model.publicViewModel.ResetSecretNumber;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author sunjiv6
 */
public interface ResetSecretNumberRepo   extends CrudRepository<ResetSecretNumber, Long> { 
    
     @Query("select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.ResetSecretNumber("
            + " u.id, u.phoneNumber, u.email, u.createdOn"        
            + ") from ResetSecretNumber u "
            + " WHERE u.phoneNumber=?1 ")
    public ResetSecretNumber findByPhoneNumber(String mobileNum);
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.ResetSecretNumber("
            + " u.id, u.phoneNumber, u.email, u.createdOn"        
            + ") from ResetSecretNumber u "
            + " WHERE u.email=?1 ")
    public ResetSecretNumber findByEmail(String email);
}

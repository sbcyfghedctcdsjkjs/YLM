/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.repository;

import com.bananabkend.bananaBkEnd1A.model.SecurityApi;
import com.bananabkend.bananaBkEnd1A.model.TransactionMoney;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author sunjiv6
 */


public interface TransactionMoneyRepo extends CrudRepository<TransactionMoney, Long>{
    
    @Query("select t.id"
            + "  from TransactionMoney t "
            + " WHERE t.transactionString=?1 ")
    public Long getTrans(String transactionString);
    
    

}

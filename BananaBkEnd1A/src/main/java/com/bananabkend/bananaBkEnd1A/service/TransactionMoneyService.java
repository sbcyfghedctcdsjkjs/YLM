/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;

import com.bananabkend.bananaBkEnd1A.model.TransactionMoney;

/**
 *
 * @author sunjiv6
 */
public interface TransactionMoneyService {
    
    
    TransactionMoney save(TransactionMoney transactionMoney) throws Exception;
    
     Long getTrans(TransactionMoney transactionMoney) throws Exception;
    
    
    
}

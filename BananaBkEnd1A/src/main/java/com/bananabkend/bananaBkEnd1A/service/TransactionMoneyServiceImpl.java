/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;

import com.bananabkend.bananaBkEnd1A.model.TransactionMoney;
import com.bananabkend.bananaBkEnd1A.repository.TransactionMoneyRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sunjiv6
 */



@Service
@Transactional
public class TransactionMoneyServiceImpl implements TransactionMoneyService{
    
    private TransactionMoneyRepo transactionMoneyRepo;
    public TransactionMoneyServiceImpl(TransactionMoneyRepo transactionMoneyRepo) {
        this.transactionMoneyRepo = transactionMoneyRepo;
    }
    
    
    @Override
    public TransactionMoney save(TransactionMoney transactionMoney) throws Exception {
        return transactionMoneyRepo.save(transactionMoney);
    }
       
    @Override
    
    public Long getTrans(TransactionMoney transactionMoney) throws Exception {
        return transactionMoneyRepo.getTrans(transactionMoney.getTransactionString());
    }
}
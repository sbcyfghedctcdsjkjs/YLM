/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author sunjiv6
 */
@Entity
public class TransactionMoney {
    public TransactionMoney() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length=80)
    private String transactionString;
    
    @Transient
    private String transactionDate;
    
    @Column(length=50)
    private String ownerPhoneNum;
    
    
    @Column(length=15)
    private String ownerEmail;
    
    @Column(length=15)
    private String transactionUserEmail;
    @Column(length=300)
    private String remarks;
    
    
    @Column(length=50)
    private String secret;
    
    @Column(length=20)
    private String createdOn;
    
    @Transient
    private Long updatedByUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionString() {
        return transactionString;
    }

    public void setTransactionString(String transactionString) {
        this.transactionString = transactionString;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getOwnerPhoneNum() {
        return ownerPhoneNum;
    }

    public void setOwnerPhoneNum(String ownerPhoneNum) {
        this.ownerPhoneNum = ownerPhoneNum;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getTransactionUserEmail() {
        return transactionUserEmail;
    }

    public void setTransactionUserEmail(String transactionUserEmail) {
        this.transactionUserEmail = transactionUserEmail;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getUpdatedByUser() {
        return updatedByUser;
    }

    public void setUpdatedByUser(Long updatedByUser) {
        this.updatedByUser = updatedByUser;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    
}
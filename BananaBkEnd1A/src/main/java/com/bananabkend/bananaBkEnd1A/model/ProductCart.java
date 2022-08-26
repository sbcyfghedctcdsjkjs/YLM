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
/**
 *
 * @author bunsiv
 */


@Entity
public class ProductCart {

    public ProductCart() {
    }
    public ProductCart(Long id,Long userId,String cartItemsList,String updatedOn,String status) {
        this.id = id;
        
        this.userId=userId;
        
        this.cartItemsList=cartItemsList;        
        this.updatedOn=updatedOn;
        this.status=status;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    
    @Column(length=500)
    private String cartItemsList;
    
    //private Integer cartValue;//cartPrice
    private Integer itemsCount;
    
    @Column(length=20)
    private String updatedOn;
    


    @Column(length=1)
    private String status; //Active or not Active 


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCartItemsList() {
        return cartItemsList;
    }

    public void setCartItemsList(String cartItemsList) {
        this.cartItemsList = cartItemsList;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(Integer itemsCount) {
        this.itemsCount = itemsCount;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
}
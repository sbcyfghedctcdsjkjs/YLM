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
public class ProductOrderPlaced {
   public ProductOrderPlaced() {
    }

    public ProductOrderPlaced(Long id, Long buyerId, Long cartId, Long productId, Long sellerId, String newAddressStatus, 
            String newAddress, String orderStartDate, String orderPlacedStatus, String orderPlacedDate, 
            Double price, Integer quantity, String discountOffer,String unitDetail,String contentName) {
        this.id = id;
        this.buyerId = buyerId;
        this.cartId = cartId;
        this.productId = productId;
        this.sellerId = sellerId;
        this.newAddressStatus = newAddressStatus;
        this.newAddress = newAddress;
        this.orderStartDate = orderStartDate;
        this.orderPlacedStatus = orderPlacedStatus;
        this.orderPlacedDate = orderPlacedDate;
        this.price = price;
        this.quantity = quantity;
        this.discountOffer = discountOffer;
        this.unitDetail = unitDetail;
        this.contentName=contentName;
    }
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long buyerId;

    private Long cartId;
    private Long productId;
    private Long sellerId;
    @Column(length=1)
    private String newAddressStatus;//newAddress OR oldAddress
    @Column(length=200)
    private String newAddress;
    @Column(length=20)
    private String orderStartDate;
    
//    @Column(length=300)
//    private String orderDetails;//ProductId,Prod_Price,offersId,
    
    @Column(length=3)
    private String orderPlacedStatus;//ContentStatus.ProductOrder_Status_OrderReceived & many...
    @Column(length=20)
    private String orderPlacedDate;
    
    private Double price;
    private Integer quantity;
    @Column(length=10)
    private String discountOffer;
    
    
    @Column(length=20)
    private String unitDetail;
    @Column(length=100)
    private String contentName ;
    public String getOrderStartDate() {
        return orderStartDate;
    }

    public void setOrderStartDate(String orderStartDate) {
        this.orderStartDate = orderStartDate;
    }

    public String getOrderPlacedDate() {
        return orderPlacedDate;
    }

    public void setOrderPlacedDate(String orderPlacedDate) {
        this.orderPlacedDate = orderPlacedDate;
    }
    
    public String getOrderPlacedStatus() {
        return orderPlacedStatus;
    }

    public void setOrderPlacedStatus(String orderPlacedStatus) {
        this.orderPlacedStatus = orderPlacedStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }


    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public String getNewAddressStatus() {
        return newAddressStatus;
    }

    public void setNewAddressStatus(String newAddressStatus) {
        this.newAddressStatus = newAddressStatus;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
    }
//
//    public String getOrderDetails() {
//        return orderDetails;
//    }
//
//    public void setOrderDetails(String orderDetails) {
//        this.orderDetails = orderDetails;
//    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDiscountOffer() {
        return discountOffer;
    }

    public void setDiscountOffer(String discountOffer) {
        this.discountOffer = discountOffer;
    }

    public String getUnitDetail() {
        return unitDetail;
    }

    public void setUnitDetail(String unitDetail) {
        this.unitDetail = unitDetail;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }    
    
}
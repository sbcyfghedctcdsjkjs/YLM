/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.model.dto;

/**
 *
 * @author bunsiv
 */
public class ProductOrderPlacedDto {
    private Long productOrderPlacedId;
    private Long ownerContentId;
    private String contentDesc;
    private String contentName;
    private Integer qntty;
    private String unitDetail;
    private String pricingId;
    private String ProductOrderPlacedStatus;
    
    
    private String orderStartDate;
    private String orderPlacedQuantity;

    public Long getProductOrderPlacedId() {
        return productOrderPlacedId;
    }

    public void setProductOrderPlacedId(Long productOrderPlacedId) {
        this.productOrderPlacedId = productOrderPlacedId;
    }

    public Long getOwnerContentId() {
        return ownerContentId;
    }

    public void setOwnerContentId(Long ownerContentId) {
        this.ownerContentId = ownerContentId;
    }

    public String getContentDesc() {
        return contentDesc;
    }

    public void setContentDesc(String contentDesc) {
        this.contentDesc = contentDesc;
    }

    public String getPricingId() {
        return pricingId;
    }

    public void setPricingId(String pricingId) {
        this.pricingId = pricingId;
    }

    public String getProductOrderPlacedStatus() {
        return ProductOrderPlacedStatus;
    }

    public void setProductOrderPlacedStatus(String ProductOrderPlacedStatus) {
        this.ProductOrderPlacedStatus = ProductOrderPlacedStatus;
    }

    public String getOrderStartDate() {
        return orderStartDate;
    }

    public void setOrderStartDate(String orderStartDate) {
        this.orderStartDate = orderStartDate;
    }

    public String getOrderPlacedQuantity() {
        return orderPlacedQuantity;
    }

    public void setOrderPlacedQuantity(String orderPlacedQuantity) {
        this.orderPlacedQuantity = orderPlacedQuantity;
    }       
}

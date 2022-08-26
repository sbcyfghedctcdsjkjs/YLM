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
public class Pricing {   
    public Pricing() {
    }
    public Pricing(Long id, Long ownerContentId,Double price, String unitDetail,Integer availableQuantity,
            Double taxPercent,String taxDetail,Integer soldQuantity,String status) {
        this.id = id;
        this.ownerContentId=ownerContentId;
        
        this.price = price;
        
        this.unitDetail = unitDetail;        
        this.availableQuantity = availableQuantity;        
        this.soldQuantity = soldQuantity;
        this.taxPercent = taxPercent;
        this.taxDetail = taxDetail;
        this.status = status;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    private Long ownerContentId; 
    private Double price;
    
    
    @Column(length=1)
    private String status; // Yes Active OR No Old pricing 
            
    @Column(length=20)
    private String unitDetail;
    private Integer availableQuantity;
//    @Column(length=200)
//    private String prevPrices;
    private Double taxPercent; // 12.5% 
//    private Double taxValue;  // 12.5% of 200= 24.2 value
    private String taxDetail;  // State Tax
    private Integer soldQuantity;
    public Long getId() {
        
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Double getPrice() {
        return price;
    }

    
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnitDetail() {
        return unitDetail;
    }

    public void setUnitDetail(String unitDetail) {
        this.unitDetail = unitDetail;
    }

    public Long getOwnerContentId() {
        return ownerContentId;
    }

    public void setOwnerContentId(Long ownerContentId) {
        this.ownerContentId = ownerContentId;
    }

    public Double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(Double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public String getTaxDetail() {
        return taxDetail;
    }

    
    public void setTaxDetail(String taxDetail) {
        this.taxDetail = taxDetail;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Integer getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Integer soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}

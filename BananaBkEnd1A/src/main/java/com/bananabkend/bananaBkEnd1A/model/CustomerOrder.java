/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author bunsiv
 */
public class CustomerOrder {

    
    
    public CustomerOrder() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    
    private Long ownerContentid; //Product id
    
    private String courierTrackingId;
    
    private String CourierName;    
    private String deliveryAddress;
    
}

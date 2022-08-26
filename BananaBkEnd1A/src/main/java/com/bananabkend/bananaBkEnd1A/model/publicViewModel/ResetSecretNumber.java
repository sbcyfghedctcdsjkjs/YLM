/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.model.publicViewModel;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sunjiv6
 */

@Entity
public class ResetSecretNumber {

    public ResetSecretNumber() {
    }
    
    

    public ResetSecretNumber(Long id, String phoneNumber, String email, String createdOn) {
        this.id=id;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.createdOn=createdOn;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "System generated unique id of the UserAdViewer",name="id",required=false,value="-1") 
    private Long id;
    @Column(length=15)
    private String phoneNumber;
    
    @Column(length=50)        
    private String email;
    
    @Column(length=16)
    private String createdOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     
    
}

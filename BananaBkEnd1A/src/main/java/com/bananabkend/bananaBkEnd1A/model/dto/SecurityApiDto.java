/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.model.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sunjiv6
 */
public class SecurityApiDto {

    public SecurityApiDto() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "System generated unique id of the SecurityApi",name="id",required=true,value="-1") 
    private Long id;
    
    private Long userId;
    
    private String apikey_vb;
    
    private String mobileOrWeb; // Mobile or web browsers
    
    private String updatedOn_vb; //time
    
    private String uriAccessed; //1,2,3,4,5,6
    
    private String status; //apiKey is active or not depending on time difference
    
    private String message;
    
    private Boolean isValid;

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

    public String getApikey_vb() {
        return apikey_vb;
    }

    public void setApikey_vb(String apikey_vb) {
        this.apikey_vb = apikey_vb;
    }

    public String getMobileOrWeb() {
        return mobileOrWeb;
    }

    public void setMobileOrWeb(String mobileOrWeb) {
        this.mobileOrWeb = mobileOrWeb;
    }

    public String getUpdatedOn_vb() {
        return updatedOn_vb;
    }

    public void setUpdatedOn_vb(String updatedOn_vb) {
        this.updatedOn_vb = updatedOn_vb;
    }

    public String getUriAccessed() {
        return uriAccessed;
    }

    public void setUriAccessed(String uriAccessed) {
        this.uriAccessed = uriAccessed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }    
}


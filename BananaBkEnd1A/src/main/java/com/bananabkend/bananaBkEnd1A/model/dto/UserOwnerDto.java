/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.model.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sunjiv6
 */
public class UserOwnerDto {

    public UserOwnerDto() {
    }
    
    
    
    private String id;
    
    private Integer userType;
    
    private String userCreatedDate;
    
    private String userName;
    
    private Integer createLimit;
    
    private Integer createCount=0;
    
    private String ownerEmail_vb;
    
    private String ownerPhone_vb;
    
    private String secretNumber_vb;
    
    private String msg_vb;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserCreatedDate() {
        return userCreatedDate;
    }

    public void setUserCreatedDate(String userCreatedDate) {
        this.userCreatedDate = userCreatedDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCreateLimit() {
        return createLimit;
    }

    public void setCreateLimit(Integer createLimit) {
        this.createLimit = createLimit;
    }

    public Integer getCreateCount() {
        return createCount;
    }

    public void setCreateCount(Integer createCount) {
        this.createCount = createCount;
    }

    public String getSecretNumber_vb() {
        return secretNumber_vb;
    }

    public void setSecretNumber_vb(String secretNumber_vb) {
        this.secretNumber_vb = secretNumber_vb;
    }

    public String getOwnerEmail_vb() {
        return ownerEmail_vb;
    }

    public void setOwnerEmail_vb(String ownerEmail_vb) {
        this.ownerEmail_vb = ownerEmail_vb;
    }

    public String getOwnerPhone_vb() {
        return ownerPhone_vb;
    }

    public void setOwnerPhone_vb(String ownerPhone_vb) {
        this.ownerPhone_vb = ownerPhone_vb;
    }

    public String getMsg_vb() {
        return msg_vb;
    }

    public void setMsg_vb(String msg_vb) {
        this.msg_vb = msg_vb;
    }
    
}

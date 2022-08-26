/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.model.dto.publicView;

import io.swagger.annotations.ApiModelProperty;


/**
 *
 * @author sunjiv6
 */
public class UserAdViewerDTO {

    
    @ApiModelProperty(notes = "System generated unique id of the UserAdViewer",name="id",required=false,value="-1") 
    private String userId;
    
    @ApiModelProperty(notes = "User Phone Number",name="adViewerPhone",required=true,value="") 
    private String phone;
    
    @ApiModelProperty(notes = "User Email",name="adViewerEmail",required=true,value="") 
    private String email;
    
    @ApiModelProperty(notes = "User secret number",name="secretNumber",required=true,value="") 
    private String secretNumber;
    
    private String userCreatedDate;
    
    private String userName;
    
    private String userStatus;
    
    private String likedAdsId;
    
    private String idOfLikedAds;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(String secretNumber) {
        this.secretNumber = secretNumber;
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

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getLikedAdsId() {
        return likedAdsId;
    }

    public void setLikedAdsId(String likedAdsId) {
        this.likedAdsId = likedAdsId;
    }

    public String getIdOfLikedAds() {
        return idOfLikedAds;
    }

    public void setIdOfLikedAds(String idOfLikedAds) {
        this.idOfLikedAds = idOfLikedAds;
    }
}
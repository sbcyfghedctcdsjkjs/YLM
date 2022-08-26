/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.model;
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
public class UserOwner {

    public UserOwner() {
    }
    
    public UserOwner(Long id,Integer userType,String userName,String userCreatedDate,
            String userEmail,String userPhone,String secretNumberEncoded,Integer createLimit,Integer createCount) {
    this.id = id;
    this.userType = userType;
    this.userName = userName;
    this.userCreatedDate = userCreatedDate;
    this.userEmail = userEmail;
    this.userPhone =userPhone;
    this.secretNumberEncoded = secretNumberEncoded;
    this.createLimit=createLimit;
    this.createCount=createCount;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "System generated unique id of the UserOwner",name="id",required=true,value="-1") 
    private Long id;
    
    @ApiModelProperty(notes = "Type/Role of user",name="userType",required=false,value="1")
    private Integer userType;
    
    @Column(length=20)
    private String userCreatedDate;
    
    @Column(length=50)
    private String userName;
    
    private Integer createLimit;
    
    private Integer createCount=0;
    
    @ApiModelProperty(notes = "User Email",name="userEmail",required=true,value="")
    @Column(length=50)
    private String userEmail;
    
    @ApiModelProperty(notes = "User Phone",name="userPhone",required=true,value="")
    @Column(length=15)
    private String userPhone;
    
    @ApiModelProperty(notes = "Secret Number Encoded",name="secretNumberEncoded",required=true,value="")
    @Column(length=4)
    private String secretNumberEncoded;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getSecretNumberEncoded() {
        return secretNumberEncoded;
    }

    public void setSecretNumberEncoded(String secretNumberEncoded) {
        this.secretNumberEncoded = secretNumberEncoded;
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
}

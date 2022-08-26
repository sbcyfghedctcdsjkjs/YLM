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
import javax.persistence.Transient;

/**
 *
 * @author sunjiv6
 */
@Entity
public class UserAdViewer {

    public UserAdViewer() {
    }
      
//    public UserAdViewer(Long id,String adViewerPhone,String adViewerEmail,String userName,String allLikedIds) {
//        this.id=id;
//        this.adViewerPhone=adViewerPhone;
//        this.adViewerEmail=adViewerEmail;
//        this.userName=userName;
//        this.allLikedAdsId=allLikedIds;
//    }
//    
    public UserAdViewer(Long id,String adViewerPhone,String adViewerEmail,String userName ) {
        this.id=id;
        this.adViewerPhone=adViewerPhone;
        this.adViewerEmail=adViewerEmail;
        this.userName=userName;
    }    
    public UserAdViewer(Long id,String adViewerPhone,String adViewerEmail,String userName,
            String secretNumber,String userType,Long transactionId,String userCreatedDate,
            String userStatus,Integer createLimit,Integer createCount,String lang,
            Integer search,Integer userInfo,Integer validatePhone,Integer validateEmail,Integer ngChangeLang,Integer resetSecretCnt,
            Long cartId,Integer seeCartInfoCnt        ) {
        this.id=id;
        this.adViewerPhone=adViewerPhone;
        this.adViewerEmail=adViewerEmail;
        this.userName=userName;
        this.secretNumber=secretNumber;
        this.userType=userType;
        this.transactionId=transactionId;
        this.userCreatedDate=userCreatedDate;
        this.userStatus=userStatus;
        this.createLimit= createLimit;
        this.createCount=createCount;
        this.lang=lang;   
        this.search=search;
        this.userInfo=userInfo;
        this.validatePhone=validatePhone;
        this.validateEmail=validateEmail;
        this.ngChangeLang=ngChangeLang;
        this.resetSecretCnt=resetSecretCnt;
        this.cartId=cartId;
        this.seeCartInfoCnt=seeCartInfoCnt;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "System generated unique id of the UserAdViewer",name="id",required=false,value="-1") 
    private Long id;
    
    @ApiModelProperty(notes = "User Phone Number",name="adViewerPhone",required=true,value="") 
    @Column(length=15)
    private String adViewerPhone;
    
    @ApiModelProperty(notes = "User Email",name="adViewerEmail",required=true,value="") 
    @Column(length=50)
    private String adViewerEmail;
    
    @ApiModelProperty(notes = "User secret number",name="secretNumber",required=true,value="") 
    @Column(length=4)
    private String secretNumber;
    
    @Column(length=1)
    private String userType;  
    
    private Long transactionId;  
    
    @Column(length=20)
    private String userCreatedDate;
    
    @Column(length=10)
    private String userName;
    
    @Column(length=1)
    private String userStatus;
    
    @Transient
    private String allLikedAdsId;
    
    
    @Column(length=4)
    private String lang;
    private Integer createLimit;
    
    private Integer createCount=0;
    
        
//    @Column(columnDefinition = "TINYINT default 20")
//    private Integer login=20; 
//    
//    @Column(columnDefinition = "TINYINT default 20")
//    private Integer logout=20;
    
    @Column(columnDefinition = "TINYINT default 30")
    private Integer search=30;
 
    @Column(columnDefinition = "TINYINT default 2")
    private Integer userInfo=20; 
    
    @Column(columnDefinition = "TINYINT default 5")
    private Integer validatePhone=20;
    
    @Column(columnDefinition = "TINYINT default 5")
    private Integer validateEmail=20;
    
    @Column(columnDefinition = "TINYINT default 2")
    private Integer ngChangeLang=3;
    
    @Column(columnDefinition = "TINYINT default 5")
    private Integer resetSecretCnt=5;
    
    private Long cartId;
    
    //@Column(columnDefinition = "TINYINT default 1")
    private Integer seeCartInfoCnt=1;
//    @Column(length=200)
//    private String productOrderId;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAdViewerPhone() {
        return adViewerPhone;
    }

    public void setAdViewerPhone(String adViewerPhone) {
        this.adViewerPhone = adViewerPhone;
    }

    public String getAdViewerEmail() {
        return adViewerEmail;
    }

    public void setAdViewerEmail(String adViewerEmail) {
        this.adViewerEmail = adViewerEmail;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getAllLikedAdsId() {
        return allLikedAdsId;
    }

    public void setAllLikedAdsId(String allLikedAdsId) {
        this.allLikedAdsId = allLikedAdsId;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

//    public Integer getLogin() {
//        return login;
//    }
//
//    public void setLogin(Integer login) {
//        this.login = login;
//    }
//
//    public Integer getLogout() {
//        return logout;
//    }
//
//    public void setLogout(Integer logout) {
//        this.logout = logout;
//    }

    public Integer getSearch() {
        return search;
    }

    public void setSearch(Integer search) {
        this.search = search;
    }

    public Integer getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Integer userInfo) {
        this.userInfo = userInfo;
    }

    public Integer getValidatePhone() {
        return validatePhone;
    }

    public void setValidatePhone(Integer validatePhone) {
        this.validatePhone = validatePhone;
    }

    public Integer getValidateEmail() {
        return validateEmail;
    }

    public void setValidateEmail(Integer validateEmail) {
        this.validateEmail = validateEmail;
    }

    public Integer getNgChangeLang() {
        return ngChangeLang;
    }

    public void setNgChangeLang(Integer ngChangeLang) {
        this.ngChangeLang = ngChangeLang;
    }

    public Integer getResetSecretCnt() {
        return resetSecretCnt;
    }

    public void setResetSecretCnt(Integer resetSecretCnt) {
        this.resetSecretCnt = resetSecretCnt;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Integer getSeeCartInfoCnt() {
        return seeCartInfoCnt;
    }

    public void setSeeCartInfoCnt(Integer seeCartInfoCnt) {

        this.seeCartInfoCnt = seeCartInfoCnt;
    }
}
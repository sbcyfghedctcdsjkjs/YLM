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
import javax.persistence.Transient;

/**
 *
 * @author sunjiv6
 */
@Entity
public class SecurityApi {

    public SecurityApi() {
    }
    
    
    public SecurityApi(Long id,String apikey,String updatedOn,Long viewerUserId,
            String uriAccessed,String createdOn,
            Integer register ) {
        this.id            =       id;
        this.apikey        =       apikey;
        this.updatedOn    =       updatedOn;
        //this.ownerUserId   =       ownerUserId;
        this.viewerUserId  =       viewerUserId;
        //this.mobileOrWeb   =       mobileOrWeb;
        this.uriAccessed   =       uriAccessed;
        //this.status        =     status;
        this.createdOn=createdOn;
//        this.login=login;
//        this.logout=logout;
//        this.search=search;
        this.registerCnt=registerCnt;
//        this.userInfo=userInfo;
//        this.validatePhone=validatePhone;
//        this.validateEmail=validateEmail;
//        this.ngChangeLang=ngChangeLang;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "System generated unique id of the SecurityApi",name="id",required=true,value="-1") 
    private Long id;
    
    @Transient
    private Long ownerUserId;
    
    private Long viewerUserId;
    
    @Column(length=50)
    private String apikey;    
    
//    @Column(length=1)
//    private String mobileOrWeb; // Mobile or web browsers
    
    @Column(length=20)
    private String createdOn; //time
    
    @Column(length=20)
    private String updatedOn; //time
    
    @Column(length=1000)
    private String uriAccessed; //1,2,3,4,5,6
    
    @Transient
    private String status; //apiKey is active or not depending on time difference
    
//    private Integer accessedCount;
            
//   private Integer accessedLimit;

    @Transient
    private Boolean valid;
//    
//    @Column(columnDefinition = "TINYINT default 20")
//    private Integer login=20; 
//    
//    @Column(columnDefinition = "TINYINT default 20")
//    private Integer logout=20;
//    
//    @Column(columnDefinition = "TINYINT default 30")
//    private Integer search=30;
//    
//
//    
//    @Column(columnDefinition = "TINYINT default 2")
//    private Integer userInfo=2; 
//    
//    @Column(columnDefinition = "TINYINT default 5")
//    private Integer validatePhone=5;
//    
//    @Column(columnDefinition = "TINYINT default 5")
//    private Integer validateEmail=5;
//    
//    @Column(columnDefinition = "TINYINT default 2")
//    private Integer ngChangeLang=2;
//    
//    @Column(columnDefinition = "TINYINT default 5")
//    private Integer ngResetSecret=5;
    
    @Column(columnDefinition = "TINYINT")
    private Integer registerCnt=0; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Long ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public Long getViewerUserId() {
        return viewerUserId;
    }

    public void setViewerUserId(Long viewerUserId) {
        this.viewerUserId = viewerUserId;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
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

    public Boolean getValid() {
        return valid;

    }
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
//
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
//
//    public Integer getSearch() {
//        return search;
//    }
//
//    public void setSearch(Integer search) {
//        this.search = search;
//    }
//
    public Integer getRegisterCnt() {
        return registerCnt;
    }

    public void setRegisterCnt(Integer registerCnt) {
        this.registerCnt = registerCnt;
    }
//
//    public Integer getUserInfo() {
//        return userInfo;
//    }
//
//    public void setUserInfo(Integer userInfo) {
//        this.userInfo = userInfo;
//    }
//
//    public Integer getValidatePhone() {
//        return validatePhone;
//    }
//
//    public void setValidatePhone(Integer validatePhone) {
//        this.validatePhone = validatePhone;
//    }
//
//    public Integer getValidateEmail() {
//        return validateEmail;
//    }
//
//    public void setValidateEmail(Integer validateEmail) {
//        this.validateEmail = validateEmail;
//    }
//
//    public Integer getNgChangeLang() {
//        return ngChangeLang;
//    }
//
//    public void setNgChangeLang(Integer ngChangeLang) {
//        this.ngChangeLang = ngChangeLang;
//    }

//    public Integer getNgResetSecret() {
//        return ngResetSecret;
//    }
//
//    public void setNgResetSecret(Integer ngResetSecret) {
//        this.ngResetSecret = ngResetSecret;
//    }

    
}

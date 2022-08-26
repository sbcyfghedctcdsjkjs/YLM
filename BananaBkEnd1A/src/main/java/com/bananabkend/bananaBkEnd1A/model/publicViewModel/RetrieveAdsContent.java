/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.model.publicViewModel;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;


/**
 *
 * @author sunjiv6
 */

public class RetrieveAdsContent {
    
    public RetrieveAdsContent() {
    }
    
    public RetrieveAdsContent(Long id,Long ownerUserId, String uploadedFileName,String generatedFileName, 
        String contentDesc,Integer adType,String createdOn, String status,Integer adDisplayType,String activeDate) {
        this.id=id;
        this.ownerUserId=ownerUserId;
        this.uploadedFileName = uploadedFileName;
        this.generatedFileName = generatedFileName;
        this.contentDesc=contentDesc;
        this.adType=adType;
        this.createdOn=createdOn;
        this.status=status;
        this.adDisplayType=adDisplayType;
        this.activeDate=activeDate;
    }
    
    public RetrieveAdsContent(Long id,String contentDesc, String uploadedFileName,Integer adType,String createdOn,
            Integer adDisplayType,String activeDate,Integer pageNum,Double price,String unitDetail,String contentName){
        this.id=id;
        this.uploadedFileName = uploadedFileName;
        this.contentDesc=contentDesc;
        this.adType=adType;
        this.createdOn=createdOn;
        this.adDisplayType=adDisplayType;
        this.activeDate=activeDate;
        this.pageNum=pageNum;
        this.price=price;
        this.unitDetail=unitDetail;
        this.contentName=contentName;
    }

    @ApiModelProperty(notes = "System generated unique id of the Employee",name="id",required=false,value="-1") 
    private Long id;
    //    For directory path where image is stored
    private Integer directoryPathsId;
    
    private Boolean likedIt;
    
    private String likedAdsId;
    
    private Long adViewerId;
    
    private Long idOfLikedAds;
    
    private Integer pageNum;
    
    private Long ownerUserId;
    
    private Integer adDisplayType;
    
    private Integer adType;
    
    private String uploadedFileName;
    
    private String generatedFileName; 
    
    private String contentDesc;
    private String contentName;
    private String status;  
    
    private String createdOn ;
    
    private String activeDate;
    
    private String addressSearch;
    
    private String done;
    
    private String selectedFilters;
    private Double price;    
    private String unitDetail;
    private String selectedAdtype;
    
    @ApiModelProperty(notes = "User Phone Number",name="ownerPhone",required=true,value="") 
    private String ownerPhone;
    

    @ApiModelProperty(notes = "User Email",name="ownerEmail",required=true,value="") 
    private String ownerEmail;
    
    @ApiModelProperty(notes = "User secret number",name="secretNumber",required=true,value="") 
    private String secretNumber;
    
//    @Transient
//    @ApiModelProperty(notes = "Image to be uploaded",name="inputFile01",required=true,value="[]")
//    private MultipartFile inputFile01;

    
    @Override
    public String toString() {
        String str="ownerPhone: "+ownerPhone+"\n ownerEmail: "+ownerEmail+"\n secretNumber: "+secretNumber;
        return str; //To change body of generated methods, choose Tools | Templates.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDirectoryPathsId() {
        return directoryPathsId;
    }

    public void setDirectoryPathsId(Integer directoryPathsId) {
        this.directoryPathsId = directoryPathsId;
    }

    public Long getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Long ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public Integer getAdType() {
        return adType;
    }

    public void setAdType(Integer adType) {
        this.adType = adType;
    }

    public String getUploadedFileName() {
        return uploadedFileName;
    }

    public void setUploadedFileName(String uploadedFileName) {
        this.uploadedFileName = uploadedFileName;
    }

    public String getGeneratedFileName() {
        return generatedFileName;
    }

    public void setGeneratedFileName(String generatedFileName) {
        this.generatedFileName = generatedFileName;
    }

    public String getContentDesc() {
        return contentDesc;
    }

    public void setContentDesc(String contentDesc) {
        this.contentDesc = contentDesc;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(String secretNumber) {
        this.secretNumber = secretNumber;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    public Integer getAdDisplayType() {
        return adDisplayType;
    }

    public void setAdDisplayType(Integer adDisplayType) {
        this.adDisplayType = adDisplayType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getAddressSearch() {
        return addressSearch;
    }

    public void setAddressSearch(String addressSearch) {
        this.addressSearch = addressSearch;
    }

    public Boolean getLikedIt() {
        return likedIt;
    }

    public void setLikedIt(Boolean likedIt) {
        this.likedIt = likedIt;
    }

    public String getLikedAdsId() {
        return likedAdsId;
    }

    public void setLikedAdsId(String likedAdsId) {
        this.likedAdsId = likedAdsId;
    }   

    public Long getAdViewerId() {
        return adViewerId;
    }

    public void setAdViewerId(Long adViewerId) {
        this.adViewerId = adViewerId;
    }

    public Long getIdOfLikedAds() {
        return idOfLikedAds;
    }

    public void setIdOfLikedAds(Long idOfLikedAds) {
        this.idOfLikedAds = idOfLikedAds;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public String getSelectedFilters() {
        return selectedFilters;
    }

    public void setSelectedFilters(String selectedFilters) {
        this.selectedFilters = selectedFilters;
    }

    public String getSelectedAdtype() {
        return selectedAdtype;
    }

    public void setSelectedAdtype(String selectedAdtype) {
        this.selectedAdtype = selectedAdtype;
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

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }
}

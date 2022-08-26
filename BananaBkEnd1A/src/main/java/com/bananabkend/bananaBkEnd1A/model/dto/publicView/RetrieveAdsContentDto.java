/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.model.dto.publicView;

/**
 *
 * @author sunjiv6
 */

public class RetrieveAdsContentDto {
    
    public RetrieveAdsContentDto() {
    }
   
    private String id;
    
    private Boolean likedIt;
    
    private String likedAdsId;
    
    private String adViewerId; //l
    
    private String idOfLikedAds; //l
    
    private Integer pageNum;
    
    private String ownerUserId;//l
    
    private Integer adDisplayType;
    
    private Integer adType;

    private String contentDesc;
    
    private String status;  
    
    private String createdOn ;
    
    private String activeDate;
    
    private String addressSearch;
    
    private String done;
    
    private String ownerPhone;
    

    private String ownerEmail;
    
    private String secretNumber;
    
//    @Transient
//    @ApiModelProperty(notes = "Image to be uploaded",name="inputFile01",required=true,value="[]")
//    private MultipartFile inputFile01;

    
    @Override
    public String toString() {
        String str="ownerPhone: "+ownerPhone+"\n ownerEmail: "+ownerEmail+"\n secretNumber: "+secretNumber;
        return str; //To change body of generated methods, choose Tools | Templates.
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAdViewerId() {
        return adViewerId;
    }

    public void setAdViewerId(String adViewerId) {
        this.adViewerId = adViewerId;
    }

    public String getIdOfLikedAds() {
        return idOfLikedAds;
    }

    public void setIdOfLikedAds(String idOfLikedAds) {
        this.idOfLikedAds = idOfLikedAds;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public Integer getAdDisplayType() {
        return adDisplayType;
    }

    public void setAdDisplayType(Integer adDisplayType) {
        this.adDisplayType = adDisplayType;
    }

    public Integer getAdType() {
        return adType;
    }

    public void setAdType(Integer adType) {
        this.adType = adType;
    }

    public String getContentDesc() {
        return contentDesc;
    }

    public void setContentDesc(String contentDesc) {
        this.contentDesc = contentDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getAddressSearch() {
        return addressSearch;
    }

    public void setAddressSearch(String addressSearch) {
        this.addressSearch = addressSearch;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
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
    
}

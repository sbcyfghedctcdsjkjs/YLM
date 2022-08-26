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
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author sunjiv6
 */
@Entity
public class OwnerContent {
    
    public OwnerContent() {
    }
        
    public OwnerContent(Long id,Long ownerUserId, String uploadedFileName,String generatedFileName,String contentDesc,
    
            Integer adType,String createdOn, String status,Integer adDisplayType,String activeDate,String category,
            Long pricingId,String contentName,String contentType) {
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
        this.category=category;
        this.pricingId=pricingId;
        this.contentName=contentName;
        this.contentType=contentType;
    }
    
    
//    public OwnerContent(Long id,Long ownerUserId, String uploadedFileName,String generatedFileName, 
//        String contentDesc,Integer adType,String createdOn, String status,Integer adDisplayType,String activeDate) {
//        this.id=id;
//        this.ownerUserId=ownerUserId;
//        this.uploadedFileName = uploadedFileName;
//        this.generatedFileName = generatedFileName;
//        this.contentDesc=contentDesc;
//        this.adType=adType;
//        this.createdOn=createdOn;
//        this.status=status;
//        this.adDisplayType=adDisplayType;
//        this.activeDate=activeDate;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "System generated unique id of the Employee",name="id",required=false,value="-1") 
    private Long id;
    //    For directory path where image is stored
    private Integer directoryPathsId;
    
    private Long ownerUserId;
    
    private Integer adDisplayType;
    
    private Integer adType;
    
    @Column(length=50)
    private String uploadedFileName;
    
    @Column(length=30)
    private String generatedFileName; 
    
    @Column(length=1000)
    private String contentDesc;
    
    @Column(length=1)
    private String status;  
    
    @Column(length=20)
    private String createdOn ;
    
    @Column(length=400)
    private String category ;
    
    
    @Column(length=100)
    private String contentName ;
    @Column(length=1)
    private String contentType ;
//    private Integer status ;
    
    private String activeDate;
    
    @Transient
    @ApiModelProperty(notes = "User Phone Number",name="ownerPhone",required=true,value="") 
    private String ownerPhone;
    
    @Transient
    @ApiModelProperty(notes = "User Email",name="ownerEmail",required=true,value="") 
    private String ownerEmail;
    
    @Transient
    @ApiModelProperty(notes = "User secret number",name="secretNumber",required=true,value="") 
    private String secretNumber;
    
    
    
    
    @Transient
    @ApiModelProperty(notes = "Image to be uploaded",name="inputFile01",required=true,value="[]")
    private MultipartFile inputFile01;

    private Long pricingId;
    @Transient
    private Pricing pricing;
    @Override
    public String toString() {
        String str="ownerPhone: "+ownerPhone+"\n ownerEmail: "+ownerEmail+"\n secretNumber: "+secretNumber
                +"\n inputFile01 size: "+inputFile01.getSize()
                +"\n inputFile01 filename: "+inputFile01.getOriginalFilename();
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

    public MultipartFile getInputFile01() {
        return inputFile01;
    }

    public void setInputFile01(MultipartFile inputFile01) {
        this.inputFile01 = inputFile01;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getPricingId() {
        return pricingId;
    }

    public void setPricingId(Long pricingId) {
        this.pricingId = pricingId;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.model.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author sunjiv6
 */
public class OwnerContentDto {

    public OwnerContentDto() {
    }
    
//    public OwnerContentDto(Long id,Long ownerUserId, String uploadedFileName,String generatedFileName, 
//            String contentDesc,Integer adType,String createdOn, String status,Integer adDisplayType,String activeDate) {
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
//
//    public OwnerContentDto(Long id,Long ownerUserId, String uploadedFileName, String contentDesc,Integer adType,String createdOn,
//            String status,Integer adDisplayType,String activeDate) {
//        this.id=id;
//        this.ownerUserId=ownerUserId;
//        this.uploadedFileName = uploadedFileName;
//        this.contentDesc=contentDesc;
//        this.adType=adType;
//        this.createdOn=createdOn;
//        this.status=status;
//        this.adDisplayType=adDisplayType;
//        this.activeDate=activeDate;
//    }

    private String ownerPhone_vb;
    
    private String ownerEmail_vb;
    
    private String secretNumber_vb;
    
    private String id_vb;
    
//    private Integer directoryPathsId_vb;
    
//    private Long ownerUserId_vb;
    
    private Integer adDisplayType_vb;
    
    private Integer adType_vb;
    
//    private String uploadedFileName_vb;
    
//    private String generatedFileName_vb;   
    private String contentName_vb;  
    private String contentDesc_vb;  
    private String price_vb;
    private String qnttyUnit_vb;
    
    private String totalQntty_vb;
    private String taxPercent_vb;
    
    private String taxDetails_vb;
    private String createdOn_vb;  
    
    private String status_vb;  
    
    private String activeDate_vb;
    
    private String selectedCategoryList_vb;
    
    private Integer pageNum; 
    
    private MultipartFile inputFile01_vb;
    
    @Override
    public String toString() {
        String str="";
        return str; //To change body of generated methods, choose Tools | Templates.
    }

    public String getOwnerPhone_vb() {
        return ownerPhone_vb;
    }

    public void setOwnerPhone_vb(String ownerPhone_vb) {
        this.ownerPhone_vb = ownerPhone_vb;
    }

    public String getOwnerEmail_vb() {
        return ownerEmail_vb;
    }

    public void setOwnerEmail_vb(String ownerEmail_vb) {
        this.ownerEmail_vb = ownerEmail_vb;
    }

    public String getSecretNumber_vb() {
        return secretNumber_vb;
    }

    public void setSecretNumber_vb(String secretNumber_vb) {
        this.secretNumber_vb = secretNumber_vb;
    }
    
    

    public String getId_vb() {
        return id_vb;
    }

    public void setId_vb(String id_vb) {
        this.id_vb = id_vb;
    }

//    public Integer getDirectoryPathsId_vb() {
//        return directoryPathsId_vb;
//    }
//
//    public void setDirectoryPathsId_vb(Integer directoryPathsId_vb) {
//        this.directoryPathsId_vb = directoryPathsId_vb;
//    }
//
//    public Long getOwnerUserId_vb() {
//        return ownerUserId_vb;
//    }
//
//    public void setOwnerUserId_vb(Long ownerUserId_vb) {
//        this.ownerUserId_vb = ownerUserId_vb;
//    }
//
//    public String getUploadedFileName_vb() {
//        return uploadedFileName_vb;
//    }
//
//    public void setUploadedFileName_vb(String uploadedFileName_vb) {
//        this.uploadedFileName_vb = uploadedFileName_vb;
//    }
//
//    public String getGeneratedFileName_vb() {
//        return generatedFileName_vb;
//    }
//
//    public void setGeneratedFileName_vb(String generatedFileName_vb) {
//        this.generatedFileName_vb = generatedFileName_vb;
//    }
//
//    
    public Integer getAdDisplayType_vb() {
        return adDisplayType_vb;
    }

    public void setAdDisplayType_vb(Integer adDisplayType_vb) {
        this.adDisplayType_vb = adDisplayType_vb;
    }

    public Integer getAdType_vb() {
        return adType_vb;
    }

    public void setAdType_vb(Integer adType_vb) {
        this.adType_vb = adType_vb;
    }
    
    public String getContentDesc_vb() {
        return contentDesc_vb;
    }

    public void setContentDesc_vb(String contentDesc_vb) {
        this.contentDesc_vb = contentDesc_vb;
    }

    public String getCreatedOn_vb() {
        return createdOn_vb;
    }

    public void setCreatedOn_vb(String createdOn_vb) {
        this.createdOn_vb = createdOn_vb;
    }

    public String getStatus_vb() {
        return status_vb;
    }

    public void setStatus_vb(String status_vb) {
        this.status_vb = status_vb;
    }

    public String getActiveDate_vb() {
        return activeDate_vb;
    }

    public void setActiveDate_vb(String activeDate_vb) {
        this.activeDate_vb = activeDate_vb;
    }

    public MultipartFile getInputFile01_vb() {
        return inputFile01_vb;
    }

    public void setInputFile01_vb(MultipartFile inputFile01_vb) {
        this.inputFile01_vb = inputFile01_vb;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getSelectedCategoryList_vb() {
        return selectedCategoryList_vb;
    }

    public void setSelectedCategoryList_vb(String selectedCategoryList_vb) {
        this.selectedCategoryList_vb = selectedCategoryList_vb;
    }

    public String getContentName_vb() {
        return contentName_vb;
    }

    public void setContentName_vb(String contentName_vb) {
        this.contentName_vb = contentName_vb;
    }

    public String getPrice_vb() {
        return price_vb;
    }

    public void setPrice_vb(String price_vb) {
        this.price_vb = price_vb;
    }

    public String getQnttyUnit_vb() {
        return qnttyUnit_vb;
    }

    public void setQnttyUnit_vb(String qnttyUnit_vb) {
        this.qnttyUnit_vb = qnttyUnit_vb;
    }

    public String getTotalQntty_vb() {
        return totalQntty_vb;
    }

    public void setTotalQntty_vb(String totalQntty_vb) {
        this.totalQntty_vb = totalQntty_vb;
    }

    public String getTaxPercent_vb() {
        return taxPercent_vb;
    }

    public void setTaxPercent_vb(String taxPercent_vb) {
        this.taxPercent_vb = taxPercent_vb;
    }

    public String getTaxDetails_vb() {
        return taxDetails_vb;
    }

    public void setTaxDetails_vb(String taxDetails_vb) {
        this.taxDetails_vb = taxDetails_vb;
    }
    
}

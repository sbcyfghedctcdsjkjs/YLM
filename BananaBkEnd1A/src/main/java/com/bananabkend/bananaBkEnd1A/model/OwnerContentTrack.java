/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sunjiv6
 */
//@Entity
public class OwnerContentTrack {

    public OwnerContentTrack() {
    }
    
    
    
    private Long id;
    
    private Long ownerUserId;
    private Long contentId;
    private String contentCreatedDate;    
    private String contentDuration;
    //Edit modified count
    private Integer contentEditCount;
    
    
    private Integer activeContentCount;
    
    private Integer inActiveContentCount;

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

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getContentCreatedDate() {
        return contentCreatedDate;
    }

    public void setContentCreatedDate(String contentCreatedDate) {
        this.contentCreatedDate = contentCreatedDate;
    }

    public String getContentDuration() {
        return contentDuration;
    }

    public void setContentDuration(String contentDuration) {
        this.contentDuration = contentDuration;
    }

    public Integer getContentEditCount() {
        return contentEditCount;
    }

    public void setContentEditCount(Integer contentEditCount) {
        this.contentEditCount = contentEditCount;
    }

    public Integer getActiveContentCount() {
        return activeContentCount;
    }

    public void setActiveContentCount(Integer activeContentCount) {
        this.activeContentCount = activeContentCount;
    }

    public Integer getInActiveContentCount() {
        return inActiveContentCount;
    }

    public void setInActiveContentCount(Integer inActiveContentCount) {
        this.inActiveContentCount = inActiveContentCount;
    }

        
  
   
}

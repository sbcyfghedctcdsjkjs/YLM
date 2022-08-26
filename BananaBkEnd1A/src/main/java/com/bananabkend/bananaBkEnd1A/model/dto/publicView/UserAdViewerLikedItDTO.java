/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.model.dto.publicView;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;

/**
 *
 * @author sunjiv6
 */
public class UserAdViewerLikedItDTO {
    
    private String id;
    
    //userAdViewerId from UserAdViewer table
    private String userId;
        
    //OwnerContentId from OwnerContent table
    private String contentId;    
    
    private String liked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getLiked() {
        return liked;
    }

    public void setLiked(String liked) {
        this.liked = liked;
    }
    

    
    
}

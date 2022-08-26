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


/**
 *
 * @author sunjiv6
 */
@Entity
public class UserAdViewerLikedIt {

    public UserAdViewerLikedIt() {
    }
    
    public UserAdViewerLikedIt(Long userAdViewerId) {
        this.userAdViewerId=userAdViewerId;
    }

//    public UserAdViewerLikedIt(Long ownerContentId) {
//        this.ownerContentId=ownerContentId;
//    }
    
    public UserAdViewerLikedIt(Long id,String allLikedIds,Long userAdViewerId) {
        this.id=id;
        this.allLikedIds=allLikedIds;
        this.userAdViewerId=userAdViewerId;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "System generated unique id of the Employee",name="id",required=false,value="-1") 
    private Long id;
    
    //userAdViewerId from UserAdViewer table
    @ApiModelProperty(notes = "System generated unique id of the UserOwner",name="id",required=true,value="-1") 
    private Long userAdViewerId;
        
    //OwnerContentId from OwnerContent table
//    @ApiModelProperty(notes = "System generated unique id of the UserOwner",name="id",required=true,value="-1") 
//    private Long ownerContentId;
//    
//    @ApiModelProperty(notes = "System generated unique id of the UserOwner",name="id",required=true,value="-1") 
//    
//    
//    @Column(length=1)
//    private String likedStatus;
//    
    @Column(length=1000)
    private String allLikedIds;
    
    public Long getUserAdViewerId() {
        return userAdViewerId;
    }

    public void setUserAdViewerId(Long userAdViewerId) {
        this.userAdViewerId = userAdViewerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAllLikedIds() {
        return allLikedIds;
    }

    public void setAllLikedIds(String allLikedIds) {
        this.allLikedIds = allLikedIds;
    }
    
    
    
}

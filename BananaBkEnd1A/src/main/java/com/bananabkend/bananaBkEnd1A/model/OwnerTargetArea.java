/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

/**
 *
 * @author sunjiv6
 */
@Entity
public class OwnerTargetArea {

    public OwnerTargetArea() {
    }

    public OwnerTargetArea(Long id) {
        this.id=id;
    }
    
    public OwnerTargetArea(Long id,ArrayList target,Long userOwnerId) {
        this.id=id;
        this.target=target;
        this.userOwnerId=userOwnerId;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "System generated unique id of the OwnerTargetArea",name="id",required=true,value="-1") 
    private Long id;
    
    private Long userOwnerId;
    
    //@Column(columnDefinition="Clob")
    @Column(length=20)
    private ArrayList target;
    
    //@Column(columnDefinition="Clob")
    @Column(length=1000)
    private String allTargets;
    
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
    private Integer countRecordFound;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserOwnerId() {
        return userOwnerId;
    }

    public void setUserOwnerId(Long userOwnerId) {
        this.userOwnerId = userOwnerId;
    }

    public ArrayList getTarget() {
        return target;
    }

    public void setTarget(ArrayList target) {
        this.target = target;
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

    public String getAllTargets() {
        return allTargets;
    }

    public void setAllTargets(String allTargets) {
        this.allTargets = allTargets;
    }

    public Integer getCountRecordFound() {
        return countRecordFound;
    }

    public void setCountRecordFound(Integer countRecordFound) {
        this.countRecordFound = countRecordFound;
    }
    
    
}

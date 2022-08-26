/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.model.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author sunjiv6
 */
public class TargetAreaDto {
    
    public TargetAreaDto() {
    }

    private String id_vb;
    
    private Long userOwnerId_vb;
    
    private ArrayList target_vb;
    
    private String allTargets_vb;
    
    private String ownerPhone_vb;
    
    private String ownerEmail_vb;
    
    private String secretNumber_vb;

    public String getId_vb() {
        return id_vb;
    }

    public void setId_vb(String id_vb) {
        this.id_vb = id_vb;
    }

    public Long getUserOwnerId_vb() {
        return userOwnerId_vb;
    }

    public void setUserOwnerId_vb(Long userOwnerId_vb) {
        this.userOwnerId_vb = userOwnerId_vb;
    }

    public ArrayList getTarget_vb() {
        return target_vb;
    }

    public void setTarget_vb(ArrayList target_vb) {
        this.target_vb = target_vb;
    }

    public String getAllTargets_vb() {
        return allTargets_vb;
    }

    public void setAllTargets_vb(String allTargets_vb) {
        this.allTargets_vb = allTargets_vb;
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
    
    

}

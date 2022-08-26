/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;

import com.bananabkend.bananaBkEnd1A.model.OwnerTargetArea;
import java.util.ArrayList;

/**
 *
 * @author sunjiv6
 */
public interface OwnerTargetService {
    
    OwnerTargetArea saveTargetArea(OwnerTargetArea ownerTargetArea) throws Exception;
    ArrayList<OwnerTargetArea> getAllRecords() throws Exception;
    OwnerTargetArea getOneRecord() throws Exception;
    OwnerTargetArea getTargetAreaForSingleOwner(Long userOwnerId) throws Exception;
    OwnerTargetArea getTargetIdForOwnerUserId(Long userOwnerId) throws Exception;
    Integer recordsCount(String address) throws Exception; 
}
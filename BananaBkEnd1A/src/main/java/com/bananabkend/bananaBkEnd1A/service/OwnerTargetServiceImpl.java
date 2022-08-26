/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;

import com.bananabkend.bananaBkEnd1A.model.OwnerTargetArea;
import com.bananabkend.bananaBkEnd1A.repository.OwnerTargetAreaRepo;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sunjiv6
 */
@Service
@Transactional
public class OwnerTargetServiceImpl implements OwnerTargetService{
    
    private OwnerTargetAreaRepo ownerTargetAreaRepo;
    
    public OwnerTargetServiceImpl(OwnerTargetAreaRepo  ownerTargetAreaRepo) {
        this.ownerTargetAreaRepo = ownerTargetAreaRepo;
    }

    @Override
    public OwnerTargetArea saveTargetArea(OwnerTargetArea ownerTargetArea) throws Exception {
       return this.ownerTargetAreaRepo.save(ownerTargetArea);
    }

    @Override
    public ArrayList<OwnerTargetArea> getAllRecords() throws Exception {
        return this.ownerTargetAreaRepo.getAllRecords();
    }
    
    
    @Override
    public OwnerTargetArea getOneRecord() throws Exception {
        return this.ownerTargetAreaRepo.getOneRecordIdis1();
    }

    @Override
    public OwnerTargetArea getTargetAreaForSingleOwner(Long userOwnerId) throws Exception {
       return this.ownerTargetAreaRepo.getAreasForOneOwnerId(userOwnerId);
    }

    @Override
    public OwnerTargetArea getTargetIdForOwnerUserId(Long userOwnerId) throws Exception {
        return this.ownerTargetAreaRepo.getTargetIdForUserOwnerId(userOwnerId);
    }
    
    @Override
    public Integer recordsCount(String address) throws Exception {
        String p1="% "+address+"";
        String p2=""+address+" %";
        String p3="% "+address+" %";
        String p4="%,"+address+"";
        String p5=""+address+",%";
        String p6="%,"+address+",%";
        
        return this.ownerTargetAreaRepo.activeAdsRecordsCount(p1,p2,p3,p4,p5,p6,"Y");
    }

}

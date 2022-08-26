/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.repository;

import com.bananabkend.bananaBkEnd1A.model.OwnerTargetArea;
import com.bananabkend.bananaBkEnd1A.model.OwnerContent;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author sunjiv6
 */
public interface OwnerTargetAreaRepo  extends CrudRepository<OwnerTargetArea, Long> {
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.OwnerTargetArea(t.id,t.target,t.userOwnerId) from OwnerTargetArea t where t.id=1")
    public ArrayList<OwnerTargetArea>  getAllRecords();
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.OwnerTargetArea(t.id,t.target,t.userOwnerId) from OwnerTargetArea t where t.id=1L")
    public OwnerTargetArea getOneRecordIdis1();    
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.OwnerTargetArea(t.id,t.target,t.userOwnerId) from OwnerTargetArea t "
            + "where t.userOwnerId=?1")
    public OwnerTargetArea getAreasForOneOwnerId(Long userOwnerId);
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.OwnerTargetArea(t.id) from OwnerTargetArea t where t.userOwnerId=?1")
    public OwnerTargetArea getTargetIdForUserOwnerId(Long userOwnerId);  

    
    @Query("select count(*) from OwnerTargetArea t,OwnerContent c where "
            +  " t.userOwnerId =c.ownerUserId and "
            +  " c.status = ?7 and ("
            +  " t.allTargets like ?1" 
            +  " or t.allTargets like ?2" 
            +  " or t.allTargets like ?3" 
            +  " or t.allTargets like ?4" 
            +  " or t.allTargets like ?5" 
            +  " or t.allTargets like ?6)")
    public Integer activeAdsRecordsCount(String p1,String p2,String p3,String p4,String p5,String p6,String status);
    
    
    @Query("select count(*) from OwnerTargetArea t where "
            +  "t.allTargets like ?1" 
            +  " or t.allTargets like ?2" 
            +  " or t.allTargets like ?3" 
            +  " or t.allTargets like ?4" 
            +  " or t.allTargets like ?5" 
            +  " or t.allTargets like ?6")
    public Integer recordsCount(String p1,String p2,String p3,String p4,String p5,String p6); //working
    
    
    @Query("select count(*) from OwnerTargetArea t where "
            +  "t.allTargets like '% ?1'" 
            +  " or t.allTargets like '?1 %'" 
            +  " or t.allTargets like '% ?1 %'" 
            +  " or t.allTargets like '%,?1'" 
            +  " or t.allTargets like '?1,%'" 
            +  " or t.allTargets like '%,?1'")
    public Integer recordsCountNO(String address); //NOT Working
    
    
    
    
    
    @Query("select 1 from OwnerTargetArea t where "
            +  "t.allTargets like ?1")
    public Integer recordsCount1(String address); //working
    
    
    
    @Query("select 'DOG 500' from OwnerContent t where "
            +  "t.contentDesc like ?1")
    public String recordsCount2(String address);//working 
    
    
    
    @Query("select 'DOG 500' from OwnerContent t where "
            +  "t.contentDesc like ?1")
    public String recordsCount23(String address);//Working
    
    
    @Query("select 'DOG 500' from OwnerContent t where "
            +  "t.contentDesc = ?1")
    public String recordsCount22(String address);//Working
    
    @Query("select 'DOG 500' from OwnerContent t where "
            +  "t.contentDesc like ?1")
    public String recordsCount21(String address);//Working
    
    @Query("select 'Y' from OwnerContent t where "
            +  "t.status = ?1")
    public String recordsCount3(String address);
    
}
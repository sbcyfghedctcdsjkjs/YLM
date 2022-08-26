/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.repository;

import com.bananabkend.bananaBkEnd1A.model.SecurityApi;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author sunjiv6
 */
public interface SecurityApiRepo extends CrudRepository<SecurityApi, Long>{

    @Query("select new com.bananabkend.bananaBkEnd1A.model.SecurityApi(s.id,s.apikey,s.updatedOn,"
            + " s.viewerUserId,s.uriAccessed, s.createdOn,"
            + " s.registerCnt "
            + ") from SecurityApi s "
            + " WHERE s.apikey=?1 ")
    public SecurityApi getApiKeyRecordWithApiKey(String apikey);
    
        @Query("select count(*) from SecurityApi  "
            + "  ")
    public Long getTotalRowsCount();
    
    
    @Query("select Sum(registerCnt) from SecurityApi  "
            + "  ")
    public Integer getTotalRegistrationCount();
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.SecurityApi(s.id,s.apikey,s.updatedOn,"
            + " s.viewerUserId,s.uriAccessed, s.createdOn,"
            + " s.registerCnt "
            + ") from SecurityApi s "
            + " order by s.id desc")
    public ArrayList<SecurityApi> getTopNRows_NOTWORKING();
    
    
   
}

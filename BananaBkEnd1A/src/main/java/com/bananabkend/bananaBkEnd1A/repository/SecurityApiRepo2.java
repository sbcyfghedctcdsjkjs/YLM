/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.repository;

import com.bananabkend.bananaBkEnd1A.model.SecurityApi;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.jpa.QueryHints;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bunsiv
 */
@Repository
public class SecurityApiRepo2 {
    private EntityManager entityManager;
        
        
    public SecurityApiRepo2(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
     public List<SecurityApi> getTopNRows(){
         
         String qryStr="select new com.bananabkend.bananaBkEnd1A.model.SecurityApi(s.id,s.apikey,s.updatedOn,"
            + " s.viewerUserId,s.uriAccessed, s.createdOn,"
            + " s.registerCnt "
            + ")  from SecurityApi s order by s.id desc"; 
         Query query = entityManager.createQuery(qryStr);
        
        
        query.setFirstResult(0); 
        query.setMaxResults(10);
        query.setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, true);  
        List list = query.getResultList();
        return list;
     }
}

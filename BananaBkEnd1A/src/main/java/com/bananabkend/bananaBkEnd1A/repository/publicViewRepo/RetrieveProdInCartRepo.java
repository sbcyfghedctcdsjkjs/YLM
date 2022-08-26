/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.repository.publicViewRepo;

import com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent;
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
public class RetrieveProdInCartRepo {
    private EntityManager entityManager;
    
    
    public RetrieveProdInCartRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    


    public List<RetrieveAdsContent> getContentForMultipleIds(String commaSeparatedIds)
    {
        String status="Y";
	String qryStr1= "select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent(c.id,c.contentDesc,"
            +  "c.uploadedFileName,c.adType,c.createdOn,c.adDisplayType,c.activeDate,"+0+",p.price,p.unitDetail,c.contentName) "                
            +  " from OwnerContent c, Pricing p where "
            +  " c.id = p.ownerContentId and "    
            +  " c.id in ("+commaSeparatedIds+") and "
            +  " c.status = '"+status+"'";

        System.out.println("<<<<<<<<< Searching >>>>>>> "+qryStr1);
                
        String qryStr= "select distinct new com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent(c.id,c.contentDesc,"
            +  "c.uploadedFileName,c.adType,c.createdOn,c.adDisplayType,c.activeDate,"+0+",p.price,p.unitDetail,c.contentName) "                
            +  " from OwnerContent c, Pricing p where "
            +  " c.id = p.ownerContentId and "    
            +  " c.id in ("+commaSeparatedIds+") and "
            +  " c.status = :status"+" and "
            +  " p.status = :status";
        
      	Query query = entityManager.createQuery(qryStr);
        query.setParameter("status", status);
        
        query.setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, true);        
        List list = query.getResultList();
        return list;
    }
}

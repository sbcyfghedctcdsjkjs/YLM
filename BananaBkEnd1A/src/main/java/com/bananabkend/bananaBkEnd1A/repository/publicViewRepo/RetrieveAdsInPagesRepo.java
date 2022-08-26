/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.repository.publicViewRepo;

import com.bananabkend.bananaBkEnd1A.model.OwnerContent;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.jpa.QueryHints;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sunjiv6
 */
@Repository
public class RetrieveAdsInPagesRepo {

    private EntityManager entityManager;
 
//    @Override
//    public List<Passenger> findOrderedBySeatNumberLimitedTo(int limit) {
//        return entityManager.createQuery("SELECT p FROM Passenger p ORDER BY p.seatNumber",
//          Passenger.class).setMaxResults(limit).getResultList();
//    }

    public RetrieveAdsInPagesRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public List<RetrieveAdsContent> getAdsInPages(int pageNumber,int pageSize,String address,String adType,String prodOrBznzType)
    {
        String p1="% "+address+"";
        String p2=""+address+" %";
        String p3="% "+address+" %";
        String p4="%,"+address+"";
        String p5=""+address+",%";
        String p6="%,"+address+",%";
        String status="Y";
        
	String qryStr1= "select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent(c.id,c.contentDesc,"
            +  "c.uploadedFileName,c.adType,c.createdOn,c.adDisplayType,c.activeDate,"+pageNumber+",0.0,'',c.contentName) "                
            +  " from OwnerTargetArea t,OwnerContent c where "
            +  " t.userOwnerId =c.ownerUserId and "
            //+  " p.ownerContentId=c.id and p.status='Y' and "    
            +  " c.content_type = 'A' and "        
            +  " c.adType in ("+adType+") and "
            +  " c.status = '"+status+"' and ("
            +  " t.allTargets like '"+p1+"'" 
            +  " or t.allTargets like '"+p2+"'"  
            +  " or t.allTargets like '"+p3+"'" 
            +  " or t.allTargets like '"+p4+"'" 
            +  " or t.allTargets like '"+p5+"'" 
            +  " or t.allTargets like '"+p6+"' ) order by c.id desc";

	System.out.println("<<<<<<<<< Searching >>>>>>> "+qryStr1);
                
        String qryStr= "select distinct new com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent(c.id,c.contentDesc,"
            +  "c.uploadedFileName,c.adType,c.createdOn,c.adDisplayType,c.activeDate,"+pageNumber+",0.0,'',c.contentName) "                
            +  " from OwnerTargetArea t,OwnerContent c where "
            +  " t.userOwnerId =c.ownerUserId and "
//            +  " p.ownerContentId=c.id and p.status='Y' and "        
            +  " c.contentType = 'A' and "    
            +  " c.adType in ("+adType+") and "
            +  " c.status = :status and ("
            +  " t.allTargets like :p1" 
            +  " or t.allTargets like :p2" 
            +  " or t.allTargets like :p3" 
            +  " or t.allTargets like :p4" 
            +  " or t.allTargets like :p5" 
            +  " or t.allTargets like :p6) order by c.id desc";
        
      	Query query = entityManager.createQuery(qryStr);
        query.setParameter("status", status);
        query.setParameter("p1", p1);
        query.setParameter("p2", p2);
        query.setParameter("p3", p3);
        query.setParameter("p4", p4);
        query.setParameter("p5", p5);
        query.setParameter("p6", p6);
//        query.setParameter("prodOrBznzType", prodOrBznzType);        
        query.setFirstResult((pageNumber-1) * pageSize); 
        query.setMaxResults(pageSize);
        query.setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, true);  
        List list = query.getResultList();
        return list;
    }
    
    
    public List<RetrieveAdsContent> getAdsInPages1(int pageNumber,int pageSize,String address,String adType)
    {
        String p1="% "+address+"";
        String p2=""+address+" %";
        String p3="% "+address+" %";
        String p4="%,"+address+"";
        String p5=""+address+",%";
        String p6="%,"+address+",%";
        String status="Y";
        
	String qryStr1= "select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent(c.id,c.contentDesc,"
            +  "c.uploadedFileName,c.adType,c.createdOn,c.adDisplayType,c.activeDate,"+pageNumber+",0.0,'') "                
            +  " from OwnerContent c where "
            +  " c.adType in ("+adType+") and "
            +  " c.status = '"+status+"' and "
            +  " c.ownerUserId in ( "
            +  " select distinct t.userOwnerId from OwnerTargetArea t where "
            +  " t.allTargets like '"+p1+"'" 
            +  " or t.allTargets like '"+p2+"'"  
            +  " or t.allTargets like '"+p3+"'" 
            +  " or t.allTargets like '"+p4+"'" 
            +  " or t.allTargets like '"+p5+"'" 
            +  " or t.allTargets like '"+p6+"' ) order by c.id desc";

	System.out.println("<<<<<<<<< Searching >>>>>>> "+qryStr1);
                
        String qryStr= "select distinct new com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent(c.id,c.contentDesc,"
            +  "c.uploadedFileName,c.adType,c.createdOn,c.adDisplayType,c.activeDate,"+pageNumber+",0.0,'') "                
            +  " from OwnerContent c where "            
            +  " c.adType in ("+adType+") and "
            +  " c.status = :status and "
            +  " c.ownerUserId in ( "
            +  " select distinct t.userOwnerId from OwnerTargetArea t where "
            +  " t.allTargets like :p1" 
            +  " or t.allTargets like :p2" 
            +  " or t.allTargets like :p3" 
            +  " or t.allTargets like :p4" 
            +  " or t.allTargets like :p5" 
            +  " or t.allTargets like :p6) order by c.id desc";
        
      	Query query = entityManager.createQuery(qryStr);
        query.setParameter("status", status);
        query.setParameter("p1", p1);
        query.setParameter("p2", p2);
        query.setParameter("p3", p3);
        query.setParameter("p4", p4);
        query.setParameter("p5", p5);
        query.setParameter("p6", p6);
        
        query.setFirstResult((pageNumber-1) * pageSize); 
        query.setMaxResults(pageSize);
        query.setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, true);  
        List list = query.getResultList();
        return list;
    }
    
}

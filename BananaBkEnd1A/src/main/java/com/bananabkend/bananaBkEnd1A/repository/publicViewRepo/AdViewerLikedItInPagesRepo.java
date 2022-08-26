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
public class AdViewerLikedItInPagesRepo {
 private EntityManager entityManager;
 
        public AdViewerLikedItInPagesRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    
    }
    
    //ForMySQL
    public List<RetrieveAdsContent> getLikedAdsAdsInPages(int pageNumber,int pageSize,String adType,String likedIds,Long adViewerId)
    {
        
        String status="Y";
        
//        String[] catArr= selectedCategory.split(",");
//        int catLength = catArr.length > 4 ? 4 : catArr.length;
//        StringBuffer catQueryPart= new StringBuffer();
//        for (int i = 1; i < catLength; i++) {
//            if(i==1) catQueryPart.append(" and (");
//            
//            if(i>1) catQueryPart.append(" or ");
//            
//            //catQueryPart.append(" c.category like '").append("%,"+catArr[i]+",%' ");                   
//            catQueryPart.append(" c.category like '").append("%,"+catArr[i]+",%' ");
//             
//            if(i==catLength-1){
//                catQueryPart.append(") ");
//            }
//        }
               
        
	String qryStr1= "select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent(c.id,c.contentDesc,"
            +  "c.uploadedFileName,c.adType,c.createdOn,c.adDisplayType,c.activeDate,"+pageNumber+",0.0,'') "                
            +  " from UserAdViewerLikedIt u,OwnerContent c where "
            +  " u.userAdViewerId = "+adViewerId+" and "    
            +  " c.id in ( "+likedIds+" and "
            //+  " t.userOwnerId =c.ownerUserId and "
            +  " c.adType in ("+adType+") and "
            +  " c.status = '"+status+"'"
//            + " and ("
//            +  " t.allTargets like '"+p1+"'" 
//            +  " or t.allTargets like '"+p2+"'"  
//            +  " or t.allTargets like '"+p3+"'" 
//            +  " or t.allTargets like '"+p4+"'" 
//            +  " or t.allTargets like '"+p5+"'" 
//            +  " or t.allTargets like '"+p6+"' ) "
          //  +    catQueryPart.toString()    
            +  " order by c.id desc";

        /* For debug
        select c.*  
        from bana1a.owner_target_area t,bana1a.owner_content c 
        where  t.user_owner_id =c.owner_user_id and  
        c.ad_type in (1) and  
        c.status = 'Y' 
        and ( t.all_targets like '% NOIDA' or 
          t.all_targets like 'NOIDA %' or 
          t.all_targets like '% NOIDA %' or 
          t.all_targets like '%,NOIDA' or 
          t.all_targets like 'NOIDA,%' or 
          t.all_targets like '%,NOIDA,%' )  
        and ( c.category like '%,4,%' )  order by c.id desc   */
	
        System.out.println("<<<<<<<<< getLikedAdsAdsInPages >>>>>>> "+qryStr1);
        String zero="0";        
        String qryStr= "select distinct new com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent(c.id,c.contentDesc,"
            +  "c.uploadedFileName,c.adType,c.createdOn,c.adDisplayType,c.activeDate,"+pageNumber+",0.0,'') "                
            +  " from UserAdViewerLikedIt u,OwnerContent c where "
            +  " u.userAdViewerId = "+adViewerId+" and "   
            +  " c.id in ( "+likedIds+" ) and "    
           // +  " t.userOwnerId =c.ownerUserId and "
            +  " c.adType in ("+adType+") and "            
            +  " c.status = :status "
//            + "and ("
//            +  " t.allTargets like :p1" 
//            +  " or t.allTargets like :p2" 
//            +  " or t.allTargets like :p3" 
//            +  " or t.allTargets like :p4" 
//            +  " or t.allTargets like :p5" 
//            +  " or t.allTargets like :p6) "
           // +    catQueryPart.toString()
            + " order by c.id desc";
        
      	Query query = entityManager.createQuery(qryStr);
        query.setParameter("status", status);
//        query.setParameter("p1", p1);
//        query.setParameter("p2", p2);
//        query.setParameter("p3", p3);
//        query.setParameter("p4", p4);
//        query.setParameter("p5", p5);
//        query.setParameter("p6", p6);
        
        query.setFirstResult((pageNumber-1) * pageSize); 
        query.setMaxResults(pageSize);
        query.setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, true);
        List list = query.getResultList();
        return list;
    }
    
}

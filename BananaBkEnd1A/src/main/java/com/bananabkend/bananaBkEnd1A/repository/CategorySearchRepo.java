/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.repository;

import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sunjiv6
 */
@Repository
public class CategorySearchRepo {
    
     private EntityManager entityManager;
 
    public CategorySearchRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
        
    public List<AnonymousDto> findActiveCategoryByName(String name,String lang){
        String p1="% "+name+"";
        String p2=""+name+" %";
        String p3="% "+name+" %";
//        String p4="%,"+name+"";
//        String p5=""+name+",%";
//        String p6="%,"+name+",%";


        String qryStr = "select new com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto("
                        + " t.id as p13,t.categoryName_"+lang

                        + " as p2 ) "
                        + " from CategoryModel t where t.status='Y' and "
                        + " t.categoryName_"+lang+" like :p1 "
                        + " or t.categoryName_"+lang+" like :p2 "
                        + " or t.categoryName_"+lang+" like :p3 ";
        
        Query query = entityManager.createQuery(qryStr);
        query.setParameter("p1", p1);
        query.setParameter("p2", p2);        
        query.setParameter("p3", p3);
        
        List list = query.getResultList();
        return list;
    }
}
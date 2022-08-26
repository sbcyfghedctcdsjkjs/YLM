/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.repository;

import com.bananabkend.bananaBkEnd1A.model.CategoryModel;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author sunjiv6
 */


public interface CategoryRepo extends CrudRepository<CategoryModel, Object>{

    @Query("select new com.bananabkend.bananaBkEnd1A.model.CategoryModel("
            + " t.id,t.categoryName_en,t.status,t.createdOn ) "
            + " from CategoryModel t where t.status='Y'")  
    public ArrayList<CategoryModel> getAllActiveCategory();
    //Start getAll In Lang    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto("
            + " t.id as p13,t.categoryName_bn"
            + " as p2 ) "
            + " from CategoryModel t where t.status='Y'")  
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_bn();
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto("
            + " t.id as p13,t.categoryName_en"
            + " as p2 ) "
            + " from CategoryModel t where t.status='Y'")  
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_en();
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto("
            + " t.id as p13,t.categoryName_gu"
            + " as p2 ) "
            + " from CategoryModel t where t.status='Y'")  
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_gu();
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto("
            + " t.id as p13,t.categoryName_hi"
            + " as p2 ) "
            + " from CategoryModel t where t.status='Y'")  
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_hi();
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto("
            + " t.id as p13,t.categoryName_kn"
            + " as p2 ) "
            + " from CategoryModel t where t.status='Y'")  
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_kn();
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto("
        + " t.id as p13,t.categoryName_ml"
        + " as p2 ) "
        + " from CategoryModel t where t.status='Y'")  
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_ml();


    @Query("select new com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto("
        + " t.id as p13,t.categoryName_mr"
        + " as p2 ) "
        + " from CategoryModel t where t.status='Y'")  
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_mr();

    @Query("select new com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto("
        + " t.id as p13,t.categoryName_pa"
        + " as p2 ) "
        + " from CategoryModel t where t.status='Y'")  
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_pa();
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto("
        + " t.id as p13,t.categoryName_ta"
        + " as p2 ) "
        + " from CategoryModel t where t.status='Y'")  
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_ta();
    
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto("
        + " t.id as p13,t.categoryName_te"
        + " as p2 ) "
        + " from CategoryModel t where t.status='Y'")  
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_te();
    
    @Query("select new com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto("
            + " t.id as p13,t.categoryName_ur"
            + " as p2 ) "
            + " from CategoryModel t where t.status='Y'")  
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_ur();
    //End getAll In Lang    
    //Start  In Lang         
}
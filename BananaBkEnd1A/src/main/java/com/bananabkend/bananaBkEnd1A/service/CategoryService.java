/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;

import com.bananabkend.bananaBkEnd1A.model.CategoryModel;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sunjiv6
 */
public interface CategoryService {
    public CategoryModel save(CategoryModel categoryModel) throws Exception;
    //public CategoryModel getContentIdForCategory(CategoryModel categoryModel) throws Exception;
    
    
    public ArrayList<CategoryModel> getAllActiveCategory() throws Exception;
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_bn(CategoryModel categoryModel) throws Exception;
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_en(CategoryModel categoryModel) throws Exception;
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_gu(CategoryModel categoryModel) throws Exception;
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_hi(CategoryModel categoryModel) throws Exception;
    
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_kn(CategoryModel categoryModel) throws Exception;
    
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_ml(CategoryModel categoryModel) throws Exception;
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_mr(CategoryModel categoryModel) throws Exception;
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_pa(CategoryModel categoryModel) throws Exception;
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_ta(CategoryModel categoryModel) throws Exception;
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_te(CategoryModel categoryModel) throws Exception;
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_ur(CategoryModel categoryModel) throws Exception;
    
    
    public List<AnonymousDto> findActiveCategoryByName(CategoryModel categoryModel) throws Exception;
}

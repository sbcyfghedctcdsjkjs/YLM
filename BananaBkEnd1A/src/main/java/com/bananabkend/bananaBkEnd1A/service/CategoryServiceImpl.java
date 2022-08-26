/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;

import com.bananabkend.bananaBkEnd1A.model.CategoryModel;
import com.bananabkend.bananaBkEnd1A.model.dto.publicView.AnonymousDto;
import com.bananabkend.bananaBkEnd1A.repository.CategoryRepo;
import com.bananabkend.bananaBkEnd1A.repository.CategorySearchRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sunjiv6
 */


@Service 
@Transactional
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepo categoryRepo;
    private CategorySearchRepo categorySearchRepo;
    
    public CategoryServiceImpl(CategoryRepo categoryRepo,CategorySearchRepo categorySearchRepo) {
    
        this.categoryRepo= categoryRepo;        
        this.categorySearchRepo = categorySearchRepo;
    }
    
    public CategoryModel save(CategoryModel categoryModel) throws Exception{
        return categoryRepo.save(categoryModel);
    }
    
    public ArrayList<CategoryModel> getAllActiveCategory() throws Exception{
        return categoryRepo.getAllActiveCategory();
    }
    
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_bn(CategoryModel categoryModel) throws Exception{
        return categoryRepo.getAllActiveCategoryInAnoDto_bn();
    }
    
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_en(CategoryModel categoryModel) throws Exception{
        return categoryRepo.getAllActiveCategoryInAnoDto_en();
    }
    
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_gu(CategoryModel categoryModel) throws Exception{
        return categoryRepo.getAllActiveCategoryInAnoDto_gu();
    }
    
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_hi(CategoryModel categoryModel) throws Exception{
        return categoryRepo.getAllActiveCategoryInAnoDto_hi();
    }
    
    
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_kn(CategoryModel categoryModel) throws Exception{
        return categoryRepo.getAllActiveCategoryInAnoDto_kn();
    }
    
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_ml(CategoryModel categoryModel) throws Exception{
        return categoryRepo.getAllActiveCategoryInAnoDto_ml();
    }
    
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_mr(CategoryModel categoryModel) throws Exception{
        return categoryRepo.getAllActiveCategoryInAnoDto_mr();
    }
    
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_pa(CategoryModel categoryModel) throws Exception{
        return categoryRepo.getAllActiveCategoryInAnoDto_pa();
    }
    
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_ta(CategoryModel categoryModel) throws Exception{
        return categoryRepo.getAllActiveCategoryInAnoDto_ta();
    }
    
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_te(CategoryModel categoryModel) throws Exception{
        return categoryRepo.getAllActiveCategoryInAnoDto_te();
    }
    
    public ArrayList<AnonymousDto> getAllActiveCategoryInAnoDto_ur(CategoryModel categoryModel) throws Exception{
        return categoryRepo.getAllActiveCategoryInAnoDto_ur();
    }
    
    
    public List<AnonymousDto> findActiveCategoryByName(CategoryModel categoryModel) throws Exception{
        return categorySearchRepo.findActiveCategoryByName(categoryModel.getCategoryName(), categoryModel.getLang());
    }
}
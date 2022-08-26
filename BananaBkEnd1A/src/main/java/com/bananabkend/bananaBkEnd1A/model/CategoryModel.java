/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author sunjiv6
 */


@Entity
public class CategoryModel {

    public CategoryModel() {
    }
    
    public CategoryModel(Long id,String categoryName_en,String status,String createdOn) {
        this.id=id;
        this.categoryName_en=categoryName_en;
        this.status=status;
        this.createdOn=createdOn;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Transient
    private String categoryName;
    
    @Transient
    private String lang;
    
    @Column(length=80)
    private String categoryName_bn;
    
    @Column(length=80)
    private String categoryName_en;
    
    @Column(length=80)
    private String categoryName_gu;
    
    @Column(length=80)
    private String categoryName_hi;
    
    @Column(length=80)
    private String categoryName_kn;
    
    
    @Column(length=80)
    private String categoryName_ml;
    @Column(length=80)
    private String categoryName_mr;
    @Column(length=80)
    private String categoryName_pa;
    @Column(length=80)
    private String categoryName_ta;
    
    
    @Column(length=80)
    private String categoryName_te;
    
    @Column(length=80)
    private String categoryName_ur;
    
    
    @Column(length=1)
    private String status;
    
    @Column(length=20)
    private String createdOn;
    
//    @Column(length=2000)
    @Transient
    private String contentIdsWithComma;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContentIdsWithComma() {
        return contentIdsWithComma;
    }

    public void setContentIdsWithComma(String contentIdsWithComma) {
        this.contentIdsWithComma = contentIdsWithComma;
    }

    public String getCreatedOn() {
        return createdOn;
    }


    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
    
    public String getCategoryName_en() {
        return categoryName_en;
    }

    public void setCategoryName_en(String categoryName_en) {
        this.categoryName_en = categoryName_en;
    }

    public String getCategoryName_bn() {
        return categoryName_bn;
    }

    public void setCategoryName_bn(String categoryName_bn) {
        this.categoryName_bn = categoryName_bn;
    }

    public String getCategoryName_gu() {
        return categoryName_gu;
    }

    public void setCategoryName_gu(String categoryName_gu) {
        this.categoryName_gu = categoryName_gu;
    }

    public String getCategoryName_hi() {
        return categoryName_hi;
    }

    public void setCategoryName_hi(String categoryName_hi) {
        this.categoryName_hi = categoryName_hi;
    }

    public String getCategoryName_kn() {
        return categoryName_kn;
    }

    public void setCategoryName_kn(String categoryName_kn) {
        this.categoryName_kn = categoryName_kn;
    }

    public String getCategoryName_ur() {
        return categoryName_ur;
    }

    public void setCategoryName_ur(String categoryName_ur) {
        this.categoryName_ur = categoryName_ur;
    }

    public String getCategoryName_ml() {
        return categoryName_ml;
    }

    public void setCategoryName_ml(String categoryName_ml) {
        this.categoryName_ml = categoryName_ml;
    }

    public String getCategoryName_mr() {
        return categoryName_mr;
    }

    public void setCategoryName_mr(String categoryName_mr) {
        this.categoryName_mr = categoryName_mr;
    }

    public String getCategoryName_pa() {
        return categoryName_pa;
    }

    public void setCategoryName_pa(String categoryName_pa) {
        this.categoryName_pa = categoryName_pa;
    }

    public String getCategoryName_ta() {
        return categoryName_ta;
    }

    public void setCategoryName_ta(String categoryName_ta) {
        this.categoryName_ta = categoryName_ta;
    }

    public String getCategoryName_te() {
        return categoryName_te;
    }

    public void setCategoryName_te(String categoryName_te) {
        this.categoryName_te = categoryName_te;
    }

    
}

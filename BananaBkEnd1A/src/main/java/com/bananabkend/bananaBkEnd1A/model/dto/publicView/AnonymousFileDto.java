/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.model.dto.publicView;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author sunjiv6
 */
public class AnonymousFileDto {
    public AnonymousFileDto() {    }   
    public AnonymousFileDto(Long p13,String p2) {
        this.p13=p13;
    
        
        this.p2=p2;
    }   
    private String p1; 
    private String p2;
    private String p3;
    private String p4;
    private Integer p5;
    private String p6;
    private Integer p7;
    private MultipartFile p8;
    private String p10;
    private String p11;
    private String p12;
    private Long p13;
    private String p14;
    private String p15;
    private String p16;
    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public String getP4() {
        return p4;
    }

    public void setP4(String p4) {
        this.p4 = p4;
    }

    public Integer getP5() {
        return p5;
    }

    public void setP5(Integer p5) {
        this.p5 = p5;
    }

    public String getP6() {
        return p6;
    }

    public void setP6(String p6) {
        this.p6 = p6;
    }

    public Integer getP7() {
        return p7;
    }

    public void setP7(Integer p7) {
        this.p7 = p7;
    }   

    public MultipartFile getP8() {
        return p8;
    }

    public void setP8(MultipartFile p8) {
        this.p8 = p8;
    }

    public String getP10() {
        return p10;
    }

    public void setP10(String p10) {
        this.p10 = p10;
    }

    public String getP11() {
        return p11;
    }

    public void setP11(String p11) {
        this.p11 = p11;
    }

    public String getP12() {
        return p12;
    }

    public void setP12(String p12) {
        this.p12 = p12;
    }

    public Long getP13() {
        return p13;
    }

    public void setP13(Long p13) {
        this.p13 = p13;
    }    

    public String getP14() {
        return p14;
    }

    public void setP14(String p14) {
        this.p14 = p14;
    }

    public String getP15() {
        return p15;
    }

    public void setP15(String p15) {
        this.p15 = p15;
    }

    public String getP16() {
        return p16;
    }

    public void setP16(String p16) {
        this.p16 = p16;
    }
    
}
package com.bananabkend.bananaBkEnd1A.service.exception;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author sunjiv6
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequest400Exception extends RuntimeException{
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service;


import com.bananabkend.bananaBkEnd1A.model.UserOwner;
import com.bananabkend.bananaBkEnd1A.repository.UserRepository;
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
public class UserOwnerServiceImpl implements UserOwnerService{
    
    private UserRepository userRepository;

    public UserOwnerServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserOwner modifyUserCount(UserOwner userOwner) throws Exception {
        return this.userRepository.save(userOwner);
    }
    
    @Override
    public UserOwner registerNewUserByPhone(UserOwner userOwner) throws Exception{
    UserOwner userExist =  this.userRepository.findByPhoneNum(userOwner.getUserPhone());
        if (userExist!=null) {
            return null;
        }
        //lenderUser.setCreatedAt();
        //lenderUser.setSignUpDate(LocalDateTime.now().atZone(ZoneId.of("Asia/Kolkata")).toLocalDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        UserOwner newUserOwner =  this.userRepository.save(userOwner);
        return newUserOwner;
    }
    
    @Override
    public UserOwner registerNewUserByEmail(UserOwner userOwner) throws Exception{
    UserOwner userExist =  this.userRepository.findByEmail(userOwner.getUserPhone());
        if (userExist!=null) {
            return null;
        }
        //lenderUser.setCreatedAt();
        //lenderUser.setSignUpDate(LocalDateTime.now().atZone(ZoneId.of("Asia/Kolkata")).toLocalDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        UserOwner newUserOwner =  this.userRepository.save(userOwner);
        return newUserOwner;
        
    }
    
    @Override
    public Boolean userExistByPhoneAndSecretNumber(UserOwner owner) {
    
    UserOwner fetchedOwner = userRepository.findByPhoneNumAndSecretNumber(owner.getUserPhone(),owner.getSecretNumberEncoded());
    if(fetchedOwner != null) {
        if(fetchedOwner.getId()>0L) return true; 
    }
    return false;
    }
    
    @Override
    public Boolean userExistByEmailAndSecretNumber(UserOwner owner) {
    
    UserOwner fetchedOwner = userRepository.findByEmailAndSecretNumber(owner.getUserEmail(),owner.getSecretNumberEncoded());
    if(fetchedOwner != null) {
        if(fetchedOwner.getId()>0L) return true; 
    }
    return false;
    }
    
    @Override
    public List<UserOwner> getUserByPhoneAndSecretNumber(UserOwner phone) {
    List<UserOwner> userOwnerList = new ArrayList<>();
    
    UserOwner user = userRepository.findByPhoneNumAndSecretNumber(phone.getUserPhone(),phone.getSecretNumberEncoded());
    if(user != null) userOwnerList.add(user);
    return userOwnerList;
    }
    
    @Override
    public List<UserOwner> getUserByEmailAndSecretNumber(UserOwner email) {
    List<UserOwner> userOwnerList = new ArrayList<>();
    
    UserOwner user = userRepository.findByEmailAndSecretNumber(email.getUserEmail(),email.getSecretNumberEncoded());
    if(user != null) userOwnerList.add(user);
    return userOwnerList;
    }
    //List<Actor> actorsOrderedByTotalNumberOfEvents();
    //List<Actor> actorsOrderedByMaximumStreak();
}

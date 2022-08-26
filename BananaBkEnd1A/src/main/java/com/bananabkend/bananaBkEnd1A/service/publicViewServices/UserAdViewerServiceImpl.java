/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service.publicViewServices;

import com.bananabkend.bananaBkEnd1A.model.UserOwner;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bananabkend.bananaBkEnd1A.repository.publicViewRepo.UserAdViewerRepo;
import java.util.Optional;

/**
 *
 * @author sunjiv6
 */
@Service
@Transactional
public class UserAdViewerServiceImpl implements UserAdViewerService {
    
    private UserAdViewerRepo userAdViewerServiceRepo;

    public UserAdViewerServiceImpl(UserAdViewerRepo userAdViewerServiceRepo) {
        this.userAdViewerServiceRepo= userAdViewerServiceRepo;
    }
    
    
    @Override
    public UserAdViewer save(UserAdViewer userAdViewer) throws Exception {
        return this.userAdViewerServiceRepo.save(userAdViewer);
    }
    
    
    @Override
    public UserAdViewer registerNewUser(UserAdViewer userAdViewer) throws Exception{
    ArrayList<UserAdViewer> userExist =  this.userAdViewerServiceRepo.findByPhoneNumOrEmail(userAdViewer.getAdViewerPhone(),userAdViewer.getAdViewerEmail());
        if (userExist!=null && userExist.size() >0) {
            return null;
        }
        //lenderUser.setCreatedAt();
        //lenderUser.setSignUpDate(LocalDateTime.now().atZone(ZoneId.of("Asia/Kolkata")).toLocalDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        UserAdViewer newUserOwner =  this.userAdViewerServiceRepo.save(userAdViewer);
        return newUserOwner;
    }
    
    
    @Override
    public UserAdViewer registerNewUserByPhone(UserAdViewer userAdViewer) throws Exception{
    UserAdViewer userExist =  this.userAdViewerServiceRepo.findByPhoneNum(userAdViewer.getAdViewerPhone());
        if (userExist!=null) {
            return null;
        }
        //lenderUser.setCreatedAt();
        //lenderUser.setSignUpDate(LocalDateTime.now().atZone(ZoneId.of("Asia/Kolkata")).toLocalDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        UserAdViewer newUserOwner =  this.userAdViewerServiceRepo.save(userAdViewer);
        return newUserOwner;
    }
    
    @Override
    public UserAdViewer registerNewUserByEmail(UserAdViewer userAdViewer) throws Exception{
    UserAdViewer userExist =  this.userAdViewerServiceRepo.findByEmail(userAdViewer.getAdViewerPhone());
        if (userExist!=null) {
            return null;
        }
        //lenderUser.setCreatedAt();
        //lenderUser.setSignUpDate(LocalDateTime.now().atZone(ZoneId.of("Asia/Kolkata")).toLocalDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        UserAdViewer newUserOwner =  this.userAdViewerServiceRepo.save(userAdViewer);
        return newUserOwner;
    }
    
    @Override
    public Boolean userExistByPhoneAndSecretNumber(UserAdViewer userAdViewer) {
    
    UserAdViewer fetchedOwner = userAdViewerServiceRepo.findByPhoneNumAndSecretNumber(userAdViewer.getAdViewerPhone(),userAdViewer.getSecretNumber());
    if(fetchedOwner != null) {
        if(fetchedOwner.getId()>0L) return true; 
    }
    return false;
    }
    
    @Override
    public Boolean userExistByEmailAndSecretNumber(UserAdViewer userAdViewer) {
    
    UserAdViewer fetchedOwner = userAdViewerServiceRepo.findByEmailAndSecretNumber(userAdViewer.getAdViewerEmail(),userAdViewer.getSecretNumber());
    if(fetchedOwner != null) {
        if(fetchedOwner.getId()>0L) return true; 
    }
    return false;
    }
    
    @Override
    public List<UserAdViewer> getUserByPhoneAndSecretNumber(UserAdViewer userAdViewer) {
    List<UserAdViewer> userOwnerList = new ArrayList<>();
    
    UserAdViewer user = userAdViewerServiceRepo.findByPhoneNumAndSecretNumber(userAdViewer.getAdViewerPhone(),userAdViewer.getSecretNumber());
    if(user != null) userOwnerList.add(user);
    return userOwnerList;
    }
    
    @Override
    public List<UserAdViewer> getUserByEmailAndSecretNumber(UserAdViewer userAdViewer) {
    List<UserAdViewer> userOwnerList = new ArrayList<>();
    
    UserAdViewer user = userAdViewerServiceRepo.findByEmailAndSecretNumber(userAdViewer.getAdViewerEmail(),userAdViewer.getSecretNumber());
    if(user != null) userOwnerList.add(user);
    return userOwnerList;
    }
    
    @Override
    public List<UserAdViewer> getUserById(UserAdViewer userAdViewer) {
    List<UserAdViewer> userOwnerList = new ArrayList<>();
    
        Optional<UserAdViewer> user = userAdViewerServiceRepo.findById(userAdViewer.getId());
        
    if(user != null) userOwnerList.add(user.get());
    return userOwnerList;
    }
    
    @Override
    public List<UserAdViewer> getUserByPhone(UserAdViewer userAdViewer) {
    List<UserAdViewer> userOwnerList = new ArrayList<>();
    
        UserAdViewer user = userAdViewerServiceRepo.findByPhoneNum(userAdViewer.getAdViewerPhone());
        
    if(user != null) userOwnerList.add(user);
    return userOwnerList;
    }
    
    @Override
    public List<UserAdViewer> getUserByEmail(UserAdViewer userAdViewer) {
    List<UserAdViewer> userOwnerList = new ArrayList<>();
    
        UserAdViewer user = userAdViewerServiceRepo.findByEmail(userAdViewer.getAdViewerEmail());
        
    if(user != null) userOwnerList.add(user);
    return userOwnerList;
    }
    
    @Override
    public Long getUserCountByUserType(String userType) throws Exception{
        return userAdViewerServiceRepo.getUserCountByUserType(userType);        
    }
    
    @Override
    public UserAdViewer findAdminTransactionUser(UserAdViewer userAdViewer) throws Exception{
        return userAdViewerServiceRepo.findAdminTransactionUser(userAdViewer.getAdViewerEmail());        
    }
    
    @Override
    public UserAdViewer authorizeAdminTransactionUser(UserAdViewer userAdViewer) throws Exception{
        return userAdViewerServiceRepo.authorizeAdminTransactionUser(userAdViewer.getAdViewerEmail(),userAdViewer.getSecretNumber());        
    }
    
}

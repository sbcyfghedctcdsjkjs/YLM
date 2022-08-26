/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service.publicViewServices;

import com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewerLikedIt;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sunjiv6
 */



@Service
@Transactional
public interface AdViewerLikedItService {
//    List<Long>  getLikedAdsContentId(UserAdViewerLikedIt user) throws Exception;
    
    String getLikedAdsContentIdWithCommaStr(UserAdViewerLikedIt user) throws Exception;

    UserAdViewerLikedIt getLikedAdsContentIdWithComma(UserAdViewerLikedIt user) throws Exception;
   
    UserAdViewerLikedIt saveLikedAds(UserAdViewerLikedIt user) throws Exception;
    List<RetrieveAdsContent> getLikedAdsInPages(int pageNumber,int pageSize,String adType,String likedIds,Long adViewerId) ;
    List<RetrieveAdsContent> getLikedAdsInPagesByCategory(int pageNumber,int pageSize,String adType,String selectedCategory,String likedIds,Long adViewerId);
}

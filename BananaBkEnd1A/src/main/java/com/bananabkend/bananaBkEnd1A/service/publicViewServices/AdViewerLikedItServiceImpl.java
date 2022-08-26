/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.service.publicViewServices;

import com.bananabkend.bananaBkEnd1A.model.publicViewModel.RetrieveAdsContent;
import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewerLikedIt;

import com.bananabkend.bananaBkEnd1A.repository.publicViewRepo.AdViewerLikedItRepo;
import com.bananabkend.bananaBkEnd1A.repository.publicViewRepo.AdViewerLikedItInPagesByCategoryRepo;
import com.bananabkend.bananaBkEnd1A.repository.publicViewRepo.AdViewerLikedItInPagesRepo;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sunjiv6
 */
@Service
@Transactional
public class AdViewerLikedItServiceImpl implements AdViewerLikedItService{    
    private AdViewerLikedItRepo adViewerLikedItRepo;
    private AdViewerLikedItInPagesRepo adViewerLikedItInPagesRepo;
    private AdViewerLikedItInPagesByCategoryRepo adViewerLikedItInPagesByCategoryRepo;
    public AdViewerLikedItServiceImpl(AdViewerLikedItRepo adViewerLikedItRepo,
            AdViewerLikedItInPagesByCategoryRepo adViewerLikedItInPagesByCategoryRepo,
            AdViewerLikedItInPagesRepo adViewerLikedItInPagesRepo) {                
        this.adViewerLikedItRepo=adViewerLikedItRepo;
        
        this.adViewerLikedItInPagesByCategoryRepo=adViewerLikedItInPagesByCategoryRepo;
        this.adViewerLikedItInPagesRepo=adViewerLikedItInPagesRepo;
    
    }    
//    public List<Long> getLikedAdsContentId(UserAdViewerLikedIt user) throws Exception{
//        return adViewerLikedItRepo.getLikedAdsContentId(user.getUserAdViewerId());
//    }
    
    @Override
    public String getLikedAdsContentIdWithCommaStr(UserAdViewerLikedIt user) throws Exception{
        return adViewerLikedItRepo.getLikedAdsContentIdWithCommaStr(user.getUserAdViewerId());
    }
    
    @Override
    public UserAdViewerLikedIt getLikedAdsContentIdWithComma(UserAdViewerLikedIt user) throws Exception{
        return adViewerLikedItRepo.getLikedAdsContentIdWithComma(user.getUserAdViewerId());
    }

    @Override
    public UserAdViewerLikedIt saveLikedAds(UserAdViewerLikedIt user) throws Exception {
        return adViewerLikedItRepo.save(user);
    }


    @Override
    public List<RetrieveAdsContent> getLikedAdsInPages(int pageNumber,int pageSize,String adType,String likedIds,Long adViewerId) {
            return this.adViewerLikedItInPagesRepo.getLikedAdsAdsInPages(pageNumber,pageSize, adType,likedIds,adViewerId);
    }
    
    @Override
    public List<RetrieveAdsContent> getLikedAdsInPagesByCategory(int pageNumber,int pageSize,String adType,String selectedCategory,String likedIds,Long adViewerId) {
            return this.adViewerLikedItInPagesByCategoryRepo.getLikedAdsAdsInPagesByCategory(pageNumber,pageSize, adType,selectedCategory,likedIds,adViewerId);
    }
}

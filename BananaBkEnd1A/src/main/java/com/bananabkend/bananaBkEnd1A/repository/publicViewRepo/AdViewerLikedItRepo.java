/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.repository.publicViewRepo;

import com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewerLikedIt;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author sunjiv6
 */
public interface AdViewerLikedItRepo extends CrudRepository<UserAdViewerLikedIt, Long>{
    
//   @Query("select "
//            + " u.ownerContentId  "
//            + " from UserAdViewerLikedIt u where u.likedStatus='Y' and u.userAdViewerId=?1")     
//   public List<Long> getLikedAdsContentId(Long adViewerId);
   
   @Query("select "
            + " u.allLikedIds  "
            + " from UserAdViewerLikedIt u where u.userAdViewerId=?1")     
   public String getLikedAdsContentIdWithCommaStr(Long adViewerId);

   
   
   @Query("select new com.bananabkend.bananaBkEnd1A.model.publicViewModel.UserAdViewerLikedIt(u.id, "
            + " u.allLikedIds,u.userAdViewerId)  "
            + " from UserAdViewerLikedIt u where u.userAdViewerId=?1")     
   public UserAdViewerLikedIt getLikedAdsContentIdWithComma(Long adViewerId);
   
   

   
}

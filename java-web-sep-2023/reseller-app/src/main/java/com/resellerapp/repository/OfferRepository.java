package com.resellerapp.repository;

import com.resellerapp.model.entity.OfferEntity;
import com.resellerapp.model.view.OfferViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {



    List<OfferEntity> findAllBySellerId(Long id);

//    @Query("SELECT of FROM OfferEntity as of" +
//            " WHERE of.seller.id != :id")
    List<OfferEntity> findOfferEntityBySellerIdNot(@Param("id") Long id);

//    List<OfferEntity> findAllByB

//    Set<Post> findPostsByUserIdNot(Long user_id);


}

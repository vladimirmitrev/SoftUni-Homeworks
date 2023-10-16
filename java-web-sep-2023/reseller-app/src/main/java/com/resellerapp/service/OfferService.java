package com.resellerapp.service;

import com.resellerapp.model.entity.OfferEntity;
import com.resellerapp.model.service.OfferServiceModel;
import com.resellerapp.model.view.OfferViewModel;
import com.resellerapp.model.view.OfferViewOthersModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface OfferService {
    void addOffer(OfferServiceModel offerServiceModel);

    List<OfferViewOthersModel> findAllOtherOffers(Long id);

    List<OfferViewModel> findMyOffers(Long id);

    void removeOfferById(Long id);

    void buyItemWithId(Long offerId, Long userId);

    List<OfferEntity> getAllBoughtOffers(Long id);
}

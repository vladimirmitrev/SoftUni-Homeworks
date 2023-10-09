package com.softuni.mobilele.service;

import com.softuni.mobilele.model.dto.offer.AddOfferDTO;
import com.softuni.mobilele.model.dto.brand.BrandDTO;
import com.softuni.mobilele.model.dto.offer.CardListingOfferDTO;

import java.util.List;

public interface OfferService {

    public List<BrandDTO> getAllBrands();
   public void addOffer(AddOfferDTO addOfferDTO);
//    UUID createOffer(CreateOfferDTO createOfferDTO);
    public List<CardListingOfferDTO> findOfferByOfferName(String query);
}

package com.softuni.mobilele.service;

import com.softuni.mobilele.model.dto.AddOfferDTO;
import com.softuni.mobilele.model.dto.CreateOfferDTO;

import java.util.UUID;

public interface OfferService {

   public void addOffer(AddOfferDTO addOfferDTO);
    UUID createOffer(CreateOfferDTO createOfferDTO);
}

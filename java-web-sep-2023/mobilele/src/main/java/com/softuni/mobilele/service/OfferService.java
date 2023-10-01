package com.softuni.mobilele.service;

import com.softuni.mobilele.model.dto.AddOfferDTO;
import com.softuni.mobilele.model.dto.BrandDTO;
import com.softuni.mobilele.model.dto.CreateOfferDTO;

import java.util.List;
import java.util.UUID;

public interface OfferService {

    public List<BrandDTO> getAllBrands();
   public void addOffer(AddOfferDTO addOfferDTO);
    UUID createOffer(CreateOfferDTO createOfferDTO);
}

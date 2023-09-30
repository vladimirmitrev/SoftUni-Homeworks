package com.softuni.mobilele.service.impl;

import com.softuni.mobilele.model.dto.CreateOfferDTO;
import com.softuni.mobilele.repository.OfferRepository;
import com.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {
        //Todo: create offer

        throw new UnsupportedOperationException("Coming soon!");
    }
}

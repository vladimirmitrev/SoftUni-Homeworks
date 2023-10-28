package com.softuni.mobilele.service;

import com.softuni.mobilele.model.dto.offer.AddOfferDTO;
import com.softuni.mobilele.model.dto.brand.BrandDTO;
import com.softuni.mobilele.model.dto.offer.OfferDetailDTO;
import com.softuni.mobilele.model.dto.offer.SearchOfferDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OfferService {

    public List<BrandDTO> getAllBrands();
   public void addOffer(AddOfferDTO addOfferDTO, UserDetails userDetails);
//    UUID createOffer(CreateOfferDTO createOfferDTO);
    public Page<OfferDetailDTO> getAllOffers(Pageable pageable);
    public List<OfferDetailDTO> searchOffer(SearchOfferDTO searchOfferDTO);
    public Optional<OfferDetailDTO> findOfferByUUID(UUID offerId);
    void deleteOfferById(UUID offerId);
    boolean isOwner(String userName, UUID offerId);
}

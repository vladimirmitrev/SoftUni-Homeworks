package com.softuni.mobilele.service.impl;

import com.softuni.mobilele.model.dto.offer.*;
import com.softuni.mobilele.model.dto.brand.BrandDTO;
import com.softuni.mobilele.model.dto.model.ModelDTO;
import com.softuni.mobilele.model.entity.BrandEntity;
import com.softuni.mobilele.model.entity.ModelEntity;
import com.softuni.mobilele.model.entity.OfferEntity;
import com.softuni.mobilele.model.entity.UserEntity;
import com.softuni.mobilele.model.mapper.OfferMapper;
import com.softuni.mobilele.repository.BrandRepository;
import com.softuni.mobilele.repository.ModelRepository;
import com.softuni.mobilele.repository.OfferRepository;
import com.softuni.mobilele.repository.UserRepository;
import com.softuni.mobilele.service.OfferService;
import com.softuni.mobilele.util.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final BrandRepository brandRepository;
    private final OfferMapper offerMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelRepository modelRepository;

    public OfferServiceImpl(OfferRepository offerRepository, BrandRepository brandRepository, OfferMapper offerMapper, UserRepository userRepository, CurrentUser currentUser, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.brandRepository = brandRepository;
        this.offerMapper = offerMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelRepository = modelRepository;
    }


    @Override
    public List<BrandDTO> getAllBrands() {

        return brandRepository.findAll()
                .stream()
                .map(this::mapBrand)
                .collect(Collectors.toList());
    }

    private BrandDTO mapBrand(BrandEntity brandEntity) {

        List<ModelDTO> models = brandEntity
                .getModels()
                .stream()
                .map(this::mapModel)
                .collect(Collectors.toList());

        BrandDTO result = new BrandDTO();
        result.setModels(models);
        result.setName(brandEntity.getName());

        return result;
    }

    private ModelDTO mapModel(ModelEntity modelEntity) {

        ModelDTO result = new ModelDTO();
        result.setId(modelEntity.getId());
        result.setName(modelEntity.getName());

        return result;
    }

    @Override
    public void addOffer(AddOfferDTO addOfferDTO) {
        OfferEntity newOffer = offerMapper.addOfferDtoToOfferEntity(addOfferDTO);

        //Todo - check if logged user

        UserEntity seller = userRepository
                .findByEmail(currentUser.getEmail())
                .orElseThrow();


        ModelEntity model = modelRepository
                .findById(addOfferDTO.getModelId())
                .orElseThrow();

        newOffer.setModel(model);
        newOffer.setSeller(seller);

        offerRepository.save(newOffer);
    }

    public List<CardListingOfferDTO> findOfferByOfferName(String query) {
        return this.offerRepository
                .findAllByModel_NameContains(query)
                .stream()
                .map(offerMapper::offerEntityToCardListingOfferDto)
                .toList();
    }

//    @Override
//    public UUID createOffer(CreateOfferDTO createOfferDTO) {
//        //Todo: create offer
//
//        throw new UnsupportedOperationException("Coming soon!");
//    }
}

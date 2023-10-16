package com.resellerapp.service.impl;

import com.resellerapp.model.entity.OfferEntity;
import com.resellerapp.model.entity.UserEntity;
import com.resellerapp.model.service.OfferServiceModel;
import com.resellerapp.model.view.OfferBoughtViewModel;
import com.resellerapp.model.view.OfferViewModel;
import com.resellerapp.model.view.OfferViewOthersModel;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.service.ConditionService;
import com.resellerapp.service.OfferService;
import com.resellerapp.service.UserService;
import com.resellerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ConditionService conditionService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ConditionService conditionService, UserService userService, CurrentUser currentUser) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.conditionService = conditionService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public void addOffer(OfferServiceModel offerServiceModel) {

        OfferEntity offerEntity = modelMapper.map(offerServiceModel, OfferEntity.class);

        offerEntity
                .setCondition(conditionService.findByConditionNameEnum(offerServiceModel.getCondition()));
        offerEntity
                .setSeller(userService
                        .findById(currentUser.getId())
                        .orElse(null));

        offerRepository.save(offerEntity);

    }

    @Override
    public List<OfferViewOthersModel> findAllOtherOffers(Long id) {

        return offerRepository
                .findOfferEntityBySellerIdNot(currentUser.getId())
                .stream()
                .map(offerEntity -> {
                    OfferViewOthersModel offerViewOthersModel = new OfferViewOthersModel();

                    offerViewOthersModel.setId(offerEntity.getId());
                    offerViewOthersModel.setUsername(offerEntity.getSeller().getUsername());
                    offerViewOthersModel.setDescription(offerEntity.getDescription());
                    offerViewOthersModel.setPrice(offerEntity.getPrice());
                    offerViewOthersModel.setConditionNameEnum(offerEntity.getCondition().getConditionNameEnum());

//                    modelMapper.map(offerEntity, OfferViewOthersModel.class);

                    return offerViewOthersModel;
                })
                .collect(Collectors.toList());
    };

    @Override
    public List<OfferViewModel> findMyOffers(Long id) {

        return offerRepository
                .findAllBySellerId(currentUser.getId())
                .stream()
                .map(offerEntity -> modelMapper.map(offerEntity, OfferViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void removeOfferById(Long id) {
        offerRepository.deleteById(id);
    }

    @Override
    public void buyItemWithId(Long offerId, Long userId) {

        OfferEntity offer = offerRepository
                .findById(offerId)
                .orElse(null);

        UserEntity user = userService
                .findUserById(userId)
                .orElse(null);

        if (offer != null) {
            offer.setSeller(user);
        }
        if (user != null) {
            user.getBoughtOffers().add(offer);
        }

        offerRepository.save(offer);
    }

    @Override
    public List<OfferEntity> getAllBoughtOffers(Long userId) {

        UserEntity user = userService
                .findUserById(userId)
                .orElse(null);

        List<OfferEntity> offers =  user.getBoughtOffers();

        return offers;
    }
}

package com.softuni.mobilele.service.impl;

import com.softuni.mobilele.model.dto.offer.*;
import com.softuni.mobilele.model.dto.brand.BrandDTO;
import com.softuni.mobilele.model.dto.model.ModelDTO;
import com.softuni.mobilele.model.entity.BrandEntity;
import com.softuni.mobilele.model.entity.ModelEntity;
import com.softuni.mobilele.model.entity.OfferEntity;
import com.softuni.mobilele.model.entity.UserEntity;
import com.softuni.mobilele.model.enums.UserRoleEnum;
import com.softuni.mobilele.model.mapper.OfferMapper;
import com.softuni.mobilele.repository.*;
import com.softuni.mobilele.service.OfferService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final BrandRepository brandRepository;
    private final OfferMapper offerMapper;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;

    public OfferServiceImpl(OfferRepository offerRepository, BrandRepository brandRepository,
                            OfferMapper offerMapper, UserRepository userRepository,
                            ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.brandRepository = brandRepository;
        this.offerMapper = offerMapper;
        this.userRepository = userRepository;
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
    public Page<OfferDetailDTO> getAllOffers(Pageable pageable) {
        return offerRepository
                .findAll(pageable)
                .map(offerMapper::offerEntityToOfferDetailDto);
    }


    @Override
    public void addOffer(CreateOrUpdateOfferDTO createOrUpdateOfferDTO, UserDetails userDetails) {
        OfferEntity newOffer = offerMapper.createOrUpdateOfferDtoToOfferEntity(createOrUpdateOfferDTO);

        //Todo - check if logged user

        UserEntity seller = userRepository
                .findByEmail(userDetails.getUsername())
                .orElseThrow();


        ModelEntity model = modelRepository
                .findById(createOrUpdateOfferDTO.getModelId())
                .orElseThrow();

        newOffer.setModel(model);
        newOffer.setSeller(seller);

        offerRepository.save(newOffer);
    }

    @Override
    public List<OfferDetailDTO> searchOffer(SearchOfferDTO searchOfferDTO) {

        Specification<OfferEntity> offerEntitySpecification = new OfferSpecification(searchOfferDTO);

        List<OfferDetailDTO> offerDetailDTOList = this.offerRepository
                .findAll(offerEntitySpecification)
                .stream().map(offer -> offerMapper.offerEntityToOfferDetailDto(offer)).
                toList();

        return offerDetailDTOList;
    }

    @Override
    public Optional<OfferDetailDTO> findOfferByUUID(UUID offerId) {
        return offerRepository
                .findById(offerId)
                .map(offerMapper::offerEntityToOfferDetailDto);
    }

    @Override
    public void deleteOfferById(UUID offerId) {

        offerRepository.deleteById(offerId);
    }

    @Override
    public boolean isOwner(String userName, UUID offerId) {
        boolean isOwner = offerRepository
                .findById(offerId)
                .filter(o -> o.getSeller().getEmail().equals(userName))
                .isPresent();

        if (isOwner) {
            return true;
        }

        return userRepository.findByEmail(userName)
                .filter(this::isAdmin)
                .isPresent();
    }

    @Override
    public Optional<CreateOrUpdateOfferDTO> getOfferEditDetails(UUID offerId) {
        return offerRepository.findById(offerId)
                .map(offerMapper::offerEntityToCreateOrUpdateOfferDtoTo);
    }

    private boolean isAdmin(UserEntity user) {

        return user.getUserRoles()
                .stream()
                .anyMatch(r -> r.getUserRole() == UserRoleEnum.ADMIN);
    }

//    @Override
//    public UUID createOffer(CreateOfferDTO createOfferDTO) {
//        //Todo: create offer
//
//        throw new UnsupportedOperationException("Coming soon!");
//    }
}

package com.softuni.mobilele.model.mapper;

import com.softuni.mobilele.model.dto.offer.AddOfferDTO;
import com.softuni.mobilele.model.dto.offer.OfferDetailDTO;
import com.softuni.mobilele.model.entity.OfferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    OfferEntity addOfferDtoToOfferEntity(AddOfferDTO addOfferDTO);

    @Mapping(source = "model.name", target = "model")
    @Mapping(source = "model.brand.name", target = "brand")
    OfferDetailDTO offerEntityToOfferDetailDto(OfferEntity offerEntity);

}

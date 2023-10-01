package com.softuni.mobilele.model.mapper;

import com.softuni.mobilele.model.dto.AddOfferDTO;
import com.softuni.mobilele.model.entity.OfferEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    OfferEntity addOfferDtoToOfferEntity(AddOfferDTO addOfferDTO);
}

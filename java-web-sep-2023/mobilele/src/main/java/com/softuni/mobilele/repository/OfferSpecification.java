package com.softuni.mobilele.repository;

import com.softuni.mobilele.model.dto.offer.SearchOfferDTO;
import com.softuni.mobilele.model.entity.OfferEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.domain.Specification;

public class OfferSpecification implements Specification<OfferEntity>{

    private final SearchOfferDTO searchOfferDTO;

    public OfferSpecification(SearchOfferDTO searchOfferDTO) {
        this.searchOfferDTO = searchOfferDTO;
    }

    @Override
    public Predicate toPredicate(@NotNull Root<OfferEntity> root,
                                 @NotNull CriteriaQuery<?> query,
                                 CriteriaBuilder cb) {
        Predicate p = cb.conjunction();

        if (searchOfferDTO.getModel() != null && !searchOfferDTO.getModel().isEmpty()) {
            p.getExpressions().add(
                    cb.and(cb.equal(root.join("model").get("name"), searchOfferDTO.getModel()))
            );
        }

        if (searchOfferDTO.getMinPrice() != null) {
            p.getExpressions().add(
                    cb.and(cb.greaterThanOrEqualTo(root.get("price"), searchOfferDTO.getMinPrice()))
            );
        }

        if (searchOfferDTO.getMaxPrice() != null) {
            p.getExpressions().add(
                    cb.and(cb.lessThanOrEqualTo(root.get("price"), searchOfferDTO.getMaxPrice()))
            );
        }
        return p;
    }
}

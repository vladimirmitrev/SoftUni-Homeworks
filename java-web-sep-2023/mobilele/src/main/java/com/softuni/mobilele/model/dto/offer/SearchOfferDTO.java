package com.softuni.mobilele.model.dto.offer;

import jakarta.validation.constraints.NotEmpty;

public class SearchOfferDTO {
    @NotEmpty
    private String query;

    public SearchOfferDTO() {
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
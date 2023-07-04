package com.example.cardealer.service;

import com.example.cardealer.model.entity.Part;

import java.util.Set;

public interface PartService {

    Set<Part> getRandomParts();
}

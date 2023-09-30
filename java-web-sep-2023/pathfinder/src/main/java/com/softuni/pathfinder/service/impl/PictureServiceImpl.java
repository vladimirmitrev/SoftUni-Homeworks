package com.softuni.pathfinder.service.impl;

import com.softuni.pathfinder.repository.PictureRepository;
import com.softuni.pathfinder.service.PictureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public List<String> findAllUrls() {

        return pictureRepository.findAllUrls();
    }
}

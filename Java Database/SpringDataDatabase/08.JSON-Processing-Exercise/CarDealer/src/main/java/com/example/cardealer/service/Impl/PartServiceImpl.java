package com.example.cardealer.service.Impl;

import com.example.cardealer.model.entity.Part;
import com.example.cardealer.repository.PartRepository;
import com.example.cardealer.service.PartService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PartServiceImpl implements PartService {


    private final PartRepository partRepository;

    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public Set<Part> getRandomParts() {
        Set<Part> partSet = new HashSet<>();
        int partCount = ThreadLocalRandom
                .current().nextInt(3, 6);

        long totalPartCount = partRepository.count();

        for (int i = 0; i < partCount; i++) {
            long randomId = ThreadLocalRandom
                    .current().nextLong(1, totalPartCount + 1);

            partSet.add(partRepository.findById(randomId).orElse(null));
        }

        return partSet;
    }
}

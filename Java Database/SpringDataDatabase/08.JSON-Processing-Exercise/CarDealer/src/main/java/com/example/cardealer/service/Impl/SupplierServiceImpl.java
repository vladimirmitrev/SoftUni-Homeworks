package com.example.cardealer.service.Impl;

import com.example.cardealer.model.dto.SupplierWithIdAndPartsCountDto;
import com.example.cardealer.model.entity.Supplier;
import com.example.cardealer.repository.SupplierRepository;
import com.example.cardealer.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SupplierServiceImpl implements SupplierService {


    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier findRandomSuppliers() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, supplierRepository.count() + 1);

        return supplierRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public List<SupplierWithIdAndPartsCountDto> getAllSuppliersWithLocalParts() {

        return this.supplierRepository.findAllByImporterFalse();
    }

}

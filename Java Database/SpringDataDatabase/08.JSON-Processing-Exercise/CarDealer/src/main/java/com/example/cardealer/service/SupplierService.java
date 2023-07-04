package com.example.cardealer.service;

import com.example.cardealer.model.dto.SupplierWithIdAndPartsCountDto;
import com.example.cardealer.model.entity.Supplier;

import java.util.List;
import java.util.Set;

public interface SupplierService {

    Supplier findRandomSuppliers();

    List<SupplierWithIdAndPartsCountDto> getAllSuppliersWithLocalParts();
}

package com.example.cardealer.repository;

import com.example.cardealer.model.dto.SupplierWithIdAndPartsCountDto;
import com.example.cardealer.model.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {


    @Query("SELECT new com.example.cardealer.model.dto.SupplierWithIdAndPartsCountDto(" +
            "s.id, s.name, COUNT(p)) " +
            " FROM Supplier s" +
            " JOIN s.parts p" +
            " WHERE s.isImporter = FALSE" +
            " GROUP BY s")

    List<SupplierWithIdAndPartsCountDto> findAllByImporterFalse();



}

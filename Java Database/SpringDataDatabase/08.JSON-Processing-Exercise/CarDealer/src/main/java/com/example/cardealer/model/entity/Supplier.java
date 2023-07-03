package com.example.cardealer.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "supliers")
public class Supplier extends BaseEntity{

    @Column
    private String name;
    @Column(name = "is_importer")
    private boolean isImporter;

    @OneToMany(mappedBy = "supplier")
    private Set<Part> parts;


    public Supplier() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Supplier supplier = (Supplier) o;
//        return isImporter == supplier.isImporter && Objects.equals(name, supplier.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, isImporter);
//    }
}

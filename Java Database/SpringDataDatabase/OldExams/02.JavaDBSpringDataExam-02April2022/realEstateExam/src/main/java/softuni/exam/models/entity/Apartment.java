package softuni.exam.models.entity;

import softuni.exam.models.entity.enums.ApartmentType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "apartments")
public class Apartment extends BaseEntity {

    @Column(name = "apartment_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ApartmentType apartmentType;
    @Column(name = "area", nullable = false)
    private Double area;

    @ManyToOne
    private Town town;
    @OneToMany(mappedBy = "apartment")
    private Set<Offer> offers;

    public Apartment() {
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}


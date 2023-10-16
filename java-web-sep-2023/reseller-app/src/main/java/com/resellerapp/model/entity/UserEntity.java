package com.resellerapp.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
    private Set<OfferEntity> offers;
    @OneToMany(mappedBy = "buyer", fetch = FetchType.EAGER)
    private List<OfferEntity> boughtOffers;

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<OfferEntity> getOffers() {
        return offers;
    }

    public void setOffers(Set<OfferEntity> offers) {
        this.offers = offers;
    }

    public List<OfferEntity> getBoughtOffers() {
        return boughtOffers;
    }

    public void setBoughtOffers(List<OfferEntity> boughtOffers) {
        this.boughtOffers = boughtOffers;
    }

//•	Has an Id – “UUID-String” or Long
    //•	Has a Username (unique, not null)
    //o	Username length must be between 3 and 20 characters (inclusive of 3 and 20).
    //•	Has a Password (not null)
    //o	Password length must be between 3 and 20 characters (inclusive of 3 and 20).
    //•	Has an Email (unique, not null)
    //o	Must contain '@'.
    //•	Has Offers
    //o	The offers contains users offers. One user may have many offers and one offer can be created by only one user.
    //•	Has boughtOffers
    //o	Collection with the offers that the user bought. One user may have many offers in boughtOffers.
}

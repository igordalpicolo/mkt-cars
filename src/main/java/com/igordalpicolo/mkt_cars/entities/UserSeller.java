package com.igordalpicolo.mkt_cars.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user_seller")
public class UserSeller extends User {

    private String address;

    @ManyToOne
    @JoinColumn(name = "listing_id")
    private Listing listing;

    public UserSeller() {
    }

    public UserSeller(int id, String name, String email, String phone, String password, String address) {
        super(id, name, email, phone, password);
        this.address = address;
    }
}

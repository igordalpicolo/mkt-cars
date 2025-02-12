package com.igordalpicolo.mkt_cars.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user_buyer")
public class UserBuyer extends User {

    public UserBuyer() {
        super();
    }

    protected UserBuyer(int id, String name, String email, String phone, String password) {
        super(id, name, email, phone, password);
    }


}

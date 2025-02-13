package com.igordalpicolo.mkt_cars.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "proposal")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_buyer_id", nullable = false)
    private UserBuyer buyer;

    @OneToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    private double offerPrice;

    private char status;

    public Proposal() {}

    public Proposal(Long id, double offerPrice, char status) {
        this.id = id;
        this.offerPrice = offerPrice;
        this.status = status;
    }

    public double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Proposal proposal = (Proposal) o;
        return Objects.equals(id, proposal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

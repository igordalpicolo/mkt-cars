package com.igordalpicolo.mkt_cars.dto;

import com.igordalpicolo.mkt_cars.entities.Listing;
import com.igordalpicolo.mkt_cars.entities.UserSeller;
import org.springframework.beans.BeanUtils;

public class ListingDTO {

    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private String color;
    private Integer price;
    private Integer kilometers;
    private String description;
    private UserSeller seller;

    public ListingDTO() {}

    public ListingDTO(Listing entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {return year;}

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSeller(UserSeller seller) {this.seller = seller;}

    public UserSeller getSeller() { return seller; }

}

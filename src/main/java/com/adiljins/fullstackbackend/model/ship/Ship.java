package com.adiljins.fullstackbackend.model.ship;

import com.adiljins.fullstackbackend.model.essential.Company;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name="SHIP_TBL")
@Component
public class Ship {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private int years;
    private String typeLease;
    private int price;
    private int pricePerYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    Company company;
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getYears() {
        return years;
    }
    public void setYears(int years) {
        this.years = years;
    }
    public String getTypeLease() {
        return typeLease;
    }
    public void setTypeLease(String typeLease) {
        this.typeLease = typeLease;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getPricePerYear() {
        return pricePerYear;
    }
    public void setPricePerYear(int pricePerYear) {
        this.pricePerYear = pricePerYear;
    }
}

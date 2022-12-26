package com.adiljins.fullstackbackend.model.ship;

import com.adiljins.fullstackbackend.model.essential.Company;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Set;

import static com.adiljins.fullstackbackend.accounting.Lease.getLeasing;

@Entity
@Table(name="SHIP_TBL")
@Component
public class Ship {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String address;
    private String number;
    private String email;
    private String type = this.getClass().getSimpleName();
    private int years;
    private String typeLease;
    private int price;
    private int pricePerYear;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

//    public Ship() {
//        this.price = getLeasing(this.getTypeLease(),this.getYears(),this.getPricePerYear());
//    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonBackReference()
//    Company company;

//    public Company getCompany() {
//        return company;
//    }
//    public void setCompany(Company company) {
//        this.company = company;
//    }

    public void generatePrice(){
        this.pricePerYear = this.getPricePerYear();
        this.price = getLeasing(this.getTypeLease(),this.getYears(),this.getPricePerYear());
    }
    public String getName() {
        return company;
    }
    public void setName(String name) {
        this.company = name;
    }
    public Long getId() {
        return id;
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
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

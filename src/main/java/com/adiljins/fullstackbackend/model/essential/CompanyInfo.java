package com.adiljins.fullstackbackend.model.essential;

import com.adiljins.fullstackbackend.model.ship.Ship;

import java.util.Set;

public class CompanyInfo {
    private long id;
    private String name;
    private String address;
    private String number;
    private String e_mail;
    private Set<Ship> set;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public Set<Ship> getSet() {
        return set;
    }

    public void setSet(Set<Ship> set) {
        this.set = set;
    }
}

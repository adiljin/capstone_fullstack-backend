package com.adiljins.fullstackbackend.model.ship.ports_20;

import com.adiljins.fullstackbackend.model.ship.Ship;
import jakarta.persistence.Entity;

@Entity
public class Container extends Ship {

    private final int weightMin = 7000;
    private final int weightMax = 10000;
    private int pricePerYear = 6000;

    public int getWeightMin() {
        return weightMin;
    }
    public int getWeightMax() {
        return weightMax;
    }
    public int getPricePerYear() {
        return pricePerYear;
    }
    public void setPricePerYear(int pricePerYear) {
        this.pricePerYear = pricePerYear;
    }
}

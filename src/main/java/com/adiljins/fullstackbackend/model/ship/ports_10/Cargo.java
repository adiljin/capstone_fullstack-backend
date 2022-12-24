package com.adiljins.fullstackbackend.model.ship.ports_10;
import static com.adiljins.fullstackbackend.accounting.Lease.getLeasing;

import com.adiljins.fullstackbackend.model.essential.Company;
import com.adiljins.fullstackbackend.model.ship.Ship;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Entity
public class Cargo extends Ship {

    private final int weightMin = 2000;
    private final int weightMax = 5000;
    private int pricePerYear = 2000;

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

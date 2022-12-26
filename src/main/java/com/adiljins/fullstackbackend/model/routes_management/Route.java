package com.adiljins.fullstackbackend.model.routes_management;

import jakarta.persistence.*;

@Entity
@Table(name="ROUTE_TBL")
public class Route {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String portName;
    private int portPrice;

    public Route() {
    }

    public Route(String portName, int portPrice) {
        this.portName = portName;
        this.portPrice = portPrice;
    }

    public Long getId() {
        return id;
    }
    public String getPortName() {
        return portName;
    }
    public int getPriceFrom() {
        return portPrice;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }
    public void setPriceFrom(int portPrice) {
        this.portPrice = portPrice;
    }
}

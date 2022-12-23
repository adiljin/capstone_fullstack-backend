package com.adiljins.fullstackbackend.model.routes_management;

import jakarta.persistence.*;

@Entity
@Table(name="ROUTE_TBL")
public class Route {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long portNumber;
    private String portName;
    private int portPrice;
//    private int port1, port2, quantity;


    public Route() {
    }

    public Route(String portName, int portPrice) {
        this.portName = portName;
        this.portPrice = portPrice;
    }

    //
//    public Route(int port1, int port2, int quantity) {
//        this.port1 = port1;
//        this.port2 = port2;
//        this.quantity = quantity;
//    }

//    public int getPort1() {
//        return port1;
//    }
//    public int getPort2() {
//        return port2;
//    }
//    public int getQuantity() {
//        return quantity;
//    }

    public Long getPortNumber() {
        return portNumber;
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

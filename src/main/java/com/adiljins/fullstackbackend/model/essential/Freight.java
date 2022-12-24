package com.adiljins.fullstackbackend.model.essential;

import com.adiljins.fullstackbackend.model.routes_management.Route;
import com.adiljins.fullstackbackend.model.ship.Ship;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name="FRE_TBL")
@Component
public class Freight {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private String type;
    private String weight;
    @OneToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;
    private int price;
    private int route;
    private String routeType;
    @OneToOne
    @JoinColumn(name = "chosen_route_port_number")
    private Route chosenRoute;

    public void setType(String type) {
        this.type = type;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Long getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public String getWeight() {
        return weight;
    }
    public Ship getShip() {
        return ship;
    }
    public int getPrice() {
        return price;
    }
    public int getRoute() {
        return route;
    }
    public String getRouteType() {
        return routeType;
    }
    public Route getChosenRoute() {
        return chosenRoute;
    }

}

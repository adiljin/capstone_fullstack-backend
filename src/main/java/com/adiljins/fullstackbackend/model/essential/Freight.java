package com.adiljins.fullstackbackend.model.essential;

import com.adiljins.fullstackbackend.model.routes_management.Route;
import com.adiljins.fullstackbackend.model.ship.Ship;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

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
    @OneToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;
    @OneToOne
    @JoinColumn(name = "route_f_id")
    private Route routeF;
    @OneToOne
    @JoinColumn(name = "route_t_id")
    private Route routeT;
    private int weight;
    private int price;
    private int routesPrice;

//    public int genPrice(List<Route> list, Route routeF, Route routeT){
//        int result = 0;
//        boolean may = false;
//        for (int i = 0; i < list.size(); i++) {
//            Route troute = list.get(i);
//            if(troute.getId()==routeF.getId()){
//                may = true;
//            }else if (troute.getId()==routeT.getId()){
//                result += troute.getPriceFrom();
//                return result;
//            }
//            if(may){
//                result += troute.getPriceFrom();
//            }
//        }
//        return result;
//    }

    public void genPrice(){
        this.price = (int) (this.routesPrice + ((this.weight + this.ship.getPricePerYear()) * 0.4));
    }

    public int getRoutesPrice() {
        return routesPrice;
    }
    public int getPrice() {
        return price;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Long getId() {
        return id;
    }
    public int getWeight() {
        return weight;
    }
    public Ship getShip() {
        return ship;
    }
    public Route getRouteF() {
        return routeF;
    }
    public Route getRouteT() {
        return routeT;
    }

}

package com.adiljins.fullstackbackend.controller;

import com.adiljins.fullstackbackend.exception.NotFoundException;
import com.adiljins.fullstackbackend.model.essential.Company;
import com.adiljins.fullstackbackend.model.essential.Customer;
import com.adiljins.fullstackbackend.model.routes_management.Route;
import com.adiljins.fullstackbackend.model.ship.Ship;
import com.adiljins.fullstackbackend.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static com.adiljins.fullstackbackend.accounting.Lease.getLeasing;

@RestController
@RequestMapping("/rout")
@CrossOrigin("http://localhost:3000/")
public class RouteController {

    @Autowired
    private RouteRepository routeRepository;

    @PostMapping()
    Route newRoute(@RequestBody Route newRoute){
        return routeRepository.save(newRoute);
    }

    @PostMapping("/set")
    List<Route> setRoutes(){
        List<Route> routes = Arrays.asList(
                new Route("New York1", 99),
                new Route("Watervilet", 142),
                new Route("Troy Lock", 134),
                new Route("Troya", 132),
                new Route("Rense", 146),
                new Route("Coeyman", 166),
                new Route("Albanie", 116),
                new Route("Athenes", 198),
                new Route("Hudson", 142),
                new Route("Catskill", 89),
                new Route("Poughkeepsie", 79),
                new Route("Kingston", 80),
                new Route("Hyde Park", 71),
                new Route("Ossinina", 66),
                new Route("Newburgh", 53),
                new Route("West Point", 45),
                new Route("Haverstraw", 33),
                new Route("Peek", 28),
                new Route("Saugerties", 39),
                new Route("New York2", 134)
        );
        return routeRepository.saveAll(routes);
    }

    @GetMapping("/routes")
    List<Route> getAllRoutes(){return routeRepository.findAll();}

    @GetMapping("/route/{id}")
    Route getRouteById(@PathVariable Long id){
        return routeRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    @PutMapping("/route/{id}")
    Route updateRoute(@RequestBody Route newRoute,@PathVariable Long id){
        return routeRepository.findById(id).map(route -> {
            route.setPortName(newRoute.getPortName());
            route.setPriceFrom(newRoute.getPriceFrom());
            return routeRepository.save(route);
        }).orElseThrow(()->new NotFoundException(id));
    }

    @DeleteMapping("/route/{id}")
    String deleteRoute(@PathVariable Long id){
        if(!routeRepository.existsById(id)){
            throw new NotFoundException(id);
        }
        routeRepository.deleteById(id);
        return "Route with id " + id + " has been deleted";
    }
}

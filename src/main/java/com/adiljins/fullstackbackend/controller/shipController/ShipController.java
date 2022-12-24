//package com.adiljins.fullstackbackend.controller.shipController;
//
//import com.adiljins.fullstackbackend.exception.NotFoundException;
//import com.adiljins.fullstackbackend.model.ship.Ship;
//import com.adiljins.fullstackbackend.repository.ship_repo.ShipRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin("http://localhost:3000/")
//public class ShipController {
//
//    @Autowired
//    private ShipRepository shipRepository;
//
//    @PostMapping(path = "/ship")
//    Ship newShip(@RequestBody Ship newShip){return shipRepository.save(newShip);}
//
//    @GetMapping("/ships")
//    List<Ship> getAllShips(){return shipRepository.findAll();}
//
//    @GetMapping("/ships/{id}")
//    Ship getShipById(@PathVariable Long id){
//        return shipRepository.findById(id).orElseThrow(()->new NotFoundException(id));
//    }
//
//    @PutMapping("/ship/{id}")
//    Ship updateShip(@RequestBody Ship newShip,@PathVariable Long id){
//        return shipRepository.findById(id).map(ship -> {
//            ship.setType(newShip.getType());
//            ship.setAddress(newShip.getAddress());
//            ship.setPricePerYear(newShip.getPricePerYear());
//            ship.setPrice(newShip.getPrice());
//            ship.setYears(newShip.getYears());
//            ship.setTypeLease(newShip.getTypeLease());
//            return shipRepository.save(ship);
//        }).orElseThrow(()->new NotFoundException(id));
//    }
//
//    @DeleteMapping("/ship/{id}")
//    String deleteShip(@PathVariable Long id){
//        if(!shipRepository.existsById(id)){
//            throw new NotFoundException(id);
//        }
//        shipRepository.deleteById(id);
//        return "Ship with id " + id + " has been deleted";
//    }
//
//}

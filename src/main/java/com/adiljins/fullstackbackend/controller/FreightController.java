package com.adiljins.fullstackbackend.controller;

import com.adiljins.fullstackbackend.exception.NotFoundException;
import com.adiljins.fullstackbackend.model.essential.Freight;
import com.adiljins.fullstackbackend.model.ship.ports_10.Tugboat;
import com.adiljins.fullstackbackend.repository.FreightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fre")
@CrossOrigin("http://localhost:3000/")
public class FreightController {

    @Autowired
    private FreightRepository freightRepository;

    @PostMapping
    Freight newFreight(@RequestBody Freight newFreight){
        newFreight.genPrice();
        return freightRepository.save(newFreight);
    }

    @GetMapping("/get")
    List<Freight> getAllFreights(){return freightRepository.findAll();}

    @GetMapping("/freights/{id}")
    Freight getFreightById(@PathVariable Long id){
        return freightRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

//    @PutMapping("/freights/{id}")
//    Freight updateFreight(@RequestBody Freight newFreight,@PathVariable Long id){
//        return freightRepository.findById(id).map(freight -> {
//            freight.setWeight(newFreight.getWeight());
//            return freightRepository.save(freight);
//        }).orElseThrow(()->new NotFoundException(id));
//    }

    @DeleteMapping("/{id}")
    String deleteTugboat(@PathVariable Long id){
        if(!freightRepository.existsById(id)){
            throw new NotFoundException(id);
        }
        freightRepository.deleteById(id);
        return "Freight with id " + id + " has been deleted";
    }

}

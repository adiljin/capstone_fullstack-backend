package com.adiljins.fullstackbackend.controller.shipController;

import com.adiljins.fullstackbackend.exception.NotFoundException;
import com.adiljins.fullstackbackend.model.essential.Company;
import com.adiljins.fullstackbackend.model.ship.Ship;
import com.adiljins.fullstackbackend.model.ship.ports_20.Barge;
import com.adiljins.fullstackbackend.repository.ship_repo.BargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.adiljins.fullstackbackend.accounting.Lease.getLeasing;

@RestController
@RequestMapping("/barge")
@CrossOrigin("http://localhost:3000/")
public class BargeController {

    @Autowired
    private BargeRepository bargeRepository;

    @PostMapping
    Barge newBarge(@RequestBody Barge newBarge){
        newBarge.generatePrice();
        return bargeRepository.save(newBarge);
    }

    @GetMapping("/barges")
    List<Barge> getAllBarges(){
        return bargeRepository.findAll();
    }

    @GetMapping("/barges/{id}")
    Barge getBargeById(@PathVariable Long id){
        return bargeRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    @PutMapping("/barge/{id}")
    Barge updateBarge(@RequestBody Barge newBarge,@PathVariable Long id){
        return bargeRepository.findById(id).map(barge -> {
            barge.setCompany(newBarge.getCompany());
            barge.setAddress(newBarge.getAddress());
            barge.setNumber(newBarge.getNumber());
            barge.setEmail(newBarge.getEmail());
            barge.setYears(newBarge.getYears());
            barge.setTypeLease(newBarge.getTypeLease());
            barge.setPrice(newBarge.getPrice());
            return bargeRepository.save(barge);
        }).orElseThrow(()->new NotFoundException(id));
    }

    @DeleteMapping("/del/{id}")
    String deleteBarge(@PathVariable Long id){
        if(!bargeRepository.existsById(id)){
            throw new NotFoundException(id);
        }
        bargeRepository.deleteById(id);
        return "Barge with id " + id + " has been deleted";
    }
}

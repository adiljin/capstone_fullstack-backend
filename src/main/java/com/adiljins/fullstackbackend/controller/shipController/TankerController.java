package com.adiljins.fullstackbackend.controller.shipController;

import com.adiljins.fullstackbackend.exception.NotFoundException;
import com.adiljins.fullstackbackend.model.ship.ports_20.Tanker;
import com.adiljins.fullstackbackend.repository.ship_repo.TankerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.adiljins.fullstackbackend.accounting.Lease.getLeasing;

@RestController
@RequestMapping("/tanker")
@CrossOrigin("http://localhost:3000/")
public class TankerController {

    @Autowired
    private TankerRepository tankerRepository;

    @PostMapping
    Tanker newTanker(@RequestBody Tanker newTanker){
        newTanker.generatePrice();
        return tankerRepository.save(newTanker);
    }

    @GetMapping("/tankers")
    List<Tanker> getAllTankers(){return tankerRepository.findAll();}

    @GetMapping("/tankers/{id}")
    Tanker getTankerById(@PathVariable Long id){
        return tankerRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    @PutMapping("/tanker/{id}")
    Tanker updateTanker(@RequestBody Tanker newTanker,@PathVariable Long id){
        return tankerRepository.findById(id).map(tanker -> {
            tanker.setType(newTanker.getType());
            tanker.setAddress(newTanker.getAddress());
            tanker.setPrice(newTanker.getPrice());
            tanker.setYears(newTanker.getYears());
            tanker.setTypeLease(newTanker.getTypeLease());
            return tankerRepository.save(tanker);
        }).orElseThrow(()->new NotFoundException(id));
    }

    @DeleteMapping("/tanker/{id}")
    String deleteTanker(@PathVariable Long id){
        if(!tankerRepository.existsById(id)){
            throw new NotFoundException(id);
        }
        tankerRepository.deleteById(id);
        return "Tanker with id " + id + " has been deleted";
    }
}

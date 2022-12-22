package com.adiljins.fullstackbackend.controller.shipController;

import com.adiljins.fullstackbackend.exception.NotFoundException;
import com.adiljins.fullstackbackend.model.ship.ports_20.Container;
import com.adiljins.fullstackbackend.repository.ship_repo.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.adiljins.fullstackbackend.accounting.Lease.getLeasing;

@RestController
@CrossOrigin("http://localhost:3000/")
public class ContainerController {

    @Autowired
    private ContainerRepository containerRepository;

    @PostMapping(path = "/container")
    Container newContainer(@RequestBody Container newContainer){
        newContainer.setPrice(getLeasing(newContainer.getTypeLease(),newContainer.getYears(),newContainer.getPricePerYear()));
        return containerRepository.save(newContainer);
    }

    @GetMapping("/containers")
    List<Container> getAllContainers(){return containerRepository.findAll();}

    @GetMapping("/containers/{id}")
    Container getContainerById(@PathVariable Long id){
        return containerRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    @PutMapping("/container/{id}")
    Container updateContainer(@RequestBody Container newContainer,@PathVariable Long id){
        return containerRepository.findById(id).map(container -> {
            container.setName(newContainer.getName());
            container.setAddress(newContainer.getAddress());
            container.setPrice(newContainer.getPrice());
            container.setYears(newContainer.getYears());
            container.setTypeLease(newContainer.getTypeLease());
            return containerRepository.save(container);
        }).orElseThrow(()->new NotFoundException(id));
    }

    @DeleteMapping("/container/{id}")
    String deleteContainer(@PathVariable Long id){
        if(!containerRepository.existsById(id)){
            throw new NotFoundException(id);
        }
        containerRepository.deleteById(id);
        return "Container with id " + id + " has been deleted";
    }

}

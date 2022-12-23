//package com.adiljins.fullstackbackend.controller.shipController;
//
//import com.adiljins.fullstackbackend.exception.NotFoundException;
//import com.adiljins.fullstackbackend.model.ship.ports_10.Tugboat;
//import com.adiljins.fullstackbackend.repository.ship_repo.TugboatRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//import static com.adiljins.fullstackbackend.accounting.Lease.getLeasing;
//
//@RestController
//@CrossOrigin("http://localhost:3000/")
//public class TugboatController {
//
//    @Autowired
//    private TugboatRepository tugboatRepository;
//
//    @PostMapping(path = "/tugboat")
//    Tugboat newTugboat(@RequestBody Tugboat newTugboat){
//        newTugboat.setPrice(getLeasing(newTugboat.getTypeLease(),newTugboat.getYears(),newTugboat.getPricePerYear()));
//        return tugboatRepository.save(newTugboat);
//    }
//
//    @GetMapping("/tugboats")
//    List<Tugboat> getAllTugboats(){return tugboatRepository.findAll();}
//
//    @GetMapping("/tugboats/{id}")
//    Tugboat getTugboatById(@PathVariable Long id){
//        return tugboatRepository.findById(id).orElseThrow(()->new NotFoundException(id));
//    }
//
//    @PutMapping("/tugboat/{id}")
//    Tugboat updateTugboat(@RequestBody Tugboat newTugboat,@PathVariable Long id){
//        return tugboatRepository.findById(id).map(cruise -> {
//            cruise.setName(newTugboat.getName());
//            cruise.setAddress(newTugboat.getAddress());
//            cruise.setPrice(newTugboat.getPrice());
//            cruise.setYears(newTugboat.getYears());
//            cruise.setTypeLease(newTugboat.getTypeLease());
//            return tugboatRepository.save(cruise);
//        }).orElseThrow(()->new NotFoundException(id));
//    }
//
//    @DeleteMapping("/tugboat/{id}")
//    String deleteTugboat(@PathVariable Long id){
//        if(!tugboatRepository.existsById(id)){
//            throw new NotFoundException(id);
//        }
//        tugboatRepository.deleteById(id);
//        return "Tugboat with id " + id + " has been deleted";
//    }
//
//}

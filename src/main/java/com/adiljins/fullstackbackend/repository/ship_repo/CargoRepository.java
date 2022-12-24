package com.adiljins.fullstackbackend.repository.ship_repo;

import com.adiljins.fullstackbackend.model.ship.ports_10.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo,Long> {
}

package com.adiljins.fullstackbackend.repository.ship_repo;

import com.adiljins.fullstackbackend.model.ship.ports_20.Tanker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TankerRepository extends JpaRepository<Tanker,Long> {
}

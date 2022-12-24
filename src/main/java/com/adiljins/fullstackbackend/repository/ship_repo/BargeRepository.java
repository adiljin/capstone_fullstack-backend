package com.adiljins.fullstackbackend.repository.ship_repo;

import com.adiljins.fullstackbackend.model.ship.ports_20.Barge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BargeRepository extends JpaRepository<Barge,Long> {
}

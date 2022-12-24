package com.adiljins.fullstackbackend.repository.ship_repo;

import com.adiljins.fullstackbackend.model.ship.ports_10.Tugboat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TugboatRepository extends JpaRepository<Tugboat,Long>  {
}

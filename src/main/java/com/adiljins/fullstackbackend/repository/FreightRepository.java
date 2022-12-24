package com.adiljins.fullstackbackend.repository;

import com.adiljins.fullstackbackend.model.essential.Freight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreightRepository extends JpaRepository<Freight,Long> {
}

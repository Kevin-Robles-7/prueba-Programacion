package com.PruebaTransporte.PruebaProgramacion.repository;

import com.PruebaTransporte.PruebaProgramacion.model.Conductores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductoresRepository extends JpaRepository<Conductores, Long> {
}

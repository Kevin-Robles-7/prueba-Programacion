package com.PruebaTransporte.PruebaProgramacion.repository;

import com.PruebaTransporte.PruebaProgramacion.model.Rutas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutasRepository extends JpaRepository<Rutas, Long> {
}

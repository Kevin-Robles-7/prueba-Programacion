package com.PruebaTransporte.PruebaProgramacion.controller;

import com.PruebaTransporte.PruebaProgramacion.model.Conductores;
import com.PruebaTransporte.PruebaProgramacion.model.Rutas;
import com.PruebaTransporte.PruebaProgramacion.model.Viajes;
import com.PruebaTransporte.PruebaProgramacion.repository.ConductoresRepository;
import com.PruebaTransporte.PruebaProgramacion.repository.RutasRepository;
import com.PruebaTransporte.PruebaProgramacion.repository.ViajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Viajes")
public class ViajesController {

    @Autowired
    private ViajesRepository miviajesRepository;

    @Autowired
    private ConductoresRepository miconductorRepository;

    @Autowired
    private RutasRepository mirutaRepository;

    //Visualizacion de todos los viajes que han hecho los conductores.

    @GetMapping("/")
    public List<Viajes> index() {
        return this.miviajesRepository.findAll();
    }

    //Creacion de metodo que permite crear o registrar un viaje nuevo
    /*
    * Hacemos uso del repositorio, controlador y modelo de conductores y rutas, con esto podemos traer el id
    * del conductor y de la ruta de tal forma que podamos saber cuando demora un conductor en hacer el viaje.
    */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Viajes> createViaje(@RequestBody Viajes viajes) {
        Conductores conductores = this.miconductorRepository.findById(viajes.getId_conductor().getId_conductor()).orElse(null);
        if (conductores == null) {
            return ResponseEntity.badRequest().build();
        }
        Rutas ruta = this.mirutaRepository.findById(viajes.getId_ruta().getId_ruta()).orElse(null);
        if (ruta == null) {
            return ResponseEntity.badRequest().build();
        }
        double distancia = ruta.getDistancia();
        LocalTime hora_inicio = viajes.getHora_inicio();
        LocalTime hora_fin = viajes.getHora_fin();
        double tiempo_total = Duration.between(hora_inicio, hora_fin).toMinutes() / 60.0;
        double velocidad = distancia / tiempo_total;
        viajes.setTiempo_total(tiempo_total);
        viajes.setId_conductor(conductores);
        viajes.setId_ruta(ruta);
        miviajesRepository.save(viajes);
        System.out.println("Viaje Creado");
        return ResponseEntity.status(HttpStatus.CREATED).body(viajes);
    }
}

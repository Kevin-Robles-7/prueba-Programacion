package com.PruebaTransporte.PruebaProgramacion.controller;

import com.PruebaTransporte.PruebaProgramacion.model.Conductores;
import com.PruebaTransporte.PruebaProgramacion.model.Rutas;
import com.PruebaTransporte.PruebaProgramacion.repository.RutasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Rutas")
public class RutasController {

    @Autowired
    private RutasRepository mirutaRepository;

    @GetMapping("")
    public List<Rutas> index() {
        return this.mirutaRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Rutas create(@RequestBody Rutas rutas) {
        rutas.setNombre_ruta(rutas.getNombre_ruta());
        rutas.setOrigen(rutas.getOrigen());
        rutas.setDestino(rutas.getDestino());
        rutas.setDistancia(rutas.getDistancia());
        System.out.println("Ruta Registrada Exitosamente");
        return this.mirutaRepository.save(rutas);
    }

    @GetMapping("{id_ruta}")
    public ResponseEntity<String> show(@PathVariable Long id_ruta){
        Rutas ruta = this.mirutaRepository
                .findById(id_ruta)
                .orElse(null);
        if (ruta != null){
            return ResponseEntity.ok(ruta.toString());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro la ruta con el ID " + id_ruta);
        }
    }

    @PutMapping("{id_conductor}")
    public Rutas update(@PathVariable Long id_conductor, @RequestBody Rutas rutas){
        Rutas ruta = this.mirutaRepository
                .findById(id_conductor)
                .orElse(null);
        if (ruta != null){
            ruta.setDistancia(ruta.getDistancia());
            return this.mirutaRepository.save(ruta);
        }else {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id_ruta}")
    public void delete(@PathVariable Long id_ruta){
        Rutas ruta = this.mirutaRepository
                .findById(id_ruta)
                .orElse(null);
        if (ruta != null){
            this.mirutaRepository.delete(ruta);
            System.out.println("Conductor Eliminado");
        }else {
            System.out.println("No se encontro o no se pudo eliminar al conductor (Verificar)");
        }
    }

}

package com.PruebaTransporte.PruebaProgramacion.controller;

import com.PruebaTransporte.PruebaProgramacion.model.Conductores;
import com.PruebaTransporte.PruebaProgramacion.repository.ConductoresRepository;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Conductores")
public class ConductoresController {

    @Autowired
    private ConductoresRepository miconductorRepository;

    /*
    Creamos una funcion con un metodo GET
    para ver la lista completa
    de todos los conductores que estan en la base de datos
    */
    @GetMapping("")
    public List<Conductores> index() {
        return this.miconductorRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Conductores create(@RequestBody Conductores conductores) {
        conductores.setNombre_conductor(conductores.getNombre_conductor());
        conductores.setApellido_conductor(conductores.getApellido_conductor());
        conductores.setTelefono(conductores.getTelefono());
        conductores.setCorreo_electronico(conductores.getCorreo_electronico());
        System.out.println("Conductor Registrado Exitosamente");
        return this.miconductorRepository.save(conductores);
    }

    @GetMapping("{id_conductor}")
    public ResponseEntity<String> show(@PathVariable Long id_conductor){
        Conductores conductor= this.miconductorRepository
                .findById(id_conductor)
                .orElse(null);
        if (conductor != null){
            return ResponseEntity.ok(conductor.toString());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el conductor con el ID " + id_conductor);
        }
    }

    @PutMapping("{id_conductor}")
    public Conductores update(@PathVariable Long id_conductor, @RequestBody Conductores conductores){
        Conductores conductor = this.miconductorRepository
                .findById(id_conductor)
                .orElse(null);
        if (conductor != null){
            conductor.setTelefono(conductor.getTelefono());
            conductor.setCorreo_electronico(conductor.getCorreo_electronico());
            return this.miconductorRepository.save(conductor);
        }else {
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id_conductor}")
    public void delete(@PathVariable Long id_conductor){
        Conductores conductor = this.miconductorRepository
                .findById(id_conductor)
                .orElse(null);
        if (conductor != null){
            this.miconductorRepository.delete(conductor);
            System.out.println("Conductor Eliminado");
        }else {
            System.out.println("No se encontro o no se pudo eliminar al conductor (Verificar)");
        }
    }
}

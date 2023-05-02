package com.PruebaTransporte.PruebaProgramacion.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Rutas")
public class Rutas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ruta;

    @Column(name = "nombre_ruta")
    private String nombre_ruta;

    @Column(name = "origen")
    private String origen;

    @Column(name = "destino")
    private String destino;

    @Column(name = "distancia")
    private Float distancia;

    public Rutas() {
    }

    public Rutas(String nombre_ruta, String origen, String destino, Float distancia) {
        this.nombre_ruta = nombre_ruta;
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }

    public Long getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(Long id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getNombre_ruta() {
        return nombre_ruta;
    }

    public void setNombre_ruta(String nombre_ruta) {
        this.nombre_ruta = nombre_ruta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Float getDistancia() {
        return distancia;
    }

    public void setDistancia(Float distancia) {
        this.distancia = distancia;
    }
}

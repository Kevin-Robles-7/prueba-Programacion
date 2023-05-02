package com.PruebaTransporte.PruebaProgramacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Viajes")
public class Viajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_viaje;

    @Column(name = "fecha_viaje")
    private LocalDate fecha_viaje;

    @Column(name = "hora_inicio")
    private LocalTime hora_inicio;

    @Column(name = "hora_fin")
    private LocalTime hora_fin;

    @ManyToOne
    @JoinColumn(name = "id_conductor")
    private Conductores id_conductor;

    @ManyToOne
    @JoinColumn(name = "id_ruta")
    private Rutas id_ruta;

    @Column(name = "tiempo_total")
    private Double tiempo_total;

    public Viajes() {
    }

    public Viajes(LocalDate fecha_viaje, LocalTime hora_inicio, LocalTime hora_fin, Conductores id_conductor, Rutas id_ruta, Double tiempo_total) {
        this.fecha_viaje = fecha_viaje;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.id_conductor = id_conductor;
        this.id_ruta = id_ruta;
        this.tiempo_total = tiempo_total;
    }

    public Long getId_viaje() {
        return id_viaje;
    }

    public void setId_viaje(Long id_viaje) {
        this.id_viaje = id_viaje;
    }

    public LocalDate getFecha_viaje() {
        return fecha_viaje;
    }

    public void setFecha_viaje(LocalDate fecha_viaje) {
        this.fecha_viaje = fecha_viaje;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    public Conductores getId_conductor() {
        return id_conductor = id_conductor;
    }

    public void setId_conductor(Conductores id_conductor) {
        this.id_conductor = id_conductor;
    }

    public Rutas getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(Rutas id_ruta) {
        this.id_ruta = id_ruta;
    }

    public Double getTiempo_total() {
        return tiempo_total;
    }

    public void setTiempo_total(Double tiempo_total) {
        this.tiempo_total = tiempo_total;
    }

    public void setVelocidad(double velocidad) {
    }

}

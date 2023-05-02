package com.PruebaTransporte.PruebaProgramacion.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Conductores")
public class Conductores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conductor;

    @Column(name = "nombre_conductor")
    private String nombre_conductor;

    @Column(name = "apellido_conductor")
    private String apellido_conductor;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo_electronico")
    private String correo_electronico;

    public Conductores() {
    }

    public Conductores(String nombre_conductor, String apellido_conductor, String telefono, String correo_electronico) {
        this.nombre_conductor = nombre_conductor;
        this.apellido_conductor = apellido_conductor;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
    }

    public Long getId_conductor() {
        return id_conductor;
    }

    public void setId_conductor(Long id_conductor) {
        this.id_conductor = id_conductor;
    }

    public String getNombre_conductor() {
        return nombre_conductor;
    }

    public void setNombre_conductor(String nombre_conductor) {
        this.nombre_conductor = nombre_conductor;
    }

    public String getApellido_conductor() {
        return apellido_conductor;
    }

    public void setApellido_conductor(String apellido_conductor) {
        this.apellido_conductor = apellido_conductor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
}

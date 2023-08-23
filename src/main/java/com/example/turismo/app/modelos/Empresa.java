package com.example.turismo.app.modelos;

import jakarta.persistence.*;

@Entity
@Table(name="empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nombre",nullable = false)
    private String nombre;
    private String nit;
    private Integer ubicacion;
    private String descripcion;


    public Empresa() {
    }

    public Empresa(Integer id, String nombre, String nit, Integer ubicacion, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }
    //las anotaciones son las palabras reservadas que algo simple lo convierten en algo 0p


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Integer getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Integer ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
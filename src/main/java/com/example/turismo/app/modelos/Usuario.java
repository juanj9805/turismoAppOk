package com.example.turismo.app.modelos;


import jakarta.persistence.*;

@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String cedula;
    private Integer Rol;


    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String cedula, Integer rol) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        Rol = rol;
    }

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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Integer getRol() {
        return Rol;
    }

    public void setRol(Integer rol) {
        Rol = rol;
    }
}

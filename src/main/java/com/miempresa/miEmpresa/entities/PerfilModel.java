package com.miempresa.miEmpresa.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "perfil")
public class PerfilModel {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "telefono")
    private String telefono;

    // user...

    @Column(name = "creado")
    private LocalDate creado;
    @Column(name = "actualizado")
    private LocalDate actualizado;

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getCreado() {
        return creado;
    }

    public void setCreado(LocalDate creado) {
        this.creado = creado;
    }

    public LocalDate getActualizado() {
        return actualizado;
    }

    public void setActualizado(LocalDate actualizado) {
        this.actualizado = actualizado;
    }
}

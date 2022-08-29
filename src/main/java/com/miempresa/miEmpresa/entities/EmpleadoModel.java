package com.miempresa.miEmpresa.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "empleado")
public class EmpleadoModel {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "correo")
    private String correo;

    // perfil...
    // rol...
    // empresa...
    // transaccion...

    @Column(name = "creado")
    private LocalDate creado;
    @Column(name = "actualizado")
    private LocalDate actualizado;

    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

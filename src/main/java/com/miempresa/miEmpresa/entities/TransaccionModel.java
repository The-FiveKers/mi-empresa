package com.miempresa.miEmpresa.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transaccion")
public class TransaccionModel {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "concepto")
    private String concepto;
    @Column(name = "monto")
    private String monto;

    // usuario...
    // empresa...

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

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
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

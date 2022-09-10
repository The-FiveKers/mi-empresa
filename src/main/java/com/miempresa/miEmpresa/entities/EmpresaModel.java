package com.miempresa.miEmpresa.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "empresa")
public class EmpresaModel {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;
    @Column(name = "documento", unique = true, nullable = false)
    private String documento;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;

    // usuario...
    // transaccion...
    @ManyToOne
    @JoinColumn(name = "transacciones")
    private TransaccionModel transacciones;

    @Column(name = "creado")
    private LocalDate creado;
    @Column(name = "modificado")
    private LocalDate modificado;

    // Getters & Settes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getCreado() {
        return creado;
    }

    public void setCreado(LocalDate creado) {
        this.creado = creado;
    }

    public LocalDate getModificado() {
        return modificado;
    }

    public void setModificado(LocalDate modificado) {
        this.modificado = modificado;
    }

    public TransaccionModel getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(TransaccionModel transacciones) {
        this.transacciones = transacciones;
    }
}

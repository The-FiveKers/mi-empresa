package com.miempresa.miEmpresa.entities;

import com.miempresa.miEmpresa.Enumeracion.RoleName;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "empleado")
public class EmpleadoModel {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;


    // perfil...
    // rol...
    // empresa...
    // transaccion...


    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "profile")
    private PerfilModel perfil;

      @OneToMany
      @JoinColumn(name = "role")
      private RoleName role;

    @ManyToOne
    @JoinColumn(name = "empresa")
    private EmpresaModel empresa;

    @ManyToOne
    @JoinColumn(name = "transaccion")
    private TransaccionModel transaccion;

    @Column(name = "creado")
    private LocalDate creado;

    @Column(name = "actualizado")
    private LocalDate actualizado;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PerfilModel getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilModel perfil) {
        this.perfil = perfil;
    }

    public EmpresaModel getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaModel empresa) {
        this.empresa = empresa;
    }

    public TransaccionModel getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(TransaccionModel transaccion) {
        this.transaccion = transaccion;
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

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }

//Getters & Setters

}

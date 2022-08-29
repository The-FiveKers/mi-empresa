package com.miempresa.miEmpresa.repository;

import com.miempresa.miEmpresa.entities.EmpleadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceEmpleado extends JpaRepository<EmpleadoModel, Integer> {

}

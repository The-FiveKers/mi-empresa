package com.miempresa.miEmpresa.repository;

import com.miempresa.miEmpresa.entities.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface InterfaceEmpresa extends JpaRepository<EmpresaModel, Integer> {
    // validar que nombre no se repita
    ArrayList<EmpresaModel> getEmpresaModelByNombre(String nombreEmpresa);

    // Validar que el documentoEmpresa no se repita
    ArrayList<EmpresaModel> getEmpresaModelByDocumento(String documentoEmpresa);
}

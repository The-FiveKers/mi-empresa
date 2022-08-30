package com.miempresa.miEmpresa.repository;

import com.miempresa.miEmpresa.entities.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceEmpresa extends JpaRepository<EmpresaModel, Integer> {
}

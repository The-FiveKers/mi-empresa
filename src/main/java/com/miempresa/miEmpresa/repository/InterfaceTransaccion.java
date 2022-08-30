package com.miempresa.miEmpresa.repository;

import com.miempresa.miEmpresa.entities.TransaccionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceTransaccion extends JpaRepository<TransaccionModel, Integer> {
}

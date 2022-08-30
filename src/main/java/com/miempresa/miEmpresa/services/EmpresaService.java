package com.miempresa.miEmpresa.services;

import com.miempresa.miEmpresa.entities.EmpresaModel;
import com.miempresa.miEmpresa.repository.InterfaceEmpresa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmpresaService {

    private InterfaceEmpresa empresaRepository;

    public EmpresaService(InterfaceEmpresa rep){
        this.empresaRepository = rep;
    }

    public ArrayList<EmpresaModel> selectAll() {
        return (ArrayList<EmpresaModel>) this.empresaRepository.findAll();
    }

    public Response createEmpresa(EmpresaModel data){
        Response response = new Response();
        this.empresaRepository.save(data);
        response.setCode(200);
        response.setMessage("empresa registrada correctamente");
        return response;
    }
}

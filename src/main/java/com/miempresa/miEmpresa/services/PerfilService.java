package com.miempresa.miEmpresa.services;

import com.miempresa.miEmpresa.entities.PerfilModel;
import com.miempresa.miEmpresa.repository.InterfacePerfil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PerfilService {

    private InterfacePerfil perfilRepository;
    public PerfilService(InterfacePerfil rep){
        this.perfilRepository = rep;
    }

    public ArrayList<PerfilModel> selectAll(){
        return (ArrayList<PerfilModel>) this.perfilRepository.findAll();
    }

    public Response createPerfil(PerfilModel data){
        Response response = new Response();
        this.perfilRepository.save(data);
        response.setCode(200);
        response.setMessage("perfil registrado correctamente");
        return response;
    }
}

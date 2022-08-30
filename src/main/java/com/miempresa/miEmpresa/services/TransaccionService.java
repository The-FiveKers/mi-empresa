package com.miempresa.miEmpresa.services;

import com.miempresa.miEmpresa.entities.TransaccionModel;
import com.miempresa.miEmpresa.repository.InterfaceTransaccion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TransaccionService {

    private InterfaceTransaccion transaccionRepository;

    public TransaccionService(InterfaceTransaccion rep){
        this.transaccionRepository = rep;
    }

    public ArrayList<TransaccionModel> selectAll(){
        return (ArrayList<TransaccionModel>) this.transaccionRepository.findAll();
    }

    public Response createTransaccion(TransaccionModel data){
        Response response = new Response();
        this.transaccionRepository.save(data);
        response.setCode(200);
        response.setMessage("transaccion registrada correctamente");
        return response;
    }
}

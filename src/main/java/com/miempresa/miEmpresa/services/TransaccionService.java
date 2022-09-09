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
    //CODIGO DAVID
    // DELETE
    // Se crea metodo para eliminar una trasaccion. Dicho metodo recibe el parametro id y usa la funcion deletId para eliminar las transacciones del Id solicitado
    public Response deleteTransaccionById(int id){

        Response response = new Response();
        try{
            this.transaccionRepository.deleteById(id);
            response.setCode(200);
            response.setMessage("Trasaccion eliminada correctamente");
            return response;
        }
        // creamos una excepcion que nos retorna mensaje con error generado
        catch (Exception ex){
            response.setCode(500);
            response.setMessage("Error " + ex.getMessage());
            return response;
        }

    }
    // FIN CODIGO DAVID
}

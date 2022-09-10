package com.miempresa.miEmpresa.services;

import com.miempresa.miEmpresa.entities.TransaccionModel;
import com.miempresa.miEmpresa.repository.InterfaceTransaccion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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

    // CODIGO DANIEL
    public TransaccionModel selectById(int id){
        Optional<TransaccionModel> exists = this.transaccionRepository.findById(id);
        if (exists.isPresent()){
            return exists.get();
        }
        else{
            return null;
        }
    }

    // Actualizar transaccion
    public Response actualizarTransaccion(TransaccionModel data){
        Response response = new Response();
        if(data.getId() == 0){
            response.setCode(500);
            response.setMessage("Error, el Id de la transaccion no es valido" );
            return response;
        }
        // Validar si la transaccion existe
        TransaccionModel exists = selectById(data.getId());
        if(exists == null){
            response.setCode(500);
            response.setMessage("Error, la transaccion no existe en la base de datos");
            return response;
        }
        // Validar concepto
        if (data.getConcepto().equals(null) || data.getConcepto().equals("")){
            response.setCode(500);
            response.setMessage("Error, concepto no especificado");
            return response;
        }
        // Validar monto
        if (data.getMonto().equals(null) || data.getMonto().equals("")){
            response.setCode(500);
            response.setMessage("Error, concepto no especificado");
            return response;
        }
        // Validar fecha creado
        if (data.getCreado().equals(null) || data.getCreado().equals("")){
            response.setCode(500);
            response.setMessage("Error, concepto no especificado");
            return response;
        }
        // Validar fecha Actualizado
        if (data.getActualizado().equals(null) || data.getActualizado().equals("")){
            response.setCode(500);
            response.setMessage("Error, concepto no especificado");
            return response;
        }
        // Actualizar datos
        exists.setConcepto(data.getConcepto());
        exists.setMonto(data.getMonto());
        exists.setCreado(data.getCreado());
        exists.setActualizado(data.getActualizado());

        this.transaccionRepository.save(exists);
        response.setCode(200);
        response.setMessage("Usuario modificado crectamente");
        return response;
    }
}

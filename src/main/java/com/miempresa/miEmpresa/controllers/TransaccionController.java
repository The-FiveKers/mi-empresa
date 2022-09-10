package com.miempresa.miEmpresa.controllers;

import com.miempresa.miEmpresa.entities.EmpresaModel;
import com.miempresa.miEmpresa.entities.TransaccionModel;
import com.miempresa.miEmpresa.services.Response;
import com.miempresa.miEmpresa.services.TransaccionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
//@RequestMapping("enterprises/[id]/movements")
public class TransaccionController {

    private TransaccionService transaccionService;

    public TransaccionController(TransaccionService service){
        this.transaccionService = service;
    }

    @RequestMapping("gettransaccion")
    public ArrayList<TransaccionModel> getTransaccion(){
        return this.transaccionService.selectAll();
    }

    @PostMapping("createtransaccion")
    public Response createTransaccion(@RequestBody TransaccionModel request){
        return this.transaccionService.createTransaccion(request);
    }
    //creamos un controlador REST que recibe la peticion del cliente y llama el metodo creado en el servicio TransaccionService el cuel nos retorna un Response
    @DeleteMapping("deletetransaccion/{id}")
    public Response deleteTransaccion(@PathVariable int id){
        return this.transaccionService.deleteTransaccionById(id);
    }

    @PutMapping("actualizartransaccion/{id}")
    public Response updateTransaccion(@RequestBody TransaccionModel request) {
        return this.transaccionService.actualizarTransaccion(request);
    }

}

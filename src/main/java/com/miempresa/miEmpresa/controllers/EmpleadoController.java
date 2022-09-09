package com.miempresa.miEmpresa.controllers;


import com.miempresa.miEmpresa.entities.EmpleadoModel;
import com.miempresa.miEmpresa.services.EmpleadoService;
import com.miempresa.miEmpresa.services.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EmpleadoController {

    private EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService service){
        this.empleadoService = service;
    }

    @RequestMapping("getempleado")
    public ArrayList<EmpleadoModel> getEmpleado(){
        return this.empleadoService.selectAll();
    }

    @PostMapping("createempleado")
    public Response createEmpleado(@RequestBody EmpleadoModel request){
        return this.empleadoService.createEmpleado(request);
    }
    @DeleteMapping("delete/{id}")
    public Response deleteUsuario(@PathVariable int id){
        return this.empleadoService.deleteEmpleadoById(id);
    }
  }

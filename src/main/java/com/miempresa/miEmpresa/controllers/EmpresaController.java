package com.miempresa.miEmpresa.controllers;

import com.miempresa.miEmpresa.entities.EmpresaModel;
import com.miempresa.miEmpresa.services.EmpresaService;
import com.miempresa.miEmpresa.services.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class EmpresaController {

    private EmpresaService empresaService;

    public EmpresaController(EmpresaService service){
        this.empresaService = service;
    }

    @RequestMapping("getempresa")
    public ArrayList<EmpresaModel> getEmpresa(){
        return this.empresaService.selectAll();
    }

    @PostMapping("createempresa")
    public Response createEmpresa(@RequestBody EmpresaModel request){
        return this.empresaService.createEmpresa(request);
    }

}

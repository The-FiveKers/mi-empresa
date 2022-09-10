package com.miempresa.miEmpresa.services;

import com.miempresa.miEmpresa.controllers.EmpleadoController;
import com.miempresa.miEmpresa.entities.EmpleadoModel;
import com.miempresa.miEmpresa.repository.InterfaceEmpleado;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmpleadoService {

    private InterfaceEmpleado empleadoRepository;

    public EmpleadoService(InterfaceEmpleado rep) {
        this.empleadoRepository = rep;
    }

    public ArrayList<EmpleadoModel> selectAll() {
        return (ArrayList<EmpleadoModel>) this.empleadoRepository.findAll();
    }

    public Response createEmpleado(EmpleadoModel data) {
        Response response = new Response();
        this.empleadoRepository.save(data);
        response.setCode(200);
        response.setMessage("empleado registrado correctamente");
        return response;
    }

    public Response deleteEmpleadoById(int Id) {
        Response response = new Response();
        try {
            this.empleadoRepository.deleteById(Id);
            response.setCode(200);
            response.setMessage("Usuario eliminado exitosamente");
            return response;
        } catch (Exception ex) {
            response.setCode(500);
            response.setMessage("Error" + ex.getMessage());
            return response;
        }
    }

    public EmpleadoModel selectById(int id) {
        Optional<EmpleadoModel> exists = this.empleadoRepository.findById(id);
        if (exists.isPresent()) {
            return exists.get();
        } else {
            return null;
        }
    }

    //Actualizar empleado Daniel
    public Response actualizarEmpleado(EmpleadoModel data) {
        Response response = new Response();
        // validar id de empleado
        if (data.getId() == 0) {
            response.setCode(500);
            response.setMessage("Error, el Id del empleado no es valido");
            return response;
        }
        // Validar si el empleado existe
        EmpleadoModel exists = selectById(data.getId());
        if (exists == null) {
            response.setCode(500);
            response.setMessage("Error, el empleado no existe en la base de datos");
            return response;
        }
        // validar correo electronico
        if (data.getEmail().equals(null) || data.getEmail().equals("")) {
            response.setCode(500);
            response.setMessage("Error, Correo no especificado");
            return response;
        }
        // validar perfil
        if (data.getPerfil().equals(null) || data.getPerfil().equals("")) {
            response.setCode(500);
            response.setMessage("Error, Perfil no especificado");
            return response;
        }
        // validar rol
        if (data.getRole().equals(null) || data.getRole().equals("")) {
            response.setCode(500);
            response.setMessage("Error, Rol no especificado");
            return response;
        }
        // validar empresa
        /*if (data.getEmpresa().equals(null) || data.getEmpresa().equals("")){
            response.setCode(500);
            response.setMessage("Error, Empresa no especificada");
            return response;
        }*/
        // validar transacciones
        if (data.getTransaccion().equals(null) || data.getTransaccion().equals("")) {
            response.setCode(500);
            response.setMessage("Error, Rol no especificado");
            return response;
        }
        // validar fecha creado
        if (data.getCreado().equals(null) || data.getCreado().equals("")) {
            response.setCode(500);
            response.setMessage("Error, Rol no especificado");
            return response;
        }
        // validar fecha actualizado
        if (data.getActualizado().equals(null) || data.getActualizado().equals("")) {
            response.setCode(500);
            response.setMessage("Error, Rol no especificado");
            return response;
        }

        // Actualizar datos
        exists.setEmail(data.getEmail());
        exists.setPerfil(data.getPerfil());
        exists.setRole(data.getRole());
        /*exists.setRolName(data.getEmpresa());*/
        exists.setTransaccion(data.getTransaccion());
        exists.setCreado(data.getCreado());
        exists.setActualizado(data.getActualizado());

        this.empleadoRepository.save(exists);
        response.setCode(200);
        response.setMessage("Usuario modificado crectamente");
        return response;
    }


}

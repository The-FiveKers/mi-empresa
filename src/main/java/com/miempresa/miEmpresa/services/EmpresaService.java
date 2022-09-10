package com.miempresa.miEmpresa.services;

import com.miempresa.miEmpresa.entities.EmpleadoModel;
import com.miempresa.miEmpresa.entities.EmpresaModel;
import com.miempresa.miEmpresa.repository.InterfaceEmpresa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmpresaService {

    private InterfaceEmpresa empresaRepository;

    public EmpresaService(InterfaceEmpresa rep) {
        this.empresaRepository = rep;
    }

    public ArrayList<EmpresaModel> selectAll() {
        return (ArrayList<EmpresaModel>) this.empresaRepository.findAll();
    }

    public Response deleteEmpresaByID(int id) {
        Response response = new Response();
        try {
            Integer Id = null;
            this.empresaRepository.deleteById(Id);
            response.setCode(200);
            response.setMessage("empresa eliminada exitosamente");
            return response;
        } catch (Exception ex) {
            response.setCode(500);
            return response;
        }
    }
    // put empresa Daniel
    public EmpresaModel selectById(int id) {
        Optional<EmpresaModel> exists = this.empresaRepository.findById(id);
        if (exists.isPresent()) {
            return exists.get();
        } else {
            return null;
        }
    }

    // Crear una empresa
    public Response createEmpresa(EmpresaModel data){
        Response response = new Response();
        // Validar nombre
        ArrayList<EmpresaModel> existsNombre = this.empresaRepository.getEmpresaModelByNombre(data.getNombre());
        if(existsNombre != null && existsNombre.size() > 0){
            response.setCode(500);
            response.setMessage("Nombre de empresa ya esta registrado");
            return response;
        }
        // Validar documento
        ArrayList<EmpresaModel> existsDocumento = this.empresaRepository.getEmpresaModelByDocumento(data.getDocumento());
        if(existsDocumento != null && existsDocumento.size() > 0){
            response.setCode(500);
            response.setMessage("Nombre de empresa ya esta registrado");
            return response;
        }
        this.empresaRepository.save(data);
        response.setCode(200);
        response.setMessage("empresa registrada correctamente");
        return response;
    }

    // Eliminar una empresa
    public Response deleteEmpresaById(int id){
        Response response = new Response();
        try{
            this.empresaRepository.deleteById(id);
            response.setCode(200);
            response.setMessage("usuario eliminado correctamente");
            return response;
        }
        catch (Exception ex){
            response.setCode(500);
            response.setMessage("Error " + ex.getMessage());
            return response;
        }
    }

    // Actualizar empresa
    public Response actualizarEmpresa (EmpresaModel data){
        Response response = new Response();
        if(data.getId() == 0){
            response.setCode(500);
            response.setMessage("Error, el Id de la Empresa no es valido" );
            return response;
        }
        // Validar si la empresa existe
        EmpresaModel exists = selectById(data.getId());
        if(exists == null){
            response.setCode(500);
            response.setMessage("Error, la empresa no existe en la base de datos");
            return response;
        }
        // Validar nombre de empresa
        if (data.getNombre().equals(null) || data.getNombre().equals("")){
            response.setCode(500);
            response.setMessage("Error, nombre de empresa no especificado");
            return response;
        }

        // Validar documento de empresa
        if (data.getDocumento().equals(null) || data.getDocumento().equals("")){
            response.setCode(500);
            response.setMessage("Error, documento de empresa no especificado");
            return response;
        }

        // Validar telefono de empresa
        if (data.getTelefono().equals(null) || data.getTelefono().equals("")){
            response.setCode(500);
            response.setMessage("Error, telefono de empresa no especificado");
            return response;
        }

        // Validar direccion de empresa
        if (data.getDireccion().equals(null) || data.getDireccion().equals("")){
            response.setCode(500);
            response.setMessage("Error, telefono de empresa no especificado");
            return response;
        }

        // Validar transacciones de empresa
        if (data.getTransacciones().equals(null) || data.getTransacciones().equals("")){
            response.setCode(500);
            response.setMessage("Error, telefono de empresa no especificado");
            return response;
        }

        // Validar fecha creado
        if (data.getCreado().equals(null) || data.getCreado().equals("")){
            response.setCode(500);
            response.setMessage("Error, telefono de empresa no especificado");
            return response;
        }

        // Validar fecha modificado
        if (data.getModificado().equals(null) || data.getModificado().equals("")){
            response.setCode(500);
            response.setMessage("Error, telefono de empresa no especificado");
            return response;
        }

        // Actualizar datos
        exists.setNombre(data.getNombre());
        exists.setDocumento(data.getDocumento());
        exists.setTelefono(data.getTelefono());
        exists.setDireccion(data.getDireccion());
        exists.setTransacciones(data.getTransacciones());
        exists.setCreado(data.getCreado());
        exists.setModificado(data.getModificado());

        this.empresaRepository.save(exists);
        response.setCode(200);
        response.setMessage("Empresa modificada crectamente");
        return response;

    }
}

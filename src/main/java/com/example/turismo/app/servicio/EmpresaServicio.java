package com.example.turismo.app.servicio;
//SERVICIOS/LOGICA NEGOCIOS(VALIDACIONES)/IMPLEMENTA/LLAMA A LOS REPOSITORIOS
//POR CADA SERVICIO QUE YO QUIERA

import com.example.turismo.app.modelos.Empresa;
import com.example.turismo.app.repositorio.EmpresaRepositorio;
import com.example.turismo.app.validaciones.EmpresaValidacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//SERVICIO este DTO coge los datos de la entidad y no devuelve
@Service//ANTOACION PARA DECIRLE QUE ESTO ES UN SERVICIO
public class EmpresaServicio {

    //CON ESTA ANOTACCION LLAMO A OTRAS CLASES PARA PODER USAR SUS METODOS(YO TE ARRIENDO MI PIEZA Y SI ES AIS TU M EHACES LA COMIDA)
    @Autowired
    EmpresaRepositorio empresaRepositorio;
    @Autowired
    EmpresaValidacion empresaValidacion;
    public Empresa registrarEmpresa (Empresa datosRegistrar)throws Exception{ //el nombre aca siempre debe ir en infinitivo ar er ir
        //validacciones

        //TRY Y CATCH SON LOS CAPATACES SE ENCARGAN DE VER QUE ESTA PASANDO EN EL SISTEMA
        try {
            if(!this.empresaValidacion.validarNombre(datosRegistrar.getNombre())){
                throw new Exception("error en el servicio");
            }//despues de todos los if estoy listo para llamar a repositorio
            return(this.empresaRepositorio.save(datosRegistrar));

            //Falta validar el NIT

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Empresa modificarEmpresa(Integer id,Empresa datosModificar)throws Exception{
        try {

            //validamos la informacion
            if (this.empresaValidacion.validarNombre(datosModificar.getNombre())){

            }
            //buscar que la empresa que tiene el id que envia el usuario exista en bd
            Optional<Empresa> empresaEncontrada=this.empresaRepositorio.findById(id);
            //pregunto si lo que busque esta vacio (que no existe)
            if(empresaEncontrada.isEmpty()){
                throw new Exception("empresa no encontrada");
            }
            //rutina por si si la encontre

            //convierto el opcional en la entidad respectiva ------------------1
            Empresa empresaExiste=empresaEncontrada.get();

            //a la empresa que existe le cambio la informacion que el usuario necesite ----------------2
            empresaExiste.setNombre(datosModificar.getNombre());

            //guardar la informacion que se acaba de editar con el (SET)----------------------------------------3
            return (this.empresaRepositorio.save(empresaExiste));


        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public Empresa consultarEmpresaId(Integer id)throws Exception{
try {
    Optional<Empresa> empresaOptional=this.empresaRepositorio.findById(id);
    if(empresaOptional.isEmpty()){
        throw new Exception("empresa no encontrada");
    }

    return empresaOptional.get();

}catch (Exception error){
    throw new Exception(error.getMessage());
}
    }

    public List<Empresa> consultarEmpresaTodas()throws Exception{
        try {
            List<Empresa>listaEmpresa=this.empresaRepositorio.findAll();
            return listaEmpresa;

    }catch (Exception error){
        throw new Exception(error.getMessage());
    }
        }

    public Boolean EliminarEmpresa(Integer id)throws Exception{
        try {
            Optional<Empresa>empresaOptional=this.empresaRepositorio.findById(id);

            if (empresaOptional.isPresent()){
                this.empresaRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("empresa no encontrada");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}

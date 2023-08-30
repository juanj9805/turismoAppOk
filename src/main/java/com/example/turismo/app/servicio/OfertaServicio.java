package com.example.turismo.app.servicio;

import com.example.turismo.app.modelos.Empresa;
import com.example.turismo.app.modelos.Oferta;
import com.example.turismo.app.repositorio.EmpresaRepositorio;
import com.example.turismo.app.repositorio.OfertaRepositorio;
import com.example.turismo.app.validaciones.OfertaValidacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfertaServicio {

    @Autowired //inyectando una dependencia aca le digo a una clase que puede usar el objeto de otra (desde una clase uso a otra)
    OfertaRepositorio ofertaRepositorio;
    @Autowired
    OfertaValidacion ofertaValidacion;
    public Oferta registrarOferta (Oferta datosRegistrar)throws Exception{
        try {
            //despues de todos los if estoy listo para llamar a repositorio
            return(this.ofertaRepositorio.save(datosRegistrar));

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public Oferta modificarOferta(Integer id,Oferta datosModificar)throws Exception{
        try {

            if (this.ofertaValidacion.validarNombre(datosModificar.getTitulo())){

            }
            if(this.ofertaValidacion.validarDescripcion(datosModificar.getDescripcion())){

            }
            Optional<Oferta> ofertaEncontrada=this.ofertaRepositorio.findById(id);
            if(ofertaEncontrada.isEmpty()){
                throw new Exception("oferta no encontrada");
            }

            Oferta ofertaExiste=ofertaEncontrada.get();

            ofertaExiste.setTitulo(datosModificar.getTitulo());
            ofertaExiste.setDescripcion(datosModificar.getDescripcion());

            return (this.ofertaRepositorio.save(ofertaExiste));


        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }


    public Oferta consultarOfertaId(Integer id)throws Exception{
        try {
            Optional<Oferta> ofertaOptional=this.ofertaRepositorio.findById(id);
            if(ofertaOptional.isEmpty()){
                throw new Exception("oferta no encontrada");
            }

            return ofertaOptional.get();

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Oferta> consultarOfertaTodas()throws Exception{
        try {
            List<Oferta>listaOferta=this.ofertaRepositorio.findAll();
            return listaOferta;

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }    }

    public Boolean EliminarOferta(Integer id)throws Exception{
        try {
            Optional<Oferta>ofertaOptional=this.ofertaRepositorio.findById(id);

            if (ofertaOptional.isPresent()){
                this.ofertaRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("oferta no encontrada");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


}

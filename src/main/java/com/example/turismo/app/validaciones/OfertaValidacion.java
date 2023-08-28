package com.example.turismo.app.validaciones;

import org.springframework.stereotype.Component;

@Component
public class OfertaValidacion {

    public Boolean validarNombre(String nombre)throws Exception {
        if (nombre.length() > 30) {
            throw new Exception("longitud de caracteres invalido");
        } else {
            return true;
        }
    }

        public Boolean validarDescripcion(String descripcion)throws Exception{
            if(descripcion.length()>50){
                throw new Exception("longitud de caracteres invalido");
            }else{
                return true;
            }


    }

}

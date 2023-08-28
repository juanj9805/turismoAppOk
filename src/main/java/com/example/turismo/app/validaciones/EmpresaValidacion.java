package com.example.turismo.app.validaciones;

import org.springframework.stereotype.Component;

@Component //con esta notacion le digo al programa que este paquete me lo convierta en una capa
public class EmpresaValidacion {

    public Boolean validarNombre(String nombre)throws Exception{
        if(nombre.length()>30){
            throw new Exception("longitud de caracteres invalido");
        }else{
            return true;
        }




    }

}

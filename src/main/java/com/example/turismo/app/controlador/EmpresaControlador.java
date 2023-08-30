package com.example.turismo.app.controlador;

import com.example.turismo.app.modelos.Empresa;
import com.example.turismo.app.servicio.EmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//EN LOS ENDPOINT SUELEN SER LOS ID DE LO QUE ESTMOAS VIENDO ----------------------- EJ ESTE ES UN DATO DE CABECERA YA QUE VA POR FUERA
//LOS END POINT SON LOS NOMBRES QUE LE VAMOS A DAR A NUESTROS SERVICIOS
//EJEMPLO1: NETFLIX.COM/SERIES
//EJEMPLO2: NETFLIX.COM/PELICULAS

@RestController //REST REGLAS
@RequestMapping("/empresas") //
public class EmpresaControlador {
    @Autowired//INYECTAR
    EmpresaServicio empresaServicio;
    //POR CADA METODO QUE TENGA EN SERVICIO TENGO QUE HACER UN CONTROLADOR

    @PostMapping //CON ESTA ANOTACION DECIMOS QUE VAMOS A RECIBIR UNA PETICION DE TIPO POST
    public ResponseEntity<?> registrarEmpresa(@RequestBody Empresa datosEmpresa){//REQUESTBODY CON ESTA ANOTACION (INFO ADENTRO DATA AFUERA)
        //<?> PARAMETROS con ? decimos que aca te puede devolver cualquier cosa(mala practica)
        return null;
    }

    @PutMapping
     public ResponseEntity<?> editarEmpresa(@RequestBody Empresa datosNUevosEmpresa, @PathVariable Integer idEmpresa ){//EN LOS () VA LA INFORMACION QUE NOS MANDA EL CLIENTE
        //PATH ES RUTA -------------
        return null;
     }

     @GetMapping
     public ResponseEntity<?> buscarEmpresa(@PathVariable Integer idEmpresa){
        return null;
     }

     @GetMapping
     public ResponseEntity<?> buscarTodasEmpresa(){
        return null;
     }

     @DeleteMapping
     public ResponseEntity<?> eliminarEmpresa(@PathVariable Integer idEmpresa){
        return null;
     }





}

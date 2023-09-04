package com.example.turismo.app.controlador;

import com.example.turismo.app.modelos.Empresa;
import com.example.turismo.app.servicio.EmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.empresaServicio.registrarEmpresa(datosEmpresa));

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }

    }

    @PutMapping("{idEmpresa}") //cuando algo se manda en el header se le abre parentesis y se pone esa variable (pathvariable)
     public ResponseEntity<?> editarEmpresa(@RequestBody Empresa datosNUevosEmpresa, @PathVariable Integer idEmpresa ){//EN LOS () VA LA INFORMACION QUE NOS MANDA EL CLIENTE
        //PATH ES RUTA -------------
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.empresaServicio.modificarEmpresa(idEmpresa,datosNUevosEmpresa));

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
     }

     @GetMapping("{idEmpresa}")
     public ResponseEntity<?> buscarEmpresa(@PathVariable Integer idEmpresa){
         try{
             return ResponseEntity
                     .status(HttpStatus.OK)
                     .body(this.empresaServicio.consultarEmpresaId(idEmpresa));

         }catch(Exception error){
             return ResponseEntity
                     .status(HttpStatus.BAD_REQUEST)
                     .body(error.getMessage());

         }     }

     @GetMapping
     public ResponseEntity<?> buscarTodasEmpresa(){
         try{
             return ResponseEntity
                     .status(HttpStatus.OK)
                     .body(this.empresaServicio.consultarEmpresaTodas());

         }catch(Exception error){
             return ResponseEntity
                     .status(HttpStatus.BAD_REQUEST)
                     .body(error.getMessage());

         }
     }

     @DeleteMapping ("{idEmpresa}")
     public ResponseEntity<?> eliminarEmpresa(@PathVariable Integer idEmpresa){
         try{
             return ResponseEntity
                     .status(HttpStatus.OK)
                     .body(this.empresaServicio.EliminarEmpresa(idEmpresa));

         }catch(Exception error){
             return ResponseEntity
                     .status(HttpStatus.BAD_REQUEST)
                     .body(error.getMessage());

         }
     }


}

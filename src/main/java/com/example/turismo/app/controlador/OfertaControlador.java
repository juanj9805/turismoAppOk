package com.example.turismo.app.controlador;

import com.example.turismo.app.modelos.Oferta;
import com.example.turismo.app.servicio.OfertaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/oferta")
public class OfertaControlador {
    @Autowired
    OfertaServicio ofertaServicio;

    @PostMapping
    public ResponseEntity<?>registrarOferta(@RequestBody Oferta datosOferta){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.ofertaServicio.registrarOferta(datosOferta));

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }    }

    @PutMapping("{idOferta}")
    public  ResponseEntity<?> editarOferta(@RequestBody Oferta datosNuevosOferta,@PathVariable Integer idOferta){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.ofertaServicio.modificarOferta(idOferta,datosNuevosOferta));

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }    }

    @GetMapping("{idOferta}")
    public ResponseEntity<?> buscarOferta(@PathVariable Integer idOferta){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.ofertaServicio.consultarOfertaId(idOferta));

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }    }

    @GetMapping
    public ResponseEntity<?> buscarOfertas(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.ofertaServicio.consultarOfertaTodas());

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }    }

    @DeleteMapping ("{idOferta}")
    public ResponseEntity<?> borrarOferta(@PathVariable Integer idOferta){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.ofertaServicio.EliminarOferta(idOferta));

        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }

}

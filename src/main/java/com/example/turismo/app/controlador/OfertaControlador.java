package com.example.turismo.app.controlador;

import com.example.turismo.app.modelos.Oferta;
import com.example.turismo.app.servicio.OfertaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class OfertaControlador {
    @Autowired
    OfertaServicio ofertaServicio;

    @PostMapping
    public ResponseEntity<?>registrarEmpresa(@RequestBody Oferta datosOferta,@PathVariable Integer idOferta){
        return null;
    }

    @PutMapping
    public  ResponseEntity<?> editarOferta(@RequestBody Oferta datosNuevosOferta,@PathVariable Integer idOferta){
        return null;
    }

    @GetMapping
    public ResponseEntity<?> buscarOferta(@PathVariable Integer idOferta){
        return null;
    }

    @GetMapping
    public ResponseEntity<?> buscarOfertas(){
        return null;
    }

    @DeleteMapping
    public ResponseEntity<?> borrarOferta(@PathVariable Integer idOferta){
        return null;
    }

}

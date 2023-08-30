package com.example.turismo.app.repositorio;
//UNA INTERFAZ ES UNA CLASE QUE NO IMPLEMENTA LOGICA NI METODOS, NI ATRIBUTOS ELLA SOLO LISTA COSAS
//RE´POSITORIOS/CONSULTAS BD/ORM/JPA

import com.example.turismo.app.modelos.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//REPOSITORIO


//ORM/JPA
@Repository //con esta anotacion le decimos a esta clase que es un conjunto de consultas pre programadas
public interface EmpresaRepositorio extends JpaRepository<Empresa,Integer> {
}

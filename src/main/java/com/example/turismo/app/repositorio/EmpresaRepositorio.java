package com.example.turismo.app.repositorio;

import com.example.turismo.app.modelos.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//REPOSITORIO

@Repository //con esta anotacion le decimos a esta clase que es un conjunto de consultas pre programadas
public interface EmpresaRepositorio extends JpaRepository<Empresa,Integer> {
}

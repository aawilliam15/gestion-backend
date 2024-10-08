package com.gestion.reclamo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.reclamo.modelo.Empresa;


@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa, Long> {

}

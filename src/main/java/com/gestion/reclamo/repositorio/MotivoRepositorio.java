package com.gestion.reclamo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.reclamo.modelo.Motivo;

@Repository
public interface MotivoRepositorio extends JpaRepository<Motivo, Long> {

}

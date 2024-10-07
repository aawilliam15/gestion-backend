package com.gestion.reclamo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.reclamo.modelo.Reclamo;

@Repository
public interface ReclamoRepositorio extends JpaRepository<Reclamo, Long> {

}

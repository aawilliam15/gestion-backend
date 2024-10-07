package com.gestion.reclamo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.reclamo.modelo.User;

@Repository
public interface UsuarioRepositorio  extends JpaRepository<User, Long>{

}

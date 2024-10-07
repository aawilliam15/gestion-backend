package com.gestion.reclamo.controlador;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.reclamo.modelo.User;

import com.gestion.reclamo.servicio.UsuarioServicio;


@RestController
@RequestMapping("/api/v1/")

public class UserController {

	@Autowired
	private UsuarioServicio servicio;

	@PostMapping("/login")

	public User login(@RequestBody User user ) {

		return servicio.login(user.getUser(), user.getPwd());

	}

}

package com.gestion.reclamo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.reclamo.mensaje.ReclamoMotivoDTO;
import com.gestion.reclamo.modelo.Motivo;
import com.gestion.reclamo.modelo.Reclamo;

import com.gestion.reclamo.servicio.ReclamoServicio;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class ReclamoController {

	@Autowired
	private ReclamoServicio servicio;
	
	@GetMapping("/reclamos")
	public List<ReclamoMotivoDTO> listarReclamos()
	{
		return servicio.getAllReclamos();
		
	}
	
	@GetMapping("/motivos")
	public List<Motivo> listarMotivos()
	{
		return servicio.getAllMotivo();
		
	}
	
	@PostMapping("/registro")
	public Boolean RegistroReclamo(Reclamo reclamo)
	{
		return servicio.RegistroReclamo(reclamo);
		
	}
	
	@PutMapping("/registro")
	public Boolean ActualizaReclamo(Reclamo reclamo)
	{
		return servicio.RegistroReclamo(reclamo);
		
	}
	
}

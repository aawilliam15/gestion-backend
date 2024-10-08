package com.gestion.reclamo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.reclamo.mensaje.ReclamoMotivoDTO;
import com.gestion.reclamo.modelo.Empresa;
import com.gestion.reclamo.modelo.Motivo;
import com.gestion.reclamo.modelo.Reclamo;

import com.gestion.reclamo.servicio.ReclamoServicio;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*")
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
	
	@GetMapping("/empresa")
	public List<Empresa> listarEmpresas()
	{
		return servicio.getAllEmpresa();
		
	}
	
	@PostMapping("/registro")
	public Boolean RegistroReclamo(@RequestBody Reclamo reclamo)
	{
		return servicio.RegistroReclamo(reclamo);
		
	}	
	
	@PostMapping("/registro/{id}/{status}")
	public Boolean ActualizaEstado(@PathVariable Long id,@PathVariable String status)
	{
		return servicio.ActualizaEstado(id,status);
		
	}
	
}
